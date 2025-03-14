// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.delegatednetwork.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The kind of workbook. Choices are user and shared.
 */
public final class OrchestratorKind extends ExpandableStringEnum<OrchestratorKind> {
    /**
     * Static value Kubernetes for OrchestratorKind.
     */
    public static final OrchestratorKind KUBERNETES = fromString("Kubernetes");

    /**
     * Creates a new instance of OrchestratorKind value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public OrchestratorKind() {
    }

    /**
     * Creates or finds a OrchestratorKind from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding OrchestratorKind.
     */
    public static OrchestratorKind fromString(String name) {
        return fromString(name, OrchestratorKind.class);
    }

    /**
     * Gets known OrchestratorKind values.
     * 
     * @return known OrchestratorKind values.
     */
    public static Collection<OrchestratorKind> values() {
        return values(OrchestratorKind.class);
    }
}
