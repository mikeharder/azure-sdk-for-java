// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.providerhub.models.ThrottlingMetric;
import com.azure.resourcemanager.providerhub.models.ThrottlingMetricType;
import com.azure.resourcemanager.providerhub.models.ThrottlingRule;
import java.time.Duration;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class ThrottlingRuleTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ThrottlingRule model = BinaryData.fromString(
            "{\"action\":\"vudwtiukbldng\",\"metrics\":[{\"type\":\"NumberOfResources\",\"limit\":9183547158611084836,\"interval\":\"PT192H57M25S\"},{\"type\":\"NotSpecified\",\"limit\":2857636660248584289,\"interval\":\"PT216H23M56S\"},{\"type\":\"NumberOfResources\",\"limit\":7699505413324678544,\"interval\":\"PT179H47M46S\"},{\"type\":\"NumberOfResources\",\"limit\":2759352392811439395,\"interval\":\"PT86H39M26S\"}],\"requiredFeatures\":[\"gevqznty\",\"mrbpizcdrqj\",\"dpydn\",\"yhxdeoejzicwi\"],\"applicationId\":[\"ttgzfbis\",\"cbkhajdeyeamdph\"]}")
            .toObject(ThrottlingRule.class);
        Assertions.assertEquals("vudwtiukbldng", model.action());
        Assertions.assertEquals(ThrottlingMetricType.NUMBER_OF_RESOURCES, model.metrics().get(0).type());
        Assertions.assertEquals(9183547158611084836L, model.metrics().get(0).limit());
        Assertions.assertEquals(Duration.parse("PT192H57M25S"), model.metrics().get(0).interval());
        Assertions.assertEquals("gevqznty", model.requiredFeatures().get(0));
        Assertions.assertEquals("ttgzfbis", model.applicationId().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ThrottlingRule model = new ThrottlingRule().withAction("vudwtiukbldng")
            .withMetrics(Arrays.asList(
                new ThrottlingMetric().withType(ThrottlingMetricType.NUMBER_OF_RESOURCES)
                    .withLimit(9183547158611084836L)
                    .withInterval(Duration.parse("PT192H57M25S")),
                new ThrottlingMetric().withType(ThrottlingMetricType.NOT_SPECIFIED)
                    .withLimit(2857636660248584289L)
                    .withInterval(Duration.parse("PT216H23M56S")),
                new ThrottlingMetric().withType(ThrottlingMetricType.NUMBER_OF_RESOURCES)
                    .withLimit(7699505413324678544L)
                    .withInterval(Duration.parse("PT179H47M46S")),
                new ThrottlingMetric().withType(ThrottlingMetricType.NUMBER_OF_RESOURCES)
                    .withLimit(2759352392811439395L)
                    .withInterval(Duration.parse("PT86H39M26S"))))
            .withRequiredFeatures(Arrays.asList("gevqznty", "mrbpizcdrqj", "dpydn", "yhxdeoejzicwi"))
            .withApplicationId(Arrays.asList("ttgzfbis", "cbkhajdeyeamdph"));
        model = BinaryData.fromObject(model).toObject(ThrottlingRule.class);
        Assertions.assertEquals("vudwtiukbldng", model.action());
        Assertions.assertEquals(ThrottlingMetricType.NUMBER_OF_RESOURCES, model.metrics().get(0).type());
        Assertions.assertEquals(9183547158611084836L, model.metrics().get(0).limit());
        Assertions.assertEquals(Duration.parse("PT192H57M25S"), model.metrics().get(0).interval());
        Assertions.assertEquals("gevqznty", model.requiredFeatures().get(0));
        Assertions.assertEquals("ttgzfbis", model.applicationId().get(0));
    }
}
