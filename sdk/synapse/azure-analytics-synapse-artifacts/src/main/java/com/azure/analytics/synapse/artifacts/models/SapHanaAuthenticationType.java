// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The authentication type to be used to connect to the SAP HANA server.
 */
public final class SapHanaAuthenticationType extends ExpandableStringEnum<SapHanaAuthenticationType> {
    /**
     * Static value Basic for SapHanaAuthenticationType.
     */
    @Generated
    public static final SapHanaAuthenticationType BASIC = fromString("Basic");

    /**
     * Static value Windows for SapHanaAuthenticationType.
     */
    @Generated
    public static final SapHanaAuthenticationType WINDOWS = fromString("Windows");

    /**
     * Creates a new instance of SapHanaAuthenticationType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public SapHanaAuthenticationType() {
    }

    /**
     * Creates or finds a SapHanaAuthenticationType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding SapHanaAuthenticationType.
     */
    @Generated
    public static SapHanaAuthenticationType fromString(String name) {
        return fromString(name, SapHanaAuthenticationType.class);
    }

    /**
     * Gets known SapHanaAuthenticationType values.
     * 
     * @return known SapHanaAuthenticationType values.
     */
    @Generated
    public static Collection<SapHanaAuthenticationType> values() {
        return values(SapHanaAuthenticationType.class);
    }
}
