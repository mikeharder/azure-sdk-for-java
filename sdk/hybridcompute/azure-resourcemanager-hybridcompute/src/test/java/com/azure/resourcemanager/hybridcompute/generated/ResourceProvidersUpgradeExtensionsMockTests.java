// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcompute.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.hybridcompute.HybridComputeManager;
import com.azure.resourcemanager.hybridcompute.models.ExtensionTargetProperties;
import com.azure.resourcemanager.hybridcompute.models.MachineExtensionUpgrade;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ResourceProvidersUpgradeExtensionsMockTests {
    @Test
    public void testUpgradeExtensions() throws Exception {
        String responseStr = "{}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        HybridComputeManager manager = HybridComputeManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        manager.resourceProviders()
            .upgradeExtensions("chorimkrsr", "moucsofldpuviyfc",
                new MachineExtensionUpgrade().withExtensionTargets(
                    mapOf("xuqibsxtkcudf", new ExtensionTargetProperties().withTargetVersion("olhbhlvb"), "owlkjxnqpv",
                        new ExtensionTargetProperties().withTargetVersion("farfs"))),
                com.azure.core.util.Context.NONE);

    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
