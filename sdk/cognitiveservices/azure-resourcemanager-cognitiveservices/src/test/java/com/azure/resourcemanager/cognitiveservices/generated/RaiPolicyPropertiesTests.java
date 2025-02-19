// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.cognitiveservices.models.ContentLevel;
import com.azure.resourcemanager.cognitiveservices.models.CustomBlocklistConfig;
import com.azure.resourcemanager.cognitiveservices.models.RaiPolicyContentFilter;
import com.azure.resourcemanager.cognitiveservices.models.RaiPolicyContentSource;
import com.azure.resourcemanager.cognitiveservices.models.RaiPolicyMode;
import com.azure.resourcemanager.cognitiveservices.models.RaiPolicyProperties;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class RaiPolicyPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        RaiPolicyProperties model = BinaryData.fromString(
            "{\"type\":\"UserManaged\",\"mode\":\"Deferred\",\"basePolicyName\":\"lhlv\",\"contentFilters\":[{\"name\":\"pzlrphw\",\"enabled\":true,\"severityThreshold\":\"Low\",\"blocking\":true,\"source\":\"Completion\"},{\"name\":\"dunvmnnrwrbiorkt\",\"enabled\":true,\"severityThreshold\":\"Low\",\"blocking\":true,\"source\":\"Prompt\"}],\"customBlocklists\":[{\"source\":\"Prompt\",\"blocklistName\":\"ivfomiloxgg\",\"blocking\":false},{\"source\":\"Prompt\",\"blocklistName\":\"dieuzaofj\",\"blocking\":false}]}")
            .toObject(RaiPolicyProperties.class);
        Assertions.assertEquals(RaiPolicyMode.DEFERRED, model.mode());
        Assertions.assertEquals("lhlv", model.basePolicyName());
        Assertions.assertEquals("pzlrphw", model.contentFilters().get(0).name());
        Assertions.assertEquals(true, model.contentFilters().get(0).enabled());
        Assertions.assertEquals(ContentLevel.LOW, model.contentFilters().get(0).severityThreshold());
        Assertions.assertEquals(true, model.contentFilters().get(0).blocking());
        Assertions.assertEquals(RaiPolicyContentSource.COMPLETION, model.contentFilters().get(0).source());
        Assertions.assertEquals("ivfomiloxgg", model.customBlocklists().get(0).blocklistName());
        Assertions.assertEquals(false, model.customBlocklists().get(0).blocking());
        Assertions.assertEquals(RaiPolicyContentSource.PROMPT, model.customBlocklists().get(0).source());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        RaiPolicyProperties model = new RaiPolicyProperties().withMode(RaiPolicyMode.DEFERRED)
            .withBasePolicyName("lhlv")
            .withContentFilters(Arrays.asList(
                new RaiPolicyContentFilter().withName("pzlrphw")
                    .withEnabled(true)
                    .withSeverityThreshold(ContentLevel.LOW)
                    .withBlocking(true)
                    .withSource(RaiPolicyContentSource.COMPLETION),
                new RaiPolicyContentFilter().withName("dunvmnnrwrbiorkt")
                    .withEnabled(true)
                    .withSeverityThreshold(ContentLevel.LOW)
                    .withBlocking(true)
                    .withSource(RaiPolicyContentSource.PROMPT)))
            .withCustomBlocklists(Arrays.asList(
                new CustomBlocklistConfig().withBlocklistName("ivfomiloxgg")
                    .withBlocking(false)
                    .withSource(RaiPolicyContentSource.PROMPT),
                new CustomBlocklistConfig().withBlocklistName("dieuzaofj")
                    .withBlocking(false)
                    .withSource(RaiPolicyContentSource.PROMPT)));
        model = BinaryData.fromObject(model).toObject(RaiPolicyProperties.class);
        Assertions.assertEquals(RaiPolicyMode.DEFERRED, model.mode());
        Assertions.assertEquals("lhlv", model.basePolicyName());
        Assertions.assertEquals("pzlrphw", model.contentFilters().get(0).name());
        Assertions.assertEquals(true, model.contentFilters().get(0).enabled());
        Assertions.assertEquals(ContentLevel.LOW, model.contentFilters().get(0).severityThreshold());
        Assertions.assertEquals(true, model.contentFilters().get(0).blocking());
        Assertions.assertEquals(RaiPolicyContentSource.COMPLETION, model.contentFilters().get(0).source());
        Assertions.assertEquals("ivfomiloxgg", model.customBlocklists().get(0).blocklistName());
        Assertions.assertEquals(false, model.customBlocklists().get(0).blocking());
        Assertions.assertEquals(RaiPolicyContentSource.PROMPT, model.customBlocklists().get(0).source());
    }
}
