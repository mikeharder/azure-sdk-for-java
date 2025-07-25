// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcompute.generated;

/**
 * Samples for MachineRunCommands List.
 */
public final class MachineRunCommandsListSamples {
    /*
     * x-ms-original-file:
     * specification/hybridcompute/resource-manager/Microsoft.HybridCompute/preview/2025-02-19-preview/examples/
     * runCommand/RunCommands_List.json
     */
    /**
     * Sample code: GET all Machine Run Commands.
     * 
     * @param manager Entry point to HybridComputeManager.
     */
    public static void gETAllMachineRunCommands(com.azure.resourcemanager.hybridcompute.HybridComputeManager manager) {
        manager.machineRunCommands().list("myResourceGroup", "myMachine", null, com.azure.core.util.Context.NONE);
    }
}
