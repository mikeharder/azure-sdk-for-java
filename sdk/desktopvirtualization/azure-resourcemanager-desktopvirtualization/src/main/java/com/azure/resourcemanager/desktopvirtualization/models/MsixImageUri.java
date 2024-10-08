// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.desktopvirtualization.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Represents URI referring to MSIX Image.
 */
@Fluent
public final class MsixImageUri implements JsonSerializable<MsixImageUri> {
    /*
     * URI to Image
     */
    private String uri;

    /**
     * Creates an instance of MsixImageUri class.
     */
    public MsixImageUri() {
    }

    /**
     * Get the uri property: URI to Image.
     * 
     * @return the uri value.
     */
    public String uri() {
        return this.uri;
    }

    /**
     * Set the uri property: URI to Image.
     * 
     * @param uri the uri value to set.
     * @return the MsixImageUri object itself.
     */
    public MsixImageUri withUri(String uri) {
        this.uri = uri;
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
        jsonWriter.writeStringField("uri", this.uri);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MsixImageUri from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MsixImageUri if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the MsixImageUri.
     */
    public static MsixImageUri fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MsixImageUri deserializedMsixImageUri = new MsixImageUri();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("uri".equals(fieldName)) {
                    deserializedMsixImageUri.uri = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedMsixImageUri;
        });
    }
}
