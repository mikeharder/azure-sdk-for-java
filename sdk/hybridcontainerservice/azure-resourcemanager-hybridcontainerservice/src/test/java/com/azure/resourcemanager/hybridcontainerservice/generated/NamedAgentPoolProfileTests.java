// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcontainerservice.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.hybridcontainerservice.models.NamedAgentPoolProfile;
import com.azure.resourcemanager.hybridcontainerservice.models.OsType;
import com.azure.resourcemanager.hybridcontainerservice.models.Ossku;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class NamedAgentPoolProfileTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        NamedAgentPoolProfile model = BinaryData.fromString(
            "{\"count\":1770977837,\"vmSize\":\"jnqglhqgnu\",\"kubernetesVersion\":\"oo\",\"name\":\"wifsq\",\"osType\":\"Windows\",\"osSKU\":\"CBLMariner\",\"nodeLabels\":{\"rifkwm\":\"mglzlhj\"},\"nodeTaints\":[\"tsizntocipaoua\",\"psqucmpoyf\",\"kfo\",\"knygjofjddeq\"],\"maxCount\":752788462,\"minCount\":1305479900,\"enableAutoScaling\":true,\"maxPods\":727938504}")
            .toObject(NamedAgentPoolProfile.class);
        Assertions.assertEquals(OsType.WINDOWS, model.osType());
        Assertions.assertEquals(Ossku.CBLMARINER, model.osSku());
        Assertions.assertEquals("mglzlhj", model.nodeLabels().get("rifkwm"));
        Assertions.assertEquals("tsizntocipaoua", model.nodeTaints().get(0));
        Assertions.assertEquals(752788462, model.maxCount());
        Assertions.assertEquals(1305479900, model.minCount());
        Assertions.assertEquals(true, model.enableAutoScaling());
        Assertions.assertEquals(727938504, model.maxPods());
        Assertions.assertEquals(1770977837, model.count());
        Assertions.assertEquals("jnqglhqgnu", model.vmSize());
        Assertions.assertEquals("wifsq", model.name());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        NamedAgentPoolProfile model = new NamedAgentPoolProfile().withOsType(OsType.WINDOWS)
            .withOsSku(Ossku.CBLMARINER)
            .withNodeLabels(mapOf("rifkwm", "mglzlhj"))
            .withNodeTaints(Arrays.asList("tsizntocipaoua", "psqucmpoyf", "kfo", "knygjofjddeq"))
            .withMaxCount(752788462)
            .withMinCount(1305479900)
            .withEnableAutoScaling(true)
            .withMaxPods(727938504)
            .withCount(1770977837)
            .withVmSize("jnqglhqgnu")
            .withName("wifsq");
        model = BinaryData.fromObject(model).toObject(NamedAgentPoolProfile.class);
        Assertions.assertEquals(OsType.WINDOWS, model.osType());
        Assertions.assertEquals(Ossku.CBLMARINER, model.osSku());
        Assertions.assertEquals("mglzlhj", model.nodeLabels().get("rifkwm"));
        Assertions.assertEquals("tsizntocipaoua", model.nodeTaints().get(0));
        Assertions.assertEquals(752788462, model.maxCount());
        Assertions.assertEquals(1305479900, model.minCount());
        Assertions.assertEquals(true, model.enableAutoScaling());
        Assertions.assertEquals(727938504, model.maxPods());
        Assertions.assertEquals(1770977837, model.count());
        Assertions.assertEquals("jnqglhqgnu", model.vmSize());
        Assertions.assertEquals("wifsq", model.name());
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
