// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.fluent.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The properties of the enrollment account. */
@Immutable
public final class EnrollmentAccountSummaryProperties {
    /*
     * The account owner's principal name.
     */
    @JsonProperty(value = "principalName", access = JsonProperty.Access.WRITE_ONLY)
    private String principalName;

    /** Creates an instance of EnrollmentAccountSummaryProperties class. */
    public EnrollmentAccountSummaryProperties() {
    }

    /**
     * Get the principalName property: The account owner's principal name.
     *
     * @return the principalName value.
     */
    public String principalName() {
        return this.principalName;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
