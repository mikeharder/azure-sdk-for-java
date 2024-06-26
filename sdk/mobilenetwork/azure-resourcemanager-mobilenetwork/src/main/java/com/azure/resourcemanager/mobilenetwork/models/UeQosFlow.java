// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mobilenetwork.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * QoS Flow.
 */
@Fluent
public final class UeQosFlow {
    /*
     * Qos Flow Identifier
     */
    @JsonProperty(value = "qfi", required = true)
    private int qfi;

    /*
     * 5G QoS Identifier.
     */
    @JsonProperty(value = "fiveqi", required = true)
    private int fiveqi;

    /*
     * Maximum Bit Rate
     */
    @JsonProperty(value = "mbr")
    private Ambr mbr;

    /*
     * Guaranteed Bit Rate
     */
    @JsonProperty(value = "gbr")
    private Ambr gbr;

    /**
     * Creates an instance of UeQosFlow class.
     */
    public UeQosFlow() {
    }

    /**
     * Get the qfi property: Qos Flow Identifier.
     * 
     * @return the qfi value.
     */
    public int qfi() {
        return this.qfi;
    }

    /**
     * Set the qfi property: Qos Flow Identifier.
     * 
     * @param qfi the qfi value to set.
     * @return the UeQosFlow object itself.
     */
    public UeQosFlow withQfi(int qfi) {
        this.qfi = qfi;
        return this;
    }

    /**
     * Get the fiveqi property: 5G QoS Identifier.
     * 
     * @return the fiveqi value.
     */
    public int fiveqi() {
        return this.fiveqi;
    }

    /**
     * Set the fiveqi property: 5G QoS Identifier.
     * 
     * @param fiveqi the fiveqi value to set.
     * @return the UeQosFlow object itself.
     */
    public UeQosFlow withFiveqi(int fiveqi) {
        this.fiveqi = fiveqi;
        return this;
    }

    /**
     * Get the mbr property: Maximum Bit Rate.
     * 
     * @return the mbr value.
     */
    public Ambr mbr() {
        return this.mbr;
    }

    /**
     * Set the mbr property: Maximum Bit Rate.
     * 
     * @param mbr the mbr value to set.
     * @return the UeQosFlow object itself.
     */
    public UeQosFlow withMbr(Ambr mbr) {
        this.mbr = mbr;
        return this;
    }

    /**
     * Get the gbr property: Guaranteed Bit Rate.
     * 
     * @return the gbr value.
     */
    public Ambr gbr() {
        return this.gbr;
    }

    /**
     * Set the gbr property: Guaranteed Bit Rate.
     * 
     * @param gbr the gbr value to set.
     * @return the UeQosFlow object itself.
     */
    public UeQosFlow withGbr(Ambr gbr) {
        this.gbr = gbr;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (mbr() != null) {
            mbr().validate();
        }
        if (gbr() != null) {
            gbr().validate();
        }
    }
}
