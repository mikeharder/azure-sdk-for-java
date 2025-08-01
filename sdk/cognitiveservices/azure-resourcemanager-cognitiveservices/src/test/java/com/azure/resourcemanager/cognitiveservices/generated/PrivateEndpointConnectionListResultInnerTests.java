// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.cognitiveservices.fluent.models.PrivateEndpointConnectionInner;
import com.azure.resourcemanager.cognitiveservices.fluent.models.PrivateEndpointConnectionListResultInner;
import com.azure.resourcemanager.cognitiveservices.models.PrivateEndpoint;
import com.azure.resourcemanager.cognitiveservices.models.PrivateEndpointConnectionProperties;
import com.azure.resourcemanager.cognitiveservices.models.PrivateEndpointServiceConnectionStatus;
import com.azure.resourcemanager.cognitiveservices.models.PrivateLinkServiceConnectionState;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class PrivateEndpointConnectionListResultInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PrivateEndpointConnectionListResultInner model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"privateEndpoint\":{\"id\":\"hqcrailvpnpp\"},\"privateLinkServiceConnectionState\":{\"status\":\"Approved\",\"description\":\"rwdmhdlxyjrxsa\",\"actionsRequired\":\"fcnihgwq\"},\"provisioningState\":\"Creating\",\"groupIds\":[\"gfbcvkcv\",\"vpk\",\"qdcvdrhvoo\",\"sotbob\"]},\"location\":\"pcjwv\",\"etag\":\"dldwmgxc\",\"id\":\"rslpmutwuoeg\",\"name\":\"pkhjwni\",\"type\":\"qsluicp\"},{\"properties\":{\"privateEndpoint\":{\"id\":\"zzlvmbmpaxmodfv\"},\"privateLinkServiceConnectionState\":{\"status\":\"Pending\",\"description\":\"wsbpfvm\",\"actionsRequired\":\"hrfou\"},\"provisioningState\":\"Creating\",\"groupIds\":[\"kcpwiy\"]},\"location\":\"tmnubexkpzksmon\",\"etag\":\"mquxvypo\",\"id\":\"gkopkwhojvpajqgx\",\"name\":\"smocmbq\",\"type\":\"qvmkcxo\"},{\"properties\":{\"privateEndpoint\":{\"id\":\"helxprglya\"},\"privateLinkServiceConnectionState\":{\"status\":\"Approved\",\"description\":\"kcbcue\",\"actionsRequired\":\"jxgciqibrh\"},\"provisioningState\":\"Failed\",\"groupIds\":[\"qrhzoymibmrqyib\",\"hwflu\",\"zdtmhrkwofy\"]},\"location\":\"qacpiex\",\"etag\":\"tg\",\"id\":\"wbwo\",\"name\":\"nwashrtd\",\"type\":\"kcnqxwbpo\"},{\"properties\":{\"privateEndpoint\":{\"id\":\"iujwa\"},\"privateLinkServiceConnectionState\":{\"status\":\"Pending\",\"description\":\"qiiobyuqer\",\"actionsRequired\":\"lp\"},\"provisioningState\":\"Failed\",\"groupIds\":[\"uqgbdbutauvfbt\",\"uwhhmhykojoxafn\",\"dlpichkoymkcdyhb\"]},\"location\":\"pwdreqnovvqf\",\"etag\":\"ljxywsu\",\"id\":\"syrsndsytgadgvra\",\"name\":\"aeneqnzarrwl\",\"type\":\"uu\"}]}")
            .toObject(PrivateEndpointConnectionListResultInner.class);
        Assertions.assertEquals(PrivateEndpointServiceConnectionStatus.APPROVED,
            model.value().get(0).properties().privateLinkServiceConnectionState().status());
        Assertions.assertEquals("rwdmhdlxyjrxsa",
            model.value().get(0).properties().privateLinkServiceConnectionState().description());
        Assertions.assertEquals("fcnihgwq",
            model.value().get(0).properties().privateLinkServiceConnectionState().actionsRequired());
        Assertions.assertEquals("gfbcvkcv", model.value().get(0).properties().groupIds().get(0));
        Assertions.assertEquals("pcjwv", model.value().get(0).location());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PrivateEndpointConnectionListResultInner model
            = new PrivateEndpointConnectionListResultInner()
                .withValue(Arrays.asList(
                    new PrivateEndpointConnectionInner()
                        .withProperties(
                            new PrivateEndpointConnectionProperties()
                                .withPrivateEndpoint(new PrivateEndpoint())
                                .withPrivateLinkServiceConnectionState(
                                    new PrivateLinkServiceConnectionState()
                                        .withStatus(PrivateEndpointServiceConnectionStatus.APPROVED)
                                        .withDescription("rwdmhdlxyjrxsa")
                                        .withActionsRequired("fcnihgwq"))
                                .withGroupIds(Arrays.asList("gfbcvkcv", "vpk", "qdcvdrhvoo", "sotbob")))
                        .withLocation("pcjwv"),
                    new PrivateEndpointConnectionInner().withProperties(
                        new PrivateEndpointConnectionProperties().withPrivateEndpoint(new PrivateEndpoint())
                            .withPrivateLinkServiceConnectionState(new PrivateLinkServiceConnectionState()
                                .withStatus(PrivateEndpointServiceConnectionStatus.PENDING)
                                .withDescription("wsbpfvm")
                                .withActionsRequired("hrfou"))
                            .withGroupIds(Arrays.asList("kcpwiy")))
                        .withLocation("tmnubexkpzksmon"),
                    new PrivateEndpointConnectionInner()
                        .withProperties(
                            new PrivateEndpointConnectionProperties().withPrivateEndpoint(new PrivateEndpoint())
                                .withPrivateLinkServiceConnectionState(new PrivateLinkServiceConnectionState()
                                    .withStatus(PrivateEndpointServiceConnectionStatus.APPROVED)
                                    .withDescription("kcbcue")
                                    .withActionsRequired("jxgciqibrh"))
                                .withGroupIds(Arrays.asList("qrhzoymibmrqyib", "hwflu", "zdtmhrkwofy")))
                        .withLocation("qacpiex"),
                    new PrivateEndpointConnectionInner()
                        .withProperties(
                            new PrivateEndpointConnectionProperties().withPrivateEndpoint(new PrivateEndpoint())
                                .withPrivateLinkServiceConnectionState(new PrivateLinkServiceConnectionState()
                                    .withStatus(PrivateEndpointServiceConnectionStatus.PENDING)
                                    .withDescription("qiiobyuqer")
                                    .withActionsRequired("lp"))
                                .withGroupIds(Arrays.asList("uqgbdbutauvfbt", "uwhhmhykojoxafn", "dlpichkoymkcdyhb")))
                        .withLocation("pwdreqnovvqf")));
        model = BinaryData.fromObject(model).toObject(PrivateEndpointConnectionListResultInner.class);
        Assertions.assertEquals(PrivateEndpointServiceConnectionStatus.APPROVED,
            model.value().get(0).properties().privateLinkServiceConnectionState().status());
        Assertions.assertEquals("rwdmhdlxyjrxsa",
            model.value().get(0).properties().privateLinkServiceConnectionState().description());
        Assertions.assertEquals("fcnihgwq",
            model.value().get(0).properties().privateLinkServiceConnectionState().actionsRequired());
        Assertions.assertEquals("gfbcvkcv", model.value().get(0).properties().groupIds().get(0));
        Assertions.assertEquals("pcjwv", model.value().get(0).location());
    }
}
