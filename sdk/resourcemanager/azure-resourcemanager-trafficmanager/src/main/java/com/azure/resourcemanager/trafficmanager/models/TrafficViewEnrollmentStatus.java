// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.trafficmanager.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Indicates whether Traffic View is 'Enabled' or 'Disabled' for the Traffic Manager profile. Null, indicates
 * 'Disabled'. Enabling this feature will increase the cost of the Traffic Manage profile.
 */
public final class TrafficViewEnrollmentStatus extends ExpandableStringEnum<TrafficViewEnrollmentStatus> {
    /**
     * Static value Enabled for TrafficViewEnrollmentStatus.
     */
    public static final TrafficViewEnrollmentStatus ENABLED = fromString("Enabled");

    /**
     * Static value Disabled for TrafficViewEnrollmentStatus.
     */
    public static final TrafficViewEnrollmentStatus DISABLED = fromString("Disabled");

    /**
     * Creates a new instance of TrafficViewEnrollmentStatus value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public TrafficViewEnrollmentStatus() {
    }

    /**
     * Creates or finds a TrafficViewEnrollmentStatus from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding TrafficViewEnrollmentStatus.
     */
    public static TrafficViewEnrollmentStatus fromString(String name) {
        return fromString(name, TrafficViewEnrollmentStatus.class);
    }

    /**
     * Gets known TrafficViewEnrollmentStatus values.
     * 
     * @return known TrafficViewEnrollmentStatus values.
     */
    public static Collection<TrafficViewEnrollmentStatus> values() {
        return values(TrafficViewEnrollmentStatus.class);
    }
}
