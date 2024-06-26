// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.reservations.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Exchange policy errors. */
@Fluent
public final class ExchangePolicyErrors {
    /*
     * Exchange Policy errors
     */
    @JsonProperty(value = "policyErrors")
    private List<ExchangePolicyError> policyErrors;

    /** Creates an instance of ExchangePolicyErrors class. */
    public ExchangePolicyErrors() {
    }

    /**
     * Get the policyErrors property: Exchange Policy errors.
     *
     * @return the policyErrors value.
     */
    public List<ExchangePolicyError> policyErrors() {
        return this.policyErrors;
    }

    /**
     * Set the policyErrors property: Exchange Policy errors.
     *
     * @param policyErrors the policyErrors value to set.
     * @return the ExchangePolicyErrors object itself.
     */
    public ExchangePolicyErrors withPolicyErrors(List<ExchangePolicyError> policyErrors) {
        this.policyErrors = policyErrors;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (policyErrors() != null) {
            policyErrors().forEach(e -> e.validate());
        }
    }
}
