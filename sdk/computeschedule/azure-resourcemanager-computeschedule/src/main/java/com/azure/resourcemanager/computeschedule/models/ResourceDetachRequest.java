// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.computeschedule.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Request model to detach a list of scheduled action resources.
 */
@Fluent
public final class ResourceDetachRequest implements JsonSerializable<ResourceDetachRequest> {
    /*
     * List of resources to be detached
     */
    private List<String> resources;

    /**
     * Creates an instance of ResourceDetachRequest class.
     */
    public ResourceDetachRequest() {
    }

    /**
     * Get the resources property: List of resources to be detached.
     * 
     * @return the resources value.
     */
    public List<String> resources() {
        return this.resources;
    }

    /**
     * Set the resources property: List of resources to be detached.
     * 
     * @param resources the resources value to set.
     * @return the ResourceDetachRequest object itself.
     */
    public ResourceDetachRequest withResources(List<String> resources) {
        this.resources = resources;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (resources() == null) {
            throw LOGGER.atError()
                .log(
                    new IllegalArgumentException("Missing required property resources in model ResourceDetachRequest"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ResourceDetachRequest.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("resources", this.resources, (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ResourceDetachRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ResourceDetachRequest if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ResourceDetachRequest.
     */
    public static ResourceDetachRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ResourceDetachRequest deserializedResourceDetachRequest = new ResourceDetachRequest();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("resources".equals(fieldName)) {
                    List<String> resources = reader.readArray(reader1 -> reader1.getString());
                    deserializedResourceDetachRequest.resources = resources;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedResourceDetachRequest;
        });
    }
}
