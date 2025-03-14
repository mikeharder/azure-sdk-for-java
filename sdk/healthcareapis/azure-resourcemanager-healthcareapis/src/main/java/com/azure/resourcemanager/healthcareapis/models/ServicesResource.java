// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.healthcareapis.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.Resource;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.Map;

/**
 * The common properties of a service.
 */
@Fluent
public class ServicesResource extends Resource {
    /*
     * The kind of the service.
     */
    private Kind kind;

    /*
     * An etag associated with the resource, used for optimistic concurrency when editing it.
     */
    private String etag;

    /*
     * Setting indicating whether the service has a managed identity associated with it.
     */
    private ServicesResourceIdentity identity;

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
     * Creates an instance of ServicesResource class.
     */
    public ServicesResource() {
    }

    /**
     * Get the kind property: The kind of the service.
     * 
     * @return the kind value.
     */
    public Kind kind() {
        return this.kind;
    }

    /**
     * Set the kind property: The kind of the service.
     * 
     * @param kind the kind value to set.
     * @return the ServicesResource object itself.
     */
    public ServicesResource withKind(Kind kind) {
        this.kind = kind;
        return this;
    }

    /**
     * Get the etag property: An etag associated with the resource, used for optimistic concurrency when editing it.
     * 
     * @return the etag value.
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Set the etag property: An etag associated with the resource, used for optimistic concurrency when editing it.
     * 
     * @param etag the etag value to set.
     * @return the ServicesResource object itself.
     */
    public ServicesResource withEtag(String etag) {
        this.etag = etag;
        return this;
    }

    /**
     * Get the identity property: Setting indicating whether the service has a managed identity associated with it.
     * 
     * @return the identity value.
     */
    public ServicesResourceIdentity identity() {
        return this.identity;
    }

    /**
     * Set the identity property: Setting indicating whether the service has a managed identity associated with it.
     * 
     * @param identity the identity value to set.
     * @return the ServicesResource object itself.
     */
    public ServicesResource withIdentity(ServicesResourceIdentity identity) {
        this.identity = identity;
        return this;
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
    public ServicesResource withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ServicesResource withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (kind() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property kind in model ServicesResource"));
        }
        if (identity() != null) {
            identity().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ServicesResource.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("location", location());
        jsonWriter.writeMapField("tags", tags(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("kind", this.kind == null ? null : this.kind.toString());
        jsonWriter.writeStringField("etag", this.etag);
        jsonWriter.writeJsonField("identity", this.identity);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ServicesResource from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ServicesResource if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ServicesResource.
     */
    public static ServicesResource fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ServicesResource deserializedServicesResource = new ServicesResource();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedServicesResource.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedServicesResource.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedServicesResource.type = reader.getString();
                } else if ("location".equals(fieldName)) {
                    deserializedServicesResource.withLocation(reader.getString());
                } else if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedServicesResource.withTags(tags);
                } else if ("kind".equals(fieldName)) {
                    deserializedServicesResource.kind = Kind.fromString(reader.getString());
                } else if ("etag".equals(fieldName)) {
                    deserializedServicesResource.etag = reader.getString();
                } else if ("identity".equals(fieldName)) {
                    deserializedServicesResource.identity = ServicesResourceIdentity.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedServicesResource;
        });
    }
}
