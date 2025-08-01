// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The CheckinManifestInfo model.
 */
@Fluent
public class CheckinManifestInfoInner implements JsonSerializable<CheckinManifestInfoInner> {
    /*
     * Whether the manifest is checked in.
     */
    private boolean isCheckedIn;

    /*
     * The status message.
     */
    private String statusMessage;

    /*
     * The pull request.
     */
    private String pullRequest;

    /*
     * The commit id.
     */
    private String commitId;

    /**
     * Creates an instance of CheckinManifestInfoInner class.
     */
    public CheckinManifestInfoInner() {
    }

    /**
     * Get the isCheckedIn property: Whether the manifest is checked in.
     * 
     * @return the isCheckedIn value.
     */
    public boolean isCheckedIn() {
        return this.isCheckedIn;
    }

    /**
     * Set the isCheckedIn property: Whether the manifest is checked in.
     * 
     * @param isCheckedIn the isCheckedIn value to set.
     * @return the CheckinManifestInfoInner object itself.
     */
    public CheckinManifestInfoInner withIsCheckedIn(boolean isCheckedIn) {
        this.isCheckedIn = isCheckedIn;
        return this;
    }

    /**
     * Get the statusMessage property: The status message.
     * 
     * @return the statusMessage value.
     */
    public String statusMessage() {
        return this.statusMessage;
    }

    /**
     * Set the statusMessage property: The status message.
     * 
     * @param statusMessage the statusMessage value to set.
     * @return the CheckinManifestInfoInner object itself.
     */
    public CheckinManifestInfoInner withStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
        return this;
    }

    /**
     * Get the pullRequest property: The pull request.
     * 
     * @return the pullRequest value.
     */
    public String pullRequest() {
        return this.pullRequest;
    }

    /**
     * Set the pullRequest property: The pull request.
     * 
     * @param pullRequest the pullRequest value to set.
     * @return the CheckinManifestInfoInner object itself.
     */
    public CheckinManifestInfoInner withPullRequest(String pullRequest) {
        this.pullRequest = pullRequest;
        return this;
    }

    /**
     * Get the commitId property: The commit id.
     * 
     * @return the commitId value.
     */
    public String commitId() {
        return this.commitId;
    }

    /**
     * Set the commitId property: The commit id.
     * 
     * @param commitId the commitId value to set.
     * @return the CheckinManifestInfoInner object itself.
     */
    public CheckinManifestInfoInner withCommitId(String commitId) {
        this.commitId = commitId;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (statusMessage() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property statusMessage in model CheckinManifestInfoInner"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(CheckinManifestInfoInner.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeBooleanField("isCheckedIn", this.isCheckedIn);
        jsonWriter.writeStringField("statusMessage", this.statusMessage);
        jsonWriter.writeStringField("pullRequest", this.pullRequest);
        jsonWriter.writeStringField("commitId", this.commitId);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CheckinManifestInfoInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CheckinManifestInfoInner if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the CheckinManifestInfoInner.
     */
    public static CheckinManifestInfoInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CheckinManifestInfoInner deserializedCheckinManifestInfoInner = new CheckinManifestInfoInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("isCheckedIn".equals(fieldName)) {
                    deserializedCheckinManifestInfoInner.isCheckedIn = reader.getBoolean();
                } else if ("statusMessage".equals(fieldName)) {
                    deserializedCheckinManifestInfoInner.statusMessage = reader.getString();
                } else if ("pullRequest".equals(fieldName)) {
                    deserializedCheckinManifestInfoInner.pullRequest = reader.getString();
                } else if ("commitId".equals(fieldName)) {
                    deserializedCheckinManifestInfoInner.commitId = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCheckinManifestInfoInner;
        });
    }
}
