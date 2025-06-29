// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A copy activity DelimitedText sink.
 */
@Fluent
public final class DelimitedTextSink extends CopySink {
    /*
     * Copy sink type.
     */
    @Generated
    private String type = "DelimitedTextSink";

    /*
     * DelimitedText store settings.
     */
    @Generated
    private StoreWriteSettings storeSettings;

    /*
     * DelimitedText format settings.
     */
    @Generated
    private DelimitedTextWriteSettings formatSettings;

    /**
     * Creates an instance of DelimitedTextSink class.
     */
    @Generated
    public DelimitedTextSink() {
    }

    /**
     * Get the type property: Copy sink type.
     * 
     * @return the type value.
     */
    @Generated
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Get the storeSettings property: DelimitedText store settings.
     * 
     * @return the storeSettings value.
     */
    @Generated
    public StoreWriteSettings getStoreSettings() {
        return this.storeSettings;
    }

    /**
     * Set the storeSettings property: DelimitedText store settings.
     * 
     * @param storeSettings the storeSettings value to set.
     * @return the DelimitedTextSink object itself.
     */
    @Generated
    public DelimitedTextSink setStoreSettings(StoreWriteSettings storeSettings) {
        this.storeSettings = storeSettings;
        return this;
    }

    /**
     * Get the formatSettings property: DelimitedText format settings.
     * 
     * @return the formatSettings value.
     */
    @Generated
    public DelimitedTextWriteSettings getFormatSettings() {
        return this.formatSettings;
    }

    /**
     * Set the formatSettings property: DelimitedText format settings.
     * 
     * @param formatSettings the formatSettings value to set.
     * @return the DelimitedTextSink object itself.
     */
    @Generated
    public DelimitedTextSink setFormatSettings(DelimitedTextWriteSettings formatSettings) {
        this.formatSettings = formatSettings;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public DelimitedTextSink setWriteBatchSize(Object writeBatchSize) {
        super.setWriteBatchSize(writeBatchSize);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public DelimitedTextSink setWriteBatchTimeout(Object writeBatchTimeout) {
        super.setWriteBatchTimeout(writeBatchTimeout);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public DelimitedTextSink setSinkRetryCount(Object sinkRetryCount) {
        super.setSinkRetryCount(sinkRetryCount);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public DelimitedTextSink setSinkRetryWait(Object sinkRetryWait) {
        super.setSinkRetryWait(sinkRetryWait);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public DelimitedTextSink setMaxConcurrentConnections(Object maxConcurrentConnections) {
        super.setMaxConcurrentConnections(maxConcurrentConnections);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        if (getWriteBatchSize() != null) {
            jsonWriter.writeUntypedField("writeBatchSize", getWriteBatchSize());
        }
        if (getWriteBatchTimeout() != null) {
            jsonWriter.writeUntypedField("writeBatchTimeout", getWriteBatchTimeout());
        }
        if (getSinkRetryCount() != null) {
            jsonWriter.writeUntypedField("sinkRetryCount", getSinkRetryCount());
        }
        if (getSinkRetryWait() != null) {
            jsonWriter.writeUntypedField("sinkRetryWait", getSinkRetryWait());
        }
        if (getMaxConcurrentConnections() != null) {
            jsonWriter.writeUntypedField("maxConcurrentConnections", getMaxConcurrentConnections());
        }
        jsonWriter.writeStringField("type", this.type);
        jsonWriter.writeJsonField("storeSettings", this.storeSettings);
        jsonWriter.writeJsonField("formatSettings", this.formatSettings);
        if (getAdditionalProperties() != null) {
            for (Map.Entry<String, Object> additionalProperty : getAdditionalProperties().entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DelimitedTextSink from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DelimitedTextSink if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the DelimitedTextSink.
     */
    @Generated
    public static DelimitedTextSink fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DelimitedTextSink deserializedDelimitedTextSink = new DelimitedTextSink();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("writeBatchSize".equals(fieldName)) {
                    deserializedDelimitedTextSink.setWriteBatchSize(reader.readUntyped());
                } else if ("writeBatchTimeout".equals(fieldName)) {
                    deserializedDelimitedTextSink.setWriteBatchTimeout(reader.readUntyped());
                } else if ("sinkRetryCount".equals(fieldName)) {
                    deserializedDelimitedTextSink.setSinkRetryCount(reader.readUntyped());
                } else if ("sinkRetryWait".equals(fieldName)) {
                    deserializedDelimitedTextSink.setSinkRetryWait(reader.readUntyped());
                } else if ("maxConcurrentConnections".equals(fieldName)) {
                    deserializedDelimitedTextSink.setMaxConcurrentConnections(reader.readUntyped());
                } else if ("type".equals(fieldName)) {
                    deserializedDelimitedTextSink.type = reader.getString();
                } else if ("storeSettings".equals(fieldName)) {
                    deserializedDelimitedTextSink.storeSettings = StoreWriteSettings.fromJson(reader);
                } else if ("formatSettings".equals(fieldName)) {
                    deserializedDelimitedTextSink.formatSettings = DelimitedTextWriteSettings.fromJson(reader);
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedDelimitedTextSink.setAdditionalProperties(additionalProperties);

            return deserializedDelimitedTextSink;
        });
    }
}
