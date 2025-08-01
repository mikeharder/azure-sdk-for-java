// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.exception.ManagementError;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.datamigration.fluent.models.CommandPropertiesInner;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Properties for the task that collects user tables for the given list of databases.
 */
@Fluent
public final class GetUserTablesSqlSyncTaskProperties extends ProjectTaskProperties {
    /*
     * Task type.
     */
    private TaskType taskType = TaskType.GET_USER_TABLES_AZURE_SQL_DB_SYNC;

    /*
     * Task input
     */
    private GetUserTablesSqlSyncTaskInput input;

    /*
     * Task output. This is ignored if submitted.
     */
    private List<GetUserTablesSqlSyncTaskOutput> output;

    /**
     * Creates an instance of GetUserTablesSqlSyncTaskProperties class.
     */
    public GetUserTablesSqlSyncTaskProperties() {
    }

    /**
     * Get the taskType property: Task type.
     * 
     * @return the taskType value.
     */
    @Override
    public TaskType taskType() {
        return this.taskType;
    }

    /**
     * Get the input property: Task input.
     * 
     * @return the input value.
     */
    public GetUserTablesSqlSyncTaskInput input() {
        return this.input;
    }

    /**
     * Set the input property: Task input.
     * 
     * @param input the input value to set.
     * @return the GetUserTablesSqlSyncTaskProperties object itself.
     */
    public GetUserTablesSqlSyncTaskProperties withInput(GetUserTablesSqlSyncTaskInput input) {
        this.input = input;
        return this;
    }

    /**
     * Get the output property: Task output. This is ignored if submitted.
     * 
     * @return the output value.
     */
    public List<GetUserTablesSqlSyncTaskOutput> output() {
        return this.output;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GetUserTablesSqlSyncTaskProperties withClientData(Map<String, String> clientData) {
        super.withClientData(clientData);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (input() != null) {
            input().validate();
        }
        if (output() != null) {
            output().forEach(e -> e.validate());
        }
        if (commands() != null) {
            commands().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeMapField("clientData", clientData(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("taskType", this.taskType == null ? null : this.taskType.toString());
        jsonWriter.writeJsonField("input", this.input);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GetUserTablesSqlSyncTaskProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GetUserTablesSqlSyncTaskProperties if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the GetUserTablesSqlSyncTaskProperties.
     */
    public static GetUserTablesSqlSyncTaskProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            GetUserTablesSqlSyncTaskProperties deserializedGetUserTablesSqlSyncTaskProperties
                = new GetUserTablesSqlSyncTaskProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("errors".equals(fieldName)) {
                    List<ManagementError> errors = reader.readArray(reader1 -> ManagementError.fromJson(reader1));
                    deserializedGetUserTablesSqlSyncTaskProperties.withErrors(errors);
                } else if ("state".equals(fieldName)) {
                    deserializedGetUserTablesSqlSyncTaskProperties.withState(TaskState.fromString(reader.getString()));
                } else if ("commands".equals(fieldName)) {
                    List<CommandPropertiesInner> commands
                        = reader.readArray(reader1 -> CommandPropertiesInner.fromJson(reader1));
                    deserializedGetUserTablesSqlSyncTaskProperties.withCommands(commands);
                } else if ("clientData".equals(fieldName)) {
                    Map<String, String> clientData = reader.readMap(reader1 -> reader1.getString());
                    deserializedGetUserTablesSqlSyncTaskProperties.withClientData(clientData);
                } else if ("taskType".equals(fieldName)) {
                    deserializedGetUserTablesSqlSyncTaskProperties.taskType = TaskType.fromString(reader.getString());
                } else if ("input".equals(fieldName)) {
                    deserializedGetUserTablesSqlSyncTaskProperties.input
                        = GetUserTablesSqlSyncTaskInput.fromJson(reader);
                } else if ("output".equals(fieldName)) {
                    List<GetUserTablesSqlSyncTaskOutput> output
                        = reader.readArray(reader1 -> GetUserTablesSqlSyncTaskOutput.fromJson(reader1));
                    deserializedGetUserTablesSqlSyncTaskProperties.output = output;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedGetUserTablesSqlSyncTaskProperties;
        });
    }
}
