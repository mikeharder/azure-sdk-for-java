// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Metadata used to render different experiences for resources of the same type; e.g. WorkflowApp is a kind of
 * Microsoft.App/ContainerApps type. If supported, the resource provider must validate and persist this value.
 */
public final class Kind extends ExpandableStringEnum<Kind> {
    /**
     * Static value workflowapp for Kind.
     */
    public static final Kind WORKFLOWAPP = fromString("workflowapp");

    /**
     * Creates a new instance of Kind value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public Kind() {
    }

    /**
     * Creates or finds a Kind from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding Kind.
     */
    public static Kind fromString(String name) {
        return fromString(name, Kind.class);
    }

    /**
     * Gets known Kind values.
     * 
     * @return known Kind values.
     */
    public static Collection<Kind> values() {
        return values(Kind.class);
    }
}
