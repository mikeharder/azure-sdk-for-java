// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.hardwaresecuritymodules.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.hardwaresecuritymodules.fluent.models.PrivateEndpointConnectionInner;

/**
 * An instance of this class provides access to all the operations defined in
 * CloudHsmClusterPrivateEndpointConnectionsClient.
 */
public interface CloudHsmClusterPrivateEndpointConnectionsClient {
    /**
     * Gets the private endpoint connection for the Cloud Hsm Cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param cloudHsmClusterName The name of the Cloud HSM Cluster within the specified resource group. Cloud HSM
     * Cluster names must be between 3 and 23 characters in length.
     * @param peConnectionName Name of the private endpoint connection associated with the Cloud HSM Cluster.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the private endpoint connection for the Cloud Hsm Cluster along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<PrivateEndpointConnectionInner> getWithResponse(String resourceGroupName, String cloudHsmClusterName,
        String peConnectionName, Context context);

    /**
     * Gets the private endpoint connection for the Cloud Hsm Cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param cloudHsmClusterName The name of the Cloud HSM Cluster within the specified resource group. Cloud HSM
     * Cluster names must be between 3 and 23 characters in length.
     * @param peConnectionName Name of the private endpoint connection associated with the Cloud HSM Cluster.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the private endpoint connection for the Cloud Hsm Cluster.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    PrivateEndpointConnectionInner get(String resourceGroupName, String cloudHsmClusterName, String peConnectionName);

    /**
     * Creates or updates the private endpoint connection for the Cloud Hsm Cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param cloudHsmClusterName The name of the Cloud HSM Cluster within the specified resource group. Cloud HSM
     * Cluster names must be between 3 and 23 characters in length.
     * @param peConnectionName Name of the private endpoint connection associated with the Cloud HSM Cluster.
     * @param properties Parameters of the PrivateEndpointConnection.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the private endpoint connection resource along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<PrivateEndpointConnectionInner> createWithResponse(String resourceGroupName, String cloudHsmClusterName,
        String peConnectionName, PrivateEndpointConnectionInner properties, Context context);

    /**
     * Creates or updates the private endpoint connection for the Cloud Hsm Cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param cloudHsmClusterName The name of the Cloud HSM Cluster within the specified resource group. Cloud HSM
     * Cluster names must be between 3 and 23 characters in length.
     * @param peConnectionName Name of the private endpoint connection associated with the Cloud HSM Cluster.
     * @param properties Parameters of the PrivateEndpointConnection.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the private endpoint connection resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    PrivateEndpointConnectionInner create(String resourceGroupName, String cloudHsmClusterName, String peConnectionName,
        PrivateEndpointConnectionInner properties);

    /**
     * Deletes the private endpoint connection for the Cloud Hsm Cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param cloudHsmClusterName The name of the Cloud HSM Cluster within the specified resource group. Cloud HSM
     * Cluster names must be between 3 and 23 characters in length.
     * @param peConnectionName Name of the private endpoint connection associated with the Cloud HSM Cluster.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String cloudHsmClusterName,
        String peConnectionName);

    /**
     * Deletes the private endpoint connection for the Cloud Hsm Cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param cloudHsmClusterName The name of the Cloud HSM Cluster within the specified resource group. Cloud HSM
     * Cluster names must be between 3 and 23 characters in length.
     * @param peConnectionName Name of the private endpoint connection associated with the Cloud HSM Cluster.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String cloudHsmClusterName,
        String peConnectionName, Context context);

    /**
     * Deletes the private endpoint connection for the Cloud Hsm Cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param cloudHsmClusterName The name of the Cloud HSM Cluster within the specified resource group. Cloud HSM
     * Cluster names must be between 3 and 23 characters in length.
     * @param peConnectionName Name of the private endpoint connection associated with the Cloud HSM Cluster.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String cloudHsmClusterName, String peConnectionName);

    /**
     * Deletes the private endpoint connection for the Cloud Hsm Cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param cloudHsmClusterName The name of the Cloud HSM Cluster within the specified resource group. Cloud HSM
     * Cluster names must be between 3 and 23 characters in length.
     * @param peConnectionName Name of the private endpoint connection associated with the Cloud HSM Cluster.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String cloudHsmClusterName, String peConnectionName, Context context);
}
