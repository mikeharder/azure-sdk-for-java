// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.computeschedule.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/**
 * Resource collection API of ScheduledActions.
 */
public interface ScheduledActions {
    /**
     * VirtualMachinesSubmitDeallocate: Schedule deallocate operation for a batch of virtual machines at datetime in
     * future.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from a deallocate request along with {@link Response}.
     */
    Response<DeallocateResourceOperationResponse> virtualMachinesSubmitDeallocateWithResponse(String locationparameter,
        SubmitDeallocateRequest requestBody, Context context);

    /**
     * VirtualMachinesSubmitDeallocate: Schedule deallocate operation for a batch of virtual machines at datetime in
     * future.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from a deallocate request.
     */
    DeallocateResourceOperationResponse virtualMachinesSubmitDeallocate(String locationparameter,
        SubmitDeallocateRequest requestBody);

    /**
     * VirtualMachinesSubmitHibernate: Schedule hibernate operation for a batch of virtual machines at datetime in
     * future.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from a Hibernate request along with {@link Response}.
     */
    Response<HibernateResourceOperationResponse> virtualMachinesSubmitHibernateWithResponse(String locationparameter,
        SubmitHibernateRequest requestBody, Context context);

    /**
     * VirtualMachinesSubmitHibernate: Schedule hibernate operation for a batch of virtual machines at datetime in
     * future.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from a Hibernate request.
     */
    HibernateResourceOperationResponse virtualMachinesSubmitHibernate(String locationparameter,
        SubmitHibernateRequest requestBody);

    /**
     * VirtualMachinesSubmitStart: Schedule start operation for a batch of virtual machines at datetime in future.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from a start request along with {@link Response}.
     */
    Response<StartResourceOperationResponse> virtualMachinesSubmitStartWithResponse(String locationparameter,
        SubmitStartRequest requestBody, Context context);

    /**
     * VirtualMachinesSubmitStart: Schedule start operation for a batch of virtual machines at datetime in future.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from a start request.
     */
    StartResourceOperationResponse virtualMachinesSubmitStart(String locationparameter, SubmitStartRequest requestBody);

    /**
     * VirtualMachinesExecuteDeallocate: Execute deallocate operation for a batch of virtual machines, this operation is
     * triggered as soon as Computeschedule receives it.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from a deallocate request along with {@link Response}.
     */
    Response<DeallocateResourceOperationResponse> virtualMachinesExecuteDeallocateWithResponse(String locationparameter,
        ExecuteDeallocateRequest requestBody, Context context);

    /**
     * VirtualMachinesExecuteDeallocate: Execute deallocate operation for a batch of virtual machines, this operation is
     * triggered as soon as Computeschedule receives it.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from a deallocate request.
     */
    DeallocateResourceOperationResponse virtualMachinesExecuteDeallocate(String locationparameter,
        ExecuteDeallocateRequest requestBody);

    /**
     * VirtualMachinesExecuteHibernate: Execute hibernate operation for a batch of virtual machines, this operation is
     * triggered as soon as Computeschedule receives it.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from a Hibernate request along with {@link Response}.
     */
    Response<HibernateResourceOperationResponse> virtualMachinesExecuteHibernateWithResponse(String locationparameter,
        ExecuteHibernateRequest requestBody, Context context);

    /**
     * VirtualMachinesExecuteHibernate: Execute hibernate operation for a batch of virtual machines, this operation is
     * triggered as soon as Computeschedule receives it.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from a Hibernate request.
     */
    HibernateResourceOperationResponse virtualMachinesExecuteHibernate(String locationparameter,
        ExecuteHibernateRequest requestBody);

    /**
     * VirtualMachinesExecuteStart: Execute start operation for a batch of virtual machines, this operation is triggered
     * as soon as Computeschedule receives it.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from a start request along with {@link Response}.
     */
    Response<StartResourceOperationResponse> virtualMachinesExecuteStartWithResponse(String locationparameter,
        ExecuteStartRequest requestBody, Context context);

    /**
     * VirtualMachinesExecuteStart: Execute start operation for a batch of virtual machines, this operation is triggered
     * as soon as Computeschedule receives it.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from a start request.
     */
    StartResourceOperationResponse virtualMachinesExecuteStart(String locationparameter,
        ExecuteStartRequest requestBody);

