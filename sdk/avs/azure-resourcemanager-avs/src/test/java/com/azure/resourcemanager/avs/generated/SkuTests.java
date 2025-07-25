// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.avs.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.avs.models.Sku;
import com.azure.resourcemanager.avs.models.SkuTier;
import org.junit.jupiter.api.Assertions;

public final class SkuTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        Sku model = BinaryData.fromString(
            "{\"name\":\"zt\",\"tier\":\"Free\",\"size\":\"gnxytxhpzxbz\",\"family\":\"zabglcuhxwt\",\"capacity\":1557005906}")
            .toObject(Sku.class);
        Assertions.assertEquals("zt", model.name());
        Assertions.assertEquals(SkuTier.FREE, model.tier());
        Assertions.assertEquals("gnxytxhpzxbz", model.size());
        Assertions.assertEquals("zabglcuhxwt", model.family());
        Assertions.assertEquals(1557005906, model.capacity());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        Sku model = new Sku().withName("zt")
            .withTier(SkuTier.FREE)
            .withSize("gnxytxhpzxbz")
            .withFamily("zabglcuhxwt")
            .withCapacity(1557005906);
        model = BinaryData.fromObject(model).toObject(Sku.class);
        Assertions.assertEquals("zt", model.name());
        Assertions.assertEquals(SkuTier.FREE, model.tier());
        Assertions.assertEquals("gnxytxhpzxbz", model.size());
        Assertions.assertEquals("zabglcuhxwt", model.family());
        Assertions.assertEquals(1557005906, model.capacity());
    }
}
