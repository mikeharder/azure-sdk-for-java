// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Configuration to bind a Dapr Component to a dev ContainerApp Service.
 */
@Fluent
public final class DaprComponentServiceBinding implements JsonSerializable<DaprComponentServiceBinding> {
    /*
     * Name of the service bind
     */
    private String name;

    /*
     * Resource id of the target service
     */
    private String serviceId;

    /*
     * Service bind metadata
     */
    private DaprServiceBindMetadata metadata;

    /**
     * Creates an instance of DaprComponentServiceBinding class.
     */
    public DaprComponentServiceBinding() {
    }

    /**
     * Get the name property: Name of the service bind.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Name of the service bind.
     * 
     * @param name the name value to set.
     * @return the DaprComponentServiceBinding object itself.
     */
    public DaprComponentServiceBinding withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the serviceId property: Resource id of the target service.
     * 
     * @return the serviceId value.
     */
    public String serviceId() {
        return this.serviceId;
    }

    /**
     * Set the serviceId property: Resource id of the target service.
     * 
     * @param serviceId the serviceId value to set.
     * @return the DaprComponentServiceBinding object itself.
     */
    public DaprComponentServiceBinding withServiceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    /**
     * Get the metadata property: Service bind metadata.
     * 
     * @return the metadata value.
     */
    public DaprServiceBindMetadata metadata() {
        return this.metadata;
    }

    /**
     * Set the metadata property: Service bind metadata.
     * 
     * @param metadata the metadata value to set.
     * @return the DaprComponentServiceBinding object itself.
     */
    public DaprComponentServiceBinding withMetadata(DaprServiceBindMetadata metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (metadata() != null) {
            metadata().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("serviceId", this.serviceId);
        jsonWriter.writeJsonField("metadata", this.metadata);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DaprComponentServiceBinding from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DaprComponentServiceBinding if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the DaprComponentServiceBinding.
     */
    public static DaprComponentServiceBinding fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DaprComponentServiceBinding deserializedDaprComponentServiceBinding = new DaprComponentServiceBinding();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedDaprComponentServiceBinding.name = reader.getString();
                } else if ("serviceId".equals(fieldName)) {
                    deserializedDaprComponentServiceBinding.serviceId = reader.getString();
                } else if ("metadata".equals(fieldName)) {
                    deserializedDaprComponentServiceBinding.metadata = DaprServiceBindMetadata.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDaprComponentServiceBinding;
        });
    }
}
