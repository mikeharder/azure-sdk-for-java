// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.databricks.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.UUID;

/**
 * The Managed Identity details for storage account.
 */
@Immutable
public final class ManagedIdentityConfiguration implements JsonSerializable<ManagedIdentityConfiguration> {
    /*
     * The objectId of the Managed Identity that is linked to the Managed Storage account.
     */
    private UUID principalId;

    /*
     * The tenant Id where the Managed Identity is created.
     */
    private UUID tenantId;

    /*
     * The type of Identity created. It can be either SystemAssigned or UserAssigned.
     */
    private String type;

    /**
     * Creates an instance of ManagedIdentityConfiguration class.
     */
    public ManagedIdentityConfiguration() {
    }

    /**
     * Get the principalId property: The objectId of the Managed Identity that is linked to the Managed Storage account.
     * 
     * @return the principalId value.
     */
    public UUID principalId() {
        return this.principalId;
    }

    /**
     * Get the tenantId property: The tenant Id where the Managed Identity is created.
     * 
     * @return the tenantId value.
     */
    public UUID tenantId() {
        return this.tenantId;
    }

    /**
     * Get the type property: The type of Identity created. It can be either SystemAssigned or UserAssigned.
     * 
     * @return the type value.
     */
    public String type() {
        return this.type;
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
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ManagedIdentityConfiguration from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ManagedIdentityConfiguration if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ManagedIdentityConfiguration.
     */
    public static ManagedIdentityConfiguration fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ManagedIdentityConfiguration deserializedManagedIdentityConfiguration = new ManagedIdentityConfiguration();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("principalId".equals(fieldName)) {
                    deserializedManagedIdentityConfiguration.principalId
                        = reader.getNullable(nonNullReader -> UUID.fromString(nonNullReader.getString()));
                } else if ("tenantId".equals(fieldName)) {
                    deserializedManagedIdentityConfiguration.tenantId
                        = reader.getNullable(nonNullReader -> UUID.fromString(nonNullReader.getString()));
                } else if ("type".equals(fieldName)) {
                    deserializedManagedIdentityConfiguration.type = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedManagedIdentityConfiguration;
        });
    }
}
