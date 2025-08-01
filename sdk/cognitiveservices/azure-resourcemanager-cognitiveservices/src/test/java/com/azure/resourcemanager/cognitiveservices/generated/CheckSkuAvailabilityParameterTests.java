// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.cognitiveservices.models.CheckSkuAvailabilityParameter;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class CheckSkuAvailabilityParameterTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        CheckSkuAvailabilityParameter model = BinaryData
            .fromString(
                "{\"skus\":[\"cuh\",\"wtctyqi\",\"lbbovplw\",\"bhvgy\"],\"kind\":\"gu\",\"type\":\"svmkfssxquk\"}")
            .toObject(CheckSkuAvailabilityParameter.class);
        Assertions.assertEquals("cuh", model.skus().get(0));
        Assertions.assertEquals("gu", model.kind());
        Assertions.assertEquals("svmkfssxquk", model.type());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        CheckSkuAvailabilityParameter model
            = new CheckSkuAvailabilityParameter().withSkus(Arrays.asList("cuh", "wtctyqi", "lbbovplw", "bhvgy"))
                .withKind("gu")
                .withType("svmkfssxquk");
        model = BinaryData.fromObject(model).toObject(CheckSkuAvailabilityParameter.class);
        Assertions.assertEquals("cuh", model.skus().get(0));
        Assertions.assertEquals("gu", model.kind());
        Assertions.assertEquals("svmkfssxquk", model.type());
    }
}
