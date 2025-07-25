// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.computeschedule.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.computeschedule.ComputeScheduleManager;
import com.azure.resourcemanager.computeschedule.models.DeadlineType;
import com.azure.resourcemanager.computeschedule.models.ExecutionParameters;
import com.azure.resourcemanager.computeschedule.models.Language;
import com.azure.resourcemanager.computeschedule.models.Month;
import com.azure.resourcemanager.computeschedule.models.NotificationProperties;
import com.azure.resourcemanager.computeschedule.models.NotificationType;
import com.azure.resourcemanager.computeschedule.models.OptimizationPreference;
import com.azure.resourcemanager.computeschedule.models.ResourceType;
import com.azure.resourcemanager.computeschedule.models.RetryPolicy;
import com.azure.resourcemanager.computeschedule.models.ScheduledAction;
import com.azure.resourcemanager.computeschedule.models.ScheduledActionProperties;
import com.azure.resourcemanager.computeschedule.models.ScheduledActionType;
import com.azure.resourcemanager.computeschedule.models.ScheduledActionsSchedule;
import com.azure.resourcemanager.computeschedule.models.WeekDay;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ScheduledActionsCreateOrUpdateMockTests {
    @Test
    public void testCreateOrUpdate() throws Exception {
        String responseStr
            = "{\"properties\":{\"resourceType\":\"VirtualMachine\",\"actionType\":\"Start\",\"startTime\":\"2021-11-09T05:24:27Z\",\"endTime\":\"2021-04-03T17:36:18Z\",\"schedule\":{\"scheduledTime\":\"aeburuvdmo\",\"timeZone\":\"s\",\"requestedWeekDays\":[\"Monday\",\"Thursday\",\"Tuesday\",\"Monday\"],\"requestedMonths\":[\"February\"],\"requestedDaysOfTheMonth\":[1200703069],\"executionParameters\":{\"optimizationPreference\":\"Availability\",\"retryPolicy\":{\"retryCount\":1043168058,\"retryWindowInMinutes\":2086656667}},\"deadlineType\":\"Unknown\"},\"notificationSettings\":[{\"destination\":\"ujmqlgkfbtndoa\",\"type\":\"Email\",\"language\":\"en-us\",\"disabled\":false},{\"destination\":\"cn\",\"type\":\"Email\",\"language\":\"en-us\",\"disabled\":false},{\"destination\":\"c\",\"type\":\"Email\",\"language\":\"en-us\",\"disabled\":true}],\"disabled\":true,\"provisioningState\":\"Succeeded\"},\"location\":\"kojvd\",\"tags\":{\"rzgszufoxci\":\"foqouicybx\",\"haz\":\"opidoamciodh\",\"toego\":\"khnzbonlw\",\"vbtqgsfraoyzk\":\"dwbwhkszzcmrvexz\"},\"id\":\"owtlmnguxawqald\",\"name\":\"yuuximerqfobwyzn\",\"type\":\"bykutw\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ComputeScheduleManager manager = ComputeScheduleManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        ScheduledAction response
            = manager.scheduledActions()
                .define("zuempsbzkf")
                .withRegion("wcsdbnwdcfhucq")
                .withExistingResourceGroup("jnsjervtiagxsd")
                .withTags(mapOf("vtvudutncormr", "uvglsbjjcanvx", "f", "xqtvcofu", "u", "vkg"))
                .withProperties(
                    new ScheduledActionProperties().withResourceType(ResourceType.VIRTUAL_MACHINE_SCALE_SET)
                        .withActionType(ScheduledActionType.START)
                        .withStartTime(OffsetDateTime.parse("2021-07-26T11:46:04Z"))
                        .withEndTime(OffsetDateTime.parse("2021-09-12T04:39:33Z"))
                        .withSchedule(new ScheduledActionsSchedule().withScheduledTime("qi")
                            .withTimeZone("vinvkj")
                            .withRequestedWeekDays(Arrays.asList(WeekDay.SATURDAY))
                            .withRequestedMonths(Arrays.asList(Month.NOVEMBER, Month.MAY, Month.FEBRUARY))
                            .withRequestedDaysOfTheMonth(Arrays.asList(2049841705, 372795901, 1867961627, 733421396))
                            .withExecutionParameters(
                                new ExecutionParameters().withOptimizationPreference(OptimizationPreference.COST)
                                    .withRetryPolicy(new RetryPolicy().withRetryCount(332964812)
                                        .withRetryWindowInMinutes(969914681)))
                            .withDeadlineType(DeadlineType.COMPLETE_BY))
                        .withNotificationSettings(Arrays.asList(
                            new NotificationProperties().withDestination("zpof")
                                .withType(NotificationType.EMAIL)
                                .withLanguage(Language.EN_US)
                                .withDisabled(true),
                            new NotificationProperties().withDestination("yfzqwhxxbu")
                                .withType(NotificationType.EMAIL)
                                .withLanguage(Language.EN_US)
                                .withDisabled(true),
                            new NotificationProperties().withDestination("feqztppriol")
                                .withType(NotificationType.EMAIL)
                                .withLanguage(Language.EN_US)
                                .withDisabled(false),
                            new NotificationProperties().withDestination("lt")
                                .withType(NotificationType.EMAIL)
                                .withLanguage(Language.EN_US)
                                .withDisabled(true)))
                        .withDisabled(false))
                .create();

        Assertions.assertEquals("kojvd", response.location());
        Assertions.assertEquals("foqouicybx", response.tags().get("rzgszufoxci"));
        Assertions.assertEquals(ResourceType.VIRTUAL_MACHINE, response.properties().resourceType());
        Assertions.assertEquals(ScheduledActionType.START, response.properties().actionType());
        Assertions.assertEquals(OffsetDateTime.parse("2021-11-09T05:24:27Z"), response.properties().startTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-04-03T17:36:18Z"), response.properties().endTime());
        Assertions.assertEquals("aeburuvdmo", response.properties().schedule().scheduledTime());
        Assertions.assertEquals("s", response.properties().schedule().timeZone());
        Assertions.assertEquals(WeekDay.MONDAY, response.properties().schedule().requestedWeekDays().get(0));
        Assertions.assertEquals(Month.FEBRUARY, response.properties().schedule().requestedMonths().get(0));
        Assertions.assertEquals(1200703069, response.properties().schedule().requestedDaysOfTheMonth().get(0));
        Assertions.assertEquals(OptimizationPreference.AVAILABILITY,
            response.properties().schedule().executionParameters().optimizationPreference());
        Assertions.assertEquals(1043168058,
            response.properties().schedule().executionParameters().retryPolicy().retryCount());
        Assertions.assertEquals(2086656667,
            response.properties().schedule().executionParameters().retryPolicy().retryWindowInMinutes());
        Assertions.assertEquals(DeadlineType.UNKNOWN, response.properties().schedule().deadlineType());
        Assertions.assertEquals("ujmqlgkfbtndoa", response.properties().notificationSettings().get(0).destination());
        Assertions.assertEquals(NotificationType.EMAIL, response.properties().notificationSettings().get(0).type());
        Assertions.assertEquals(Language.EN_US, response.properties().notificationSettings().get(0).language());
        Assertions.assertFalse(response.properties().notificationSettings().get(0).disabled());
        Assertions.assertTrue(response.properties().disabled());
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
