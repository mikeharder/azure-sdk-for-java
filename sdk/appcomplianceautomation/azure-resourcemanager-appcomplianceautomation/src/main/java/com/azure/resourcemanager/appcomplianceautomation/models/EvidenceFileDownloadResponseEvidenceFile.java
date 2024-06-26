// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcomplianceautomation.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The uri of evidence file.
 */
@Immutable
public final class EvidenceFileDownloadResponseEvidenceFile
    implements JsonSerializable<EvidenceFileDownloadResponseEvidenceFile> {
    /*
     * The url of evidence file
     */
    private String url;

    /**
     * Creates an instance of EvidenceFileDownloadResponseEvidenceFile class.
     */
    private EvidenceFileDownloadResponseEvidenceFile() {
    }

    /**
     * Get the url property: The url of evidence file.
     * 
     * @return the url value.
     */
    public String url() {
        return this.url;
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
     * Reads an instance of EvidenceFileDownloadResponseEvidenceFile from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of EvidenceFileDownloadResponseEvidenceFile if the JsonReader was pointing to an instance of
     * it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the EvidenceFileDownloadResponseEvidenceFile.
     */
    public static EvidenceFileDownloadResponseEvidenceFile fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            EvidenceFileDownloadResponseEvidenceFile deserializedEvidenceFileDownloadResponseEvidenceFile
                = new EvidenceFileDownloadResponseEvidenceFile();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("url".equals(fieldName)) {
                    deserializedEvidenceFileDownloadResponseEvidenceFile.url = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedEvidenceFileDownloadResponseEvidenceFile;
        });
    }
}
