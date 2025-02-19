// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.fluent.models.CustomActivityTypeProperties;
import com.azure.resourcemanager.datafactory.models.CustomActivityReferenceObject;
import com.azure.resourcemanager.datafactory.models.DatasetReference;
import com.azure.resourcemanager.datafactory.models.LinkedServiceReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class CustomActivityTypePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        CustomActivityTypeProperties model = BinaryData.fromString(
            "{\"command\":\"datajdu\",\"resourceLinkedService\":{\"referenceName\":\"xbrjdpeypuqwd\",\"parameters\":{\"xdeo\":\"datamfvxfssho\",\"fnreempbumyuiquz\":\"datanzprdgmmgtqgzdf\",\"facflkbgohxbj\":\"dataotfoifjrik\"}},\"folderPath\":\"datafpfxbqdrjunigx\",\"referenceObjects\":{\"linkedServices\":[{\"referenceName\":\"ghga\",\"parameters\":{\"wrncwhlxvngj\":\"datavenvrltijq\",\"bd\":\"datapydjdpapndmv\",\"xidecdehskmfiu\":\"datavvtapwkwkthm\"}},{\"referenceName\":\"npjzx\",\"parameters\":{\"kznffqv\":\"datasgyyrgdguvkgqllg\"}},{\"referenceName\":\"xnytihhqancw\",\"parameters\":{\"snbdfamyolvgksla\":\"datagdpfzdygtk\",\"rswvwzu\":\"datauon\",\"omxvbruzxsnz\":\"datatqcxoamxumwzduhi\"}}],\"datasets\":[{\"referenceName\":\"gf\",\"parameters\":{\"zclnqexlnpwpw\":\"datadouneozgnwmc\"}}]},\"extendedProperties\":{\"cfoqdspslcvpqwrs\":\"datasjkondrk\",\"g\":\"datadpikx\",\"phcwzdwvyjz\":\"dataaegrppwoligfljt\",\"mfoztwmvprn\":\"datakvycinmywjcf\"},\"retentionTimeInDays\":\"dataxsexzxbiwnqe\",\"autoUserSpecification\":\"datatbztog\"}")
            .toObject(CustomActivityTypeProperties.class);
        Assertions.assertEquals("xbrjdpeypuqwd", model.resourceLinkedService().referenceName());
        Assertions.assertEquals("ghga", model.referenceObjects().linkedServices().get(0).referenceName());
        Assertions.assertEquals("gf", model.referenceObjects().datasets().get(0).referenceName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        CustomActivityTypeProperties model = new CustomActivityTypeProperties().withCommand("datajdu")
            .withResourceLinkedService(new LinkedServiceReference().withReferenceName("xbrjdpeypuqwd")
                .withParameters(mapOf("xdeo", "datamfvxfssho", "fnreempbumyuiquz", "datanzprdgmmgtqgzdf",
                    "facflkbgohxbj", "dataotfoifjrik")))
            .withFolderPath("datafpfxbqdrjunigx")
            .withReferenceObjects(new CustomActivityReferenceObject()
                .withLinkedServices(Arrays.asList(
                    new LinkedServiceReference().withReferenceName("ghga")
                        .withParameters(mapOf("wrncwhlxvngj", "datavenvrltijq", "bd", "datapydjdpapndmv",
                            "xidecdehskmfiu", "datavvtapwkwkthm")),
                    new LinkedServiceReference().withReferenceName("npjzx")
                        .withParameters(mapOf("kznffqv", "datasgyyrgdguvkgqllg")),
                    new LinkedServiceReference().withReferenceName("xnytihhqancw")
                        .withParameters(mapOf("snbdfamyolvgksla", "datagdpfzdygtk", "rswvwzu", "datauon",
                            "omxvbruzxsnz", "datatqcxoamxumwzduhi"))))
                .withDatasets(Arrays.asList(new DatasetReference().withReferenceName("gf")
                    .withParameters(mapOf("zclnqexlnpwpw", "datadouneozgnwmc")))))
            .withExtendedProperties(mapOf("cfoqdspslcvpqwrs", "datasjkondrk", "g", "datadpikx", "phcwzdwvyjz",
                "dataaegrppwoligfljt", "mfoztwmvprn", "datakvycinmywjcf"))
            .withRetentionTimeInDays("dataxsexzxbiwnqe")
            .withAutoUserSpecification("datatbztog");
        model = BinaryData.fromObject(model).toObject(CustomActivityTypeProperties.class);
        Assertions.assertEquals("xbrjdpeypuqwd", model.resourceLinkedService().referenceName());
        Assertions.assertEquals("ghga", model.referenceObjects().linkedServices().get(0).referenceName());
        Assertions.assertEquals("gf", model.referenceObjects().datasets().get(0).referenceName());
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
