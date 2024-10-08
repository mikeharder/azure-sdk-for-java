// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.generated;

/**
 * Samples for BillingRoleDefinition ListByEnrollmentAccount.
 */
public final class BillingRoleDefinitionListByEnrollmentAccountSamples {
    /*
     * x-ms-original-file: specification/billing/resource-manager/Microsoft.Billing/stable/2024-04-01/examples/
     * billingRoleDefinitionListByEnrollmentAccount.json
     */
    /**
     * Sample code: BillingRoleDefinitionListByEnrollmentAccount.
     * 
     * @param manager Entry point to BillingManager.
     */
    public static void
        billingRoleDefinitionListByEnrollmentAccount(com.azure.resourcemanager.billing.BillingManager manager) {
        manager.billingRoleDefinitions().listByEnrollmentAccount("123456", "4568789", com.azure.core.util.Context.NONE);
    }
}
