// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.core.management.implementation.polling;

import com.azure.core.annotation.Host;
import com.azure.core.annotation.Put;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.management.Resource;
import com.azure.core.management.polling.PollResult;
import com.azure.core.management.polling.PollerFactory;
import com.azure.core.management.polling.SyncPollerFactory;
import com.azure.core.management.serializer.SerializerFactory;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import com.azure.core.util.polling.AsyncPollResponse;
import com.azure.core.util.polling.LongRunningOperationStatus;
import com.azure.core.util.polling.PollResponse;
import com.azure.core.util.polling.PollerFlux;
import com.azure.core.util.polling.SyncPoller;
import com.azure.core.util.serializer.SerializerAdapter;
import com.azure.core.util.serializer.SerializerEncoding;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseTransformer;
import com.github.tomakehurst.wiremock.http.HttpHeader;
import com.github.tomakehurst.wiremock.http.HttpHeaders;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.RequestMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import wiremock.com.google.common.util.concurrent.SimpleTimeLimiter;
import wiremock.com.google.common.util.concurrent.TimeLimiter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("unchecked")
public class LROPollerTests {
    private static final ClientLogger LOGGER = new ClientLogger(LROPollerTests.class);

    private static final SerializerAdapter SERIALIZER = SerializerFactory.createDefaultManagementSerializerAdapter();

    private static final Duration POLLING_DURATION = Duration.ofMillis(100);

    @Host("http://localhost")
    @ServiceInterface(name = "ProvisioningStateLroService")
    interface ProvisioningStateLroServiceClient {
        @Put("/resource/1")
        Mono<Response<Flux<ByteBuffer>>> startLro(Context context);

