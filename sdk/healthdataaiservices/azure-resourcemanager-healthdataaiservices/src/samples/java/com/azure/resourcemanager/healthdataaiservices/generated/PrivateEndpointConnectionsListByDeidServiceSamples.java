// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.healthdataaiservices.generated;

/**
 * Samples for PrivateEndpointConnections ListByDeidService.
 */
public final class PrivateEndpointConnectionsListByDeidServiceSamples {
    /*
     * x-ms-original-file: 2024-09-20/PrivateEndpointConnections_ListByDeidService_MaximumSet_Gen.json
     */
    /**
     * Sample code: PrivateEndpointConnections_ListByDeidService - generated by [MaximumSet] rule. [stable].
     * 
     * @param manager Entry point to HealthDataAIServicesManager.
     */
    public static void privateEndpointConnectionsListByDeidServiceGeneratedByMaximumSetRuleStable(
        com.azure.resourcemanager.healthdataaiservices.HealthDataAIServicesManager manager) {
        manager.privateEndpointConnections()
            .listByDeidService("rgopenapi", "deidTest", com.azure.core.util.Context.NONE);
    }
}
