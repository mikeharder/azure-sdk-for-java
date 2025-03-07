// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.models;

import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/**
 * Resource collection API of OutboundNetworkDependenciesEndpoints.
 */
public interface OutboundNetworkDependenciesEndpoints {
    /**
     * Gets the network endpoints of all outbound dependencies of a ApiManagement service.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the network endpoints of all outbound dependencies of a ApiManagement service along with
     * {@link Response}.
     */
    Response<OutboundEnvironmentEndpointList> listByServiceWithResponse(String resourceGroupName, String serviceName,
        Context context);

    /**
     * Gets the network endpoints of all outbound dependencies of a ApiManagement service.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the network endpoints of all outbound dependencies of a ApiManagement service.
     */
    OutboundEnvironmentEndpointList listByService(String resourceGroupName, String serviceName);
}
