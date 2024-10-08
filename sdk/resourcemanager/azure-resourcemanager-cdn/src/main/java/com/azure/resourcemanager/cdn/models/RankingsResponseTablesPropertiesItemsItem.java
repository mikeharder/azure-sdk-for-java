// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cdn.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The RankingsResponseTablesPropertiesItemsItem model.
 */
@Fluent
public final class RankingsResponseTablesPropertiesItemsItem
    implements JsonSerializable<RankingsResponseTablesPropertiesItemsItem> {
    /*
     * The name property.
     */
    private String name;

    /*
     * The metrics property.
     */
    private List<RankingsResponseTablesPropertiesItemsMetricsItem> metrics;

    /**
     * Creates an instance of RankingsResponseTablesPropertiesItemsItem class.
     */
    public RankingsResponseTablesPropertiesItemsItem() {
    }

    /**
     * Get the name property: The name property.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: The name property.
     * 
     * @param name the name value to set.
     * @return the RankingsResponseTablesPropertiesItemsItem object itself.
     */
    public RankingsResponseTablesPropertiesItemsItem withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the metrics property: The metrics property.
     * 
     * @return the metrics value.
     */
    public List<RankingsResponseTablesPropertiesItemsMetricsItem> metrics() {
        return this.metrics;
    }

    /**
     * Set the metrics property: The metrics property.
     * 
     * @param metrics the metrics value to set.
     * @return the RankingsResponseTablesPropertiesItemsItem object itself.
     */
    public RankingsResponseTablesPropertiesItemsItem
        withMetrics(List<RankingsResponseTablesPropertiesItemsMetricsItem> metrics) {
        this.metrics = metrics;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (metrics() != null) {
            metrics().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeArrayField("metrics", this.metrics, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RankingsResponseTablesPropertiesItemsItem from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RankingsResponseTablesPropertiesItemsItem if the JsonReader was pointing to an instance of
     * it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the RankingsResponseTablesPropertiesItemsItem.
     */
    public static RankingsResponseTablesPropertiesItemsItem fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RankingsResponseTablesPropertiesItemsItem deserializedRankingsResponseTablesPropertiesItemsItem
                = new RankingsResponseTablesPropertiesItemsItem();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedRankingsResponseTablesPropertiesItemsItem.name = reader.getString();
                } else if ("metrics".equals(fieldName)) {
                    List<RankingsResponseTablesPropertiesItemsMetricsItem> metrics = reader
                        .readArray(reader1 -> RankingsResponseTablesPropertiesItemsMetricsItem.fromJson(reader1));
                    deserializedRankingsResponseTablesPropertiesItemsItem.metrics = metrics;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRankingsResponseTablesPropertiesItemsItem;
        });
    }
}
