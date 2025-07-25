// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.hardwaresecuritymodules.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.hardwaresecuritymodules.models.PrivateEndpoint;

public final class PrivateEndpointTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PrivateEndpoint model = BinaryData.fromString("{\"id\":\"bhj\"}").toObject(PrivateEndpoint.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PrivateEndpoint model = new PrivateEndpoint();
        model = BinaryData.fromObject(model).toObject(PrivateEndpoint.class);
    }
}
