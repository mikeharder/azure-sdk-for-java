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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Xml dataset.
 */
@Fluent
public class XmlDataset extends Dataset {
    /*
     * Type of dataset.
     */
    @Generated
    private String type = "Xml";

    /*
     * The location of the json data storage.
     */
    @Generated
    private DatasetLocation location;

    /*
     * The code page name of the preferred encoding. If not specified, the default value is UTF-8, unless BOM denotes
     * another Unicode encoding. Refer to the name column of the table in the following link to set supported values:
     * https://msdn.microsoft.com/library/system.text.encoding.aspx. Type: string (or Expression with resultType
     * string).
     */
    @Generated
    private Object encodingName;

    /*
     * The null value string. Type: string (or Expression with resultType string).
     */
    @Generated
    private Object nullValue;

    /*
     * The data compression method used for the json dataset.
     */
    @Generated
    private DatasetCompression compression;

    /**
     * Creates an instance of XmlDataset class.
     */
    @Generated
    public XmlDataset() {
    }

    /**
     * Get the type property: Type of dataset.
     * 
     * @return the type value.
     */
    @Generated
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Get the location property: The location of the json data storage.
     * 
     * @return the location value.
     */
    @Generated
    public DatasetLocation getLocation() {
        return this.location;
    }

    /**
     * Set the location property: The location of the json data storage.
     * 
     * @param location the location value to set.
     * @return the XmlDataset object itself.
     */
    @Generated
    public XmlDataset setLocation(DatasetLocation location) {
        this.location = location;
        return this;
    }

    /**
     * Get the encodingName property: The code page name of the preferred encoding. If not specified, the default value
     * is UTF-8, unless BOM denotes another Unicode encoding. Refer to the name column of the table in the following
     * link to set supported values: https://msdn.microsoft.com/library/system.text.encoding.aspx. Type: string (or
     * Expression with resultType string).
     * 
     * @return the encodingName value.
     */
    @Generated
    public Object getEncodingName() {
        return this.encodingName;
    }

    /**
     * Set the encodingName property: The code page name of the preferred encoding. If not specified, the default value
     * is UTF-8, unless BOM denotes another Unicode encoding. Refer to the name column of the table in the following
     * link to set supported values: https://msdn.microsoft.com/library/system.text.encoding.aspx. Type: string (or
     * Expression with resultType string).
     * 
     * @param encodingName the encodingName value to set.
     * @return the XmlDataset object itself.
     */
    @Generated
    public XmlDataset setEncodingName(Object encodingName) {
        this.encodingName = encodingName;
        return this;
    }

    /**
     * Get the nullValue property: The null value string. Type: string (or Expression with resultType string).
     * 
     * @return the nullValue value.
     */
    @Generated
    public Object getNullValue() {
        return this.nullValue;
    }

    /**
     * Set the nullValue property: The null value string. Type: string (or Expression with resultType string).
     * 
     * @param nullValue the nullValue value to set.
     * @return the XmlDataset object itself.
     */
    @Generated
    public XmlDataset setNullValue(Object nullValue) {
        this.nullValue = nullValue;
        return this;
    }

    /**
     * Get the compression property: The data compression method used for the json dataset.
     * 
     * @return the compression value.
     */
    @Generated
    public DatasetCompression getCompression() {
        return this.compression;
    }

    /**
     * Set the compression property: The data compression method used for the json dataset.
     * 
     * @param compression the compression value to set.
     * @return the XmlDataset object itself.
     */
    @Generated
    public XmlDataset setCompression(DatasetCompression compression) {
        this.compression = compression;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public XmlDataset setDescription(String description) {
        super.setDescription(description);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public XmlDataset setStructure(Object structure) {
        super.setStructure(structure);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public XmlDataset setSchema(Object schema) {
        super.setSchema(schema);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public XmlDataset setLinkedServiceName(LinkedServiceReference linkedServiceName) {
        super.setLinkedServiceName(linkedServiceName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public XmlDataset setParameters(Map<String, ParameterSpecification> parameters) {
        super.setParameters(parameters);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public XmlDataset setAnnotations(List<Object> annotations) {
        super.setAnnotations(annotations);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public XmlDataset setFolder(DatasetFolder folder) {
        super.setFolder(folder);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("linkedServiceName", getLinkedServiceName());
        jsonWriter.writeStringField("description", getDescription());
        if (getStructure() != null) {
            jsonWriter.writeUntypedField("structure", getStructure());
        }
        if (getSchema() != null) {
            jsonWriter.writeUntypedField("schema", getSchema());
        }
        jsonWriter.writeMapField("parameters", getParameters(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("annotations", getAnnotations(), (writer, element) -> writer.writeUntyped(element));
        jsonWriter.writeJsonField("folder", getFolder());
        jsonWriter.writeStringField("type", this.type);
        if (location != null || encodingName != null || nullValue != null || compression != null) {
            jsonWriter.writeStartObject("typeProperties");
            jsonWriter.writeJsonField("location", this.location);
            if (this.encodingName != null) {
                jsonWriter.writeUntypedField("encodingName", this.encodingName);
            }
            if (this.nullValue != null) {
                jsonWriter.writeUntypedField("nullValue", this.nullValue);
            }
            jsonWriter.writeJsonField("compression", this.compression);
            jsonWriter.writeEndObject();
        }
        if (getAdditionalProperties() != null) {
            for (Map.Entry<String, Object> additionalProperty : getAdditionalProperties().entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of XmlDataset from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of XmlDataset if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the XmlDataset.
     */
    @Generated
    public static XmlDataset fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            XmlDataset deserializedXmlDataset = new XmlDataset();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("linkedServiceName".equals(fieldName)) {
                    deserializedXmlDataset.setLinkedServiceName(LinkedServiceReference.fromJson(reader));
                } else if ("description".equals(fieldName)) {
                    deserializedXmlDataset.setDescription(reader.getString());
                } else if ("structure".equals(fieldName)) {
                    deserializedXmlDataset.setStructure(reader.readUntyped());
                } else if ("schema".equals(fieldName)) {
                    deserializedXmlDataset.setSchema(reader.readUntyped());
                } else if ("parameters".equals(fieldName)) {
                    Map<String, ParameterSpecification> parameters
                        = reader.readMap(reader1 -> ParameterSpecification.fromJson(reader1));
                    deserializedXmlDataset.setParameters(parameters);
                } else if ("annotations".equals(fieldName)) {
                    List<Object> annotations = reader.readArray(reader1 -> reader1.readUntyped());
                    deserializedXmlDataset.setAnnotations(annotations);
                } else if ("folder".equals(fieldName)) {
                    deserializedXmlDataset.setFolder(DatasetFolder.fromJson(reader));
                } else if ("type".equals(fieldName)) {
                    deserializedXmlDataset.type = reader.getString();
                } else if ("typeProperties".equals(fieldName) && reader.currentToken() == JsonToken.START_OBJECT) {
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("location".equals(fieldName)) {
                            deserializedXmlDataset.location = DatasetLocation.fromJson(reader);
                        } else if ("encodingName".equals(fieldName)) {
                            deserializedXmlDataset.encodingName = reader.readUntyped();
                        } else if ("nullValue".equals(fieldName)) {
                            deserializedXmlDataset.nullValue = reader.readUntyped();
                        } else if ("compression".equals(fieldName)) {
                            deserializedXmlDataset.compression = DatasetCompression.fromJson(reader);
                        } else {
                            reader.skipChildren();
                        }
                    }
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedXmlDataset.setAdditionalProperties(additionalProperties);

            return deserializedXmlDataset;
        });
    }
}
