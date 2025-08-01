// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.generated;

import com.azure.resourcemanager.datamigration.fluent.models.RegenAuthKeysInner;

/**
 * Samples for SqlMigrationServices RegenerateAuthKeys.
 */
public final class SqlMigrationServicesRegenerateAuthKeysSamples {
    /*
     * x-ms-original-file:
     * specification/datamigration/resource-manager/Microsoft.DataMigration/preview/2025-03-15-preview/examples/
     * RegenAuthKeysSqlMigrationService.json
     */
    /**
     * Sample code: Regenerate the of Authentication Keys.
     * 
     * @param manager Entry point to DataMigrationManager.
     */
    public static void
        regenerateTheOfAuthenticationKeys(com.azure.resourcemanager.datamigration.DataMigrationManager manager) {
        manager.sqlMigrationServices()
            .regenerateAuthKeysWithResponse("testrg", "service1",
                new RegenAuthKeysInner().withKeyName("fakeTokenPlaceholder"), com.azure.core.util.Context.NONE);
    }
}
