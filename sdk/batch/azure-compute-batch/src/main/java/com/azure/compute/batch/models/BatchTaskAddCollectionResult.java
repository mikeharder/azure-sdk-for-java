// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.compute.batch.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The result of adding a collection of Tasks to a Job.
 */
@Immutable
public final class BatchTaskAddCollectionResult implements JsonSerializable<BatchTaskAddCollectionResult> {

    /*
     * The results of the add Task collection operation.
     */
    @Generated
    private List<BatchTaskAddResult> value;

    /**
     * Creates an instance of BatchTaskAddCollectionResult class.
     */
    @Generated
    private BatchTaskAddCollectionResult() {
    }

    /**
     * Get the value property: The results of the add Task collection operation.
     *
     * @return the value value.
     */
    @Generated
    public List<BatchTaskAddResult> getValue() {
        return this.value;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("value", this.value, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of BatchTaskAddCollectionResult from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of BatchTaskAddCollectionResult if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the BatchTaskAddCollectionResult.
     */
    @Generated
    public static BatchTaskAddCollectionResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            BatchTaskAddCollectionResult deserializedBatchTaskAddCollectionResult = new BatchTaskAddCollectionResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("value".equals(fieldName)) {
                    List<BatchTaskAddResult> value = reader.readArray(reader1 -> BatchTaskAddResult.fromJson(reader1));
                    deserializedBatchTaskAddCollectionResult.value = value;
                } else {
                    reader.skipChildren();
                }
            }
            return deserializedBatchTaskAddCollectionResult;
        });
    }
}
