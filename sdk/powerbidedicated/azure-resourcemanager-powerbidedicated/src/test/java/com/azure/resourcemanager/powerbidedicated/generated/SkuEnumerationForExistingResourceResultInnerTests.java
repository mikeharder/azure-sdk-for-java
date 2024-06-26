// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.powerbidedicated.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.powerbidedicated.fluent.models.SkuEnumerationForExistingResourceResultInner;
import com.azure.resourcemanager.powerbidedicated.models.CapacitySku;
import com.azure.resourcemanager.powerbidedicated.models.CapacitySkuTier;
import com.azure.resourcemanager.powerbidedicated.models.SkuDetailsForExistingResource;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class SkuEnumerationForExistingResourceResultInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SkuEnumerationForExistingResourceResultInner model =
            BinaryData
                .fromString(
                    "{\"value\":[{\"resourceType\":\"umkdosvqwhbmd\",\"sku\":{\"name\":\"bjf\",\"tier\":\"PBIE_Azure\",\"capacity\":1359237516}},{\"resourceType\":\"bexppb\",\"sku\":{\"name\":\"q\",\"tier\":\"Premium\",\"capacity\":1825167031}},{\"resourceType\":\"fpsalgbqu\",\"sku\":{\"name\":\"gjyjgzjaoyfhrtxi\",\"tier\":\"PBIE_Azure\",\"capacity\":1275359394}}]}")
                .toObject(SkuEnumerationForExistingResourceResultInner.class);
        Assertions.assertEquals("umkdosvqwhbmd", model.value().get(0).resourceType());
        Assertions.assertEquals("bjf", model.value().get(0).sku().name());
        Assertions.assertEquals(CapacitySkuTier.PBIE_AZURE, model.value().get(0).sku().tier());
        Assertions.assertEquals(1359237516, model.value().get(0).sku().capacity());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SkuEnumerationForExistingResourceResultInner model =
            new SkuEnumerationForExistingResourceResultInner()
                .withValue(
                    Arrays
                        .asList(
                            new SkuDetailsForExistingResource()
                                .withResourceType("umkdosvqwhbmd")
                                .withSku(
                                    new CapacitySku()
                                        .withName("bjf")
                                        .withTier(CapacitySkuTier.PBIE_AZURE)
                                        .withCapacity(1359237516)),
                            new SkuDetailsForExistingResource()
                                .withResourceType("bexppb")
                                .withSku(
                                    new CapacitySku()
                                        .withName("q")
                                        .withTier(CapacitySkuTier.PREMIUM)
                                        .withCapacity(1825167031)),
                            new SkuDetailsForExistingResource()
                                .withResourceType("fpsalgbqu")
                                .withSku(
                                    new CapacitySku()
                                        .withName("gjyjgzjaoyfhrtxi")
                                        .withTier(CapacitySkuTier.PBIE_AZURE)
                                        .withCapacity(1275359394))));
        model = BinaryData.fromObject(model).toObject(SkuEnumerationForExistingResourceResultInner.class);
        Assertions.assertEquals("umkdosvqwhbmd", model.value().get(0).resourceType());
        Assertions.assertEquals("bjf", model.value().get(0).sku().name());
        Assertions.assertEquals(CapacitySkuTier.PBIE_AZURE, model.value().get(0).sku().tier());
        Assertions.assertEquals(1359237516, model.value().get(0).sku().capacity());
    }
}
