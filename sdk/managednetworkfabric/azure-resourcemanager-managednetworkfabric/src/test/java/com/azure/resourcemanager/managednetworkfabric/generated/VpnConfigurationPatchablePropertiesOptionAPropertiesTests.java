// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.managednetworkfabric.models.BfdConfiguration;
import com.azure.resourcemanager.managednetworkfabric.models.VpnConfigurationPatchablePropertiesOptionAProperties;
import org.junit.jupiter.api.Assertions;

public final class VpnConfigurationPatchablePropertiesOptionAPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        VpnConfigurationPatchablePropertiesOptionAProperties model = BinaryData.fromString(
            "{\"primaryIpv4Prefix\":\"lrr\",\"primaryIpv6Prefix\":\"hctsbbibti\",\"secondaryIpv4Prefix\":\"hqvumspbfs\",\"secondaryIpv6Prefix\":\"qbbewfcuqfpyyxm\",\"mtu\":796336279,\"vlanId\":1630264703,\"peerASN\":2293730529266201821,\"bfdConfiguration\":{\"administrativeState\":\"Enabled\",\"intervalInMilliSeconds\":1541863840,\"multiplier\":1931320869}}")
            .toObject(VpnConfigurationPatchablePropertiesOptionAProperties.class);
        Assertions.assertEquals(796336279, model.mtu());
        Assertions.assertEquals(1630264703, model.vlanId());
        Assertions.assertEquals(2293730529266201821L, model.peerAsn());
        Assertions.assertEquals(1541863840, model.bfdConfiguration().intervalInMilliSeconds());
        Assertions.assertEquals(1931320869, model.bfdConfiguration().multiplier());
        Assertions.assertEquals("lrr", model.primaryIpv4Prefix());
        Assertions.assertEquals("hctsbbibti", model.primaryIpv6Prefix());
        Assertions.assertEquals("hqvumspbfs", model.secondaryIpv4Prefix());
        Assertions.assertEquals("qbbewfcuqfpyyxm", model.secondaryIpv6Prefix());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        VpnConfigurationPatchablePropertiesOptionAProperties model
            = new VpnConfigurationPatchablePropertiesOptionAProperties().withMtu(796336279)
                .withVlanId(1630264703)
                .withPeerAsn(2293730529266201821L)
                .withBfdConfiguration(
                    new BfdConfiguration().withIntervalInMilliSeconds(1541863840).withMultiplier(1931320869))
                .withPrimaryIpv4Prefix("lrr")
                .withPrimaryIpv6Prefix("hctsbbibti")
                .withSecondaryIpv4Prefix("hqvumspbfs")
                .withSecondaryIpv6Prefix("qbbewfcuqfpyyxm");
        model = BinaryData.fromObject(model).toObject(VpnConfigurationPatchablePropertiesOptionAProperties.class);
        Assertions.assertEquals(796336279, model.mtu());
        Assertions.assertEquals(1630264703, model.vlanId());
        Assertions.assertEquals(2293730529266201821L, model.peerAsn());
        Assertions.assertEquals(1541863840, model.bfdConfiguration().intervalInMilliSeconds());
        Assertions.assertEquals(1931320869, model.bfdConfiguration().multiplier());
        Assertions.assertEquals("lrr", model.primaryIpv4Prefix());
        Assertions.assertEquals("hctsbbibti", model.primaryIpv6Prefix());
        Assertions.assertEquals("hqvumspbfs", model.secondaryIpv4Prefix());
        Assertions.assertEquals("qbbewfcuqfpyyxm", model.secondaryIpv6Prefix());
    }
}
