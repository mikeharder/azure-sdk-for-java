// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.reservations.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The roll up count summary of reservations in each state.
 */
@Immutable
public final class ReservationSummary implements JsonSerializable<ReservationSummary> {
    /*
     * The number of reservation in Succeeded state
     */
    private Float succeededCount;

    /*
     * The number of reservation in Failed state
     */
    private Float failedCount;

    /*
     * The number of reservation in Expiring state
     */
    private Float expiringCount;

    /*
     * The number of reservation in Expired state
     */
    private Float expiredCount;

    /*
     * The number of reservation in Pending state
     */
    private Float pendingCount;

    /*
     * The number of reservation in Cancelled state
     */
    private Float cancelledCount;

    /*
     * The number of reservation in Processing state
     */
    private Float processingCount;

    /*
     * The number of reservation in Warning state
     */
    private Float warningCount;

    /*
     * The number of reservation in NoBenefit state
     */
    private Float noBenefitCount;

    /**
     * Creates an instance of ReservationSummary class.
     */
    public ReservationSummary() {
    }

    /**
     * Get the succeededCount property: The number of reservation in Succeeded state.
     * 
     * @return the succeededCount value.
     */
    public Float succeededCount() {
        return this.succeededCount;
    }

    /**
     * Get the failedCount property: The number of reservation in Failed state.
     * 
     * @return the failedCount value.
     */
    public Float failedCount() {
        return this.failedCount;
    }

    /**
     * Get the expiringCount property: The number of reservation in Expiring state.
     * 
     * @return the expiringCount value.
     */
    public Float expiringCount() {
        return this.expiringCount;
    }

    /**
     * Get the expiredCount property: The number of reservation in Expired state.
     * 
     * @return the expiredCount value.
     */
    public Float expiredCount() {
        return this.expiredCount;
    }

    /**
     * Get the pendingCount property: The number of reservation in Pending state.
     * 
     * @return the pendingCount value.
     */
    public Float pendingCount() {
        return this.pendingCount;
    }

    /**
     * Get the cancelledCount property: The number of reservation in Cancelled state.
     * 
     * @return the cancelledCount value.
     */
    public Float cancelledCount() {
        return this.cancelledCount;
    }

    /**
     * Get the processingCount property: The number of reservation in Processing state.
     * 
     * @return the processingCount value.
     */
    public Float processingCount() {
        return this.processingCount;
    }

    /**
     * Get the warningCount property: The number of reservation in Warning state.
     * 
     * @return the warningCount value.
     */
    public Float warningCount() {
        return this.warningCount;
    }

    /**
     * Get the noBenefitCount property: The number of reservation in NoBenefit state.
     * 
     * @return the noBenefitCount value.
     */
    public Float noBenefitCount() {
        return this.noBenefitCount;
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
     * Reads an instance of ReservationSummary from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ReservationSummary if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ReservationSummary.
     */
    public static ReservationSummary fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ReservationSummary deserializedReservationSummary = new ReservationSummary();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("succeededCount".equals(fieldName)) {
                    deserializedReservationSummary.succeededCount = reader.getNullable(JsonReader::getFloat);
                } else if ("failedCount".equals(fieldName)) {
                    deserializedReservationSummary.failedCount = reader.getNullable(JsonReader::getFloat);
                } else if ("expiringCount".equals(fieldName)) {
                    deserializedReservationSummary.expiringCount = reader.getNullable(JsonReader::getFloat);
                } else if ("expiredCount".equals(fieldName)) {
                    deserializedReservationSummary.expiredCount = reader.getNullable(JsonReader::getFloat);
                } else if ("pendingCount".equals(fieldName)) {
                    deserializedReservationSummary.pendingCount = reader.getNullable(JsonReader::getFloat);
                } else if ("cancelledCount".equals(fieldName)) {
                    deserializedReservationSummary.cancelledCount = reader.getNullable(JsonReader::getFloat);
                } else if ("processingCount".equals(fieldName)) {
                    deserializedReservationSummary.processingCount = reader.getNullable(JsonReader::getFloat);
                } else if ("warningCount".equals(fieldName)) {
                    deserializedReservationSummary.warningCount = reader.getNullable(JsonReader::getFloat);
                } else if ("noBenefitCount".equals(fieldName)) {
                    deserializedReservationSummary.noBenefitCount = reader.getNullable(JsonReader::getFloat);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedReservationSummary;
        });
    }
}
