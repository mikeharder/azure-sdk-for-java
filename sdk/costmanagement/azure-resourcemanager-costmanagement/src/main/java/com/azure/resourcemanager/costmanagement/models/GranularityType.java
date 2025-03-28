// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.costmanagement.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The granularity of rows in the forecast.
 */
public final class GranularityType extends ExpandableStringEnum<GranularityType> {
    /**
     * Static value Daily for GranularityType.
     */
    public static final GranularityType DAILY = fromString("Daily");

    /**
     * Creates a new instance of GranularityType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public GranularityType() {
    }

    /**
     * Creates or finds a GranularityType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding GranularityType.
     */
    public static GranularityType fromString(String name) {
        return fromString(name, GranularityType.class);
    }

    /**
     * Gets known GranularityType values.
     * 
     * @return known GranularityType values.
     */
    public static Collection<GranularityType> values() {
        return values(GranularityType.class);
    }
}
