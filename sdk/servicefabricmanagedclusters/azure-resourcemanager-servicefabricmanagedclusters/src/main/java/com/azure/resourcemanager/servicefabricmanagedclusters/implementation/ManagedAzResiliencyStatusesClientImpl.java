// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.servicefabricmanagedclusters.implementation;

import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Headers;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Post;
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
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.servicefabricmanagedclusters.fluent.ManagedAzResiliencyStatusesClient;
import com.azure.resourcemanager.servicefabricmanagedclusters.fluent.models.ManagedAzResiliencyStatusInner;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in ManagedAzResiliencyStatusesClient.
 */
public final class ManagedAzResiliencyStatusesClientImpl implements ManagedAzResiliencyStatusesClient {
    /**
     * The proxy service used to perform REST calls.
     */
    private final ManagedAzResiliencyStatusesService service;

    /**
     * The service client containing this operation class.
     */
    private final ServiceFabricManagedClustersMgmtClientImpl client;

    /**
     * Initializes an instance of ManagedAzResiliencyStatusesClientImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    ManagedAzResiliencyStatusesClientImpl(ServiceFabricManagedClustersMgmtClientImpl client) {
        this.service = RestProxy.create(ManagedAzResiliencyStatusesService.class, client.getHttpPipeline(),
            client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for ServiceFabricManagedClustersMgmtClientManagedAzResiliencyStatuses to
     * be used by the proxy service to perform REST calls.
     */
    @Host("{endpoint}")
    @ServiceInterface(name = "ServiceFabricManagedClustersMgmtClientManagedAzResiliencyStatuses")
    public interface ManagedAzResiliencyStatusesService {
        @Headers({ "Content-Type: application/json" })
        @Post("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.ServiceFabric/managedClusters/{clusterName}/getazresiliencystatus")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<ManagedAzResiliencyStatusInner>> get(@HostParam("endpoint") String endpoint,
            @QueryParam("api-version") String apiVersion, @PathParam("subscriptionId") String subscriptionId,
            @PathParam("resourceGroupName") String resourceGroupName, @PathParam("clusterName") String clusterName,
            @HeaderParam("Accept") String accept, Context context);

        @Headers({ "Content-Type: application/json" })
        @Post("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.ServiceFabric/managedClusters/{clusterName}/getazresiliencystatus")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Response<ManagedAzResiliencyStatusInner> getSync(@HostParam("endpoint") String endpoint,
            @QueryParam("api-version") String apiVersion, @PathParam("subscriptionId") String subscriptionId,
            @PathParam("resourceGroupName") String resourceGroupName, @PathParam("clusterName") String clusterName,
            @HeaderParam("Accept") String accept, Context context);
    }

    /**
     * Action to get Az Resiliency Status of all the Base resources constituting Service Fabric Managed Clusters.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return describes the result of the request to list Managed VM Sizes for Service Fabric Managed Clusters along
     * with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<ManagedAzResiliencyStatusInner>> getWithResponseAsync(String resourceGroupName,
        String clusterName) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono.error(new IllegalArgumentException(
                "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (clusterName == null) {
            return Mono.error(new IllegalArgumentException("Parameter clusterName is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.get(this.client.getEndpoint(), this.client.getApiVersion(),
                this.client.getSubscriptionId(), resourceGroupName, clusterName, accept, context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Action to get Az Resiliency Status of all the Base resources constituting Service Fabric Managed Clusters.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return describes the result of the request to list Managed VM Sizes for Service Fabric Managed Clusters on
     * successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<ManagedAzResiliencyStatusInner> getAsync(String resourceGroupName, String clusterName) {
        return getWithResponseAsync(resourceGroupName, clusterName).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Action to get Az Resiliency Status of all the Base resources constituting Service Fabric Managed Clusters.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return describes the result of the request to list Managed VM Sizes for Service Fabric Managed Clusters along
     * with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ManagedAzResiliencyStatusInner> getWithResponse(String resourceGroupName, String clusterName,
        Context context) {
        if (this.client.getEndpoint() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (clusterName == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Parameter clusterName is required and cannot be null."));
        }
        final String accept = "application/json";
        return service.getSync(this.client.getEndpoint(), this.client.getApiVersion(), this.client.getSubscriptionId(),
            resourceGroupName, clusterName, accept, context);
    }

    /**
     * Action to get Az Resiliency Status of all the Base resources constituting Service Fabric Managed Clusters.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return describes the result of the request to list Managed VM Sizes for Service Fabric Managed Clusters.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ManagedAzResiliencyStatusInner get(String resourceGroupName, String clusterName) {
        return getWithResponse(resourceGroupName, clusterName, Context.NONE).getValue();
    }

    private static final ClientLogger LOGGER = new ClientLogger(ManagedAzResiliencyStatusesClientImpl.class);
}
