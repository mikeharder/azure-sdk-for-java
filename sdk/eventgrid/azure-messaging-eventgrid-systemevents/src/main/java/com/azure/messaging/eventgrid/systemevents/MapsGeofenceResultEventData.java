// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.messaging.eventgrid.systemevents;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Schema of the Data property of an EventGridEvent for a Microsoft.Maps.GeofenceResult event.
 */
@Immutable
public final class MapsGeofenceResultEventData extends MapsGeofenceEventProperties {
    /**
     * Creates an instance of MapsGeofenceResultEventData class.
     * 
     * @param expiredGeofenceGeometryId the expiredGeofenceGeometryId value to set.
     * @param geometries the geometries value to set.
     * @param invalidPeriodGeofenceGeometryId the invalidPeriodGeofenceGeometryId value to set.
     * @param isEventPublished the isEventPublished value to set.
     */
    @Generated
    private MapsGeofenceResultEventData(List<String> expiredGeofenceGeometryId, List<MapsGeofenceGeometry> geometries,
        List<String> invalidPeriodGeofenceGeometryId, boolean isEventPublished) {
        super(expiredGeofenceGeometryId, geometries, invalidPeriodGeofenceGeometryId, isEventPublished);
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("expiredGeofenceGeometryId", getExpiredGeofenceGeometryId(),
            (writer, element) -> writer.writeString(element));
        jsonWriter.writeArrayField("geometries", getGeometries(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("invalidPeriodGeofenceGeometryId", getInvalidPeriodGeofenceGeometryId(),
            (writer, element) -> writer.writeString(element));
        jsonWriter.writeBooleanField("isEventPublished", isEventPublished());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MapsGeofenceResultEventData from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MapsGeofenceResultEventData if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the MapsGeofenceResultEventData.
     */
    @Generated
    public static MapsGeofenceResultEventData fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            List<String> expiredGeofenceGeometryId = null;
            List<MapsGeofenceGeometry> geometries = null;
            List<String> invalidPeriodGeofenceGeometryId = null;
            boolean isEventPublished = false;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("expiredGeofenceGeometryId".equals(fieldName)) {
                    expiredGeofenceGeometryId = reader.readArray(reader1 -> reader1.getString());
                } else if ("geometries".equals(fieldName)) {
                    geometries = reader.readArray(reader1 -> MapsGeofenceGeometry.fromJson(reader1));
                } else if ("invalidPeriodGeofenceGeometryId".equals(fieldName)) {
                    invalidPeriodGeofenceGeometryId = reader.readArray(reader1 -> reader1.getString());
                } else if ("isEventPublished".equals(fieldName)) {
                    isEventPublished = reader.getBoolean();
                } else {
                    reader.skipChildren();
                }
            }
            return new MapsGeofenceResultEventData(expiredGeofenceGeometryId, geometries,
                invalidPeriodGeofenceGeometryId, isEventPublished);
        });
    }
}
