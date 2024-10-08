// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.billing.models.PaymentOnAccountAmount;

public final class PaymentOnAccountAmountTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PaymentOnAccountAmount model = BinaryData.fromString("{\"currency\":\"hajdeyeamdpha\",\"value\":99.485886}")
            .toObject(PaymentOnAccountAmount.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PaymentOnAccountAmount model = new PaymentOnAccountAmount();
        model = BinaryData.fromObject(model).toObject(PaymentOnAccountAmount.class);
    }
}
