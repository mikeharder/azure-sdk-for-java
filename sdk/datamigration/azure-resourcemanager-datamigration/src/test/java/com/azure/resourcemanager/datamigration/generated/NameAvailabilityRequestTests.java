// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datamigration.models.NameAvailabilityRequest;
import org.junit.jupiter.api.Assertions;

public final class NameAvailabilityRequestTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        NameAvailabilityRequest model =
            BinaryData
                .fromString("{\"name\":\"aop\",\"type\":\"mijcmmxdcufufs\"}")
                .toObject(NameAvailabilityRequest.class);
        Assertions.assertEquals("aop", model.name());
        Assertions.assertEquals("mijcmmxdcufufs", model.type());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        NameAvailabilityRequest model = new NameAvailabilityRequest().withName("aop").withType("mijcmmxdcufufs");
        model = BinaryData.fromObject(model).toObject(NameAvailabilityRequest.class);
        Assertions.assertEquals("aop", model.name());
        Assertions.assertEquals("mijcmmxdcufufs", model.type());
    }
}
