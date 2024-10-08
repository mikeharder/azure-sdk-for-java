// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.generated;

import com.azure.resourcemanager.billing.fluent.models.BillingAccountPolicyInner;
import com.azure.resourcemanager.billing.models.BillingAccountPolicyProperties;
import com.azure.resourcemanager.billing.models.BillingAccountPolicyPropertiesEnterpriseAgreementPolicies;
import com.azure.resourcemanager.billing.models.EnrollmentAuthLevelState;
import com.azure.resourcemanager.billing.models.MarketplacePurchasesPolicy;
import com.azure.resourcemanager.billing.models.ReservationPurchasesPolicy;
import com.azure.resourcemanager.billing.models.SavingsPlanPurchasesPolicy;

/**
 * Samples for Policies CreateOrUpdateByBillingAccount.
 */
public final class PoliciesCreateOrUpdateByBillingAccountSamples {
    /*
     * x-ms-original-file:
     * specification/billing/resource-manager/Microsoft.Billing/stable/2024-04-01/examples/policiesPutByBillingAccount.
     * json
     */
    /**
     * Sample code: PoliciesPutByBillingAccount.
     * 
     * @param manager Entry point to BillingManager.
     */
    public static void policiesPutByBillingAccount(com.azure.resourcemanager.billing.BillingManager manager) {
        manager.policies()
            .createOrUpdateByBillingAccount("1234567",
                new BillingAccountPolicyInner().withProperties(new BillingAccountPolicyProperties()
                    .withEnterpriseAgreementPolicies(new BillingAccountPolicyPropertiesEnterpriseAgreementPolicies()
                        .withAuthenticationType(EnrollmentAuthLevelState.ORGANIZATIONAL_ACCOUNT_ONLY))
                    .withMarketplacePurchases(MarketplacePurchasesPolicy.ALL_ALLOWED)
                    .withReservationPurchases(ReservationPurchasesPolicy.ALLOWED)
                    .withSavingsPlanPurchases(SavingsPlanPurchasesPolicy.NOT_ALLOWED)),
                com.azure.core.util.Context.NONE);
    }
}
