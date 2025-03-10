// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.fluent.models.DataLakeAnalyticsUsqlActivityTypeProperties;
import com.azure.resourcemanager.datafactory.models.LinkedServiceReference;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class DataLakeAnalyticsUsqlActivityTypePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DataLakeAnalyticsUsqlActivityTypeProperties model = BinaryData.fromString(
            "{\"scriptPath\":\"dataqzmwxoogi\",\"scriptLinkedService\":{\"referenceName\":\"gnplzbtvpuigtnjy\",\"parameters\":{\"extlyyvebpykzhr\":\"datavvitxoitnqmiwlri\"}},\"degreeOfParallelism\":\"datasbtwpvmz\",\"priority\":\"dataxepapmv\",\"parameters\":{\"kylu\":\"datas\",\"tefbbr\":\"dataxndmtasxsnb\",\"oh\":\"datalofkvshozjkwjwv\"},\"runtimeVersion\":\"datasg\",\"compilationMode\":\"datafzstyacbekc\"}")
            .toObject(DataLakeAnalyticsUsqlActivityTypeProperties.class);
        Assertions.assertEquals("gnplzbtvpuigtnjy", model.scriptLinkedService().referenceName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DataLakeAnalyticsUsqlActivityTypeProperties model
            = new DataLakeAnalyticsUsqlActivityTypeProperties().withScriptPath("dataqzmwxoogi")
                .withScriptLinkedService(new LinkedServiceReference().withReferenceName("gnplzbtvpuigtnjy")
                    .withParameters(mapOf("extlyyvebpykzhr", "datavvitxoitnqmiwlri")))
                .withDegreeOfParallelism("datasbtwpvmz")
                .withPriority("dataxepapmv")
                .withParameters(mapOf("kylu", "datas", "tefbbr", "dataxndmtasxsnb", "oh", "datalofkvshozjkwjwv"))
                .withRuntimeVersion("datasg")
                .withCompilationMode("datafzstyacbekc");
        model = BinaryData.fromObject(model).toObject(DataLakeAnalyticsUsqlActivityTypeProperties.class);
        Assertions.assertEquals("gnplzbtvpuigtnjy", model.scriptLinkedService().referenceName());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
