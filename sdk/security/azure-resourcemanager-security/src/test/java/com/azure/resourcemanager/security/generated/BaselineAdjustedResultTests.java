// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.Baseline;
import com.azure.resourcemanager.security.models.BaselineAdjustedResult;
import com.azure.resourcemanager.security.models.RuleStatus;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class BaselineAdjustedResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        BaselineAdjustedResult model =
            BinaryData
                .fromString(
                    "{\"baseline\":{\"expectedResults\":[[\"oqc\"]],\"updatedTime\":\"2021-03-15T06:39:11Z\"},\"status\":\"InternalError\",\"resultsNotInBaseline\":[[\"kuejk\",\"vbiztjofqcv\"],[\"juf\",\"csjml\",\"e\"]],\"resultsOnlyInBaseline\":[[\"iriuxegthortu\",\"awlpjfelqerpp\"]]}")
                .toObject(BaselineAdjustedResult.class);
        Assertions.assertEquals("oqc", model.baseline().expectedResults().get(0).get(0));
        Assertions.assertEquals(OffsetDateTime.parse("2021-03-15T06:39:11Z"), model.baseline().updatedTime());
        Assertions.assertEquals(RuleStatus.INTERNAL_ERROR, model.status());
        Assertions.assertEquals("kuejk", model.resultsNotInBaseline().get(0).get(0));
        Assertions.assertEquals("iriuxegthortu", model.resultsOnlyInBaseline().get(0).get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        BaselineAdjustedResult model =
            new BaselineAdjustedResult()
                .withBaseline(
                    new Baseline()
                        .withExpectedResults(Arrays.asList(Arrays.asList("oqc")))
                        .withUpdatedTime(OffsetDateTime.parse("2021-03-15T06:39:11Z")))
                .withStatus(RuleStatus.INTERNAL_ERROR)
                .withResultsNotInBaseline(
                    Arrays.asList(Arrays.asList("kuejk", "vbiztjofqcv"), Arrays.asList("juf", "csjml", "e")))
                .withResultsOnlyInBaseline(Arrays.asList(Arrays.asList("iriuxegthortu", "awlpjfelqerpp")));
        model = BinaryData.fromObject(model).toObject(BaselineAdjustedResult.class);
        Assertions.assertEquals("oqc", model.baseline().expectedResults().get(0).get(0));
        Assertions.assertEquals(OffsetDateTime.parse("2021-03-15T06:39:11Z"), model.baseline().updatedTime());
        Assertions.assertEquals(RuleStatus.INTERNAL_ERROR, model.status());
        Assertions.assertEquals("kuejk", model.resultsNotInBaseline().get(0).get(0));
        Assertions.assertEquals("iriuxegthortu", model.resultsOnlyInBaseline().get(0).get(0));
    }
}