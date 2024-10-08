// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.Resource;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.network.models.ProtocolType;
import com.azure.resourcemanager.network.models.ProvisioningState;
import com.azure.resourcemanager.network.models.QosDefinition;
import com.azure.resourcemanager.network.models.QosIpRange;
import com.azure.resourcemanager.network.models.QosPortRange;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Differentiated Services Code Point configuration for any given network interface.
 */
@Fluent
public final class DscpConfigurationInner extends Resource {
    /*
     * Properties of the network interface.
     */
    private DscpConfigurationPropertiesFormat innerProperties;

    /*
     * A unique read-only string that changes whenever the resource is updated.
     */
    private String etag;

    /*
     * Resource ID.
     */
    private String id;

    /*
     * The type of the resource.
     */
    private String type;

    /*
     * The name of the resource.
     */
    private String name;

    /**
     * Creates an instance of DscpConfigurationInner class.
     */
    public DscpConfigurationInner() {
    }

    /**
     * Get the innerProperties property: Properties of the network interface.
     * 
     * @return the innerProperties value.
     */
    private DscpConfigurationPropertiesFormat innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the etag property: A unique read-only string that changes whenever the resource is updated.
     * 
     * @return the etag value.
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Get the id property: Resource ID.
     * 
     * @return the id value.
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the id property: Resource ID.
     * 
     * @param id the id value to set.
     * @return the DscpConfigurationInner object itself.
     */
    public DscpConfigurationInner withId(String id) {
        this.id = id;
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
     * {@inheritDoc}
     */
    @Override
    public DscpConfigurationInner withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DscpConfigurationInner withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Get the markings property: List of markings to be used in the configuration.
     * 
     * @return the markings value.
     */
    public List<Integer> markings() {
        return this.innerProperties() == null ? null : this.innerProperties().markings();
    }

    /**
     * Set the markings property: List of markings to be used in the configuration.
     * 
     * @param markings the markings value to set.
     * @return the DscpConfigurationInner object itself.
     */
    public DscpConfigurationInner withMarkings(List<Integer> markings) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DscpConfigurationPropertiesFormat();
        }
        this.innerProperties().withMarkings(markings);
        return this;
    }

    /**
     * Get the sourceIpRanges property: Source IP ranges.
     * 
     * @return the sourceIpRanges value.
     */
    public List<QosIpRange> sourceIpRanges() {
        return this.innerProperties() == null ? null : this.innerProperties().sourceIpRanges();
    }

    /**
     * Set the sourceIpRanges property: Source IP ranges.
     * 
     * @param sourceIpRanges the sourceIpRanges value to set.
     * @return the DscpConfigurationInner object itself.
     */
    public DscpConfigurationInner withSourceIpRanges(List<QosIpRange> sourceIpRanges) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DscpConfigurationPropertiesFormat();
        }
        this.innerProperties().withSourceIpRanges(sourceIpRanges);
        return this;
    }

    /**
     * Get the destinationIpRanges property: Destination IP ranges.
     * 
     * @return the destinationIpRanges value.
     */
    public List<QosIpRange> destinationIpRanges() {
        return this.innerProperties() == null ? null : this.innerProperties().destinationIpRanges();
    }

    /**
     * Set the destinationIpRanges property: Destination IP ranges.
     * 
     * @param destinationIpRanges the destinationIpRanges value to set.
     * @return the DscpConfigurationInner object itself.
     */
    public DscpConfigurationInner withDestinationIpRanges(List<QosIpRange> destinationIpRanges) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DscpConfigurationPropertiesFormat();
        }
        this.innerProperties().withDestinationIpRanges(destinationIpRanges);
        return this;
    }

    /**
     * Get the sourcePortRanges property: Sources port ranges.
     * 
     * @return the sourcePortRanges value.
     */
    public List<QosPortRange> sourcePortRanges() {
        return this.innerProperties() == null ? null : this.innerProperties().sourcePortRanges();
    }

    /**
     * Set the sourcePortRanges property: Sources port ranges.
     * 
     * @param sourcePortRanges the sourcePortRanges value to set.
     * @return the DscpConfigurationInner object itself.
     */
    public DscpConfigurationInner withSourcePortRanges(List<QosPortRange> sourcePortRanges) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DscpConfigurationPropertiesFormat();
        }
        this.innerProperties().withSourcePortRanges(sourcePortRanges);
        return this;
    }

    /**
     * Get the destinationPortRanges property: Destination port ranges.
     * 
     * @return the destinationPortRanges value.
     */
    public List<QosPortRange> destinationPortRanges() {
        return this.innerProperties() == null ? null : this.innerProperties().destinationPortRanges();
    }

    /**
     * Set the destinationPortRanges property: Destination port ranges.
     * 
     * @param destinationPortRanges the destinationPortRanges value to set.
     * @return the DscpConfigurationInner object itself.
     */
    public DscpConfigurationInner withDestinationPortRanges(List<QosPortRange> destinationPortRanges) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DscpConfigurationPropertiesFormat();
        }
        this.innerProperties().withDestinationPortRanges(destinationPortRanges);
        return this;
    }

    /**
     * Get the protocol property: RNM supported protocol types.
     * 
     * @return the protocol value.
     */
    public ProtocolType protocol() {
        return this.innerProperties() == null ? null : this.innerProperties().protocol();
    }

    /**
     * Set the protocol property: RNM supported protocol types.
     * 
     * @param protocol the protocol value to set.
     * @return the DscpConfigurationInner object itself.
     */
    public DscpConfigurationInner withProtocol(ProtocolType protocol) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DscpConfigurationPropertiesFormat();
        }
        this.innerProperties().withProtocol(protocol);
        return this;
    }

    /**
     * Get the qosDefinitionCollection property: QoS object definitions.
     * 
     * @return the qosDefinitionCollection value.
     */
    public List<QosDefinition> qosDefinitionCollection() {
        return this.innerProperties() == null ? null : this.innerProperties().qosDefinitionCollection();
    }

    /**
     * Set the qosDefinitionCollection property: QoS object definitions.
     * 
     * @param qosDefinitionCollection the qosDefinitionCollection value to set.
     * @return the DscpConfigurationInner object itself.
     */
    public DscpConfigurationInner withQosDefinitionCollection(List<QosDefinition> qosDefinitionCollection) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DscpConfigurationPropertiesFormat();
        }
        this.innerProperties().withQosDefinitionCollection(qosDefinitionCollection);
        return this;
    }

    /**
     * Get the qosCollectionId property: Qos Collection ID generated by RNM.
     * 
     * @return the qosCollectionId value.
     */
    public String qosCollectionId() {
        return this.innerProperties() == null ? null : this.innerProperties().qosCollectionId();
    }

    /**
     * Get the associatedNetworkInterfaces property: Associated Network Interfaces to the DSCP Configuration.
     * 
     * @return the associatedNetworkInterfaces value.
     */
    public List<NetworkInterfaceInner> associatedNetworkInterfaces() {
        return this.innerProperties() == null ? null : this.innerProperties().associatedNetworkInterfaces();
    }

    /**
     * Get the resourceGuid property: The resource GUID property of the DSCP Configuration resource.
     * 
     * @return the resourceGuid value.
     */
    public String resourceGuid() {
        return this.innerProperties() == null ? null : this.innerProperties().resourceGuid();
    }

    /**
     * Get the provisioningState property: The provisioning state of the DSCP Configuration resource.
     * 
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.innerProperties() == null ? null : this.innerProperties().provisioningState();
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("location", location());
        jsonWriter.writeMapField("tags", tags(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeJsonField("properties", this.innerProperties);
        jsonWriter.writeStringField("id", this.id);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DscpConfigurationInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DscpConfigurationInner if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the DscpConfigurationInner.
     */
    public static DscpConfigurationInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DscpConfigurationInner deserializedDscpConfigurationInner = new DscpConfigurationInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedDscpConfigurationInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedDscpConfigurationInner.type = reader.getString();
                } else if ("location".equals(fieldName)) {
                    deserializedDscpConfigurationInner.withLocation(reader.getString());
                } else if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedDscpConfigurationInner.withTags(tags);
                } else if ("properties".equals(fieldName)) {
                    deserializedDscpConfigurationInner.innerProperties
                        = DscpConfigurationPropertiesFormat.fromJson(reader);
                } else if ("etag".equals(fieldName)) {
                    deserializedDscpConfigurationInner.etag = reader.getString();
                } else if ("id".equals(fieldName)) {
                    deserializedDscpConfigurationInner.id = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDscpConfigurationInner;
        });
    }
}
