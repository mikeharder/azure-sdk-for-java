// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.costmanagement.implementation;

import com.azure.core.management.exception.ManagementError;
import com.azure.resourcemanager.costmanagement.fluent.models.CommonExportPropertiesInner;
import com.azure.resourcemanager.costmanagement.fluent.models.ExportRunPropertiesInner;
import com.azure.resourcemanager.costmanagement.models.CommonExportProperties;
import com.azure.resourcemanager.costmanagement.models.ExecutionStatus;
import com.azure.resourcemanager.costmanagement.models.ExecutionType;
import com.azure.resourcemanager.costmanagement.models.ExportRunProperties;
import java.time.OffsetDateTime;

public final class ExportRunPropertiesImpl implements ExportRunProperties {
    private ExportRunPropertiesInner innerObject;

    private final com.azure.resourcemanager.costmanagement.CostManagementManager serviceManager;

    ExportRunPropertiesImpl(ExportRunPropertiesInner innerObject,
        com.azure.resourcemanager.costmanagement.CostManagementManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public ExecutionType executionType() {
        return this.innerModel().executionType();
    }

    public ExecutionStatus status() {
        return this.innerModel().status();
    }

    public String submittedBy() {
        return this.innerModel().submittedBy();
    }

    public OffsetDateTime submittedTime() {
        return this.innerModel().submittedTime();
    }

    public OffsetDateTime processingStartTime() {
        return this.innerModel().processingStartTime();
    }

    public OffsetDateTime processingEndTime() {
        return this.innerModel().processingEndTime();
    }

    public String fileName() {
        return this.innerModel().fileName();
    }

    public CommonExportProperties runSettings() {
        CommonExportPropertiesInner inner = this.innerModel().runSettings();
        if (inner != null) {
            return new CommonExportPropertiesImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public ManagementError error() {
        return this.innerModel().error();
    }

    public ExportRunPropertiesInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.costmanagement.CostManagementManager manager() {
        return this.serviceManager;
    }
}
