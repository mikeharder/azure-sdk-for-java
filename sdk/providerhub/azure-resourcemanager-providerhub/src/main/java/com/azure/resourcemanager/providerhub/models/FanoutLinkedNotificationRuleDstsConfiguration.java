// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The dsts configuration.
 */
@Fluent
public final class FanoutLinkedNotificationRuleDstsConfiguration extends DstsConfiguration {
    /**
     * Creates an instance of FanoutLinkedNotificationRuleDstsConfiguration class.
     */
    public FanoutLinkedNotificationRuleDstsConfiguration() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FanoutLinkedNotificationRuleDstsConfiguration withServiceName(String serviceName) {
        super.withServiceName(serviceName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FanoutLinkedNotificationRuleDstsConfiguration withServiceDnsName(String serviceDnsName) {
        super.withServiceDnsName(serviceDnsName);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (serviceName() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property serviceName in model FanoutLinkedNotificationRuleDstsConfiguration"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(FanoutLinkedNotificationRuleDstsConfiguration.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("serviceName", serviceName());
        jsonWriter.writeStringField("serviceDnsName", serviceDnsName());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of FanoutLinkedNotificationRuleDstsConfiguration from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of FanoutLinkedNotificationRuleDstsConfiguration if the JsonReader was pointing to an
     * instance of it, or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the FanoutLinkedNotificationRuleDstsConfiguration.
     */
    public static FanoutLinkedNotificationRuleDstsConfiguration fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            FanoutLinkedNotificationRuleDstsConfiguration deserializedFanoutLinkedNotificationRuleDstsConfiguration
                = new FanoutLinkedNotificationRuleDstsConfiguration();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("serviceName".equals(fieldName)) {
                    deserializedFanoutLinkedNotificationRuleDstsConfiguration.withServiceName(reader.getString());
                } else if ("serviceDnsName".equals(fieldName)) {
                    deserializedFanoutLinkedNotificationRuleDstsConfiguration.withServiceDnsName(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedFanoutLinkedNotificationRuleDstsConfiguration;
        });
    }
}
