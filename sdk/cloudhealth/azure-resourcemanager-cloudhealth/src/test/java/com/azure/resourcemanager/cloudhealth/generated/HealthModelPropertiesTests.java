// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.cloudhealth.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.cloudhealth.models.DiscoveryRuleRecommendedSignalsBehavior;
import com.azure.resourcemanager.cloudhealth.models.HealthModelProperties;
import com.azure.resourcemanager.cloudhealth.models.ModelDiscoverySettings;
import org.junit.jupiter.api.Assertions;

public final class HealthModelPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        HealthModelProperties model = BinaryData.fromString(
            "{\"dataplaneEndpoint\":\"jbp\",\"provisioningState\":\"Canceled\",\"discovery\":{\"scope\":\"inzgvfcj\",\"addRecommendedSignals\":\"Enabled\",\"identity\":\"oxxjtfelluwf\"}}")
            .toObject(HealthModelProperties.class);
        Assertions.assertEquals("inzgvfcj", model.discovery().scope());
        Assertions.assertEquals(DiscoveryRuleRecommendedSignalsBehavior.ENABLED,
            model.discovery().addRecommendedSignals());
        Assertions.assertEquals("oxxjtfelluwf", model.discovery().identity());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        HealthModelProperties model
            = new HealthModelProperties().withDiscovery(new ModelDiscoverySettings().withScope("inzgvfcj")
                .withAddRecommendedSignals(DiscoveryRuleRecommendedSignalsBehavior.ENABLED)
                .withIdentity("oxxjtfelluwf"));
        model = BinaryData.fromObject(model).toObject(HealthModelProperties.class);
        Assertions.assertEquals("inzgvfcj", model.discovery().scope());
        Assertions.assertEquals(DiscoveryRuleRecommendedSignalsBehavior.ENABLED,
            model.discovery().addRecommendedSignals());
        Assertions.assertEquals("oxxjtfelluwf", model.discovery().identity());
    }
}
