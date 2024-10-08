// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.desktopvirtualization.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.desktopvirtualization.DesktopVirtualizationManager;
import com.azure.resourcemanager.desktopvirtualization.models.MsixPackage;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class MsixPackagesListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"imagePath\":\"kbbm\",\"packageName\":\"aglt\",\"packageFamilyName\":\"oeeonqlnfwm\",\"displayName\":\"mvqdbpbhfckdvez\",\"packageRelativePath\":\"cssbzhddu\",\"isRegularRegistration\":true,\"isActive\":true,\"packageDependencies\":[{\"dependencyName\":\"kalehp\",\"publisher\":\"awugiqjti\",\"minVersion\":\"qgdm\"},{\"dependencyName\":\"i\",\"publisher\":\"teajohiyg\",\"minVersion\":\"n\"},{\"dependencyName\":\"n\",\"publisher\":\"czykmktpvw\",\"minVersion\":\"csehchkhufm\"},{\"dependencyName\":\"umqy\",\"publisher\":\"ydzulodsaeuzan\",\"minVersion\":\"fnhsenwphp\"}],\"version\":\"ngqjclidf\",\"lastUpdated\":\"2021-10-18T07:20:26Z\",\"packageApplications\":[{\"appId\":\"ufwbeqrku\",\"description\":\"htssruqnmdvhazc\",\"appUserModelID\":\"ytiq\",\"friendlyName\":\"bqerzwx\",\"iconImageName\":\"txtd\"}]},\"id\":\"lbpktg\",\"name\":\"styoua\",\"type\":\"bewreswmowegmmut\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        DesktopVirtualizationManager manager = DesktopVirtualizationManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<MsixPackage> response = manager.msixPackages()
            .list("vcuartrhun", "pirykycndzfqiv", 1105579119, false, 1729042857, com.azure.core.util.Context.NONE);

        Assertions.assertEquals("kbbm", response.iterator().next().imagePath());
        Assertions.assertEquals("aglt", response.iterator().next().packageName());
        Assertions.assertEquals("oeeonqlnfwm", response.iterator().next().packageFamilyName());
        Assertions.assertEquals("mvqdbpbhfckdvez", response.iterator().next().displayName());
        Assertions.assertEquals("cssbzhddu", response.iterator().next().packageRelativePath());
        Assertions.assertEquals(true, response.iterator().next().isRegularRegistration());
        Assertions.assertEquals(true, response.iterator().next().isActive());
        Assertions.assertEquals("kalehp", response.iterator().next().packageDependencies().get(0).dependencyName());
        Assertions.assertEquals("awugiqjti", response.iterator().next().packageDependencies().get(0).publisher());
        Assertions.assertEquals("qgdm", response.iterator().next().packageDependencies().get(0).minVersion());
        Assertions.assertEquals("ngqjclidf", response.iterator().next().version());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-18T07:20:26Z"), response.iterator().next().lastUpdated());
        Assertions.assertEquals("ufwbeqrku", response.iterator().next().packageApplications().get(0).appId());
        Assertions.assertEquals("htssruqnmdvhazc",
            response.iterator().next().packageApplications().get(0).description());
        Assertions.assertEquals("ytiq", response.iterator().next().packageApplications().get(0).appUserModelId());
        Assertions.assertEquals("bqerzwx", response.iterator().next().packageApplications().get(0).friendlyName());
        Assertions.assertEquals("txtd", response.iterator().next().packageApplications().get(0).iconImageName());
    }
}
