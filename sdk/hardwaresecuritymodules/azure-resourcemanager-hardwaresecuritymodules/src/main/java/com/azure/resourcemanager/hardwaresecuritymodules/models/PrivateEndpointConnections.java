// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.hardwaresecuritymodules.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.util.Context;

/**
 * Resource collection API of PrivateEndpointConnections.
 */
public interface PrivateEndpointConnections {
    /**
     * The List operation gets information about the private endpoint connections associated with the Cloud HSM Cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param cloudHsmClusterName The name of the Cloud HSM Cluster within the specified resource group. Cloud HSM
     * Cluster names must be between 3 and 23 characters in length.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a PrivateEndpointConnection list operation as paginated response with
     * {@link PagedIterable}.
     */
    PagedIterable<PrivateEndpointConnection> listByCloudHsmCluster(String resourceGroupName,
        String cloudHsmClusterName);

    /**
     * The List operation gets information about the private endpoint connections associated with the Cloud HSM Cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param cloudHsmClusterName The name of the Cloud HSM Cluster within the specified resource group. Cloud HSM
     * Cluster names must be between 3 and 23 characters in length.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a PrivateEndpointConnection list operation as paginated response with
     * {@link PagedIterable}.
     */
    PagedIterable<PrivateEndpointConnection> listByCloudHsmCluster(String resourceGroupName, String cloudHsmClusterName,
        Context context);
}
