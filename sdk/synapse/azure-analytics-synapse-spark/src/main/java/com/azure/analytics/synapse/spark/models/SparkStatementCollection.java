// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.spark.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The SparkStatementCollection model.
 */
@Fluent
public final class SparkStatementCollection implements JsonSerializable<SparkStatementCollection> {
    /*
     * The total_statements property.
     */
    @Generated
    private int total;

    /*
     * The statements property.
     */
    @Generated
    private List<SparkStatement> statements;

    /**
     * Creates an instance of SparkStatementCollection class.
     */
    @Generated
    public SparkStatementCollection() {
    }

    /**
     * Get the total property: The total_statements property.
     * 
     * @return the total value.
     */
    @Generated
    public int getTotal() {
        return this.total;
    }

    /**
     * Set the total property: The total_statements property.
     * 
     * @param total the total value to set.
     * @return the SparkStatementCollection object itself.
     */
    @Generated
    public SparkStatementCollection setTotal(int total) {
        this.total = total;
        return this;
    }

    /**
     * Get the statements property: The statements property.
     * 
     * @return the statements value.
     */
    @Generated
    public List<SparkStatement> getStatements() {
        return this.statements;
    }

    /**
     * Set the statements property: The statements property.
     * 
     * @param statements the statements value to set.
     * @return the SparkStatementCollection object itself.
     */
    @Generated
    public SparkStatementCollection setStatements(List<SparkStatement> statements) {
        this.statements = statements;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeIntField("total_statements", this.total);
        jsonWriter.writeArrayField("statements", this.statements, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SparkStatementCollection from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SparkStatementCollection if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SparkStatementCollection.
     */
    @Generated
    public static SparkStatementCollection fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SparkStatementCollection deserializedSparkStatementCollection = new SparkStatementCollection();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("total_statements".equals(fieldName)) {
                    deserializedSparkStatementCollection.total = reader.getInt();
                } else if ("statements".equals(fieldName)) {
                    List<SparkStatement> statements = reader.readArray(reader1 -> SparkStatement.fromJson(reader1));
                    deserializedSparkStatementCollection.statements = statements;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSparkStatementCollection;
        });
    }
}
