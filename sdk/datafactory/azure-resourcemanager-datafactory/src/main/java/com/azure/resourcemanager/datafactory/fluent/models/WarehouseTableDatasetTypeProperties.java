// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.fluent.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Microsoft Fabric Warehouse dataset properties.
 */
@Fluent
public final class WarehouseTableDatasetTypeProperties {
    /*
     * The schema name of the Microsoft Fabric Warehouse. Type: string (or Expression with resultType string).
     */
    @JsonProperty(value = "schema")
    private Object schema;

    /*
     * The table name of the Microsoft Fabric Warehouse. Type: string (or Expression with resultType string).
     */
    @JsonProperty(value = "table")
    private Object table;

    /**
     * Creates an instance of WarehouseTableDatasetTypeProperties class.
     */
    public WarehouseTableDatasetTypeProperties() {
    }

    /**
     * Get the schema property: The schema name of the Microsoft Fabric Warehouse. Type: string (or Expression with
     * resultType string).
     * 
     * @return the schema value.
     */
    public Object schema() {
        return this.schema;
    }

    /**
     * Set the schema property: The schema name of the Microsoft Fabric Warehouse. Type: string (or Expression with
     * resultType string).
     * 
     * @param schema the schema value to set.
     * @return the WarehouseTableDatasetTypeProperties object itself.
     */
    public WarehouseTableDatasetTypeProperties withSchema(Object schema) {
        this.schema = schema;
        return this;
    }

    /**
     * Get the table property: The table name of the Microsoft Fabric Warehouse. Type: string (or Expression with
     * resultType string).
     * 
     * @return the table value.
     */
    public Object table() {
        return this.table;
    }

    /**
     * Set the table property: The table name of the Microsoft Fabric Warehouse. Type: string (or Expression with
     * resultType string).
     * 
     * @param table the table value to set.
     * @return the WarehouseTableDatasetTypeProperties object itself.
     */
    public WarehouseTableDatasetTypeProperties withTable(Object table) {
        this.table = table;
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
