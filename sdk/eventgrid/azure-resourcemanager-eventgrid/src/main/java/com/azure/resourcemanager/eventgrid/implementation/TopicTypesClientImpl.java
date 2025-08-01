// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.implementation;

import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Headers;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
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
import com.azure.core.management.exception.ManagementException;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.eventgrid.fluent.TopicTypesClient;
import com.azure.resourcemanager.eventgrid.fluent.models.EventTypeInner;
import com.azure.resourcemanager.eventgrid.fluent.models.TopicTypeInfoInner;
import com.azure.resourcemanager.eventgrid.models.EventTypesListResult;
import com.azure.resourcemanager.eventgrid.models.TopicTypesListResult;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in TopicTypesClient.
 */
public final class TopicTypesClientImpl implements TopicTypesClient {
    /**
     * The proxy service used to perform REST calls.
     */
    private final TopicTypesService service;

    /**
     * The service client containing this operation class.
     */
    private final EventGridManagementClientImpl client;

    /**
     * Initializes an instance of TopicTypesClientImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    TopicTypesClientImpl(EventGridManagementClientImpl client) {
        this.service
            = RestProxy.create(TopicTypesService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for EventGridManagementClientTopicTypes to be used by the proxy service
     * to perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "EventGridManagementClientTopicTypes")
    public interface TopicTypesService {
        @Headers({ "Content-Type: application/json" })
        @Get("/providers/Microsoft.EventGrid/topicTypes")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<TopicTypesListResult>> list(@HostParam("$host") String endpoint,
            @QueryParam("api-version") String apiVersion, @HeaderParam("Accept") String accept, Context context);

        @Headers({ "Content-Type: application/json" })
        @Get("/providers/Microsoft.EventGrid/topicTypes")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Response<TopicTypesListResult> listSync(@HostParam("$host") String endpoint,
            @QueryParam("api-version") String apiVersion, @HeaderParam("Accept") String accept, Context context);

        @Headers({ "Content-Type: application/json" })
        @Get("/providers/Microsoft.EventGrid/topicTypes/{topicTypeName}")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<TopicTypeInfoInner>> get(@HostParam("$host") String endpoint,
            @PathParam("topicTypeName") String topicTypeName, @QueryParam("api-version") String apiVersion,
            @HeaderParam("Accept") String accept, Context context);

        @Headers({ "Content-Type: application/json" })
        @Get("/providers/Microsoft.EventGrid/topicTypes/{topicTypeName}")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Response<TopicTypeInfoInner> getSync(@HostParam("$host") String endpoint,
            @PathParam("topicTypeName") String topicTypeName, @QueryParam("api-version") String apiVersion,
            @HeaderParam("Accept") String accept, Context context);

        @Headers({ "Content-Type: application/json" })
        @Get("/providers/Microsoft.EventGrid/topicTypes/{topicTypeName}/eventTypes")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<EventTypesListResult>> listEventTypes(@HostParam("$host") String endpoint,
            @PathParam("topicTypeName") String topicTypeName, @QueryParam("api-version") String apiVersion,
            @HeaderParam("Accept") String accept, Context context);

        @Headers({ "Content-Type: application/json" })
        @Get("/providers/Microsoft.EventGrid/topicTypes/{topicTypeName}/eventTypes")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Response<EventTypesListResult> listEventTypesSync(@HostParam("$host") String endpoint,
            @PathParam("topicTypeName") String topicTypeName, @QueryParam("api-version") String apiVersion,
            @HeaderParam("Accept") String accept, Context context);
    }

    /**
     * List topic types.
     * 
     * List all registered topic types.
     * 
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the List Topic Types operation along with {@link PagedResponse} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<PagedResponse<TopicTypeInfoInner>> listSinglePageAsync() {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(
                context -> service.list(this.client.getEndpoint(), this.client.getApiVersion(), accept, context))
            .<PagedResponse<TopicTypeInfoInner>>map(res -> new PagedResponseBase<>(res.getRequest(),
                res.getStatusCode(), res.getHeaders(), res.getValue().value(), null, null))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * List topic types.
     * 
     * List all registered topic types.
     * 
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the List Topic Types operation as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    private PagedFlux<TopicTypeInfoInner> listAsync() {
        return new PagedFlux<>(() -> listSinglePageAsync());
    }

    /**
     * List topic types.
     * 
     * List all registered topic types.
     * 
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the List Topic Types operation along with {@link PagedResponse}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private PagedResponse<TopicTypeInfoInner> listSinglePage() {
        if (this.client.getEndpoint() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        final String accept = "application/json";
        Response<TopicTypesListResult> res
            = service.listSync(this.client.getEndpoint(), this.client.getApiVersion(), accept, Context.NONE);
        return new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(), res.getValue().value(),
            null, null);
    }

    /**
     * List topic types.
     * 
     * List all registered topic types.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the List Topic Types operation along with {@link PagedResponse}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private PagedResponse<TopicTypeInfoInner> listSinglePage(Context context) {
        if (this.client.getEndpoint() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        final String accept = "application/json";
        Response<TopicTypesListResult> res
            = service.listSync(this.client.getEndpoint(), this.client.getApiVersion(), accept, context);
        return new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(), res.getValue().value(),
            null, null);
    }

    /**
     * List topic types.
     * 
     * List all registered topic types.
     * 
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the List Topic Types operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<TopicTypeInfoInner> list() {
        return new PagedIterable<>(() -> listSinglePage());
    }

    /**
     * List topic types.
     * 
     * List all registered topic types.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the List Topic Types operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<TopicTypeInfoInner> list(Context context) {
        return new PagedIterable<>(() -> listSinglePage(context));
    }

    /**
     * Get a topic type.
     * 
     * Get information about a topic type.
     * 
     * @param topicTypeName Name of the topic type.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return information about a topic type along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<TopicTypeInfoInner>> getWithResponseAsync(String topicTypeName) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (topicTypeName == null) {
            return Mono.error(new IllegalArgumentException("Parameter topicTypeName is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.get(this.client.getEndpoint(), topicTypeName, this.client.getApiVersion(),
                accept, context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Get a topic type.
     * 
     * Get information about a topic type.
     * 
     * @param topicTypeName Name of the topic type.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return information about a topic type on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<TopicTypeInfoInner> getAsync(String topicTypeName) {
        return getWithResponseAsync(topicTypeName).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get a topic type.
     * 
     * Get information about a topic type.
     * 
     * @param topicTypeName Name of the topic type.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return information about a topic type along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<TopicTypeInfoInner> getWithResponse(String topicTypeName, Context context) {
        if (this.client.getEndpoint() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (topicTypeName == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Parameter topicTypeName is required and cannot be null."));
        }
        final String accept = "application/json";
        return service.getSync(this.client.getEndpoint(), topicTypeName, this.client.getApiVersion(), accept, context);
    }

    /**
     * Get a topic type.
     * 
     * Get information about a topic type.
     * 
     * @param topicTypeName Name of the topic type.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return information about a topic type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public TopicTypeInfoInner get(String topicTypeName) {
        return getWithResponse(topicTypeName, Context.NONE).getValue();
    }

    /**
     * List event types.
     * 
     * List event types for a topic type.
     * 
     * @param topicTypeName Name of the topic type.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the List Event Types operation along with {@link PagedResponse} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<PagedResponse<EventTypeInner>> listEventTypesSinglePageAsync(String topicTypeName) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (topicTypeName == null) {
            return Mono.error(new IllegalArgumentException("Parameter topicTypeName is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.listEventTypes(this.client.getEndpoint(), topicTypeName,
                this.client.getApiVersion(), accept, context))
            .<PagedResponse<EventTypeInner>>map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(),
                res.getHeaders(), res.getValue().value(), null, null))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * List event types.
     * 
     * List event types for a topic type.
     * 
     * @param topicTypeName Name of the topic type.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the List Event Types operation as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    private PagedFlux<EventTypeInner> listEventTypesAsync(String topicTypeName) {
        return new PagedFlux<>(() -> listEventTypesSinglePageAsync(topicTypeName));
    }

    /**
     * List event types.
     * 
     * List event types for a topic type.
     * 
     * @param topicTypeName Name of the topic type.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the List Event Types operation along with {@link PagedResponse}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private PagedResponse<EventTypeInner> listEventTypesSinglePage(String topicTypeName) {
        if (this.client.getEndpoint() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (topicTypeName == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Parameter topicTypeName is required and cannot be null."));
        }
        final String accept = "application/json";
        Response<EventTypesListResult> res = service.listEventTypesSync(this.client.getEndpoint(), topicTypeName,
            this.client.getApiVersion(), accept, Context.NONE);
        return new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(), res.getValue().value(),
            null, null);
    }

    /**
     * List event types.
     * 
     * List event types for a topic type.
     * 
     * @param topicTypeName Name of the topic type.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the List Event Types operation along with {@link PagedResponse}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private PagedResponse<EventTypeInner> listEventTypesSinglePage(String topicTypeName, Context context) {
        if (this.client.getEndpoint() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (topicTypeName == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Parameter topicTypeName is required and cannot be null."));
        }
        final String accept = "application/json";
        Response<EventTypesListResult> res = service.listEventTypesSync(this.client.getEndpoint(), topicTypeName,
            this.client.getApiVersion(), accept, context);
        return new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(), res.getValue().value(),
            null, null);
    }

    /**
     * List event types.
     * 
     * List event types for a topic type.
     * 
     * @param topicTypeName Name of the topic type.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the List Event Types operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<EventTypeInner> listEventTypes(String topicTypeName) {
        return new PagedIterable<>(() -> listEventTypesSinglePage(topicTypeName));
    }

    /**
     * List event types.
     * 
     * List event types for a topic type.
     * 
     * @param topicTypeName Name of the topic type.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the List Event Types operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<EventTypeInner> listEventTypes(String topicTypeName, Context context) {
        return new PagedIterable<>(() -> listEventTypesSinglePage(topicTypeName, context));
    }

    private static final ClientLogger LOGGER = new ClientLogger(TopicTypesClientImpl.class);
}
