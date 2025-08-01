// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.datamigration.models.DatabaseMigrationPropertiesSqlDb;
import com.azure.resourcemanager.datamigration.models.SystemDataAutoGenerated;
import java.io.IOException;

/**
 * Database Migration Resource for SQL Database.
 */
@Fluent
public final class DatabaseMigrationSqlDbInner extends ProxyResource {
    /*
     * Database Migration Resource properties for SQL database.
     */
    private DatabaseMigrationPropertiesSqlDb properties;

    /*
     * Metadata pertaining to creation and last modification of the resource.
     */
    private SystemDataAutoGenerated systemData;

    /*
     * The type of the resource.
     */
    private String type;

    /*
     * The name of the resource.
     */
    private String name;

    /*
     * Fully qualified resource Id for the resource.
     */
    private String id;

    /**
     * Creates an instance of DatabaseMigrationSqlDbInner class.
     */
    public DatabaseMigrationSqlDbInner() {
    }

    /**
     * Get the properties property: Database Migration Resource properties for SQL database.
     * 
     * @return the properties value.
     */
    public DatabaseMigrationPropertiesSqlDb properties() {
        return this.properties;
    }

    /**
     * Set the properties property: Database Migration Resource properties for SQL database.
     * 
     * @param properties the properties value to set.
     * @return the DatabaseMigrationSqlDbInner object itself.
     */
    public DatabaseMigrationSqlDbInner withProperties(DatabaseMigrationPropertiesSqlDb properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Get the systemData property: Metadata pertaining to creation and last modification of the resource.
     * 
     * @return the systemData value.
     */
    public SystemDataAutoGenerated systemData() {
        return this.systemData;
    }

    /**
     * Get the type property: The type of the resource.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the name property: The name of the resource.
     * 
     * @return the name value.
     */
    @Override
    public String name() {
        return this.name;
    }

    /**
     * Get the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    @Override
    public String id() {
        return this.id;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (properties() != null) {
            properties().validate();
        }
        if (systemData() != null) {
            systemData().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("properties", this.properties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DatabaseMigrationSqlDbInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DatabaseMigrationSqlDbInner if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the DatabaseMigrationSqlDbInner.
     */
    public static DatabaseMigrationSqlDbInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DatabaseMigrationSqlDbInner deserializedDatabaseMigrationSqlDbInner = new DatabaseMigrationSqlDbInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedDatabaseMigrationSqlDbInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedDatabaseMigrationSqlDbInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedDatabaseMigrationSqlDbInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedDatabaseMigrationSqlDbInner.properties
                        = DatabaseMigrationPropertiesSqlDb.fromJson(reader);
                } else if ("systemData".equals(fieldName)) {
                    deserializedDatabaseMigrationSqlDbInner.systemData = SystemDataAutoGenerated.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDatabaseMigrationSqlDbInner;
        });
    }
}
