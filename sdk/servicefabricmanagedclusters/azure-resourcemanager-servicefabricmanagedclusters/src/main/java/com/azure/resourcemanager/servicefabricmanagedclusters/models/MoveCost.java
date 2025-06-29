// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.servicefabricmanagedclusters.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Specifies the move cost for the service.
 */
public final class MoveCost extends ExpandableStringEnum<MoveCost> {
    /**
     * Zero move cost. This value is zero.
     */
    public static final MoveCost ZERO = fromString("Zero");

    /**
     * Specifies the move cost of the service as Low. The value is 1.
     */
    public static final MoveCost LOW = fromString("Low");

    /**
     * Specifies the move cost of the service as Medium. The value is 2.
     */
    public static final MoveCost MEDIUM = fromString("Medium");

    /**
     * Specifies the move cost of the service as High. The value is 3.
     */
    public static final MoveCost HIGH = fromString("High");

    /**
     * Creates a new instance of MoveCost value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public MoveCost() {
    }

    /**
     * Creates or finds a MoveCost from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding MoveCost.
     */
    public static MoveCost fromString(String name) {
        return fromString(name, MoveCost.class);
    }

    /**
     * Gets known MoveCost values.
     * 
     * @return known MoveCost values.
     */
    public static Collection<MoveCost> values() {
        return values(MoveCost.class);
    }
}
