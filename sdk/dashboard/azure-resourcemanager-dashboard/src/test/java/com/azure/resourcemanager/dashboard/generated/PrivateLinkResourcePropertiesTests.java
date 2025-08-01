// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.dashboard.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.dashboard.fluent.models.PrivateLinkResourceProperties;
import org.junit.jupiter.api.Assertions;

public final class PrivateLinkResourcePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PrivateLinkResourceProperties model = BinaryData.fromString(
            "{\"provisioningState\":\"Deleting\",\"groupId\":\"d\",\"requiredMembers\":[\"dsbdkvwrwjf\"],\"requiredZoneNames\":[\"nhutjeltmrldhugj\"]}")
            .toObject(PrivateLinkResourceProperties.class);
        Assertions.assertEquals("nhutjeltmrldhugj", model.requiredZoneNames().get(0));
    }
}
