// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.cognitiveservices.CognitiveServicesManager;
import com.azure.resourcemanager.cognitiveservices.models.PrivateLinkResourceListResult;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class PrivateLinkResourcesListWithResponseMockTests {
    @Test
    public void testListWithResponse() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"groupId\":\"eaqnrmvvfkoxm\",\"requiredMembers\":[\"ktuidvrm\",\"zlpdwwex\",\"mzvlazipbh\"],\"requiredZoneNames\":[\"qsg\"],\"displayName\":\"yuuzivens\"},\"id\":\"pmeyyvpkpatlbijp\",\"name\":\"gsksrfhf\",\"type\":\"olmk\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        CognitiveServicesManager manager = CognitiveServicesManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PrivateLinkResourceListResult response = manager.privateLinkResources()
            .listWithResponse("y", "srucvcrrpcjtt", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("qsg", response.value().get(0).properties().requiredZoneNames().get(0));
    }
}
