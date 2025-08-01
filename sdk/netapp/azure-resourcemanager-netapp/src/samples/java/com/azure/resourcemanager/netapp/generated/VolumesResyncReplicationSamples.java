// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

/**
 * Samples for Volumes ResyncReplication.
 */
public final class VolumesResyncReplicationSamples {
    /*
     * x-ms-original-file:
     * specification/netapp/resource-manager/Microsoft.NetApp/stable/2025-03-01/examples/Volumes_ResyncReplication.json
     */
    /**
     * Sample code: Volumes_ResyncReplication.
     * 
     * @param manager Entry point to NetAppFilesManager.
     */
    public static void volumesResyncReplication(com.azure.resourcemanager.netapp.NetAppFilesManager manager) {
        manager.volumes().resyncReplication("myRG", "account1", "pool1", "volume1", com.azure.core.util.Context.NONE);
    }
}
