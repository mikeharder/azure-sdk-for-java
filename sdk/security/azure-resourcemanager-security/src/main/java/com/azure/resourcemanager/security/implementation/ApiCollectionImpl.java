// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.implementation;

import com.azure.resourcemanager.security.fluent.models.ApiCollectionInner;
import com.azure.resourcemanager.security.models.ApiCollection;
import com.azure.resourcemanager.security.models.ProvisioningState;

public final class ApiCollectionImpl implements ApiCollection {
    private ApiCollectionInner innerObject;

    private final com.azure.resourcemanager.security.SecurityManager serviceManager;

    ApiCollectionImpl(ApiCollectionInner innerObject,
        com.azure.resourcemanager.security.SecurityManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public ProvisioningState provisioningState() {
        return this.innerModel().provisioningState();
    }

    public String displayName() {
        return this.innerModel().displayName();
    }

    public String discoveredVia() {
        return this.innerModel().discoveredVia();
    }

    public String baseUrl() {
        return this.innerModel().baseUrl();
    }

    public Long numberOfApiEndpoints() {
        return this.innerModel().numberOfApiEndpoints();
    }

    public Long numberOfInactiveApiEndpoints() {
        return this.innerModel().numberOfInactiveApiEndpoints();
    }

    public Long numberOfUnauthenticatedApiEndpoints() {
        return this.innerModel().numberOfUnauthenticatedApiEndpoints();
    }

    public Long numberOfExternalApiEndpoints() {
        return this.innerModel().numberOfExternalApiEndpoints();
    }

    public Long numberOfApiEndpointsWithSensitiveDataExposed() {
        return this.innerModel().numberOfApiEndpointsWithSensitiveDataExposed();
    }

    public String sensitivityLabel() {
        return this.innerModel().sensitivityLabel();
    }

    public ApiCollectionInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.security.SecurityManager manager() {
        return this.serviceManager;
    }
}
