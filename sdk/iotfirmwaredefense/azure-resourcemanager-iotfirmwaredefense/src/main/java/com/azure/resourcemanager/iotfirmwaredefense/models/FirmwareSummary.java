// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.iotfirmwaredefense.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Properties for high level summary of firmware analysis results.
 */
@Fluent
public final class FirmwareSummary extends SummaryResourceProperties {
    /*
     * Describes the type of summary.
     */
    private SummaryType summaryType = SummaryType.FIRMWARE;

    /*
     * Total extracted size of the firmware in bytes.
     */
    private Long extractedSize;

    /*
     * Firmware file size in bytes.
     */
    private Long fileSize;

    /*
     * Extracted file count.
     */
    private Long extractedFileCount;

    /*
     * Components count.
     */
    private Long componentCount;

    /*
     * Binary count
     */
    private Long binaryCount;

    /*
     * Time used for analysis
     */
    private Long analysisTimeSeconds;

    /*
     * The number of root file systems found.
     */
    private Long rootFileSystems;

    /**
     * Creates an instance of FirmwareSummary class.
     */
    public FirmwareSummary() {
    }

    /**
     * Get the summaryType property: Describes the type of summary.
     * 
     * @return the summaryType value.
     */
    @Override
    public SummaryType summaryType() {
        return this.summaryType;
    }

    /**
     * Get the extractedSize property: Total extracted size of the firmware in bytes.
     * 
     * @return the extractedSize value.
     */
    public Long extractedSize() {
        return this.extractedSize;
    }

    /**
     * Set the extractedSize property: Total extracted size of the firmware in bytes.
     * 
     * @param extractedSize the extractedSize value to set.
     * @return the FirmwareSummary object itself.
     */
    public FirmwareSummary withExtractedSize(Long extractedSize) {
        this.extractedSize = extractedSize;
        return this;
    }

    /**
     * Get the fileSize property: Firmware file size in bytes.
     * 
     * @return the fileSize value.
     */
    public Long fileSize() {
        return this.fileSize;
    }

    /**
     * Set the fileSize property: Firmware file size in bytes.
     * 
     * @param fileSize the fileSize value to set.
     * @return the FirmwareSummary object itself.
     */
    public FirmwareSummary withFileSize(Long fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    /**
     * Get the extractedFileCount property: Extracted file count.
     * 
     * @return the extractedFileCount value.
     */
    public Long extractedFileCount() {
        return this.extractedFileCount;
    }

    /**
     * Set the extractedFileCount property: Extracted file count.
     * 
     * @param extractedFileCount the extractedFileCount value to set.
     * @return the FirmwareSummary object itself.
     */
    public FirmwareSummary withExtractedFileCount(Long extractedFileCount) {
        this.extractedFileCount = extractedFileCount;
        return this;
    }

    /**
     * Get the componentCount property: Components count.
     * 
     * @return the componentCount value.
     */
    public Long componentCount() {
        return this.componentCount;
    }

    /**
     * Set the componentCount property: Components count.
     * 
     * @param componentCount the componentCount value to set.
     * @return the FirmwareSummary object itself.
     */
    public FirmwareSummary withComponentCount(Long componentCount) {
        this.componentCount = componentCount;
        return this;
    }

    /**
     * Get the binaryCount property: Binary count.
     * 
     * @return the binaryCount value.
     */
    public Long binaryCount() {
        return this.binaryCount;
    }

    /**
     * Set the binaryCount property: Binary count.
     * 
     * @param binaryCount the binaryCount value to set.
     * @return the FirmwareSummary object itself.
     */
    public FirmwareSummary withBinaryCount(Long binaryCount) {
        this.binaryCount = binaryCount;
        return this;
    }

    /**
     * Get the analysisTimeSeconds property: Time used for analysis.
     * 
     * @return the analysisTimeSeconds value.
     */
    public Long analysisTimeSeconds() {
        return this.analysisTimeSeconds;
    }

    /**
     * Set the analysisTimeSeconds property: Time used for analysis.
     * 
     * @param analysisTimeSeconds the analysisTimeSeconds value to set.
     * @return the FirmwareSummary object itself.
     */
    public FirmwareSummary withAnalysisTimeSeconds(Long analysisTimeSeconds) {
        this.analysisTimeSeconds = analysisTimeSeconds;
        return this;
    }

    /**
     * Get the rootFileSystems property: The number of root file systems found.
     * 
     * @return the rootFileSystems value.
     */
    public Long rootFileSystems() {
        return this.rootFileSystems;
    }

    /**
     * Set the rootFileSystems property: The number of root file systems found.
     * 
     * @param rootFileSystems the rootFileSystems value to set.
     * @return the FirmwareSummary object itself.
     */
    public FirmwareSummary withRootFileSystems(Long rootFileSystems) {
        this.rootFileSystems = rootFileSystems;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("summaryType", this.summaryType == null ? null : this.summaryType.toString());
        jsonWriter.writeNumberField("extractedSize", this.extractedSize);
        jsonWriter.writeNumberField("fileSize", this.fileSize);
        jsonWriter.writeNumberField("extractedFileCount", this.extractedFileCount);
        jsonWriter.writeNumberField("componentCount", this.componentCount);
        jsonWriter.writeNumberField("binaryCount", this.binaryCount);
        jsonWriter.writeNumberField("analysisTimeSeconds", this.analysisTimeSeconds);
        jsonWriter.writeNumberField("rootFileSystems", this.rootFileSystems);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of FirmwareSummary from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of FirmwareSummary if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the FirmwareSummary.
     */
    public static FirmwareSummary fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            FirmwareSummary deserializedFirmwareSummary = new FirmwareSummary();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("summaryType".equals(fieldName)) {
                    deserializedFirmwareSummary.summaryType = SummaryType.fromString(reader.getString());
                } else if ("extractedSize".equals(fieldName)) {
                    deserializedFirmwareSummary.extractedSize = reader.getNullable(JsonReader::getLong);
                } else if ("fileSize".equals(fieldName)) {
                    deserializedFirmwareSummary.fileSize = reader.getNullable(JsonReader::getLong);
                } else if ("extractedFileCount".equals(fieldName)) {
                    deserializedFirmwareSummary.extractedFileCount = reader.getNullable(JsonReader::getLong);
                } else if ("componentCount".equals(fieldName)) {
                    deserializedFirmwareSummary.componentCount = reader.getNullable(JsonReader::getLong);
                } else if ("binaryCount".equals(fieldName)) {
                    deserializedFirmwareSummary.binaryCount = reader.getNullable(JsonReader::getLong);
                } else if ("analysisTimeSeconds".equals(fieldName)) {
                    deserializedFirmwareSummary.analysisTimeSeconds = reader.getNullable(JsonReader::getLong);
                } else if ("rootFileSystems".equals(fieldName)) {
                    deserializedFirmwareSummary.rootFileSystems = reader.getNullable(JsonReader::getLong);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedFirmwareSummary;
        });
    }
}
