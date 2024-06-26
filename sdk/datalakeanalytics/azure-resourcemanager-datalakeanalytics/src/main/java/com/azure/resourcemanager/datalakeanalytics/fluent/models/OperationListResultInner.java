// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datalakeanalytics.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.resourcemanager.datalakeanalytics.models.Operation;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The list of available operations for Data Lake Analytics. */
@Immutable
public final class OperationListResultInner {
    /*
     * The results of the list operation.
     */
    @JsonProperty(value = "value", access = JsonProperty.Access.WRITE_ONLY)
    private List<Operation> value;

    /*
     * The link (url) to the next page of results.
     */
    @JsonProperty(value = "nextLink", access = JsonProperty.Access.WRITE_ONLY)
    private String nextLink;

    /** Creates an instance of OperationListResultInner class. */
    public OperationListResultInner() {
    }

    /**
     * Get the value property: The results of the list operation.
     *
     * @return the value value.
     */
    public List<Operation> value() {
        return this.value;
    }

    /**
     * Get the nextLink property: The link (url) to the next page of results.
     *
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
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
