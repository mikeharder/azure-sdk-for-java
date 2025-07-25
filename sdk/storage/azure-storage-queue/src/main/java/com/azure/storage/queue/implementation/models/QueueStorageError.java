// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.storage.queue.implementation.models;

import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.xml.XmlReader;
import com.azure.xml.XmlSerializable;
import com.azure.xml.XmlToken;
import com.azure.xml.XmlWriter;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

/**
 * Represents an error response returned by the Azure Storage Queues service.
 */
public final class QueueStorageError
    implements JsonSerializable<QueueStorageError>, XmlSerializable<QueueStorageError> {
    private String code;
    private String message;
    private String queryParameterName;
    private String queryParameterValue;
    private String reason;
    private String extendedErrorDetail;
    private String headerName;
    private String headerValue;

    private QueueStorageError() {
    }

    /**
     * Gets the error code returned by the Azure Storage Queues service.
     *
     * @return The error code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the error message returned by the Azure Storage Queues service.
     *
     * @return The error message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets the header name returned by the Azure Storage Shares service.
     *
     * @return The name of the header parameter.
     */
    public String getHeaderName() {
        return headerName;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        return jsonWriter.writeStartObject("Error")
            .writeStringField("Code", code)
            .writeStringField("Message", this.message)
            .writeStringField("QueryParameterName", this.queryParameterName)
            .writeStringField("QueryParameterValue", this.queryParameterValue)
            .writeStringField("Reason", this.reason)
            .writeStringField("ExtendedErrorDetail", this.extendedErrorDetail)
            .writeEndObject();
    }

    /**
     * Reads an instance of QueueStorageError from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of QueueStorageError if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the QueueStorageError.
     */
    public static QueueStorageError fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            // Buffer the next JSON object as QueueStorageError can take two forms:
            //
            // - A QueueStorageError object
            // - A QueueStorageError object wrapped in an "error" node.
            JsonReader bufferedReader = reader.bufferObject();
            bufferedReader.nextToken(); // Get to the START_OBJECT token.
            while (bufferedReader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = bufferedReader.getFieldName();
                bufferedReader.nextToken();

                if ("error".equals(fieldName)) {
                    // If the QueueStorageError was wrapped in the "error" node begin reading it now.
                    return readQueueError(bufferedReader);
                } else {
                    bufferedReader.skipChildren();
                }
            }

            // Otherwise reset the JsonReader and read the whole JSON object.
            return readQueueError(bufferedReader.reset());
        });
    }

    private static QueueStorageError readQueueError(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            QueueStorageError deserializedStorageError = new QueueStorageError();

            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("code".equals(fieldName)) {
                    deserializedStorageError.code = reader.getString();
                } else if ("message".equals(fieldName)) {
                    deserializedStorageError.message = reader.getString();
                } else if ("queryParameterName".equals(fieldName)) {
                    deserializedStorageError.queryParameterName = reader.getString();
                } else if ("queryParameterValue".equals(fieldName)) {
                    deserializedStorageError.queryParameterValue = reader.getString();
                } else if ("reason".equals(fieldName)) {
                    deserializedStorageError.reason = reader.getString();
                } else if ("extendedErrorDetail".equals(fieldName)) {
                    deserializedStorageError.extendedErrorDetail = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedStorageError;
        });
    }

    @Override
    public XmlWriter toXml(XmlWriter xmlWriter, String rootElementName) throws XMLStreamException {
        rootElementName = CoreUtils.isNullOrEmpty(rootElementName) ? "Error" : rootElementName;
        xmlWriter.writeStartElement(rootElementName);
        xmlWriter.writeStringElement("Code", code);
        xmlWriter.writeStringElement("Message", this.message);
        xmlWriter.writeStringElement("QueryParameterName", this.queryParameterName);
        xmlWriter.writeStringElement("QueryParameterValue", this.queryParameterValue);
        xmlWriter.writeStringElement("Reason", this.reason);
        xmlWriter.writeStringElement("ExtendedErrorDetail", this.extendedErrorDetail);
        xmlWriter.writeStringElement("HeaderName", this.headerName);
        xmlWriter.writeStringElement("HeaderValue", this.headerValue);
        return xmlWriter.writeEndElement();
    }

    /**
     * Reads an instance of QueueStorageError from the XmlReader.
     *
     * @param xmlReader The XmlReader being read.
     * @return An instance of QueueStorageError if the XmlReader was pointing to an instance of it, or null if it was
     * pointing to XML null.
     * @throws XMLStreamException If an error occurs while reading the QueueStorageError.
     */
    public static QueueStorageError fromXml(XmlReader xmlReader) throws XMLStreamException {
        return fromXml(xmlReader, null);
    }

    /**
     * Reads an instance of QueueStorageError from the XmlReader.
     *
     * @param xmlReader The XmlReader being read.
     * @param rootElementName Optional root element name to override the default defined by the model. Used to support
     * cases where the model can deserialize from different root element names.
     * @return An instance of QueueStorageError if the XmlReader was pointing to an instance of it, or null if it was
     * pointing to XML null.
     * @throws XMLStreamException If an error occurs while reading the QueueStorageError.
     */
    public static QueueStorageError fromXml(XmlReader xmlReader, String rootElementName) throws XMLStreamException {
        String finalRootElementName = CoreUtils.isNullOrEmpty(rootElementName) ? "Error" : rootElementName;
        return xmlReader.readObject(finalRootElementName, reader -> {
            QueueStorageError deserializedStorageError = new QueueStorageError();
            while (reader.nextElement() != XmlToken.END_ELEMENT) {
                QName elementName = reader.getElementName();

                if ("Code".equals(elementName.getLocalPart())) {
                    deserializedStorageError.code = reader.getStringElement();
                } else if ("Message".equals(elementName.getLocalPart())) {
                    deserializedStorageError.message = reader.getStringElement();
                } else if ("QueryParameterName".equals(elementName.getLocalPart())) {
                    deserializedStorageError.queryParameterName = reader.getStringElement();
                } else if ("QueryParameterValue".equals(elementName.getLocalPart())) {
                    deserializedStorageError.queryParameterValue = reader.getStringElement();
                } else if ("Reason".equals(elementName.getLocalPart())) {
                    deserializedStorageError.reason = reader.getStringElement();
                } else if ("ExtendedErrorDetail".equals(elementName.getLocalPart())) {
                    deserializedStorageError.extendedErrorDetail = reader.getStringElement();
                } else if ("HeaderName".equals(elementName.getLocalPart())) {
                    deserializedStorageError.headerName = reader.getStringElement();
                } else if ("HeaderValue".equals(elementName.getLocalPart())) {
                    deserializedStorageError.headerValue = reader.getStringElement();
                }
            }

            return deserializedStorageError;
        });
    }
}
