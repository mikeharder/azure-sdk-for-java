// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.resourcemanager.recoveryservicesbackup.RecoveryServicesBackupManager;
import com.azure.resourcemanager.recoveryservicesbackup.models.CreateMode;
import com.azure.resourcemanager.recoveryservicesbackup.models.ProtectedItem;
import com.azure.resourcemanager.recoveryservicesbackup.models.ProtectedItemResource;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public final class ProtectedItemsCreateOrUpdateWithResponseMockTests {
    @Test
    public void testCreateOrUpdateWithResponse() throws Exception {
        HttpClient httpClient = Mockito.mock(HttpClient.class);
        HttpResponse httpResponse = Mockito.mock(HttpResponse.class);
        ArgumentCaptor<HttpRequest> httpRequest = ArgumentCaptor.forClass(HttpRequest.class);

        String responseStr =
            "{\"properties\":{\"protectedItemType\":\"ProtectedItem\",\"backupManagementType\":\"AzureIaasVM\",\"workloadType\":\"AzureSqlDb\",\"containerName\":\"gv\",\"sourceResourceId\":\"mxaursqftibtyi\",\"policyId\":\"yvp\",\"lastRecoveryPoint\":\"2021-02-03T04:51:25Z\",\"backupSetName\":\"jpnqnoowsbeden\",\"createMode\":\"Default\",\"deferredDeleteTimeInUTC\":\"2021-01-21T17:44:50Z\",\"isScheduledForDeferredDelete\":false,\"deferredDeleteTimeRemaining\":\"vucnulgmnh\",\"isDeferredDeleteScheduleUpcoming\":false,\"isRehydrate\":false,\"resourceGuardOperationRequests\":[\"fajs\"],\"isArchiveEnabled\":true,\"policyName\":\"mqozzkivy\",\"softDeleteRetentionPeriod\":478502250},\"eTag\":\"iizjixlqfhefkwa\",\"location\":\"solronqqlm\",\"tags\":{\"exhvuqbozoolz\":\"qxsjxte\",\"nx\":\"ocarkuzlbcnndt\",\"llhdyzm\":\"wqy\"},\"id\":\"ckze\",\"name\":\"nxakckyw\",\"type\":\"mxgaabjkdtfohfao\"}";

        Mockito.when(httpResponse.getStatusCode()).thenReturn(200);
        Mockito.when(httpResponse.getHeaders()).thenReturn(new HttpHeaders());
        Mockito
            .when(httpResponse.getBody())
            .thenReturn(Flux.just(ByteBuffer.wrap(responseStr.getBytes(StandardCharsets.UTF_8))));
        Mockito
            .when(httpResponse.getBodyAsByteArray())
            .thenReturn(Mono.just(responseStr.getBytes(StandardCharsets.UTF_8)));
        Mockito
            .when(httpClient.send(httpRequest.capture(), Mockito.any()))
            .thenReturn(
                Mono
                    .defer(
                        () -> {
                            Mockito.when(httpResponse.getRequest()).thenReturn(httpRequest.getValue());
                            return Mono.just(httpResponse);
                        }));

        RecoveryServicesBackupManager manager =
            RecoveryServicesBackupManager
                .configure()
                .withHttpClient(httpClient)
                .authenticate(
                    tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                    new AzureProfile("", "", AzureEnvironment.AZURE));

        ProtectedItemResource response =
            manager
                .protectedItems()
                .define("muii")
                .withRegion("uww")
                .withExistingProtectionContainer("zwjiqullq", "bdmvrscmqerndbr", "yeofltfnnxrkad", "fynn")
                .withTags(mapOf("xlb", "hefsb", "wpfsuqtaaz", "xomeikjclwzacn", "ezxlhdjzqdca", "qbxyxoyfpuqqi"))
                .withProperties(
                    new ProtectedItem()
                        .withContainerName("ykfkx")
                        .withSourceResourceId("cbrwjiutgnjizbe")
                        .withPolicyId("oiymrvzbjuyrsrzi")
                        .withLastRecoveryPoint(OffsetDateTime.parse("2020-12-28T10:26:36Z"))
                        .withBackupSetName("xgbdsuifrevka")
                        .withCreateMode(CreateMode.INVALID)
                        .withDeferredDeleteTimeInUtc(OffsetDateTime.parse("2021-03-29T18:46:45Z"))
                        .withIsScheduledForDeferredDelete(false)
                        .withDeferredDeleteTimeRemaining("qjm")
                        .withIsDeferredDeleteScheduleUpcoming(true)
                        .withIsRehydrate(true)
                        .withResourceGuardOperationRequests(Arrays.asList("ry", "jufptbjczjnciuiy", "vldaswv"))
                        .withIsArchiveEnabled(false)
                        .withPolicyName("qqzlgcndhz")
                        .withSoftDeleteRetentionPeriod(599915299))
                .withEtag("cfsrhkhgsn")
                .create();

        Assertions.assertEquals("solronqqlm", response.location());
        Assertions.assertEquals("qxsjxte", response.tags().get("exhvuqbozoolz"));
        Assertions.assertEquals("gv", response.properties().containerName());
        Assertions.assertEquals("mxaursqftibtyi", response.properties().sourceResourceId());
        Assertions.assertEquals("yvp", response.properties().policyId());
        Assertions
            .assertEquals(OffsetDateTime.parse("2021-02-03T04:51:25Z"), response.properties().lastRecoveryPoint());
        Assertions.assertEquals("jpnqnoowsbeden", response.properties().backupSetName());
        Assertions.assertEquals(CreateMode.DEFAULT, response.properties().createMode());
        Assertions
            .assertEquals(
                OffsetDateTime.parse("2021-01-21T17:44:50Z"), response.properties().deferredDeleteTimeInUtc());
        Assertions.assertEquals(false, response.properties().isScheduledForDeferredDelete());
        Assertions.assertEquals("vucnulgmnh", response.properties().deferredDeleteTimeRemaining());
        Assertions.assertEquals(false, response.properties().isDeferredDeleteScheduleUpcoming());
        Assertions.assertEquals(false, response.properties().isRehydrate());
        Assertions.assertEquals("fajs", response.properties().resourceGuardOperationRequests().get(0));
        Assertions.assertEquals(true, response.properties().isArchiveEnabled());
        Assertions.assertEquals("mqozzkivy", response.properties().policyName());
        Assertions.assertEquals(478502250, response.properties().softDeleteRetentionPeriod());
        Assertions.assertEquals("iizjixlqfhefkwa", response.etag());
    }

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