    /**
     * VirtualMachinesExecuteCreate: Execute create operation for a batch of virtual machines, this operation is
     * triggered as soon as Computeschedule receives it.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from a create request along with {@link Response}.
     */
    Response<CreateResourceOperationResponse> virtualMachinesExecuteCreateWithResponse(String locationparameter,
        ExecuteCreateRequest requestBody, Context context);

    /**
     * VirtualMachinesExecuteCreate: Execute create operation for a batch of virtual machines, this operation is
     * triggered as soon as Computeschedule receives it.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from a create request.
     */
    CreateResourceOperationResponse virtualMachinesExecuteCreate(String locationparameter,
        ExecuteCreateRequest requestBody);

    /**
     * VirtualMachinesExecuteDelete: Execute delete operation for a batch of virtual machines, this operation is
     * triggered as soon as Computeschedule receives it.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from a delete request along with {@link Response}.
     */
    Response<DeleteResourceOperationResponse> virtualMachinesExecuteDeleteWithResponse(String locationparameter,
        ExecuteDeleteRequest requestBody, Context context);

    /**
     * VirtualMachinesExecuteDelete: Execute delete operation for a batch of virtual machines, this operation is
     * triggered as soon as Computeschedule receives it.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from a delete request.
     */
    DeleteResourceOperationResponse virtualMachinesExecuteDelete(String locationparameter,
        ExecuteDeleteRequest requestBody);

    /**
     * VirtualMachinesGetOperationStatus: Polling endpoint to read status of operations performed on virtual machines.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return this is the response from a get operations status request along with {@link Response}.
     */
    Response<GetOperationStatusResponse> virtualMachinesGetOperationStatusWithResponse(String locationparameter,
        GetOperationStatusRequest requestBody, Context context);

    /**
     * VirtualMachinesGetOperationStatus: Polling endpoint to read status of operations performed on virtual machines.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return this is the response from a get operations status request.
     */
    GetOperationStatusResponse virtualMachinesGetOperationStatus(String locationparameter,
        GetOperationStatusRequest requestBody);

    /**
     * VirtualMachinesCancelOperations: Cancel a previously submitted (start/deallocate/hibernate) request.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return this is the response from a cancel operations request along with {@link Response}.
     */
    Response<CancelOperationsResponse> virtualMachinesCancelOperationsWithResponse(String locationparameter,
        CancelOperationsRequest requestBody, Context context);

    /**
     * VirtualMachinesCancelOperations: Cancel a previously submitted (start/deallocate/hibernate) request.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return this is the response from a cancel operations request.
     */
    CancelOperationsResponse virtualMachinesCancelOperations(String locationparameter,
        CancelOperationsRequest requestBody);

    /**
     * VirtualMachinesGetOperationErrors: Get error details on operation errors (like transient errors encountered,
     * additional logs) if they exist.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return this is the response from a get operations errors request along with {@link Response}.
     */
    Response<GetOperationErrorsResponse> virtualMachinesGetOperationErrorsWithResponse(String locationparameter,
        GetOperationErrorsRequest requestBody, Context context);

    /**
     * VirtualMachinesGetOperationErrors: Get error details on operation errors (like transient errors encountered,
     * additional logs) if they exist.
     * 
     * @param locationparameter The location name.
     * @param requestBody The request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return this is the response from a get operations errors request.
     */
    GetOperationErrorsResponse virtualMachinesGetOperationErrors(String locationparameter,
        GetOperationErrorsRequest requestBody);

    /**
     * Get a ScheduledAction.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a ScheduledAction along with {@link Response}.
     */
    Response<ScheduledAction> getByResourceGroupWithResponse(String resourceGroupName, String scheduledActionName,
        Context context);

    /**
     * Get a ScheduledAction.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a ScheduledAction.
     */
    ScheduledAction getByResourceGroup(String resourceGroupName, String scheduledActionName);

    /**
     * Delete a ScheduledAction.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteByResourceGroup(String resourceGroupName, String scheduledActionName);

    /**
     * Delete a ScheduledAction.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String scheduledActionName, Context context);

    /**
     * List ScheduledAction resources by resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a ScheduledAction list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ScheduledAction> listByResourceGroup(String resourceGroupName);

    /**
     * List ScheduledAction resources by resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a ScheduledAction list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ScheduledAction> listByResourceGroup(String resourceGroupName, Context context);

    /**
     * List ScheduledAction resources by subscription ID.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a ScheduledAction list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ScheduledAction> list();

    /**
     * List ScheduledAction resources by subscription ID.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a ScheduledAction list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ScheduledAction> list(Context context);

    /**
     * List resources attached to Scheduled Actions.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return paged collection of ScheduledActionResource items as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ScheduledActionResource> listResources(String resourceGroupName, String scheduledActionName);

    /**
     * List resources attached to Scheduled Actions.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return paged collection of ScheduledActionResource items as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ScheduledActionResource> listResources(String resourceGroupName, String scheduledActionName,
        Context context);

    /**
     * A synchronous resource action.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @param body The content of the action request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from scheduled action resource requests, which contains the status of each resource along
     * with {@link Response}.
     */
    Response<RecurringActionsResourceOperationResult> attachResourcesWithResponse(String resourceGroupName,
        String scheduledActionName, ResourceAttachRequest body, Context context);

