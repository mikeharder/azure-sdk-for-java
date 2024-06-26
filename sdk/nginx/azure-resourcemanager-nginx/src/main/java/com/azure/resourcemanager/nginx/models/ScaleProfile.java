// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.nginx.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The autoscale profile.
 */
@Fluent
public final class ScaleProfile {
    /*
     * The name property.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /*
     * The capacity parameters of the profile.
     */
    @JsonProperty(value = "capacity", required = true)
    private ScaleProfileCapacity capacity;

    /**
     * Creates an instance of ScaleProfile class.
     */
    public ScaleProfile() {
    }

    /**
     * Get the name property: The name property.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: The name property.
     * 
     * @param name the name value to set.
     * @return the ScaleProfile object itself.
     */
    public ScaleProfile withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the capacity property: The capacity parameters of the profile.
     * 
     * @return the capacity value.
     */
    public ScaleProfileCapacity capacity() {
        return this.capacity;
    }

    /**
     * Set the capacity property: The capacity parameters of the profile.
     * 
     * @param capacity the capacity value to set.
     * @return the ScaleProfile object itself.
     */
    public ScaleProfile withCapacity(ScaleProfileCapacity capacity) {
        this.capacity = capacity;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (name() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property name in model ScaleProfile"));
        }
        if (capacity() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property capacity in model ScaleProfile"));
        } else {
            capacity().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ScaleProfile.class);
}
