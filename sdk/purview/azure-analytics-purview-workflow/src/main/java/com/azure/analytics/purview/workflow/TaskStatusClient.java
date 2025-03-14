// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.purview.workflow;

import com.azure.analytics.purview.workflow.implementation.TaskStatusImpl;
import com.azure.core.annotation.Generated;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.exception.ClientAuthenticationException;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceModifiedException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.util.BinaryData;

/**
 * Initializes a new instance of the synchronous PurviewWorkflowClient type.
 */
@ServiceClient(builder = TaskStatusClientBuilder.class)
public final class TaskStatusClient {
    @Generated
    private final TaskStatusImpl serviceClient;

    /**
     * Initializes an instance of TaskStatusClient class.
     * 
     * @param serviceClient the service client implementation.
     */
    @Generated
    TaskStatusClient(TaskStatusImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * Update the status of a workflow task request.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     newStatus: String(NotStarted/InProgress/Completed/Canceled) (Required)
     *     comment: String (Optional)
     * }
     * }
     * </pre>
     * 
     * @param taskId The task id.
     * @param taskUpdateCommand Request body of updating workflow task request.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> updateWithResponse(String taskId, BinaryData taskUpdateCommand,
        RequestOptions requestOptions) {
        return this.serviceClient.updateWithResponse(taskId, taskUpdateCommand, requestOptions);
    }
}
