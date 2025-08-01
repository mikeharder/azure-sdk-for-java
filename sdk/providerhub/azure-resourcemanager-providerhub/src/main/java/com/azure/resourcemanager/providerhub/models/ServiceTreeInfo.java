// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The ServiceTreeInfo model.
 */
@Fluent
public final class ServiceTreeInfo implements JsonSerializable<ServiceTreeInfo> {
    /*
     * The service id.
     */
    private String serviceId;

    /*
     * The component id.
     */
    private String componentId;

    /*
     * The readiness.
     */
    private Readiness readiness;

    /**
     * Creates an instance of ServiceTreeInfo class.
     */
    public ServiceTreeInfo() {
    }

    /**
     * Get the serviceId property: The service id.
     * 
     * @return the serviceId value.
     */
    public String serviceId() {
        return this.serviceId;
    }

    /**
     * Set the serviceId property: The service id.
     * 
     * @param serviceId the serviceId value to set.
     * @return the ServiceTreeInfo object itself.
     */
    public ServiceTreeInfo withServiceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    /**
     * Get the componentId property: The component id.
     * 
     * @return the componentId value.
     */
    public String componentId() {
        return this.componentId;
    }

    /**
     * Set the componentId property: The component id.
     * 
     * @param componentId the componentId value to set.
     * @return the ServiceTreeInfo object itself.
     */
    public ServiceTreeInfo withComponentId(String componentId) {
        this.componentId = componentId;
        return this;
    }

    /**
     * Get the readiness property: The readiness.
     * 
     * @return the readiness value.
     */
    public Readiness readiness() {
        return this.readiness;
    }

    /**
     * Set the readiness property: The readiness.
     * 
     * @param readiness the readiness value to set.
     * @return the ServiceTreeInfo object itself.
     */
    public ServiceTreeInfo withReadiness(Readiness readiness) {
        this.readiness = readiness;
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
        jsonWriter.writeStringField("serviceId", this.serviceId);
        jsonWriter.writeStringField("componentId", this.componentId);
        jsonWriter.writeStringField("readiness", this.readiness == null ? null : this.readiness.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ServiceTreeInfo from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ServiceTreeInfo if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ServiceTreeInfo.
     */
    public static ServiceTreeInfo fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ServiceTreeInfo deserializedServiceTreeInfo = new ServiceTreeInfo();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("serviceId".equals(fieldName)) {
                    deserializedServiceTreeInfo.serviceId = reader.getString();
                } else if ("componentId".equals(fieldName)) {
                    deserializedServiceTreeInfo.componentId = reader.getString();
                } else if ("readiness".equals(fieldName)) {
                    deserializedServiceTreeInfo.readiness = Readiness.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedServiceTreeInfo;
        });
    }
}
