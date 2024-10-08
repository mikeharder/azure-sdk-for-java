// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Properties specific to credit line check failure.
 */
@Fluent
public final class ExtendedStatusInfoProperties implements JsonSerializable<ExtendedStatusInfoProperties> {
    /*
     * The subscription that has failed credit line check.
     */
    private String subscriptionId;

    /**
     * Creates an instance of ExtendedStatusInfoProperties class.
     */
    public ExtendedStatusInfoProperties() {
    }

    /**
     * Get the subscriptionId property: The subscription that has failed credit line check.
     * 
     * @return the subscriptionId value.
     */
    public String subscriptionId() {
        return this.subscriptionId;
    }

    /**
     * Set the subscriptionId property: The subscription that has failed credit line check.
     * 
     * @param subscriptionId the subscriptionId value to set.
     * @return the ExtendedStatusInfoProperties object itself.
     */
    public ExtendedStatusInfoProperties withSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
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
        jsonWriter.writeStringField("subscriptionId", this.subscriptionId);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ExtendedStatusInfoProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ExtendedStatusInfoProperties if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ExtendedStatusInfoProperties.
     */
    public static ExtendedStatusInfoProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ExtendedStatusInfoProperties deserializedExtendedStatusInfoProperties = new ExtendedStatusInfoProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("subscriptionId".equals(fieldName)) {
                    deserializedExtendedStatusInfoProperties.subscriptionId = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedExtendedStatusInfoProperties;
        });
    }
}
