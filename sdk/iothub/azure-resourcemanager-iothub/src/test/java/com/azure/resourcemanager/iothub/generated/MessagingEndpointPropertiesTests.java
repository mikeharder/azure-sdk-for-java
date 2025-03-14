// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.iothub.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.iothub.models.MessagingEndpointProperties;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;

public final class MessagingEndpointPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        MessagingEndpointProperties model = BinaryData.fromString(
            "{\"lockDurationAsIso8601\":\"PT135H19M21S\",\"ttlAsIso8601\":\"PT18M41S\",\"maxDeliveryCount\":1400002261}")
            .toObject(MessagingEndpointProperties.class);
        Assertions.assertEquals(Duration.parse("PT135H19M21S"), model.lockDurationAsIso8601());
        Assertions.assertEquals(Duration.parse("PT18M41S"), model.ttlAsIso8601());
        Assertions.assertEquals(1400002261, model.maxDeliveryCount());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        MessagingEndpointProperties model
            = new MessagingEndpointProperties().withLockDurationAsIso8601(Duration.parse("PT135H19M21S"))
                .withTtlAsIso8601(Duration.parse("PT18M41S"))
                .withMaxDeliveryCount(1400002261);
        model = BinaryData.fromObject(model).toObject(MessagingEndpointProperties.class);
        Assertions.assertEquals(Duration.parse("PT135H19M21S"), model.lockDurationAsIso8601());
        Assertions.assertEquals(Duration.parse("PT18M41S"), model.ttlAsIso8601());
        Assertions.assertEquals(1400002261, model.maxDeliveryCount());
    }
}
