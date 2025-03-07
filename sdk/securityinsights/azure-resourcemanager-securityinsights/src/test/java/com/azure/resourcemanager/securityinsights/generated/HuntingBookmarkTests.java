// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.securityinsights.models.HuntingBookmark;
import com.azure.resourcemanager.securityinsights.models.IncidentInfo;
import com.azure.resourcemanager.securityinsights.models.IncidentSeverity;
import com.azure.resourcemanager.securityinsights.models.UserInfo;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;

public final class HuntingBookmarkTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        HuntingBookmark model = BinaryData.fromString(
            "{\"kind\":\"Bookmark\",\"properties\":{\"created\":\"2021-07-24T11:16:02Z\",\"createdBy\":{\"email\":\"bttdumorppxe\",\"name\":\"nzbtbhj\",\"objectId\":\"4bf124bc-99cc-4faa-85c8-ac8955183b5b\"},\"displayName\":\"lkfg\",\"eventTime\":\"2021-10-17T15:49:25Z\",\"labels\":[\"uel\"],\"notes\":\"hsd\",\"query\":\"htozfikdow\",\"queryResult\":\"uuvxz\",\"updated\":\"2021-05-22T14:25:48Z\",\"updatedBy\":{\"email\":\"thhqzonosggbh\",\"name\":\"hfwdsjnkaljutiis\",\"objectId\":\"c71c5eae-5991-47f9-b132-4c85e149f460\"},\"incidentInfo\":{\"incidentId\":\"fgdkzzew\",\"severity\":\"Medium\",\"title\":\"qcrailvpnppfufl\",\"relationName\":\"dmhdlxyjr\"},\"additionalData\":{\"bcvkcvqvpkeq\":\"datagafcnihgwqapnedg\",\"obzdopcjwvnhdl\":\"datacvdrhvoodsot\",\"mutwuoe\":\"datawmgxcxrsl\",\"yqsluic\":\"datarpkhjwn\"},\"friendlyName\":\"ggkzzlvmbmpa\"},\"id\":\"odfvuefywsbp\",\"name\":\"vmwy\",\"type\":\"rfouyftaakcpw\"}")
            .toObject(HuntingBookmark.class);
        Assertions.assertEquals(OffsetDateTime.parse("2021-07-24T11:16:02Z"), model.created());
        Assertions.assertEquals(UUID.fromString("4bf124bc-99cc-4faa-85c8-ac8955183b5b"), model.createdBy().objectId());
        Assertions.assertEquals("lkfg", model.displayName());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-17T15:49:25Z"), model.eventTime());
        Assertions.assertEquals("uel", model.labels().get(0));
        Assertions.assertEquals("hsd", model.notes());
        Assertions.assertEquals("htozfikdow", model.query());
        Assertions.assertEquals("uuvxz", model.queryResult());
        Assertions.assertEquals(OffsetDateTime.parse("2021-05-22T14:25:48Z"), model.updated());
        Assertions.assertEquals(UUID.fromString("c71c5eae-5991-47f9-b132-4c85e149f460"), model.updatedBy().objectId());
        Assertions.assertEquals("fgdkzzew", model.incidentInfo().incidentId());
        Assertions.assertEquals(IncidentSeverity.MEDIUM, model.incidentInfo().severity());
        Assertions.assertEquals("qcrailvpnppfufl", model.incidentInfo().title());
        Assertions.assertEquals("dmhdlxyjr", model.incidentInfo().relationName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        HuntingBookmark model = new HuntingBookmark().withCreated(OffsetDateTime.parse("2021-07-24T11:16:02Z"))
            .withCreatedBy(new UserInfo().withObjectId(UUID.fromString("4bf124bc-99cc-4faa-85c8-ac8955183b5b")))
            .withDisplayName("lkfg")
            .withEventTime(OffsetDateTime.parse("2021-10-17T15:49:25Z"))
            .withLabels(Arrays.asList("uel"))
            .withNotes("hsd")
            .withQuery("htozfikdow")
            .withQueryResult("uuvxz")
            .withUpdated(OffsetDateTime.parse("2021-05-22T14:25:48Z"))
            .withUpdatedBy(new UserInfo().withObjectId(UUID.fromString("c71c5eae-5991-47f9-b132-4c85e149f460")))
            .withIncidentInfo(new IncidentInfo().withIncidentId("fgdkzzew")
                .withSeverity(IncidentSeverity.MEDIUM)
                .withTitle("qcrailvpnppfufl")
                .withRelationName("dmhdlxyjr"));
        model = BinaryData.fromObject(model).toObject(HuntingBookmark.class);
        Assertions.assertEquals(OffsetDateTime.parse("2021-07-24T11:16:02Z"), model.created());
        Assertions.assertEquals(UUID.fromString("4bf124bc-99cc-4faa-85c8-ac8955183b5b"), model.createdBy().objectId());
        Assertions.assertEquals("lkfg", model.displayName());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-17T15:49:25Z"), model.eventTime());
        Assertions.assertEquals("uel", model.labels().get(0));
        Assertions.assertEquals("hsd", model.notes());
        Assertions.assertEquals("htozfikdow", model.query());
        Assertions.assertEquals("uuvxz", model.queryResult());
        Assertions.assertEquals(OffsetDateTime.parse("2021-05-22T14:25:48Z"), model.updated());
        Assertions.assertEquals(UUID.fromString("c71c5eae-5991-47f9-b132-4c85e149f460"), model.updatedBy().objectId());
        Assertions.assertEquals("fgdkzzew", model.incidentInfo().incidentId());
        Assertions.assertEquals(IncidentSeverity.MEDIUM, model.incidentInfo().severity());
        Assertions.assertEquals("qcrailvpnppfufl", model.incidentInfo().title());
        Assertions.assertEquals("dmhdlxyjr", model.incidentInfo().relationName());
    }
}
