// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.cognitiveservices.fluent.models.AccountModelInner;
import com.azure.resourcemanager.cognitiveservices.fluent.models.ModelInner;
import com.azure.resourcemanager.cognitiveservices.models.BillingMeterInfo;
import com.azure.resourcemanager.cognitiveservices.models.CallRateLimit;
import com.azure.resourcemanager.cognitiveservices.models.CapacityConfig;
import com.azure.resourcemanager.cognitiveservices.models.DeploymentModel;
import com.azure.resourcemanager.cognitiveservices.models.ModelDeprecationInfo;
import com.azure.resourcemanager.cognitiveservices.models.ModelLifecycleStatus;
import com.azure.resourcemanager.cognitiveservices.models.ModelListResult;
import com.azure.resourcemanager.cognitiveservices.models.ModelSku;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class ModelListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ModelListResult model = BinaryData.fromString(
            "{\"nextLink\":\"wmdyvxqtay\",\"value\":[{\"model\":{\"baseModel\":{\"publisher\":\"yqbexrmcqibycno\",\"format\":\"knme\",\"name\":\"sgzvahapjyzhpv\",\"version\":\"zcjrvxdjzlmwlx\",\"source\":\"ug\",\"sourceAccount\":\"zovawjvz\",\"callRateLimit\":{\"count\":99.287285,\"renewalPeriod\":27.584808,\"rules\":[{}]}},\"isDefaultVersion\":false,\"skus\":[{\"name\":\"peilpjzuaejxdu\",\"usageName\":\"skzbb\",\"deprecationDate\":\"2021-08-12T02:58:19Z\",\"capacity\":{},\"rateLimits\":[{},{},{},{}],\"cost\":[{}]},{\"name\":\"gpw\",\"usageName\":\"uh\",\"deprecationDate\":\"2021-08-14T18:03:09Z\",\"capacity\":{},\"rateLimits\":[{},{},{},{}],\"cost\":[{}]},{\"name\":\"dxluu\",\"usageName\":\"ttouwaboekqvkel\",\"deprecationDate\":\"2021-10-11T10:00:24Z\",\"capacity\":{},\"rateLimits\":[{},{},{}],\"cost\":[{},{},{},{}]},{\"name\":\"sflhhca\",\"usageName\":\"n\",\"deprecationDate\":\"2021-03-25T19:19:56Z\",\"capacity\":{},\"rateLimits\":[{},{}],\"cost\":[{},{},{},{}]}],\"maxCapacity\":939698337,\"capabilities\":{\"slyjpkiid\":\"aq\",\"eli\":\"yexz\",\"bnxknalaulppg\":\"hnrztfol\",\"gvpgy\":\"dtpnapnyiropuhp\"},\"finetuneCapabilities\":{\"medjvcslynqwwncw\":\"git\",\"pkteo\":\"zhxgktrmgucn\"},\"deprecation\":{\"fineTune\":\"wptfdy\",\"inference\":\"fqbuaceopzf\"},\"lifecycleStatus\":\"Deprecating\",\"publisher\":\"ao\",\"format\":\"pcqeqx\",\"name\":\"z\",\"version\":\"hzxct\",\"source\":\"gbkdmoizpos\",\"sourceAccount\":\"grcfb\",\"callRateLimit\":{\"count\":62.275116,\"renewalPeriod\":50.984173,\"rules\":[{},{}]}},\"kind\":\"kxbpvj\",\"skuName\":\"jhxxjyn\",\"description\":\"divkrt\"}]}")
            .toObject(ModelListResult.class);
        Assertions.assertEquals("wmdyvxqtay", model.nextLink());
        Assertions.assertEquals("ao", model.value().get(0).model().publisher());
        Assertions.assertEquals("pcqeqx", model.value().get(0).model().format());
        Assertions.assertEquals("z", model.value().get(0).model().name());
        Assertions.assertEquals("hzxct", model.value().get(0).model().version());
        Assertions.assertEquals("gbkdmoizpos", model.value().get(0).model().source());
        Assertions.assertEquals("grcfb", model.value().get(0).model().sourceAccount());
        Assertions.assertEquals("yqbexrmcqibycno", model.value().get(0).model().baseModel().publisher());
        Assertions.assertEquals("knme", model.value().get(0).model().baseModel().format());
        Assertions.assertEquals("sgzvahapjyzhpv", model.value().get(0).model().baseModel().name());
        Assertions.assertEquals("zcjrvxdjzlmwlx", model.value().get(0).model().baseModel().version());
        Assertions.assertEquals("ug", model.value().get(0).model().baseModel().source());
        Assertions.assertEquals("zovawjvz", model.value().get(0).model().baseModel().sourceAccount());
        Assertions.assertFalse(model.value().get(0).model().isDefaultVersion());
        Assertions.assertEquals("peilpjzuaejxdu", model.value().get(0).model().skus().get(0).name());
        Assertions.assertEquals("skzbb", model.value().get(0).model().skus().get(0).usageName());
        Assertions.assertEquals(OffsetDateTime.parse("2021-08-12T02:58:19Z"),
            model.value().get(0).model().skus().get(0).deprecationDate());
        Assertions.assertEquals(939698337, model.value().get(0).model().maxCapacity());
        Assertions.assertEquals("aq", model.value().get(0).model().capabilities().get("slyjpkiid"));
        Assertions.assertEquals("git", model.value().get(0).model().finetuneCapabilities().get("medjvcslynqwwncw"));
        Assertions.assertEquals("wptfdy", model.value().get(0).model().deprecation().fineTune());
        Assertions.assertEquals("fqbuaceopzf", model.value().get(0).model().deprecation().inference());
        Assertions.assertEquals(ModelLifecycleStatus.DEPRECATING, model.value().get(0).model().lifecycleStatus());
        Assertions.assertEquals("kxbpvj", model.value().get(0).kind());
        Assertions.assertEquals("jhxxjyn", model.value().get(0).skuName());
        Assertions.assertEquals("divkrt", model.value().get(0).description());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ModelListResult model = new ModelListResult().withNextLink("wmdyvxqtay")
            .withValue(Arrays.asList(new ModelInner()
                .withModel(new AccountModelInner().withPublisher("ao")
                    .withFormat("pcqeqx")
                    .withName("z")
                    .withVersion("hzxct")
                    .withSource("gbkdmoizpos")
                    .withSourceAccount("grcfb")
                    .withBaseModel(new DeploymentModel()
                        .withPublisher("yqbexrmcqibycno")
                        .withFormat("knme")
                        .withName("sgzvahapjyzhpv")
                        .withVersion("zcjrvxdjzlmwlx")
                        .withSource("ug")
                        .withSourceAccount("zovawjvz"))
                    .withIsDefaultVersion(false)
                    .withSkus(Arrays.asList(
                        new ModelSku().withName("peilpjzuaejxdu")
                            .withUsageName("skzbb")
                            .withDeprecationDate(OffsetDateTime.parse("2021-08-12T02:58:19Z"))
                            .withCapacity(new CapacityConfig())
                            .withRateLimits(Arrays.asList(new CallRateLimit(), new CallRateLimit(), new CallRateLimit(),
                                new CallRateLimit()))
                            .withCost(Arrays.asList(new BillingMeterInfo())),
                        new ModelSku().withName("gpw")
                            .withUsageName("uh")
                            .withDeprecationDate(OffsetDateTime.parse("2021-08-14T18:03:09Z"))
                            .withCapacity(new CapacityConfig())
                            .withRateLimits(Arrays.asList(new CallRateLimit(), new CallRateLimit(), new CallRateLimit(),
                                new CallRateLimit()))
                            .withCost(Arrays.asList(new BillingMeterInfo())),
                        new ModelSku().withName("dxluu")
                            .withUsageName("ttouwaboekqvkel")
                            .withDeprecationDate(OffsetDateTime.parse("2021-10-11T10:00:24Z"))
                            .withCapacity(new CapacityConfig())
                            .withRateLimits(
                                Arrays.asList(new CallRateLimit(), new CallRateLimit(), new CallRateLimit()))
                            .withCost(Arrays.asList(new BillingMeterInfo(), new BillingMeterInfo(),
                                new BillingMeterInfo(), new BillingMeterInfo())),
                        new ModelSku().withName("sflhhca")
                            .withUsageName("n")
                            .withDeprecationDate(OffsetDateTime.parse("2021-03-25T19:19:56Z"))
                            .withCapacity(new CapacityConfig())
                            .withRateLimits(Arrays.asList(new CallRateLimit(), new CallRateLimit()))
                            .withCost(Arrays.asList(new BillingMeterInfo(), new BillingMeterInfo(),
                                new BillingMeterInfo(), new BillingMeterInfo()))))
                    .withMaxCapacity(939698337)
                    .withCapabilities(mapOf("slyjpkiid", "aq", "eli", "yexz", "bnxknalaulppg", "hnrztfol", "gvpgy",
                        "dtpnapnyiropuhp"))
                    .withFinetuneCapabilities(mapOf("medjvcslynqwwncw", "git", "pkteo", "zhxgktrmgucn"))
                    .withDeprecation(new ModelDeprecationInfo().withFineTune("wptfdy").withInference("fqbuaceopzf"))
                    .withLifecycleStatus(ModelLifecycleStatus.DEPRECATING))
                .withKind("kxbpvj")
                .withSkuName("jhxxjyn")
                .withDescription("divkrt")));
        model = BinaryData.fromObject(model).toObject(ModelListResult.class);
        Assertions.assertEquals("wmdyvxqtay", model.nextLink());
        Assertions.assertEquals("ao", model.value().get(0).model().publisher());
        Assertions.assertEquals("pcqeqx", model.value().get(0).model().format());
        Assertions.assertEquals("z", model.value().get(0).model().name());
        Assertions.assertEquals("hzxct", model.value().get(0).model().version());
        Assertions.assertEquals("gbkdmoizpos", model.value().get(0).model().source());
        Assertions.assertEquals("grcfb", model.value().get(0).model().sourceAccount());
        Assertions.assertEquals("yqbexrmcqibycno", model.value().get(0).model().baseModel().publisher());
        Assertions.assertEquals("knme", model.value().get(0).model().baseModel().format());
        Assertions.assertEquals("sgzvahapjyzhpv", model.value().get(0).model().baseModel().name());
        Assertions.assertEquals("zcjrvxdjzlmwlx", model.value().get(0).model().baseModel().version());
        Assertions.assertEquals("ug", model.value().get(0).model().baseModel().source());
        Assertions.assertEquals("zovawjvz", model.value().get(0).model().baseModel().sourceAccount());
        Assertions.assertFalse(model.value().get(0).model().isDefaultVersion());
        Assertions.assertEquals("peilpjzuaejxdu", model.value().get(0).model().skus().get(0).name());
        Assertions.assertEquals("skzbb", model.value().get(0).model().skus().get(0).usageName());
        Assertions.assertEquals(OffsetDateTime.parse("2021-08-12T02:58:19Z"),
            model.value().get(0).model().skus().get(0).deprecationDate());
        Assertions.assertEquals(939698337, model.value().get(0).model().maxCapacity());
        Assertions.assertEquals("aq", model.value().get(0).model().capabilities().get("slyjpkiid"));
        Assertions.assertEquals("git", model.value().get(0).model().finetuneCapabilities().get("medjvcslynqwwncw"));
        Assertions.assertEquals("wptfdy", model.value().get(0).model().deprecation().fineTune());
        Assertions.assertEquals("fqbuaceopzf", model.value().get(0).model().deprecation().inference());
        Assertions.assertEquals(ModelLifecycleStatus.DEPRECATING, model.value().get(0).model().lifecycleStatus());
        Assertions.assertEquals("kxbpvj", model.value().get(0).kind());
        Assertions.assertEquals("jhxxjyn", model.value().get(0).skuName());
        Assertions.assertEquals("divkrt", model.value().get(0).description());
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
