// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

/**
 * Samples for ServerlessEndpoints ListKeys.
 */
public final class ServerlessEndpointsListKeysSamples {
    /*
     * x-ms-original-file:
     * specification/machinelearningservices/resource-manager/Microsoft.MachineLearningServices/stable/2024-04-01/
     * examples/Workspace/ServerlessEndpoint/listKeys.json
     */
    /**
     * Sample code: ListKeys Workspace Serverless Endpoint.
     * 
     * @param manager Entry point to MachineLearningManager.
     */
    public static void
        listKeysWorkspaceServerlessEndpoint(com.azure.resourcemanager.machinelearning.MachineLearningManager manager) {
        manager.serverlessEndpoints()
            .listKeysWithResponse("test-rg", "my-aml-workspace", "string", com.azure.core.util.Context.NONE);
    }
}
