// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.dnsresolver.generated;

/**
 * Samples for DnsForwardingRulesets ListByResourceGroup.
 */
public final class DnsForwardingRulesetsListByResourceGroupSamples {
    /*
     * x-ms-original-file: specification/dnsresolver/resource-manager/Microsoft.Network/stable/2025-05-01/examples/
     * DnsForwardingRuleset_ListByResourceGroup.json
     */
    /**
     * Sample code: List DNS forwarding rulesets by resource group.
     * 
     * @param manager Entry point to DnsResolverManager.
     */
    public static void
        listDNSForwardingRulesetsByResourceGroup(com.azure.resourcemanager.dnsresolver.DnsResolverManager manager) {
        manager.dnsForwardingRulesets()
            .listByResourceGroup("sampleResourceGroup", null, com.azure.core.util.Context.NONE);
    }
}
