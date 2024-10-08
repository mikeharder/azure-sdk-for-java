// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appplatform.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The error code compose of code and message.
 */
@Fluent
public final class Error implements JsonSerializable<Error> {
    /*
     * The code of error.
     */
    private String code;

    /*
     * The message of error.
     */
    private String message;

    /**
     * Creates an instance of Error class.
     */
    public Error() {
    }

    /**
     * Get the code property: The code of error.
     * 
     * @return the code value.
     */
    public String code() {
        return this.code;
    }

    /**
     * Set the code property: The code of error.
     * 
     * @param code the code value to set.
     * @return the Error object itself.
     */
    public Error withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get the message property: The message of error.
     * 
     * @return the message value.
     */
    public String message() {
        return this.message;
    }

    /**
     * Set the message property: The message of error.
     * 
     * @param message the message value to set.
     * @return the Error object itself.
     */
    public Error withMessage(String message) {
        this.message = message;
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
        jsonWriter.writeStringField("code", this.code);
        jsonWriter.writeStringField("message", this.message);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of Error from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of Error if the JsonReader was pointing to an instance of it, or null if it was pointing to
     * JSON null.
     * @throws IOException If an error occurs while reading the Error.
     */
    public static Error fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            Error deserializedError = new Error();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("code".equals(fieldName)) {
                    deserializedError.code = reader.getString();
                } else if ("message".equals(fieldName)) {
                    deserializedError.message = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedError;
        });
    }
}
