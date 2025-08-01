// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.servicefabricmanagedclusters.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.VaultCertificate;
import org.junit.jupiter.api.Assertions;

public final class VaultCertificateTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        VaultCertificate model = BinaryData
            .fromString("{\"certificateUrl\":\"hfkvtvsexsowuel\",\"certificateStore\":\"qhhahhxvrhmzkwpj\"}")
            .toObject(VaultCertificate.class);
        Assertions.assertEquals("hfkvtvsexsowuel", model.certificateUrl());
        Assertions.assertEquals("qhhahhxvrhmzkwpj", model.certificateStore());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        VaultCertificate model
            = new VaultCertificate().withCertificateUrl("hfkvtvsexsowuel").withCertificateStore("qhhahhxvrhmzkwpj");
        model = BinaryData.fromObject(model).toObject(VaultCertificate.class);
        Assertions.assertEquals("hfkvtvsexsowuel", model.certificateUrl());
        Assertions.assertEquals("qhhahhxvrhmzkwpj", model.certificateStore());
    }
}
