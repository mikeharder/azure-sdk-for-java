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
 * A copy activity source for Db2 databases.
 */
@Fluent
public final class Db2Source extends TabularSource {
    /*
     * Copy source type.
     */
    @Generated
    private String type = "Db2Source";

    /*
     * Database query. Type: string (or Expression with resultType string).
     */
    @Generated
    private Object query;

    /**
     * Creates an instance of Db2Source class.
     */
    @Generated
    public Db2Source() {
    }

    /**
     * Get the type property: Copy source type.
     * 
     * @return the type value.
     */
    @Generated
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Get the query property: Database query. Type: string (or Expression with resultType string).
     * 
     * @return the query value.
     */
    @Generated
    public Object getQuery() {
        return this.query;
    }

    /**
     * Set the query property: Database query. Type: string (or Expression with resultType string).
     * 
     * @param query the query value to set.
     * @return the Db2Source object itself.
     */
    @Generated
    public Db2Source setQuery(Object query) {
        this.query = query;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public Db2Source setQueryTimeout(Object queryTimeout) {
        super.setQueryTimeout(queryTimeout);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public Db2Source setAdditionalColumns(Object additionalColumns) {
        super.setAdditionalColumns(additionalColumns);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public Db2Source setSourceRetryCount(Object sourceRetryCount) {
        super.setSourceRetryCount(sourceRetryCount);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public Db2Source setSourceRetryWait(Object sourceRetryWait) {
        super.setSourceRetryWait(sourceRetryWait);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public Db2Source setMaxConcurrentConnections(Object maxConcurrentConnections) {
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
        if (getSourceRetryCount() != null) {
            jsonWriter.writeUntypedField("sourceRetryCount", getSourceRetryCount());
        }
        if (getSourceRetryWait() != null) {
            jsonWriter.writeUntypedField("sourceRetryWait", getSourceRetryWait());
        }
        if (getMaxConcurrentConnections() != null) {
            jsonWriter.writeUntypedField("maxConcurrentConnections", getMaxConcurrentConnections());
        }
        if (getQueryTimeout() != null) {
            jsonWriter.writeUntypedField("queryTimeout", getQueryTimeout());
        }
        if (getAdditionalColumns() != null) {
            jsonWriter.writeUntypedField("additionalColumns", getAdditionalColumns());
        }
        jsonWriter.writeStringField("type", this.type);
        if (this.query != null) {
            jsonWriter.writeUntypedField("query", this.query);
        }
        if (getAdditionalProperties() != null) {
            for (Map.Entry<String, Object> additionalProperty : getAdditionalProperties().entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of Db2Source from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of Db2Source if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IOException If an error occurs while reading the Db2Source.
     */
    @Generated
    public static Db2Source fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            Db2Source deserializedDb2Source = new Db2Source();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("sourceRetryCount".equals(fieldName)) {
                    deserializedDb2Source.setSourceRetryCount(reader.readUntyped());
                } else if ("sourceRetryWait".equals(fieldName)) {
                    deserializedDb2Source.setSourceRetryWait(reader.readUntyped());
                } else if ("maxConcurrentConnections".equals(fieldName)) {
                    deserializedDb2Source.setMaxConcurrentConnections(reader.readUntyped());
                } else if ("queryTimeout".equals(fieldName)) {
                    deserializedDb2Source.setQueryTimeout(reader.readUntyped());
                } else if ("additionalColumns".equals(fieldName)) {
                    deserializedDb2Source.setAdditionalColumns(reader.readUntyped());
                } else if ("type".equals(fieldName)) {
                    deserializedDb2Source.type = reader.getString();
                } else if ("query".equals(fieldName)) {
                    deserializedDb2Source.query = reader.readUntyped();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedDb2Source.setAdditionalProperties(additionalProperties);

            return deserializedDb2Source;
        });
    }
}
