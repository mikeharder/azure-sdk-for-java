// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.implementation;

import com.azure.analytics.synapse.artifacts.models.ArtifactRenameRequest;
import com.azure.analytics.synapse.artifacts.models.CloudErrorException;
import com.azure.analytics.synapse.artifacts.models.SqlScriptResource;
import com.azure.analytics.synapse.artifacts.models.SqlScriptsListResponse;
import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.Delete;
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
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in SqlScripts.
 */
public final class SqlScriptsImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final SqlScriptsService service;

    /**
     * The service client containing this operation class.
     */
    private final ArtifactsClientImpl client;

    /**
     * Initializes an instance of SqlScriptsImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    SqlScriptsImpl(ArtifactsClientImpl client) {
        this.service
            = RestProxy.create(SqlScriptsService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for ArtifactsClientSqlScripts to be used by the proxy service to perform
     * REST calls.
     */
    @Host("{endpoint}")
    @ServiceInterface(name = "ArtifactsClientSqlScripts")
    public interface SqlScriptsService {
        @Get("/sqlScripts")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<SqlScriptsListResponse>> getSqlScriptsByWorkspace(@HostParam("endpoint") String endpoint,
            @QueryParam("api-version") String apiVersion, @HeaderParam("Accept") String accept, Context context);

        @Put("/sqlScripts/{sqlScriptName}")
        @ExpectedResponses({ 200, 202 })
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<SqlScriptResource>> createOrUpdateSqlScript(@HostParam("endpoint") String endpoint,
            @PathParam("sqlScriptName") String sqlScriptName, @QueryParam("api-version") String apiVersion,
            @HeaderParam("If-Match") String ifMatch, @BodyParam("application/json") SqlScriptResource sqlScript,
            @HeaderParam("Accept") String accept, Context context);

        @Get("/sqlScripts/{sqlScriptName}")
        @ExpectedResponses({ 200, 304 })
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<SqlScriptResource>> getSqlScript(@HostParam("endpoint") String endpoint,
            @PathParam("sqlScriptName") String sqlScriptName, @QueryParam("api-version") String apiVersion,
            @HeaderParam("If-None-Match") String ifNoneMatch, @HeaderParam("Accept") String accept, Context context);

        @Delete("/sqlScripts/{sqlScriptName}")
        @ExpectedResponses({ 200, 202, 204 })
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<Void>> deleteSqlScript(@HostParam("endpoint") String endpoint,
            @PathParam("sqlScriptName") String sqlScriptName, @QueryParam("api-version") String apiVersion,
            @HeaderParam("Accept") String accept, Context context);

        @Post("/sqlScripts/{sqlScriptName}/rename")
        @ExpectedResponses({ 200, 202 })
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<Void>> renameSqlScript(@HostParam("endpoint") String endpoint,
            @PathParam("sqlScriptName") String sqlScriptName, @QueryParam("api-version") String apiVersion,
            @BodyParam("application/json") ArtifactRenameRequest request, @HeaderParam("Accept") String accept,
            Context context);

        @Get("{nextLink}")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<SqlScriptsListResponse>> getSqlScriptsByWorkspaceNext(
            @PathParam(value = "nextLink", encoded = true) String nextLink, @HostParam("endpoint") String endpoint,
            @HeaderParam("Accept") String accept, Context context);
    }

    /**
     * Lists sql scripts.
     * 
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of sql scripts resources along with {@link PagedResponse} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<SqlScriptResource>> getSqlScriptsByWorkspaceSinglePageAsync() {
        final String apiVersion = "2020-12-01";
        final String accept = "application/json";
        return FluxUtil
            .withContext(
                context -> service.getSqlScriptsByWorkspace(this.client.getEndpoint(), apiVersion, accept, context))
            .map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(),
                res.getValue().getValue(), res.getValue().getNextLink(), null));
    }

    /**
     * Lists sql scripts.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of sql scripts resources along with {@link PagedResponse} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<SqlScriptResource>> getSqlScriptsByWorkspaceSinglePageAsync(Context context) {
        final String apiVersion = "2020-12-01";
        final String accept = "application/json";
        return service.getSqlScriptsByWorkspace(this.client.getEndpoint(), apiVersion, accept, context)
            .map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(),
                res.getValue().getValue(), res.getValue().getNextLink(), null));
    }

    /**
     * Lists sql scripts.
     * 
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of sql scripts resources as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<SqlScriptResource> getSqlScriptsByWorkspaceAsync() {
        return new PagedFlux<>(() -> getSqlScriptsByWorkspaceSinglePageAsync(),
            nextLink -> getSqlScriptsByWorkspaceNextSinglePageAsync(nextLink));
    }

    /**
     * Lists sql scripts.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of sql scripts resources as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<SqlScriptResource> getSqlScriptsByWorkspaceAsync(Context context) {
        return new PagedFlux<>(() -> getSqlScriptsByWorkspaceSinglePageAsync(context),
            nextLink -> getSqlScriptsByWorkspaceNextSinglePageAsync(nextLink, context));
    }

    /**
     * Lists sql scripts.
     * 
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of sql scripts resources along with {@link PagedResponse}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public PagedResponse<SqlScriptResource> getSqlScriptsByWorkspaceSinglePage() {
        return getSqlScriptsByWorkspaceSinglePageAsync().block();
    }

    /**
     * Lists sql scripts.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of sql scripts resources along with {@link PagedResponse}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public PagedResponse<SqlScriptResource> getSqlScriptsByWorkspaceSinglePage(Context context) {
        return getSqlScriptsByWorkspaceSinglePageAsync(context).block();
    }

    /**
     * Lists sql scripts.
     * 
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of sql scripts resources as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<SqlScriptResource> getSqlScriptsByWorkspace() {
        return new PagedIterable<>(getSqlScriptsByWorkspaceAsync());
    }

    /**
     * Lists sql scripts.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of sql scripts resources as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<SqlScriptResource> getSqlScriptsByWorkspace(Context context) {
        return new PagedIterable<>(getSqlScriptsByWorkspaceAsync(context));
    }

    /**
     * Creates or updates a Sql Script.
     * 
     * @param sqlScriptName The sql script name.
     * @param sqlScript Sql Script resource definition.
     * @param ifMatch ETag of the SQL script entity. Should only be specified for update, for which it should match
     * existing entity or can be * for unconditional update.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sql Script resource type along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<SqlScriptResource>> createOrUpdateSqlScriptWithResponseAsync(String sqlScriptName,
        SqlScriptResource sqlScript, String ifMatch) {
        return FluxUtil.withContext(
            context -> createOrUpdateSqlScriptWithResponseAsync(sqlScriptName, sqlScript, ifMatch, context));
    }

    /**
     * Creates or updates a Sql Script.
     * 
     * @param sqlScriptName The sql script name.
     * @param sqlScript Sql Script resource definition.
     * @param ifMatch ETag of the SQL script entity. Should only be specified for update, for which it should match
     * existing entity or can be * for unconditional update.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sql Script resource type along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<SqlScriptResource>> createOrUpdateSqlScriptWithResponseAsync(String sqlScriptName,
        SqlScriptResource sqlScript, String ifMatch, Context context) {
        final String apiVersion = "2020-12-01";
        final String accept = "application/json";
        return service.createOrUpdateSqlScript(this.client.getEndpoint(), sqlScriptName, apiVersion, ifMatch, sqlScript,
            accept, context);
    }

    /**
     * Creates or updates a Sql Script.
     * 
     * @param sqlScriptName The sql script name.
     * @param sqlScript Sql Script resource definition.
     * @param ifMatch ETag of the SQL script entity. Should only be specified for update, for which it should match
     * existing entity or can be * for unconditional update.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sql Script resource type on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SqlScriptResource> createOrUpdateSqlScriptAsync(String sqlScriptName, SqlScriptResource sqlScript,
        String ifMatch) {
        return createOrUpdateSqlScriptWithResponseAsync(sqlScriptName, sqlScript, ifMatch)
            .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Creates or updates a Sql Script.
     * 
     * @param sqlScriptName The sql script name.
     * @param sqlScript Sql Script resource definition.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sql Script resource type on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SqlScriptResource> createOrUpdateSqlScriptAsync(String sqlScriptName, SqlScriptResource sqlScript) {
        final String ifMatch = null;
        return createOrUpdateSqlScriptWithResponseAsync(sqlScriptName, sqlScript, ifMatch)
            .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Creates or updates a Sql Script.
     * 
     * @param sqlScriptName The sql script name.
     * @param sqlScript Sql Script resource definition.
     * @param ifMatch ETag of the SQL script entity. Should only be specified for update, for which it should match
     * existing entity or can be * for unconditional update.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sql Script resource type on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SqlScriptResource> createOrUpdateSqlScriptAsync(String sqlScriptName, SqlScriptResource sqlScript,
        String ifMatch, Context context) {
        return createOrUpdateSqlScriptWithResponseAsync(sqlScriptName, sqlScript, ifMatch, context)
            .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Creates or updates a Sql Script.
     * 
     * @param sqlScriptName The sql script name.
     * @param sqlScript Sql Script resource definition.
     * @param ifMatch ETag of the SQL script entity. Should only be specified for update, for which it should match
     * existing entity or can be * for unconditional update.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sql Script resource type along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<SqlScriptResource> createOrUpdateSqlScriptWithResponse(String sqlScriptName,
        SqlScriptResource sqlScript, String ifMatch, Context context) {
        return createOrUpdateSqlScriptWithResponseAsync(sqlScriptName, sqlScript, ifMatch, context).block();
    }

    /**
     * Creates or updates a Sql Script.
     * 
     * @param sqlScriptName The sql script name.
     * @param sqlScript Sql Script resource definition.
     * @param ifMatch ETag of the SQL script entity. Should only be specified for update, for which it should match
     * existing entity or can be * for unconditional update.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sql Script resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SqlScriptResource createOrUpdateSqlScript(String sqlScriptName, SqlScriptResource sqlScript,
        String ifMatch) {
        return createOrUpdateSqlScriptWithResponse(sqlScriptName, sqlScript, ifMatch, Context.NONE).getValue();
    }

    /**
     * Creates or updates a Sql Script.
     * 
     * @param sqlScriptName The sql script name.
     * @param sqlScript Sql Script resource definition.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sql Script resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SqlScriptResource createOrUpdateSqlScript(String sqlScriptName, SqlScriptResource sqlScript) {
        final String ifMatch = null;
        return createOrUpdateSqlScriptWithResponse(sqlScriptName, sqlScript, ifMatch, Context.NONE).getValue();
    }

    /**
     * Gets a sql script.
     * 
     * @param sqlScriptName The sql script name.
     * @param ifNoneMatch ETag of the sql compute entity. Should only be specified for get. If the ETag matches the
     * existing entity tag, or if * was provided, then no content will be returned.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a sql script along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<SqlScriptResource>> getSqlScriptWithResponseAsync(String sqlScriptName, String ifNoneMatch) {
        return FluxUtil.withContext(context -> getSqlScriptWithResponseAsync(sqlScriptName, ifNoneMatch, context));
    }

    /**
     * Gets a sql script.
     * 
     * @param sqlScriptName The sql script name.
     * @param ifNoneMatch ETag of the sql compute entity. Should only be specified for get. If the ETag matches the
     * existing entity tag, or if * was provided, then no content will be returned.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a sql script along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<SqlScriptResource>> getSqlScriptWithResponseAsync(String sqlScriptName, String ifNoneMatch,
        Context context) {
        final String apiVersion = "2020-12-01";
        final String accept = "application/json";
        return service.getSqlScript(this.client.getEndpoint(), sqlScriptName, apiVersion, ifNoneMatch, accept, context);
    }

    /**
     * Gets a sql script.
     * 
     * @param sqlScriptName The sql script name.
     * @param ifNoneMatch ETag of the sql compute entity. Should only be specified for get. If the ETag matches the
     * existing entity tag, or if * was provided, then no content will be returned.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a sql script on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SqlScriptResource> getSqlScriptAsync(String sqlScriptName, String ifNoneMatch) {
        return getSqlScriptWithResponseAsync(sqlScriptName, ifNoneMatch)
            .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Gets a sql script.
     * 
     * @param sqlScriptName The sql script name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a sql script on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SqlScriptResource> getSqlScriptAsync(String sqlScriptName) {
        final String ifNoneMatch = null;
        return getSqlScriptWithResponseAsync(sqlScriptName, ifNoneMatch)
            .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Gets a sql script.
     * 
     * @param sqlScriptName The sql script name.
     * @param ifNoneMatch ETag of the sql compute entity. Should only be specified for get. If the ETag matches the
     * existing entity tag, or if * was provided, then no content will be returned.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a sql script on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SqlScriptResource> getSqlScriptAsync(String sqlScriptName, String ifNoneMatch, Context context) {
        return getSqlScriptWithResponseAsync(sqlScriptName, ifNoneMatch, context)
            .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Gets a sql script.
     * 
     * @param sqlScriptName The sql script name.
     * @param ifNoneMatch ETag of the sql compute entity. Should only be specified for get. If the ETag matches the
     * existing entity tag, or if * was provided, then no content will be returned.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a sql script along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<SqlScriptResource> getSqlScriptWithResponse(String sqlScriptName, String ifNoneMatch,
        Context context) {
        return getSqlScriptWithResponseAsync(sqlScriptName, ifNoneMatch, context).block();
    }

    /**
     * Gets a sql script.
     * 
     * @param sqlScriptName The sql script name.
     * @param ifNoneMatch ETag of the sql compute entity. Should only be specified for get. If the ETag matches the
     * existing entity tag, or if * was provided, then no content will be returned.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a sql script.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SqlScriptResource getSqlScript(String sqlScriptName, String ifNoneMatch) {
        return getSqlScriptWithResponse(sqlScriptName, ifNoneMatch, Context.NONE).getValue();
    }

    /**
     * Gets a sql script.
     * 
     * @param sqlScriptName The sql script name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a sql script.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SqlScriptResource getSqlScript(String sqlScriptName) {
        final String ifNoneMatch = null;
        return getSqlScriptWithResponse(sqlScriptName, ifNoneMatch, Context.NONE).getValue();
    }

    /**
     * Deletes a Sql Script.
     * 
     * @param sqlScriptName The sql script name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteSqlScriptWithResponseAsync(String sqlScriptName) {
        return FluxUtil.withContext(context -> deleteSqlScriptWithResponseAsync(sqlScriptName, context));
    }

    /**
     * Deletes a Sql Script.
     * 
     * @param sqlScriptName The sql script name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteSqlScriptWithResponseAsync(String sqlScriptName, Context context) {
        final String apiVersion = "2020-12-01";
        final String accept = "application/json";
        return service.deleteSqlScript(this.client.getEndpoint(), sqlScriptName, apiVersion, accept, context);
    }

    /**
     * Deletes a Sql Script.
     * 
     * @param sqlScriptName The sql script name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteSqlScriptAsync(String sqlScriptName) {
        return deleteSqlScriptWithResponseAsync(sqlScriptName).flatMap(ignored -> Mono.empty());
    }

    /**
     * Deletes a Sql Script.
     * 
     * @param sqlScriptName The sql script name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteSqlScriptAsync(String sqlScriptName, Context context) {
        return deleteSqlScriptWithResponseAsync(sqlScriptName, context).flatMap(ignored -> Mono.empty());
    }

    /**
     * Deletes a Sql Script.
     * 
     * @param sqlScriptName The sql script name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> deleteSqlScriptWithResponse(String sqlScriptName, Context context) {
        return deleteSqlScriptWithResponseAsync(sqlScriptName, context).block();
    }

    /**
     * Deletes a Sql Script.
     * 
     * @param sqlScriptName The sql script name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void deleteSqlScript(String sqlScriptName) {
        deleteSqlScriptWithResponse(sqlScriptName, Context.NONE);
    }

    /**
     * Renames a sqlScript.
     * 
     * @param sqlScriptName The sql script name.
     * @param request proposed new name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> renameSqlScriptWithResponseAsync(String sqlScriptName, ArtifactRenameRequest request) {
        return FluxUtil.withContext(context -> renameSqlScriptWithResponseAsync(sqlScriptName, request, context));
    }

    /**
     * Renames a sqlScript.
     * 
     * @param sqlScriptName The sql script name.
     * @param request proposed new name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> renameSqlScriptWithResponseAsync(String sqlScriptName, ArtifactRenameRequest request,
        Context context) {
        final String apiVersion = "2020-12-01";
        final String accept = "application/json";
        return service.renameSqlScript(this.client.getEndpoint(), sqlScriptName, apiVersion, request, accept, context);
    }

    /**
     * Renames a sqlScript.
     * 
     * @param sqlScriptName The sql script name.
     * @param request proposed new name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> renameSqlScriptAsync(String sqlScriptName, ArtifactRenameRequest request) {
        return renameSqlScriptWithResponseAsync(sqlScriptName, request).flatMap(ignored -> Mono.empty());
    }

    /**
     * Renames a sqlScript.
     * 
     * @param sqlScriptName The sql script name.
     * @param request proposed new name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> renameSqlScriptAsync(String sqlScriptName, ArtifactRenameRequest request, Context context) {
        return renameSqlScriptWithResponseAsync(sqlScriptName, request, context).flatMap(ignored -> Mono.empty());
    }

    /**
     * Renames a sqlScript.
     * 
     * @param sqlScriptName The sql script name.
     * @param request proposed new name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> renameSqlScriptWithResponse(String sqlScriptName, ArtifactRenameRequest request,
        Context context) {
        return renameSqlScriptWithResponseAsync(sqlScriptName, request, context).block();
    }

    /**
     * Renames a sqlScript.
     * 
     * @param sqlScriptName The sql script name.
     * @param request proposed new name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void renameSqlScript(String sqlScriptName, ArtifactRenameRequest request) {
        renameSqlScriptWithResponse(sqlScriptName, request, Context.NONE);
    }

    /**
     * Get the next page of items.
     * 
     * @param nextLink The URL to get the next list of items.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of sql scripts resources along with {@link PagedResponse} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<SqlScriptResource>> getSqlScriptsByWorkspaceNextSinglePageAsync(String nextLink) {
        final String accept = "application/json";
        return FluxUtil
            .withContext(
                context -> service.getSqlScriptsByWorkspaceNext(nextLink, this.client.getEndpoint(), accept, context))
            .map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(),
                res.getValue().getValue(), res.getValue().getNextLink(), null));
    }

    /**
     * Get the next page of items.
     * 
     * @param nextLink The URL to get the next list of items.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of sql scripts resources along with {@link PagedResponse} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<SqlScriptResource>> getSqlScriptsByWorkspaceNextSinglePageAsync(String nextLink,
        Context context) {
        final String accept = "application/json";
        return service.getSqlScriptsByWorkspaceNext(nextLink, this.client.getEndpoint(), accept, context)
            .map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(),
                res.getValue().getValue(), res.getValue().getNextLink(), null));
    }

    /**
     * Get the next page of items.
     * 
     * @param nextLink The URL to get the next list of items.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of sql scripts resources along with {@link PagedResponse}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public PagedResponse<SqlScriptResource> getSqlScriptsByWorkspaceNextSinglePage(String nextLink) {
        return getSqlScriptsByWorkspaceNextSinglePageAsync(nextLink).block();
    }

    /**
     * Get the next page of items.
     * 
     * @param nextLink The URL to get the next list of items.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of sql scripts resources along with {@link PagedResponse}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public PagedResponse<SqlScriptResource> getSqlScriptsByWorkspaceNextSinglePage(String nextLink, Context context) {
        return getSqlScriptsByWorkspaceNextSinglePageAsync(nextLink, context).block();
    }
}
