// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.netapp.fluent.models.BackupPolicyInner;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class BackupPolicyInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        BackupPolicyInner model = BinaryData.fromString(
            "{\"etag\":\"xexccbdreaxhcexd\",\"properties\":{\"backupPolicyId\":\"vqahqkghtpwi\",\"provisioningState\":\"hyjsvfycx\",\"dailyBackupsToKeep\":1220802910,\"weeklyBackupsToKeep\":1564652638,\"monthlyBackupsToKeep\":1626035296,\"volumesAssigned\":1844906639,\"enabled\":false,\"volumeBackups\":[{\"volumeName\":\"qp\",\"volumeResourceId\":\"ostronz\",\"backupsCount\":856785773,\"policyEnabled\":false},{\"volumeName\":\"pnsxkmcwaek\",\"volumeResourceId\":\"jreafxtsgum\",\"backupsCount\":1019109775,\"policyEnabled\":false}]},\"location\":\"kxw\",\"tags\":{\"tgp\":\"lbqpvuzlmvfelf\"},\"id\":\"crpw\",\"name\":\"xeznoi\",\"type\":\"brnjwmw\"}")
            .toObject(BackupPolicyInner.class);
        Assertions.assertEquals("kxw", model.location());
        Assertions.assertEquals("lbqpvuzlmvfelf", model.tags().get("tgp"));
        Assertions.assertEquals(1220802910, model.dailyBackupsToKeep());
        Assertions.assertEquals(1564652638, model.weeklyBackupsToKeep());
        Assertions.assertEquals(1626035296, model.monthlyBackupsToKeep());
        Assertions.assertFalse(model.enabled());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        BackupPolicyInner model = new BackupPolicyInner().withLocation("kxw")
            .withTags(mapOf("tgp", "lbqpvuzlmvfelf"))
            .withDailyBackupsToKeep(1220802910)
            .withWeeklyBackupsToKeep(1564652638)
            .withMonthlyBackupsToKeep(1626035296)
            .withEnabled(false);
        model = BinaryData.fromObject(model).toObject(BackupPolicyInner.class);
        Assertions.assertEquals("kxw", model.location());
        Assertions.assertEquals("lbqpvuzlmvfelf", model.tags().get("tgp"));
        Assertions.assertEquals(1220802910, model.dailyBackupsToKeep());
        Assertions.assertEquals(1564652638, model.weeklyBackupsToKeep());
        Assertions.assertEquals(1626035296, model.monthlyBackupsToKeep());
        Assertions.assertFalse(model.enabled());
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
