// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.automation.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.automation.fluent.models.WebhookUpdateProperties;
import java.io.IOException;
import java.util.Map;

/**
 * The parameters supplied to the update webhook operation.
 */
@Fluent
public final class WebhookUpdateParameters implements JsonSerializable<WebhookUpdateParameters> {
    /*
     * Gets or sets the name of the webhook.
     */
    private String name;

    /*
     * Gets or sets the value of the webhook.
     */
    private WebhookUpdateProperties innerProperties;

    /**
     * Creates an instance of WebhookUpdateParameters class.
     */
    public WebhookUpdateParameters() {
    }

    /**
     * Get the name property: Gets or sets the name of the webhook.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Gets or sets the name of the webhook.
     * 
     * @param name the name value to set.
     * @return the WebhookUpdateParameters object itself.
     */
    public WebhookUpdateParameters withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the innerProperties property: Gets or sets the value of the webhook.
     * 
     * @return the innerProperties value.
     */
    private WebhookUpdateProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the isEnabled property: Gets or sets the value of the enabled flag of webhook.
     * 
     * @return the isEnabled value.
     */
    public Boolean isEnabled() {
        return this.innerProperties() == null ? null : this.innerProperties().isEnabled();
    }

    /**
     * Set the isEnabled property: Gets or sets the value of the enabled flag of webhook.
     * 
     * @param isEnabled the isEnabled value to set.
     * @return the WebhookUpdateParameters object itself.
     */
    public WebhookUpdateParameters withIsEnabled(Boolean isEnabled) {
        if (this.innerProperties() == null) {
            this.innerProperties = new WebhookUpdateProperties();
        }
        this.innerProperties().withIsEnabled(isEnabled);
        return this;
    }

    /**
     * Get the runOn property: Gets or sets the name of the hybrid worker group the webhook job will run on.
     * 
     * @return the runOn value.
     */
    public String runOn() {
        return this.innerProperties() == null ? null : this.innerProperties().runOn();
    }

    /**
     * Set the runOn property: Gets or sets the name of the hybrid worker group the webhook job will run on.
     * 
     * @param runOn the runOn value to set.
     * @return the WebhookUpdateParameters object itself.
     */
    public WebhookUpdateParameters withRunOn(String runOn) {
        if (this.innerProperties() == null) {
            this.innerProperties = new WebhookUpdateProperties();
        }
        this.innerProperties().withRunOn(runOn);
        return this;
    }

    /**
     * Get the parameters property: Gets or sets the parameters of the job.
     * 
     * @return the parameters value.
     */
    public Map<String, String> parameters() {
        return this.innerProperties() == null ? null : this.innerProperties().parameters();
    }

    /**
     * Set the parameters property: Gets or sets the parameters of the job.
     * 
     * @param parameters the parameters value to set.
     * @return the WebhookUpdateParameters object itself.
     */
    public WebhookUpdateParameters withParameters(Map<String, String> parameters) {
        if (this.innerProperties() == null) {
            this.innerProperties = new WebhookUpdateProperties();
        }
        this.innerProperties().withParameters(parameters);
        return this;
    }

    /**
     * Get the description property: Gets or sets the description of the webhook.
     * 
     * @return the description value.
     */
    public String description() {
        return this.innerProperties() == null ? null : this.innerProperties().description();
    }

    /**
     * Set the description property: Gets or sets the description of the webhook.
     * 
     * @param description the description value to set.
     * @return the WebhookUpdateParameters object itself.
     */
    public WebhookUpdateParameters withDescription(String description) {
        if (this.innerProperties() == null) {
            this.innerProperties = new WebhookUpdateProperties();
        }
        this.innerProperties().withDescription(description);
        return this;
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
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of WebhookUpdateParameters from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of WebhookUpdateParameters if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the WebhookUpdateParameters.
     */
    public static WebhookUpdateParameters fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            WebhookUpdateParameters deserializedWebhookUpdateParameters = new WebhookUpdateParameters();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedWebhookUpdateParameters.name = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedWebhookUpdateParameters.innerProperties = WebhookUpdateProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedWebhookUpdateParameters;
        });
    }
}
