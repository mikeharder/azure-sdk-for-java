// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.communication.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.communication.CommunicationManager;
import com.azure.resourcemanager.communication.models.CheckNameAvailabilityReason;
import com.azure.resourcemanager.communication.models.CheckNameAvailabilityResponse;
import com.azure.resourcemanager.communication.models.NameAvailabilityParameters;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class CommunicationServicesCheckNameAvailabilityWithResponseMockTests {
    @Test
    public void testCheckNameAvailabilityWithResponse() throws Exception {
        String responseStr = "{\"nameAvailable\":false,\"reason\":\"Invalid\",\"message\":\"eyp\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        CommunicationManager manager = CommunicationManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        CheckNameAvailabilityResponse response = manager.communicationServices()
            .checkNameAvailabilityWithResponse(
                new NameAvailabilityParameters().withName("xzko").withType("cukoklyaxuconu"),
                com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals(false, response.nameAvailable());
        Assertions.assertEquals(CheckNameAvailabilityReason.INVALID, response.reason());
        Assertions.assertEquals("eyp", response.message());
    }
}
