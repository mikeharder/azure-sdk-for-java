// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.kusto.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * A cluster migrate request.
 */
@Fluent
public final class ClusterMigrateRequest implements JsonSerializable<ClusterMigrateRequest> {
    /*
     * Resource ID of the destination cluster or kusto pool.
     */
    private String clusterResourceId;

    /**
     * Creates an instance of ClusterMigrateRequest class.
     */
    public ClusterMigrateRequest() {
    }

    /**
     * Get the clusterResourceId property: Resource ID of the destination cluster or kusto pool.
     * 
     * @return the clusterResourceId value.
     */
    public String clusterResourceId() {
        return this.clusterResourceId;
    }

    /**
     * Set the clusterResourceId property: Resource ID of the destination cluster or kusto pool.
     * 
     * @param clusterResourceId the clusterResourceId value to set.
     * @return the ClusterMigrateRequest object itself.
     */
    public ClusterMigrateRequest withClusterResourceId(String clusterResourceId) {
        this.clusterResourceId = clusterResourceId;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (clusterResourceId() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property clusterResourceId in model ClusterMigrateRequest"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ClusterMigrateRequest.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("clusterResourceId", this.clusterResourceId);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ClusterMigrateRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ClusterMigrateRequest if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ClusterMigrateRequest.
     */
    public static ClusterMigrateRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ClusterMigrateRequest deserializedClusterMigrateRequest = new ClusterMigrateRequest();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("clusterResourceId".equals(fieldName)) {
                    deserializedClusterMigrateRequest.clusterResourceId = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedClusterMigrateRequest;
        });
    }
}
