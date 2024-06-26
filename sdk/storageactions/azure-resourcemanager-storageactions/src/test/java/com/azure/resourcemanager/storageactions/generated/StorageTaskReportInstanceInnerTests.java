// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storageactions.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.storageactions.fluent.models.StorageTaskReportInstanceInner;
import com.azure.resourcemanager.storageactions.models.StorageTaskReportProperties;

public final class StorageTaskReportInstanceInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        StorageTaskReportInstanceInner model = BinaryData.fromString(
            "{\"properties\":{\"taskAssignmentId\":\"baiuebbaumny\",\"storageAccountId\":\"ped\",\"startTime\":\"jn\",\"finishTime\":\"ckhsmtxpsieb\",\"objectsTargetedCount\":\"hvpesapskrdqm\",\"objectsOperatedOnCount\":\"jdhtldwkyzxu\",\"objectFailedCount\":\"kn\",\"objectsSucceededCount\":\"scwsv\",\"runStatusError\":\"otogtwrupqs\",\"runStatusEnum\":\"InProgress\",\"summaryReportPath\":\"i\",\"taskId\":\"kvceoveilovnotyf\",\"taskVersion\":\"cnjbkcnxdhbt\",\"runResult\":\"Succeeded\"},\"id\":\"ywpnvjt\",\"name\":\"qnermclfplphoxu\",\"type\":\"crpab\"}")
            .toObject(StorageTaskReportInstanceInner.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        StorageTaskReportInstanceInner model
            = new StorageTaskReportInstanceInner().withProperties(new StorageTaskReportProperties());
        model = BinaryData.fromObject(model).toObject(StorageTaskReportInstanceInner.class);
    }
}
