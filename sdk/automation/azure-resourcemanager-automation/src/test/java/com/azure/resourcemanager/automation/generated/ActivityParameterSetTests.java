// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.automation.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.automation.models.ActivityParameter;
import com.azure.resourcemanager.automation.models.ActivityParameterSet;
import com.azure.resourcemanager.automation.models.ActivityParameterValidationSet;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class ActivityParameterSetTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ActivityParameterSet model = BinaryData.fromString(
            "{\"name\":\"jcrxgibbdaxcon\",\"parameters\":[{\"name\":\"uors\",\"type\":\"okwbqplh\",\"isMandatory\":true,\"isDynamic\":false,\"position\":7056990023571937899,\"valueFromPipeline\":false,\"valueFromPipelineByPropertyName\":false,\"valueFromRemainingArguments\":false,\"description\":\"oldweyuqdu\",\"validationSet\":[{\"memberValue\":\"nrwrbiork\"},{\"memberValue\":\"lywjhh\"}]},{\"name\":\"nhxmsi\",\"type\":\"omi\",\"isMandatory\":false,\"isDynamic\":false,\"position\":4807237335933132468,\"valueFromPipeline\":false,\"valueFromPipelineByPropertyName\":true,\"valueFromRemainingArguments\":false,\"description\":\"zaofjchvcyy\",\"validationSet\":[{\"memberValue\":\"dotcubiipuip\"}]}]}")
            .toObject(ActivityParameterSet.class);
        Assertions.assertEquals("jcrxgibbdaxcon", model.name());
        Assertions.assertEquals("uors", model.parameters().get(0).name());
        Assertions.assertEquals("okwbqplh", model.parameters().get(0).type());
        Assertions.assertEquals(true, model.parameters().get(0).isMandatory());
        Assertions.assertEquals(false, model.parameters().get(0).isDynamic());
        Assertions.assertEquals(7056990023571937899L, model.parameters().get(0).position());
        Assertions.assertEquals(false, model.parameters().get(0).valueFromPipeline());
        Assertions.assertEquals(false, model.parameters().get(0).valueFromPipelineByPropertyName());
        Assertions.assertEquals(false, model.parameters().get(0).valueFromRemainingArguments());
        Assertions.assertEquals("oldweyuqdu", model.parameters().get(0).description());
        Assertions.assertEquals("nrwrbiork", model.parameters().get(0).validationSet().get(0).memberValue());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ActivityParameterSet model = new ActivityParameterSet().withName("jcrxgibbdaxcon")
            .withParameters(Arrays.asList(
                new ActivityParameter().withName("uors")
                    .withType("okwbqplh")
                    .withIsMandatory(true)
                    .withIsDynamic(false)
                    .withPosition(7056990023571937899L)
                    .withValueFromPipeline(false)
                    .withValueFromPipelineByPropertyName(false)
                    .withValueFromRemainingArguments(false)
                    .withDescription("oldweyuqdu")
                    .withValidationSet(Arrays.asList(new ActivityParameterValidationSet().withMemberValue("nrwrbiork"),
                        new ActivityParameterValidationSet().withMemberValue("lywjhh"))),
                new ActivityParameter().withName("nhxmsi")
                    .withType("omi")
                    .withIsMandatory(false)
                    .withIsDynamic(false)
                    .withPosition(4807237335933132468L)
                    .withValueFromPipeline(false)
                    .withValueFromPipelineByPropertyName(true)
                    .withValueFromRemainingArguments(false)
                    .withDescription("zaofjchvcyy")
                    .withValidationSet(
                        Arrays.asList(new ActivityParameterValidationSet().withMemberValue("dotcubiipuip")))));
        model = BinaryData.fromObject(model).toObject(ActivityParameterSet.class);
        Assertions.assertEquals("jcrxgibbdaxcon", model.name());
        Assertions.assertEquals("uors", model.parameters().get(0).name());
        Assertions.assertEquals("okwbqplh", model.parameters().get(0).type());
        Assertions.assertEquals(true, model.parameters().get(0).isMandatory());
        Assertions.assertEquals(false, model.parameters().get(0).isDynamic());
        Assertions.assertEquals(7056990023571937899L, model.parameters().get(0).position());
        Assertions.assertEquals(false, model.parameters().get(0).valueFromPipeline());
        Assertions.assertEquals(false, model.parameters().get(0).valueFromPipelineByPropertyName());
        Assertions.assertEquals(false, model.parameters().get(0).valueFromRemainingArguments());
        Assertions.assertEquals("oldweyuqdu", model.parameters().get(0).description());
        Assertions.assertEquals("nrwrbiork", model.parameters().get(0).validationSet().get(0).memberValue());
    }
}
