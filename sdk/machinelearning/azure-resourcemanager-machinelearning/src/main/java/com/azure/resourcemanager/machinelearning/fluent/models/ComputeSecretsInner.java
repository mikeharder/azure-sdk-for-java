// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.machinelearning.models.AksComputeSecrets;
import com.azure.resourcemanager.machinelearning.models.ComputeType;
import com.azure.resourcemanager.machinelearning.models.DatabricksComputeSecrets;
import com.azure.resourcemanager.machinelearning.models.VirtualMachineSecrets;
import java.io.IOException;

/**
 * Secrets related to a Machine Learning compute. Might differ for every type of compute.
 */
@Immutable
public class ComputeSecretsInner implements JsonSerializable<ComputeSecretsInner> {
    /*
     * The type of compute
     */
    private ComputeType computeType = ComputeType.fromString("ComputeSecrets");

    /**
     * Creates an instance of ComputeSecretsInner class.
     */
    public ComputeSecretsInner() {
    }

    /**
     * Get the computeType property: The type of compute.
     * 
     * @return the computeType value.
     */
    public ComputeType computeType() {
        return this.computeType;
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
        jsonWriter.writeStringField("computeType", this.computeType == null ? null : this.computeType.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ComputeSecretsInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ComputeSecretsInner if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ComputeSecretsInner.
     */
    public static ComputeSecretsInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("computeType".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("AKS".equals(discriminatorValue)) {
                    return AksComputeSecrets.fromJson(readerToUse.reset());
                } else if ("VirtualMachine".equals(discriminatorValue)) {
                    return VirtualMachineSecrets.fromJson(readerToUse.reset());
                } else if ("Databricks".equals(discriminatorValue)) {
                    return DatabricksComputeSecrets.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    static ComputeSecretsInner fromJsonKnownDiscriminator(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ComputeSecretsInner deserializedComputeSecretsInner = new ComputeSecretsInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("computeType".equals(fieldName)) {
                    deserializedComputeSecretsInner.computeType = ComputeType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedComputeSecretsInner;
        });
    }
}
