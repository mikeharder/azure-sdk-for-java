// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.avs.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.avs.models.AddonVrProperties;
import org.junit.jupiter.api.Assertions;

public final class AddonVrPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AddonVrProperties model
            = BinaryData.fromString("{\"addonType\":\"VR\",\"vrsCount\":2125136939,\"provisioningState\":\"Canceled\"}")
                .toObject(AddonVrProperties.class);
        Assertions.assertEquals(2125136939, model.vrsCount());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AddonVrProperties model = new AddonVrProperties().withVrsCount(2125136939);
        model = BinaryData.fromObject(model).toObject(AddonVrProperties.class);
        Assertions.assertEquals(2125136939, model.vrsCount());
    }
}
