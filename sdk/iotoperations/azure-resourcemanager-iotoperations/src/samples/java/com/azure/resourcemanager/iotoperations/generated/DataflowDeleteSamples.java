// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.iotoperations.generated;

/**
 * Samples for Dataflow Delete.
 */
public final class DataflowDeleteSamples {
    /*
     * x-ms-original-file: 2025-04-01/Dataflow_Delete_MaximumSet_Gen.json
     */
    /**
     * Sample code: Dataflow_Delete.
     * 
     * @param manager Entry point to IoTOperationsManager.
     */
    public static void dataflowDelete(com.azure.resourcemanager.iotoperations.IoTOperationsManager manager) {
        manager.dataflows()
            .delete("rgiotoperations", "resource-name123", "resource-name123", "resource-name123",
                com.azure.core.util.Context.NONE);
    }
}
