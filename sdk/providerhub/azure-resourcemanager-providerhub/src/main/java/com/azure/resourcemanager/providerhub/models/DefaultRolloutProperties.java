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
 * The DefaultRolloutProperties model.
 */
@Fluent
public final class DefaultRolloutProperties implements JsonSerializable<DefaultRolloutProperties> {
    /*
     * The provisioned state of the resource.
     */
    private ProvisioningState provisioningState;

    /*
     * The default rollout specification.
     */
    private DefaultRolloutPropertiesSpecification specification;

    /*
     * The default rollout status.
     */
    private DefaultRolloutPropertiesStatus status;

    /**
     * Creates an instance of DefaultRolloutProperties class.
     */
    public DefaultRolloutProperties() {
    }

    /**
     * Get the provisioningState property: The provisioned state of the resource.
     * 
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the specification property: The default rollout specification.
     * 
     * @return the specification value.
     */
    public DefaultRolloutPropertiesSpecification specification() {
        return this.specification;
    }

    /**
     * Set the specification property: The default rollout specification.
     * 
     * @param specification the specification value to set.
     * @return the DefaultRolloutProperties object itself.
     */
    public DefaultRolloutProperties withSpecification(DefaultRolloutPropertiesSpecification specification) {
        this.specification = specification;
        return this;
    }

    /**
     * Get the status property: The default rollout status.
     * 
     * @return the status value.
     */
    public DefaultRolloutPropertiesStatus status() {
        return this.status;
    }

    /**
     * Set the status property: The default rollout status.
     * 
     * @param status the status value to set.
     * @return the DefaultRolloutProperties object itself.
     */
    public DefaultRolloutProperties withStatus(DefaultRolloutPropertiesStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (specification() != null) {
            specification().validate();
        }
        if (status() != null) {
            status().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("specification", this.specification);
        jsonWriter.writeJsonField("status", this.status);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DefaultRolloutProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DefaultRolloutProperties if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the DefaultRolloutProperties.
     */
    public static DefaultRolloutProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DefaultRolloutProperties deserializedDefaultRolloutProperties = new DefaultRolloutProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("provisioningState".equals(fieldName)) {
                    deserializedDefaultRolloutProperties.provisioningState
                        = ProvisioningState.fromString(reader.getString());
                } else if ("specification".equals(fieldName)) {
                    deserializedDefaultRolloutProperties.specification
                        = DefaultRolloutPropertiesSpecification.fromJson(reader);
                } else if ("status".equals(fieldName)) {
                    deserializedDefaultRolloutProperties.status = DefaultRolloutPropertiesStatus.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDefaultRolloutProperties;
        });
    }
}
