// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.chaos.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.chaos.fluent.models.ExperimentExecutionDetailsInner;

public final class ExperimentExecutionDetailsInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ExperimentExecutionDetailsInner model = BinaryData.fromString(
            "{\"type\":\"udwtiukbl\",\"id\":\"gkpocipazyxoe\",\"name\":\"kgjn\",\"properties\":{\"status\":\"cgygev\",\"startedAt\":\"2021-06-11T02:44:35Z\",\"stoppedAt\":\"2021-06-23T19:38:39Z\",\"failureReason\":\"mrbpizcdrqj\",\"lastActionAt\":\"2021-09-28T20:18:05Z\",\"runInformation\":{\"steps\":[{\"stepName\":\"yhxdeoejzicwi\",\"stepId\":\"jttgzf\",\"status\":\"shcbkhajdeyeamdp\",\"branches\":[{}]},{\"stepName\":\"lpbuxwgipwhonowk\",\"stepId\":\"hwankixzbinjepu\",\"status\":\"mryw\",\"branches\":[{},{},{},{}]}]}}}")
            .toObject(ExperimentExecutionDetailsInner.class);
    }
}
