// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.generated;

/**
 * Samples for DefaultRollouts Delete.
 */
public final class DefaultRolloutsDeleteSamples {
    /*
     * x-ms-original-file: specification/providerhub/resource-manager/Microsoft.ProviderHub/stable/2024-09-01/examples/
     * DefaultRollouts_Delete.json
     */
    /**
     * Sample code: DefaultRollouts_Delete.
     * 
     * @param manager Entry point to ProviderHubManager.
     */
    public static void defaultRolloutsDelete(com.azure.resourcemanager.providerhub.ProviderHubManager manager) {
        manager.defaultRollouts()
            .deleteByResourceGroupWithResponse("Microsoft.Contoso", "2020week10", com.azure.core.util.Context.NONE);
    }
}
