// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerinstance.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The instance view of the container instance. Only valid in response.
 */
@Immutable
public final class ContainerPropertiesInstanceView implements JsonSerializable<ContainerPropertiesInstanceView> {
    /*
     * The number of times that the container instance has been restarted.
     */
    private Integer restartCount;

    /*
     * Current container instance state.
     */
    private ContainerState currentState;

    /*
     * Previous container instance state.
     */
    private ContainerState previousState;

    /*
     * The events of the container instance.
     */
    private List<Event> events;

    /**
     * Creates an instance of ContainerPropertiesInstanceView class.
     */
    public ContainerPropertiesInstanceView() {
    }

    /**
     * Get the restartCount property: The number of times that the container instance has been restarted.
     * 
     * @return the restartCount value.
     */
    public Integer restartCount() {
        return this.restartCount;
    }

    /**
     * Get the currentState property: Current container instance state.
     * 
     * @return the currentState value.
     */
    public ContainerState currentState() {
        return this.currentState;
    }

    /**
     * Get the previousState property: Previous container instance state.
     * 
     * @return the previousState value.
     */
    public ContainerState previousState() {
        return this.previousState;
    }

    /**
     * Get the events property: The events of the container instance.
     * 
     * @return the events value.
     */
    public List<Event> events() {
        return this.events;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (currentState() != null) {
            currentState().validate();
        }
        if (previousState() != null) {
            previousState().validate();
        }
        if (events() != null) {
            events().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ContainerPropertiesInstanceView from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ContainerPropertiesInstanceView if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ContainerPropertiesInstanceView.
     */
    public static ContainerPropertiesInstanceView fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ContainerPropertiesInstanceView deserializedContainerPropertiesInstanceView
                = new ContainerPropertiesInstanceView();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("restartCount".equals(fieldName)) {
                    deserializedContainerPropertiesInstanceView.restartCount = reader.getNullable(JsonReader::getInt);
                } else if ("currentState".equals(fieldName)) {
                    deserializedContainerPropertiesInstanceView.currentState = ContainerState.fromJson(reader);
                } else if ("previousState".equals(fieldName)) {
                    deserializedContainerPropertiesInstanceView.previousState = ContainerState.fromJson(reader);
                } else if ("events".equals(fieldName)) {
                    List<Event> events = reader.readArray(reader1 -> Event.fromJson(reader1));
                    deserializedContainerPropertiesInstanceView.events = events;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedContainerPropertiesInstanceView;
        });
    }
}
