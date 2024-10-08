// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

/**
 * Samples for Registries Delete.
 */
public final class RegistriesDeleteSamples {
    /*
     * x-ms-original-file:
     * specification/machinelearningservices/resource-manager/Microsoft.MachineLearningServices/stable/2024-04-01/
     * examples/Registries/delete.json
     */
    /**
     * Sample code: Delete Registry.
     * 
     * @param manager Entry point to MachineLearningManager.
     */
    public static void deleteRegistry(com.azure.resourcemanager.machinelearning.MachineLearningManager manager) {
        manager.registries().delete("test-rg", "string", com.azure.core.util.Context.NONE);
    }
}
