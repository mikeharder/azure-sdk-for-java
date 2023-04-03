// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.newrelicobservability.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.newrelicobservability.fluent.models.AppServiceInfoInner;
import com.azure.resourcemanager.newrelicobservability.fluent.models.MetricRulesInner;
import com.azure.resourcemanager.newrelicobservability.fluent.models.MetricsStatusResponseInner;
import com.azure.resourcemanager.newrelicobservability.fluent.models.MonitoredResourceInner;
import com.azure.resourcemanager.newrelicobservability.fluent.models.NewRelicMonitorResourceInner;
import com.azure.resourcemanager.newrelicobservability.fluent.models.VMExtensionPayloadInner;
import com.azure.resourcemanager.newrelicobservability.fluent.models.VMInfoInner;
import com.azure.resourcemanager.newrelicobservability.models.AppServicesGetRequest;
import com.azure.resourcemanager.newrelicobservability.models.HostsGetRequest;
import com.azure.resourcemanager.newrelicobservability.models.MetricsRequest;
import com.azure.resourcemanager.newrelicobservability.models.MetricsStatusRequest;
import com.azure.resourcemanager.newrelicobservability.models.NewRelicMonitorResourceUpdate;
import com.azure.resourcemanager.newrelicobservability.models.SwitchBillingRequest;

