// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.generated;

/**
 * Samples for WorkflowRuns Cancel.
 */
public final class WorkflowRunsCancelSamples {
    /*
     * x-ms-original-file:
     * specification/web/resource-manager/Microsoft.Web/stable/2024-11-01/examples/WorkflowRuns_Cancel.json
     */
    /**
     * Sample code: Cancel a workflow run.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void cancelAWorkflowRun(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.webApps()
            .manager()
            .serviceClient()
            .getWorkflowRuns()
            .cancelWithResponse("test-resource-group", "test-name", "test-workflow",
                "08586676746934337772206998657CU22", com.azure.core.util.Context.NONE);
    }
}
