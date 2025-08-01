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

/**
 * Properties for the command that restarts a migration in whole or in part.
 */
@Fluent
public final class MongoDbRestartCommand extends CommandPropertiesInner {
    /*
     * Command type.
     */
    private CommandType commandType = CommandType.RESTART;

    /*
     * Command input
     */
    private MongoDbCommandInput input;

    /*
     * The state of the command. This is ignored if submitted.
     */
    private CommandState state;

    /*
     * Array of errors. This is ignored if submitted.
     */
    private List<ManagementError> errors;

    /**
     * Creates an instance of MongoDbRestartCommand class.
     */
    public MongoDbRestartCommand() {
    }

    /**
     * Get the commandType property: Command type.
     * 
     * @return the commandType value.
     */
    @Override
    public CommandType commandType() {
        return this.commandType;
    }

    /**
     * Get the input property: Command input.
     * 
     * @return the input value.
     */
    public MongoDbCommandInput input() {
        return this.input;
    }

    /**
     * Set the input property: Command input.
     * 
     * @param input the input value to set.
     * @return the MongoDbRestartCommand object itself.
     */
    public MongoDbRestartCommand withInput(MongoDbCommandInput input) {
        this.input = input;
        return this;
    }

    /**
     * Get the state property: The state of the command. This is ignored if submitted.
     * 
     * @return the state value.
     */
    @Override
    public CommandState state() {
        return this.state;
    }

    /**
     * Get the errors property: Array of errors. This is ignored if submitted.
     * 
     * @return the errors value.
     */
    @Override
    public List<ManagementError> errors() {
        return this.errors;
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
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("commandType", this.commandType == null ? null : this.commandType.toString());
        jsonWriter.writeJsonField("input", this.input);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MongoDbRestartCommand from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MongoDbRestartCommand if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the MongoDbRestartCommand.
     */
    public static MongoDbRestartCommand fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MongoDbRestartCommand deserializedMongoDbRestartCommand = new MongoDbRestartCommand();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("errors".equals(fieldName)) {
                    List<ManagementError> errors = reader.readArray(reader1 -> ManagementError.fromJson(reader1));
                    deserializedMongoDbRestartCommand.errors = errors;
                } else if ("state".equals(fieldName)) {
                    deserializedMongoDbRestartCommand.state = CommandState.fromString(reader.getString());
                } else if ("commandType".equals(fieldName)) {
                    deserializedMongoDbRestartCommand.commandType = CommandType.fromString(reader.getString());
                } else if ("input".equals(fieldName)) {
                    deserializedMongoDbRestartCommand.input = MongoDbCommandInput.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedMongoDbRestartCommand;
        });
    }
}
