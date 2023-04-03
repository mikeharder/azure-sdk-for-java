// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.newrelicobservability.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Account Info of the NewRelic account. */
@Fluent
public final class AccountInfo {
    /*
     * Account id
     */
    @JsonProperty(value = "accountId")
    private String accountId;

    /*
     * ingestion key of account
     */
    @JsonProperty(value = "ingestionKey")
    private String ingestionKey;

    /*
     * NewRelic account region
     */
    @JsonProperty(value = "region")
    private String region;

    /** Creates an instance of AccountInfo class. */
    public AccountInfo() {
    }

    /**
     * Get the accountId property: Account id.
     *
     * @return the accountId value.
     */
    public String accountId() {
        return this.accountId;
    }

    /**
     * Set the accountId property: Account id.
     *
     * @param accountId the accountId value to set.
     * @return the AccountInfo object itself.
     */
    public AccountInfo withAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * Get the ingestionKey property: ingestion key of account.
     *
     * @return the ingestionKey value.
     */
    public String ingestionKey() {
        return this.ingestionKey;
    }

    /**
     * Set the ingestionKey property: ingestion key of account.
     *
     * @param ingestionKey the ingestionKey value to set.
     * @return the AccountInfo object itself.
     */
    public AccountInfo withIngestionKey(String ingestionKey) {
        this.ingestionKey = ingestionKey;
        return this;
    }

    /**
     * Get the region property: NewRelic account region.
     *
     * @return the region value.
     */
    public String region() {
        return this.region;
    }

    /**
     * Set the region property: NewRelic account region.
     *
     * @param region the region value to set.
     * @return the AccountInfo object itself.
     */
    public AccountInfo withRegion(String region) {
        this.region = region;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}