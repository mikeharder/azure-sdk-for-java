// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devcenter.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.devcenter.DevCenterManager;
import com.azure.resourcemanager.devcenter.models.CatalogItemType;
import com.azure.resourcemanager.devcenter.models.ManagedServiceIdentityType;
import com.azure.resourcemanager.devcenter.models.Project;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ProjectsListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"provisioningState\":\"NotSpecified\",\"devCenterUri\":\"a\",\"devCenterId\":\"cfxwmdbox\",\"description\":\"gsftufqobrjlnacg\",\"maxDevBoxesPerUser\":1670865281,\"displayName\":\"nhxk\",\"catalogSettings\":{\"catalogItemSyncTypes\":[\"EnvironmentDefinition\",\"EnvironmentDefinition\",\"EnvironmentDefinition\",\"EnvironmentDefinition\"]}},\"identity\":{\"principalId\":\"52899271-9ac6-4b2c-a2ae-63f898298e4e\",\"tenantId\":\"99eabf2e-9e4d-4a89-8a50-73fd77616e97\",\"type\":\"SystemAssigned, UserAssigned\",\"userAssignedIdentities\":{\"rano\":{\"principalId\":\"b66bec2e-50d0-4214-b204-0032d981d0d0\",\"clientId\":\"262b41c0-7c7f-4ecc-897e-d4a6318f2ed1\"},\"ukkjqnvbroyla\":{\"principalId\":\"1bd54796-e711-4eb0-ba48-a41d441c516b\",\"clientId\":\"9f9e3cc3-5946-49c7-badf-38b3723d0e0a\"},\"lcdisd\":{\"principalId\":\"93f6679e-b81f-4ad5-986b-cd43a975a847\",\"clientId\":\"c6793802-e3f7-4af4-b77e-d2cf404351dd\"},\"jbjsvgjrwh\":{\"principalId\":\"0d21960c-93da-4761-8cb1-248bd7e3243b\",\"clientId\":\"df2a821e-6196-48c0-9dc2-2878f53ddd5b\"}}},\"location\":\"vyc\",\"tags\":{\"xgccknfnw\":\"c\",\"fedxihchrphkm\":\"btmvpdvjdhttza\"},\"id\":\"rjdqnsdfzp\",\"name\":\"gtgkylkdghr\",\"type\":\"euutlwxezwzh\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        DevCenterManager manager = DevCenterManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<Project> response = manager.projects().list(2009658341, com.azure.core.util.Context.NONE);

        Assertions.assertEquals("vyc", response.iterator().next().location());
        Assertions.assertEquals("c", response.iterator().next().tags().get("xgccknfnw"));
        Assertions.assertEquals(ManagedServiceIdentityType.SYSTEM_ASSIGNED_USER_ASSIGNED,
            response.iterator().next().identity().type());
        Assertions.assertEquals("cfxwmdbox", response.iterator().next().devCenterId());
        Assertions.assertEquals("gsftufqobrjlnacg", response.iterator().next().description());
        Assertions.assertEquals(1670865281, response.iterator().next().maxDevBoxesPerUser());
        Assertions.assertEquals("nhxk", response.iterator().next().displayName());
        Assertions.assertEquals(CatalogItemType.ENVIRONMENT_DEFINITION,
            response.iterator().next().catalogSettings().catalogItemSyncTypes().get(0));
    }
}
