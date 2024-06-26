// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.mongocluster.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.mongocluster.fluent.PrivateEndpointConnectionsClient;
import com.azure.resourcemanager.mongocluster.fluent.models.PrivateEndpointConnectionResourceInner;
import com.azure.resourcemanager.mongocluster.models.PrivateEndpointConnectionResource;
import com.azure.resourcemanager.mongocluster.models.PrivateEndpointConnections;

public final class PrivateEndpointConnectionsImpl implements PrivateEndpointConnections {
    private static final ClientLogger LOGGER = new ClientLogger(PrivateEndpointConnectionsImpl.class);

    private final PrivateEndpointConnectionsClient innerClient;

    private final com.azure.resourcemanager.mongocluster.MongoClusterManager serviceManager;

    public PrivateEndpointConnectionsImpl(PrivateEndpointConnectionsClient innerClient,
        com.azure.resourcemanager.mongocluster.MongoClusterManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<PrivateEndpointConnectionResource> listByMongoCluster(String resourceGroupName,
        String mongoClusterName) {
        PagedIterable<PrivateEndpointConnectionResourceInner> inner
            = this.serviceClient().listByMongoCluster(resourceGroupName, mongoClusterName);
        return ResourceManagerUtils.mapPage(inner,
            inner1 -> new PrivateEndpointConnectionResourceImpl(inner1, this.manager()));
    }

    public PagedIterable<PrivateEndpointConnectionResource> listByMongoCluster(String resourceGroupName,
        String mongoClusterName, Context context) {
        PagedIterable<PrivateEndpointConnectionResourceInner> inner
            = this.serviceClient().listByMongoCluster(resourceGroupName, mongoClusterName, context);
        return ResourceManagerUtils.mapPage(inner,
            inner1 -> new PrivateEndpointConnectionResourceImpl(inner1, this.manager()));
    }

    public Response<PrivateEndpointConnectionResource> getWithResponse(String resourceGroupName,
        String mongoClusterName, String privateEndpointConnectionName, Context context) {
        Response<PrivateEndpointConnectionResourceInner> inner = this.serviceClient()
            .getWithResponse(resourceGroupName, mongoClusterName, privateEndpointConnectionName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new PrivateEndpointConnectionResourceImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public PrivateEndpointConnectionResource get(String resourceGroupName, String mongoClusterName,
        String privateEndpointConnectionName) {
        PrivateEndpointConnectionResourceInner inner
            = this.serviceClient().get(resourceGroupName, mongoClusterName, privateEndpointConnectionName);
        if (inner != null) {
            return new PrivateEndpointConnectionResourceImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public void delete(String resourceGroupName, String mongoClusterName, String privateEndpointConnectionName) {
        this.serviceClient().delete(resourceGroupName, mongoClusterName, privateEndpointConnectionName);
    }

    public void delete(String resourceGroupName, String mongoClusterName, String privateEndpointConnectionName,
        Context context) {
        this.serviceClient().delete(resourceGroupName, mongoClusterName, privateEndpointConnectionName, context);
    }

    public PrivateEndpointConnectionResource getById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String mongoClusterName = ResourceManagerUtils.getValueFromIdByName(id, "mongoClusters");
        if (mongoClusterName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'mongoClusters'.", id)));
        }
        String privateEndpointConnectionName
            = ResourceManagerUtils.getValueFromIdByName(id, "privateEndpointConnections");
        if (privateEndpointConnectionName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(String
                .format("The resource ID '%s' is not valid. Missing path segment 'privateEndpointConnections'.", id)));
        }
        return this.getWithResponse(resourceGroupName, mongoClusterName, privateEndpointConnectionName, Context.NONE)
            .getValue();
    }

    public Response<PrivateEndpointConnectionResource> getByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String mongoClusterName = ResourceManagerUtils.getValueFromIdByName(id, "mongoClusters");
        if (mongoClusterName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'mongoClusters'.", id)));
        }
        String privateEndpointConnectionName
            = ResourceManagerUtils.getValueFromIdByName(id, "privateEndpointConnections");
        if (privateEndpointConnectionName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(String
                .format("The resource ID '%s' is not valid. Missing path segment 'privateEndpointConnections'.", id)));
        }
        return this.getWithResponse(resourceGroupName, mongoClusterName, privateEndpointConnectionName, context);
    }

    public void deleteById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String mongoClusterName = ResourceManagerUtils.getValueFromIdByName(id, "mongoClusters");
        if (mongoClusterName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'mongoClusters'.", id)));
        }
        String privateEndpointConnectionName
            = ResourceManagerUtils.getValueFromIdByName(id, "privateEndpointConnections");
        if (privateEndpointConnectionName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(String
                .format("The resource ID '%s' is not valid. Missing path segment 'privateEndpointConnections'.", id)));
        }
        this.delete(resourceGroupName, mongoClusterName, privateEndpointConnectionName, Context.NONE);
    }

    public void deleteByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String mongoClusterName = ResourceManagerUtils.getValueFromIdByName(id, "mongoClusters");
        if (mongoClusterName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'mongoClusters'.", id)));
        }
        String privateEndpointConnectionName
            = ResourceManagerUtils.getValueFromIdByName(id, "privateEndpointConnections");
        if (privateEndpointConnectionName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(String
                .format("The resource ID '%s' is not valid. Missing path segment 'privateEndpointConnections'.", id)));
        }
        this.delete(resourceGroupName, mongoClusterName, privateEndpointConnectionName, context);
    }

    private PrivateEndpointConnectionsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.mongocluster.MongoClusterManager manager() {
        return this.serviceManager;
    }

    public PrivateEndpointConnectionResourceImpl define(String name) {
        return new PrivateEndpointConnectionResourceImpl(name, this.manager());
    }
}
