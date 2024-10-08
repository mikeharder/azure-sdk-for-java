// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.batch.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Specifies the security profile settings for the virtual machine or virtual machine scale set.
 */
@Fluent
public final class SecurityProfile implements JsonSerializable<SecurityProfile> {
    /*
     * Specifies the SecurityType of the virtual machine. It has to be set to any specified value to enable
     * UefiSettings.
     */
    private SecurityTypes securityType;

    /*
     * This property can be used by user in the request to enable or disable the Host Encryption for the virtual machine
     * or virtual machine scale set. This will enable the encryption for all the disks including Resource/Temp disk at
     * host itself.
     */
    private Boolean encryptionAtHost;

    /*
     * Specifies the security settings like secure boot and vTPM used while creating the virtual machine.
     */
    private UefiSettings uefiSettings;

    /**
     * Creates an instance of SecurityProfile class.
     */
    public SecurityProfile() {
    }

    /**
     * Get the securityType property: Specifies the SecurityType of the virtual machine. It has to be set to any
     * specified value to enable UefiSettings.
     * 
     * @return the securityType value.
     */
    public SecurityTypes securityType() {
        return this.securityType;
    }

    /**
     * Set the securityType property: Specifies the SecurityType of the virtual machine. It has to be set to any
     * specified value to enable UefiSettings.
     * 
     * @param securityType the securityType value to set.
     * @return the SecurityProfile object itself.
     */
    public SecurityProfile withSecurityType(SecurityTypes securityType) {
        this.securityType = securityType;
        return this;
    }

    /**
     * Get the encryptionAtHost property: This property can be used by user in the request to enable or disable the Host
     * Encryption for the virtual machine or virtual machine scale set. This will enable the encryption for all the
     * disks including Resource/Temp disk at host itself.
     * 
     * @return the encryptionAtHost value.
     */
    public Boolean encryptionAtHost() {
        return this.encryptionAtHost;
    }

    /**
     * Set the encryptionAtHost property: This property can be used by user in the request to enable or disable the Host
     * Encryption for the virtual machine or virtual machine scale set. This will enable the encryption for all the
     * disks including Resource/Temp disk at host itself.
     * 
     * @param encryptionAtHost the encryptionAtHost value to set.
     * @return the SecurityProfile object itself.
     */
    public SecurityProfile withEncryptionAtHost(Boolean encryptionAtHost) {
        this.encryptionAtHost = encryptionAtHost;
        return this;
    }

    /**
     * Get the uefiSettings property: Specifies the security settings like secure boot and vTPM used while creating the
     * virtual machine.
     * 
     * @return the uefiSettings value.
     */
    public UefiSettings uefiSettings() {
        return this.uefiSettings;
    }

    /**
     * Set the uefiSettings property: Specifies the security settings like secure boot and vTPM used while creating the
     * virtual machine.
     * 
     * @param uefiSettings the uefiSettings value to set.
     * @return the SecurityProfile object itself.
     */
    public SecurityProfile withUefiSettings(UefiSettings uefiSettings) {
        this.uefiSettings = uefiSettings;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (uefiSettings() != null) {
            uefiSettings().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("securityType", this.securityType == null ? null : this.securityType.toString());
        jsonWriter.writeBooleanField("encryptionAtHost", this.encryptionAtHost);
        jsonWriter.writeJsonField("uefiSettings", this.uefiSettings);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SecurityProfile from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SecurityProfile if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the SecurityProfile.
     */
    public static SecurityProfile fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SecurityProfile deserializedSecurityProfile = new SecurityProfile();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("securityType".equals(fieldName)) {
                    deserializedSecurityProfile.securityType = SecurityTypes.fromString(reader.getString());
                } else if ("encryptionAtHost".equals(fieldName)) {
                    deserializedSecurityProfile.encryptionAtHost = reader.getNullable(JsonReader::getBoolean);
                } else if ("uefiSettings".equals(fieldName)) {
                    deserializedSecurityProfile.uefiSettings = UefiSettings.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSecurityProfile;
        });
    }
}
