// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.subscription.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.subscription.models.SubscriptionPolicies;

public final class SubscriptionPoliciesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SubscriptionPolicies model = BinaryData
            .fromString("{\"locationPlacementId\":\"vd\",\"quotaId\":\"jgrtfwvukxga\",\"spendingLimit\":\"Off\"}")
            .toObject(SubscriptionPolicies.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SubscriptionPolicies model = new SubscriptionPolicies();
        model = BinaryData.fromObject(model).toObject(SubscriptionPolicies.class);
    }
}
