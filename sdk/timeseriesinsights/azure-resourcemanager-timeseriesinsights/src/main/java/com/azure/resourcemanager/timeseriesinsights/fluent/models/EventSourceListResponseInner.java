// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.timeseriesinsights.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The response of the List EventSources operation.
 */
@Fluent
public final class EventSourceListResponseInner implements JsonSerializable<EventSourceListResponseInner> {
    /*
     * Result of the List EventSources operation.
     */
    private List<EventSourceResourceInner> value;

    /**
     * Creates an instance of EventSourceListResponseInner class.
     */
    public EventSourceListResponseInner() {
    }

    /**
     * Get the value property: Result of the List EventSources operation.
     * 
     * @return the value value.
     */
    public List<EventSourceResourceInner> value() {
        return this.value;
    }

    /**
     * Set the value property: Result of the List EventSources operation.
     * 
     * @param value the value value to set.
     * @return the EventSourceListResponseInner object itself.
     */
    public EventSourceListResponseInner withValue(List<EventSourceResourceInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("value", this.value, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of EventSourceListResponseInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of EventSourceListResponseInner if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the EventSourceListResponseInner.
     */
    public static EventSourceListResponseInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            EventSourceListResponseInner deserializedEventSourceListResponseInner = new EventSourceListResponseInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<EventSourceResourceInner> value
                        = reader.readArray(reader1 -> EventSourceResourceInner.fromJson(reader1));
                    deserializedEventSourceListResponseInner.value = value;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedEventSourceListResponseInner;
        });
    }
}
