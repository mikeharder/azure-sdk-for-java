// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The DatabricksSchema model.
 */
@Fluent
public class DatabricksSchema implements JsonSerializable<DatabricksSchema> {
    /*
     * Properties of Databricks
     */
    private DatabricksProperties properties;

    /**
     * Creates an instance of DatabricksSchema class.
     */
    public DatabricksSchema() {
    }

    /**
     * Get the properties property: Properties of Databricks.
     * 
     * @return the properties value.
     */
    public DatabricksProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties property: Properties of Databricks.
     * 
     * @param properties the properties value to set.
     * @return the DatabricksSchema object itself.
     */
    public DatabricksSchema withProperties(DatabricksProperties properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (properties() != null) {
            properties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("properties", this.properties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DatabricksSchema from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DatabricksSchema if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the DatabricksSchema.
     */
    public static DatabricksSchema fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DatabricksSchema deserializedDatabricksSchema = new DatabricksSchema();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("properties".equals(fieldName)) {
                    deserializedDatabricksSchema.properties = DatabricksProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDatabricksSchema;
        });
    }
}
