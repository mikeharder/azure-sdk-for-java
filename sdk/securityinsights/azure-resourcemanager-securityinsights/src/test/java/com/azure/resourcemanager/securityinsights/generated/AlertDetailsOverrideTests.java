// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.securityinsights.models.AlertDetailsOverride;
import org.junit.jupiter.api.Assertions;

public final class AlertDetailsOverrideTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AlertDetailsOverride model = BinaryData.fromString(
            "{\"alertDisplayNameFormat\":\"xwh\",\"alertDescriptionFormat\":\"nsymoyqhlwigd\",\"alertTacticsColumnName\":\"bkbxgomfa\",\"alertSeverityColumnName\":\"wasqvdaeyyg\"}")
            .toObject(AlertDetailsOverride.class);
        Assertions.assertEquals("xwh", model.alertDisplayNameFormat());
        Assertions.assertEquals("nsymoyqhlwigd", model.alertDescriptionFormat());
        Assertions.assertEquals("bkbxgomfa", model.alertTacticsColumnName());
        Assertions.assertEquals("wasqvdaeyyg", model.alertSeverityColumnName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AlertDetailsOverride model = new AlertDetailsOverride().withAlertDisplayNameFormat("xwh")
            .withAlertDescriptionFormat("nsymoyqhlwigd")
            .withAlertTacticsColumnName("bkbxgomfa")
            .withAlertSeverityColumnName("wasqvdaeyyg");
        model = BinaryData.fromObject(model).toObject(AlertDetailsOverride.class);
        Assertions.assertEquals("xwh", model.alertDisplayNameFormat());
        Assertions.assertEquals("nsymoyqhlwigd", model.alertDescriptionFormat());
        Assertions.assertEquals("bkbxgomfa", model.alertTacticsColumnName());
        Assertions.assertEquals("wasqvdaeyyg", model.alertSeverityColumnName());
    }
}
