// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devhub.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.devhub.DevHubManager;
import com.azure.resourcemanager.devhub.models.OperationListResult;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class OperationsListWithResponseMockTests {
    @Test
    public void testListWithResponse() throws Exception {
        String responseStr
            = "{\"value\":[{\"name\":\"jjxhvpmo\",\"isDataAction\":true,\"display\":{\"provider\":\"zxibqeoj\",\"resource\":\"qbzvddntwnd\",\"operation\":\"cbtwnpzaoqvuh\",\"description\":\"cffcyddglmj\"},\"origin\":\"user\",\"actionType\":\"Internal\"},{\"name\":\"pyeicxm\",\"isDataAction\":false,\"display\":{\"provider\":\"vhkhixu\",\"resource\":\"dtopbob\",\"operation\":\"ghmewuam\",\"description\":\"hrzayvvtpgvdf\"},\"origin\":\"system\",\"actionType\":\"Internal\"},{\"name\":\"tutqxlngxlefgug\",\"isDataAction\":false,\"display\":{\"provider\":\"dqmidtt\",\"resource\":\"rvqdra\",\"operation\":\"jybige\",\"description\":\"qfbow\"},\"origin\":\"user\",\"actionType\":\"Internal\"},{\"name\":\"tzlcuiywgqywgn\",\"isDataAction\":true,\"display\":{\"provider\":\"hzgpphrcgyncocpe\",\"resource\":\"vmmcoofs\",\"operation\":\"zevgb\",\"description\":\"jqabcypmivkwlzuv\"},\"origin\":\"user,system\",\"actionType\":\"Internal\"}],\"nextLink\":\"nbacfi\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        DevHubManager manager = DevHubManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        OperationListResult response
            = manager.operations().listWithResponse(com.azure.core.util.Context.NONE).getValue();

    }
}
