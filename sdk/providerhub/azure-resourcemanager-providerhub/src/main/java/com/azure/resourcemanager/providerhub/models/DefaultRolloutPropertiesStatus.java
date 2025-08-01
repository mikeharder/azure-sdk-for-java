// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * The default rollout status.
 */
@Fluent
public final class DefaultRolloutPropertiesStatus extends DefaultRolloutStatus {
    /**
     * Creates an instance of DefaultRolloutPropertiesStatus class.
     */
    public DefaultRolloutPropertiesStatus() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultRolloutPropertiesStatus withNextTrafficRegion(TrafficRegionCategory nextTrafficRegion) {
        super.withNextTrafficRegion(nextTrafficRegion);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultRolloutPropertiesStatus
        withNextTrafficRegionScheduledTime(OffsetDateTime nextTrafficRegionScheduledTime) {
        super.withNextTrafficRegionScheduledTime(nextTrafficRegionScheduledTime);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultRolloutPropertiesStatus
        withSubscriptionReregistrationResult(SubscriptionReregistrationResult subscriptionReregistrationResult) {
        super.withSubscriptionReregistrationResult(subscriptionReregistrationResult);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultRolloutPropertiesStatus
        withManifestCheckinStatus(DefaultRolloutStatusManifestCheckinStatus manifestCheckinStatus) {
        super.withManifestCheckinStatus(manifestCheckinStatus);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultRolloutPropertiesStatus withCompletedRegions(List<String> completedRegions) {
        super.withCompletedRegions(completedRegions);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultRolloutPropertiesStatus
        withFailedOrSkippedRegions(Map<String, ExtendedErrorInfo> failedOrSkippedRegions) {
        super.withFailedOrSkippedRegions(failedOrSkippedRegions);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (failedOrSkippedRegions() != null) {
            failedOrSkippedRegions().values().forEach(e -> {
                if (e != null) {
                    e.validate();
                }
            });
        }
        if (manifestCheckinStatus() != null) {
            manifestCheckinStatus().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("completedRegions", completedRegions(),
            (writer, element) -> writer.writeString(element));
        jsonWriter.writeMapField("failedOrSkippedRegions", failedOrSkippedRegions(),
            (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("nextTrafficRegion",
            nextTrafficRegion() == null ? null : nextTrafficRegion().toString());
        jsonWriter.writeStringField("nextTrafficRegionScheduledTime",
            nextTrafficRegionScheduledTime() == null
                ? null
                : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(nextTrafficRegionScheduledTime()));
        jsonWriter.writeStringField("subscriptionReregistrationResult",
            subscriptionReregistrationResult() == null ? null : subscriptionReregistrationResult().toString());
        jsonWriter.writeJsonField("manifestCheckinStatus", manifestCheckinStatus());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DefaultRolloutPropertiesStatus from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DefaultRolloutPropertiesStatus if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the DefaultRolloutPropertiesStatus.
     */
    public static DefaultRolloutPropertiesStatus fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DefaultRolloutPropertiesStatus deserializedDefaultRolloutPropertiesStatus
                = new DefaultRolloutPropertiesStatus();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("completedRegions".equals(fieldName)) {
                    List<String> completedRegions = reader.readArray(reader1 -> reader1.getString());
                    deserializedDefaultRolloutPropertiesStatus.withCompletedRegions(completedRegions);
                } else if ("failedOrSkippedRegions".equals(fieldName)) {
                    Map<String, ExtendedErrorInfo> failedOrSkippedRegions
                        = reader.readMap(reader1 -> ExtendedErrorInfo.fromJson(reader1));
                    deserializedDefaultRolloutPropertiesStatus.withFailedOrSkippedRegions(failedOrSkippedRegions);
                } else if ("nextTrafficRegion".equals(fieldName)) {
                    deserializedDefaultRolloutPropertiesStatus
                        .withNextTrafficRegion(TrafficRegionCategory.fromString(reader.getString()));
                } else if ("nextTrafficRegionScheduledTime".equals(fieldName)) {
                    deserializedDefaultRolloutPropertiesStatus.withNextTrafficRegionScheduledTime(reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString())));
                } else if ("subscriptionReregistrationResult".equals(fieldName)) {
                    deserializedDefaultRolloutPropertiesStatus.withSubscriptionReregistrationResult(
                        SubscriptionReregistrationResult.fromString(reader.getString()));
                } else if ("manifestCheckinStatus".equals(fieldName)) {
                    deserializedDefaultRolloutPropertiesStatus
                        .withManifestCheckinStatus(DefaultRolloutStatusManifestCheckinStatus.fromJson(reader));
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDefaultRolloutPropertiesStatus;
        });
    }
}
