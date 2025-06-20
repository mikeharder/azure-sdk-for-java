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

/**
 * A WebLinkedService that uses client certificate based authentication to communicate with an HTTP endpoint. This
 * scheme follows mutual authentication; the server must also provide valid credentials to the client.
 */
@Fluent
public final class WebClientCertificateAuthentication extends WebLinkedServiceTypeProperties {
    /*
     * Type of authentication used to connect to the web table source.
     */
    @Generated
    private WebAuthenticationType authenticationType = WebAuthenticationType.CLIENT_CERTIFICATE;

    /*
     * Base64-encoded contents of a PFX file.
     */
    @Generated
    private SecretBase pfx;

    /*
     * Password for the PFX file.
     */
    @Generated
    private SecretBase password;

    /**
     * Creates an instance of WebClientCertificateAuthentication class.
     */
    @Generated
    public WebClientCertificateAuthentication() {
    }

    /**
     * Get the authenticationType property: Type of authentication used to connect to the web table source.
     * 
     * @return the authenticationType value.
     */
    @Generated
    @Override
    public WebAuthenticationType getAuthenticationType() {
        return this.authenticationType;
    }

    /**
     * Get the pfx property: Base64-encoded contents of a PFX file.
     * 
     * @return the pfx value.
     */
    @Generated
    public SecretBase getPfx() {
        return this.pfx;
    }

    /**
     * Set the pfx property: Base64-encoded contents of a PFX file.
     * 
     * @param pfx the pfx value to set.
     * @return the WebClientCertificateAuthentication object itself.
     */
    @Generated
    public WebClientCertificateAuthentication setPfx(SecretBase pfx) {
        this.pfx = pfx;
        return this;
    }

    /**
     * Get the password property: Password for the PFX file.
     * 
     * @return the password value.
     */
    @Generated
    public SecretBase getPassword() {
        return this.password;
    }

    /**
     * Set the password property: Password for the PFX file.
     * 
     * @param password the password value to set.
     * @return the WebClientCertificateAuthentication object itself.
     */
    @Generated
    public WebClientCertificateAuthentication setPassword(SecretBase password) {
        this.password = password;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public WebClientCertificateAuthentication setUrl(Object url) {
        super.setUrl(url);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeUntypedField("url", getUrl());
        jsonWriter.writeJsonField("pfx", this.pfx);
        jsonWriter.writeJsonField("password", this.password);
        jsonWriter.writeStringField("authenticationType",
            this.authenticationType == null ? null : this.authenticationType.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of WebClientCertificateAuthentication from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of WebClientCertificateAuthentication if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the WebClientCertificateAuthentication.
     */
    @Generated
    public static WebClientCertificateAuthentication fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            WebClientCertificateAuthentication deserializedWebClientCertificateAuthentication
                = new WebClientCertificateAuthentication();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("url".equals(fieldName)) {
                    deserializedWebClientCertificateAuthentication.setUrl(reader.readUntyped());
                } else if ("pfx".equals(fieldName)) {
                    deserializedWebClientCertificateAuthentication.pfx = SecretBase.fromJson(reader);
                } else if ("password".equals(fieldName)) {
                    deserializedWebClientCertificateAuthentication.password = SecretBase.fromJson(reader);
                } else if ("authenticationType".equals(fieldName)) {
                    deserializedWebClientCertificateAuthentication.authenticationType
                        = WebAuthenticationType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedWebClientCertificateAuthentication;
        });
    }
}
