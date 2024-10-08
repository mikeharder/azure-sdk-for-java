// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.machinelearning.fluent.RegistryDataVersionsClient;
import com.azure.resourcemanager.machinelearning.fluent.models.DataVersionBaseInner;
import com.azure.resourcemanager.machinelearning.fluent.models.PendingUploadResponseDtoInner;
import com.azure.resourcemanager.machinelearning.models.DataVersionBase;
import com.azure.resourcemanager.machinelearning.models.ListViewType;
import com.azure.resourcemanager.machinelearning.models.PendingUploadRequestDto;
import com.azure.resourcemanager.machinelearning.models.PendingUploadResponseDto;
import com.azure.resourcemanager.machinelearning.models.RegistryDataVersions;

public final class RegistryDataVersionsImpl implements RegistryDataVersions {
    private static final ClientLogger LOGGER = new ClientLogger(RegistryDataVersionsImpl.class);

    private final RegistryDataVersionsClient innerClient;

    private final com.azure.resourcemanager.machinelearning.MachineLearningManager serviceManager;

    public RegistryDataVersionsImpl(RegistryDataVersionsClient innerClient,
        com.azure.resourcemanager.machinelearning.MachineLearningManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<DataVersionBase> list(String resourceGroupName, String registryName, String name) {
        PagedIterable<DataVersionBaseInner> inner = this.serviceClient().list(resourceGroupName, registryName, name);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new DataVersionBaseImpl(inner1, this.manager()));
    }

    public PagedIterable<DataVersionBase> list(String resourceGroupName, String registryName, String name,
        String orderBy, Integer top, String skip, String tags, ListViewType listViewType, Context context) {
        PagedIterable<DataVersionBaseInner> inner = this.serviceClient()
            .list(resourceGroupName, registryName, name, orderBy, top, skip, tags, listViewType, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new DataVersionBaseImpl(inner1, this.manager()));
    }

    public void delete(String resourceGroupName, String registryName, String name, String version) {
        this.serviceClient().delete(resourceGroupName, registryName, name, version);
    }

    public void delete(String resourceGroupName, String registryName, String name, String version, Context context) {
        this.serviceClient().delete(resourceGroupName, registryName, name, version, context);
    }

    public Response<DataVersionBase> getWithResponse(String resourceGroupName, String registryName, String name,
        String version, Context context) {
        Response<DataVersionBaseInner> inner
            = this.serviceClient().getWithResponse(resourceGroupName, registryName, name, version, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new DataVersionBaseImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public DataVersionBase get(String resourceGroupName, String registryName, String name, String version) {
        DataVersionBaseInner inner = this.serviceClient().get(resourceGroupName, registryName, name, version);
        if (inner != null) {
            return new DataVersionBaseImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public DataVersionBase createOrUpdate(String resourceGroupName, String registryName, String name, String version,
        DataVersionBaseInner body) {
        DataVersionBaseInner inner
            = this.serviceClient().createOrUpdate(resourceGroupName, registryName, name, version, body);
        if (inner != null) {
            return new DataVersionBaseImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public DataVersionBase createOrUpdate(String resourceGroupName, String registryName, String name, String version,
        DataVersionBaseInner body, Context context) {
        DataVersionBaseInner inner
            = this.serviceClient().createOrUpdate(resourceGroupName, registryName, name, version, body, context);
        if (inner != null) {
            return new DataVersionBaseImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<PendingUploadResponseDto> createOrGetStartPendingUploadWithResponse(String resourceGroupName,
        String registryName, String name, String version, PendingUploadRequestDto body, Context context) {
        Response<PendingUploadResponseDtoInner> inner = this.serviceClient()
            .createOrGetStartPendingUploadWithResponse(resourceGroupName, registryName, name, version, body, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new PendingUploadResponseDtoImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public PendingUploadResponseDto createOrGetStartPendingUpload(String resourceGroupName, String registryName,
        String name, String version, PendingUploadRequestDto body) {
        PendingUploadResponseDtoInner inner
            = this.serviceClient().createOrGetStartPendingUpload(resourceGroupName, registryName, name, version, body);
        if (inner != null) {
            return new PendingUploadResponseDtoImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    private RegistryDataVersionsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.machinelearning.MachineLearningManager manager() {
        return this.serviceManager;
    }
}
