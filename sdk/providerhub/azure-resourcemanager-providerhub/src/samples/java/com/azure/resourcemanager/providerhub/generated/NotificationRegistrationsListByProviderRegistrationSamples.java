// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.generated;

/**
 * Samples for NotificationRegistrations ListByProviderRegistration.
 */
public final class NotificationRegistrationsListByProviderRegistrationSamples {
    /*
     * x-ms-original-file: specification/providerhub/resource-manager/Microsoft.ProviderHub/stable/2024-09-01/examples/
     * NotificationRegistrations_ListByProviderRegistration.json
     */
    /**
     * Sample code: NotificationRegistrations_ListByProviderRegistration.
     * 
     * @param manager Entry point to ProviderHubManager.
     */
    public static void notificationRegistrationsListByProviderRegistration(
        com.azure.resourcemanager.providerhub.ProviderHubManager manager) {
        manager.notificationRegistrations()
            .listByProviderRegistration("Microsoft.Contoso", com.azure.core.util.Context.NONE);
    }
}
