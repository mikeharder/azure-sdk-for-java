// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storagemover.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * The NfsMountEndpointUpdateProperties model.
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "endpointType",
    defaultImpl = NfsMountEndpointUpdateProperties.class,
    visible = true)
@JsonTypeName("NfsMount")
@Fluent
public final class NfsMountEndpointUpdateProperties extends EndpointBaseUpdateProperties {
    /*
     * The Endpoint resource type.
     */
    @JsonTypeId
    @JsonProperty(value = "endpointType", required = true)
    private EndpointType endpointType = EndpointType.NFS_MOUNT;

    /**
     * Creates an instance of NfsMountEndpointUpdateProperties class.
     */
    public NfsMountEndpointUpdateProperties() {
    }

    /**
     * Get the endpointType property: The Endpoint resource type.
     * 
     * @return the endpointType value.
     */
    @Override
    public EndpointType endpointType() {
        return this.endpointType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NfsMountEndpointUpdateProperties withDescription(String description) {
        super.withDescription(description);
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
    }
}
