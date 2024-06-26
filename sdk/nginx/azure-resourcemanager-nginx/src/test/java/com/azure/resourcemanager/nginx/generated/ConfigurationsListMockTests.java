// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.nginx.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.nginx.NginxManager;
import com.azure.resourcemanager.nginx.models.NginxConfiguration;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ConfigurationsListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"provisioningState\":\"Accepted\",\"files\":[{\"content\":\"wyzmhtxon\",\"virtualPath\":\"ts\"}],\"protectedFiles\":[{\"content\":\"bp\",\"virtualPath\":\"qpsrknftguvri\"},{\"content\":\"prwmdyvxqt\",\"virtualPath\":\"riwwroy\"},{\"content\":\"exrmcqibycnojvk\",\"virtualPath\":\"e\"},{\"content\":\"sgzvahapjyzhpv\",\"virtualPath\":\"zcjrvxdjzlmwlx\"}],\"package\":{\"data\":\"gfhzovawjvzunlut\",\"protectedFiles\":[\"prnxipeil\"]},\"rootFile\":\"zuaejxd\"},\"location\":\"tskzbbtdzumveek\",\"id\":\"wozuhkf\",\"name\":\"bsjyofdx\",\"type\":\"uusdttouwa\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        NginxManager manager = NginxManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<NginxConfiguration> response
            = manager.configurations().list("jkbegibtnmxiebww", "loayqcgw", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("wyzmhtxon", response.iterator().next().properties().files().get(0).content());
        Assertions.assertEquals("ts", response.iterator().next().properties().files().get(0).virtualPath());
        Assertions.assertEquals("bp", response.iterator().next().properties().protectedFiles().get(0).content());
        Assertions.assertEquals("qpsrknftguvri",
            response.iterator().next().properties().protectedFiles().get(0).virtualPath());
        Assertions.assertEquals("gfhzovawjvzunlut", response.iterator().next().properties().packageProperty().data());
        Assertions.assertEquals("prnxipeil",
            response.iterator().next().properties().packageProperty().protectedFiles().get(0));
        Assertions.assertEquals("zuaejxd", response.iterator().next().properties().rootFile());
        Assertions.assertEquals("tskzbbtdzumveek", response.iterator().next().location());
    }
}
