// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.servicebus.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.servicebus.models.AccessRights;
import java.io.IOException;
import java.util.List;

/**
 * AuthorizationRule properties.
 */
@Fluent
public final class SBAuthorizationRuleProperties implements JsonSerializable<SBAuthorizationRuleProperties> {
    /*
     * The rights associated with the rule.
     */
    private List<AccessRights> rights;

    /**
     * Creates an instance of SBAuthorizationRuleProperties class.
     */
    public SBAuthorizationRuleProperties() {
    }

    /**
     * Get the rights property: The rights associated with the rule.
     * 
     * @return the rights value.
     */
    public List<AccessRights> rights() {
        return this.rights;
    }

    /**
     * Set the rights property: The rights associated with the rule.
     * 
     * @param rights the rights value to set.
     * @return the SBAuthorizationRuleProperties object itself.
     */
    public SBAuthorizationRuleProperties withRights(List<AccessRights> rights) {
        this.rights = rights;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (rights() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property rights in model SBAuthorizationRuleProperties"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(SBAuthorizationRuleProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("rights", this.rights,
            (writer, element) -> writer.writeString(element == null ? null : element.toString()));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SBAuthorizationRuleProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SBAuthorizationRuleProperties if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SBAuthorizationRuleProperties.
     */
    public static SBAuthorizationRuleProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SBAuthorizationRuleProperties deserializedSBAuthorizationRuleProperties
                = new SBAuthorizationRuleProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("rights".equals(fieldName)) {
                    List<AccessRights> rights
                        = reader.readArray(reader1 -> AccessRights.fromString(reader1.getString()));
                    deserializedSBAuthorizationRuleProperties.rights = rights;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSBAuthorizationRuleProperties;
        });
    }
}
