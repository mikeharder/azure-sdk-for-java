// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.webpubsub.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.webpubsub.fluent.models.PrivateEndpointConnectionInner;
import com.azure.resourcemanager.webpubsub.models.PrivateEndpoint;
import com.azure.resourcemanager.webpubsub.models.PrivateEndpointConnectionList;
import com.azure.resourcemanager.webpubsub.models.PrivateLinkServiceConnectionState;
import com.azure.resourcemanager.webpubsub.models.PrivateLinkServiceConnectionStatus;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class PrivateEndpointConnectionListTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PrivateEndpointConnectionList model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"provisioningState\":\"Creating\",\"privateEndpoint\":{\"id\":\"einqf\"},\"groupIds\":[\"x\",\"knpirgnepttwq\",\"sniffc\",\"mqnrojlpijnkr\"],\"privateLinkServiceConnectionState\":{\"status\":\"Rejected\",\"description\":\"hcrat\",\"actionsRequired\":\"zronasxift\"}},\"id\":\"qyzhf\",\"name\":\"wesgogczh\",\"type\":\"nnxk\"},{\"properties\":{\"provisioningState\":\"Canceled\",\"privateEndpoint\":{\"id\":\"mossxkkgthrrghxj\"},\"groupIds\":[\"qxvcxgfrpdsofb\",\"hrnsvbu\",\"wdvzyy\",\"ycnunvjsrtk\"],\"privateLinkServiceConnectionState\":{\"status\":\"Disconnected\",\"description\":\"pqgik\",\"actionsRequired\":\"irtx\"}},\"id\":\"uxzejntpsew\",\"name\":\"ioilqukrydxtq\",\"type\":\"ieoxorggufhyaomt\"},{\"properties\":{\"provisioningState\":\"Moving\",\"privateEndpoint\":{\"id\":\"grvk\"},\"groupIds\":[\"vjzhpjbib\",\"jmfxumvf\",\"luyovwxnbkfezzx\",\"cy\"],\"privateLinkServiceConnectionState\":{\"status\":\"Rejected\",\"description\":\"irujbz\",\"actionsRequired\":\"mvzzbtdcqvp\"}},\"id\":\"yujviylwdshfssn\",\"name\":\"bgye\",\"type\":\"rymsgaojfmw\"},{\"properties\":{\"provisioningState\":\"Updating\",\"privateEndpoint\":{\"id\":\"fhir\"},\"groupIds\":[\"moxoftpi\",\"iwyczuh\",\"a\",\"pqjlihhyusps\"],\"privateLinkServiceConnectionState\":{\"status\":\"Rejected\",\"description\":\"lmfwdgzx\",\"actionsRequired\":\"ucvpamrs\"}},\"id\":\"uzvx\",\"name\":\"risjnhnytxifqjz\",\"type\":\"xmrhu\"}],\"nextLink\":\"wp\"}")
            .toObject(PrivateEndpointConnectionList.class);
        Assertions.assertEquals("einqf", model.value().get(0).privateEndpoint().id());
        Assertions.assertEquals(PrivateLinkServiceConnectionStatus.REJECTED,
            model.value().get(0).privateLinkServiceConnectionState().status());
        Assertions.assertEquals("hcrat", model.value().get(0).privateLinkServiceConnectionState().description());
        Assertions.assertEquals("zronasxift",
            model.value().get(0).privateLinkServiceConnectionState().actionsRequired());
        Assertions.assertEquals("wp", model.nextLink());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PrivateEndpointConnectionList model
            = new PrivateEndpointConnectionList()
                .withValue(
                    Arrays.asList(
                        new PrivateEndpointConnectionInner().withPrivateEndpoint(new PrivateEndpoint().withId("einqf"))
                            .withPrivateLinkServiceConnectionState(new PrivateLinkServiceConnectionState()
                                .withStatus(PrivateLinkServiceConnectionStatus.REJECTED)
                                .withDescription("hcrat")
                                .withActionsRequired("zronasxift")),
                        new PrivateEndpointConnectionInner()
                            .withPrivateEndpoint(new PrivateEndpoint().withId("mossxkkgthrrghxj"))
                            .withPrivateLinkServiceConnectionState(new PrivateLinkServiceConnectionState()
                                .withStatus(PrivateLinkServiceConnectionStatus.DISCONNECTED)
                                .withDescription("pqgik")
                                .withActionsRequired("irtx")),
                        new PrivateEndpointConnectionInner().withPrivateEndpoint(new PrivateEndpoint().withId("grvk"))
                            .withPrivateLinkServiceConnectionState(new PrivateLinkServiceConnectionState()
                                .withStatus(PrivateLinkServiceConnectionStatus.REJECTED)
                                .withDescription("irujbz")
                                .withActionsRequired("mvzzbtdcqvp")),
                        new PrivateEndpointConnectionInner().withPrivateEndpoint(new PrivateEndpoint().withId("fhir"))
                            .withPrivateLinkServiceConnectionState(new PrivateLinkServiceConnectionState()
                                .withStatus(PrivateLinkServiceConnectionStatus.REJECTED)
                                .withDescription("lmfwdgzx")
                                .withActionsRequired("ucvpamrs"))))
                .withNextLink("wp");
        model = BinaryData.fromObject(model).toObject(PrivateEndpointConnectionList.class);
        Assertions.assertEquals("einqf", model.value().get(0).privateEndpoint().id());
        Assertions.assertEquals(PrivateLinkServiceConnectionStatus.REJECTED,
            model.value().get(0).privateLinkServiceConnectionState().status());
        Assertions.assertEquals("hcrat", model.value().get(0).privateLinkServiceConnectionState().description());
        Assertions.assertEquals("zronasxift",
            model.value().get(0).privateLinkServiceConnectionState().actionsRequired());
        Assertions.assertEquals("wp", model.nextLink());
    }
}
