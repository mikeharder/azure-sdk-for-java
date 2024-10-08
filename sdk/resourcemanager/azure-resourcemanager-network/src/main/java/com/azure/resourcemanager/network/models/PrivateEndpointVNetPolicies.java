// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Private Endpoint VNet Policies.
 */
public final class PrivateEndpointVNetPolicies extends ExpandableStringEnum<PrivateEndpointVNetPolicies> {
    /**
     * Static value Disabled for PrivateEndpointVNetPolicies.
     */
    public static final PrivateEndpointVNetPolicies DISABLED = fromString("Disabled");

    /**
     * Static value Basic for PrivateEndpointVNetPolicies.
     */
    public static final PrivateEndpointVNetPolicies BASIC = fromString("Basic");

    /**
     * Creates a new instance of PrivateEndpointVNetPolicies value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public PrivateEndpointVNetPolicies() {
    }

    /**
     * Creates or finds a PrivateEndpointVNetPolicies from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding PrivateEndpointVNetPolicies.
     */
    public static PrivateEndpointVNetPolicies fromString(String name) {
        return fromString(name, PrivateEndpointVNetPolicies.class);
    }

    /**
     * Gets known PrivateEndpointVNetPolicies values.
     * 
     * @return known PrivateEndpointVNetPolicies values.
     */
    public static Collection<PrivateEndpointVNetPolicies> values() {
        return values(PrivateEndpointVNetPolicies.class);
    }
}
