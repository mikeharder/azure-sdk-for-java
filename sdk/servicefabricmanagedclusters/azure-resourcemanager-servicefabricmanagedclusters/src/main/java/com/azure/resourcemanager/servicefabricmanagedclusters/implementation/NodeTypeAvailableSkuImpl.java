// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.servicefabricmanagedclusters.implementation;

import com.azure.resourcemanager.servicefabricmanagedclusters.fluent.models.NodeTypeAvailableSkuInner;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.NodeTypeAvailableSku;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.NodeTypeSkuCapacity;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.NodeTypeSupportedSku;

public final class NodeTypeAvailableSkuImpl implements NodeTypeAvailableSku {
    private NodeTypeAvailableSkuInner innerObject;

    private final com.azure.resourcemanager.servicefabricmanagedclusters.ServiceFabricManagedClustersManager serviceManager;

    NodeTypeAvailableSkuImpl(NodeTypeAvailableSkuInner innerObject,
        com.azure.resourcemanager.servicefabricmanagedclusters.ServiceFabricManagedClustersManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public String resourceType() {
        return this.innerModel().resourceType();
    }

    public NodeTypeSupportedSku sku() {
        return this.innerModel().sku();
    }

    public NodeTypeSkuCapacity capacity() {
        return this.innerModel().capacity();
    }

    public NodeTypeAvailableSkuInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.servicefabricmanagedclusters.ServiceFabricManagedClustersManager manager() {
        return this.serviceManager;
    }
}
