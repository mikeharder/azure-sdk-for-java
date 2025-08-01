// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.providerhub.models.FeaturesPolicy;
import com.azure.resourcemanager.providerhub.models.ResourceTypeRegistrationPropertiesFeaturesRule;
import org.junit.jupiter.api.Assertions;

public final class ResourceTypeRegistrationPropertiesFeaturesRuleTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ResourceTypeRegistrationPropertiesFeaturesRule model
            = BinaryData.fromString("{\"requiredFeaturesPolicy\":\"All\"}")
                .toObject(ResourceTypeRegistrationPropertiesFeaturesRule.class);
        Assertions.assertEquals(FeaturesPolicy.ALL, model.requiredFeaturesPolicy());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ResourceTypeRegistrationPropertiesFeaturesRule model
            = new ResourceTypeRegistrationPropertiesFeaturesRule().withRequiredFeaturesPolicy(FeaturesPolicy.ALL);
        model = BinaryData.fromObject(model).toObject(ResourceTypeRegistrationPropertiesFeaturesRule.class);
        Assertions.assertEquals(FeaturesPolicy.ALL, model.requiredFeaturesPolicy());
    }
}
