// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.logic.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.logic.fluent.models.IntegrationAccountSessionInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The list of integration account sessions. */
@Fluent
public final class IntegrationAccountSessionListResult {
    /*
     * The list of integration account sessions.
     */
    @JsonProperty(value = "value")
    private List<IntegrationAccountSessionInner> value;

    /*
     * The URL to get the next set of results.
     */
    @JsonProperty(value = "nextLink")
    private String nextLink;

    /** Creates an instance of IntegrationAccountSessionListResult class. */
    public IntegrationAccountSessionListResult() {
    }

    /**
     * Get the value property: The list of integration account sessions.
     *
     * @return the value value.
     */
    public List<IntegrationAccountSessionInner> value() {
        return this.value;
    }

    /**
     * Set the value property: The list of integration account sessions.
     *
     * @param value the value value to set.
     * @return the IntegrationAccountSessionListResult object itself.
     */
    public IntegrationAccountSessionListResult withValue(List<IntegrationAccountSessionInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: The URL to get the next set of results.
     *
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: The URL to get the next set of results.
     *
     * @param nextLink the nextLink value to set.
     * @return the IntegrationAccountSessionListResult object itself.
     */
    public IntegrationAccountSessionListResult withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }
}
