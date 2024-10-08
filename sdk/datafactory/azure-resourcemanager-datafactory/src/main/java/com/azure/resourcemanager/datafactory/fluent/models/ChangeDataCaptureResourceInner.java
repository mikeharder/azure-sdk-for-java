// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.SubResource;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.datafactory.models.ChangeDataCaptureFolder;
import com.azure.resourcemanager.datafactory.models.MapperPolicy;
import com.azure.resourcemanager.datafactory.models.MapperSourceConnectionsInfo;
import com.azure.resourcemanager.datafactory.models.MapperTargetConnectionsInfo;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Change data capture resource type.
 */
@Fluent
public final class ChangeDataCaptureResourceInner extends SubResource {
    /*
     * Properties of the change data capture.
     */
    private ChangeDataCapture innerProperties = new ChangeDataCapture();

    /*
     * The resource name.
     */
    private String name;

    /*
     * The resource type.
     */
    private String type;

    /*
     * Etag identifies change in the resource.
     */
    private String etag;

    /*
     * Change data capture resource type.
     */
    private Map<String, Object> additionalProperties;

    /**
     * Creates an instance of ChangeDataCaptureResourceInner class.
     */
    public ChangeDataCaptureResourceInner() {
    }

    /**
     * Get the innerProperties property: Properties of the change data capture.
     * 
     * @return the innerProperties value.
     */
    private ChangeDataCapture innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the name property: The resource name.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Get the type property: The resource type.
     * 
     * @return the type value.
     */
    public String type() {
        return this.type;
    }

    /**
     * Get the etag property: Etag identifies change in the resource.
     * 
     * @return the etag value.
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Get the additionalProperties property: Change data capture resource type.
     * 
     * @return the additionalProperties value.
     */
    public Map<String, Object> additionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: Change data capture resource type.
     * 
     * @param additionalProperties the additionalProperties value to set.
     * @return the ChangeDataCaptureResourceInner object itself.
     */
    public ChangeDataCaptureResourceInner withAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChangeDataCaptureResourceInner withId(String id) {
        super.withId(id);
        return this;
    }

    /**
     * Get the folder property: The folder that this CDC is in. If not specified, CDC will appear at the root level.
     * 
     * @return the folder value.
     */
    public ChangeDataCaptureFolder folder() {
        return this.innerProperties() == null ? null : this.innerProperties().folder();
    }

