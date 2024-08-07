// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.dataprotection.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * ValidateForBackupRequest
 * 
 * Validate for backup request.
 */
@Fluent
public final class ValidateForBackupRequest implements JsonSerializable<ValidateForBackupRequest> {
    /*
     * Backup Instance
     */
    private BackupInstance backupInstance;

    /**
     * Creates an instance of ValidateForBackupRequest class.
     */
    public ValidateForBackupRequest() {
    }

    /**
     * Get the backupInstance property: Backup Instance.
     * 
     * @return the backupInstance value.
     */
    public BackupInstance backupInstance() {
        return this.backupInstance;
    }

    /**
     * Set the backupInstance property: Backup Instance.
     * 
     * @param backupInstance the backupInstance value to set.
     * @return the ValidateForBackupRequest object itself.
     */
    public ValidateForBackupRequest withBackupInstance(BackupInstance backupInstance) {
        this.backupInstance = backupInstance;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (backupInstance() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property backupInstance in model ValidateForBackupRequest"));
        } else {
            backupInstance().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ValidateForBackupRequest.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("backupInstance", this.backupInstance);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ValidateForBackupRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ValidateForBackupRequest if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ValidateForBackupRequest.
     */
    public static ValidateForBackupRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ValidateForBackupRequest deserializedValidateForBackupRequest = new ValidateForBackupRequest();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("backupInstance".equals(fieldName)) {
                    deserializedValidateForBackupRequest.backupInstance = BackupInstance.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedValidateForBackupRequest;
        });
    }
}
