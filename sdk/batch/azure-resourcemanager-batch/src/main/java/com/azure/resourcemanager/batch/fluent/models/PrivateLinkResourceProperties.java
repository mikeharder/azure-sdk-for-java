// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.batch.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Private link resource properties.
 */
@Immutable
public final class PrivateLinkResourceProperties implements JsonSerializable<PrivateLinkResourceProperties> {
    /*
     * The group id is used to establish the private link connection.
     */
    private String groupId;

    /*
     * The list of required members that are used to establish the private link connection.
     */
    private List<String> requiredMembers;

    /*
     * The list of required zone names for the private DNS resource name
     */
    private List<String> requiredZoneNames;

    /**
     * Creates an instance of PrivateLinkResourceProperties class.
     */
    public PrivateLinkResourceProperties() {
    }

    /**
     * Get the groupId property: The group id is used to establish the private link connection.
     * 
     * @return the groupId value.
     */
    public String groupId() {
        return this.groupId;
    }

    /**
     * Get the requiredMembers property: The list of required members that are used to establish the private link
     * connection.
     * 
     * @return the requiredMembers value.
     */
    public List<String> requiredMembers() {
        return this.requiredMembers;
    }

    /**
     * Get the requiredZoneNames property: The list of required zone names for the private DNS resource name.
     * 
     * @return the requiredZoneNames value.
     */
    public List<String> requiredZoneNames() {
        return this.requiredZoneNames;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PrivateLinkResourceProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PrivateLinkResourceProperties if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the PrivateLinkResourceProperties.
     */
    public static PrivateLinkResourceProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PrivateLinkResourceProperties deserializedPrivateLinkResourceProperties
                = new PrivateLinkResourceProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("groupId".equals(fieldName)) {
                    deserializedPrivateLinkResourceProperties.groupId = reader.getString();
                } else if ("requiredMembers".equals(fieldName)) {
                    List<String> requiredMembers = reader.readArray(reader1 -> reader1.getString());
                    deserializedPrivateLinkResourceProperties.requiredMembers = requiredMembers;
                } else if ("requiredZoneNames".equals(fieldName)) {
                    List<String> requiredZoneNames = reader.readArray(reader1 -> reader1.getString());
                    deserializedPrivateLinkResourceProperties.requiredZoneNames = requiredZoneNames;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedPrivateLinkResourceProperties;
        });
    }
}
