// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.reservations.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Available scope request properties. */
@Fluent
public final class AvailableScopeRequestProperties {
    /*
     * The scopes property.
     */
    @JsonProperty(value = "scopes")
    private List<String> scopes;

    /** Creates an instance of AvailableScopeRequestProperties class. */
    public AvailableScopeRequestProperties() {
    }

    /**
     * Get the scopes property: The scopes property.
     *
     * @return the scopes value.
     */
    public List<String> scopes() {
        return this.scopes;
    }

    /**
     * Set the scopes property: The scopes property.
     *
     * @param scopes the scopes value to set.
     * @return the AvailableScopeRequestProperties object itself.
     */
    public AvailableScopeRequestProperties withScopes(List<String> scopes) {
        this.scopes = scopes;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
