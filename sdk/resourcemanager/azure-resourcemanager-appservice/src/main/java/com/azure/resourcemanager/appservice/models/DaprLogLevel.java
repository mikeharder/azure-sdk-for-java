// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Sets the log level for the Dapr sidecar. Allowed values are debug, info, warn, error. Default is info.
 */
public final class DaprLogLevel extends ExpandableStringEnum<DaprLogLevel> {
    /**
     * Static value info for DaprLogLevel.
     */
    public static final DaprLogLevel INFO = fromString("info");

    /**
     * Static value debug for DaprLogLevel.
     */
    public static final DaprLogLevel DEBUG = fromString("debug");

    /**
     * Static value warn for DaprLogLevel.
     */
    public static final DaprLogLevel WARN = fromString("warn");

    /**
     * Static value error for DaprLogLevel.
     */
    public static final DaprLogLevel ERROR = fromString("error");

    /**
     * Creates a new instance of DaprLogLevel value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public DaprLogLevel() {
    }

    /**
     * Creates or finds a DaprLogLevel from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding DaprLogLevel.
     */
    public static DaprLogLevel fromString(String name) {
        return fromString(name, DaprLogLevel.class);
    }

    /**
     * Gets known DaprLogLevel values.
     * 
     * @return known DaprLogLevel values.
     */
    public static Collection<DaprLogLevel> values() {
        return values(DaprLogLevel.class);
    }
}
