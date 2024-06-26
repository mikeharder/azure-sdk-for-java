// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hdinsight.fluent.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The response spec of checking name availability. */
@Fluent
public final class NameAvailabilityCheckResultInner {
    /*
     * This indicates whether the name is available.
     */
    @JsonProperty(value = "nameAvailable")
    private Boolean nameAvailable;

    /*
     * The reason of the result.
     */
    @JsonProperty(value = "reason", access = JsonProperty.Access.WRITE_ONLY)
    private String reason;

    /*
     * The related message.
     */
    @JsonProperty(value = "message", access = JsonProperty.Access.WRITE_ONLY)
    private String message;

    /** Creates an instance of NameAvailabilityCheckResultInner class. */
    public NameAvailabilityCheckResultInner() {
    }

    /**
     * Get the nameAvailable property: This indicates whether the name is available.
     *
     * @return the nameAvailable value.
     */
    public Boolean nameAvailable() {
        return this.nameAvailable;
    }

    /**
     * Set the nameAvailable property: This indicates whether the name is available.
     *
     * @param nameAvailable the nameAvailable value to set.
     * @return the NameAvailabilityCheckResultInner object itself.
     */
    public NameAvailabilityCheckResultInner withNameAvailable(Boolean nameAvailable) {
        this.nameAvailable = nameAvailable;
        return this;
    }

    /**
     * Get the reason property: The reason of the result.
     *
     * @return the reason value.
     */
    public String reason() {
        return this.reason;
    }

    /**
     * Get the message property: The related message.
     *
     * @return the message value.
     */
    public String message() {
        return this.message;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
