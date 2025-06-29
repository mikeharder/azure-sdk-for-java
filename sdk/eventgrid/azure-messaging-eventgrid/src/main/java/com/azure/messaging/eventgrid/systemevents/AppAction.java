// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
package com.azure.messaging.eventgrid.systemevents;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Type of action of the operation.
 * 
 * @deprecated This class is deprecated and may be removed in future releases. System events are now available in the
 * azure-messaging-eventgrid-systemevents package.
 */
@Deprecated
public final class AppAction extends ExpandableStringEnum<AppAction> {

    /**
     * Web app was restarted.
     */
    @Generated
    public static final AppAction RESTARTED = fromString("Restarted");

    /**
     * Web app was stopped.
     */
    @Generated
    public static final AppAction STOPPED = fromString("Stopped");

    /**
     * There was an operation to change app setting on the web app.
     */
    @Generated
    public static final AppAction CHANGED_APP_SETTINGS = fromString("ChangedAppSettings");

    /**
     * The job has started.
     */
    @Generated
    public static final AppAction STARTED = fromString("Started");

    /**
     * The job has completed.
     */
    @Generated
    public static final AppAction COMPLETED = fromString("Completed");

    /**
     * The job has failed to complete.
     */
    @Generated
    public static final AppAction FAILED = fromString("Failed");

    /**
     * Creates a new instance of AppAction value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public AppAction() {
    }

    /**
     * Creates or finds a AppAction from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding AppAction.
     */
    @Generated
    public static AppAction fromString(String name) {
        return fromString(name, AppAction.class);
    }

    /**
     * Gets known AppAction values.
     *
     * @return known AppAction values.
     */
    @Generated
    public static Collection<AppAction> values() {
        return values(AppAction.class);
    }
}
