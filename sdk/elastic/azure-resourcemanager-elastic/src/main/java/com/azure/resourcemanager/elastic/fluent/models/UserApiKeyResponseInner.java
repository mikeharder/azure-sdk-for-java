// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.elastic.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.elastic.models.UserApiKeyResponseProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The User Api Key created for the Organization associated with the User Email Id that was passed in the request. */
@Fluent
public final class UserApiKeyResponseInner {
    /*
     * The properties property.
     */
    @JsonProperty(value = "properties")
    private UserApiKeyResponseProperties properties;

    /** Creates an instance of UserApiKeyResponseInner class. */
    public UserApiKeyResponseInner() {
    }

    /**
     * Get the properties property: The properties property.
     *
     * @return the properties value.
     */
    public UserApiKeyResponseProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties property: The properties property.
     *
     * @param properties the properties value to set.
     * @return the UserApiKeyResponseInner object itself.
     */
    public UserApiKeyResponseInner withProperties(UserApiKeyResponseProperties properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (properties() != null) {
            properties().validate();
        }
    }
}
