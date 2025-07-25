// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcompute.generated;

import com.azure.resourcemanager.hybridcompute.models.MachineRunCommandScriptSource;
import com.azure.resourcemanager.hybridcompute.models.RunCommandInputParameter;
import java.util.Arrays;

/**
 * Samples for MachineRunCommands CreateOrUpdate.
 */
public final class MachineRunCommandsCreateOrUpdateSamples {
    /*
     * x-ms-original-file:
     * specification/hybridcompute/resource-manager/Microsoft.HybridCompute/preview/2025-02-19-preview/examples/
     * runCommand/RunCommands_CreateOrUpdate.json
     */
    /**
     * Sample code: Create or Update a Run Command.
     * 
     * @param manager Entry point to HybridComputeManager.
     */
    public static void createOrUpdateARunCommand(com.azure.resourcemanager.hybridcompute.HybridComputeManager manager) {
        manager.machineRunCommands()
            .define("myRunCommand")
            .withRegion("eastus2")
            .withExistingMachine("myResourceGroup", "myMachine")
            .withSource(new MachineRunCommandScriptSource().withScript("Write-Host Hello World!"))
            .withParameters(Arrays.asList(new RunCommandInputParameter().withName("param1").withValue("value1"),
                new RunCommandInputParameter().withName("param2").withValue("value2")))
            .withAsyncExecution(false)
            .withRunAsUser("user1")
            .withRunAsPassword("<runAsPassword>")
            .withTimeoutInSeconds(3600)
            .withOutputBlobUri(
                "https://mystorageaccount.blob.core.windows.net/myscriptoutputcontainer/MyScriptoutput.txt")
            .withErrorBlobUri("https://mystorageaccount.blob.core.windows.net/mycontainer/MyScriptError.txt")
            .create();
    }
}