    /**
     * Set the folder property: The folder that this CDC is in. If not specified, CDC will appear at the root level.
     * 
     * @param folder the folder value to set.
     * @return the ChangeDataCaptureResourceInner object itself.
     */
    public ChangeDataCaptureResourceInner withFolder(ChangeDataCaptureFolder folder) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ChangeDataCapture();
        }
        this.innerProperties().withFolder(folder);
        return this;
    }

    /**
     * Get the description property: The description of the change data capture.
     * 
     * @return the description value.
     */
    public String description() {
        return this.innerProperties() == null ? null : this.innerProperties().description();
    }

    /**
     * Set the description property: The description of the change data capture.
     * 
     * @param description the description value to set.
     * @return the ChangeDataCaptureResourceInner object itself.
     */
    public ChangeDataCaptureResourceInner withDescription(String description) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ChangeDataCapture();
        }
        this.innerProperties().withDescription(description);
        return this;
    }

    /**
     * Get the sourceConnectionsInfo property: List of sources connections that can be used as sources in the CDC.
     * 
     * @return the sourceConnectionsInfo value.
     */
    public List<MapperSourceConnectionsInfo> sourceConnectionsInfo() {
        return this.innerProperties() == null ? null : this.innerProperties().sourceConnectionsInfo();
    }

    /**
     * Set the sourceConnectionsInfo property: List of sources connections that can be used as sources in the CDC.
     * 
     * @param sourceConnectionsInfo the sourceConnectionsInfo value to set.
     * @return the ChangeDataCaptureResourceInner object itself.
     */
    public ChangeDataCaptureResourceInner
        withSourceConnectionsInfo(List<MapperSourceConnectionsInfo> sourceConnectionsInfo) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ChangeDataCapture();
        }
        this.innerProperties().withSourceConnectionsInfo(sourceConnectionsInfo);
        return this;
    }

    /**
     * Get the targetConnectionsInfo property: List of target connections that can be used as sources in the CDC.
     * 
     * @return the targetConnectionsInfo value.
     */
    public List<MapperTargetConnectionsInfo> targetConnectionsInfo() {
        return this.innerProperties() == null ? null : this.innerProperties().targetConnectionsInfo();
    }

    /**
     * Set the targetConnectionsInfo property: List of target connections that can be used as sources in the CDC.
     * 
     * @param targetConnectionsInfo the targetConnectionsInfo value to set.
     * @return the ChangeDataCaptureResourceInner object itself.
     */
    public ChangeDataCaptureResourceInner
        withTargetConnectionsInfo(List<MapperTargetConnectionsInfo> targetConnectionsInfo) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ChangeDataCapture();
        }
        this.innerProperties().withTargetConnectionsInfo(targetConnectionsInfo);
        return this;
    }

    /**
     * Get the policy property: CDC policy.
     * 
     * @return the policy value.
     */
    public MapperPolicy policy() {
        return this.innerProperties() == null ? null : this.innerProperties().policy();
    }

    /**
     * Set the policy property: CDC policy.
     * 
     * @param policy the policy value to set.
     * @return the ChangeDataCaptureResourceInner object itself.
     */
    public ChangeDataCaptureResourceInner withPolicy(MapperPolicy policy) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ChangeDataCapture();
        }
        this.innerProperties().withPolicy(policy);
        return this;
    }

    /**
     * Get the allowVNetOverride property: A boolean to determine if the vnet configuration needs to be overwritten.
     * 
     * @return the allowVNetOverride value.
     */
    public Boolean allowVNetOverride() {
        return this.innerProperties() == null ? null : this.innerProperties().allowVNetOverride();
    }

    /**
     * Set the allowVNetOverride property: A boolean to determine if the vnet configuration needs to be overwritten.
     * 
     * @param allowVNetOverride the allowVNetOverride value to set.
     * @return the ChangeDataCaptureResourceInner object itself.
     */
    public ChangeDataCaptureResourceInner withAllowVNetOverride(Boolean allowVNetOverride) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ChangeDataCapture();
        }
        this.innerProperties().withAllowVNetOverride(allowVNetOverride);
        return this;
    }

    /**
     * Get the status property: Status of the CDC as to if it is running or stopped.
     * 
     * @return the status value.
     */
    public String status() {
        return this.innerProperties() == null ? null : this.innerProperties().status();
    }

    /**
     * Set the status property: Status of the CDC as to if it is running or stopped.
     * 
     * @param status the status value to set.
     * @return the ChangeDataCaptureResourceInner object itself.
     */
    public ChangeDataCaptureResourceInner withStatus(String status) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ChangeDataCapture();
        }
        this.innerProperties().withStatus(status);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property innerProperties in model ChangeDataCaptureResourceInner"));
        } else {
            innerProperties().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ChangeDataCaptureResourceInner.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("id", id());
        jsonWriter.writeJsonField("properties", this.innerProperties);
        if (additionalProperties != null) {
            for (Map.Entry<String, Object> additionalProperty : additionalProperties.entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ChangeDataCaptureResourceInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ChangeDataCaptureResourceInner if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ChangeDataCaptureResourceInner.
     */
    public static ChangeDataCaptureResourceInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ChangeDataCaptureResourceInner deserializedChangeDataCaptureResourceInner
                = new ChangeDataCaptureResourceInner();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedChangeDataCaptureResourceInner.withId(reader.getString());
                } else if ("properties".equals(fieldName)) {
                    deserializedChangeDataCaptureResourceInner.innerProperties = ChangeDataCapture.fromJson(reader);
                } else if ("name".equals(fieldName)) {
                    deserializedChangeDataCaptureResourceInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedChangeDataCaptureResourceInner.type = reader.getString();
                } else if ("etag".equals(fieldName)) {
                    deserializedChangeDataCaptureResourceInner.etag = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedChangeDataCaptureResourceInner.additionalProperties = additionalProperties;

            return deserializedChangeDataCaptureResourceInner;
        });
    }
}
