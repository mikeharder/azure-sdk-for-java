// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.fabric.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.fabric.fluent.models.CheckNameAvailabilityResponseInner;
import com.azure.resourcemanager.fabric.models.CheckNameAvailabilityReason;
import org.junit.jupiter.api.Assertions;

public final class CheckNameAvailabilityResponseInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        CheckNameAvailabilityResponseInner model
            = BinaryData.fromString("{\"nameAvailable\":false,\"reason\":\"Invalid\",\"message\":\"jhqjbasvmsmjqul\"}")
                .toObject(CheckNameAvailabilityResponseInner.class);
        Assertions.assertEquals(false, model.nameAvailable());
        Assertions.assertEquals(CheckNameAvailabilityReason.INVALID, model.reason());
        Assertions.assertEquals("jhqjbasvmsmjqul", model.message());
    }
}
