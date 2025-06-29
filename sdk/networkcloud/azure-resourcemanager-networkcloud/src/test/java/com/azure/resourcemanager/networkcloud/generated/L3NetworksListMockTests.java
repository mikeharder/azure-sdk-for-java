// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.networkcloud.NetworkCloudManager;
import com.azure.resourcemanager.networkcloud.models.HybridAksIpamEnabled;
import com.azure.resourcemanager.networkcloud.models.HybridAksPluginType;
import com.azure.resourcemanager.networkcloud.models.IpAllocationType;
import com.azure.resourcemanager.networkcloud.models.L3Network;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class L3NetworksListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"etag\":\"yegq\",\"extendedLocation\":{\"name\":\"vn\",\"type\":\"gflqqbtnyjp\"},\"properties\":{\"associatedResourceIds\":[\"dbfvabmv\"],\"clusterId\":\"xbaevwjcnkot\",\"detailedStatus\":\"Available\",\"detailedStatusMessage\":\"hvajmailfemjjzak\",\"hybridAksClustersAssociatedIds\":[\"iqullqxbdmvr\",\"cm\"],\"hybridAksIpamEnabled\":\"True\",\"hybridAksPluginType\":\"SRIOV\",\"interfaceName\":\"rnyeofltfnnxrk\",\"ipAllocationType\":\"DualStack\",\"ipv4ConnectedPrefix\":\"ynnfmuiii\",\"ipv6ConnectedPrefix\":\"pfoh\",\"l3IsolationDomainId\":\"kfkxbbcbrwjiut\",\"provisioningState\":\"Failed\",\"virtualMachinesAssociatedIds\":[\"beewoi\",\"mrvz\",\"juyrsrziuctixg\",\"d\"],\"vlan\":3502296229444232217},\"location\":\"revkaapezkis\",\"tags\":{\"ufptb\":\"mdghsyparyb\"},\"id\":\"czjnc\",\"name\":\"uiyqvldaswvppi\",\"type\":\"qqzlgcndhz\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        NetworkCloudManager manager = NetworkCloudManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<L3Network> response = manager.l3Networks().list(com.azure.core.util.Context.NONE);

        Assertions.assertEquals("revkaapezkis", response.iterator().next().location());
        Assertions.assertEquals("mdghsyparyb", response.iterator().next().tags().get("ufptb"));
        Assertions.assertEquals("vn", response.iterator().next().extendedLocation().name());
        Assertions.assertEquals("gflqqbtnyjp", response.iterator().next().extendedLocation().type());
        Assertions.assertEquals(HybridAksIpamEnabled.TRUE, response.iterator().next().hybridAksIpamEnabled());
        Assertions.assertEquals(HybridAksPluginType.SRIOV, response.iterator().next().hybridAksPluginType());
        Assertions.assertEquals("rnyeofltfnnxrk", response.iterator().next().interfaceName());
        Assertions.assertEquals(IpAllocationType.DUAL_STACK, response.iterator().next().ipAllocationType());
        Assertions.assertEquals("ynnfmuiii", response.iterator().next().ipv4ConnectedPrefix());
        Assertions.assertEquals("pfoh", response.iterator().next().ipv6ConnectedPrefix());
        Assertions.assertEquals("kfkxbbcbrwjiut", response.iterator().next().l3IsolationDomainId());
        Assertions.assertEquals(3502296229444232217L, response.iterator().next().vlan());
    }
}
