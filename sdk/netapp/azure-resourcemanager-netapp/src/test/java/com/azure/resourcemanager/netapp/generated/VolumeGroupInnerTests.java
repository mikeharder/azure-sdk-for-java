// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.netapp.fluent.models.VolumeGroupInner;
import com.azure.resourcemanager.netapp.models.ApplicationType;
import com.azure.resourcemanager.netapp.models.VolumeGroupMetadata;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class VolumeGroupInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        VolumeGroupInner model =
            BinaryData
                .fromString(
                    "{\"location\":\"cizsjqlhkrribdei\",\"id\":\"ipqkghvxndzwm\",\"name\":\"efajpj\",\"type\":\"wkqnyhg\",\"properties\":{\"provisioningState\":\"tjivfxzsjabib\",\"groupMetaData\":{\"groupDescription\":\"tawfsdjpvkvp\",\"applicationType\":\"SAP-HANA\",\"applicationIdentifier\":\"kzbzkdvncjabudu\",\"globalPlacementRules\":[],\"deploymentSpecId\":\"kmokz\",\"volumesCount\":2248907093975297235}}}")
                .toObject(VolumeGroupInner.class);
        Assertions.assertEquals("cizsjqlhkrribdei", model.location());
        Assertions.assertEquals("tawfsdjpvkvp", model.groupMetadata().groupDescription());
        Assertions.assertEquals(ApplicationType.SAP_HANA, model.groupMetadata().applicationType());
        Assertions.assertEquals("kzbzkdvncjabudu", model.groupMetadata().applicationIdentifier());
        Assertions.assertEquals("kmokz", model.groupMetadata().deploymentSpecId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        VolumeGroupInner model =
            new VolumeGroupInner()
                .withLocation("cizsjqlhkrribdei")
                .withGroupMetadata(
                    new VolumeGroupMetadata()
                        .withGroupDescription("tawfsdjpvkvp")
                        .withApplicationType(ApplicationType.SAP_HANA)
                        .withApplicationIdentifier("kzbzkdvncjabudu")
                        .withGlobalPlacementRules(Arrays.asList())
                        .withDeploymentSpecId("kmokz"));
        model = BinaryData.fromObject(model).toObject(VolumeGroupInner.class);
        Assertions.assertEquals("cizsjqlhkrribdei", model.location());
        Assertions.assertEquals("tawfsdjpvkvp", model.groupMetadata().groupDescription());
        Assertions.assertEquals(ApplicationType.SAP_HANA, model.groupMetadata().applicationType());
        Assertions.assertEquals("kzbzkdvncjabudu", model.groupMetadata().applicationIdentifier());
        Assertions.assertEquals("kmokz", model.groupMetadata().deploymentSpecId());
    }
}