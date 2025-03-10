// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devtestlabs.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.devtestlabs.fluent.models.NotificationChannelInner;
import com.azure.resourcemanager.devtestlabs.models.NotificationChannelFragment;
import com.azure.resourcemanager.devtestlabs.models.NotifyParameters;

/**
 * An instance of this class provides access to all the operations defined in NotificationChannelsClient.
 */
public interface NotificationChannelsClient {
    /**
     * List notification channels in a given lab.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<NotificationChannelInner> list(String resourceGroupName, String labName);

    /**
     * List notification channels in a given lab.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param expand Specify the $expand query. Example: 'properties($select=webHookUrl)'.
     * @param filter The filter to apply to the operation. Example: '$filter=contains(name,'myName').
     * @param top The maximum number of resources to return from the operation. Example: '$top=10'.
     * @param orderby The ordering expression for the results, using OData notation. Example: '$orderby=name desc'.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<NotificationChannelInner> list(String resourceGroupName, String labName, String expand, String filter,
        Integer top, String orderby, Context context);

    /**
     * Get notification channel.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the notification channel.
     * @param expand Specify the $expand query. Example: 'properties($select=webHookUrl)'.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return notification channel along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<NotificationChannelInner> getWithResponse(String resourceGroupName, String labName, String name,
        String expand, Context context);

    /**
     * Get notification channel.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the notification channel.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return notification channel.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    NotificationChannelInner get(String resourceGroupName, String labName, String name);

    /**
     * Create or replace an existing notification channel.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the notification channel.
     * @param notificationChannel A notification.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a notification along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<NotificationChannelInner> createOrUpdateWithResponse(String resourceGroupName, String labName, String name,
        NotificationChannelInner notificationChannel, Context context);

    /**
     * Create or replace an existing notification channel.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the notification channel.
     * @param notificationChannel A notification.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a notification.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    NotificationChannelInner createOrUpdate(String resourceGroupName, String labName, String name,
        NotificationChannelInner notificationChannel);

    /**
     * Delete notification channel.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the notification channel.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> deleteWithResponse(String resourceGroupName, String labName, String name, Context context);

    /**
     * Delete notification channel.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the notification channel.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String labName, String name);

    /**
     * Allows modifying tags of notification channels. All other properties will be ignored.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the notification channel.
     * @param notificationChannel A notification.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a notification along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<NotificationChannelInner> updateWithResponse(String resourceGroupName, String labName, String name,
        NotificationChannelFragment notificationChannel, Context context);

    /**
     * Allows modifying tags of notification channels. All other properties will be ignored.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the notification channel.
     * @param notificationChannel A notification.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a notification.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    NotificationChannelInner update(String resourceGroupName, String labName, String name,
        NotificationChannelFragment notificationChannel);

    /**
     * Send notification to provided channel.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the notification channel.
     * @param notifyParameters Properties for generating a Notification.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> notifyWithResponse(String resourceGroupName, String labName, String name,
        NotifyParameters notifyParameters, Context context);

    /**
     * Send notification to provided channel.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param name The name of the notification channel.
     * @param notifyParameters Properties for generating a Notification.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void notify(String resourceGroupName, String labName, String name, NotifyParameters notifyParameters);
}
