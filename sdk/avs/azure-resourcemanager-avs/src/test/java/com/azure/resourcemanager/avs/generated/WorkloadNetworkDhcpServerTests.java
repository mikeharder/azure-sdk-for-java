// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.avs.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.avs.models.WorkloadNetworkDhcpServer;
import org.junit.jupiter.api.Assertions;

public final class WorkloadNetworkDhcpServerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        WorkloadNetworkDhcpServer model = BinaryData.fromString(
            "{\"dhcpType\":\"SERVER\",\"serverAddress\":\"pikxwczbyscnpqxu\",\"leaseTime\":3437469293095173263,\"displayName\":\"n\",\"segments\":[\"ybrk\"],\"provisioningState\":\"Failed\",\"revision\":3576842101387296320}")
            .toObject(WorkloadNetworkDhcpServer.class);
        Assertions.assertEquals("n", model.displayName());
        Assertions.assertEquals(3576842101387296320L, model.revision());
        Assertions.assertEquals("pikxwczbyscnpqxu", model.serverAddress());
        Assertions.assertEquals(3437469293095173263L, model.leaseTime());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        WorkloadNetworkDhcpServer model = new WorkloadNetworkDhcpServer().withDisplayName("n")
            .withRevision(3576842101387296320L)
            .withServerAddress("pikxwczbyscnpqxu")
            .withLeaseTime(3437469293095173263L);
        model = BinaryData.fromObject(model).toObject(WorkloadNetworkDhcpServer.class);
        Assertions.assertEquals("n", model.displayName());
        Assertions.assertEquals(3576842101387296320L, model.revision());
        Assertions.assertEquals("pikxwczbyscnpqxu", model.serverAddress());
        Assertions.assertEquals(3437469293095173263L, model.leaseTime());
    }
}
