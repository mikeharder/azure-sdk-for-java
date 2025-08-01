// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.generated;

import com.azure.resourcemanager.cognitiveservices.models.CapabilityHostProperties;

/**
 * Samples for AccountCapabilityHosts CreateOrUpdate.
 */
public final class AccountCapabilityHostsCreateOrUpdateSamples {
    /*
     * x-ms-original-file:
     * specification/cognitiveservices/resource-manager/Microsoft.CognitiveServices/stable/2025-06-01/examples/
     * AccountCapabilityHost/createOrUpdate.json
     */
    /**
     * Sample code: CreateOrUpdate Account CapabilityHost.
     * 
     * @param manager Entry point to CognitiveServicesManager.
     */
    public static void createOrUpdateAccountCapabilityHost(
        com.azure.resourcemanager.cognitiveservices.CognitiveServicesManager manager) {
        manager.accountCapabilityHosts()
            .define("capabilityHostName")
            .withExistingAccount("test-rg", "account-1")
            .withProperties(new CapabilityHostProperties().withCustomerSubnet(
                "/subscriptions/00000000-1111-2222-3333-444444444444/resourceGroups/myResourceGroups/providers/Microsoft.Network/virtualNetworks/myVnet/subnets/mySubnet"))
            .create();
    }
}
