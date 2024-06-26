// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storagemover.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.storagemover.fluent.models.JobDefinitionUpdateProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Job Definition resource.
 */
@Fluent
public final class JobDefinitionUpdateParameters {
    /*
     * Job definition properties.
     */
    @JsonProperty(value = "properties")
    private JobDefinitionUpdateProperties innerProperties;

    /**
     * Creates an instance of JobDefinitionUpdateParameters class.
     */
    public JobDefinitionUpdateParameters() {
    }

    /**
     * Get the innerProperties property: Job definition properties.
     * 
     * @return the innerProperties value.
     */
    private JobDefinitionUpdateProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the description property: A description for the Job Definition.
     * 
     * @return the description value.
     */
    public String description() {
        return this.innerProperties() == null ? null : this.innerProperties().description();
    }

    /**
     * Set the description property: A description for the Job Definition.
     * 
     * @param description the description value to set.
     * @return the JobDefinitionUpdateParameters object itself.
     */
    public JobDefinitionUpdateParameters withDescription(String description) {
        if (this.innerProperties() == null) {
            this.innerProperties = new JobDefinitionUpdateProperties();
        }
        this.innerProperties().withDescription(description);
        return this;
    }

    /**
     * Get the copyMode property: Strategy to use for copy.
     * 
     * @return the copyMode value.
     */
    public CopyMode copyMode() {
        return this.innerProperties() == null ? null : this.innerProperties().copyMode();
    }

    /**
     * Set the copyMode property: Strategy to use for copy.
     * 
     * @param copyMode the copyMode value to set.
     * @return the JobDefinitionUpdateParameters object itself.
     */
    public JobDefinitionUpdateParameters withCopyMode(CopyMode copyMode) {
        if (this.innerProperties() == null) {
            this.innerProperties = new JobDefinitionUpdateProperties();
        }
        this.innerProperties().withCopyMode(copyMode);
        return this;
    }

    /**
     * Get the agentName property: Name of the Agent to assign for new Job Runs of this Job Definition.
     * 
     * @return the agentName value.
     */
    public String agentName() {
        return this.innerProperties() == null ? null : this.innerProperties().agentName();
    }

    /**
     * Set the agentName property: Name of the Agent to assign for new Job Runs of this Job Definition.
     * 
     * @param agentName the agentName value to set.
     * @return the JobDefinitionUpdateParameters object itself.
     */
    public JobDefinitionUpdateParameters withAgentName(String agentName) {
        if (this.innerProperties() == null) {
            this.innerProperties = new JobDefinitionUpdateProperties();
        }
        this.innerProperties().withAgentName(agentName);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}
