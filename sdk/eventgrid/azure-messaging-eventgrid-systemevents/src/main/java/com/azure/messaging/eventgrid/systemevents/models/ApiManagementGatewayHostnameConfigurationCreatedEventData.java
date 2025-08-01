// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.messaging.eventgrid.systemevents.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Schema of the Data property of an EventGridEvent for a Microsoft.ApiManagement.GatewayHostnameConfigurationCreated
 * event.
 */
@Immutable
public final class ApiManagementGatewayHostnameConfigurationCreatedEventData
    implements JsonSerializable<ApiManagementGatewayHostnameConfigurationCreatedEventData> {

    /*
     * The fully qualified ID of the resource that the compliance state change is for, including the resource name and
     * resource type. Uses the format,
     * `/subscriptions/<SubscriptionID>/resourceGroups/<ResourceGroup>/Microsoft.ApiManagement/service/<ServiceName>/
     * gateways/<GatewayName>/hostnameConfigurations/<ResourceName>`
     */
    @Generated
    private String resourceUrl;

    /**
     * Creates an instance of ApiManagementGatewayHostnameConfigurationCreatedEventData class.
     */
    @Generated
    private ApiManagementGatewayHostnameConfigurationCreatedEventData() {
    }

    /**
     * Get the resourceUrl property: The fully qualified ID of the resource that the compliance state change is for,
     * including the resource name and resource type. Uses the format,
     * `/subscriptions/&lt;SubscriptionID&gt;/resourceGroups/&lt;ResourceGroup&gt;/Microsoft.ApiManagement/service/&lt;ServiceName&gt;/gateways/&lt;GatewayName&gt;/hostnameConfigurations/&lt;ResourceName&gt;`.
     *
     * @return the resourceUrl value.
     */
    @Generated
    public String getResourceUrl() {
        return this.resourceUrl;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("resourceUri", this.resourceUrl);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ApiManagementGatewayHostnameConfigurationCreatedEventData from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of ApiManagementGatewayHostnameConfigurationCreatedEventData if the JsonReader was pointing
     * to an instance of it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the
     * ApiManagementGatewayHostnameConfigurationCreatedEventData.
     */
    @Generated
    public static ApiManagementGatewayHostnameConfigurationCreatedEventData fromJson(JsonReader jsonReader)
        throws IOException {
        return jsonReader.readObject(reader -> {
            ApiManagementGatewayHostnameConfigurationCreatedEventData deserializedApiManagementGatewayHostnameConfigurationCreatedEventData
                = new ApiManagementGatewayHostnameConfigurationCreatedEventData();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("resourceUri".equals(fieldName)) {
                    deserializedApiManagementGatewayHostnameConfigurationCreatedEventData.resourceUrl
                        = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            return deserializedApiManagementGatewayHostnameConfigurationCreatedEventData;
        });
    }
}
