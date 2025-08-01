// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.computeschedule.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.computeschedule.fluent.OccurrencesClient;
import com.azure.resourcemanager.computeschedule.fluent.models.OccurrenceInner;
import com.azure.resourcemanager.computeschedule.fluent.models.OccurrenceResourceInner;
import com.azure.resourcemanager.computeschedule.fluent.models.RecurringActionsResourceOperationResultInner;
import com.azure.resourcemanager.computeschedule.models.CancelOccurrenceRequest;
import com.azure.resourcemanager.computeschedule.models.DelayRequest;
import com.azure.resourcemanager.computeschedule.models.Occurrence;
import com.azure.resourcemanager.computeschedule.models.OccurrenceResource;
import com.azure.resourcemanager.computeschedule.models.Occurrences;
import com.azure.resourcemanager.computeschedule.models.RecurringActionsResourceOperationResult;

public final class OccurrencesImpl implements Occurrences {
    private static final ClientLogger LOGGER = new ClientLogger(OccurrencesImpl.class);

    private final OccurrencesClient innerClient;

    private final com.azure.resourcemanager.computeschedule.ComputeScheduleManager serviceManager;

    public OccurrencesImpl(OccurrencesClient innerClient,
        com.azure.resourcemanager.computeschedule.ComputeScheduleManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<Occurrence> getWithResponse(String resourceGroupName, String scheduledActionName,
        String occurrenceId, Context context) {
        Response<OccurrenceInner> inner
            = this.serviceClient().getWithResponse(resourceGroupName, scheduledActionName, occurrenceId, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new OccurrenceImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public Occurrence get(String resourceGroupName, String scheduledActionName, String occurrenceId) {
        OccurrenceInner inner = this.serviceClient().get(resourceGroupName, scheduledActionName, occurrenceId);
        if (inner != null) {
            return new OccurrenceImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public PagedIterable<Occurrence> listByScheduledAction(String resourceGroupName, String scheduledActionName) {
        PagedIterable<OccurrenceInner> inner
            = this.serviceClient().listByScheduledAction(resourceGroupName, scheduledActionName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new OccurrenceImpl(inner1, this.manager()));
    }

    public PagedIterable<Occurrence> listByScheduledAction(String resourceGroupName, String scheduledActionName,
        Context context) {
        PagedIterable<OccurrenceInner> inner
            = this.serviceClient().listByScheduledAction(resourceGroupName, scheduledActionName, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new OccurrenceImpl(inner1, this.manager()));
    }

    public PagedIterable<OccurrenceResource> listResources(String resourceGroupName, String scheduledActionName,
        String occurrenceId) {
        PagedIterable<OccurrenceResourceInner> inner
            = this.serviceClient().listResources(resourceGroupName, scheduledActionName, occurrenceId);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new OccurrenceResourceImpl(inner1, this.manager()));
    }

    public PagedIterable<OccurrenceResource> listResources(String resourceGroupName, String scheduledActionName,
        String occurrenceId, Context context) {
        PagedIterable<OccurrenceResourceInner> inner
            = this.serviceClient().listResources(resourceGroupName, scheduledActionName, occurrenceId, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new OccurrenceResourceImpl(inner1, this.manager()));
    }

    public Response<RecurringActionsResourceOperationResult> cancelWithResponse(String resourceGroupName,
        String scheduledActionName, String occurrenceId, CancelOccurrenceRequest body, Context context) {
        Response<RecurringActionsResourceOperationResultInner> inner = this.serviceClient()
            .cancelWithResponse(resourceGroupName, scheduledActionName, occurrenceId, body, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new RecurringActionsResourceOperationResultImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public RecurringActionsResourceOperationResult cancel(String resourceGroupName, String scheduledActionName,
        String occurrenceId, CancelOccurrenceRequest body) {
        RecurringActionsResourceOperationResultInner inner
            = this.serviceClient().cancel(resourceGroupName, scheduledActionName, occurrenceId, body);
        if (inner != null) {
            return new RecurringActionsResourceOperationResultImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public RecurringActionsResourceOperationResult delay(String resourceGroupName, String scheduledActionName,
        String occurrenceId, DelayRequest body) {
        RecurringActionsResourceOperationResultInner inner
            = this.serviceClient().delay(resourceGroupName, scheduledActionName, occurrenceId, body);
        if (inner != null) {
            return new RecurringActionsResourceOperationResultImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public RecurringActionsResourceOperationResult delay(String resourceGroupName, String scheduledActionName,
        String occurrenceId, DelayRequest body, Context context) {
        RecurringActionsResourceOperationResultInner inner
            = this.serviceClient().delay(resourceGroupName, scheduledActionName, occurrenceId, body, context);
        if (inner != null) {
            return new RecurringActionsResourceOperationResultImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    private OccurrencesClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.computeschedule.ComputeScheduleManager manager() {
        return this.serviceManager;
    }
}
