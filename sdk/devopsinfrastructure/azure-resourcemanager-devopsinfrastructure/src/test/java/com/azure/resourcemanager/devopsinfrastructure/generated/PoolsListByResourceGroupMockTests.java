// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.devopsinfrastructure.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.devopsinfrastructure.DevOpsInfrastructureManager;
import com.azure.resourcemanager.devopsinfrastructure.models.ManagedServiceIdentityType;
import com.azure.resourcemanager.devopsinfrastructure.models.Pool;
import com.azure.resourcemanager.devopsinfrastructure.models.ProvisioningState;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class PoolsListByResourceGroupMockTests {
    @Test
    public void testListByResourceGroup() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"provisioningState\":\"Updating\",\"maximumConcurrency\":613432064,\"organizationProfile\":{\"kind\":\"OrganizationProfile\"},\"agentProfile\":{\"kind\":\"AgentProfile\",\"resourcePredictions\":{},\"resourcePredictionsProfile\":{\"kind\":\"ResourcePredictionsProfile\"}},\"fabricProfile\":{\"kind\":\"FabricProfile\"},\"devCenterProjectResourceId\":\"ibzyhwitsmyp\"},\"identity\":{\"principalId\":\"pcdpumnz\",\"tenantId\":\"wznm\",\"type\":\"SystemAssigned,UserAssigned\",\"userAssignedIdentities\":{\"lkdmtncvokotllxd\":{\"principalId\":\"sorgj\",\"clientId\":\"bldtlww\"}}},\"location\":\"gsyocogj\",\"tags\":{\"oocrkvcikhnv\":\"tbnnha\",\"gxk\":\"amqgxqquezikyw\"},\"id\":\"lla\",\"name\":\"melwuipiccjz\",\"type\":\"z\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        DevOpsInfrastructureManager manager = DevOpsInfrastructureManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<Pool> response
            = manager.pools().listByResourceGroup("ysuiizynkedya", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("gsyocogj", response.iterator().next().location());
        Assertions.assertEquals("tbnnha", response.iterator().next().tags().get("oocrkvcikhnv"));
        Assertions.assertEquals(ProvisioningState.UPDATING,
            response.iterator().next().properties().provisioningState());
        Assertions.assertEquals(613432064, response.iterator().next().properties().maximumConcurrency());
        Assertions.assertEquals("ibzyhwitsmyp", response.iterator().next().properties().devCenterProjectResourceId());
        Assertions.assertEquals(ManagedServiceIdentityType.SYSTEM_AND_USER_ASSIGNED,
            response.iterator().next().identity().type());
    }
}
