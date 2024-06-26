// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.azurestackhci.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.azurestackhci.fluent.models.RouteTablePropertiesFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Route table resource. */
@Fluent
public final class RouteTable {
    /*
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag", access = JsonProperty.Access.WRITE_ONLY)
    private String etag;

    /*
     * Resource name.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    /*
     * Resource type.
     */
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private String type;

    /*
     * Properties of the route table.
     */
    @JsonProperty(value = "properties")
    private RouteTablePropertiesFormat innerProperties;

    /** Creates an instance of RouteTable class. */
    public RouteTable() {
    }

    /**
     * Get the etag property: A unique read-only string that changes whenever the resource is updated.
     *
     * @return the etag value.
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Get the name property: Resource name.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Get the type property: Resource type.
     *
     * @return the type value.
     */
    public String type() {
        return this.type;
    }

    /**
     * Get the innerProperties property: Properties of the route table.
     *
     * @return the innerProperties value.
     */
    private RouteTablePropertiesFormat innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the routes property: Collection of routes contained within a route table.
     *
     * @return the routes value.
     */
    public List<Route> routes() {
        return this.innerProperties() == null ? null : this.innerProperties().routes();
    }

    /**
     * Set the routes property: Collection of routes contained within a route table.
     *
     * @param routes the routes value to set.
     * @return the RouteTable object itself.
     */
    public RouteTable withRoutes(List<Route> routes) {
        if (this.innerProperties() == null) {
            this.innerProperties = new RouteTablePropertiesFormat();
        }
        this.innerProperties().withRoutes(routes);
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
}
