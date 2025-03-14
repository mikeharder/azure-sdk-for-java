// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.costmanagement.models;

import com.azure.core.management.exception.ManagementError;
import com.azure.resourcemanager.costmanagement.fluent.models.ExportRunInner;
import java.time.OffsetDateTime;

/**
 * An immutable client-side representation of ExportRun.
 */
public interface ExportRun {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     * 
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     * 
     * @return the type value.
     */
    String type();

    /**
     * Gets the etag property: eTag of the resource. To handle concurrent update scenario, this field will be used to
     * determine whether the user is updating the latest version or not.
     * 
     * @return the etag value.
     */
    String etag();

    /**
     * Gets the executionType property: The type of the export run.
     * 
     * @return the executionType value.
     */
    ExecutionType executionType();

    /**
     * Gets the status property: The last known status of the export run.
     * 
     * @return the status value.
     */
    ExecutionStatus status();

    /**
     * Gets the submittedBy property: The identifier for the entity that triggered the export. For on-demand runs it is
     * the user email. For scheduled runs it is 'System'.
     * 
     * @return the submittedBy value.
     */
    String submittedBy();

    /**
     * Gets the submittedTime property: The time when export was queued to be run.
     * 
     * @return the submittedTime value.
     */
    OffsetDateTime submittedTime();

    /**
     * Gets the processingStartTime property: The time when export was picked up to be run.
     * 
     * @return the processingStartTime value.
     */
    OffsetDateTime processingStartTime();

    /**
     * Gets the processingEndTime property: The time when the export run finished.
     * 
     * @return the processingEndTime value.
     */
    OffsetDateTime processingEndTime();

    /**
     * Gets the fileName property: The name of the exported file.
     * 
     * @return the fileName value.
     */
    String fileName();

    /**
     * Gets the runSettings property: The export settings that were in effect for this run.
     * 
     * @return the runSettings value.
     */
    CommonExportProperties runSettings();

    /**
     * Gets the error property: The details of any error.
     * 
     * @return the error value.
     */
    ManagementError error();

    /**
     * Gets the inner com.azure.resourcemanager.costmanagement.fluent.models.ExportRunInner object.
     * 
     * @return the inner object.
     */
    ExportRunInner innerModel();
}
