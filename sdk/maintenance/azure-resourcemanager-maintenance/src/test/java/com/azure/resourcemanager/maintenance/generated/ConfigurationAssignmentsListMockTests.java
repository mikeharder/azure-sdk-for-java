// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.maintenance.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.maintenance.MaintenanceManager;
import com.azure.resourcemanager.maintenance.models.ConfigurationAssignment;
import com.azure.resourcemanager.maintenance.models.TagOperators;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ConfigurationAssignmentsListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"location\":\"dscwxqupevzhf\",\"properties\":{\"maintenanceConfigurationId\":\"txhojujb\",\"resourceId\":\"elmcuvhixbjxyfw\",\"filter\":{\"resourceTypes\":[\"coolsttpkiwkkb\"],\"resourceGroups\":[\"rywvtylbfpn\",\"urdoi\",\"iithtywu\",\"xcbihw\"],\"osTypes\":[\"fdntwjchrdgoih\"],\"locations\":[\"wct\",\"ndz\",\"luudfdlwggytsb\",\"tov\"],\"tagSettings\":{\"tags\":{\"ffcdmqnrojl\":[\"inqfiufxqknpirgn\",\"pttwqmsn\"],\"ft\":[\"jnkrxf\",\"ddhcratizzr\",\"nasx\"],\"wesgogczh\":[\"qyzhf\"]},\"filterOperator\":\"Any\"}}},\"id\":\"krlgnyhm\",\"name\":\"ssxkkgthr\",\"type\":\"gh\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        MaintenanceManager manager = MaintenanceManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<ConfigurationAssignment> response = manager.configurationAssignments()
            .list("pqqmted", "tmmjihyeozph", "wau", "qncygupkvi", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("dscwxqupevzhf", response.iterator().next().location());
        Assertions.assertEquals("txhojujb", response.iterator().next().maintenanceConfigurationId());
        Assertions.assertEquals("elmcuvhixbjxyfw", response.iterator().next().resourceId());
        Assertions.assertEquals("coolsttpkiwkkb", response.iterator().next().filter().resourceTypes().get(0));
        Assertions.assertEquals("rywvtylbfpn", response.iterator().next().filter().resourceGroups().get(0));
        Assertions.assertEquals("fdntwjchrdgoih", response.iterator().next().filter().osTypes().get(0));
        Assertions.assertEquals("wct", response.iterator().next().filter().locations().get(0));
        Assertions.assertEquals("inqfiufxqknpirgn",
            response.iterator().next().filter().tagSettings().tags().get("ffcdmqnrojl").get(0));
        Assertions.assertEquals(TagOperators.ANY, response.iterator().next().filter().tagSettings().filterOperator());
    }
}
