// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.servicefabricmanagedclusters.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.Access;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.Direction;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.NetworkSecurityRule;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.NsgProtocol;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class NetworkSecurityRuleTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        NetworkSecurityRule model = BinaryData.fromString(
            "{\"name\":\"afnn\",\"description\":\"pichkoymkcdy\",\"protocol\":\"http\",\"sourceAddressPrefixes\":[\"kpw\",\"reqnovvqfov\",\"jxywsuws\",\"rsndsytgadgvra\"],\"destinationAddressPrefixes\":[\"neqn\"],\"sourcePortRanges\":[\"rwlqu\",\"ijfqkacewiipfp\",\"bjibwwiftohq\",\"vpuvks\"],\"destinationPortRanges\":[\"saknynfsyn\"],\"sourceAddressPrefix\":\"ph\",\"destinationAddressPrefix\":\"pxodlqiyntorzih\",\"sourcePortRange\":\"osjswsr\",\"destinationPortRange\":\"lyzrpzbchckqqzqi\",\"access\":\"allow\",\"priority\":1257157038,\"direction\":\"outbound\"}")
            .toObject(NetworkSecurityRule.class);
        Assertions.assertEquals("afnn", model.name());
        Assertions.assertEquals("pichkoymkcdy", model.description());
        Assertions.assertEquals(NsgProtocol.HTTP, model.protocol());
        Assertions.assertEquals("kpw", model.sourceAddressPrefixes().get(0));
        Assertions.assertEquals("neqn", model.destinationAddressPrefixes().get(0));
        Assertions.assertEquals("rwlqu", model.sourcePortRanges().get(0));
        Assertions.assertEquals("saknynfsyn", model.destinationPortRanges().get(0));
        Assertions.assertEquals("ph", model.sourceAddressPrefix());
        Assertions.assertEquals("pxodlqiyntorzih", model.destinationAddressPrefix());
        Assertions.assertEquals("osjswsr", model.sourcePortRange());
        Assertions.assertEquals("lyzrpzbchckqqzqi", model.destinationPortRange());
        Assertions.assertEquals(Access.ALLOW, model.access());
        Assertions.assertEquals(1257157038, model.priority());
        Assertions.assertEquals(Direction.OUTBOUND, model.direction());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        NetworkSecurityRule model = new NetworkSecurityRule().withName("afnn")
            .withDescription("pichkoymkcdy")
            .withProtocol(NsgProtocol.HTTP)
            .withSourceAddressPrefixes(Arrays.asList("kpw", "reqnovvqfov", "jxywsuws", "rsndsytgadgvra"))
            .withDestinationAddressPrefixes(Arrays.asList("neqn"))
            .withSourcePortRanges(Arrays.asList("rwlqu", "ijfqkacewiipfp", "bjibwwiftohq", "vpuvks"))
            .withDestinationPortRanges(Arrays.asList("saknynfsyn"))
            .withSourceAddressPrefix("ph")
            .withDestinationAddressPrefix("pxodlqiyntorzih")
            .withSourcePortRange("osjswsr")
            .withDestinationPortRange("lyzrpzbchckqqzqi")
            .withAccess(Access.ALLOW)
            .withPriority(1257157038)
            .withDirection(Direction.OUTBOUND);
        model = BinaryData.fromObject(model).toObject(NetworkSecurityRule.class);
        Assertions.assertEquals("afnn", model.name());
        Assertions.assertEquals("pichkoymkcdy", model.description());
        Assertions.assertEquals(NsgProtocol.HTTP, model.protocol());
        Assertions.assertEquals("kpw", model.sourceAddressPrefixes().get(0));
        Assertions.assertEquals("neqn", model.destinationAddressPrefixes().get(0));
        Assertions.assertEquals("rwlqu", model.sourcePortRanges().get(0));
        Assertions.assertEquals("saknynfsyn", model.destinationPortRanges().get(0));
        Assertions.assertEquals("ph", model.sourceAddressPrefix());
        Assertions.assertEquals("pxodlqiyntorzih", model.destinationAddressPrefix());
        Assertions.assertEquals("osjswsr", model.sourcePortRange());
        Assertions.assertEquals("lyzrpzbchckqqzqi", model.destinationPortRange());
        Assertions.assertEquals(Access.ALLOW, model.access());
        Assertions.assertEquals(1257157038, model.priority());
        Assertions.assertEquals(Direction.OUTBOUND, model.direction());
    }
}
