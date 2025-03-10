// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resourcemover.implementation;

import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Headers;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.management.exception.ManagementException;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.resourcemanager.resourcemover.fluent.OperationsDiscoveriesClient;
import com.azure.resourcemanager.resourcemover.fluent.models.OperationsDiscoveryCollectionInner;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in OperationsDiscoveriesClient.
 */
public final class OperationsDiscoveriesClientImpl implements OperationsDiscoveriesClient {
    /**
     * The proxy service used to perform REST calls.
     */
    private final OperationsDiscoveriesService service;

    /**
     * The service client containing this operation class.
     */
    private final ResourceMoverServiceApiImpl client;

    /**
     * Initializes an instance of OperationsDiscoveriesClientImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    OperationsDiscoveriesClientImpl(ResourceMoverServiceApiImpl client) {
        this.service = RestProxy.create(OperationsDiscoveriesService.class, client.getHttpPipeline(),
            client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for ResourceMoverServiceApiOperationsDiscoveries to be used by the proxy
     * service to perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "ResourceMoverService")
    public interface OperationsDiscoveriesService {
        @Headers({ "Content-Type: application/json" })
        @Get("/providers/Microsoft.Migrate/operations")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<OperationsDiscoveryCollectionInner>> get(@HostParam("$host") String endpoint,
            @QueryParam("api-version") String apiVersion, @HeaderParam("Accept") String accept, Context context);
    }

    /**
     * The get operation.
     * 
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return collection of ClientDiscovery details along with {@link Response} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<OperationsDiscoveryCollectionInner>> getWithResponseAsync() {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(
                context -> service.get(this.client.getEndpoint(), this.client.getApiVersion(), accept, context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * The get operation.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return collection of ClientDiscovery details along with {@link Response} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<OperationsDiscoveryCollectionInner>> getWithResponseAsync(Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service.get(this.client.getEndpoint(), this.client.getApiVersion(), accept, context);
    }

    /**
     * The get operation.
     * 
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return collection of ClientDiscovery details on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<OperationsDiscoveryCollectionInner> getAsync() {
        return getWithResponseAsync().flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * The get operation.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return collection of ClientDiscovery details along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<OperationsDiscoveryCollectionInner> getWithResponse(Context context) {
        return getWithResponseAsync(context).block();
    }

    /**
     * The get operation.
     * 
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return collection of ClientDiscovery details.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public OperationsDiscoveryCollectionInner get() {
        return getWithResponse(Context.NONE).getValue();
    }
}