    /**
     * A synchronous resource action.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @param body The content of the action request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from scheduled action resource requests, which contains the status of each resource.
     */
    RecurringActionsResourceOperationResult attachResources(String resourceGroupName, String scheduledActionName,
        ResourceAttachRequest body);

    /**
     * A synchronous resource action.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @param body The content of the action request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from scheduled action resource requests, which contains the status of each resource along
     * with {@link Response}.
     */
    Response<RecurringActionsResourceOperationResult> detachResourcesWithResponse(String resourceGroupName,
        String scheduledActionName, ResourceDetachRequest body, Context context);

    /**
     * A synchronous resource action.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @param body The content of the action request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from scheduled action resource requests, which contains the status of each resource.
     */
    RecurringActionsResourceOperationResult detachResources(String resourceGroupName, String scheduledActionName,
        ResourceDetachRequest body);

    /**
     * A synchronous resource action.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @param body The content of the action request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from scheduled action resource requests, which contains the status of each resource along
     * with {@link Response}.
     */
    Response<RecurringActionsResourceOperationResult> patchResourcesWithResponse(String resourceGroupName,
        String scheduledActionName, ResourcePatchRequest body, Context context);

    /**
     * A synchronous resource action.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @param body The content of the action request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from scheduled action resource requests, which contains the status of each resource.
     */
    RecurringActionsResourceOperationResult patchResources(String resourceGroupName, String scheduledActionName,
        ResourcePatchRequest body);

    /**
     * A synchronous resource action.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    Response<Void> disableWithResponse(String resourceGroupName, String scheduledActionName, Context context);

    /**
     * A synchronous resource action.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void disable(String resourceGroupName, String scheduledActionName);

    /**
     * A synchronous resource action.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    Response<Void> enableWithResponse(String resourceGroupName, String scheduledActionName, Context context);

    /**
     * A synchronous resource action.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void enable(String resourceGroupName, String scheduledActionName);

    /**
     * A synchronous resource action.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @param body The content of the action request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from scheduled action resource requests, which contains the status of each resource along
     * with {@link Response}.
     */
    Response<RecurringActionsResourceOperationResult> cancelNextOccurrenceWithResponse(String resourceGroupName,
        String scheduledActionName, CancelOccurrenceRequest body, Context context);

    /**
     * A synchronous resource action.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @param body The content of the action request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response from scheduled action resource requests, which contains the status of each resource.
     */
    RecurringActionsResourceOperationResult cancelNextOccurrence(String resourceGroupName, String scheduledActionName,
        CancelOccurrenceRequest body);

    /**
     * A synchronous resource action.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return concrete proxy resource types can be created by aliasing this type using a specific property type along
     * with {@link Response}.
     */
    Response<Occurrence> triggerManualOccurrenceWithResponse(String resourceGroupName, String scheduledActionName,
        Context context);

    /**
     * A synchronous resource action.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scheduledActionName The name of the ScheduledAction.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return concrete proxy resource types can be created by aliasing this type using a specific property type.
     */
    Occurrence triggerManualOccurrence(String resourceGroupName, String scheduledActionName);

    /**
     * Get a ScheduledAction.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a ScheduledAction along with {@link Response}.
     */
    ScheduledAction getById(String id);

    /**
     * Get a ScheduledAction.
     * 
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a ScheduledAction along with {@link Response}.
     */
    Response<ScheduledAction> getByIdWithResponse(String id, Context context);

    /**
     * Delete a ScheduledAction.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteById(String id);

    /**
     * Delete a ScheduledAction.
     * 
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteByIdWithResponse(String id, Context context);

    /**
     * Begins definition for a new ScheduledAction resource.
     * 
     * @param name resource name.
     * @return the first stage of the new ScheduledAction definition.
     */
    ScheduledAction.DefinitionStages.Blank define(String name);
}
