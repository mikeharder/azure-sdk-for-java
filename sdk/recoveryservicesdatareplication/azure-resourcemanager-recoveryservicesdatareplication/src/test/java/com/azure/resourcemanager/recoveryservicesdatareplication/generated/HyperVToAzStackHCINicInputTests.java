// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.recoveryservicesdatareplication.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicesdatareplication.models.HyperVToAzStackHCINicInput;
import com.azure.resourcemanager.recoveryservicesdatareplication.models.VMNicSelection;
import org.junit.jupiter.api.Assertions;

public final class HyperVToAzStackHCINicInputTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        HyperVToAzStackHCINicInput model = BinaryData.fromString(
            "{\"nicId\":\"wgdsl\",\"networkName\":\"ihhrmo\",\"targetNetworkId\":\"z\",\"testNetworkId\":\"eypxiutcxapzhyr\",\"selectionTypeForFailover\":\"SelectedByUser\",\"isStaticIpMigrationEnabled\":false,\"isMacMigrationEnabled\":false}")
            .toObject(HyperVToAzStackHCINicInput.class);
        Assertions.assertEquals("wgdsl", model.nicId());
        Assertions.assertEquals("z", model.targetNetworkId());
        Assertions.assertEquals("eypxiutcxapzhyr", model.testNetworkId());
        Assertions.assertEquals(VMNicSelection.SELECTED_BY_USER, model.selectionTypeForFailover());
        Assertions.assertFalse(model.isStaticIpMigrationEnabled());
        Assertions.assertFalse(model.isMacMigrationEnabled());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        HyperVToAzStackHCINicInput model = new HyperVToAzStackHCINicInput().withNicId("wgdsl")
            .withTargetNetworkId("z")
            .withTestNetworkId("eypxiutcxapzhyr")
            .withSelectionTypeForFailover(VMNicSelection.SELECTED_BY_USER)
            .withIsStaticIpMigrationEnabled(false)
            .withIsMacMigrationEnabled(false);
        model = BinaryData.fromObject(model).toObject(HyperVToAzStackHCINicInput.class);
        Assertions.assertEquals("wgdsl", model.nicId());
        Assertions.assertEquals("z", model.targetNetworkId());
        Assertions.assertEquals("eypxiutcxapzhyr", model.testNetworkId());
        Assertions.assertEquals(VMNicSelection.SELECTED_BY_USER, model.selectionTypeForFailover());
        Assertions.assertFalse(model.isStaticIpMigrationEnabled());
        Assertions.assertFalse(model.isMacMigrationEnabled());
    }
}
