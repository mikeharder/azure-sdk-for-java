// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.streamanalytics.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.streamanalytics.models.PrivateEndpointProperties;
import com.azure.resourcemanager.streamanalytics.models.PrivateLinkConnectionState;
import com.azure.resourcemanager.streamanalytics.models.PrivateLinkServiceConnection;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class PrivateEndpointPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PrivateEndpointProperties model = BinaryData.fromString(
            "{\"createdDate\":\"nbbelda\",\"manualPrivateLinkServiceConnections\":[{\"properties\":{\"privateLinkServiceId\":\"liourqhak\",\"groupIds\":[\"ashsfwxos\",\"w\",\"xcug\"],\"requestMessage\":\"jooxdjebw\",\"privateLinkServiceConnectionState\":{\"status\":\"wwfvov\",\"description\":\"meue\",\"actionsRequired\":\"vyhzceuojgjrwj\"}}},{\"properties\":{\"privateLinkServiceId\":\"otwmcdyt\",\"groupIds\":[\"it\"],\"requestMessage\":\"rjaw\",\"privateLinkServiceConnectionState\":{\"status\":\"gxhnisk\",\"description\":\"bkpyc\",\"actionsRequired\":\"lwn\"}}},{\"properties\":{\"privateLinkServiceId\":\"jdauwhvy\",\"groupIds\":[\"btdhxujznbm\"],\"requestMessage\":\"wuwprzqlv\",\"privateLinkServiceConnectionState\":{\"status\":\"lupj\",\"description\":\"hfxobbcswsrtj\",\"actionsRequired\":\"plrbpbewtghf\"}}}]}")
            .toObject(PrivateEndpointProperties.class);
        Assertions.assertEquals("liourqhak", model.manualPrivateLinkServiceConnections().get(0).privateLinkServiceId());
        Assertions.assertEquals("ashsfwxos", model.manualPrivateLinkServiceConnections().get(0).groupIds().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PrivateEndpointProperties model
            = new PrivateEndpointProperties().withManualPrivateLinkServiceConnections(Arrays.asList(
                new PrivateLinkServiceConnection().withPrivateLinkServiceId("liourqhak")
                    .withGroupIds(Arrays.asList("ashsfwxos", "w", "xcug"))
                    .withPrivateLinkServiceConnectionState(new PrivateLinkConnectionState()),
                new PrivateLinkServiceConnection().withPrivateLinkServiceId("otwmcdyt")
                    .withGroupIds(Arrays.asList("it"))
                    .withPrivateLinkServiceConnectionState(new PrivateLinkConnectionState()),
                new PrivateLinkServiceConnection().withPrivateLinkServiceId("jdauwhvy")
                    .withGroupIds(Arrays.asList("btdhxujznbm"))
                    .withPrivateLinkServiceConnectionState(new PrivateLinkConnectionState())));
        model = BinaryData.fromObject(model).toObject(PrivateEndpointProperties.class);
        Assertions.assertEquals("liourqhak", model.manualPrivateLinkServiceConnections().get(0).privateLinkServiceId());
        Assertions.assertEquals("ashsfwxos", model.manualPrivateLinkServiceConnections().get(0).groupIds().get(0));
    }
}
