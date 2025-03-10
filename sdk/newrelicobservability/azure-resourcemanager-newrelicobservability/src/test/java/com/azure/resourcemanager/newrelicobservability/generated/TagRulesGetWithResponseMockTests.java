// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.newrelicobservability.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.newrelicobservability.NewRelicObservabilityManager;
import com.azure.resourcemanager.newrelicobservability.models.SendAadLogsStatus;
import com.azure.resourcemanager.newrelicobservability.models.SendActivityLogsStatus;
import com.azure.resourcemanager.newrelicobservability.models.SendMetricsStatus;
import com.azure.resourcemanager.newrelicobservability.models.SendSubscriptionLogsStatus;
import com.azure.resourcemanager.newrelicobservability.models.TagAction;
import com.azure.resourcemanager.newrelicobservability.models.TagRule;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class TagRulesGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"provisioningState\":\"Canceled\",\"logRules\":{\"sendAadLogs\":\"Disabled\",\"sendSubscriptionLogs\":\"Enabled\",\"sendActivityLogs\":\"Disabled\",\"filteringTags\":[{\"name\":\"zqioxiysuii\",\"value\":\"nkedyatrwyhqmib\",\"action\":\"Include\"},{\"name\":\"itsmypyyn\",\"value\":\"dpumnzgmw\",\"action\":\"Exclude\"},{\"name\":\"biknsorgjhxbld\",\"value\":\"wwrlkdmtncv\",\"action\":\"Exclude\"},{\"name\":\"llxdyhgs\",\"value\":\"cogjltdtbn\",\"action\":\"Exclude\"}]},\"metricRules\":{\"sendMetrics\":\"Disabled\",\"filteringTags\":[{\"name\":\"vcikhnvpamqgx\",\"value\":\"u\",\"action\":\"Include\"},{\"name\":\"ywggx\",\"value\":\"lla\",\"action\":\"Include\"},{\"name\":\"wuipiccjzkzivg\",\"value\":\"c\",\"action\":\"Include\"}],\"userEmail\":\"hyrnxxmu\"}},\"id\":\"dndrdvstkwqqtche\",\"name\":\"lmfmtdaay\",\"type\":\"dvwvgpio\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        NewRelicObservabilityManager manager = NewRelicObservabilityManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        TagRule response = manager.tagRules()
            .getWithResponse("synljphuopxodl", "iyntorzihle", "sjswsrms", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals(SendAadLogsStatus.DISABLED, response.logRules().sendAadLogs());
        Assertions.assertEquals(SendSubscriptionLogsStatus.ENABLED, response.logRules().sendSubscriptionLogs());
        Assertions.assertEquals(SendActivityLogsStatus.DISABLED, response.logRules().sendActivityLogs());
        Assertions.assertEquals("zqioxiysuii", response.logRules().filteringTags().get(0).name());
        Assertions.assertEquals("nkedyatrwyhqmib", response.logRules().filteringTags().get(0).value());
        Assertions.assertEquals(TagAction.INCLUDE, response.logRules().filteringTags().get(0).action());
        Assertions.assertEquals(SendMetricsStatus.DISABLED, response.metricRules().sendMetrics());
        Assertions.assertEquals("vcikhnvpamqgx", response.metricRules().filteringTags().get(0).name());
        Assertions.assertEquals("u", response.metricRules().filteringTags().get(0).value());
        Assertions.assertEquals(TagAction.INCLUDE, response.metricRules().filteringTags().get(0).action());
        Assertions.assertEquals("hyrnxxmu", response.metricRules().userEmail());
    }
}
