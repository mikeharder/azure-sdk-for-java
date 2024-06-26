// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.automation.fluent.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.Map;

/** Definition of the watcher properties. */
@Fluent
public final class WatcherProperties {
    /*
     * Gets or sets the frequency at which the watcher is invoked.
     */
    @JsonProperty(value = "executionFrequencyInSeconds")
    private Long executionFrequencyInSeconds;

    /*
     * Gets or sets the name of the script the watcher is attached to, i.e. the name of an existing runbook.
     */
    @JsonProperty(value = "scriptName")
    private String scriptName;

    /*
     * Gets or sets the parameters of the script.
     */
    @JsonProperty(value = "scriptParameters")
    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.ALWAYS)
    private Map<String, String> scriptParameters;

    /*
     * Gets or sets the name of the hybrid worker group the watcher will run on.
     */
    @JsonProperty(value = "scriptRunOn")
    private String scriptRunOn;

    /*
     * Gets the current status of the watcher.
     */
    @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY)
    private String status;

    /*
     * Gets or sets the creation time.
     */
    @JsonProperty(value = "creationTime", access = JsonProperty.Access.WRITE_ONLY)
    private OffsetDateTime creationTime;

    /*
     * Gets or sets the last modified time.
     */
    @JsonProperty(value = "lastModifiedTime", access = JsonProperty.Access.WRITE_ONLY)
    private OffsetDateTime lastModifiedTime;

    /*
     * Details of the user who last modified the watcher.
     */
    @JsonProperty(value = "lastModifiedBy", access = JsonProperty.Access.WRITE_ONLY)
    private String lastModifiedBy;

    /*
     * Gets or sets the description.
     */
    @JsonProperty(value = "description")
    private String description;

    /**
     * Get the executionFrequencyInSeconds property: Gets or sets the frequency at which the watcher is invoked.
     *
     * @return the executionFrequencyInSeconds value.
     */
    public Long executionFrequencyInSeconds() {
        return this.executionFrequencyInSeconds;
    }

    /**
     * Set the executionFrequencyInSeconds property: Gets or sets the frequency at which the watcher is invoked.
     *
     * @param executionFrequencyInSeconds the executionFrequencyInSeconds value to set.
     * @return the WatcherProperties object itself.
     */
    public WatcherProperties withExecutionFrequencyInSeconds(Long executionFrequencyInSeconds) {
        this.executionFrequencyInSeconds = executionFrequencyInSeconds;
        return this;
    }

    /**
     * Get the scriptName property: Gets or sets the name of the script the watcher is attached to, i.e. the name of an
     * existing runbook.
     *
     * @return the scriptName value.
     */
    public String scriptName() {
        return this.scriptName;
    }

    /**
     * Set the scriptName property: Gets or sets the name of the script the watcher is attached to, i.e. the name of an
     * existing runbook.
     *
     * @param scriptName the scriptName value to set.
     * @return the WatcherProperties object itself.
     */
    public WatcherProperties withScriptName(String scriptName) {
        this.scriptName = scriptName;
        return this;
    }

    /**
     * Get the scriptParameters property: Gets or sets the parameters of the script.
     *
     * @return the scriptParameters value.
     */
    public Map<String, String> scriptParameters() {
        return this.scriptParameters;
    }

    /**
     * Set the scriptParameters property: Gets or sets the parameters of the script.
     *
     * @param scriptParameters the scriptParameters value to set.
     * @return the WatcherProperties object itself.
     */
    public WatcherProperties withScriptParameters(Map<String, String> scriptParameters) {
        this.scriptParameters = scriptParameters;
        return this;
    }

    /**
     * Get the scriptRunOn property: Gets or sets the name of the hybrid worker group the watcher will run on.
     *
     * @return the scriptRunOn value.
     */
    public String scriptRunOn() {
        return this.scriptRunOn;
    }

    /**
     * Set the scriptRunOn property: Gets or sets the name of the hybrid worker group the watcher will run on.
     *
     * @param scriptRunOn the scriptRunOn value to set.
     * @return the WatcherProperties object itself.
     */
    public WatcherProperties withScriptRunOn(String scriptRunOn) {
        this.scriptRunOn = scriptRunOn;
        return this;
    }

    /**
     * Get the status property: Gets the current status of the watcher.
     *
     * @return the status value.
     */
    public String status() {
        return this.status;
    }

    /**
     * Get the creationTime property: Gets or sets the creation time.
     *
     * @return the creationTime value.
     */
    public OffsetDateTime creationTime() {
        return this.creationTime;
    }

    /**
     * Get the lastModifiedTime property: Gets or sets the last modified time.
     *
     * @return the lastModifiedTime value.
     */
    public OffsetDateTime lastModifiedTime() {
        return this.lastModifiedTime;
    }

    /**
     * Get the lastModifiedBy property: Details of the user who last modified the watcher.
     *
     * @return the lastModifiedBy value.
     */
    public String lastModifiedBy() {
        return this.lastModifiedBy;
    }

    /**
     * Get the description property: Gets or sets the description.
     *
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: Gets or sets the description.
     *
     * @param description the description value to set.
     * @return the WatcherProperties object itself.
     */
    public WatcherProperties withDescription(String description) {
        this.description = description;
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
