// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.batch.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Parameters supplied to the RegenerateKey operation.
 */
@Fluent
public final class BatchAccountRegenerateKeyParameters
    implements JsonSerializable<BatchAccountRegenerateKeyParameters> {
    /*
     * The type of account key to regenerate.
     */
    private AccountKeyType keyName;

    /**
     * Creates an instance of BatchAccountRegenerateKeyParameters class.
     */
    public BatchAccountRegenerateKeyParameters() {
    }

    /**
     * Get the keyName property: The type of account key to regenerate.
     * 
     * @return the keyName value.
     */
    public AccountKeyType keyName() {
        return this.keyName;
    }

    /**
     * Set the keyName property: The type of account key to regenerate.
     * 
     * @param keyName the keyName value to set.
     * @return the BatchAccountRegenerateKeyParameters object itself.
     */
    public BatchAccountRegenerateKeyParameters withKeyName(AccountKeyType keyName) {
        this.keyName = keyName;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (keyName() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property keyName in model BatchAccountRegenerateKeyParameters"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(BatchAccountRegenerateKeyParameters.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("keyName", this.keyName == null ? null : this.keyName.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of BatchAccountRegenerateKeyParameters from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of BatchAccountRegenerateKeyParameters if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the BatchAccountRegenerateKeyParameters.
     */
    public static BatchAccountRegenerateKeyParameters fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            BatchAccountRegenerateKeyParameters deserializedBatchAccountRegenerateKeyParameters
                = new BatchAccountRegenerateKeyParameters();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("keyName".equals(fieldName)) {
                    deserializedBatchAccountRegenerateKeyParameters.keyName
                        = AccountKeyType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedBatchAccountRegenerateKeyParameters;
        });
    }
}
