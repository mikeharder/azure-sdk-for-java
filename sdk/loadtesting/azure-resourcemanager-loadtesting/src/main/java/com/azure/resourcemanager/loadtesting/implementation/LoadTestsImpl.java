// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.loadtesting.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.loadtesting.fluent.LoadTestsClient;
import com.azure.resourcemanager.loadtesting.fluent.models.LoadTestResourceInner;
import com.azure.resourcemanager.loadtesting.fluent.models.OutboundEnvironmentEndpointInner;
import com.azure.resourcemanager.loadtesting.models.LoadTestResource;
import com.azure.resourcemanager.loadtesting.models.LoadTests;
import com.azure.resourcemanager.loadtesting.models.OutboundEnvironmentEndpoint;

public final class LoadTestsImpl implements LoadTests {
    private static final ClientLogger LOGGER = new ClientLogger(LoadTestsImpl.class);

    private final LoadTestsClient innerClient;

    private final com.azure.resourcemanager.loadtesting.LoadTestManager serviceManager;

    public LoadTestsImpl(LoadTestsClient innerClient,
        com.azure.resourcemanager.loadtesting.LoadTestManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<LoadTestResource> list() {
        PagedIterable<LoadTestResourceInner> inner = this.serviceClient().list();
        return ResourceManagerUtils.mapPage(inner, inner1 -> new LoadTestResourceImpl(inner1, this.manager()));
    }

    public PagedIterable<LoadTestResource> list(Context context) {
        PagedIterable<LoadTestResourceInner> inner = this.serviceClient().list(context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new LoadTestResourceImpl(inner1, this.manager()));
    }

    public PagedIterable<LoadTestResource> listByResourceGroup(String resourceGroupName) {
        PagedIterable<LoadTestResourceInner> inner = this.serviceClient().listByResourceGroup(resourceGroupName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new LoadTestResourceImpl(inner1, this.manager()));
    }

    public PagedIterable<LoadTestResource> listByResourceGroup(String resourceGroupName, Context context) {
        PagedIterable<LoadTestResourceInner> inner
            = this.serviceClient().listByResourceGroup(resourceGroupName, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new LoadTestResourceImpl(inner1, this.manager()));
    }

    public Response<LoadTestResource> getByResourceGroupWithResponse(String resourceGroupName, String loadTestName,
        Context context) {
        Response<LoadTestResourceInner> inner
            = this.serviceClient().getByResourceGroupWithResponse(resourceGroupName, loadTestName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new LoadTestResourceImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public LoadTestResource getByResourceGroup(String resourceGroupName, String loadTestName) {
        LoadTestResourceInner inner = this.serviceClient().getByResourceGroup(resourceGroupName, loadTestName);
        if (inner != null) {
            return new LoadTestResourceImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public void deleteByResourceGroup(String resourceGroupName, String loadTestName) {
        this.serviceClient().delete(resourceGroupName, loadTestName);
    }

    public void delete(String resourceGroupName, String loadTestName, Context context) {
        this.serviceClient().delete(resourceGroupName, loadTestName, context);
    }

    public PagedIterable<OutboundEnvironmentEndpoint> listOutboundNetworkDependenciesEndpoints(String resourceGroupName,
        String loadTestName) {
        PagedIterable<OutboundEnvironmentEndpointInner> inner
            = this.serviceClient().listOutboundNetworkDependenciesEndpoints(resourceGroupName, loadTestName);
        return ResourceManagerUtils.mapPage(inner,
            inner1 -> new OutboundEnvironmentEndpointImpl(inner1, this.manager()));
    }

    public PagedIterable<OutboundEnvironmentEndpoint> listOutboundNetworkDependenciesEndpoints(String resourceGroupName,
        String loadTestName, Context context) {
        PagedIterable<OutboundEnvironmentEndpointInner> inner
            = this.serviceClient().listOutboundNetworkDependenciesEndpoints(resourceGroupName, loadTestName, context);
        return ResourceManagerUtils.mapPage(inner,
            inner1 -> new OutboundEnvironmentEndpointImpl(inner1, this.manager()));
    }

    public LoadTestResource getById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String loadTestName = ResourceManagerUtils.getValueFromIdByName(id, "loadTests");
        if (loadTestName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'loadTests'.", id)));
        }
        return this.getByResourceGroupWithResponse(resourceGroupName, loadTestName, Context.NONE).getValue();
    }

    public Response<LoadTestResource> getByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String loadTestName = ResourceManagerUtils.getValueFromIdByName(id, "loadTests");
        if (loadTestName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'loadTests'.", id)));
        }
        return this.getByResourceGroupWithResponse(resourceGroupName, loadTestName, context);
    }

    public void deleteById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String loadTestName = ResourceManagerUtils.getValueFromIdByName(id, "loadTests");
        if (loadTestName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'loadTests'.", id)));
        }
        this.delete(resourceGroupName, loadTestName, Context.NONE);
    }

    public void deleteByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String loadTestName = ResourceManagerUtils.getValueFromIdByName(id, "loadTests");
        if (loadTestName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'loadTests'.", id)));
        }
        this.delete(resourceGroupName, loadTestName, context);
    }

    private LoadTestsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.loadtesting.LoadTestManager manager() {
        return this.serviceManager;
    }

    public LoadTestResourceImpl define(String name) {
        return new LoadTestResourceImpl(name, this.manager());
    }
}
