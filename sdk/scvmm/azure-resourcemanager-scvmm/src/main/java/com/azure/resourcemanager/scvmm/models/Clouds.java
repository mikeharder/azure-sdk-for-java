// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.scvmm.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/**
 * Resource collection API of Clouds.
 */
public interface Clouds {
    /**
     * Implements GET Clouds in a subscription.
     * 
     * List of Clouds in a subscription.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a Cloud list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<Cloud> list();

    /**
     * Implements GET Clouds in a subscription.
     * 
     * List of Clouds in a subscription.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a Cloud list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<Cloud> list(Context context);

    /**
     * Implements GET Clouds in a resource group.
     * 
     * List of Clouds in a resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a Cloud list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<Cloud> listByResourceGroup(String resourceGroupName);

    /**
     * Implements GET Clouds in a resource group.
     * 
     * List of Clouds in a resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a Cloud list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<Cloud> listByResourceGroup(String resourceGroupName, Context context);

    /**
     * Gets a Cloud.
     * 
     * Implements Cloud GET method.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param cloudResourceName Name of the Cloud.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the Clouds resource definition along with {@link Response}.
     */
    Response<Cloud> getByResourceGroupWithResponse(String resourceGroupName, String cloudResourceName, Context context);

    /**
     * Gets a Cloud.
     * 
     * Implements Cloud GET method.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param cloudResourceName Name of the Cloud.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the Clouds resource definition.
     */
    Cloud getByResourceGroup(String resourceGroupName, String cloudResourceName);

    /**
     * Implements Cloud resource DELETE method.
     * 
     * Deregisters the ScVmm fabric cloud from Azure.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param cloudResourceName Name of the Cloud.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String cloudResourceName);

    /**
     * Implements Cloud resource DELETE method.
     * 
     * Deregisters the ScVmm fabric cloud from Azure.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param cloudResourceName Name of the Cloud.
     * @param force Forces the resource to be deleted.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String cloudResourceName, ForceDelete force, Context context);

    /**
     * Gets a Cloud.
     * 
     * Implements Cloud GET method.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the Clouds resource definition along with {@link Response}.
     */
    Cloud getById(String id);

    /**
     * Gets a Cloud.
     * 
     * Implements Cloud GET method.
     * 
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the Clouds resource definition along with {@link Response}.
     */
    Response<Cloud> getByIdWithResponse(String id, Context context);

    /**
     * Implements Cloud resource DELETE method.
     * 
     * Deregisters the ScVmm fabric cloud from Azure.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteById(String id);

    /**
     * Implements Cloud resource DELETE method.
     * 
     * Deregisters the ScVmm fabric cloud from Azure.
     * 
     * @param id the resource ID.
     * @param force Forces the resource to be deleted.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteByIdWithResponse(String id, ForceDelete force, Context context);

    /**
     * Begins definition for a new Cloud resource.
     * 
     * @param name resource name.
     * @return the first stage of the new Cloud definition.
     */
    Cloud.DefinitionStages.Blank define(String name);
}
