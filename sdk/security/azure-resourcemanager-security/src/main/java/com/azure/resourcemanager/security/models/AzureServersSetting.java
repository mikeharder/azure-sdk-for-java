// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.security.fluent.models.ServerVulnerabilityAssessmentsAzureSettingProperties;
import com.azure.resourcemanager.security.fluent.models.ServerVulnerabilityAssessmentsSettingInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * A vulnerability assessments setting on Azure servers in the defined scope.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "kind", defaultImpl = AzureServersSetting.class, visible = true)
@JsonTypeName("AzureServersSetting")
@Fluent
public final class AzureServersSetting extends ServerVulnerabilityAssessmentsSettingInner {
    /*
     * The kind of the server vulnerability assessments setting.
     */
    @JsonTypeId
    @JsonProperty(value = "kind", required = true)
    private ServerVulnerabilityAssessmentsSettingKind kind
        = ServerVulnerabilityAssessmentsSettingKind.AZURE_SERVERS_SETTING;

    /*
     * The vulnerability assessments setting properties on Azure servers in the defined scope.
     */
    @JsonProperty(value = "properties")
    private ServerVulnerabilityAssessmentsAzureSettingProperties innerProperties;

    /**
     * Creates an instance of AzureServersSetting class.
     */
    public AzureServersSetting() {
    }

    /**
     * Get the kind property: The kind of the server vulnerability assessments setting.
     * 
     * @return the kind value.
     */
    @Override
    public ServerVulnerabilityAssessmentsSettingKind kind() {
        return this.kind;
    }

    /**
     * Get the innerProperties property: The vulnerability assessments setting properties on Azure servers in the
     * defined scope.
     * 
     * @return the innerProperties value.
     */
    private ServerVulnerabilityAssessmentsAzureSettingProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the selectedProvider property: The selected vulnerability assessments provider on Azure servers in the
     * defined scope.
     * 
     * @return the selectedProvider value.
     */
    public ServerVulnerabilityAssessmentsAzureSettingSelectedProvider selectedProvider() {
        return this.innerProperties() == null ? null : this.innerProperties().selectedProvider();
    }

    /**
     * Set the selectedProvider property: The selected vulnerability assessments provider on Azure servers in the
     * defined scope.
     * 
     * @param selectedProvider the selectedProvider value to set.
     * @return the AzureServersSetting object itself.
     */
    public AzureServersSetting
        withSelectedProvider(ServerVulnerabilityAssessmentsAzureSettingSelectedProvider selectedProvider) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ServerVulnerabilityAssessmentsAzureSettingProperties();
        }
        this.innerProperties().withSelectedProvider(selectedProvider);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}
