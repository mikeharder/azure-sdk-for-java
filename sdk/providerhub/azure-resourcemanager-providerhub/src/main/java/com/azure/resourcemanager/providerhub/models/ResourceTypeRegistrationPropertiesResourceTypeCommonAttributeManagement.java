// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Resource type common attribute management.
 */
@Fluent
public final class ResourceTypeRegistrationPropertiesResourceTypeCommonAttributeManagement
    implements JsonSerializable<ResourceTypeRegistrationPropertiesResourceTypeCommonAttributeManagement> {
    /*
     * Common api versions merge mode.
     */
    private CommonApiVersionsMergeMode commonApiVersionsMergeMode;

    /**
     * Creates an instance of ResourceTypeRegistrationPropertiesResourceTypeCommonAttributeManagement class.
     */
    public ResourceTypeRegistrationPropertiesResourceTypeCommonAttributeManagement() {
    }

    /**
     * Get the commonApiVersionsMergeMode property: Common api versions merge mode.
     * 
     * @return the commonApiVersionsMergeMode value.
     */
    public CommonApiVersionsMergeMode commonApiVersionsMergeMode() {
        return this.commonApiVersionsMergeMode;
    }

    /**
     * Set the commonApiVersionsMergeMode property: Common api versions merge mode.
     * 
     * @param commonApiVersionsMergeMode the commonApiVersionsMergeMode value to set.
     * @return the ResourceTypeRegistrationPropertiesResourceTypeCommonAttributeManagement object itself.
     */
    public ResourceTypeRegistrationPropertiesResourceTypeCommonAttributeManagement
        withCommonApiVersionsMergeMode(CommonApiVersionsMergeMode commonApiVersionsMergeMode) {
        this.commonApiVersionsMergeMode = commonApiVersionsMergeMode;
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
        jsonWriter.writeStringField("commonApiVersionsMergeMode",
            this.commonApiVersionsMergeMode == null ? null : this.commonApiVersionsMergeMode.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ResourceTypeRegistrationPropertiesResourceTypeCommonAttributeManagement from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ResourceTypeRegistrationPropertiesResourceTypeCommonAttributeManagement if the JsonReader
     * was pointing to an instance of it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the
     * ResourceTypeRegistrationPropertiesResourceTypeCommonAttributeManagement.
     */
    public static ResourceTypeRegistrationPropertiesResourceTypeCommonAttributeManagement
        fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ResourceTypeRegistrationPropertiesResourceTypeCommonAttributeManagement deserializedResourceTypeRegistrationPropertiesResourceTypeCommonAttributeManagement
                = new ResourceTypeRegistrationPropertiesResourceTypeCommonAttributeManagement();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("commonApiVersionsMergeMode".equals(fieldName)) {
                    deserializedResourceTypeRegistrationPropertiesResourceTypeCommonAttributeManagement.commonApiVersionsMergeMode
                        = CommonApiVersionsMergeMode.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedResourceTypeRegistrationPropertiesResourceTypeCommonAttributeManagement;
        });
    }
}
