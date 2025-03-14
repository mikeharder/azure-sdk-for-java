// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.eventgrid.fluent.TopicsClient;
import com.azure.resourcemanager.eventgrid.fluent.models.EventTypeInner;
import com.azure.resourcemanager.eventgrid.fluent.models.TopicInner;
import com.azure.resourcemanager.eventgrid.fluent.models.TopicSharedAccessKeysInner;
import com.azure.resourcemanager.eventgrid.models.EventType;
import com.azure.resourcemanager.eventgrid.models.Topic;
import com.azure.resourcemanager.eventgrid.models.TopicRegenerateKeyRequest;
import com.azure.resourcemanager.eventgrid.models.TopicSharedAccessKeys;
import com.azure.resourcemanager.eventgrid.models.Topics;

public final class TopicsImpl implements Topics {
    private static final ClientLogger LOGGER = new ClientLogger(TopicsImpl.class);

    private final TopicsClient innerClient;

    private final com.azure.resourcemanager.eventgrid.EventGridManager serviceManager;

    public TopicsImpl(TopicsClient innerClient, com.azure.resourcemanager.eventgrid.EventGridManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<Topic> getByResourceGroupWithResponse(String resourceGroupName, String topicName, Context context) {
        Response<TopicInner> inner
            = this.serviceClient().getByResourceGroupWithResponse(resourceGroupName, topicName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new TopicImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public Topic getByResourceGroup(String resourceGroupName, String topicName) {
        TopicInner inner = this.serviceClient().getByResourceGroup(resourceGroupName, topicName);
        if (inner != null) {
            return new TopicImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public void deleteByResourceGroup(String resourceGroupName, String topicName) {
        this.serviceClient().delete(resourceGroupName, topicName);
    }

    public void delete(String resourceGroupName, String topicName, Context context) {
        this.serviceClient().delete(resourceGroupName, topicName, context);
    }

    public PagedIterable<Topic> list() {
        PagedIterable<TopicInner> inner = this.serviceClient().list();
        return ResourceManagerUtils.mapPage(inner, inner1 -> new TopicImpl(inner1, this.manager()));
    }

    public PagedIterable<Topic> list(String filter, Integer top, Context context) {
        PagedIterable<TopicInner> inner = this.serviceClient().list(filter, top, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new TopicImpl(inner1, this.manager()));
    }

    public PagedIterable<Topic> listByResourceGroup(String resourceGroupName) {
        PagedIterable<TopicInner> inner = this.serviceClient().listByResourceGroup(resourceGroupName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new TopicImpl(inner1, this.manager()));
    }

    public PagedIterable<Topic> listByResourceGroup(String resourceGroupName, String filter, Integer top,
        Context context) {
        PagedIterable<TopicInner> inner
            = this.serviceClient().listByResourceGroup(resourceGroupName, filter, top, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new TopicImpl(inner1, this.manager()));
    }

    public Response<TopicSharedAccessKeys> listSharedAccessKeysWithResponse(String resourceGroupName, String topicName,
        Context context) {
        Response<TopicSharedAccessKeysInner> inner
            = this.serviceClient().listSharedAccessKeysWithResponse(resourceGroupName, topicName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new TopicSharedAccessKeysImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public TopicSharedAccessKeys listSharedAccessKeys(String resourceGroupName, String topicName) {
        TopicSharedAccessKeysInner inner = this.serviceClient().listSharedAccessKeys(resourceGroupName, topicName);
        if (inner != null) {
            return new TopicSharedAccessKeysImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public TopicSharedAccessKeys regenerateKey(String resourceGroupName, String topicName,
        TopicRegenerateKeyRequest regenerateKeyRequest) {
        TopicSharedAccessKeysInner inner
            = this.serviceClient().regenerateKey(resourceGroupName, topicName, regenerateKeyRequest);
        if (inner != null) {
            return new TopicSharedAccessKeysImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public TopicSharedAccessKeys regenerateKey(String resourceGroupName, String topicName,
        TopicRegenerateKeyRequest regenerateKeyRequest, Context context) {
        TopicSharedAccessKeysInner inner
            = this.serviceClient().regenerateKey(resourceGroupName, topicName, regenerateKeyRequest, context);
        if (inner != null) {
            return new TopicSharedAccessKeysImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public PagedIterable<EventType> listEventTypes(String resourceGroupName, String providerNamespace,
        String resourceTypeName, String resourceName) {
        PagedIterable<EventTypeInner> inner
            = this.serviceClient().listEventTypes(resourceGroupName, providerNamespace, resourceTypeName, resourceName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new EventTypeImpl(inner1, this.manager()));
    }

    public PagedIterable<EventType> listEventTypes(String resourceGroupName, String providerNamespace,
        String resourceTypeName, String resourceName, Context context) {
        PagedIterable<EventTypeInner> inner = this.serviceClient()
            .listEventTypes(resourceGroupName, providerNamespace, resourceTypeName, resourceName, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new EventTypeImpl(inner1, this.manager()));
    }

    public Topic getById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String topicName = ResourceManagerUtils.getValueFromIdByName(id, "topics");
        if (topicName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'topics'.", id)));
        }
        return this.getByResourceGroupWithResponse(resourceGroupName, topicName, Context.NONE).getValue();
    }

    public Response<Topic> getByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String topicName = ResourceManagerUtils.getValueFromIdByName(id, "topics");
        if (topicName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'topics'.", id)));
        }
        return this.getByResourceGroupWithResponse(resourceGroupName, topicName, context);
    }

    public void deleteById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String topicName = ResourceManagerUtils.getValueFromIdByName(id, "topics");
        if (topicName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'topics'.", id)));
        }
        this.delete(resourceGroupName, topicName, Context.NONE);
    }

    public void deleteByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String topicName = ResourceManagerUtils.getValueFromIdByName(id, "topics");
        if (topicName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'topics'.", id)));
        }
        this.delete(resourceGroupName, topicName, context);
    }

    private TopicsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.eventgrid.EventGridManager manager() {
        return this.serviceManager;
    }

    public TopicImpl define(String name) {
        return new TopicImpl(name, this.manager());
    }
}
