// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.generated;

/**
 * Samples for NetworkSecurityPerimeterConfigurations List.
 */
public final class NetworkSecurityPerimeterConfigurationsListSamples {
    /*
     * x-ms-original-file:
     * specification/cognitiveservices/resource-manager/Microsoft.CognitiveServices/stable/2025-06-01/examples/
     * ListNetworkSecurityPerimeterConfigurations.json
     */
    /**
     * Sample code: ListNetworkSecurityPerimeterConfigurations.
     * 
     * @param manager Entry point to CognitiveServicesManager.
     */
    public static void listNetworkSecurityPerimeterConfigurations(
        com.azure.resourcemanager.cognitiveservices.CognitiveServicesManager manager) {
        manager.networkSecurityPerimeterConfigurations()
            .list("resourceGroupName", "accountName", com.azure.core.util.Context.NONE);
    }
}
