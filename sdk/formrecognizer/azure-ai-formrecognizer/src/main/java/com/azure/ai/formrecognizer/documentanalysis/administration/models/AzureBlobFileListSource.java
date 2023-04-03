// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.formrecognizer.documentanalysis.administration.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** File list in Azure Blob Storage. */
@Fluent
public final class AzureBlobFileListSource {
    /*
     * Azure Blob Storage container URL.
     */
    @JsonProperty(value = "containerUrl", required = true)
    private String containerUrl;

    /*
     * Path to a JSONL file within the container specifying a subset of documents for training.
     */
    @JsonProperty(value = "fileList", required = true)
    private String fileList;

    /** Creates an instance of AzureBlobFileListSource class. */
    public AzureBlobFileListSource() {}

    /**
     * Get the containerUrl property: Azure Blob Storage container URL.
     *
     * @return the containerUrl value.
     */
    public String getContainerUrl() {
        return this.containerUrl;
    }

    /**
     * Set the containerUrl property: Azure Blob Storage container URL.
     *
     * @param containerUrl the containerUrl value to set.
     * @return the AzureBlobFileListSource object itself.
     */
    public AzureBlobFileListSource setContainerUrl(String containerUrl) {
        this.containerUrl = containerUrl;
        return this;
    }

    /**
     * Get the fileList property: Path to a JSONL file within the container specifying a subset of documents for
     * training.
     *
     * @return the fileList value.
     */
    public String getFileList() {
        return this.fileList;
    }

    /**
     * Set the fileList property: Path to a JSONL file within the container specifying a subset of documents for
     * training.
     *
     * @param fileList the fileList value to set.
     * @return the AzureBlobFileListSource object itself.
     */
    public AzureBlobFileListSource setFileList(String fileList) {
        this.fileList = fileList;
        return this;
    }
}