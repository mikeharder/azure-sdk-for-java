// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridnetwork.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.resourcemanager.hybridnetwork.models.AzureContainerRegistryScopedTokenCredential;
import com.azure.resourcemanager.hybridnetwork.models.AzureStorageAccountCredential;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * The artifact manifest credential definition.
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "credentialType",
    defaultImpl = ArtifactAccessCredentialInner.class)
@JsonTypeName("ArtifactAccessCredential")
@JsonSubTypes({
    @JsonSubTypes.Type(
        name = "AzureContainerRegistryScopedToken",
        value = AzureContainerRegistryScopedTokenCredential.class),
    @JsonSubTypes.Type(name = "AzureStorageAccountToken", value = AzureStorageAccountCredential.class) })
@Immutable
public class ArtifactAccessCredentialInner {
    /**
     * Creates an instance of ArtifactAccessCredentialInner class.
     */
    public ArtifactAccessCredentialInner() {
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
