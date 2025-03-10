// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.logz.generated;

/**
 * Samples for SubAccount ListVMHosts.
 */
public final class SubAccountListVMHostsSamples {
    /*
     * x-ms-original-file:
     * specification/logz/resource-manager/Microsoft.Logz/stable/2020-10-01/examples/SubAccount_VMHosts_List.json
     */
    /**
     * Sample code: SubAccount_VMHosts_List.
     * 
     * @param manager Entry point to LogzManager.
     */
    public static void subAccountVMHostsList(com.azure.resourcemanager.logz.LogzManager manager) {
        manager.subAccounts()
            .listVMHosts("myResourceGroup", "myMonitor", "SubAccount1", com.azure.core.util.Context.NONE);
    }
}
