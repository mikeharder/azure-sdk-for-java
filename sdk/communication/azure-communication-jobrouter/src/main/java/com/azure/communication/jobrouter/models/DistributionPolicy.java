// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.communication.jobrouter.models;

import com.azure.communication.jobrouter.implementation.JsonMergePatchHelper;
import com.azure.communication.jobrouter.implementation.utils.CustomizationHelper;
import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

/**
 * Policy governing how jobs are distributed to workers.
 */
@Fluent
public final class DistributionPolicy implements JsonSerializable<DistributionPolicy> {

    /*
     * The entity tag for this resource.
     */
    @Generated
    private String etag;

    /*
     * Id of a distribution policy.
     */
    @Generated
    private String id;

    /*
     * Friendly name of this policy.
     */
    @Generated
    private String name;

    /*
     * Mode governing the specific distribution method.
     */
    @Generated
    private DistributionMode mode;

    /**
     * Stores updated model property, the value is property name, not serialized name.
     */
    @Generated
    private final Set<String> updatedProperties = new HashSet<>();

    @Generated
    private boolean jsonMergePatch;

    @Generated
    private void serializeAsJsonMergePatch(boolean jsonMergePatch) {
        this.jsonMergePatch = jsonMergePatch;
    }

    static {
        JsonMergePatchHelper.setDistributionPolicyAccessor(new JsonMergePatchHelper.DistributionPolicyAccessor() {

            @Override
            public DistributionPolicy prepareModelForJsonMergePatch(DistributionPolicy model,
                boolean jsonMergePatchEnabled) {
                model.serializeAsJsonMergePatch(jsonMergePatchEnabled);
                return model;
            }

            @Override
            public boolean isJsonMergePatch(DistributionPolicy model) {
                return model.jsonMergePatch;
            }

            @Override
            public void setId(DistributionPolicy policy, String id) {
                policy.id = id;
            }
        });
    }

    /**
     * Creates an instance of DistributionPolicy class.
     */
    @Generated
    public DistributionPolicy() {
    }

    /**
     * Get the etag property: The entity tag for this resource.
     *
     * @return the etag value.
     */
    @Generated
    public String getEtag() {
        return this.etag;
    }

    /**
     * Get the id property: Id of a distribution policy.
     *
     * @return the id value.
     */
    @Generated
    public String getId() {
        return this.id;
    }

    /**
     * Get the name property: Friendly name of this policy.
     *
     * @return the name value.
     */
    @Generated
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: Friendly name of this policy.
     *
     * @param name the name value to set.
     * @return the DistributionPolicy object itself.
     */
    @Generated
    public DistributionPolicy setName(String name) {
        this.name = name;
        this.updatedProperties.add("name");
        return this;
    }

    /**
     * Get the offerExpiresAfterSeconds property: Number of seconds after which any offers created under this policy
     * will be expired.
     *
     * @return the offerExpiresAfterSeconds value.
     */
    @Generated
    public Duration getOfferExpiresAfter() {
        return this.offerExpiresAfterSeconds;
    }

    /**
     * Set the offerExpiresAfterSeconds property: Number of seconds after which any offers created under this policy
     * will be expired.
     *
     * @param offerExpiresAfterSeconds the offerExpiresAfterSeconds value to set.
     * @return the DistributionPolicy object itself.
     */
    @Generated
    public DistributionPolicy setOfferExpiresAfter(Duration offerExpiresAfterSeconds) {
        this.offerExpiresAfterSeconds = offerExpiresAfterSeconds;
        this.updatedProperties.add("offerExpiresAfterSeconds");
        return this;
    }

    /**
     * Get the mode property: Mode governing the specific distribution method.
     *
     * @return the mode value.
     */
    @Generated
    public DistributionMode getMode() {
        return this.mode;
    }

    /**
     * Set the mode property: Mode governing the specific distribution method.
     *
     * @param mode the mode value to set.
     * @return the DistributionPolicy object itself.
     */
    @Generated
    public DistributionPolicy setMode(DistributionMode mode) {
        this.mode = mode;
        this.updatedProperties.add("mode");
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        if (jsonMergePatch) {
            return toJsonMergePatch(jsonWriter);
        } else {
            jsonWriter.writeStartObject();
            jsonWriter.writeStringField("name", this.name);
            CustomizationHelper.serializeDurationToSeconds(jsonWriter, "offerExpiresAfterSeconds",
                this.offerExpiresAfterSeconds);
            jsonWriter.writeJsonField("mode", this.mode);
            return jsonWriter.writeEndObject();
        }
    }

    @Generated
    private JsonWriter toJsonMergePatch(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        if (updatedProperties.contains("name")) {
            if (this.name == null) {
                jsonWriter.writeNullField("name");
            } else {
                jsonWriter.writeStringField("name", this.name);
            }
        }
        if (updatedProperties.contains("offerExpiresAfterSeconds")) {
            if (this.offerExpiresAfterSeconds == null) {
                jsonWriter.writeNullField("offerExpiresAfterSeconds");
            } else {
                CustomizationHelper.serializeDurationToSeconds(jsonWriter, "offerExpiresAfterSeconds",
                    this.offerExpiresAfterSeconds);
            }
        }
        if (updatedProperties.contains("mode")) {
            if (this.mode == null) {
                jsonWriter.writeNullField("mode");
            } else {
                JsonMergePatchHelper.getDistributionModeAccessor().prepareModelForJsonMergePatch(this.mode, true);
                jsonWriter.writeJsonField("mode", this.mode);
                JsonMergePatchHelper.getDistributionModeAccessor().prepareModelForJsonMergePatch(this.mode, false);
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DistributionPolicy from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of DistributionPolicy if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the DistributionPolicy.
     */
    @Generated
    public static DistributionPolicy fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DistributionPolicy deserializedDistributionPolicy = new DistributionPolicy();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("etag".equals(fieldName)) {
                    deserializedDistributionPolicy.etag = reader.getString();
                } else if ("id".equals(fieldName)) {
                    deserializedDistributionPolicy.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedDistributionPolicy.name = reader.getString();
                } else if ("offerExpiresAfterSeconds".equals(fieldName)) {
                    deserializedDistributionPolicy.offerExpiresAfterSeconds
                        = reader.getNullable(CustomizationHelper::deserializeDurationFromSeconds);
                } else if ("mode".equals(fieldName)) {
                    deserializedDistributionPolicy.mode = DistributionMode.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }
            return deserializedDistributionPolicy;
        });
    }

    /*
     * Number of seconds after which any offers created under this policy will be expired.
     */
    @Generated
    private Duration offerExpiresAfterSeconds;
}
