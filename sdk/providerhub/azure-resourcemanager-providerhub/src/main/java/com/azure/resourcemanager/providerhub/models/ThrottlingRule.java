// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The ThrottlingRule model.
 */
@Fluent
public final class ThrottlingRule implements JsonSerializable<ThrottlingRule> {
    /*
     * The action.
     */
    private String action;

    /*
     * The metrics.
     */
    private List<ThrottlingMetric> metrics;

    /*
     * The required features.
     */
    private List<String> requiredFeatures;

    /*
     * The application id.
     */
    private List<String> applicationId;

    /**
     * Creates an instance of ThrottlingRule class.
     */
    public ThrottlingRule() {
    }

    /**
     * Get the action property: The action.
     * 
     * @return the action value.
     */
    public String action() {
        return this.action;
    }

    /**
     * Set the action property: The action.
     * 
     * @param action the action value to set.
     * @return the ThrottlingRule object itself.
     */
    public ThrottlingRule withAction(String action) {
        this.action = action;
        return this;
    }

    /**
     * Get the metrics property: The metrics.
     * 
     * @return the metrics value.
     */
    public List<ThrottlingMetric> metrics() {
        return this.metrics;
    }

    /**
     * Set the metrics property: The metrics.
     * 
     * @param metrics the metrics value to set.
     * @return the ThrottlingRule object itself.
     */
    public ThrottlingRule withMetrics(List<ThrottlingMetric> metrics) {
        this.metrics = metrics;
        return this;
    }

    /**
     * Get the requiredFeatures property: The required features.
     * 
     * @return the requiredFeatures value.
     */
    public List<String> requiredFeatures() {
        return this.requiredFeatures;
    }

    /**
     * Set the requiredFeatures property: The required features.
     * 
     * @param requiredFeatures the requiredFeatures value to set.
     * @return the ThrottlingRule object itself.
     */
    public ThrottlingRule withRequiredFeatures(List<String> requiredFeatures) {
        this.requiredFeatures = requiredFeatures;
        return this;
    }

    /**
     * Get the applicationId property: The application id.
     * 
     * @return the applicationId value.
     */
    public List<String> applicationId() {
        return this.applicationId;
    }

    /**
     * Set the applicationId property: The application id.
     * 
     * @param applicationId the applicationId value to set.
     * @return the ThrottlingRule object itself.
     */
    public ThrottlingRule withApplicationId(List<String> applicationId) {
        this.applicationId = applicationId;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (action() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property action in model ThrottlingRule"));
        }
        if (metrics() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property metrics in model ThrottlingRule"));
        } else {
            metrics().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ThrottlingRule.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("action", this.action);
        jsonWriter.writeArrayField("metrics", this.metrics, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("requiredFeatures", this.requiredFeatures,
            (writer, element) -> writer.writeString(element));
        jsonWriter.writeArrayField("applicationId", this.applicationId,
            (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ThrottlingRule from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ThrottlingRule if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ThrottlingRule.
     */
    public static ThrottlingRule fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ThrottlingRule deserializedThrottlingRule = new ThrottlingRule();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("action".equals(fieldName)) {
                    deserializedThrottlingRule.action = reader.getString();
                } else if ("metrics".equals(fieldName)) {
                    List<ThrottlingMetric> metrics = reader.readArray(reader1 -> ThrottlingMetric.fromJson(reader1));
                    deserializedThrottlingRule.metrics = metrics;
                } else if ("requiredFeatures".equals(fieldName)) {
                    List<String> requiredFeatures = reader.readArray(reader1 -> reader1.getString());
                    deserializedThrottlingRule.requiredFeatures = requiredFeatures;
                } else if ("applicationId".equals(fieldName)) {
                    List<String> applicationId = reader.readArray(reader1 -> reader1.getString());
                    deserializedThrottlingRule.applicationId = applicationId;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedThrottlingRule;
        });
    }
}
