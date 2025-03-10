// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.fluent.models.DeviceSecurityGroupProperties;
import com.azure.resourcemanager.security.models.AllowlistCustomAlertRule;
import com.azure.resourcemanager.security.models.DenylistCustomAlertRule;
import com.azure.resourcemanager.security.models.ThresholdCustomAlertRule;
import com.azure.resourcemanager.security.models.TimeWindowCustomAlertRule;
import java.time.Duration;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class DeviceSecurityGroupPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DeviceSecurityGroupProperties model = BinaryData.fromString(
            "{\"thresholdRules\":[{\"ruleType\":\"ThresholdCustomAlertRule\",\"minThreshold\":313369479,\"maxThreshold\":469621378,\"displayName\":\"umasxazjpq\",\"description\":\"gual\",\"isEnabled\":false},{\"ruleType\":\"ThresholdCustomAlertRule\",\"minThreshold\":523710647,\"maxThreshold\":703719662,\"displayName\":\"e\",\"description\":\"zzvdudgwds\",\"isEnabled\":false},{\"ruleType\":\"ThresholdCustomAlertRule\",\"minThreshold\":1717823990,\"maxThreshold\":1742026379,\"displayName\":\"wmc\",\"description\":\"pwlbjnpg\",\"isEnabled\":false},{\"ruleType\":\"ThresholdCustomAlertRule\",\"minThreshold\":1146215181,\"maxThreshold\":1625524147,\"displayName\":\"dehxnltyfsoppu\",\"description\":\"esnzwde\",\"isEnabled\":false}],\"timeWindowRules\":[{\"ruleType\":\"TimeWindowCustomAlertRule\",\"timeWindowSize\":\"PT104H32M31S\",\"minThreshold\":1996811861,\"maxThreshold\":58544731,\"displayName\":\"dmoh\",\"description\":\"bqvudwxdndn\",\"isEnabled\":true},{\"ruleType\":\"TimeWindowCustomAlertRule\",\"timeWindowSize\":\"PT71H8M8S\",\"minThreshold\":1257781428,\"maxThreshold\":999513360,\"displayName\":\"jugwdkcglhsl\",\"description\":\"jdyggdtji\",\"isEnabled\":true},{\"ruleType\":\"TimeWindowCustomAlertRule\",\"timeWindowSize\":\"PT164H33M35S\",\"minThreshold\":878642575,\"maxThreshold\":1474231325,\"displayName\":\"fqweykhmene\",\"description\":\"yexfwh\",\"isEnabled\":true}],\"allowlistRules\":[{\"ruleType\":\"AllowlistCustomAlertRule\",\"allowlistValues\":[\"vyvdcs\",\"tynnaamdectehfi\",\"scjeypv\"],\"valueType\":\"String\",\"displayName\":\"kgqhcjrefovg\",\"description\":\"qsl\",\"isEnabled\":true}],\"denylistRules\":[{\"ruleType\":\"DenylistCustomAlertRule\",\"denylistValues\":[\"yqjpkcatt\"],\"valueType\":\"String\",\"displayName\":\"cr\",\"description\":\"zsqpjhvmdajvny\",\"isEnabled\":true},{\"ruleType\":\"DenylistCustomAlertRule\",\"denylistValues\":[\"nqecanoaeup\",\"hy\",\"ltrpmopj\"],\"valueType\":\"IpCidr\",\"displayName\":\"tuo\",\"description\":\"hfuiuaodsfc\",\"isEnabled\":false},{\"ruleType\":\"DenylistCustomAlertRule\",\"denylistValues\":[\"xodpuozmyzydagfu\",\"xbezyiuokktwh\"],\"valueType\":\"IpCidr\",\"displayName\":\"zywqsmbsu\",\"description\":\"xim\",\"isEnabled\":true},{\"ruleType\":\"DenylistCustomAlertRule\",\"denylistValues\":[\"ocfs\"],\"valueType\":\"IpCidr\",\"displayName\":\"mddystkiiux\",\"description\":\"yudxorrqnbp\",\"isEnabled\":false}]}")
            .toObject(DeviceSecurityGroupProperties.class);
        Assertions.assertEquals(false, model.thresholdRules().get(0).isEnabled());
        Assertions.assertEquals(313369479, model.thresholdRules().get(0).minThreshold());
        Assertions.assertEquals(469621378, model.thresholdRules().get(0).maxThreshold());
        Assertions.assertEquals(true, model.timeWindowRules().get(0).isEnabled());
        Assertions.assertEquals(1996811861, model.timeWindowRules().get(0).minThreshold());
        Assertions.assertEquals(58544731, model.timeWindowRules().get(0).maxThreshold());
        Assertions.assertEquals(Duration.parse("PT104H32M31S"), model.timeWindowRules().get(0).timeWindowSize());
        Assertions.assertEquals(true, model.allowlistRules().get(0).isEnabled());
        Assertions.assertEquals("vyvdcs", model.allowlistRules().get(0).allowlistValues().get(0));
        Assertions.assertEquals(true, model.denylistRules().get(0).isEnabled());
        Assertions.assertEquals("yqjpkcatt", model.denylistRules().get(0).denylistValues().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DeviceSecurityGroupProperties model = new DeviceSecurityGroupProperties().withThresholdRules(Arrays.asList(
            new ThresholdCustomAlertRule().withIsEnabled(false).withMinThreshold(313369479).withMaxThreshold(469621378),
            new ThresholdCustomAlertRule().withIsEnabled(false).withMinThreshold(523710647).withMaxThreshold(703719662),
            new ThresholdCustomAlertRule().withIsEnabled(false)
                .withMinThreshold(1717823990)
                .withMaxThreshold(1742026379),
            new ThresholdCustomAlertRule().withIsEnabled(false)
                .withMinThreshold(1146215181)
                .withMaxThreshold(1625524147)))
            .withTimeWindowRules(Arrays.asList(
                new TimeWindowCustomAlertRule().withIsEnabled(true)
                    .withMinThreshold(1996811861)
                    .withMaxThreshold(58544731)
                    .withTimeWindowSize(Duration.parse("PT104H32M31S")),
                new TimeWindowCustomAlertRule().withIsEnabled(true)
                    .withMinThreshold(1257781428)
                    .withMaxThreshold(999513360)
                    .withTimeWindowSize(Duration.parse("PT71H8M8S")),
                new TimeWindowCustomAlertRule().withIsEnabled(true)
                    .withMinThreshold(878642575)
                    .withMaxThreshold(1474231325)
                    .withTimeWindowSize(Duration.parse("PT164H33M35S"))))
            .withAllowlistRules(Arrays.asList(new AllowlistCustomAlertRule().withIsEnabled(true)
                .withAllowlistValues(Arrays.asList("vyvdcs", "tynnaamdectehfi", "scjeypv"))))
            .withDenylistRules(Arrays.asList(
                new DenylistCustomAlertRule().withIsEnabled(true).withDenylistValues(Arrays.asList("yqjpkcatt")),
                new DenylistCustomAlertRule().withIsEnabled(false)
                    .withDenylistValues(Arrays.asList("nqecanoaeup", "hy", "ltrpmopj")),
                new DenylistCustomAlertRule().withIsEnabled(true)
                    .withDenylistValues(Arrays.asList("xodpuozmyzydagfu", "xbezyiuokktwh")),
                new DenylistCustomAlertRule().withIsEnabled(false).withDenylistValues(Arrays.asList("ocfs"))));
        model = BinaryData.fromObject(model).toObject(DeviceSecurityGroupProperties.class);
        Assertions.assertEquals(false, model.thresholdRules().get(0).isEnabled());
        Assertions.assertEquals(313369479, model.thresholdRules().get(0).minThreshold());
        Assertions.assertEquals(469621378, model.thresholdRules().get(0).maxThreshold());
        Assertions.assertEquals(true, model.timeWindowRules().get(0).isEnabled());
        Assertions.assertEquals(1996811861, model.timeWindowRules().get(0).minThreshold());
        Assertions.assertEquals(58544731, model.timeWindowRules().get(0).maxThreshold());
        Assertions.assertEquals(Duration.parse("PT104H32M31S"), model.timeWindowRules().get(0).timeWindowSize());
        Assertions.assertEquals(true, model.allowlistRules().get(0).isEnabled());
        Assertions.assertEquals("vyvdcs", model.allowlistRules().get(0).allowlistValues().get(0));
        Assertions.assertEquals(true, model.denylistRules().get(0).isEnabled());
        Assertions.assertEquals("yqjpkcatt", model.denylistRules().get(0).denylistValues().get(0));
    }
}
