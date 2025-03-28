// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.kusto.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.kusto.models.DatabaseStatistics;
import org.junit.jupiter.api.Assertions;

public final class DatabaseStatisticsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DatabaseStatistics model = BinaryData.fromString("{\"size\":81.256256}").toObject(DatabaseStatistics.class);
        Assertions.assertEquals(81.256256F, model.size());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DatabaseStatistics model = new DatabaseStatistics().withSize(81.256256F);
        model = BinaryData.fromObject(model).toObject(DatabaseStatistics.class);
        Assertions.assertEquals(81.256256F, model.size());
    }
}
