// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.dashboard.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.dashboard.models.ResourceSku;
import org.junit.jupiter.api.Assertions;

public final class ResourceSkuTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ResourceSku model = BinaryData.fromString("{\"name\":\"wpyeicxmqciwqvh\"}").toObject(ResourceSku.class);
        Assertions.assertEquals("wpyeicxmqciwqvh", model.name());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ResourceSku model = new ResourceSku().withName("wpyeicxmqciwqvh");
        model = BinaryData.fromObject(model).toObject(ResourceSku.class);
        Assertions.assertEquals("wpyeicxmqciwqvh", model.name());
    }
}
