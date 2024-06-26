// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.reservations.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The scopes checked by the available scope api. */
@Fluent
public final class SubscriptionScopeProperties {
    /*
     * The scopes property.
     */
    @JsonProperty(value = "scopes")
    private List<ScopeProperties> scopes;

    /** Creates an instance of SubscriptionScopeProperties class. */
    public SubscriptionScopeProperties() {
    }

    /**
     * Get the scopes property: The scopes property.
     *
     * @return the scopes value.
     */
    public List<ScopeProperties> scopes() {
        return this.scopes;
    }

    /**
     * Set the scopes property: The scopes property.
     *
     * @param scopes the scopes value to set.
     * @return the SubscriptionScopeProperties object itself.
     */
    public SubscriptionScopeProperties withScopes(List<ScopeProperties> scopes) {
        this.scopes = scopes;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (scopes() != null) {
            scopes().forEach(e -> e.validate());
        }
    }
}
