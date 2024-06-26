// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.batch.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.batch.models.AutomaticOSUpgradePolicy;
import com.azure.resourcemanager.batch.models.RollingUpgradePolicy;
import com.azure.resourcemanager.batch.models.UpgradeMode;
import com.azure.resourcemanager.batch.models.UpgradePolicy;
import org.junit.jupiter.api.Assertions;

public final class UpgradePolicyTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        UpgradePolicy model = BinaryData.fromString(
            "{\"mode\":\"manual\",\"automaticOSUpgradePolicy\":{\"disableAutomaticRollback\":false,\"enableAutomaticOSUpgrade\":false,\"useRollingUpgradePolicy\":true,\"osRollingUpgradeDeferral\":true},\"rollingUpgradePolicy\":{\"enableCrossZoneUpgrade\":true,\"maxBatchInstancePercent\":881779477,\"maxUnhealthyInstancePercent\":1460158080,\"maxUnhealthyUpgradedInstancePercent\":1973822753,\"pauseTimeBetweenBatches\":\"kjj\",\"prioritizeUnhealthyInstances\":true,\"rollbackFailedInstancesOnPolicyBreach\":true}}")
            .toObject(UpgradePolicy.class);
        Assertions.assertEquals(UpgradeMode.MANUAL, model.mode());
        Assertions.assertEquals(false, model.automaticOSUpgradePolicy().disableAutomaticRollback());
        Assertions.assertEquals(false, model.automaticOSUpgradePolicy().enableAutomaticOSUpgrade());
        Assertions.assertEquals(true, model.automaticOSUpgradePolicy().useRollingUpgradePolicy());
        Assertions.assertEquals(true, model.automaticOSUpgradePolicy().osRollingUpgradeDeferral());
        Assertions.assertEquals(true, model.rollingUpgradePolicy().enableCrossZoneUpgrade());
        Assertions.assertEquals(881779477, model.rollingUpgradePolicy().maxBatchInstancePercent());
        Assertions.assertEquals(1460158080, model.rollingUpgradePolicy().maxUnhealthyInstancePercent());
        Assertions.assertEquals(1973822753, model.rollingUpgradePolicy().maxUnhealthyUpgradedInstancePercent());
        Assertions.assertEquals("kjj", model.rollingUpgradePolicy().pauseTimeBetweenBatches());
        Assertions.assertEquals(true, model.rollingUpgradePolicy().prioritizeUnhealthyInstances());
        Assertions.assertEquals(true, model.rollingUpgradePolicy().rollbackFailedInstancesOnPolicyBreach());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        UpgradePolicy model
            = new UpgradePolicy().withMode(UpgradeMode.MANUAL)
                .withAutomaticOSUpgradePolicy(new AutomaticOSUpgradePolicy().withDisableAutomaticRollback(false)
                    .withEnableAutomaticOSUpgrade(false).withUseRollingUpgradePolicy(true)
                    .withOsRollingUpgradeDeferral(true))
                .withRollingUpgradePolicy(new RollingUpgradePolicy().withEnableCrossZoneUpgrade(true)
                    .withMaxBatchInstancePercent(881779477).withMaxUnhealthyInstancePercent(1460158080)
                    .withMaxUnhealthyUpgradedInstancePercent(1973822753).withPauseTimeBetweenBatches("kjj")
                    .withPrioritizeUnhealthyInstances(true).withRollbackFailedInstancesOnPolicyBreach(true));
        model = BinaryData.fromObject(model).toObject(UpgradePolicy.class);
        Assertions.assertEquals(UpgradeMode.MANUAL, model.mode());
        Assertions.assertEquals(false, model.automaticOSUpgradePolicy().disableAutomaticRollback());
        Assertions.assertEquals(false, model.automaticOSUpgradePolicy().enableAutomaticOSUpgrade());
        Assertions.assertEquals(true, model.automaticOSUpgradePolicy().useRollingUpgradePolicy());
        Assertions.assertEquals(true, model.automaticOSUpgradePolicy().osRollingUpgradeDeferral());
        Assertions.assertEquals(true, model.rollingUpgradePolicy().enableCrossZoneUpgrade());
        Assertions.assertEquals(881779477, model.rollingUpgradePolicy().maxBatchInstancePercent());
        Assertions.assertEquals(1460158080, model.rollingUpgradePolicy().maxUnhealthyInstancePercent());
        Assertions.assertEquals(1973822753, model.rollingUpgradePolicy().maxUnhealthyUpgradedInstancePercent());
        Assertions.assertEquals("kjj", model.rollingUpgradePolicy().pauseTimeBetweenBatches());
        Assertions.assertEquals(true, model.rollingUpgradePolicy().prioritizeUnhealthyInstances());
        Assertions.assertEquals(true, model.rollingUpgradePolicy().rollbackFailedInstancesOnPolicyBreach());
    }
}
