// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.generated;

/**
 * Samples for Volumes GetByResourceGroup.
 */
public final class VolumesGetByResourceGroupSamples {
    /*
     * x-ms-original-file:
     * specification/networkcloud/resource-manager/Microsoft.NetworkCloud/stable/2025-02-01/examples/Volumes_Get.json
     */
    /**
     * Sample code: Get volume.
     * 
     * @param manager Entry point to NetworkCloudManager.
     */
    public static void getVolume(com.azure.resourcemanager.networkcloud.NetworkCloudManager manager) {
        manager.volumes()
            .getByResourceGroupWithResponse("resourceGroupName", "volumeName", com.azure.core.util.Context.NONE);
    }
}
