// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.machinelearning.fluent.models.ComponentVersionInner;
import com.azure.resourcemanager.machinelearning.models.ComponentVersionProperties;
import com.azure.resourcemanager.machinelearning.models.ComponentVersionResourceArmPaginatedResult;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class ComponentVersionResourceArmPaginatedResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ComponentVersionResourceArmPaginatedResult model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"componentSpec\":\"dataqqaatjinrvgou\",\"provisioningState\":\"Updating\",\"isArchived\":false,\"isAnonymous\":true,\"description\":\"gjio\",\"tags\":{\"qwjygvja\":\"rwxkvtkkgl\",\"vkzuhbxvvyhgso\":\"vblm\"},\"properties\":{\"bnhlmc\":\"rqufegxuvwz\",\"dn\":\"l\",\"ijejvegrhbpn\":\"itvgbmhrixkwm\"}},\"id\":\"xexccbdreaxhcexd\",\"name\":\"rvqahqkghtpwi\",\"type\":\"nhyjsv\"},{\"properties\":{\"componentSpec\":\"datacxzbfvoowvr\",\"provisioningState\":\"Updating\",\"isArchived\":true,\"isAnonymous\":true,\"description\":\"y\",\"tags\":{\"sxkm\":\"ronzmyhgfip\",\"hjglikk\":\"waekrrjreafxtsgu\",\"uzlm\":\"wslolbqp\"},\"properties\":{\"noigbrnjwmwk\":\"lfktgplcrpwjxe\"}},\"id\":\"bsazejjoqka\",\"name\":\"fhsxttaugz\",\"type\":\"nfaazpxdtnkdmkq\"}],\"nextLink\":\"lwuenvrkp\"}")
            .toObject(ComponentVersionResourceArmPaginatedResult.class);
        Assertions.assertEquals("gjio", model.value().get(0).properties().description());
        Assertions.assertEquals("rwxkvtkkgl", model.value().get(0).properties().tags().get("qwjygvja"));
        Assertions.assertEquals("rqufegxuvwz", model.value().get(0).properties().properties().get("bnhlmc"));
        Assertions.assertEquals(false, model.value().get(0).properties().isArchived());
        Assertions.assertEquals(true, model.value().get(0).properties().isAnonymous());
        Assertions.assertEquals("lwuenvrkp", model.nextLink());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ComponentVersionResourceArmPaginatedResult model
            = new ComponentVersionResourceArmPaginatedResult()
                .withValue(
                    Arrays
                        .asList(
                            new ComponentVersionInner()
                                .withProperties(new ComponentVersionProperties().withDescription("gjio")
                                    .withTags(mapOf("qwjygvja", "rwxkvtkkgl", "vkzuhbxvvyhgso", "vblm"))
                                    .withProperties(
                                        mapOf("bnhlmc", "rqufegxuvwz", "dn", "l", "ijejvegrhbpn", "itvgbmhrixkwm"))
                                    .withIsArchived(false)
                                    .withIsAnonymous(true)
                                    .withComponentSpec("dataqqaatjinrvgou")),
                            new ComponentVersionInner()
                                .withProperties(new ComponentVersionProperties().withDescription("y")
                                    .withTags(
                                        mapOf("sxkm", "ronzmyhgfip", "hjglikk", "waekrrjreafxtsgu", "uzlm", "wslolbqp"))
                                    .withProperties(mapOf("noigbrnjwmwk", "lfktgplcrpwjxe"))
                                    .withIsArchived(true)
                                    .withIsAnonymous(true)
                                    .withComponentSpec("datacxzbfvoowvr"))))
                .withNextLink("lwuenvrkp");
        model = BinaryData.fromObject(model).toObject(ComponentVersionResourceArmPaginatedResult.class);
        Assertions.assertEquals("gjio", model.value().get(0).properties().description());
        Assertions.assertEquals("rwxkvtkkgl", model.value().get(0).properties().tags().get("qwjygvja"));
        Assertions.assertEquals("rqufegxuvwz", model.value().get(0).properties().properties().get("bnhlmc"));
        Assertions.assertEquals(false, model.value().get(0).properties().isArchived());
        Assertions.assertEquals(true, model.value().get(0).properties().isAnonymous());
        Assertions.assertEquals("lwuenvrkp", model.nextLink());
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
