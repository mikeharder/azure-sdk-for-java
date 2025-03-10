// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devcenter.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The type of data a parameter accepts.
 */
public final class ParameterType extends ExpandableStringEnum<ParameterType> {
    /**
     * Static value array for ParameterType.
     */
    public static final ParameterType ARRAY = fromString("array");

    /**
     * Static value boolean for ParameterType.
     */
    public static final ParameterType BOOLEAN = fromString("boolean");

    /**
     * Static value integer for ParameterType.
     */
    public static final ParameterType INTEGER = fromString("integer");

    /**
     * Static value number for ParameterType.
     */
    public static final ParameterType NUMBER = fromString("number");

    /**
     * Static value object for ParameterType.
     */
    public static final ParameterType OBJECT = fromString("object");

    /**
     * Static value string for ParameterType.
     */
    public static final ParameterType STRING = fromString("string");

    /**
     * Creates a new instance of ParameterType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public ParameterType() {
    }

    /**
     * Creates or finds a ParameterType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding ParameterType.
     */
    public static ParameterType fromString(String name) {
        return fromString(name, ParameterType.class);
    }

    /**
     * Gets known ParameterType values.
     * 
     * @return known ParameterType values.
     */
    public static Collection<ParameterType> values() {
        return values(ParameterType.class);
    }
}
