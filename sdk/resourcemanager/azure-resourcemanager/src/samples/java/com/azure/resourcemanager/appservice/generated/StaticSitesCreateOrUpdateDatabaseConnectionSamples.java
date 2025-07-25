// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.generated;

import com.azure.resourcemanager.appservice.fluent.models.DatabaseConnectionInner;

/**
 * Samples for StaticSites CreateOrUpdateDatabaseConnection.
 */
public final class StaticSitesCreateOrUpdateDatabaseConnectionSamples {
    /*
     * x-ms-original-file: specification/web/resource-manager/Microsoft.Web/stable/2024-11-01/examples/
     * CreateOrUpdateStaticSiteDatabaseConnection.json
     */
    /**
     * Sample code: Create or update a database connection for a static site.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void
        createOrUpdateADatabaseConnectionForAStaticSite(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.webApps()
            .manager()
            .serviceClient()
            .getStaticSites()
            .createOrUpdateDatabaseConnectionWithResponse("rg", "testStaticSite0", "default",
                new DatabaseConnectionInner().withResourceId(
                    "/subscription/34adfa4f-cedf-4dc0-ba29-b6d1a69ab345/resourceGroups/databaseRG/providers/Microsoft.DocumentDB/databaseAccounts/exampleDatabaseName")
                    .withConnectionIdentity("SystemAssigned")
                    .withConnectionString(
                        "AccountEndpoint=https://exampleDatabaseName.documents.azure.com:443/;Database=mydb;")
                    .withRegion("West US 2"),
                com.azure.core.util.Context.NONE);
    }
}
