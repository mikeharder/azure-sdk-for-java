// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.datamigration.fluent.DatabaseMigrationsSqlVmsClient;
import com.azure.resourcemanager.datamigration.fluent.models.DatabaseMigrationSqlVmInner;
import com.azure.resourcemanager.datamigration.models.DatabaseMigrationSqlVm;
import com.azure.resourcemanager.datamigration.models.DatabaseMigrationsSqlVms;
import com.azure.resourcemanager.datamigration.models.MigrationOperationInput;
import java.util.UUID;

public final class DatabaseMigrationsSqlVmsImpl implements DatabaseMigrationsSqlVms {
    private static final ClientLogger LOGGER = new ClientLogger(DatabaseMigrationsSqlVmsImpl.class);

    private final DatabaseMigrationsSqlVmsClient innerClient;

    private final com.azure.resourcemanager.datamigration.DataMigrationManager serviceManager;

    public DatabaseMigrationsSqlVmsImpl(DatabaseMigrationsSqlVmsClient innerClient,
        com.azure.resourcemanager.datamigration.DataMigrationManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<DatabaseMigrationSqlVm> getWithResponse(String resourceGroupName, String sqlVirtualMachineName,
        String targetDbName, UUID migrationOperationId, String expand, Context context) {
        Response<DatabaseMigrationSqlVmInner> inner = this.serviceClient()
            .getWithResponse(resourceGroupName, sqlVirtualMachineName, targetDbName, migrationOperationId, expand,
                context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new DatabaseMigrationSqlVmImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public DatabaseMigrationSqlVm get(String resourceGroupName, String sqlVirtualMachineName, String targetDbName) {
        DatabaseMigrationSqlVmInner inner
            = this.serviceClient().get(resourceGroupName, sqlVirtualMachineName, targetDbName);
        if (inner != null) {
            return new DatabaseMigrationSqlVmImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public void cancel(String resourceGroupName, String sqlVirtualMachineName, String targetDbName,
        MigrationOperationInput parameters) {
        this.serviceClient().cancel(resourceGroupName, sqlVirtualMachineName, targetDbName, parameters);
    }

    public void cancel(String resourceGroupName, String sqlVirtualMachineName, String targetDbName,
        MigrationOperationInput parameters, Context context) {
        this.serviceClient().cancel(resourceGroupName, sqlVirtualMachineName, targetDbName, parameters, context);
    }

    public void cutover(String resourceGroupName, String sqlVirtualMachineName, String targetDbName,
        MigrationOperationInput parameters) {
        this.serviceClient().cutover(resourceGroupName, sqlVirtualMachineName, targetDbName, parameters);
    }

    public void cutover(String resourceGroupName, String sqlVirtualMachineName, String targetDbName,
        MigrationOperationInput parameters, Context context) {
        this.serviceClient().cutover(resourceGroupName, sqlVirtualMachineName, targetDbName, parameters, context);
    }

    public DatabaseMigrationSqlVm getById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String sqlVirtualMachineName = ResourceManagerUtils.getValueFromIdByName(id, "sqlVirtualMachines");
        if (sqlVirtualMachineName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'sqlVirtualMachines'.", id)));
        }
        String targetDbName = ResourceManagerUtils.getValueFromIdByName(id, "databaseMigrations");
        if (targetDbName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'databaseMigrations'.", id)));
        }
        UUID localMigrationOperationId = null;
        String localExpand = null;
        return this
            .getWithResponse(resourceGroupName, sqlVirtualMachineName, targetDbName, localMigrationOperationId,
                localExpand, Context.NONE)
            .getValue();
    }

    public Response<DatabaseMigrationSqlVm> getByIdWithResponse(String id, UUID migrationOperationId, String expand,
        Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String sqlVirtualMachineName = ResourceManagerUtils.getValueFromIdByName(id, "sqlVirtualMachines");
        if (sqlVirtualMachineName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'sqlVirtualMachines'.", id)));
        }
        String targetDbName = ResourceManagerUtils.getValueFromIdByName(id, "databaseMigrations");
        if (targetDbName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'databaseMigrations'.", id)));
        }
        return this.getWithResponse(resourceGroupName, sqlVirtualMachineName, targetDbName, migrationOperationId,
            expand, context);
    }

    private DatabaseMigrationsSqlVmsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.datamigration.DataMigrationManager manager() {
        return this.serviceManager;
    }

    public DatabaseMigrationSqlVmImpl define(String name) {
        return new DatabaseMigrationSqlVmImpl(name, this.manager());
    }
}
