// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.desktopvirtualization.generated;

/**
 * Samples for AppAttachPackage List.
 */
public final class AppAttachPackageListSamples {
    /*
     * x-ms-original-file:
     * specification/desktopvirtualization/resource-manager/Microsoft.DesktopVirtualization/stable/2024-04-03/examples/
     * AppAttachPackage_ListBySubscription.json
     */
    /**
     * Sample code: AppAttachPackage_ListBySubscription.
     * 
     * @param manager Entry point to DesktopVirtualizationManager.
     */
    public static void appAttachPackageListBySubscription(
        com.azure.resourcemanager.desktopvirtualization.DesktopVirtualizationManager manager) {
        manager.appAttachPackages().list("HostPoolName eq 'hostpool1'", com.azure.core.util.Context.NONE);
    }
}
