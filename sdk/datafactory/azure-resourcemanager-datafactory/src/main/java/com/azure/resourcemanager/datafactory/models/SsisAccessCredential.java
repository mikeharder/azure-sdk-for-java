// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * SSIS access credential.
 */
@Fluent
public final class SsisAccessCredential implements JsonSerializable<SsisAccessCredential> {
    /*
     * Domain for windows authentication. Type: string (or Expression with resultType string).
     */
    private Object domain;

    /*
     * UseName for windows authentication. Type: string (or Expression with resultType string).
     */
    private Object username;

    /*
     * Password for windows authentication.
     */
    private SecretBase password;

    /**
     * Creates an instance of SsisAccessCredential class.
     */
    public SsisAccessCredential() {
    }

    /**
     * Get the domain property: Domain for windows authentication. Type: string (or Expression with resultType string).
     * 
     * @return the domain value.
     */
    public Object domain() {
        return this.domain;
    }

    /**
     * Set the domain property: Domain for windows authentication. Type: string (or Expression with resultType string).
     * 
     * @param domain the domain value to set.
     * @return the SsisAccessCredential object itself.
     */
    public SsisAccessCredential withDomain(Object domain) {
        this.domain = domain;
        return this;
    }

    /**
     * Get the username property: UseName for windows authentication. Type: string (or Expression with resultType
     * string).
     * 
     * @return the username value.
     */
    public Object username() {
        return this.username;
    }

    /**
     * Set the username property: UseName for windows authentication. Type: string (or Expression with resultType
     * string).
     * 
     * @param username the username value to set.
     * @return the SsisAccessCredential object itself.
     */
    public SsisAccessCredential withUsername(Object username) {
        this.username = username;
        return this;
    }

    /**
     * Get the password property: Password for windows authentication.
     * 
     * @return the password value.
     */
    public SecretBase password() {
        return this.password;
    }

    /**
     * Set the password property: Password for windows authentication.
     * 
     * @param password the password value to set.
     * @return the SsisAccessCredential object itself.
     */
    public SsisAccessCredential withPassword(SecretBase password) {
        this.password = password;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (domain() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property domain in model SsisAccessCredential"));
        }
        if (username() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property username in model SsisAccessCredential"));
        }
        if (password() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property password in model SsisAccessCredential"));
        } else {
            password().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(SsisAccessCredential.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeUntypedField("domain", this.domain);
        jsonWriter.writeUntypedField("userName", this.username);
        jsonWriter.writeJsonField("password", this.password);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SsisAccessCredential from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SsisAccessCredential if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SsisAccessCredential.
     */
    public static SsisAccessCredential fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SsisAccessCredential deserializedSsisAccessCredential = new SsisAccessCredential();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("domain".equals(fieldName)) {
                    deserializedSsisAccessCredential.domain = reader.readUntyped();
                } else if ("userName".equals(fieldName)) {
                    deserializedSsisAccessCredential.username = reader.readUntyped();
                } else if ("password".equals(fieldName)) {
                    deserializedSsisAccessCredential.password = SecretBase.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSsisAccessCredential;
        });
    }
}
