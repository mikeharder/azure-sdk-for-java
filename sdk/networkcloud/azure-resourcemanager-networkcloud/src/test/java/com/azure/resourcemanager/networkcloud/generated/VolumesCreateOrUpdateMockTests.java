// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.networkcloud.NetworkCloudManager;
import com.azure.resourcemanager.networkcloud.models.ExtendedLocation;
import com.azure.resourcemanager.networkcloud.models.Volume;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class VolumesCreateOrUpdateMockTests {
    @Test
    public void testCreateOrUpdate() throws Exception {
        String responseStr
            = "{\"etag\":\"uqk\",\"extendedLocation\":{\"name\":\"vzgjyp\",\"type\":\"nhxmpdxxze\"},\"properties\":{\"attachedTo\":[\"zjwotnxlkfhglh\",\"foxqwecrsn\",\"pcs\",\"lqxov\"],\"detailedStatus\":\"Error\",\"detailedStatusMessage\":\"bukk\",\"provisioningState\":\"Succeeded\",\"serialNumber\":\"lrmlccmetjscz\",\"sizeMiB\":7711263849402374951},\"location\":\"bqnasdsyenzs\",\"tags\":{\"xlyzkxit\":\"scplhyvd\",\"kol\":\"shezs\",\"mozsayebrazwz\":\"upjo\"},\"id\":\"pzbtzuyk\",\"name\":\"kipfsdyepf\",\"type\":\"ocmbezacf\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        NetworkCloudManager manager = NetworkCloudManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        Volume response = manager.volumes()
            .define("nxmlbmuoswk")
            .withRegion("tsffo")
            .withExistingResourceGroup("covqseusrfjbdxzf")
            .withExtendedLocation(new ExtendedLocation().withName("zjnufzrfg").withType("dq"))
            .withSizeMiB(3631579267195242575L)
            .withTags(
                mapOf("gwd", "nmhkscauwaz", "zokscvg", "riwgybjp", "gbyfgwe", "lix", "xlcskltez", "qkjvxprwpxsoohu"))
            .withIfMatch("resrgvtshuvft")
            .withIfNoneMatch("ai")
            .create();

        Assertions.assertEquals("bqnasdsyenzs", response.location());
        Assertions.assertEquals("scplhyvd", response.tags().get("xlyzkxit"));
        Assertions.assertEquals("vzgjyp", response.extendedLocation().name());
        Assertions.assertEquals("nhxmpdxxze", response.extendedLocation().type());
        Assertions.assertEquals(7711263849402374951L, response.sizeMiB());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
