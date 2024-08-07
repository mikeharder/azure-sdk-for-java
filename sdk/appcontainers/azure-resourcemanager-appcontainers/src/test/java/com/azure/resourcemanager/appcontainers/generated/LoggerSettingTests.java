// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.appcontainers.models.Level;
import com.azure.resourcemanager.appcontainers.models.LoggerSetting;
import org.junit.jupiter.api.Assertions;

public final class LoggerSettingTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        LoggerSetting model
            = BinaryData.fromString("{\"logger\":\"k\",\"level\":\"error\"}").toObject(LoggerSetting.class);
        Assertions.assertEquals("k", model.logger());
        Assertions.assertEquals(Level.ERROR, model.level());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        LoggerSetting model = new LoggerSetting().withLogger("k").withLevel(Level.ERROR);
        model = BinaryData.fromObject(model).toObject(LoggerSetting.class);
        Assertions.assertEquals("k", model.logger());
        Assertions.assertEquals(Level.ERROR, model.level());
    }
}
