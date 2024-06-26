// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.resourcemanager.appcontainers.ContainerAppsApiManager;
import com.azure.resourcemanager.appcontainers.models.JavaComponent;
import com.azure.resourcemanager.appcontainers.models.JavaComponentConfigurationProperty;
import com.azure.resourcemanager.appcontainers.models.JavaComponentServiceBind;
import com.azure.resourcemanager.appcontainers.models.JavaComponentType;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public final class JavaComponentsCreateOrUpdateMockTests {
    @Test
    public void testCreateOrUpdate() throws Exception {
        HttpClient httpClient = Mockito.mock(HttpClient.class);
        HttpResponse httpResponse = Mockito.mock(HttpResponse.class);
        ArgumentCaptor<HttpRequest> httpRequest = ArgumentCaptor.forClass(HttpRequest.class);

        String responseStr
            = "{\"properties\":{\"componentType\":\"SpringCloudEureka\",\"provisioningState\":\"Succeeded\",\"configurations\":[{\"propertyName\":\"wmmkfq\",\"value\":\"iqulwwtrjmeq\"},{\"propertyName\":\"yhzok\",\"value\":\"yuoh\"},{\"propertyName\":\"nsnaajphmp\",\"value\":\"jnglpwsad\"},{\"propertyName\":\"jsumxpezcoio\",\"value\":\"rmfqzwq\"}],\"serviceBinds\":[{\"name\":\"eedcnwmywx\",\"serviceId\":\"zkvemy\"},{\"name\":\"pczaqpqif\",\"serviceId\":\"m\"},{\"name\":\"rwtx\",\"serviceId\":\"isamonatniz\"}]},\"id\":\"r\",\"name\":\"qsqjghrmthsplwst\",\"type\":\"xsrgxfqpan\"}";

        Mockito.when(httpResponse.getStatusCode()).thenReturn(200);
        Mockito.when(httpResponse.getHeaders()).thenReturn(new HttpHeaders());
        Mockito.when(httpResponse.getBody())
            .thenReturn(Flux.just(ByteBuffer.wrap(responseStr.getBytes(StandardCharsets.UTF_8))));
        Mockito.when(httpResponse.getBodyAsByteArray())
            .thenReturn(Mono.just(responseStr.getBytes(StandardCharsets.UTF_8)));
        Mockito.when(httpClient.send(httpRequest.capture(), Mockito.any())).thenReturn(Mono.defer(() -> {
            Mockito.when(httpResponse.getRequest()).thenReturn(httpRequest.getValue());
            return Mono.just(httpResponse);
        }));

        ContainerAppsApiManager manager = ContainerAppsApiManager.configure().withHttpClient(httpClient).authenticate(
            tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
            new AzureProfile("", "", AzureEnvironment.AZURE));

        JavaComponent response = manager.javaComponents().define("tpjfojiunrlshxuk")
            .withExistingManagedEnvironment("misvpztd", "vykpxkqe")
            .withComponentType(JavaComponentType.SPRING_BOOT_ADMIN)
            .withConfigurations(
                Arrays.asList(new JavaComponentConfigurationProperty().withPropertyName("oancdrco").withValue("vx"),
                    new JavaComponentConfigurationProperty().withPropertyName("dxonckbn").withValue("lfxlupibaqzizxzp"),
                    new JavaComponentConfigurationProperty().withPropertyName("eghlw").withValue("ogvgfklqiyn"),
                    new JavaComponentConfigurationProperty().withPropertyName("eqelsb").withValue("dstrkzxsgtz")))
            .withServiceBinds(Arrays.asList(new JavaComponentServiceBind().withName("rds").withServiceId("vpimyndnoxa"),
                new JavaComponentServiceBind().withName("rqaqotn").withServiceId("xolousdv"),
                new JavaComponentServiceBind().withName("ptqmawzjdrpiz").withServiceId("l")))
            .create();

        Assertions.assertEquals(JavaComponentType.SPRING_CLOUD_EUREKA, response.componentType());
        Assertions.assertEquals("wmmkfq", response.configurations().get(0).propertyName());
        Assertions.assertEquals("iqulwwtrjmeq", response.configurations().get(0).value());
        Assertions.assertEquals("eedcnwmywx", response.serviceBinds().get(0).name());
        Assertions.assertEquals("zkvemy", response.serviceBinds().get(0).serviceId());
    }
}
