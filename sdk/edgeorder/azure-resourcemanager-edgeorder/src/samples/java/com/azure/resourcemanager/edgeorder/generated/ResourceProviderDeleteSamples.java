// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.edgeorder.generated;

/**
 * Samples for ResourceProvider Delete.
 */
public final class ResourceProviderDeleteSamples {
    /*
     * x-ms-original-file:
     * specification/edgeorder/resource-manager/Microsoft.EdgeOrder/stable/2021-12-01/examples/DeleteAddressByName.json
     */
    /**
     * Sample code: DeleteAddressByName.
     * 
     * @param manager Entry point to EdgeOrderManager.
     */
    public static void deleteAddressByName(com.azure.resourcemanager.edgeorder.EdgeOrderManager manager) {
        manager.resourceProviders()
            .delete("YourResourceGroupName", "TestAddressName1", com.azure.core.util.Context.NONE);
    }
}