        @Put("/resource/1")
        Response<BinaryData> startLroSync(Context context);
    }

    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    public void lroBasedOnProvisioningState(boolean syncStack) {
        WireMockServer lroServer = startServer();

        try {
            final ProvisioningStateLroServiceClient client = RestProxy.create(ProvisioningStateLroServiceClient.class,
                createHttpPipeline(lroServer.port()), SERIALIZER);
            if (syncStack) {
                SyncPoller<PollResult<FooWithProvisioningState>, FooWithProvisioningState> syncPoller
                    = SyncPollerFactory.create(SERIALIZER, new HttpPipelineBuilder().build(),
                        FooWithProvisioningState.class, FooWithProvisioningState.class, POLLING_DURATION,
                        () -> newLroInitResponse(client));

                for (int i = 0; i < 2; i++) {
                    PollResponse<PollResult<FooWithProvisioningState>> pollResponse = syncPoller.poll();
                    PollResult<FooWithProvisioningState> pollResult = pollResponse.getValue();
                    Assertions.assertNotNull(pollResult);
                    Assertions.assertNotNull(pollResult.getValue());
                    if (i == 0) {
                        Assertions.assertEquals(LongRunningOperationStatus.IN_PROGRESS, pollResponse.getStatus());
                        Assertions.assertNull(pollResult.getValue().getResourceId());
                    } else {
                        Assertions.assertEquals(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                            pollResponse.getStatus());
                        Assertions.assertNotNull(pollResult.getValue().getResourceId());
                    }
                }
            } else {
                PollerFlux<PollResult<FooWithProvisioningState>, FooWithProvisioningState> lroFlux = PollerFactory
                    .create(SERIALIZER, new HttpPipelineBuilder().build(), FooWithProvisioningState.class,
                        FooWithProvisioningState.class, POLLING_DURATION, newLroInitFunction(client));

                int[] onNextCallCount = new int[1];
                lroFlux.doOnNext(response -> {
                    PollResult<FooWithProvisioningState> pollResult = response.getValue();
                    Assertions.assertNotNull(pollResult);
                    Assertions.assertNotNull(pollResult.getValue());
                    onNextCallCount[0]++;
                    if (onNextCallCount[0] == 1) {
                        Assertions.assertEquals(LongRunningOperationStatus.IN_PROGRESS, response.getStatus());
                        Assertions.assertNull(pollResult.getValue().getResourceId());
                    } else if (onNextCallCount[0] == 2) {
                        Assertions.assertEquals(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                            response.getStatus());
                        Assertions.assertNotNull(pollResult.getValue().getResourceId());
                    } else {
                        throw new IllegalStateException("Poller emitted more than expected value.");
                    }
                }).blockLast();
            }
        } finally {
            if (lroServer.isRunning()) {
                lroServer.shutdown();
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    public void lroBasedOnAsyncOperation(boolean syncStack) {
        ServerConfigure serverConfigure = new ServerConfigure();

        final String resourceEndpoint = "/resource/1";
        final String operationEndpoint = "/operations/1";
        ResponseTransformer provisioningStateLroService = new ResponseTransformer() {
            private final int[] getCallCount = new int[1];

            @Override
            public com.github.tomakehurst.wiremock.http.Response transform(Request request,
                com.github.tomakehurst.wiremock.http.Response response, FileSource fileSource, Parameters parameters) {

                if (!request.getUrl().endsWith(resourceEndpoint) && !request.getUrl().endsWith(operationEndpoint)) {
                    return new com.github.tomakehurst.wiremock.http.Response.Builder().status(500)
                        .body("Unsupported path:" + request.getUrl())
                        .build();
                }
                if (request.getMethod().isOneOf(RequestMethod.PUT)) {
                    // accept response
                    return new com.github.tomakehurst.wiremock.http.Response.Builder()
                        .headers(new HttpHeaders(new HttpHeader("Azure-AsyncOperation",
                            request.getAbsoluteUrl().replace(resourceEndpoint, operationEndpoint))))
                        .body(toJson(new FooWithProvisioningState("Creating")))
                        .status(201)
                        .build();
                }
                if (request.getMethod().isOneOf(RequestMethod.GET)) {
                    if (request.getUrl().endsWith(operationEndpoint)) {
                        getCallCount[0]++;
                        if (getCallCount[0] < serverConfigure.pollingCountTillSuccess) {
                            return new com.github.tomakehurst.wiremock.http.Response.Builder()
                                .body("{\"status\": \"InProgress\"}")
                                .build();
                        } else if (getCallCount[0] == serverConfigure.pollingCountTillSuccess) {
                            return new com.github.tomakehurst.wiremock.http.Response.Builder()
                                .body("{\"status\": \"Succeeded\"}")
                                .build();
                        }
                    } else if (request.getUrl().endsWith(resourceEndpoint)
                        && getCallCount[0] == serverConfigure.pollingCountTillSuccess) {
                        // final resource
                        return new com.github.tomakehurst.wiremock.http.Response.Builder()
                            .body(toJson(new FooWithProvisioningState("Succeeded", UUID.randomUUID().toString())))
                            .build();
                    } else {
                        return new com.github.tomakehurst.wiremock.http.Response.Builder().status(400)
                            .body("Invalid state:" + request.getUrl())
                            .build();
                    }
                }
                return response;
            }

            @Override
            public String getName() {
                return "LroService";
            }
        };

        WireMockServer lroServer = createServer(provisioningStateLroService, resourceEndpoint, operationEndpoint);
        lroServer.start();

        try {
            final ProvisioningStateLroServiceClient client = RestProxy.create(ProvisioningStateLroServiceClient.class,
                createHttpPipeline(lroServer.port()), SERIALIZER);
            if (syncStack) {
                SyncPoller<PollResult<FooWithProvisioningState>, FooWithProvisioningState> lroPoller = SyncPollerFactory
                    .create(SERIALIZER, new HttpPipelineBuilder().build(), FooWithProvisioningState.class,
                        FooWithProvisioningState.class, POLLING_DURATION, () -> newLroInitResponse(client));

                for (int i = 0; i < 2; i++) {
                    PollResponse<PollResult<FooWithProvisioningState>> pollResponse = lroPoller.poll();
                    PollResult<FooWithProvisioningState> pollResult = pollResponse.getValue();
                    Assertions.assertNotNull(pollResult);
                    Assertions.assertNotNull(pollResult.getValue());
                    if (i == 0) {
                        Assertions.assertEquals(LongRunningOperationStatus.IN_PROGRESS, pollResponse.getStatus());
                    } else {
                        Assertions.assertEquals(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                            pollResponse.getStatus());
                    }
                }

                FooWithProvisioningState foo = lroPoller.getFinalResult();
                Assertions.assertNotNull(foo.getResourceId());
                Assertions.assertEquals("Succeeded", foo.getProvisioningState());
            } else {
                PollerFlux<PollResult<FooWithProvisioningState>, FooWithProvisioningState> lroFlux = PollerFactory
                    .create(SERIALIZER, new HttpPipelineBuilder().build(), FooWithProvisioningState.class,
                        FooWithProvisioningState.class, POLLING_DURATION, newLroInitFunction(client));

                int[] onNextCallCount = new int[1];
                AsyncPollResponse<PollResult<FooWithProvisioningState>, FooWithProvisioningState> pollResponse
                    = lroFlux.doOnNext(response -> {
                        PollResult<FooWithProvisioningState> pollResult = response.getValue();
                        Assertions.assertNotNull(pollResult);
                        Assertions.assertNotNull(pollResult.getValue());
                        onNextCallCount[0]++;
                        if (onNextCallCount[0] == 1) {
                            Assertions.assertEquals(LongRunningOperationStatus.IN_PROGRESS, response.getStatus());
                        } else if (onNextCallCount[0] == 2) {
                            Assertions.assertEquals(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                                response.getStatus());
                        } else {
                            throw new IllegalStateException("Poller emitted more than expected value.");
                        }
                    }).blockLast();

                FooWithProvisioningState foo = pollResponse.getFinalResult().block();
                Assertions.assertNotNull(foo.getResourceId());
                Assertions.assertEquals("Succeeded", foo.getProvisioningState());
            }
        } finally {
            if (lroServer.isRunning()) {
                lroServer.shutdown();
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    public void lroBasedOnAsyncOperationFailed(boolean syncStack) {
        ServerConfigure serverConfigure = new ServerConfigure();

        final String resourceEndpoint = "/resource/1";
        final String operationEndpoint = "/operations/1";
        ResponseTransformer provisioningStateLroService = new ResponseTransformer() {
            private final int[] getCallCount = new int[1];

            @Override
            public com.github.tomakehurst.wiremock.http.Response transform(Request request,
                com.github.tomakehurst.wiremock.http.Response response, FileSource fileSource, Parameters parameters) {

                if (!request.getUrl().endsWith(resourceEndpoint) && !request.getUrl().endsWith(operationEndpoint)) {
                    return new com.github.tomakehurst.wiremock.http.Response.Builder().status(500)
                        .body("Unsupported path:" + request.getUrl())
                        .build();
                }
                if (request.getMethod().isOneOf(RequestMethod.PUT)) {
                    // accept response
                    return new com.github.tomakehurst.wiremock.http.Response.Builder()
                        .headers(new HttpHeaders(new HttpHeader("Azure-AsyncOperation",
                            request.getAbsoluteUrl().replace(resourceEndpoint, operationEndpoint))))
                        .body(toJson(new FooWithProvisioningState("Creating")))
                        .status(201)
                        .build();
                }
                if (request.getMethod().isOneOf(RequestMethod.GET)) {
                    if (request.getUrl().endsWith(operationEndpoint)) {
                        getCallCount[0]++;
                        if (getCallCount[0] < serverConfigure.pollingCountTillSuccess) {
                            return new com.github.tomakehurst.wiremock.http.Response.Builder()
                                .body("{\"status\": \"InProgress\"}")
                                .build();
                        } else if (getCallCount[0] == serverConfigure.pollingCountTillSuccess) {
                            return new com.github.tomakehurst.wiremock.http.Response.Builder()
                                .headers(
                                    new HttpHeaders(new HttpHeader("x-ms-request-id", UUID.randomUUID().toString())))
                                .body("{\"status\": \"Failed\"}")
                                .build();
                        }
                    } else {
                        return new com.github.tomakehurst.wiremock.http.Response.Builder().status(400)
                            .body("Invalid state:" + request.getUrl())
                            .build();
                    }
                }
                return response;
            }

            @Override
            public String getName() {
                return "LroService";
            }
        };

        WireMockServer lroServer = createServer(provisioningStateLroService, resourceEndpoint, operationEndpoint);
        lroServer.start();

        try {
            final ProvisioningStateLroServiceClient client = RestProxy.create(ProvisioningStateLroServiceClient.class,
                createHttpPipeline(lroServer.port()), SERIALIZER);

            if (syncStack) {
                SyncPoller<PollResult<FooWithProvisioningState>, FooWithProvisioningState> lroPoller = SyncPollerFactory
                    .create(SERIALIZER, new HttpPipelineBuilder().build(), FooWithProvisioningState.class,
                        FooWithProvisioningState.class, POLLING_DURATION, () -> newLroInitResponse(client));

                for (int i = 0; i < 2; i++) {
                    PollResponse<PollResult<FooWithProvisioningState>> pollResponse = lroPoller.poll();
                    PollResult<FooWithProvisioningState> pollResult = pollResponse.getValue();
                    Assertions.assertNotNull(pollResult);
                    if (i == 0) {
                        Assertions.assertEquals(LongRunningOperationStatus.IN_PROGRESS, pollResponse.getStatus());
                        Assertions.assertNotNull(pollResult.getValue());
                    } else {
                        Assertions.assertEquals(LongRunningOperationStatus.FAILED, pollResponse.getStatus());
                        Assertions.assertNotNull(pollResult.getError());
                    }
                }
            } else {
                PollerFlux<PollResult<FooWithProvisioningState>, FooWithProvisioningState> lroFlux = PollerFactory
                    .create(SERIALIZER, new HttpPipelineBuilder().build(), FooWithProvisioningState.class,
                        FooWithProvisioningState.class, POLLING_DURATION, newLroInitFunction(client));

                int[] onNextCallCount = new int[1];
                AsyncPollResponse<PollResult<FooWithProvisioningState>, FooWithProvisioningState> pollResponse
                    = lroFlux.doOnNext(response -> {
                        PollResult<FooWithProvisioningState> pollResult = response.getValue();
                        Assertions.assertNotNull(pollResult);
                        onNextCallCount[0]++;
                        if (onNextCallCount[0] == 1) {
                            Assertions.assertNotNull(pollResult.getValue());
                            Assertions.assertEquals(LongRunningOperationStatus.IN_PROGRESS, response.getStatus());
                        } else if (onNextCallCount[0] == 2) {
                            Assertions.assertEquals(LongRunningOperationStatus.FAILED, response.getStatus());
                            Assertions.assertEquals(200, response.getValue().getError().getResponseStatusCode());
                            Assertions.assertNotNull(response.getValue().getError());
                        } else {
                            throw new IllegalStateException("Poller emitted more than expected value.");
                        }
                    }).blockLast();

                Assertions.assertEquals(LongRunningOperationStatus.FAILED, pollResponse.getStatus());
            }
        } finally {
            if (lroServer.isRunning()) {
                lroServer.shutdown();
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    public void lro200SucceededNoPoll(boolean syncStack) {
        final String resourceEndpoint = "/resource/1";
        final String sampleVaultUpdateSucceededResponse
            = "{\"id\":\"/subscriptions/000/resourceGroups/rg-weidxu/providers/Microsoft.KeyVault/vaults/v1weidxu\",\"name\":\"v1weidxu\",\"type\":\"Microsoft.KeyVault/vaults\",\"location\":\"centralus\",\"tags\":{},\"properties\":{\"sku\":{\"family\":\"A\",\"name\":\"standard\"},\"tenantId\":\"000\",\"accessPolicies\":[],\"enabledForDeployment\":false,\"vaultUri\":\"https://v1weidxu.vault.azure.net/\",\"provisioningState\":\"Succeeded\"}}";
        Duration pollInterval = Duration.ofSeconds(30);
        ResponseTransformer provisioningStateLroService = new ResponseTransformer() {
            private final int[] getCallCount = new int[1];

            @Override
            public com.github.tomakehurst.wiremock.http.Response transform(Request request,
                com.github.tomakehurst.wiremock.http.Response response, FileSource fileSource, Parameters parameters) {

                if (!request.getUrl().endsWith(resourceEndpoint)) {
                    return new com.github.tomakehurst.wiremock.http.Response.Builder().status(500)
                        .body("Unsupported path:" + request.getUrl())
                        .build();
                }
                if (request.getMethod().isOneOf(RequestMethod.PUT)) {
                    getCallCount[0]++;
                    if (getCallCount[0] > 1) {
                        return new com.github.tomakehurst.wiremock.http.Response.Builder().status(500)
                            .body("Unexpected additional polling detected.")
                            .build();
                    }
                    // 200 response with provisioningState=Succeeded.
                    return new com.github.tomakehurst.wiremock.http.Response.Builder().status(200)
                        .headers(new HttpHeaders(
                            HttpHeader.httpHeader("Retry-After", String.valueOf(pollInterval.getSeconds()))))
                        .body(sampleVaultUpdateSucceededResponse)
                        .build();
                }
                return response;
            }

            @Override
            public String getName() {
                return "LroService";
            }
        };

        WireMockServer lroServer = createServer(provisioningStateLroService, resourceEndpoint);
        lroServer.start();

        try {
            final ProvisioningStateLroServiceClient client = RestProxy.create(ProvisioningStateLroServiceClient.class,
                createHttpPipeline(lroServer.port()), SERIALIZER);
            if (syncStack) {
                SyncPoller<PollResult<Resource>, Resource> lroPoller
                    = SyncPollerFactory.create(SERIALIZER, new HttpPipelineBuilder().build(), Resource.class,
                        Resource.class, POLLING_DURATION, () -> newLroInitResponse(client));

                lroPoller.setPollInterval(pollInterval);
                long timeBeforePoll = System.currentTimeMillis();

                Resource result = lroPoller.getFinalResult();
                Assertions.assertNotNull(result);
                Assertions.assertNotNull(result.id());
                Assertions.assertEquals("v1weidxu", result.name());
                Assertions.assertEquals("Microsoft.KeyVault/vaults", result.type());

                Assertions.assertTrue(System.currentTimeMillis() - timeBeforePoll < pollInterval.toMillis());
            } else {
                PollerFlux<PollResult<Resource>, Resource> lroFlux
                    = PollerFactory.create(SERIALIZER, new HttpPipelineBuilder().build(), Resource.class,
                        Resource.class, POLLING_DURATION, newLroInitFunction(client));

                StepVerifier.create(lroFlux).expectSubscription().expectNextMatches(response -> {
                    PollResult<Resource> pollResult = response.getValue();
                    return response.getStatus() == LongRunningOperationStatus.SUCCESSFULLY_COMPLETED
                        && pollResult != null
                        && pollResult.getValue() != null
                        && pollResult.getValue().id() != null;
                }).verifyComplete();

                AsyncPollResponse<PollResult<Resource>, Resource> asyncPollResponse = lroFlux.blockLast();
                Assertions.assertNotNull(asyncPollResponse);

                Resource result = asyncPollResponse.getFinalResult().block();
                Assertions.assertNotNull(result);
                Assertions.assertNotNull(result.id());
                Assertions.assertEquals("v1weidxu", result.name());
                Assertions.assertEquals("Microsoft.KeyVault/vaults", result.type());
            }
        } finally {
            if (lroServer.isRunning()) {
                lroServer.shutdown();
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    public void lro201AsyncOperationSucceededNoPoll(boolean syncStack) {
        final String resourceEndpoint = "/resource/1";
        final String sampleNicCreateSucceededResponse
            = "{\"name\":\"nic4159682782\",\"id\":\"/subscriptions/000/resourceGroups/javanwmrg59122/providers/Microsoft.Network/networkInterfaces/nic4159682782\",\"etag\":\"W/\\\"92581fdf-b55d-4ca1-a1fa-9de0cf117b4f\\\"\",\"location\":\"eastus\",\"tags\":{},\"properties\":{\"provisioningState\":\"Succeeded\",\"resourceGuid\":\"e0a8ecd1-faa0-468c-8e30-411ca27417a1\",\"ipConfigurations\":[{\"name\":\"primary\",\"id\":\"/subscriptions/ec0aa5f7-9e78-40c9-85cd-535c6305b380/resourceGroups/javanwmrg59122/providers/Microsoft.Network/networkInterfaces/nic4159682782/ipConfigurations/primary\",\"etag\":\"W/\\\"92581fdf-b55d-4ca1-a1fa-9de0cf117b4f\\\"\",\"type\":\"Microsoft.Network/networkInterfaces/ipConfigurations\",\"properties\":{\"provisioningState\":\"Succeeded\",\"privateIPAddress\":\"10.0.0.6\",\"privateIPAllocationMethod\":\"Dynamic\",\"subnet\":{\"id\":\"/subscriptions/ec0aa5f7-9e78-40c9-85cd-535c6305b380/resourceGroups/javanwmrg59122/providers/Microsoft.Network/virtualNetworks/neta3e8953331/subnets/subnet1\"},\"primary\":true,\"privateIPAddressVersion\":\"IPv4\"}}],\"dnsSettings\":{\"dnsServers\":[],\"appliedDnsServers\":[],\"internalDomainNameSuffix\":\"a4vv4vgg2cluvfhfgw43jtn2aa.bx.internal.cloudapp.net\"},\"enableAcceleratedNetworking\":false,\"enableIPForwarding\":false,\"hostedWorkloads\":[],\"tapConfigurations\":[]},\"type\":\"Microsoft.Network/networkInterfaces\"}";
        ResponseTransformer provisioningStateLroService = new ResponseTransformer() {
            @Override
            public com.github.tomakehurst.wiremock.http.Response transform(Request request,
                com.github.tomakehurst.wiremock.http.Response response, FileSource fileSource, Parameters parameters) {

                if (!request.getUrl().endsWith(resourceEndpoint)) {
                    return new com.github.tomakehurst.wiremock.http.Response.Builder().status(500)
                        .body("Unsupported path:" + request.getUrl())
                        .build();
                }
                if (request.getMethod().isOneOf(RequestMethod.PUT)) {
                    // 201 response with provisioningState=Succeeded.
                    return new com.github.tomakehurst.wiremock.http.Response.Builder()
                        .headers(new HttpHeaders(new HttpHeader("Azure-AsyncOperation",
                            "https://management.azure.com/subscriptions/000/providers/Microsoft.Network/locations/eastus/operations/123")))
                        .body(sampleNicCreateSucceededResponse)
                        .status(201)
                        .build();
                }
                return response;
            }

            @Override
            public String getName() {
                return "LroService";
            }
        };

        WireMockServer lroServer = createServer(provisioningStateLroService, resourceEndpoint);
        lroServer.start();

        try {
            final ProvisioningStateLroServiceClient client = RestProxy.create(ProvisioningStateLroServiceClient.class,
                createHttpPipeline(lroServer.port()), SERIALIZER);
            if (syncStack) {
                SyncPoller<PollResult<Resource>, Resource> lroPoller
                    = SyncPollerFactory.create(SERIALIZER, new HttpPipelineBuilder().build(), Resource.class,
                        Resource.class, POLLING_DURATION, () -> newLroInitResponse(client));

                PollResponse<PollResult<Resource>> response = lroPoller.poll();
                Assertions.assertEquals(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED, response.getStatus());
                PollResult<Resource> pollResult = response.getValue();
                Assertions.assertNotNull(pollResult);
                Assertions.assertNotNull(pollResult.getValue().id());

                Resource result = lroPoller.getFinalResult();
                Assertions.assertNotNull(result);
                Assertions.assertNotNull(result.id());
                Assertions.assertEquals("nic4159682782", result.name());
                Assertions.assertEquals("Microsoft.Network/networkInterfaces", result.type());
            } else {
                PollerFlux<PollResult<Resource>, Resource> lroFlux
                    = PollerFactory.create(SERIALIZER, new HttpPipelineBuilder().build(), Resource.class,
                        Resource.class, POLLING_DURATION, newLroInitFunction(client));

                StepVerifier.create(lroFlux).expectSubscription().expectNextMatches(response -> {
                    PollResult<Resource> pollResult = response.getValue();
                    return response.getStatus() == LongRunningOperationStatus.SUCCESSFULLY_COMPLETED
                        && pollResult != null
                        && pollResult.getValue() != null
                        && pollResult.getValue().id() != null;
                }).verifyComplete();

                AsyncPollResponse<PollResult<Resource>, Resource> asyncPollResponse = lroFlux.blockLast();
                Assertions.assertNotNull(asyncPollResponse);

                Resource result = asyncPollResponse.getFinalResult().block();
                Assertions.assertNotNull(result);
                Assertions.assertNotNull(result.id());
                Assertions.assertEquals("nic4159682782", result.name());
                Assertions.assertEquals("Microsoft.Network/networkInterfaces", result.type());
            }
        } finally {
            if (lroServer.isRunning()) {
                lroServer.shutdown();
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    public void lro201SucceededNoPoll(boolean syncStack) {
        final String resourceEndpoint = "/resource/1";
        final String sampleSearchServiceCreateSucceededResponse
            = "{\"id\":\"/subscriptions/000/resourceGroups/rg86829b7a87d74/providers/Microsoft.Search/searchServices/ss3edfb54d\",\"name\":\"ss3edfb54d\",\"type\":\"Microsoft.Search/searchServices\",\"location\":\"West US\",\"properties\":{\"replicaCount\":1,\"partitionCount\":1,\"status\":\"running\",\"statusDetails\":\"\",\"provisioningState\":\"succeeded\",\"hostingMode\":\"Default\",\"publicNetworkAccess\":\"Enabled\",\"networkRuleSet\":{\"ipRules\":[],\"bypass\":\"None\"},\"privateEndpointConnections\":[],\"sharedPrivateLinkResources\":[]},\"sku\":{\"name\":\"free\"}}";
        ResponseTransformer provisioningStateLroService = new ResponseTransformer() {
            @Override
            public com.github.tomakehurst.wiremock.http.Response transform(Request request,
                com.github.tomakehurst.wiremock.http.Response response, FileSource fileSource, Parameters parameters) {

                if (!request.getUrl().endsWith(resourceEndpoint)) {
                    return new com.github.tomakehurst.wiremock.http.Response.Builder().status(500)
                        .body("Unsupported path:" + request.getUrl())
                        .build();
                }
                if (request.getMethod().isOneOf(RequestMethod.PUT)) {
                    // 201 response with provisioningState=Succeeded.
                    return new com.github.tomakehurst.wiremock.http.Response.Builder()
                        .headers(new HttpHeaders(new HttpHeader("Location",
                            "https://management.azure.com/subscriptions/000/resourceGroups/rg86829b7a87d74/providers/Microsoft.Search/searchServices/ss3edfb54d")))
                        .body(sampleSearchServiceCreateSucceededResponse)
                        .status(201)
                        .build();
                }
                return response;
            }

            @Override
            public String getName() {
                return "LroService";
            }
        };

        WireMockServer lroServer = createServer(provisioningStateLroService, resourceEndpoint);
        lroServer.start();

        try {
            final ProvisioningStateLroServiceClient client = RestProxy.create(ProvisioningStateLroServiceClient.class,
                createHttpPipeline(lroServer.port()), SERIALIZER);
            if (syncStack) {
                SyncPoller<PollResult<Resource>, Resource> lroPoller
                    = SyncPollerFactory.create(SERIALIZER, new HttpPipelineBuilder().build(), Resource.class,
                        Resource.class, POLLING_DURATION, () -> newLroInitResponse(client));

                PollResponse<PollResult<Resource>> pollResponse = lroPoller.poll();
                Assertions.assertEquals(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED, pollResponse.getStatus());

                Resource result = lroPoller.getFinalResult();
                Assertions.assertNotNull(result);
                Assertions.assertNotNull(result.id());
                Assertions.assertEquals("ss3edfb54d", result.name());
                Assertions.assertEquals("Microsoft.Search/searchServices", result.type());
            } else {
                PollerFlux<PollResult<Resource>, Resource> lroFlux
                    = PollerFactory.create(SERIALIZER, new HttpPipelineBuilder().build(), Resource.class,
                        Resource.class, POLLING_DURATION, newLroInitFunction(client));

                StepVerifier.create(lroFlux).expectSubscription().expectNextMatches(response -> {
                    PollResult<Resource> pollResult = response.getValue();
                    return response.getStatus() == LongRunningOperationStatus.SUCCESSFULLY_COMPLETED
                        && pollResult != null
                        && pollResult.getValue() != null
                        && pollResult.getValue().id() != null;
                }).verifyComplete();

                AsyncPollResponse<PollResult<Resource>, Resource> asyncPollResponse = lroFlux.blockLast();
                Assertions.assertNotNull(asyncPollResponse);

                Resource result = asyncPollResponse.getFinalResult().block();
                Assertions.assertNotNull(result);
                Assertions.assertNotNull(result.id());
                Assertions.assertEquals("ss3edfb54d", result.name());
                Assertions.assertEquals("Microsoft.Search/searchServices", result.type());
            }
        } finally {
            if (lroServer.isRunning()) {
                lroServer.shutdown();
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    public void lroMalformedAaoUrl(boolean syncStack) {
        ServerConfigure serverConfigure = new ServerConfigure();
        serverConfigure.pollingCountTillSuccess = 3;

        final String resourceEndpoint = "/resource/1";
        final String operationEndpoint = "/operations/1";
        ResponseTransformer provisioningStateLroService = new ResponseTransformer() {
            private final int[] getCallCount = new int[1];

            @Override
            public com.github.tomakehurst.wiremock.http.Response transform(Request request,
                com.github.tomakehurst.wiremock.http.Response response, FileSource fileSource, Parameters parameters) {

                if (!request.getUrl().endsWith(resourceEndpoint) && !request.getUrl().endsWith(operationEndpoint)) {
                    return new com.github.tomakehurst.wiremock.http.Response.Builder().status(500)
                        .body("Unsupported path:" + request.getUrl())
                        .build();
                }
                if (request.getMethod().isOneOf(RequestMethod.PUT)) {
                    // accept response
                    return new com.github.tomakehurst.wiremock.http.Response.Builder()
                        .headers(new HttpHeaders(new HttpHeader("Azure-AsyncOperation",
                            request.getAbsoluteUrl().replace(resourceEndpoint, operationEndpoint))))
                        .body(toJson(new FooWithProvisioningState("Creating")))
                        .status(201)
                        .build();
                }
                if (request.getMethod().isOneOf(RequestMethod.GET)) {
                    if (request.getUrl().endsWith(operationEndpoint)) {
                        getCallCount[0]++;
                        if (getCallCount[0] < serverConfigure.pollingCountTillSuccess) {
                            if (getCallCount[0] == 1) {
                                return new com.github.tomakehurst.wiremock.http.Response.Builder()
                                    .body("{\"status\": \"InProgress\"}")
                                    .build();
                            } else {
                                return new com.github.tomakehurst.wiremock.http.Response.Builder()
                                    .body("{\"status\": \"InProgress\"}")
                                    .headers(new HttpHeaders(new HttpHeader("Azure-AsyncOperation", "/invalid_url")))
                                    .build();
                            }
                        } else if (getCallCount[0] == serverConfigure.pollingCountTillSuccess) {
                            return new com.github.tomakehurst.wiremock.http.Response.Builder()
                                .body("{\"status\": \"Succeeded\"}")
                                .build();
                        }
                    } else if (request.getUrl().endsWith(resourceEndpoint)
                        && getCallCount[0] == serverConfigure.pollingCountTillSuccess) {
                        // final resource
                        return new com.github.tomakehurst.wiremock.http.Response.Builder()
                            .body(toJson(new FooWithProvisioningState("Succeeded", UUID.randomUUID().toString())))
                            .build();
                    } else {
                        return new com.github.tomakehurst.wiremock.http.Response.Builder().status(400)
                            .body("Invalid state:" + request.getUrl())
                            .build();
                    }
                }
                return response;
            }

            @Override
            public String getName() {
                return "LroService";
            }
        };

        WireMockServer lroServer = createServer(provisioningStateLroService, resourceEndpoint, operationEndpoint);
        lroServer.start();

        try {
            final ProvisioningStateLroServiceClient client = RestProxy.create(ProvisioningStateLroServiceClient.class,
                createHttpPipeline(lroServer.port()), SERIALIZER);
            if (syncStack) {
                SyncPoller<PollResult<FooWithProvisioningState>, FooWithProvisioningState> lroPoller = SyncPollerFactory
                    .create(SERIALIZER, new HttpPipelineBuilder().build(), FooWithProvisioningState.class,
                        FooWithProvisioningState.class, POLLING_DURATION, () -> newLroInitResponse(client));

                PollResponse<PollResult<FooWithProvisioningState>> pollResult = lroPoller.poll();
                Assertions.assertEquals(LongRunningOperationStatus.IN_PROGRESS, pollResult.getStatus());

                pollResult = lroPoller.poll();
                Assertions.assertEquals(LongRunningOperationStatus.FAILED, pollResult.getStatus());
            } else {
                PollerFlux<PollResult<FooWithProvisioningState>, FooWithProvisioningState> lroFlux = PollerFactory
                    .create(SERIALIZER, new HttpPipelineBuilder().build(), FooWithProvisioningState.class,
                        FooWithProvisioningState.class, POLLING_DURATION, newLroInitFunction(client));

                StepVerifier.create(lroFlux).expectSubscription().expectNextMatches(response -> {
                    PollResult<FooWithProvisioningState> pollResult = response.getValue();
                    return response.getStatus() == LongRunningOperationStatus.IN_PROGRESS
                        && pollResult != null
                        && pollResult.getValue() != null;
                }).expectNextMatches(response -> {
                    PollResult<FooWithProvisioningState> pollResult = response.getValue();
                    return response.getStatus() == LongRunningOperationStatus.FAILED
                        && pollResult != null
                        && pollResult.getError() != null;
                }).verifyComplete();
            }
        } finally {
            if (lroServer.isRunning()) {
                lroServer.shutdown();
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    public void lroTimeout(boolean syncStack) {
        final Duration timeoutDuration = Duration.ofMillis(1000);   // use a large timeout for manual verification

        final String resourceEndpoint = "/resource/1";
        final AtomicInteger getCallCount = new AtomicInteger(0);
        ResponseTransformer provisioningStateLroService = new ResponseTransformer() {
            @Override
            public com.github.tomakehurst.wiremock.http.Response transform(Request request,
                com.github.tomakehurst.wiremock.http.Response response, FileSource fileSource, Parameters parameters) {

                if (!request.getUrl().endsWith(resourceEndpoint)) {
                    return new com.github.tomakehurst.wiremock.http.Response.Builder().status(500)
                        .body("Unsupported path:" + request.getUrl())
                        .build();
                }
                if (request.getMethod().isOneOf(RequestMethod.PUT, RequestMethod.GET)) {
                    if (request.getMethod().isOneOf(RequestMethod.GET)) {
                        getCallCount.getAndIncrement();
                    }
                    return new com.github.tomakehurst.wiremock.http.Response.Builder()
                        .body(toJson(new FooWithProvisioningState("IN_PROGRESS")))
                        .build();
                }
                return response;
            }

            @Override
            public String getName() {
                return "LroService";
            }
        };

        WireMockServer lroServer = createServer(provisioningStateLroService, resourceEndpoint);
        lroServer.start();

        try {
            final ProvisioningStateLroServiceClient client = RestProxy.create(ProvisioningStateLroServiceClient.class,
                createHttpPipeline(lroServer.port()), SERIALIZER);
            if (syncStack) {
                SyncPoller<PollResult<FooWithProvisioningState>, FooWithProvisioningState> lroPoller = SyncPollerFactory
                    .create(SERIALIZER, new HttpPipelineBuilder().build(), FooWithProvisioningState.class,
                        FooWithProvisioningState.class, POLLING_DURATION, () -> newLroInitResponse(client));

                boolean timedOut = false;
                TimeLimiter timeLimiter = SimpleTimeLimiter.create(Executors.newSingleThreadExecutor());
                try {
                    timeLimiter.callWithTimeout(lroPoller::getFinalResult, timeoutDuration);
                } catch (TimeoutException e) {
                    timedOut = true;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                Assertions.assertTrue(timedOut);
            } else {
                PollerFlux<PollResult<FooWithProvisioningState>, FooWithProvisioningState> lroFlux = PollerFactory
                    .create(SERIALIZER, new HttpPipelineBuilder().build(), FooWithProvisioningState.class,
                        FooWithProvisioningState.class, POLLING_DURATION, newLroInitFunction(client));

                Mono<FooWithProvisioningState> resultMonoWithTimeout
                    = lroFlux.last().flatMap(AsyncPollResponse::getFinalResult).timeout(timeoutDuration);

                // VirtualTimeScheduler seems not working correctly in StepVerifier. Could be a problem.
                // verify timeout.
                StepVerifier.create(resultMonoWithTimeout).thenAwait().verifyError(TimeoutException.class);

                // verify no more polling after timeout.
                int count = getCallCount.get();
                try {
                    Thread.sleep(timeoutDuration.toMillis());
                } catch (InterruptedException e) {
                    //
                }
                // Assertions.assertEquals(count, getCallCount.get());
            }
        } finally {
            if (lroServer.isRunning()) {
                lroServer.shutdown();
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    public void lroRetryAfter(boolean syncStack) {
        ServerConfigure configure = new ServerConfigure();
        Duration expectedPollingDuration = Duration.ofSeconds(1);
        configure.pollingCountTillSuccess = 3;
        configure.additionalHeaders = new HttpHeaders(new HttpHeader("Retry-After", "1"));  // 1 second
        WireMockServer lroServer = startServer(configure);

        try {
            final ProvisioningStateLroServiceClient client = RestProxy.create(ProvisioningStateLroServiceClient.class,
                createHttpPipeline(lroServer.port()), SERIALIZER);
            if (syncStack) {
                SyncPoller<PollResult<FooWithProvisioningState>, FooWithProvisioningState> syncPoller
                    = SyncPollerFactory.create(SERIALIZER, new HttpPipelineBuilder().build(),
                        FooWithProvisioningState.class, FooWithProvisioningState.class, POLLING_DURATION,
                        () -> newLroInitResponse(client));

                long nanoTime = System.nanoTime();
                FooWithProvisioningState result = syncPoller.getFinalResult();
                Assertions.assertNotNull(result);

                Duration pollingDuration = Duration.ofNanos(System.nanoTime() - nanoTime);
                Assertions.assertTrue(pollingDuration.compareTo(expectedPollingDuration) > 0);
            } else {
                PollerFlux<PollResult<FooWithProvisioningState>, FooWithProvisioningState> lroFlux = PollerFactory
                    .create(SERIALIZER, new HttpPipelineBuilder().build(), FooWithProvisioningState.class,
                        FooWithProvisioningState.class, POLLING_DURATION, newLroInitFunction(client));

                long nanoTime = System.nanoTime();

                FooWithProvisioningState result = lroFlux
                    .doOnNext(response -> LOGGER.log(LogLevel.VERBOSE,
                        () -> String.format("[%s] status %s%n", OffsetDateTime.now(), response.getStatus())))
                    .blockLast()
                    .getFinalResult()
                    .block();
                Assertions.assertNotNull(result);

                Duration pollingDuration = Duration.ofNanos(System.nanoTime() - nanoTime);
                Assertions.assertTrue(pollingDuration.compareTo(expectedPollingDuration) > 0);
            }
        } finally {
            if (lroServer.isRunning()) {
                lroServer.shutdown();
            }
        }
    }

    @Test
    public void lroContextSubscriberContext() {
        WireMockServer lroServer = startServer();

        HttpPipelinePolicy contextVerifyPolicy = (context, next) -> {
            Optional<Object> valueOpt = context.getData("key1");
            if (valueOpt.isPresent() && "value1".equals(valueOpt.get())) {
                return next.process();
            } else {
                return Mono.error(new AssertionError());
            }
        };
        final HttpPipeline httpPipeline
            = createHttpPipeline(lroServer.port(), Collections.singletonList(contextVerifyPolicy));

        try {
            final ProvisioningStateLroServiceClient client
                = RestProxy.create(ProvisioningStateLroServiceClient.class, httpPipeline, SERIALIZER);

            Flux<AsyncPollResponse<PollResult<FooWithProvisioningState>, FooWithProvisioningState>> lroFlux
                = PollerFactory.create(SERIALIZER, httpPipeline, FooWithProvisioningState.class,
                    FooWithProvisioningState.class, POLLING_DURATION, newLroInitFunction(client));
            lroFlux = lroFlux.contextWrite(context -> context.put("key1", "value1"));

            FooWithProvisioningState result = lroFlux.blockLast().getFinalResult().block();
            Assertions.assertNotNull(result);
        } finally {
            if (lroServer.isRunning()) {
                lroServer.shutdown();
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    public void lroContext(boolean syncStack) {
        WireMockServer lroServer = startServer();

        HttpPipelinePolicy contextVerifyPolicy = (context, next) -> {
            Optional<Object> valueOpt = context.getData("key1");
            if (valueOpt.isPresent() && "value1".equals(valueOpt.get())) {
                return next.process();
            } else {
                return Mono.error(new AssertionError());
            }
        };
        final HttpPipeline httpPipeline
            = createHttpPipeline(lroServer.port(), Collections.singletonList(contextVerifyPolicy));

        try {
            final ProvisioningStateLroServiceClient client
                = RestProxy.create(ProvisioningStateLroServiceClient.class, httpPipeline, SERIALIZER);

            if (syncStack) {
                SyncPoller<PollResult<FooWithProvisioningState>, FooWithProvisioningState> lroPoller
                    = SyncPollerFactory.create(SERIALIZER, httpPipeline, FooWithProvisioningState.class,
                        FooWithProvisioningState.class, POLLING_DURATION,
                        () -> newLroInitResponse(client, new Context("key1", "value1")), new Context("key1", "value1"));

                FooWithProvisioningState result = lroPoller.getFinalResult();
                Assertions.assertNotNull(result);
            } else {
                Flux<AsyncPollResponse<PollResult<FooWithProvisioningState>, FooWithProvisioningState>> lroFlux
                    = PollerFactory.create(SERIALIZER, httpPipeline, FooWithProvisioningState.class,
                        FooWithProvisioningState.class, POLLING_DURATION,
                        newLroInitFunction(client).contextWrite(context -> context.put("key1", "value1")),
                        new Context("key1", "value1"));

                FooWithProvisioningState result = lroFlux.blockLast().getFinalResult().block();
                Assertions.assertNotNull(result);
            }
        } finally {
            if (lroServer.isRunning()) {
                lroServer.shutdown();
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    public void lroBasedOnAsyncOperationInBinaryData(boolean syncStack) {
        ServerConfigure serverConfigure = new ServerConfigure();

        final String resourceEndpoint = "/resource/1";
        final String operationEndpoint = "/operations/1";
        ResponseTransformer provisioningStateLroService = new ResponseTransformer() {
            private final int[] getCallCount = new int[1];

            @Override
            public com.github.tomakehurst.wiremock.http.Response transform(Request request,
                com.github.tomakehurst.wiremock.http.Response response, FileSource fileSource, Parameters parameters) {

                if (!request.getUrl().endsWith(resourceEndpoint) && !request.getUrl().endsWith(operationEndpoint)) {
                    return new com.github.tomakehurst.wiremock.http.Response.Builder().status(500)
                        .body("Unsupported path:" + request.getUrl())
                        .build();
                }
                if (request.getMethod().isOneOf(RequestMethod.PUT)) {
                    // accept response
                    return new com.github.tomakehurst.wiremock.http.Response.Builder()
                        .headers(new HttpHeaders(new HttpHeader("Azure-AsyncOperation",
                            request.getAbsoluteUrl().replace(resourceEndpoint, operationEndpoint))))
                        .body(toJson(new FooWithProvisioningState("Creating")))
                        .status(201)
                        .build();
                }
                if (request.getMethod().isOneOf(RequestMethod.GET)) {
                    if (request.getUrl().endsWith(operationEndpoint)) {
                        getCallCount[0]++;
                        if (getCallCount[0] < serverConfigure.pollingCountTillSuccess) {
                            return new com.github.tomakehurst.wiremock.http.Response.Builder()
                                .body("{\"status\": \"InProgress\"}")
                                .build();
                        } else if (getCallCount[0] == serverConfigure.pollingCountTillSuccess) {
                            return new com.github.tomakehurst.wiremock.http.Response.Builder()
                                .body("{\"status\": \"Succeeded\"}")
                                .build();
                        }
                    } else if (request.getUrl().endsWith(resourceEndpoint)
                        && getCallCount[0] == serverConfigure.pollingCountTillSuccess) {
                        // final resource
                        return new com.github.tomakehurst.wiremock.http.Response.Builder()
                            .body(toJson(new FooWithProvisioningState("Succeeded", UUID.randomUUID().toString())))
                            .build();
                    } else {
                        return new com.github.tomakehurst.wiremock.http.Response.Builder().status(400)
                            .body("Invalid state:" + request.getUrl())
                            .build();
                    }
                }
                return response;
            }

            @Override
            public String getName() {
                return "LroService";
            }
        };

        WireMockServer lroServer = createServer(provisioningStateLroService, resourceEndpoint, operationEndpoint);
        lroServer.start();

        try {
            final ProvisioningStateLroServiceClient client = RestProxy.create(ProvisioningStateLroServiceClient.class,
                createHttpPipeline(lroServer.port()), SERIALIZER);

            if (syncStack) {
                SyncPoller<PollResult<BinaryData>, BinaryData> lroPoller
                    = SyncPollerFactory.create(SERIALIZER, new HttpPipelineBuilder().build(), BinaryData.class,
                        BinaryData.class, POLLING_DURATION, () -> newLroInitResponse(client));

                for (int i = 0; i < 2; i++) {
                    PollResponse<PollResult<BinaryData>> response = lroPoller.poll();
                    PollResult<BinaryData> pollResult = response.getValue();
                    Assertions.assertNotNull(pollResult);
                    Assertions.assertNotNull(pollResult.getValue());
                    if (i == 0) {
                        Assertions.assertEquals(LongRunningOperationStatus.IN_PROGRESS, response.getStatus());
                    } else {
                        Assertions.assertEquals(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                            response.getStatus());
                    }
                }

                BinaryData foo = lroPoller.getFinalResult();
                FooWithProvisioningState fooAsObject = foo.toObject(FooWithProvisioningState.class);
                Assertions.assertNotNull(fooAsObject.getResourceId());
                Assertions.assertEquals("Succeeded", fooAsObject.getProvisioningState());
            } else {
                PollerFlux<PollResult<BinaryData>, BinaryData> lroFlux
                    = PollerFactory.create(SERIALIZER, new HttpPipelineBuilder().build(), BinaryData.class,
                        BinaryData.class, POLLING_DURATION, newLroInitFunction(client));

                int[] onNextCallCount = new int[1];
                AsyncPollResponse<PollResult<BinaryData>, BinaryData> pollResponse = lroFlux.doOnNext(response -> {
                    PollResult<BinaryData> pollResult = response.getValue();
                    Assertions.assertNotNull(pollResult);
                    Assertions.assertNotNull(pollResult.getValue());
                    onNextCallCount[0]++;
                    if (onNextCallCount[0] == 1) {
                        Assertions.assertEquals(LongRunningOperationStatus.IN_PROGRESS, response.getStatus());
                    } else if (onNextCallCount[0] == 2) {
                        Assertions.assertEquals(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                            response.getStatus());
                    } else {
                        throw new IllegalStateException("Poller emitted more than expected value.");
                    }
                }).blockLast();

                BinaryData foo = pollResponse.getFinalResult().block();
                FooWithProvisioningState fooAsObject = foo.toObject(FooWithProvisioningState.class);
                Assertions.assertNotNull(fooAsObject.getResourceId());
                Assertions.assertEquals("Succeeded", fooAsObject.getProvisioningState());
            }
        } finally {
            if (lroServer.isRunning()) {
                lroServer.shutdown();
            }
        }
    }

    private static class ServerConfigure {
        private int pollingCountTillSuccess = 2;

        private HttpHeaders additionalHeaders = HttpHeaders.noHeaders();
    }

    private static WireMockServer startServer() {
        return startServer(new ServerConfigure());
    }

    private static WireMockServer startServer(ServerConfigure serverConfigure) {
        final String resourceEndpoint = "/resource/1";
        ResponseTransformer provisioningStateLroService = new ResponseTransformer() {
            private final int[] getCallCount = new int[1];

            @Override
            public com.github.tomakehurst.wiremock.http.Response transform(Request request,
                com.github.tomakehurst.wiremock.http.Response response, FileSource fileSource, Parameters parameters) {

                if (!request.getUrl().endsWith(resourceEndpoint)) {
                    return new com.github.tomakehurst.wiremock.http.Response.Builder().status(500)
                        .body("Unsupported path:" + request.getUrl())
                        .build();
                }
                if (request.getMethod().isOneOf(RequestMethod.PUT)) {
                    LOGGER.log(LogLevel.VERBOSE,
                        () -> String.format("[%s] PUT status %s%n", OffsetDateTime.now(), "IN_PROGRESS"));
                    return new com.github.tomakehurst.wiremock.http.Response.Builder()
                        .headers(serverConfigure.additionalHeaders)
                        .body(toJson(new FooWithProvisioningState("IN_PROGRESS")))
                        .build();
                }
                if (request.getMethod().isOneOf(RequestMethod.GET)) {
                    getCallCount[0]++;
                    if (getCallCount[0] < serverConfigure.pollingCountTillSuccess) {
                        LOGGER.log(LogLevel.VERBOSE,
                            () -> String.format("[%s] GET status %s%n", OffsetDateTime.now(), "IN_PROGRESS"));
                        return new com.github.tomakehurst.wiremock.http.Response.Builder()
                            .headers(serverConfigure.additionalHeaders)
                            .body(toJson(new FooWithProvisioningState("IN_PROGRESS")))
                            .build();
                    } else if (getCallCount[0] == serverConfigure.pollingCountTillSuccess) {
                        LOGGER.log(LogLevel.VERBOSE,
                            () -> String.format("[%s] GET status %s%n", OffsetDateTime.now(), "SUCCEEDED"));
                        return new com.github.tomakehurst.wiremock.http.Response.Builder()
                            .body(toJson(new FooWithProvisioningState("SUCCEEDED", UUID.randomUUID().toString())))
                            .build();
                    }
                }
                return response;
            }

            @Override
            public String getName() {
                return "LroService";
            }
        };

        WireMockServer lroServer = createServer(provisioningStateLroService, resourceEndpoint);
        lroServer.start();

        return lroServer;
    }

    private static WireMockServer createServer(ResponseTransformer transformer, String... endpoints) {
        WireMockServer server = new WireMockServer(
            WireMockConfiguration.options().dynamicPort().extensions(transformer).disableRequestJournal());
        for (String endpoint : endpoints) {
            server.stubFor(WireMock.any(WireMock.urlEqualTo(endpoint)).willReturn(WireMock.aResponse()));
        }
        return server;
    }

    private static HttpPipeline createHttpPipeline(int port) {
        return createHttpPipeline(port, Collections.emptyList());
    }

    private static HttpPipeline createHttpPipeline(int port, List<HttpPipelinePolicy> additionalPolicies) {
        List<HttpPipelinePolicy> policies = new ArrayList<>(additionalPolicies);
        policies.add(new HttpPipelinePolicy() {
            @Override
            public Mono<HttpResponse> process(HttpPipelineCallContext context, HttpPipelineNextPolicy next) {
                HttpRequest request = context.getHttpRequest();
                request.setUrl(updatePort(request.getUrl(), port));
                context.setHttpRequest(request);
                return next.process();
            }

            private URL updatePort(URL url, int port) {
                try {
                    return new URI(url.getProtocol(), null, url.getHost(), port, url.getPath(), url.getQuery(), null)
                        .toURL();
                } catch (URISyntaxException | MalformedURLException mue) {
                    throw new RuntimeException(mue);
                }
            }
        });
        return new HttpPipelineBuilder().policies(policies.toArray(new HttpPipelinePolicy[0])).build();
    }

    private Mono<Response<Flux<ByteBuffer>>> newLroInitFunction(ProvisioningStateLroServiceClient client) {
        return FluxUtil.fluxContext(context -> client.startLro(context).flux()).next();
    }

    private Response<BinaryData> newLroInitResponse(ProvisioningStateLroServiceClient client) {
        return newLroInitResponse(client, Context.NONE);
    }

    private Response<BinaryData> newLroInitResponse(ProvisioningStateLroServiceClient client, Context context) {
        return client.startLroSync(context);
    }

    private static String toJson(Object object) {
        try {
            return SERIALIZER.serialize(object, SerializerEncoding.JSON);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
