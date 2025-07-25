// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The MetastoreRegistrationResponse model.
 */
@Fluent
public final class MetastoreRegistrationResponse implements JsonSerializable<MetastoreRegistrationResponse> {
    /*
     * Enumerates possible request statuses.
     */
    @Generated
    private RequestStatus status;

    /**
     * Creates an instance of MetastoreRegistrationResponse class.
     */
    @Generated
    public MetastoreRegistrationResponse() {
    }

    /**
     * Get the status property: Enumerates possible request statuses.
     * 
     * @return the status value.
     */
    @Generated
    public RequestStatus getStatus() {
        return this.status;
    }

    /**
     * Set the status property: Enumerates possible request statuses.
     * 
     * @param status the status value to set.
     * @return the MetastoreRegistrationResponse object itself.
     */
    @Generated
    public MetastoreRegistrationResponse setStatus(RequestStatus status) {
        this.status = status;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("status", this.status == null ? null : this.status.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MetastoreRegistrationResponse from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MetastoreRegistrationResponse if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the MetastoreRegistrationResponse.
     */
    @Generated
    public static MetastoreRegistrationResponse fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MetastoreRegistrationResponse deserializedMetastoreRegistrationResponse
                = new MetastoreRegistrationResponse();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("status".equals(fieldName)) {
                    deserializedMetastoreRegistrationResponse.status = RequestStatus.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedMetastoreRegistrationResponse;
        });
    }
}
