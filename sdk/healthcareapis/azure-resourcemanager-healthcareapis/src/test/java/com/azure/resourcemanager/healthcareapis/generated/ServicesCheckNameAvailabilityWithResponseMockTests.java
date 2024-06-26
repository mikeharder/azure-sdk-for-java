// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.healthcareapis.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.healthcareapis.HealthcareApisManager;
import com.azure.resourcemanager.healthcareapis.models.CheckNameAvailabilityParameters;
import com.azure.resourcemanager.healthcareapis.models.ServicesNameAvailabilityInfo;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ServicesCheckNameAvailabilityWithResponseMockTests {
    @Test
    public void testCheckNameAvailabilityWithResponse() throws Exception {
        String responseStr = "{\"nameAvailable\":true,\"reason\":\"AlreadyExists\",\"message\":\"qkagfhsxt\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        HealthcareApisManager manager = HealthcareApisManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        ServicesNameAvailabilityInfo response = manager.services()
            .checkNameAvailabilityWithResponse(
                new CheckNameAvailabilityParameters().withName("wjxeznoigbr").withType("jwmwkpnbs"),
                com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("qkagfhsxt", response.message());
    }
}
