// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sql.generated;

import com.azure.resourcemanager.sql.fluent.models.DataMaskingPolicyInner;
import com.azure.resourcemanager.sql.models.DataMaskingPolicyName;
import com.azure.resourcemanager.sql.models.DataMaskingState;

/**
 * Samples for DataMaskingPolicies CreateOrUpdate.
 */
public final class DataMaskingPoliciesCreateOrUpdateSamples {
    /*
     * x-ms-original-file:
     * specification/sql/resource-manager/Microsoft.Sql/stable/2021-11-01/examples/DataMaskingPolicyCreateOrUpdateMin.
     * json
     */
    /**
     * Sample code: Create or update data masking policy min.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void createOrUpdateDataMaskingPolicyMin(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.sqlServers()
            .manager()
            .serviceClient()
            .getDataMaskingPolicies()
            .createOrUpdateWithResponse("sqlcrudtest-6852", "sqlcrudtest-2080", "sqlcrudtest-331",
                DataMaskingPolicyName.DEFAULT,
                new DataMaskingPolicyInner().withDataMaskingState(DataMaskingState.ENABLED),
                com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file:
     * specification/sql/resource-manager/Microsoft.Sql/stable/2021-11-01/examples/DataMaskingPolicyCreateOrUpdateMax.
     * json
     */
    /**
     * Sample code: Create or update data masking policy max.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void createOrUpdateDataMaskingPolicyMax(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.sqlServers()
            .manager()
            .serviceClient()
            .getDataMaskingPolicies()
            .createOrUpdateWithResponse("sqlcrudtest-6852", "sqlcrudtest-2080", "sqlcrudtest-331",
                DataMaskingPolicyName.DEFAULT,
                new DataMaskingPolicyInner().withDataMaskingState(DataMaskingState.ENABLED)
                    .withExemptPrincipals("testuser;"),
                com.azure.core.util.Context.NONE);
    }
}
