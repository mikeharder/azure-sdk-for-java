// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridnetwork.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Vhd mapping rule profile.
 */
@Fluent
public final class VhdImageMappingRuleProfile implements JsonSerializable<VhdImageMappingRuleProfile> {
    /*
     * List of values.
     */
    private String userConfiguration;

    /**
     * Creates an instance of VhdImageMappingRuleProfile class.
     */
    public VhdImageMappingRuleProfile() {
    }

    /**
     * Get the userConfiguration property: List of values.
     * 
     * @return the userConfiguration value.
     */
    public String userConfiguration() {
        return this.userConfiguration;
    }

    /**
     * Set the userConfiguration property: List of values.
     * 
     * @param userConfiguration the userConfiguration value to set.
     * @return the VhdImageMappingRuleProfile object itself.
     */
    public VhdImageMappingRuleProfile withUserConfiguration(String userConfiguration) {
        this.userConfiguration = userConfiguration;
        return this;
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
        jsonWriter.writeStringField("userConfiguration", this.userConfiguration);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of VhdImageMappingRuleProfile from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of VhdImageMappingRuleProfile if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the VhdImageMappingRuleProfile.
     */
    public static VhdImageMappingRuleProfile fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            VhdImageMappingRuleProfile deserializedVhdImageMappingRuleProfile = new VhdImageMappingRuleProfile();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("userConfiguration".equals(fieldName)) {
                    deserializedVhdImageMappingRuleProfile.userConfiguration = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedVhdImageMappingRuleProfile;
        });
    }
}
