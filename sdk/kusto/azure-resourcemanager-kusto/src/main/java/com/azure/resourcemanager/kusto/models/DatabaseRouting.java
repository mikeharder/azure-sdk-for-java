// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.kusto.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Indication for database routing information from the data connection, by default only database routing information is
 * allowed.
 */
public final class DatabaseRouting extends ExpandableStringEnum<DatabaseRouting> {
    /**
     * Static value Single for DatabaseRouting.
     */
    public static final DatabaseRouting SINGLE = fromString("Single");

    /**
     * Static value Multi for DatabaseRouting.
     */
    public static final DatabaseRouting MULTI = fromString("Multi");

    /**
     * Creates a new instance of DatabaseRouting value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public DatabaseRouting() {
    }

    /**
     * Creates or finds a DatabaseRouting from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding DatabaseRouting.
     */
    public static DatabaseRouting fromString(String name) {
        return fromString(name, DatabaseRouting.class);
    }

    /**
     * Gets known DatabaseRouting values.
     * 
     * @return known DatabaseRouting values.
     */
    public static Collection<DatabaseRouting> values() {
        return values(DatabaseRouting.class);
    }
}
