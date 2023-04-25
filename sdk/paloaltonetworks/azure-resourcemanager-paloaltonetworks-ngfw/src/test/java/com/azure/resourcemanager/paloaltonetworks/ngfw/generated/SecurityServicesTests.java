// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.paloaltonetworks.ngfw.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.SecurityServices;
import org.junit.jupiter.api.Assertions;

public final class SecurityServicesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SecurityServices model =
            BinaryData
                .fromString(
                    "{\"vulnerabilityProfile\":\"xbnjbiksq\",\"antiSpywareProfile\":\"lssai\",\"antiVirusProfile\":\"p\",\"urlFilteringProfile\":\"nzl\",\"fileBlockingProfile\":\"fmppe\",\"dnsSubscription\":\"vmgxsab\",\"outboundUnTrustCertificate\":\"qduujitcjczdz\",\"outboundTrustCertificate\":\"ndhkrw\"}")
                .toObject(SecurityServices.class);
        Assertions.assertEquals("xbnjbiksq", model.vulnerabilityProfile());
        Assertions.assertEquals("lssai", model.antiSpywareProfile());
        Assertions.assertEquals("p", model.antiVirusProfile());
        Assertions.assertEquals("nzl", model.urlFilteringProfile());
        Assertions.assertEquals("fmppe", model.fileBlockingProfile());
        Assertions.assertEquals("vmgxsab", model.dnsSubscription());
        Assertions.assertEquals("qduujitcjczdz", model.outboundUnTrustCertificate());
        Assertions.assertEquals("ndhkrw", model.outboundTrustCertificate());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SecurityServices model =
            new SecurityServices()
                .withVulnerabilityProfile("xbnjbiksq")
                .withAntiSpywareProfile("lssai")
                .withAntiVirusProfile("p")
                .withUrlFilteringProfile("nzl")
                .withFileBlockingProfile("fmppe")
                .withDnsSubscription("vmgxsab")
                .withOutboundUnTrustCertificate("qduujitcjczdz")
                .withOutboundTrustCertificate("ndhkrw");
        model = BinaryData.fromObject(model).toObject(SecurityServices.class);
        Assertions.assertEquals("xbnjbiksq", model.vulnerabilityProfile());
        Assertions.assertEquals("lssai", model.antiSpywareProfile());
        Assertions.assertEquals("p", model.antiVirusProfile());
        Assertions.assertEquals("nzl", model.urlFilteringProfile());
        Assertions.assertEquals("fmppe", model.fileBlockingProfile());
        Assertions.assertEquals("vmgxsab", model.dnsSubscription());
        Assertions.assertEquals("qduujitcjczdz", model.outboundUnTrustCertificate());
        Assertions.assertEquals("ndhkrw", model.outboundTrustCertificate());
    }
}