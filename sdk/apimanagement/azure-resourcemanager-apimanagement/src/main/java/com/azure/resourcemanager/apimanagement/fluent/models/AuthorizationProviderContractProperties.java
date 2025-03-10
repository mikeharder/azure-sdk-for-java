// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.apimanagement.models.AuthorizationProviderOAuth2Settings;
import java.io.IOException;

/**
 * Authorization Provider details.
 */
@Fluent
public final class AuthorizationProviderContractProperties
    implements JsonSerializable<AuthorizationProviderContractProperties> {
    /*
     * Authorization Provider name. Must be 1 to 300 characters long.
     */
    private String displayName;

    /*
     * Identity provider name. Must be 1 to 300 characters long.
     */
    private String identityProvider;

    /*
     * OAuth2 settings
     */
    private AuthorizationProviderOAuth2Settings oauth2;

    /**
     * Creates an instance of AuthorizationProviderContractProperties class.
     */
    public AuthorizationProviderContractProperties() {
    }

    /**
     * Get the displayName property: Authorization Provider name. Must be 1 to 300 characters long.
     * 
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: Authorization Provider name. Must be 1 to 300 characters long.
     * 
     * @param displayName the displayName value to set.
     * @return the AuthorizationProviderContractProperties object itself.
     */
    public AuthorizationProviderContractProperties withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the identityProvider property: Identity provider name. Must be 1 to 300 characters long.
     * 
     * @return the identityProvider value.
     */
    public String identityProvider() {
        return this.identityProvider;
    }

    /**
     * Set the identityProvider property: Identity provider name. Must be 1 to 300 characters long.
     * 
     * @param identityProvider the identityProvider value to set.
     * @return the AuthorizationProviderContractProperties object itself.
     */
    public AuthorizationProviderContractProperties withIdentityProvider(String identityProvider) {
        this.identityProvider = identityProvider;
        return this;
    }

    /**
     * Get the oauth2 property: OAuth2 settings.
     * 
     * @return the oauth2 value.
     */
    public AuthorizationProviderOAuth2Settings oauth2() {
        return this.oauth2;
    }

    /**
     * Set the oauth2 property: OAuth2 settings.
     * 
     * @param oauth2 the oauth2 value to set.
     * @return the AuthorizationProviderContractProperties object itself.
     */
    public AuthorizationProviderContractProperties withOauth2(AuthorizationProviderOAuth2Settings oauth2) {
        this.oauth2 = oauth2;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (oauth2() != null) {
            oauth2().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("displayName", this.displayName);
        jsonWriter.writeStringField("identityProvider", this.identityProvider);
        jsonWriter.writeJsonField("oauth2", this.oauth2);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AuthorizationProviderContractProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AuthorizationProviderContractProperties if the JsonReader was pointing to an instance of
     * it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the AuthorizationProviderContractProperties.
     */
    public static AuthorizationProviderContractProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AuthorizationProviderContractProperties deserializedAuthorizationProviderContractProperties
                = new AuthorizationProviderContractProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("displayName".equals(fieldName)) {
                    deserializedAuthorizationProviderContractProperties.displayName = reader.getString();
                } else if ("identityProvider".equals(fieldName)) {
                    deserializedAuthorizationProviderContractProperties.identityProvider = reader.getString();
                } else if ("oauth2".equals(fieldName)) {
                    deserializedAuthorizationProviderContractProperties.oauth2
                        = AuthorizationProviderOAuth2Settings.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAuthorizationProviderContractProperties;
        });
    }
}
