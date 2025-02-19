// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Base class for backup policy. Workload-specific backup policies are derived from this class.
 */
@Fluent
public class ProtectionPolicy implements JsonSerializable<ProtectionPolicy> {
    /*
     * This property will be used as the discriminator for deciding the specific types in the polymorphic chain of
     * types.
     */
    private String backupManagementType = "ProtectionPolicy";

    /*
     * Number of items associated with this policy.
     */
    private Integer protectedItemsCount;

    /*
     * ResourceGuard Operation Requests
     */
    private List<String> resourceGuardOperationRequests;

    /**
     * Creates an instance of ProtectionPolicy class.
     */
    public ProtectionPolicy() {
    }

    /**
     * Get the backupManagementType property: This property will be used as the discriminator for deciding the specific
     * types in the polymorphic chain of types.
     * 
     * @return the backupManagementType value.
     */
    public String backupManagementType() {
        return this.backupManagementType;
    }

    /**
     * Get the protectedItemsCount property: Number of items associated with this policy.
     * 
     * @return the protectedItemsCount value.
     */
    public Integer protectedItemsCount() {
        return this.protectedItemsCount;
    }

    /**
     * Set the protectedItemsCount property: Number of items associated with this policy.
     * 
     * @param protectedItemsCount the protectedItemsCount value to set.
     * @return the ProtectionPolicy object itself.
     */
    public ProtectionPolicy withProtectedItemsCount(Integer protectedItemsCount) {
        this.protectedItemsCount = protectedItemsCount;
        return this;
    }

    /**
     * Get the resourceGuardOperationRequests property: ResourceGuard Operation Requests.
     * 
     * @return the resourceGuardOperationRequests value.
     */
    public List<String> resourceGuardOperationRequests() {
        return this.resourceGuardOperationRequests;
    }

    /**
     * Set the resourceGuardOperationRequests property: ResourceGuard Operation Requests.
     * 
     * @param resourceGuardOperationRequests the resourceGuardOperationRequests value to set.
     * @return the ProtectionPolicy object itself.
     */
    public ProtectionPolicy withResourceGuardOperationRequests(List<String> resourceGuardOperationRequests) {
        this.resourceGuardOperationRequests = resourceGuardOperationRequests;
        return this;
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
        jsonWriter.writeStringField("backupManagementType", this.backupManagementType);
        jsonWriter.writeNumberField("protectedItemsCount", this.protectedItemsCount);
        jsonWriter.writeArrayField("resourceGuardOperationRequests", this.resourceGuardOperationRequests,
            (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ProtectionPolicy from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ProtectionPolicy if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ProtectionPolicy.
     */
    public static ProtectionPolicy fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("backupManagementType".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("AzureWorkload".equals(discriminatorValue)) {
                    return AzureVmWorkloadProtectionPolicy.fromJson(readerToUse.reset());
                } else if ("AzureStorage".equals(discriminatorValue)) {
                    return AzureFileShareProtectionPolicy.fromJson(readerToUse.reset());
                } else if ("AzureIaasVM".equals(discriminatorValue)) {
                    return AzureIaaSvmProtectionPolicy.fromJson(readerToUse.reset());
                } else if ("AzureSql".equals(discriminatorValue)) {
                    return AzureSqlProtectionPolicy.fromJson(readerToUse.reset());
                } else if ("GenericProtectionPolicy".equals(discriminatorValue)) {
                    return GenericProtectionPolicy.fromJson(readerToUse.reset());
                } else if ("MAB".equals(discriminatorValue)) {
                    return MabProtectionPolicy.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    static ProtectionPolicy fromJsonKnownDiscriminator(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ProtectionPolicy deserializedProtectionPolicy = new ProtectionPolicy();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("backupManagementType".equals(fieldName)) {
                    deserializedProtectionPolicy.backupManagementType = reader.getString();
                } else if ("protectedItemsCount".equals(fieldName)) {
                    deserializedProtectionPolicy.protectedItemsCount = reader.getNullable(JsonReader::getInt);
                } else if ("resourceGuardOperationRequests".equals(fieldName)) {
                    List<String> resourceGuardOperationRequests = reader.readArray(reader1 -> reader1.getString());
                    deserializedProtectionPolicy.resourceGuardOperationRequests = resourceGuardOperationRequests;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedProtectionPolicy;
        });
    }
}
