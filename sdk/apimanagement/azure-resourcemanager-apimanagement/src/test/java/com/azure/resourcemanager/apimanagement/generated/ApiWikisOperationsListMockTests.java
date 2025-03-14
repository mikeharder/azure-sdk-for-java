// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.apimanagement.ApiManagementManager;
import com.azure.resourcemanager.apimanagement.models.WikiContract;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ApiWikisOperationsListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"documents\":[{\"documentationId\":\"jyflsmsbnlyoif\"},{\"documentationId\":\"fzjqthy\"},{\"documentationId\":\"voevcwfzo\"}]},\"id\":\"kxxlwwo\",\"name\":\"xgbsdzcgcvypj\",\"type\":\"ubdmg\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ApiManagementManager manager = ApiManagementManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<WikiContract> response = manager.apiWikisOperations()
            .list("iuceplbrzgk", "orwp", "b", "tweobptscruykkie", 1668426575, 913752529,
                com.azure.core.util.Context.NONE);

        Assertions.assertEquals("jyflsmsbnlyoif", response.iterator().next().documents().get(0).documentationId());
    }
}
