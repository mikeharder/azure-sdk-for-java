// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.DatasetFolder;
import com.azure.resourcemanager.datafactory.models.LinkedServiceReference;
import com.azure.resourcemanager.datafactory.models.ParameterSpecification;
import com.azure.resourcemanager.datafactory.models.ParameterType;
import com.azure.resourcemanager.datafactory.models.XeroObjectDataset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class XeroObjectDatasetTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        XeroObjectDataset model = BinaryData.fromString(
            "{\"type\":\"XeroObject\",\"typeProperties\":{\"tableName\":\"datamjcoyvfwgkzuhksh\"},\"description\":\"kckwbqwjyfmmkwa\",\"structure\":\"dataooyzhob\",\"schema\":\"datayuepaco\",\"linkedServiceName\":{\"referenceName\":\"rohextigukf\",\"parameters\":{\"ymbnpeenlqtqyv\":\"dataycb\",\"avqdvfjdsqephtos\":\"datafb\",\"jwgujrc\":\"dataqtua\"}},\"parameters\":{\"wscjwyyeomifl\":{\"type\":\"Float\",\"defaultValue\":\"datapyqoizfyasyddq\"}},\"annotations\":[\"dataeowctshwfrhhas\",\"databvau\",\"datanwwumkbpg\",\"datailbwtpwbjlpfwuq\"],\"folder\":{\"name\":\"dgi\"},\"\":{\"plan\":\"datayukslizmpnxgham\"}}")
            .toObject(XeroObjectDataset.class);
        Assertions.assertEquals("kckwbqwjyfmmkwa", model.description());
        Assertions.assertEquals("rohextigukf", model.linkedServiceName().referenceName());
        Assertions.assertEquals(ParameterType.FLOAT, model.parameters().get("wscjwyyeomifl").type());
        Assertions.assertEquals("dgi", model.folder().name());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        XeroObjectDataset model = new XeroObjectDataset().withDescription("kckwbqwjyfmmkwa")
            .withStructure("dataooyzhob")
            .withSchema("datayuepaco")
            .withLinkedServiceName(new LinkedServiceReference().withReferenceName("rohextigukf")
                .withParameters(
                    mapOf("ymbnpeenlqtqyv", "dataycb", "avqdvfjdsqephtos", "datafb", "jwgujrc", "dataqtua")))
            .withParameters(mapOf("wscjwyyeomifl",
                new ParameterSpecification().withType(ParameterType.FLOAT).withDefaultValue("datapyqoizfyasyddq")))
            .withAnnotations(Arrays.asList("dataeowctshwfrhhas", "databvau", "datanwwumkbpg", "datailbwtpwbjlpfwuq"))
            .withFolder(new DatasetFolder().withName("dgi"))
            .withTableName("datamjcoyvfwgkzuhksh");
        model = BinaryData.fromObject(model).toObject(XeroObjectDataset.class);
        Assertions.assertEquals("kckwbqwjyfmmkwa", model.description());
        Assertions.assertEquals("rohextigukf", model.linkedServiceName().referenceName());
        Assertions.assertEquals(ParameterType.FLOAT, model.parameters().get("wscjwyyeomifl").type());
        Assertions.assertEquals("dgi", model.folder().name());
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
