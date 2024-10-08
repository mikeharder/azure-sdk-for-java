// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.webpubsub.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.webpubsub.WebPubSubManager;
import com.azure.resourcemanager.webpubsub.models.SharedPrivateLinkResource;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class WebPubSubSharedPrivateLinkResourcesListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"groupId\":\"ela\",\"privateLinkResourceId\":\"acigel\",\"provisioningState\":\"Succeeded\",\"requestMessage\":\"bvqvwzkjopwbeo\",\"status\":\"Disconnected\"},\"id\":\"wzdqybxceakxcpts\",\"name\":\"qfyiaseqchkr\",\"type\":\"tzrazisgyk\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        WebPubSubManager manager = WebPubSubManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<SharedPrivateLinkResource> response
            = manager.webPubSubSharedPrivateLinkResources().list("afcbqw", "e", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("ela", response.iterator().next().groupId());
        Assertions.assertEquals("acigel", response.iterator().next().privateLinkResourceId());
        Assertions.assertEquals("bvqvwzkjopwbeo", response.iterator().next().requestMessage());
    }
}
