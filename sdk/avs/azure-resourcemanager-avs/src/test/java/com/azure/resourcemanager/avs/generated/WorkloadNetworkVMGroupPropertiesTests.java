// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.avs.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.avs.fluent.models.WorkloadNetworkVMGroupProperties;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class WorkloadNetworkVMGroupPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        WorkloadNetworkVMGroupProperties model = BinaryData.fromString(
            "{\"displayName\":\"fnljky\",\"members\":[\"vuujq\"],\"status\":\"SUCCESS\",\"provisioningState\":\"Succeeded\",\"revision\":8952255815532571231}")
            .toObject(WorkloadNetworkVMGroupProperties.class);
        Assertions.assertEquals("fnljky", model.displayName());
        Assertions.assertEquals("vuujq", model.members().get(0));
        Assertions.assertEquals(8952255815532571231L, model.revision());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        WorkloadNetworkVMGroupProperties model = new WorkloadNetworkVMGroupProperties().withDisplayName("fnljky")
            .withMembers(Arrays.asList("vuujq"))
            .withRevision(8952255815532571231L);
        model = BinaryData.fromObject(model).toObject(WorkloadNetworkVMGroupProperties.class);
        Assertions.assertEquals("fnljky", model.displayName());
        Assertions.assertEquals("vuujq", model.members().get(0));
        Assertions.assertEquals(8952255815532571231L, model.revision());
    }
}
