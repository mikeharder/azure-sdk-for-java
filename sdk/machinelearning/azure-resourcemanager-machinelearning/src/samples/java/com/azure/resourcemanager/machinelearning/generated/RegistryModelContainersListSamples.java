// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

/**
 * Samples for RegistryModelContainers List.
 */
public final class RegistryModelContainersListSamples {
    /*
     * x-ms-original-file:
     * specification/machinelearningservices/resource-manager/Microsoft.MachineLearningServices/stable/2024-04-01/
     * examples/Registry/ModelContainer/list.json
     */
    /**
     * Sample code: List Registry Model Container.
     * 
     * @param manager Entry point to MachineLearningManager.
     */
    public static void
        listRegistryModelContainer(com.azure.resourcemanager.machinelearning.MachineLearningManager manager) {
        manager.registryModelContainers()
            .list("testrg123", "registry123", null, null, com.azure.core.util.Context.NONE);
    }
}
