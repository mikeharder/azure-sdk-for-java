// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.migration.assessment.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Class representing Azure SQL IAAS SKU.
 */
@Immutable
public final class AzureSqlIaasSkuDto implements JsonSerializable<AzureSqlIaasSkuDto> {
    /*
     * Gets the The Azure Compute Virtual Machine.
     */
    private AzureVirtualMachineSkuDto virtualMachineSize;

    /*
     * Gets the The list of data disk sizes.
     */
    private List<AzureManagedDiskSkuDto> dataDiskSizes;

    /*
     * Gets the The list of log disk sizes.
     */
    private List<AzureManagedDiskSkuDto> logDiskSizes;

    /*
     * Gets the target type.
     */
    private TargetType azureSqlTargetType;

    /**
     * Creates an instance of AzureSqlIaasSkuDto class.
     */
    public AzureSqlIaasSkuDto() {
    }

    /**
     * Get the virtualMachineSize property: Gets the The Azure Compute Virtual Machine.
     * 
     * @return the virtualMachineSize value.
     */
    public AzureVirtualMachineSkuDto virtualMachineSize() {
        return this.virtualMachineSize;
    }

    /**
     * Get the dataDiskSizes property: Gets the The list of data disk sizes.
     * 
     * @return the dataDiskSizes value.
     */
    public List<AzureManagedDiskSkuDto> dataDiskSizes() {
        return this.dataDiskSizes;
    }

    /**
     * Get the logDiskSizes property: Gets the The list of log disk sizes.
     * 
     * @return the logDiskSizes value.
     */
    public List<AzureManagedDiskSkuDto> logDiskSizes() {
        return this.logDiskSizes;
    }

    /**
     * Get the azureSqlTargetType property: Gets the target type.
     * 
     * @return the azureSqlTargetType value.
     */
    public TargetType azureSqlTargetType() {
        return this.azureSqlTargetType;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (virtualMachineSize() != null) {
            virtualMachineSize().validate();
        }
        if (dataDiskSizes() != null) {
            dataDiskSizes().forEach(e -> e.validate());
        }
        if (logDiskSizes() != null) {
            logDiskSizes().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AzureSqlIaasSkuDto from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AzureSqlIaasSkuDto if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the AzureSqlIaasSkuDto.
     */
    public static AzureSqlIaasSkuDto fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AzureSqlIaasSkuDto deserializedAzureSqlIaasSkuDto = new AzureSqlIaasSkuDto();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("virtualMachineSize".equals(fieldName)) {
                    deserializedAzureSqlIaasSkuDto.virtualMachineSize = AzureVirtualMachineSkuDto.fromJson(reader);
                } else if ("dataDiskSizes".equals(fieldName)) {
                    List<AzureManagedDiskSkuDto> dataDiskSizes
                        = reader.readArray(reader1 -> AzureManagedDiskSkuDto.fromJson(reader1));
                    deserializedAzureSqlIaasSkuDto.dataDiskSizes = dataDiskSizes;
                } else if ("logDiskSizes".equals(fieldName)) {
                    List<AzureManagedDiskSkuDto> logDiskSizes
                        = reader.readArray(reader1 -> AzureManagedDiskSkuDto.fromJson(reader1));
                    deserializedAzureSqlIaasSkuDto.logDiskSizes = logDiskSizes;
                } else if ("azureSqlTargetType".equals(fieldName)) {
                    deserializedAzureSqlIaasSkuDto.azureSqlTargetType = TargetType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAzureSqlIaasSkuDto;
        });
    }
}
