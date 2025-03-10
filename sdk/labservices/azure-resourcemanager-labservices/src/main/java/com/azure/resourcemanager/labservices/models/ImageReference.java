// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.labservices.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Image reference information. Used in the virtual machine profile.
 */
@Fluent
public final class ImageReference implements JsonSerializable<ImageReference> {
    /*
     * Image resource ID
     */
    private String id;

    /*
     * The image offer if applicable.
     */
    private String offer;

    /*
     * The image publisher
     */
    private String publisher;

    /*
     * The image SKU
     */
    private String sku;

    /*
     * The image version specified on creation.
     */
    private String version;

    /*
     * The actual version of the image after use.
     */
    private String exactVersion;

    /**
     * Creates an instance of ImageReference class.
     */
    public ImageReference() {
    }

    /**
     * Get the id property: Image resource ID.
     * 
     * @return the id value.
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the id property: Image resource ID.
     * 
     * @param id the id value to set.
     * @return the ImageReference object itself.
     */
    public ImageReference withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the offer property: The image offer if applicable.
     * 
     * @return the offer value.
     */
    public String offer() {
        return this.offer;
    }

    /**
     * Set the offer property: The image offer if applicable.
     * 
     * @param offer the offer value to set.
     * @return the ImageReference object itself.
     */
    public ImageReference withOffer(String offer) {
        this.offer = offer;
        return this;
    }

    /**
     * Get the publisher property: The image publisher.
     * 
     * @return the publisher value.
     */
    public String publisher() {
        return this.publisher;
    }

    /**
     * Set the publisher property: The image publisher.
     * 
     * @param publisher the publisher value to set.
     * @return the ImageReference object itself.
     */
    public ImageReference withPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    /**
     * Get the sku property: The image SKU.
     * 
     * @return the sku value.
     */
    public String sku() {
        return this.sku;
    }

    /**
     * Set the sku property: The image SKU.
     * 
     * @param sku the sku value to set.
     * @return the ImageReference object itself.
     */
    public ImageReference withSku(String sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get the version property: The image version specified on creation.
     * 
     * @return the version value.
     */
    public String version() {
        return this.version;
    }

    /**
     * Set the version property: The image version specified on creation.
     * 
     * @param version the version value to set.
     * @return the ImageReference object itself.
     */
    public ImageReference withVersion(String version) {
        this.version = version;
        return this;
    }

    /**
     * Get the exactVersion property: The actual version of the image after use.
     * 
     * @return the exactVersion value.
     */
    public String exactVersion() {
        return this.exactVersion;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("id", this.id);
        jsonWriter.writeStringField("offer", this.offer);
        jsonWriter.writeStringField("publisher", this.publisher);
        jsonWriter.writeStringField("sku", this.sku);
        jsonWriter.writeStringField("version", this.version);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ImageReference from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ImageReference if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ImageReference.
     */
    public static ImageReference fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ImageReference deserializedImageReference = new ImageReference();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedImageReference.id = reader.getString();
                } else if ("offer".equals(fieldName)) {
                    deserializedImageReference.offer = reader.getString();
                } else if ("publisher".equals(fieldName)) {
                    deserializedImageReference.publisher = reader.getString();
                } else if ("sku".equals(fieldName)) {
                    deserializedImageReference.sku = reader.getString();
                } else if ("version".equals(fieldName)) {
                    deserializedImageReference.version = reader.getString();
                } else if ("exactVersion".equals(fieldName)) {
                    deserializedImageReference.exactVersion = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedImageReference;
        });
    }
}
