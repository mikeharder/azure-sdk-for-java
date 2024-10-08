// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcompute.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Describes the Update properties of a Gateway Profile.
 */
@Fluent
public final class GatewayUpdateProperties implements JsonSerializable<GatewayUpdateProperties> {
    /*
     * Specifies the list of features that are enabled for this Gateway.
     */
    private List<String> allowedFeatures;

    /**
     * Creates an instance of GatewayUpdateProperties class.
     */
    public GatewayUpdateProperties() {
    }

    /**
     * Get the allowedFeatures property: Specifies the list of features that are enabled for this Gateway.
     * 
     * @return the allowedFeatures value.
     */
    public List<String> allowedFeatures() {
        return this.allowedFeatures;
    }

    /**
     * Set the allowedFeatures property: Specifies the list of features that are enabled for this Gateway.
     * 
     * @param allowedFeatures the allowedFeatures value to set.
     * @return the GatewayUpdateProperties object itself.
     */
    public GatewayUpdateProperties withAllowedFeatures(List<String> allowedFeatures) {
        this.allowedFeatures = allowedFeatures;
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
        jsonWriter.writeArrayField("allowedFeatures", this.allowedFeatures,
            (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GatewayUpdateProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GatewayUpdateProperties if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the GatewayUpdateProperties.
     */
    public static GatewayUpdateProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            GatewayUpdateProperties deserializedGatewayUpdateProperties = new GatewayUpdateProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("allowedFeatures".equals(fieldName)) {
                    List<String> allowedFeatures = reader.readArray(reader1 -> reader1.getString());
                    deserializedGatewayUpdateProperties.allowedFeatures = allowedFeatures;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedGatewayUpdateProperties;
        });
    }
}
