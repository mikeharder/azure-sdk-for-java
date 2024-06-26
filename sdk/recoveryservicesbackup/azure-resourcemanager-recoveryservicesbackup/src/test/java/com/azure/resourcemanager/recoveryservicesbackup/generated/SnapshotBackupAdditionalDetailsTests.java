// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicesbackup.models.SnapshotBackupAdditionalDetails;
import com.azure.resourcemanager.recoveryservicesbackup.models.UserAssignedIdentityProperties;
import com.azure.resourcemanager.recoveryservicesbackup.models.UserAssignedManagedIdentityDetails;
import org.junit.jupiter.api.Assertions;

public final class SnapshotBackupAdditionalDetailsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SnapshotBackupAdditionalDetails model = BinaryData.fromString(
            "{\"instantRpRetentionRangeInDays\":751350709,\"instantRPDetails\":\"kdl\",\"userAssignedManagedIdentityDetails\":{\"identityArmId\":\"fbumlkx\",\"identityName\":\"qjfsmlmbtxhw\",\"userAssignedIdentityProperties\":{\"clientId\":\"srtawcoezbr\",\"principalId\":\"bskhudygoookkqfq\"}}}")
            .toObject(SnapshotBackupAdditionalDetails.class);
        Assertions.assertEquals(751350709, model.instantRpRetentionRangeInDays());
        Assertions.assertEquals("kdl", model.instantRPDetails());
        Assertions.assertEquals("fbumlkx", model.userAssignedManagedIdentityDetails().identityArmId());
        Assertions.assertEquals("qjfsmlmbtxhw", model.userAssignedManagedIdentityDetails().identityName());
        Assertions.assertEquals("srtawcoezbr",
            model.userAssignedManagedIdentityDetails().userAssignedIdentityProperties().clientId());
        Assertions.assertEquals("bskhudygoookkqfq",
            model.userAssignedManagedIdentityDetails().userAssignedIdentityProperties().principalId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SnapshotBackupAdditionalDetails model
            = new SnapshotBackupAdditionalDetails().withInstantRpRetentionRangeInDays(751350709)
                .withInstantRPDetails("kdl")
                .withUserAssignedManagedIdentityDetails(new UserAssignedManagedIdentityDetails()
                    .withIdentityArmId("fbumlkx")
                    .withIdentityName("qjfsmlmbtxhw")
                    .withUserAssignedIdentityProperties(new UserAssignedIdentityProperties().withClientId("srtawcoezbr")
                        .withPrincipalId("bskhudygoookkqfq")));
        model = BinaryData.fromObject(model).toObject(SnapshotBackupAdditionalDetails.class);
        Assertions.assertEquals(751350709, model.instantRpRetentionRangeInDays());
        Assertions.assertEquals("kdl", model.instantRPDetails());
        Assertions.assertEquals("fbumlkx", model.userAssignedManagedIdentityDetails().identityArmId());
        Assertions.assertEquals("qjfsmlmbtxhw", model.userAssignedManagedIdentityDetails().identityName());
        Assertions.assertEquals("srtawcoezbr",
            model.userAssignedManagedIdentityDetails().userAssignedIdentityProperties().clientId());
        Assertions.assertEquals("bskhudygoookkqfq",
            model.userAssignedManagedIdentityDetails().userAssignedIdentityProperties().principalId());
    }
}
