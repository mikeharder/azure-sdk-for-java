// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mariadb.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.mariadb.fluent.models.QueryStatisticProperties;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class QueryStatisticPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        QueryStatisticProperties model =
            BinaryData
                .fromString(
                    "{\"queryId\":\"xrhdwbavxbniwdjs\",\"startTime\":\"2021-12-07T05:36:29Z\",\"endTime\":\"2021-10-04T13:18:18Z\",\"aggregationFunction\":\"pgn\",\"databaseNames\":[\"x\"],\"queryExecutionCount\":4293273925570498826,\"metricName\":\"zpfzabglc\",\"metricDisplayName\":\"xwtctyqiklbbovpl\",\"metricValue\":29.60792586574493,\"metricValueUnit\":\"gy\"}")
                .toObject(QueryStatisticProperties.class);
        Assertions.assertEquals("xrhdwbavxbniwdjs", model.queryId());
        Assertions.assertEquals(OffsetDateTime.parse("2021-12-07T05:36:29Z"), model.startTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-04T13:18:18Z"), model.endTime());
        Assertions.assertEquals("pgn", model.aggregationFunction());
        Assertions.assertEquals("x", model.databaseNames().get(0));
        Assertions.assertEquals(4293273925570498826L, model.queryExecutionCount());
        Assertions.assertEquals("zpfzabglc", model.metricName());
        Assertions.assertEquals("xwtctyqiklbbovpl", model.metricDisplayName());
        Assertions.assertEquals(29.60792586574493D, model.metricValue());
        Assertions.assertEquals("gy", model.metricValueUnit());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        QueryStatisticProperties model =
            new QueryStatisticProperties()
                .withQueryId("xrhdwbavxbniwdjs")
                .withStartTime(OffsetDateTime.parse("2021-12-07T05:36:29Z"))
                .withEndTime(OffsetDateTime.parse("2021-10-04T13:18:18Z"))
                .withAggregationFunction("pgn")
                .withDatabaseNames(Arrays.asList("x"))
                .withQueryExecutionCount(4293273925570498826L)
                .withMetricName("zpfzabglc")
                .withMetricDisplayName("xwtctyqiklbbovpl")
                .withMetricValue(29.60792586574493D)
                .withMetricValueUnit("gy");
        model = BinaryData.fromObject(model).toObject(QueryStatisticProperties.class);
        Assertions.assertEquals("xrhdwbavxbniwdjs", model.queryId());
        Assertions.assertEquals(OffsetDateTime.parse("2021-12-07T05:36:29Z"), model.startTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-04T13:18:18Z"), model.endTime());
        Assertions.assertEquals("pgn", model.aggregationFunction());
        Assertions.assertEquals("x", model.databaseNames().get(0));
        Assertions.assertEquals(4293273925570498826L, model.queryExecutionCount());
        Assertions.assertEquals("zpfzabglc", model.metricName());
        Assertions.assertEquals("xwtctyqiklbbovpl", model.metricDisplayName());
        Assertions.assertEquals(29.60792586574493D, model.metricValue());
        Assertions.assertEquals("gy", model.metricValueUnit());
    }
}
