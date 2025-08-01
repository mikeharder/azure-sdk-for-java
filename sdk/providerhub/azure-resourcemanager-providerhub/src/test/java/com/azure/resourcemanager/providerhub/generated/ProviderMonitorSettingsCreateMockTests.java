// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.providerhub.ProviderHubManager;
import com.azure.resourcemanager.providerhub.models.ProviderMonitorSetting;
import com.azure.resourcemanager.providerhub.models.ProviderMonitorSettingProperties;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ProviderMonitorSettingsCreateMockTests {
    @Test
    public void testCreate() throws Exception {
        String responseStr
            = "{\"properties\":{\"provisioningState\":\"Succeeded\"},\"location\":\"gzsdtmwbyorjp\",\"tags\":{\"xqjsiuepm\":\"hychakvyrfbqvum\"},\"id\":\"xfnzlpq\",\"name\":\"pf\",\"type\":\"xef\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ProviderHubManager manager = ProviderHubManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        ProviderMonitorSetting response = manager.providerMonitorSettings()
            .define("ajubo")
            .withRegion("vtjr")
            .withExistingResourceGroup("ynjpchamkaepl")
            .withTags(mapOf("fnisyxgu", "kmwlaok", "jcyyuvtzrxzhcle", "bmtredscnns"))
            .withProperties(new ProviderMonitorSettingProperties())
            .create();

        Assertions.assertEquals("gzsdtmwbyorjp", response.location());
        Assertions.assertEquals("hychakvyrfbqvum", response.tags().get("xqjsiuepm"));
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
