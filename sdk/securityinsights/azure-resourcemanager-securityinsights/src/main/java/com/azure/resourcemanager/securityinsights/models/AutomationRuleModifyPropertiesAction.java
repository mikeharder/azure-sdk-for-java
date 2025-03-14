// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Describes an automation rule action to modify an object's properties.
 */
@Fluent
public final class AutomationRuleModifyPropertiesAction extends AutomationRuleAction {
    /*
     * The type of the automation rule action.
     */
    private ActionType actionType = ActionType.MODIFY_PROPERTIES;

    /*
     * The actionConfiguration property.
     */
    private IncidentPropertiesAction actionConfiguration;

    /**
     * Creates an instance of AutomationRuleModifyPropertiesAction class.
     */
    public AutomationRuleModifyPropertiesAction() {
    }

    /**
     * Get the actionType property: The type of the automation rule action.
     * 
     * @return the actionType value.
     */
    @Override
    public ActionType actionType() {
        return this.actionType;
    }

    /**
     * Get the actionConfiguration property: The actionConfiguration property.
     * 
     * @return the actionConfiguration value.
     */
    public IncidentPropertiesAction actionConfiguration() {
        return this.actionConfiguration;
    }

    /**
     * Set the actionConfiguration property: The actionConfiguration property.
     * 
     * @param actionConfiguration the actionConfiguration value to set.
     * @return the AutomationRuleModifyPropertiesAction object itself.
     */
    public AutomationRuleModifyPropertiesAction withActionConfiguration(IncidentPropertiesAction actionConfiguration) {
        this.actionConfiguration = actionConfiguration;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AutomationRuleModifyPropertiesAction withOrder(int order) {
        super.withOrder(order);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (actionConfiguration() != null) {
            actionConfiguration().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeIntField("order", order());
        jsonWriter.writeStringField("actionType", this.actionType == null ? null : this.actionType.toString());
        jsonWriter.writeJsonField("actionConfiguration", this.actionConfiguration);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AutomationRuleModifyPropertiesAction from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AutomationRuleModifyPropertiesAction if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the AutomationRuleModifyPropertiesAction.
     */
    public static AutomationRuleModifyPropertiesAction fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AutomationRuleModifyPropertiesAction deserializedAutomationRuleModifyPropertiesAction
                = new AutomationRuleModifyPropertiesAction();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("order".equals(fieldName)) {
                    deserializedAutomationRuleModifyPropertiesAction.withOrder(reader.getInt());
                } else if ("actionType".equals(fieldName)) {
                    deserializedAutomationRuleModifyPropertiesAction.actionType
                        = ActionType.fromString(reader.getString());
                } else if ("actionConfiguration".equals(fieldName)) {
                    deserializedAutomationRuleModifyPropertiesAction.actionConfiguration
                        = IncidentPropertiesAction.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAutomationRuleModifyPropertiesAction;
        });
    }
}
