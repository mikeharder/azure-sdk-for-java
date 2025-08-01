// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.cognitiveservices.models.ConnectionSharedAccessSignature;
import org.junit.jupiter.api.Assertions;

public final class ConnectionSharedAccessSignatureTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ConnectionSharedAccessSignature model
            = BinaryData.fromString("{\"sas\":\"idibgqjxgpn\"}").toObject(ConnectionSharedAccessSignature.class);
        Assertions.assertEquals("idibgqjxgpn", model.sas());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ConnectionSharedAccessSignature model = new ConnectionSharedAccessSignature().withSas("idibgqjxgpn");
        model = BinaryData.fromObject(model).toObject(ConnectionSharedAccessSignature.class);
        Assertions.assertEquals("idibgqjxgpn", model.sas());
    }
}
