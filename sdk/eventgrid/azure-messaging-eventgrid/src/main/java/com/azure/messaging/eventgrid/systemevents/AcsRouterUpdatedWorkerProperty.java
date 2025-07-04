// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
package com.azure.messaging.eventgrid.systemevents;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * An individual property updated in the Router Worker.
 * 
 * @deprecated This class is deprecated and may be removed in future releases. System events are now available in the
 * azure-messaging-eventgrid-systemevents package.
 */
@Deprecated
public final class AcsRouterUpdatedWorkerProperty extends ExpandableStringEnum<AcsRouterUpdatedWorkerProperty> {

    /**
     * Static value AvailableForOffers for AcsRouterUpdatedWorkerProperty.
     */
    @Generated
    public static final AcsRouterUpdatedWorkerProperty AVAILABLE_FOR_OFFERS = fromString("AvailableForOffers");

    /**
     * Static value TotalCapacity for AcsRouterUpdatedWorkerProperty.
     */
    @Generated
    public static final AcsRouterUpdatedWorkerProperty TOTAL_CAPACITY = fromString("TotalCapacity");

    /**
     * Static value QueueAssignments for AcsRouterUpdatedWorkerProperty.
     */
    @Generated
    public static final AcsRouterUpdatedWorkerProperty QUEUE_ASSIGNMENTS = fromString("QueueAssignments");

    /**
     * Static value Labels for AcsRouterUpdatedWorkerProperty.
     */
    @Generated
    public static final AcsRouterUpdatedWorkerProperty LABELS = fromString("Labels");

    /**
     * Static value Tags for AcsRouterUpdatedWorkerProperty.
     */
    @Generated
    public static final AcsRouterUpdatedWorkerProperty TAGS = fromString("Tags");

    /**
     * Static value ChannelConfigurations for AcsRouterUpdatedWorkerProperty.
     */
    @Generated
    public static final AcsRouterUpdatedWorkerProperty CHANNEL_CONFIGURATIONS = fromString("ChannelConfigurations");

    /**
     * Creates a new instance of AcsRouterUpdatedWorkerProperty value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public AcsRouterUpdatedWorkerProperty() {
    }

    /**
     * Creates or finds a AcsRouterUpdatedWorkerProperty from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding AcsRouterUpdatedWorkerProperty.
     */
    @Generated
    public static AcsRouterUpdatedWorkerProperty fromString(String name) {
        return fromString(name, AcsRouterUpdatedWorkerProperty.class);
    }

    /**
     * Gets known AcsRouterUpdatedWorkerProperty values.
     *
     * @return known AcsRouterUpdatedWorkerProperty values.
     */
    @Generated
    public static Collection<AcsRouterUpdatedWorkerProperty> values() {
        return values(AcsRouterUpdatedWorkerProperty.class);
    }
}
