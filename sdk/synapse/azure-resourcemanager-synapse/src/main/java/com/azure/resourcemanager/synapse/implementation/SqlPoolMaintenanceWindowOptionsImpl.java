// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.synapse.fluent.SqlPoolMaintenanceWindowOptionsClient;
import com.azure.resourcemanager.synapse.fluent.models.MaintenanceWindowOptionsInner;
import com.azure.resourcemanager.synapse.models.MaintenanceWindowOptions;
import com.azure.resourcemanager.synapse.models.SqlPoolMaintenanceWindowOptions;

public final class SqlPoolMaintenanceWindowOptionsImpl implements SqlPoolMaintenanceWindowOptions {
    private static final ClientLogger LOGGER = new ClientLogger(SqlPoolMaintenanceWindowOptionsImpl.class);

    private final SqlPoolMaintenanceWindowOptionsClient innerClient;

    private final com.azure.resourcemanager.synapse.SynapseManager serviceManager;

    public SqlPoolMaintenanceWindowOptionsImpl(SqlPoolMaintenanceWindowOptionsClient innerClient,
        com.azure.resourcemanager.synapse.SynapseManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<MaintenanceWindowOptions> getWithResponse(String resourceGroupName, String workspaceName,
        String sqlPoolName, String maintenanceWindowOptionsName, Context context) {
        Response<MaintenanceWindowOptionsInner> inner = this.serviceClient()
            .getWithResponse(resourceGroupName, workspaceName, sqlPoolName, maintenanceWindowOptionsName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new MaintenanceWindowOptionsImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public MaintenanceWindowOptions get(String resourceGroupName, String workspaceName, String sqlPoolName,
        String maintenanceWindowOptionsName) {
        MaintenanceWindowOptionsInner inner
            = this.serviceClient().get(resourceGroupName, workspaceName, sqlPoolName, maintenanceWindowOptionsName);
        if (inner != null) {
            return new MaintenanceWindowOptionsImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    private SqlPoolMaintenanceWindowOptionsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.synapse.SynapseManager manager() {
        return this.serviceManager;
    }
}
