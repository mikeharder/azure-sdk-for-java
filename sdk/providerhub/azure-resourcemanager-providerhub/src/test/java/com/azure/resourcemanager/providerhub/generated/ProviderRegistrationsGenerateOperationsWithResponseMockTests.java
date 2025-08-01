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
import com.azure.resourcemanager.providerhub.models.OperationActionType;
import com.azure.resourcemanager.providerhub.models.OperationOrigins;
import com.azure.resourcemanager.providerhub.models.OperationsDefinition;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ProviderRegistrationsGenerateOperationsWithResponseMockTests {
    @Test
    public void testGenerateOperationsWithResponse() throws Exception {
        String responseStr
            = "[{\"name\":\"gmipnmliqmvlbhik\",\"isDataAction\":false,\"origin\":\"User\",\"display\":{\"provider\":\"vgpomxpupdtsdfj\",\"resource\":\"i\",\"operation\":\"socwiqbuout\",\"description\":\"py\"},\"actionType\":\"NotSpecified\",\"properties\":\"dataofjsbgbwwzvdaj\"},{\"name\":\"wnncfmaciqg\",\"isDataAction\":true,\"origin\":\"NotSpecified\",\"display\":{\"provider\":\"iqlwixvtbou\",\"resource\":\"uxtndopgjttbasua\",\"operation\":\"ap\",\"description\":\"lndbeaqbkixv\"},\"actionType\":\"NotSpecified\",\"properties\":\"datanpbbfqv\"},{\"name\":\"fjmsp\",\"isDataAction\":false,\"origin\":\"System\",\"display\":{\"provider\":\"uzjljm\",\"resource\":\"hfkyez\",\"operation\":\"lgjzmi\",\"description\":\"uydoccnx\"},\"actionType\":\"NotSpecified\",\"properties\":\"datazbuiadhbatecaa\"},{\"name\":\"sdohz\",\"isDataAction\":false,\"origin\":\"User\",\"display\":{\"provider\":\"daomb\",\"resource\":\"iinj\",\"operation\":\"llwkt\",\"description\":\"e\"},\"actionType\":\"Internal\",\"properties\":\"datavvqxua\"}]";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ProviderHubManager manager = ProviderHubManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        List<OperationsDefinition> response = manager.providerRegistrations()
            .generateOperationsWithResponse("hpqhazyntacihn", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("gmipnmliqmvlbhik", response.get(0).name());
        Assertions.assertFalse(response.get(0).isDataAction());
        Assertions.assertEquals(OperationOrigins.USER, response.get(0).origin());
        Assertions.assertEquals("vgpomxpupdtsdfj", response.get(0).display().provider());
        Assertions.assertEquals("i", response.get(0).display().resource());
        Assertions.assertEquals("socwiqbuout", response.get(0).display().operation());
        Assertions.assertEquals("py", response.get(0).display().description());
        Assertions.assertEquals(OperationActionType.NOT_SPECIFIED, response.get(0).actionType());
    }
}
