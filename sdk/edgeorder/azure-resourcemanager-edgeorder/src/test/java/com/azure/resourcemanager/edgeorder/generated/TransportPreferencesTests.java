// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.edgeorder.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.edgeorder.models.TransportPreferences;
import com.azure.resourcemanager.edgeorder.models.TransportShipmentTypes;
import org.junit.jupiter.api.Assertions;

public final class TransportPreferencesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        TransportPreferences model = BinaryData.fromString("{\"preferredShipmentType\":\"CustomerManaged\"}")
            .toObject(TransportPreferences.class);
        Assertions.assertEquals(TransportShipmentTypes.CUSTOMER_MANAGED, model.preferredShipmentType());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        TransportPreferences model
            = new TransportPreferences().withPreferredShipmentType(TransportShipmentTypes.CUSTOMER_MANAGED);
        model = BinaryData.fromObject(model).toObject(TransportPreferences.class);
        Assertions.assertEquals(TransportShipmentTypes.CUSTOMER_MANAGED, model.preferredShipmentType());
    }
}
