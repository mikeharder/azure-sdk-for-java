// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Properties of Cognitive Services account deployment model. */
@Fluent
public class DeploymentModel {
    /*
     * Deployment model format.
     */
    @JsonProperty(value = "format")
    private String format;

    /*
     * Deployment model name.
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * Optional. Deployment model version. If version is not specified, a default version will be assigned. The default
     * version is different for different models and might change when there is new version available for a model.
     * Default version for a model could be found from list models API.
     */
    @JsonProperty(value = "version")
    private String version;

    /*
     * Optional. Deployment model source ARM resource ID.
     */
    @JsonProperty(value = "source")
    private String source;

    /*
     * The call rate limit Cognitive Services account.
     */
    @JsonProperty(value = "callRateLimit", access = JsonProperty.Access.WRITE_ONLY)
    private CallRateLimit callRateLimit;

    /** Creates an instance of DeploymentModel class. */
    public DeploymentModel() {
    }

    /**
     * Get the format property: Deployment model format.
     *
     * @return the format value.
     */
    public String format() {
        return this.format;
    }

    /**
     * Set the format property: Deployment model format.
     *
     * @param format the format value to set.
     * @return the DeploymentModel object itself.
     */
    public DeploymentModel withFormat(String format) {
        this.format = format;
        return this;
    }

    /**
     * Get the name property: Deployment model name.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Deployment model name.
     *
     * @param name the name value to set.
     * @return the DeploymentModel object itself.
     */
    public DeploymentModel withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the version property: Optional. Deployment model version. If version is not specified, a default version will
     * be assigned. The default version is different for different models and might change when there is new version
     * available for a model. Default version for a model could be found from list models API.
     *
     * @return the version value.
     */
    public String version() {
        return this.version;
    }

    /**
     * Set the version property: Optional. Deployment model version. If version is not specified, a default version will
     * be assigned. The default version is different for different models and might change when there is new version
     * available for a model. Default version for a model could be found from list models API.
     *
     * @param version the version value to set.
     * @return the DeploymentModel object itself.
     */
    public DeploymentModel withVersion(String version) {
        this.version = version;
        return this;
    }

    /**
     * Get the source property: Optional. Deployment model source ARM resource ID.
     *
     * @return the source value.
     */
    public String source() {
        return this.source;
    }

    /**
     * Set the source property: Optional. Deployment model source ARM resource ID.
     *
     * @param source the source value to set.
     * @return the DeploymentModel object itself.
     */
    public DeploymentModel withSource(String source) {
        this.source = source;
        return this;
    }

    /**
     * Get the callRateLimit property: The call rate limit Cognitive Services account.
     *
     * @return the callRateLimit value.
     */
    public CallRateLimit callRateLimit() {
        return this.callRateLimit;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (callRateLimit() != null) {
            callRateLimit().validate();
        }
    }
}
