// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.desktopvirtualization.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.desktopvirtualization.fluent.models.ScalingPlanPooledScheduleInner;
import com.azure.resourcemanager.desktopvirtualization.models.DayOfWeek;
import com.azure.resourcemanager.desktopvirtualization.models.SessionHostLoadBalancingAlgorithm;
import com.azure.resourcemanager.desktopvirtualization.models.StopHostsWhen;
import com.azure.resourcemanager.desktopvirtualization.models.Time;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class ScalingPlanPooledScheduleInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ScalingPlanPooledScheduleInner model =
            BinaryData
                .fromString(
                    "{\"properties\":{\"daysOfWeek\":[\"Friday\"],\"rampUpStartTime\":{\"hour\":333094369,\"minute\":1110747875},\"rampUpLoadBalancingAlgorithm\":\"DepthFirst\",\"rampUpMinimumHostsPct\":1378070116,\"rampUpCapacityThresholdPct\":424623413,\"peakStartTime\":{\"hour\":133898645,\"minute\":45967354},\"peakLoadBalancingAlgorithm\":\"DepthFirst\",\"rampDownStartTime\":{\"hour\":969530861,\"minute\":1223607421},\"rampDownLoadBalancingAlgorithm\":\"DepthFirst\",\"rampDownMinimumHostsPct\":655680628,\"rampDownCapacityThresholdPct\":198508752,\"rampDownForceLogoffUsers\":true,\"rampDownStopHostsWhen\":\"ZeroActiveSessions\",\"rampDownWaitTimeMinutes\":1792680801,\"rampDownNotificationMessage\":\"g\",\"offPeakStartTime\":{\"hour\":642461794,\"minute\":799434019},\"offPeakLoadBalancingAlgorithm\":\"BreadthFirst\"},\"id\":\"gygev\",\"name\":\"zntypmrb\",\"type\":\"izcdrqjsd\"}")
                .toObject(ScalingPlanPooledScheduleInner.class);
        Assertions.assertEquals(DayOfWeek.FRIDAY, model.daysOfWeek().get(0));
        Assertions.assertEquals(333094369, model.rampUpStartTime().hour());
        Assertions.assertEquals(1110747875, model.rampUpStartTime().minute());
        Assertions.assertEquals(SessionHostLoadBalancingAlgorithm.DEPTH_FIRST, model.rampUpLoadBalancingAlgorithm());
        Assertions.assertEquals(1378070116, model.rampUpMinimumHostsPct());
        Assertions.assertEquals(424623413, model.rampUpCapacityThresholdPct());
        Assertions.assertEquals(133898645, model.peakStartTime().hour());
        Assertions.assertEquals(45967354, model.peakStartTime().minute());
        Assertions.assertEquals(SessionHostLoadBalancingAlgorithm.DEPTH_FIRST, model.peakLoadBalancingAlgorithm());
        Assertions.assertEquals(969530861, model.rampDownStartTime().hour());
        Assertions.assertEquals(1223607421, model.rampDownStartTime().minute());
        Assertions.assertEquals(SessionHostLoadBalancingAlgorithm.DEPTH_FIRST, model.rampDownLoadBalancingAlgorithm());
        Assertions.assertEquals(655680628, model.rampDownMinimumHostsPct());
        Assertions.assertEquals(198508752, model.rampDownCapacityThresholdPct());
        Assertions.assertEquals(true, model.rampDownForceLogoffUsers());
        Assertions.assertEquals(StopHostsWhen.ZERO_ACTIVE_SESSIONS, model.rampDownStopHostsWhen());
        Assertions.assertEquals(1792680801, model.rampDownWaitTimeMinutes());
        Assertions.assertEquals("g", model.rampDownNotificationMessage());
        Assertions.assertEquals(642461794, model.offPeakStartTime().hour());
        Assertions.assertEquals(799434019, model.offPeakStartTime().minute());
        Assertions.assertEquals(SessionHostLoadBalancingAlgorithm.BREADTH_FIRST, model.offPeakLoadBalancingAlgorithm());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ScalingPlanPooledScheduleInner model =
            new ScalingPlanPooledScheduleInner()
                .withDaysOfWeek(Arrays.asList(DayOfWeek.FRIDAY))
                .withRampUpStartTime(new Time().withHour(333094369).withMinute(1110747875))
                .withRampUpLoadBalancingAlgorithm(SessionHostLoadBalancingAlgorithm.DEPTH_FIRST)
                .withRampUpMinimumHostsPct(1378070116)
                .withRampUpCapacityThresholdPct(424623413)
                .withPeakStartTime(new Time().withHour(133898645).withMinute(45967354))
                .withPeakLoadBalancingAlgorithm(SessionHostLoadBalancingAlgorithm.DEPTH_FIRST)
                .withRampDownStartTime(new Time().withHour(969530861).withMinute(1223607421))
                .withRampDownLoadBalancingAlgorithm(SessionHostLoadBalancingAlgorithm.DEPTH_FIRST)
                .withRampDownMinimumHostsPct(655680628)
                .withRampDownCapacityThresholdPct(198508752)
                .withRampDownForceLogoffUsers(true)
                .withRampDownStopHostsWhen(StopHostsWhen.ZERO_ACTIVE_SESSIONS)
                .withRampDownWaitTimeMinutes(1792680801)
                .withRampDownNotificationMessage("g")
                .withOffPeakStartTime(new Time().withHour(642461794).withMinute(799434019))
                .withOffPeakLoadBalancingAlgorithm(SessionHostLoadBalancingAlgorithm.BREADTH_FIRST);
        model = BinaryData.fromObject(model).toObject(ScalingPlanPooledScheduleInner.class);
        Assertions.assertEquals(DayOfWeek.FRIDAY, model.daysOfWeek().get(0));
        Assertions.assertEquals(333094369, model.rampUpStartTime().hour());
        Assertions.assertEquals(1110747875, model.rampUpStartTime().minute());
        Assertions.assertEquals(SessionHostLoadBalancingAlgorithm.DEPTH_FIRST, model.rampUpLoadBalancingAlgorithm());
        Assertions.assertEquals(1378070116, model.rampUpMinimumHostsPct());
        Assertions.assertEquals(424623413, model.rampUpCapacityThresholdPct());
        Assertions.assertEquals(133898645, model.peakStartTime().hour());
        Assertions.assertEquals(45967354, model.peakStartTime().minute());
        Assertions.assertEquals(SessionHostLoadBalancingAlgorithm.DEPTH_FIRST, model.peakLoadBalancingAlgorithm());
        Assertions.assertEquals(969530861, model.rampDownStartTime().hour());
        Assertions.assertEquals(1223607421, model.rampDownStartTime().minute());
        Assertions.assertEquals(SessionHostLoadBalancingAlgorithm.DEPTH_FIRST, model.rampDownLoadBalancingAlgorithm());
        Assertions.assertEquals(655680628, model.rampDownMinimumHostsPct());
        Assertions.assertEquals(198508752, model.rampDownCapacityThresholdPct());
        Assertions.assertEquals(true, model.rampDownForceLogoffUsers());
        Assertions.assertEquals(StopHostsWhen.ZERO_ACTIVE_SESSIONS, model.rampDownStopHostsWhen());
        Assertions.assertEquals(1792680801, model.rampDownWaitTimeMinutes());
        Assertions.assertEquals("g", model.rampDownNotificationMessage());
        Assertions.assertEquals(642461794, model.offPeakStartTime().hour());
        Assertions.assertEquals(799434019, model.offPeakStartTime().minute());
        Assertions.assertEquals(SessionHostLoadBalancingAlgorithm.BREADTH_FIRST, model.offPeakLoadBalancingAlgorithm());
    }
}