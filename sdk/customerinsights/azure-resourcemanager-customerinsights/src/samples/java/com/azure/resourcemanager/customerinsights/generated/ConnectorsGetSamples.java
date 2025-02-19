// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.customerinsights.generated;

/**
 * Samples for Connectors Get.
 */
public final class ConnectorsGetSamples {
    /*
     * x-ms-original-file:
     * specification/customer-insights/resource-manager/Microsoft.CustomerInsights/stable/2017-04-26/examples/
     * ConnectorsGet.json
     */
    /**
     * Sample code: Connectors_Get.
     * 
     * @param manager Entry point to CustomerInsightsManager.
     */
    public static void connectorsGet(com.azure.resourcemanager.customerinsights.CustomerInsightsManager manager) {
        manager.connectors()
            .getWithResponse("TestHubRG", "sdkTestHub", "testConnector", com.azure.core.util.Context.NONE);
    }
}
