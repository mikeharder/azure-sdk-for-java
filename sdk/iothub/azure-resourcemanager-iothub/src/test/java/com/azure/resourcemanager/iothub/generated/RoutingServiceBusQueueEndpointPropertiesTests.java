// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.iothub.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.iothub.models.AuthenticationType;
import com.azure.resourcemanager.iothub.models.ManagedIdentity;
import com.azure.resourcemanager.iothub.models.RoutingServiceBusQueueEndpointProperties;
import org.junit.jupiter.api.Assertions;

public final class RoutingServiceBusQueueEndpointPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        RoutingServiceBusQueueEndpointProperties model =
            BinaryData
                .fromString(
                    "{\"id\":\"aodsfcpkv\",\"connectionString\":\"dpuozmyz\",\"endpointUri\":\"agfuaxbezyiu\",\"entityPath\":\"ktwh\",\"authenticationType\":\"keyBased\",\"identity\":{\"userAssignedIdentity\":\"ywqsmbsurexim\"},\"name\":\"ryocfsfksymdd\",\"subscriptionId\":\"tki\",\"resourceGroup\":\"xhqyudxorrqnb\"}")
                .toObject(RoutingServiceBusQueueEndpointProperties.class);
        Assertions.assertEquals("aodsfcpkv", model.id());
        Assertions.assertEquals("dpuozmyz", model.connectionString());
        Assertions.assertEquals("agfuaxbezyiu", model.endpointUri());
        Assertions.assertEquals("ktwh", model.entityPath());
        Assertions.assertEquals(AuthenticationType.KEY_BASED, model.authenticationType());
        Assertions.assertEquals("ywqsmbsurexim", model.identity().userAssignedIdentity());
        Assertions.assertEquals("ryocfsfksymdd", model.name());
        Assertions.assertEquals("tki", model.subscriptionId());
        Assertions.assertEquals("xhqyudxorrqnb", model.resourceGroup());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        RoutingServiceBusQueueEndpointProperties model =
            new RoutingServiceBusQueueEndpointProperties()
                .withId("aodsfcpkv")
                .withConnectionString("dpuozmyz")
                .withEndpointUri("agfuaxbezyiu")
                .withEntityPath("ktwh")
                .withAuthenticationType(AuthenticationType.KEY_BASED)
                .withIdentity(new ManagedIdentity().withUserAssignedIdentity("ywqsmbsurexim"))
                .withName("ryocfsfksymdd")
                .withSubscriptionId("tki")
                .withResourceGroup("xhqyudxorrqnb");
        model = BinaryData.fromObject(model).toObject(RoutingServiceBusQueueEndpointProperties.class);
        Assertions.assertEquals("aodsfcpkv", model.id());
        Assertions.assertEquals("dpuozmyz", model.connectionString());
        Assertions.assertEquals("agfuaxbezyiu", model.endpointUri());
        Assertions.assertEquals("ktwh", model.entityPath());
        Assertions.assertEquals(AuthenticationType.KEY_BASED, model.authenticationType());
        Assertions.assertEquals("ywqsmbsurexim", model.identity().userAssignedIdentity());
        Assertions.assertEquals("ryocfsfksymdd", model.name());
        Assertions.assertEquals("tki", model.subscriptionId());
        Assertions.assertEquals("xhqyudxorrqnb", model.resourceGroup());
    }
}