/** An instance of this class provides access to all the operations defined in MonitorsClient. */
public interface MonitorsClient {
    /**
     * List NewRelicMonitorResource resources by subscription ID.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a NewRelicMonitorResource list operation as paginated response with {@link
     *     PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<NewRelicMonitorResourceInner> list();

    /**
     * List NewRelicMonitorResource resources by subscription ID.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a NewRelicMonitorResource list operation as paginated response with {@link
     *     PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<NewRelicMonitorResourceInner> list(Context context);

    /**
     * List NewRelicMonitorResource resources by resource group.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a NewRelicMonitorResource list operation as paginated response with {@link
     *     PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<NewRelicMonitorResourceInner> listByResourceGroup(String resourceGroupName);

    /**
     * List NewRelicMonitorResource resources by resource group.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a NewRelicMonitorResource list operation as paginated response with {@link
     *     PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<NewRelicMonitorResourceInner> listByResourceGroup(String resourceGroupName, Context context);

    /**
     * Get a NewRelicMonitorResource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a NewRelicMonitorResource along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<NewRelicMonitorResourceInner> getByResourceGroupWithResponse(
        String resourceGroupName, String monitorName, Context context);

    /**
     * Get a NewRelicMonitorResource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a NewRelicMonitorResource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    NewRelicMonitorResourceInner getByResourceGroup(String resourceGroupName, String monitorName);

    /**
     * Create a NewRelicMonitorResource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param resource Resource create parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of a Monitor Resource by NewRelic.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<NewRelicMonitorResourceInner>, NewRelicMonitorResourceInner> beginCreateOrUpdate(
        String resourceGroupName, String monitorName, NewRelicMonitorResourceInner resource);

    /**
     * Create a NewRelicMonitorResource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param resource Resource create parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of a Monitor Resource by NewRelic.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<NewRelicMonitorResourceInner>, NewRelicMonitorResourceInner> beginCreateOrUpdate(
        String resourceGroupName, String monitorName, NewRelicMonitorResourceInner resource, Context context);

    /**
     * Create a NewRelicMonitorResource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param resource Resource create parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Monitor Resource by NewRelic.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    NewRelicMonitorResourceInner createOrUpdate(
        String resourceGroupName, String monitorName, NewRelicMonitorResourceInner resource);

    /**
     * Create a NewRelicMonitorResource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param resource Resource create parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Monitor Resource by NewRelic.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    NewRelicMonitorResourceInner createOrUpdate(
        String resourceGroupName, String monitorName, NewRelicMonitorResourceInner resource, Context context);

    /**
     * Update a NewRelicMonitorResource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param properties The resource properties to be updated.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Monitor Resource by NewRelic along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<NewRelicMonitorResourceInner> updateWithResponse(
        String resourceGroupName, String monitorName, NewRelicMonitorResourceUpdate properties, Context context);

    /**
     * Update a NewRelicMonitorResource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param properties The resource properties to be updated.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Monitor Resource by NewRelic.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    NewRelicMonitorResourceInner update(
        String resourceGroupName, String monitorName, NewRelicMonitorResourceUpdate properties);

    /**
     * Delete a NewRelicMonitorResource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param userEmail User Email.
     * @param monitorName Name of the Monitors resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String userEmail, String monitorName);

    /**
     * Delete a NewRelicMonitorResource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param userEmail User Email.
     * @param monitorName Name of the Monitors resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(
        String resourceGroupName, String userEmail, String monitorName, Context context);

    /**
     * Delete a NewRelicMonitorResource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param userEmail User Email.
     * @param monitorName Name of the Monitors resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String userEmail, String monitorName);

    /**
     * Delete a NewRelicMonitorResource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param userEmail User Email.
     * @param monitorName Name of the Monitors resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String userEmail, String monitorName, Context context);

    /**
     * Get metric rules.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param request The details of the get metrics status request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return metric rules along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<MetricRulesInner> getMetricRulesWithResponse(
        String resourceGroupName, String monitorName, MetricsRequest request, Context context);

    /**
     * Get metric rules.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param request The details of the get metrics status request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return metric rules.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    MetricRulesInner getMetricRules(String resourceGroupName, String monitorName, MetricsRequest request);

    /**
     * Get metric status.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param request The details of the get metrics status request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return metric status along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<MetricsStatusResponseInner> getMetricStatusWithResponse(
        String resourceGroupName, String monitorName, MetricsStatusRequest request, Context context);

    /**
     * Get metric status.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param request The details of the get metrics status request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return metric status.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    MetricsStatusResponseInner getMetricStatus(
        String resourceGroupName, String monitorName, MetricsStatusRequest request);

    /**
     * List the app service resources currently being monitored by the NewRelic resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param request The details of the app services get request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list app services Operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<AppServiceInfoInner> listAppServices(
        String resourceGroupName, String monitorName, AppServicesGetRequest request);

    /**
     * List the app service resources currently being monitored by the NewRelic resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param request The details of the app services get request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list app services Operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<AppServiceInfoInner> listAppServices(
        String resourceGroupName, String monitorName, AppServicesGetRequest request, Context context);

    /**
     * Switches the billing for NewRelic monitor resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param request The details of the switch billing request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> switchBillingWithResponse(
        String resourceGroupName, String monitorName, SwitchBillingRequest request, Context context);

    /**
     * Switches the billing for NewRelic monitor resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param request The details of the switch billing request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void switchBilling(String resourceGroupName, String monitorName, SwitchBillingRequest request);

    /**
     * List the compute vm resources currently being monitored by the NewRelic resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param request The details of the Hosts get request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list VM Host Operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<VMInfoInner> listHosts(String resourceGroupName, String monitorName, HostsGetRequest request);

    /**
     * List the compute vm resources currently being monitored by the NewRelic resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param request The details of the Hosts get request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of a list VM Host Operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<VMInfoInner> listHosts(
        String resourceGroupName, String monitorName, HostsGetRequest request, Context context);

    /**
     * List the resources currently being monitored by the NewRelic monitor resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return list of all the resources being monitored by NewRelic monitor resource as paginated response with {@link
     *     PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<MonitoredResourceInner> listMonitoredResources(String resourceGroupName, String monitorName);

    /**
     * List the resources currently being monitored by the NewRelic monitor resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return list of all the resources being monitored by NewRelic monitor resource as paginated response with {@link
     *     PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<MonitoredResourceInner> listMonitoredResources(
        String resourceGroupName, String monitorName, Context context);

    /**
     * Returns the payload that needs to be passed in the request body for installing NewRelic agent on a VM.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of payload to be passed while installing VM agent along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<VMExtensionPayloadInner> vmHostPayloadWithResponse(
        String resourceGroupName, String monitorName, Context context);

    /**
     * Returns the payload that needs to be passed in the request body for installing NewRelic agent on a VM.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the Monitors resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response of payload to be passed while installing VM agent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    VMExtensionPayloadInner vmHostPayload(String resourceGroupName, String monitorName);
}