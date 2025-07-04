// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.implementation;

import com.azure.analytics.synapse.artifacts.models.CloudErrorException;
import com.azure.analytics.synapse.artifacts.models.RunNotebookRequest;
import com.azure.analytics.synapse.artifacts.models.RunNotebookResponse;
import com.azure.analytics.synapse.artifacts.models.RunNotebookResponseException;
import com.azure.analytics.synapse.artifacts.models.RunNotebookSnapshotResponse;
import com.azure.analytics.synapse.artifacts.models.RunNotebooksCreateRunHeaders;
import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Post;
import com.azure.core.annotation.Put;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.ResponseBase;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in RunNotebooks.
 */
public final class RunNotebooksImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final RunNotebooksService service;

    /**
     * The service client containing this operation class.
     */
    private final ArtifactsClientImpl client;

    /**
     * Initializes an instance of RunNotebooksImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    RunNotebooksImpl(ArtifactsClientImpl client) {
        this.service
            = RestProxy.create(RunNotebooksService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for ArtifactsClientRunNotebooks to be used by the proxy service to
     * perform REST calls.
     */
    @Host("{endpoint}")
    @ServiceInterface(name = "ArtifactsClientRunNotebooks")
    public interface RunNotebooksService {
        @Put("/notebooks/runs/{runId}")
        @ExpectedResponses({ 202 })
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<ResponseBase<RunNotebooksCreateRunHeaders, RunNotebookResponse>> createRun(
            @HostParam("endpoint") String endpoint, @QueryParam("api-version") String apiVersion,
            @PathParam("runId") String runId, @BodyParam("application/json") RunNotebookRequest runNotebookRequest,
            @HeaderParam("Accept") String accept, Context context);

        @Put("/notebooks/runs/{runId}")
        @ExpectedResponses({ 202 })
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<RunNotebookResponse>> createRunNoCustomHeaders(@HostParam("endpoint") String endpoint,
            @QueryParam("api-version") String apiVersion, @PathParam("runId") String runId,
            @BodyParam("application/json") RunNotebookRequest runNotebookRequest, @HeaderParam("Accept") String accept,
            Context context);

        @Get("/notebooks/runs/{runId}")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<RunNotebookResponse>> getStatus(@HostParam("endpoint") String endpoint,
            @QueryParam("api-version") String apiVersion, @PathParam("runId") String runId,
            @HeaderParam("Accept") String accept, Context context);

        @Post("/notebooks/runs/{runId}/cancel")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(value = RunNotebookResponseException.class, code = { 409 })
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<RunNotebookResponse>> cancelRun(@HostParam("endpoint") String endpoint,
            @QueryParam("api-version") String apiVersion, @PathParam("runId") String runId,
            @HeaderParam("Accept") String accept, Context context);

        @Get("/notebooks/runs/{runId}/snapshot")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<RunNotebookSnapshotResponse>> getSnapshot(@HostParam("endpoint") String endpoint,
            @QueryParam("api-version") String apiVersion, @PathParam("runId") String runId,
            @HeaderParam("Accept") String accept, Context context);
    }

    /**
     * Run notebook.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @param runNotebookRequest Run notebook request payload.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return run notebook response along with {@link ResponseBase} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<ResponseBase<RunNotebooksCreateRunHeaders, RunNotebookResponse>>
        createRunWithResponseAsync(String runId, RunNotebookRequest runNotebookRequest) {
        return FluxUtil.withContext(context -> createRunWithResponseAsync(runId, runNotebookRequest, context));
    }

    /**
     * Run notebook.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @param runNotebookRequest Run notebook request payload.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return run notebook response along with {@link ResponseBase} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<ResponseBase<RunNotebooksCreateRunHeaders, RunNotebookResponse>>
        createRunWithResponseAsync(String runId, RunNotebookRequest runNotebookRequest, Context context) {
        final String apiVersion = "2022-03-01-preview";
        final String accept = "application/json";
        return service.createRun(this.client.getEndpoint(), apiVersion, runId, runNotebookRequest, accept, context);
    }

    /**
     * Run notebook.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @param runNotebookRequest Run notebook request payload.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return run notebook response on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<RunNotebookResponse> createRunAsync(String runId, RunNotebookRequest runNotebookRequest) {
        return createRunWithResponseAsync(runId, runNotebookRequest).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Run notebook.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @param runNotebookRequest Run notebook request payload.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return run notebook response on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<RunNotebookResponse> createRunAsync(String runId, RunNotebookRequest runNotebookRequest,
        Context context) {
        return createRunWithResponseAsync(runId, runNotebookRequest, context)
            .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Run notebook.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @param runNotebookRequest Run notebook request payload.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return run notebook response along with {@link ResponseBase}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ResponseBase<RunNotebooksCreateRunHeaders, RunNotebookResponse> createRunWithResponse(String runId,
        RunNotebookRequest runNotebookRequest, Context context) {
        return createRunWithResponseAsync(runId, runNotebookRequest, context).block();
    }

    /**
     * Run notebook.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @param runNotebookRequest Run notebook request payload.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return run notebook response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public RunNotebookResponse createRun(String runId, RunNotebookRequest runNotebookRequest) {
        return createRunWithResponse(runId, runNotebookRequest, Context.NONE).getValue();
    }

    /**
     * Run notebook.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @param runNotebookRequest Run notebook request payload.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return run notebook response along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<RunNotebookResponse>> createRunNoCustomHeadersWithResponseAsync(String runId,
        RunNotebookRequest runNotebookRequest) {
        return FluxUtil
            .withContext(context -> createRunNoCustomHeadersWithResponseAsync(runId, runNotebookRequest, context));
    }

    /**
     * Run notebook.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @param runNotebookRequest Run notebook request payload.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return run notebook response along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<RunNotebookResponse>> createRunNoCustomHeadersWithResponseAsync(String runId,
        RunNotebookRequest runNotebookRequest, Context context) {
        final String apiVersion = "2022-03-01-preview";
        final String accept = "application/json";
        return service.createRunNoCustomHeaders(this.client.getEndpoint(), apiVersion, runId, runNotebookRequest,
            accept, context);
    }

    /**
     * Run notebook.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @param runNotebookRequest Run notebook request payload.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return run notebook response along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<RunNotebookResponse> createRunNoCustomHeadersWithResponse(String runId,
        RunNotebookRequest runNotebookRequest, Context context) {
        return createRunNoCustomHeadersWithResponseAsync(runId, runNotebookRequest, context).block();
    }

    /**
     * Get RunNotebook Status for run id.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return runNotebook Status for run id along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<RunNotebookResponse>> getStatusWithResponseAsync(String runId) {
        return FluxUtil.withContext(context -> getStatusWithResponseAsync(runId, context));
    }

    /**
     * Get RunNotebook Status for run id.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return runNotebook Status for run id along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<RunNotebookResponse>> getStatusWithResponseAsync(String runId, Context context) {
        final String apiVersion = "2022-03-01-preview";
        final String accept = "application/json";
        return service.getStatus(this.client.getEndpoint(), apiVersion, runId, accept, context);
    }

    /**
     * Get RunNotebook Status for run id.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return runNotebook Status for run id on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<RunNotebookResponse> getStatusAsync(String runId) {
        return getStatusWithResponseAsync(runId).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get RunNotebook Status for run id.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return runNotebook Status for run id on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<RunNotebookResponse> getStatusAsync(String runId, Context context) {
        return getStatusWithResponseAsync(runId, context).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get RunNotebook Status for run id.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return runNotebook Status for run id along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<RunNotebookResponse> getStatusWithResponse(String runId, Context context) {
        return getStatusWithResponseAsync(runId, context).block();
    }

    /**
     * Get RunNotebook Status for run id.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return runNotebook Status for run id.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public RunNotebookResponse getStatus(String runId) {
        return getStatusWithResponse(runId, Context.NONE).getValue();
    }

    /**
     * Cancel notebook run.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RunNotebookResponseException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return run notebook response along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<RunNotebookResponse>> cancelRunWithResponseAsync(String runId) {
        return FluxUtil.withContext(context -> cancelRunWithResponseAsync(runId, context));
    }

    /**
     * Cancel notebook run.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RunNotebookResponseException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return run notebook response along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<RunNotebookResponse>> cancelRunWithResponseAsync(String runId, Context context) {
        final String apiVersion = "2022-03-01-preview";
        final String accept = "application/json";
        return service.cancelRun(this.client.getEndpoint(), apiVersion, runId, accept, context);
    }

    /**
     * Cancel notebook run.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RunNotebookResponseException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return run notebook response on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<RunNotebookResponse> cancelRunAsync(String runId) {
        return cancelRunWithResponseAsync(runId).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Cancel notebook run.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RunNotebookResponseException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return run notebook response on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<RunNotebookResponse> cancelRunAsync(String runId, Context context) {
        return cancelRunWithResponseAsync(runId, context).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Cancel notebook run.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RunNotebookResponseException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return run notebook response along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<RunNotebookResponse> cancelRunWithResponse(String runId, Context context) {
        return cancelRunWithResponseAsync(runId, context).block();
    }

    /**
     * Cancel notebook run.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RunNotebookResponseException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return run notebook response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public RunNotebookResponse cancelRun(String runId) {
        return cancelRunWithResponse(runId, Context.NONE).getValue();
    }

    /**
     * Get RunNotebook Snapshot for run id.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return runNotebook Snapshot for run id along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<RunNotebookSnapshotResponse>> getSnapshotWithResponseAsync(String runId) {
        return FluxUtil.withContext(context -> getSnapshotWithResponseAsync(runId, context));
    }

    /**
     * Get RunNotebook Snapshot for run id.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return runNotebook Snapshot for run id along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<RunNotebookSnapshotResponse>> getSnapshotWithResponseAsync(String runId, Context context) {
        final String apiVersion = "2022-03-01-preview";
        final String accept = "application/json";
        return service.getSnapshot(this.client.getEndpoint(), apiVersion, runId, accept, context);
    }

    /**
     * Get RunNotebook Snapshot for run id.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return runNotebook Snapshot for run id on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<RunNotebookSnapshotResponse> getSnapshotAsync(String runId) {
        return getSnapshotWithResponseAsync(runId).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get RunNotebook Snapshot for run id.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return runNotebook Snapshot for run id on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<RunNotebookSnapshotResponse> getSnapshotAsync(String runId, Context context) {
        return getSnapshotWithResponseAsync(runId, context).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get RunNotebook Snapshot for run id.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return runNotebook Snapshot for run id along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<RunNotebookSnapshotResponse> getSnapshotWithResponse(String runId, Context context) {
        return getSnapshotWithResponseAsync(runId, context).block();
    }

    /**
     * Get RunNotebook Snapshot for run id.
     * 
     * @param runId Notebook run id. For Create Run, you can generate a new GUID and use it here. For other actions,
     * this is the same ID used in Create Run.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return runNotebook Snapshot for run id.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public RunNotebookSnapshotResponse getSnapshot(String runId) {
        return getSnapshotWithResponse(runId, Context.NONE).getValue();
    }
}
