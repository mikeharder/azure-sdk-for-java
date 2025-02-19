// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.deviceregistry.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The updatable properties of the AssetEndpointProfile.
 */
@Fluent
public final class AssetEndpointProfileUpdateProperties
    implements JsonSerializable<AssetEndpointProfileUpdateProperties> {
    /*
     * The local valid URI specifying the network address/DNS name of a southbound device. The scheme part of the
     * targetAddress URI specifies the type of the device. The additionalConfiguration field holds further connector
     * type specific configuration.
     */
    private String targetAddress;

    /*
     * Defines the configuration for the connector type that is being used with the endpoint profile.
     */
    private String endpointProfileType;

    /*
     * Defines the client authentication mechanism to the server.
     */
    private Authentication authentication;

    /*
     * Stringified JSON that contains connectivity type specific further configuration (e.g. OPC UA, Modbus, ONVIF).
     */
    private String additionalConfiguration;

    /**
     * Creates an instance of AssetEndpointProfileUpdateProperties class.
     */
    public AssetEndpointProfileUpdateProperties() {
    }

    /**
     * Get the targetAddress property: The local valid URI specifying the network address/DNS name of a southbound
     * device. The scheme part of the targetAddress URI specifies the type of the device. The additionalConfiguration
     * field holds further connector type specific configuration.
     * 
     * @return the targetAddress value.
     */
    public String targetAddress() {
        return this.targetAddress;
    }

    /**
     * Set the targetAddress property: The local valid URI specifying the network address/DNS name of a southbound
     * device. The scheme part of the targetAddress URI specifies the type of the device. The additionalConfiguration
     * field holds further connector type specific configuration.
     * 
     * @param targetAddress the targetAddress value to set.
     * @return the AssetEndpointProfileUpdateProperties object itself.
     */
    public AssetEndpointProfileUpdateProperties withTargetAddress(String targetAddress) {
        this.targetAddress = targetAddress;
        return this;
    }

    /**
     * Get the endpointProfileType property: Defines the configuration for the connector type that is being used with
     * the endpoint profile.
     * 
     * @return the endpointProfileType value.
     */
    public String endpointProfileType() {
        return this.endpointProfileType;
    }

    /**
     * Set the endpointProfileType property: Defines the configuration for the connector type that is being used with
     * the endpoint profile.
     * 
     * @param endpointProfileType the endpointProfileType value to set.
     * @return the AssetEndpointProfileUpdateProperties object itself.
     */
    public AssetEndpointProfileUpdateProperties withEndpointProfileType(String endpointProfileType) {
        this.endpointProfileType = endpointProfileType;
        return this;
    }

    /**
     * Get the authentication property: Defines the client authentication mechanism to the server.
     * 
     * @return the authentication value.
     */
    public Authentication authentication() {
        return this.authentication;
    }

    /**
     * Set the authentication property: Defines the client authentication mechanism to the server.
     * 
     * @param authentication the authentication value to set.
     * @return the AssetEndpointProfileUpdateProperties object itself.
     */
    public AssetEndpointProfileUpdateProperties withAuthentication(Authentication authentication) {
        this.authentication = authentication;
        return this;
    }

    /**
     * Get the additionalConfiguration property: Stringified JSON that contains connectivity type specific further
     * configuration (e.g. OPC UA, Modbus, ONVIF).
     * 
     * @return the additionalConfiguration value.
     */
    public String additionalConfiguration() {
        return this.additionalConfiguration;
    }

    /**
     * Set the additionalConfiguration property: Stringified JSON that contains connectivity type specific further
     * configuration (e.g. OPC UA, Modbus, ONVIF).
     * 
     * @param additionalConfiguration the additionalConfiguration value to set.
     * @return the AssetEndpointProfileUpdateProperties object itself.
     */
    public AssetEndpointProfileUpdateProperties withAdditionalConfiguration(String additionalConfiguration) {
        this.additionalConfiguration = additionalConfiguration;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (authentication() != null) {
            authentication().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("targetAddress", this.targetAddress);
        jsonWriter.writeStringField("endpointProfileType", this.endpointProfileType);
        jsonWriter.writeJsonField("authentication", this.authentication);
        jsonWriter.writeStringField("additionalConfiguration", this.additionalConfiguration);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AssetEndpointProfileUpdateProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AssetEndpointProfileUpdateProperties if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the AssetEndpointProfileUpdateProperties.
     */
    public static AssetEndpointProfileUpdateProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AssetEndpointProfileUpdateProperties deserializedAssetEndpointProfileUpdateProperties
                = new AssetEndpointProfileUpdateProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("targetAddress".equals(fieldName)) {
                    deserializedAssetEndpointProfileUpdateProperties.targetAddress = reader.getString();
                } else if ("endpointProfileType".equals(fieldName)) {
                    deserializedAssetEndpointProfileUpdateProperties.endpointProfileType = reader.getString();
                } else if ("authentication".equals(fieldName)) {
                    deserializedAssetEndpointProfileUpdateProperties.authentication = Authentication.fromJson(reader);
                } else if ("additionalConfiguration".equals(fieldName)) {
                    deserializedAssetEndpointProfileUpdateProperties.additionalConfiguration = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAssetEndpointProfileUpdateProperties;
        });
    }
}
