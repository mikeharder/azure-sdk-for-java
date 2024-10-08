// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Function App stack major version.
 */
@Immutable
public final class FunctionAppMajorVersion implements JsonSerializable<FunctionAppMajorVersion> {
    /*
     * Function App stack major version (display only).
     */
    private String displayText;

    /*
     * Function App stack major version name.
     */
    private String value;

    /*
     * Minor versions associated with the major version.
     */
    private List<FunctionAppMinorVersion> minorVersions;

    /**
     * Creates an instance of FunctionAppMajorVersion class.
     */
    public FunctionAppMajorVersion() {
    }

    /**
     * Get the displayText property: Function App stack major version (display only).
     * 
     * @return the displayText value.
     */
    public String displayText() {
        return this.displayText;
    }

    /**
     * Get the value property: Function App stack major version name.
     * 
     * @return the value value.
     */
    public String value() {
        return this.value;
    }

    /**
     * Get the minorVersions property: Minor versions associated with the major version.
     * 
     * @return the minorVersions value.
     */
    public List<FunctionAppMinorVersion> minorVersions() {
        return this.minorVersions;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (minorVersions() != null) {
            minorVersions().forEach(e -> e.validate());
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
     * Reads an instance of FunctionAppMajorVersion from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of FunctionAppMajorVersion if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the FunctionAppMajorVersion.
     */
    public static FunctionAppMajorVersion fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            FunctionAppMajorVersion deserializedFunctionAppMajorVersion = new FunctionAppMajorVersion();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("displayText".equals(fieldName)) {
                    deserializedFunctionAppMajorVersion.displayText = reader.getString();
                } else if ("value".equals(fieldName)) {
                    deserializedFunctionAppMajorVersion.value = reader.getString();
                } else if ("minorVersions".equals(fieldName)) {
                    List<FunctionAppMinorVersion> minorVersions
                        = reader.readArray(reader1 -> FunctionAppMinorVersion.fromJson(reader1));
                    deserializedFunctionAppMajorVersion.minorVersions = minorVersions;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedFunctionAppMajorVersion;
        });
    }
}
