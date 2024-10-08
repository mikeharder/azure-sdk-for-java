// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.VariableSpecification;
import com.azure.resourcemanager.datafactory.models.VariableType;
import org.junit.jupiter.api.Assertions;

public final class VariableSpecificationTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        VariableSpecification model
            = BinaryData.fromString("{\"type\":\"String\",\"defaultValue\":\"datadxpgpqchiszepnnb\"}")
                .toObject(VariableSpecification.class);
        Assertions.assertEquals(VariableType.STRING, model.type());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        VariableSpecification model
            = new VariableSpecification().withType(VariableType.STRING).withDefaultValue("datadxpgpqchiszepnnb");
        model = BinaryData.fromObject(model).toObject(VariableSpecification.class);
        Assertions.assertEquals(VariableType.STRING, model.type());
    }
}
