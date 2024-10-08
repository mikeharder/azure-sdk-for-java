// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.edgeorder.generated;

import com.azure.resourcemanager.edgeorder.models.ReturnOrderItemDetails;

/**
 * Samples for ResourceProvider ReturnOrderItem.
 */
public final class ResourceProviderReturnOrderItemSamples {
    /*
     * x-ms-original-file:
     * specification/edgeorder/resource-manager/Microsoft.EdgeOrder/stable/2021-12-01/examples/ReturnOrderItem.json
     */
    /**
     * Sample code: ReturnOrderItem.
     * 
     * @param manager Entry point to EdgeOrderManager.
     */
    public static void returnOrderItem(com.azure.resourcemanager.edgeorder.EdgeOrderManager manager) {
        manager.resourceProviders()
            .returnOrderItem("TestOrderName4", "YourResourceGroupName",
                new ReturnOrderItemDetails().withReturnReason("Order returned"), com.azure.core.util.Context.NONE);
    }
}
