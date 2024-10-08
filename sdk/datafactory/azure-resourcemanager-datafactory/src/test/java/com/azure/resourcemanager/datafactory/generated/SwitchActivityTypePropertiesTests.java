// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.fluent.models.SwitchActivityTypeProperties;
import com.azure.resourcemanager.datafactory.models.Activity;
import com.azure.resourcemanager.datafactory.models.ActivityDependency;
import com.azure.resourcemanager.datafactory.models.ActivityOnInactiveMarkAs;
import com.azure.resourcemanager.datafactory.models.ActivityState;
import com.azure.resourcemanager.datafactory.models.DependencyCondition;
import com.azure.resourcemanager.datafactory.models.Expression;
import com.azure.resourcemanager.datafactory.models.SwitchCase;
import com.azure.resourcemanager.datafactory.models.UserProperty;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class SwitchActivityTypePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SwitchActivityTypeProperties model = BinaryData.fromString(
            "{\"on\":{\"value\":\"wqyhklhossc\"},\"cases\":[{\"value\":\"ungjb\",\"activities\":[{\"type\":\"Activity\",\"name\":\"sjgmes\",\"description\":\"hxkjjhflrg\",\"state\":\"Active\",\"onInactiveMarkAs\":\"Failed\",\"dependsOn\":[{\"activity\":\"dgqpbgzyaf\",\"dependencyConditions\":[]},{\"activity\":\"zwieizzxjjdb\",\"dependencyConditions\":[]},{\"activity\":\"xuinrsrrijcwn\",\"dependencyConditions\":[]},{\"activity\":\"htqtbcwtcqjsvlzd\",\"dependencyConditions\":[]}],\"userProperties\":[{\"name\":\"zbvdzjlkocjuajcl\",\"value\":\"datatssbkzdgwpyljn\"},{\"name\":\"iprjahgqzb\",\"value\":\"dataicyufnum\"}],\"\":{\"hmuryajppuflvazp\":\"datahnru\",\"sqmli\":\"datazo\",\"lpobzvxntsf\":\"databvfa\"}}]}],\"defaultActivities\":[{\"type\":\"Activity\",\"name\":\"kfzi\",\"description\":\"bwthvww\",\"state\":\"Inactive\",\"onInactiveMarkAs\":\"Skipped\",\"dependsOn\":[{\"activity\":\"fgpj\",\"dependencyConditions\":[\"Completed\",\"Failed\",\"Failed\",\"Skipped\"],\"\":{\"hwxdwlowy\":\"dataufpdwknxe\",\"uoxkvpl\":\"dataeqiqnjcajm\",\"jfldzvgogqu\":\"dataooomnq\",\"naxfvsyustrb\":\"datagaofobjl\"}}],\"userProperties\":[{\"name\":\"bjbknpzhfhi\",\"value\":\"datahgwbslrqbd\"},{\"name\":\"cjbxochijwpsk\",\"value\":\"dataeprumhikwahbz\"},{\"name\":\"gwkimmvatrv\",\"value\":\"datakxcrxqpenkujxdn\"}],\"\":{\"qytppjdyikdykxh\":\"dataeterjerhwgiuduw\"}},{\"type\":\"Activity\",\"name\":\"rkdtucyutrp\",\"description\":\"mukmmcvfti\",\"state\":\"Active\",\"onInactiveMarkAs\":\"Failed\",\"dependsOn\":[{\"activity\":\"jynefxaed\",\"dependencyConditions\":[\"Succeeded\"],\"\":{\"fzavsajb\":\"dataw\",\"xysmqee\":\"datahshyxhfejtywl\",\"jwqmcaofxgw\":\"datadfplwfsmpbwwp\",\"tedzxujxkxjrttzh\":\"datavjefnlxq\"}},{\"activity\":\"ambjqynwqcov\",\"dependencyConditions\":[\"Skipped\",\"Failed\",\"Skipped\",\"Skipped\"],\"\":{\"rcmayqasdve\":\"datahhbddxkoj\"}}],\"userProperties\":[{\"name\":\"a\",\"value\":\"dataxmpyvlfujsbcfogu\"},{\"name\":\"bqcqnchdzyju\",\"value\":\"datadknblbrixvcp\"},{\"name\":\"svprumttrvkhu\",\"value\":\"dataxtx\"},{\"name\":\"w\",\"value\":\"datajbanlmpmvegxgymx\"}],\"\":{\"gqhqu\":\"datatu\",\"ybgpjyuvjuowk\":\"datanj\",\"dqcgedipnnzmvt\":\"dataebpvhdk\",\"ee\":\"datattjmdtfuwx\"}}]}")
            .toObject(SwitchActivityTypeProperties.class);
        Assertions.assertEquals("wqyhklhossc", model.on().value());
        Assertions.assertEquals("ungjb", model.cases().get(0).value());
        Assertions.assertEquals("sjgmes", model.cases().get(0).activities().get(0).name());
        Assertions.assertEquals("hxkjjhflrg", model.cases().get(0).activities().get(0).description());
        Assertions.assertEquals(ActivityState.ACTIVE, model.cases().get(0).activities().get(0).state());
        Assertions.assertEquals(ActivityOnInactiveMarkAs.FAILED,
            model.cases().get(0).activities().get(0).onInactiveMarkAs());
        Assertions.assertEquals("dgqpbgzyaf", model.cases().get(0).activities().get(0).dependsOn().get(0).activity());
        Assertions.assertEquals("zbvdzjlkocjuajcl",
            model.cases().get(0).activities().get(0).userProperties().get(0).name());
        Assertions.assertEquals("kfzi", model.defaultActivities().get(0).name());
        Assertions.assertEquals("bwthvww", model.defaultActivities().get(0).description());
        Assertions.assertEquals(ActivityState.INACTIVE, model.defaultActivities().get(0).state());
        Assertions.assertEquals(ActivityOnInactiveMarkAs.SKIPPED, model.defaultActivities().get(0).onInactiveMarkAs());
        Assertions.assertEquals("fgpj", model.defaultActivities().get(0).dependsOn().get(0).activity());
        Assertions.assertEquals(DependencyCondition.COMPLETED,
            model.defaultActivities().get(0).dependsOn().get(0).dependencyConditions().get(0));
        Assertions.assertEquals("bjbknpzhfhi", model.defaultActivities().get(0).userProperties().get(0).name());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SwitchActivityTypeProperties model = new SwitchActivityTypeProperties()
            .withOn(new Expression().withValue("wqyhklhossc"))
            .withCases(Arrays.asList(new SwitchCase().withValue("ungjb")
                .withActivities(Arrays.asList(new Activity().withName("sjgmes")
                    .withDescription("hxkjjhflrg")
                    .withState(ActivityState.ACTIVE)
                    .withOnInactiveMarkAs(ActivityOnInactiveMarkAs.FAILED)
                    .withDependsOn(Arrays.asList(
                        new ActivityDependency().withActivity("dgqpbgzyaf")
                            .withDependencyConditions(Arrays.asList())
                            .withAdditionalProperties(mapOf()),
                        new ActivityDependency().withActivity("zwieizzxjjdb")
                            .withDependencyConditions(Arrays.asList())
                            .withAdditionalProperties(mapOf()),
                        new ActivityDependency().withActivity("xuinrsrrijcwn")
                            .withDependencyConditions(Arrays.asList())
                            .withAdditionalProperties(mapOf()),
                        new ActivityDependency().withActivity("htqtbcwtcqjsvlzd")
                            .withDependencyConditions(Arrays.asList())
                            .withAdditionalProperties(mapOf())))
                    .withUserProperties(
                        Arrays.asList(new UserProperty().withName("zbvdzjlkocjuajcl").withValue("datatssbkzdgwpyljn"),
                            new UserProperty().withName("iprjahgqzb").withValue("dataicyufnum")))
                    .withAdditionalProperties(mapOf("type", "Activity"))))))
            .withDefaultActivities(Arrays.asList(
                new Activity().withName("kfzi")
                    .withDescription("bwthvww")
                    .withState(ActivityState.INACTIVE)
                    .withOnInactiveMarkAs(ActivityOnInactiveMarkAs.SKIPPED)
                    .withDependsOn(Arrays.asList(new ActivityDependency().withActivity("fgpj")
                        .withDependencyConditions(Arrays.asList(DependencyCondition.COMPLETED,
                            DependencyCondition.FAILED, DependencyCondition.FAILED, DependencyCondition.SKIPPED))
                        .withAdditionalProperties(mapOf())))
                    .withUserProperties(
                        Arrays.asList(new UserProperty().withName("bjbknpzhfhi").withValue("datahgwbslrqbd"),
                            new UserProperty().withName("cjbxochijwpsk")
                                .withValue("dataeprumhikwahbz"),
                            new UserProperty().withName("gwkimmvatrv").withValue("datakxcrxqpenkujxdn")))
                    .withAdditionalProperties(mapOf("type", "Activity")),
                new Activity().withName("rkdtucyutrp")
                    .withDescription("mukmmcvfti")
                    .withState(ActivityState.ACTIVE)
                    .withOnInactiveMarkAs(ActivityOnInactiveMarkAs.FAILED)
                    .withDependsOn(Arrays.asList(
                        new ActivityDependency().withActivity("jynefxaed")
                            .withDependencyConditions(Arrays.asList(DependencyCondition.SUCCEEDED))
                            .withAdditionalProperties(mapOf()),
                        new ActivityDependency().withActivity("ambjqynwqcov")
                            .withDependencyConditions(Arrays.asList(DependencyCondition.SKIPPED,
                                DependencyCondition.FAILED, DependencyCondition.SKIPPED, DependencyCondition.SKIPPED))
                            .withAdditionalProperties(mapOf())))
                    .withUserProperties(
                        Arrays.asList(new UserProperty().withName("a").withValue("dataxmpyvlfujsbcfogu"),
                            new UserProperty().withName("bqcqnchdzyju").withValue("datadknblbrixvcp"),
                            new UserProperty().withName("svprumttrvkhu").withValue("dataxtx"),
                            new UserProperty().withName("w").withValue("datajbanlmpmvegxgymx")))
                    .withAdditionalProperties(mapOf("type", "Activity"))));
        model = BinaryData.fromObject(model).toObject(SwitchActivityTypeProperties.class);
        Assertions.assertEquals("wqyhklhossc", model.on().value());
        Assertions.assertEquals("ungjb", model.cases().get(0).value());
        Assertions.assertEquals("sjgmes", model.cases().get(0).activities().get(0).name());
        Assertions.assertEquals("hxkjjhflrg", model.cases().get(0).activities().get(0).description());
        Assertions.assertEquals(ActivityState.ACTIVE, model.cases().get(0).activities().get(0).state());
        Assertions.assertEquals(ActivityOnInactiveMarkAs.FAILED,
            model.cases().get(0).activities().get(0).onInactiveMarkAs());
        Assertions.assertEquals("dgqpbgzyaf", model.cases().get(0).activities().get(0).dependsOn().get(0).activity());
        Assertions.assertEquals("zbvdzjlkocjuajcl",
            model.cases().get(0).activities().get(0).userProperties().get(0).name());
        Assertions.assertEquals("kfzi", model.defaultActivities().get(0).name());
        Assertions.assertEquals("bwthvww", model.defaultActivities().get(0).description());
        Assertions.assertEquals(ActivityState.INACTIVE, model.defaultActivities().get(0).state());
        Assertions.assertEquals(ActivityOnInactiveMarkAs.SKIPPED, model.defaultActivities().get(0).onInactiveMarkAs());
        Assertions.assertEquals("fgpj", model.defaultActivities().get(0).dependsOn().get(0).activity());
        Assertions.assertEquals(DependencyCondition.COMPLETED,
            model.defaultActivities().get(0).dependsOn().get(0).dependencyConditions().get(0));
        Assertions.assertEquals("bjbknpzhfhi", model.defaultActivities().get(0).userProperties().get(0).name());
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
