// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.providerhub.models.TemplateDeploymentCapabilities;
import com.azure.resourcemanager.providerhub.models.TemplateDeploymentPolicy;
import com.azure.resourcemanager.providerhub.models.TemplateDeploymentPreflightNotifications;
import com.azure.resourcemanager.providerhub.models.TemplateDeploymentPreflightOptions;
import org.junit.jupiter.api.Assertions;

public final class TemplateDeploymentPolicyTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        TemplateDeploymentPolicy model = BinaryData.fromString(
            "{\"capabilities\":\"Preflight\",\"preflightOptions\":\"TestOnly\",\"preflightNotifications\":\"None\"}")
            .toObject(TemplateDeploymentPolicy.class);
        Assertions.assertEquals(TemplateDeploymentCapabilities.PREFLIGHT, model.capabilities());
        Assertions.assertEquals(TemplateDeploymentPreflightOptions.TEST_ONLY, model.preflightOptions());
        Assertions.assertEquals(TemplateDeploymentPreflightNotifications.NONE, model.preflightNotifications());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        TemplateDeploymentPolicy model
            = new TemplateDeploymentPolicy().withCapabilities(TemplateDeploymentCapabilities.PREFLIGHT)
                .withPreflightOptions(TemplateDeploymentPreflightOptions.TEST_ONLY)
                .withPreflightNotifications(TemplateDeploymentPreflightNotifications.NONE);
        model = BinaryData.fromObject(model).toObject(TemplateDeploymentPolicy.class);
        Assertions.assertEquals(TemplateDeploymentCapabilities.PREFLIGHT, model.capabilities());
        Assertions.assertEquals(TemplateDeploymentPreflightOptions.TEST_ONLY, model.preflightOptions());
        Assertions.assertEquals(TemplateDeploymentPreflightNotifications.NONE, model.preflightNotifications());
    }
}
