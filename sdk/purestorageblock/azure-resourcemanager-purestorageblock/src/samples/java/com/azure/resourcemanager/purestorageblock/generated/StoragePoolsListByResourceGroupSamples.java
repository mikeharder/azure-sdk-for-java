// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.purestorageblock.generated;

/**
 * Samples for StoragePools ListByResourceGroup.
 */
public final class StoragePoolsListByResourceGroupSamples {
    /*
     * x-ms-original-file: 2024-11-01/StoragePools_ListByResourceGroup_MaximumSet_Gen.json
     */
    /**
     * Sample code: StoragePools_ListByResourceGroup.
     * 
     * @param manager Entry point to PureStorageBlockManager.
     */
    public static void
        storagePoolsListByResourceGroup(com.azure.resourcemanager.purestorageblock.PureStorageBlockManager manager) {
        manager.storagePools().listByResourceGroup("rgpurestorage", com.azure.core.util.Context.NONE);
    }
}
