// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.databricks.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.databricks.models.WorkspaceCustomObjectParameter;

public final class WorkspaceCustomObjectParameterTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        WorkspaceCustomObjectParameter model = BinaryData.fromString("{\"type\":\"Object\",\"value\":\"datan\"}")
            .toObject(WorkspaceCustomObjectParameter.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        WorkspaceCustomObjectParameter model = new WorkspaceCustomObjectParameter().withValue("datan");
        model = BinaryData.fromObject(model).toObject(WorkspaceCustomObjectParameter.class);
    }
}
