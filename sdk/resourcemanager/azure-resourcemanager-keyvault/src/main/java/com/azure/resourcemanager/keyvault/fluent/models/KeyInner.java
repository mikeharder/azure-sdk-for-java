// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.keyvault.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.Resource;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.keyvault.models.JsonWebKeyCurveName;
import com.azure.resourcemanager.keyvault.models.JsonWebKeyOperation;
import com.azure.resourcemanager.keyvault.models.JsonWebKeyType;
import com.azure.resourcemanager.keyvault.models.KeyAttributes;
import com.azure.resourcemanager.keyvault.models.KeyReleasePolicy;
import com.azure.resourcemanager.keyvault.models.RotationPolicy;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The key resource.
 */
@Fluent
public final class KeyInner extends Resource {
    /*
     * The properties of the key.
     */
    private KeyProperties innerProperties = new KeyProperties();

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
     * Creates an instance of KeyInner class.
     */
    public KeyInner() {
    }

    /**
     * Get the innerProperties property: The properties of the key.
     * 
     * @return the innerProperties value.
     */
    private KeyProperties innerProperties() {
        return this.innerProperties;
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
     * {@inheritDoc}
     */
    @Override
    public KeyInner withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public KeyInner withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Get the attributes property: The attributes of the key.
     * 
     * @return the attributes value.
     */
    public KeyAttributes attributes() {
        return this.innerProperties() == null ? null : this.innerProperties().attributes();
    }

    /**
     * Set the attributes property: The attributes of the key.
     * 
     * @param attributes the attributes value to set.
     * @return the KeyInner object itself.
     */
    public KeyInner withAttributes(KeyAttributes attributes) {
        if (this.innerProperties() == null) {
            this.innerProperties = new KeyProperties();
        }
        this.innerProperties().withAttributes(attributes);
        return this;
    }

    /**
     * Get the kty property: The type of the key. For valid values, see JsonWebKeyType.
     * 
     * @return the kty value.
     */
    public JsonWebKeyType kty() {
        return this.innerProperties() == null ? null : this.innerProperties().kty();
    }

    /**
     * Set the kty property: The type of the key. For valid values, see JsonWebKeyType.
     * 
     * @param kty the kty value to set.
     * @return the KeyInner object itself.
     */
    public KeyInner withKty(JsonWebKeyType kty) {
        if (this.innerProperties() == null) {
            this.innerProperties = new KeyProperties();
        }
        this.innerProperties().withKty(kty);
        return this;
    }

    /**
     * Get the keyOps property: The keyOps property.
     * 
     * @return the keyOps value.
     */
    public List<JsonWebKeyOperation> keyOps() {
        return this.innerProperties() == null ? null : this.innerProperties().keyOps();
    }

    /**
     * Set the keyOps property: The keyOps property.
     * 
     * @param keyOps the keyOps value to set.
     * @return the KeyInner object itself.
     */
    public KeyInner withKeyOps(List<JsonWebKeyOperation> keyOps) {
        if (this.innerProperties() == null) {
            this.innerProperties = new KeyProperties();
        }
        this.innerProperties().withKeyOps(keyOps);
        return this;
    }

    /**
     * Get the keySize property: The key size in bits. For example: 2048, 3072, or 4096 for RSA. Default for RSA and
     * RSA-HSM keys is 2048. Exception made for bring your own key (BYOK), key exchange keys default to 4096.
     * 
     * @return the keySize value.
     */
    public Integer keySize() {
        return this.innerProperties() == null ? null : this.innerProperties().keySize();
    }

    /**
     * Set the keySize property: The key size in bits. For example: 2048, 3072, or 4096 for RSA. Default for RSA and
     * RSA-HSM keys is 2048. Exception made for bring your own key (BYOK), key exchange keys default to 4096.
     * 
     * @param keySize the keySize value to set.
     * @return the KeyInner object itself.
     */
    public KeyInner withKeySize(Integer keySize) {
        if (this.innerProperties() == null) {
            this.innerProperties = new KeyProperties();
        }
        this.innerProperties().withKeySize(keySize);
        return this;
    }

    /**
     * Get the curveName property: The elliptic curve name. For valid values, see JsonWebKeyCurveName. Default for EC
     * and EC-HSM keys is P-256.
     * 
     * @return the curveName value.
     */
    public JsonWebKeyCurveName curveName() {
        return this.innerProperties() == null ? null : this.innerProperties().curveName();
    }

    /**
     * Set the curveName property: The elliptic curve name. For valid values, see JsonWebKeyCurveName. Default for EC
     * and EC-HSM keys is P-256.
     * 
     * @param curveName the curveName value to set.
     * @return the KeyInner object itself.
     */
    public KeyInner withCurveName(JsonWebKeyCurveName curveName) {
        if (this.innerProperties() == null) {
            this.innerProperties = new KeyProperties();
        }
        this.innerProperties().withCurveName(curveName);
        return this;
    }

    /**
     * Get the keyUri property: The URI to retrieve the current version of the key.
     * 
     * @return the keyUri value.
     */
    public String keyUri() {
        return this.innerProperties() == null ? null : this.innerProperties().keyUri();
    }

    /**
     * Get the keyUriWithVersion property: The URI to retrieve the specific version of the key.
     * 
     * @return the keyUriWithVersion value.
     */
    public String keyUriWithVersion() {
        return this.innerProperties() == null ? null : this.innerProperties().keyUriWithVersion();
    }

    /**
     * Get the rotationPolicy property: Key rotation policy in response. It will be used for both output and input.
     * Omitted if empty.
     * 
     * @return the rotationPolicy value.
     */
    public RotationPolicy rotationPolicy() {
        return this.innerProperties() == null ? null : this.innerProperties().rotationPolicy();
    }

    /**
     * Set the rotationPolicy property: Key rotation policy in response. It will be used for both output and input.
     * Omitted if empty.
     * 
     * @param rotationPolicy the rotationPolicy value to set.
     * @return the KeyInner object itself.
     */
    public KeyInner withRotationPolicy(RotationPolicy rotationPolicy) {
        if (this.innerProperties() == null) {
            this.innerProperties = new KeyProperties();
        }
        this.innerProperties().withRotationPolicy(rotationPolicy);
        return this;
    }

    /**
     * Get the releasePolicy property: Key release policy in response. It will be used for both output and input.
     * Omitted if empty.
     * 
     * @return the releasePolicy value.
     */
    public KeyReleasePolicy releasePolicy() {
        return this.innerProperties() == null ? null : this.innerProperties().releasePolicy();
    }

    /**
     * Set the releasePolicy property: Key release policy in response. It will be used for both output and input.
     * Omitted if empty.
     * 
     * @param releasePolicy the releasePolicy value to set.
     * @return the KeyInner object itself.
     */
    public KeyInner withReleasePolicy(KeyReleasePolicy releasePolicy) {
        if (this.innerProperties() == null) {
            this.innerProperties = new KeyProperties();
        }
        this.innerProperties().withReleasePolicy(releasePolicy);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property innerProperties in model KeyInner"));
        } else {
            innerProperties().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(KeyInner.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("location", location());
        jsonWriter.writeMapField("tags", tags(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of KeyInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of KeyInner if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the KeyInner.
     */
    public static KeyInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            KeyInner deserializedKeyInner = new KeyInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedKeyInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedKeyInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedKeyInner.type = reader.getString();
                } else if ("location".equals(fieldName)) {
                    deserializedKeyInner.withLocation(reader.getString());
                } else if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedKeyInner.withTags(tags);
                } else if ("properties".equals(fieldName)) {
                    deserializedKeyInner.innerProperties = KeyProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedKeyInner;
        });
    }
}
