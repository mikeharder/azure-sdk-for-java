// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appconfiguration.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.appconfiguration.fluent.models.ReplicaInner;
import com.azure.resourcemanager.appconfiguration.models.ReplicaListResult;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class ReplicaListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ReplicaListResult model =
            BinaryData
                .fromString(
                    "{\"value\":[{\"location\":\"odebfqkkrbmpu\",\"properties\":{\"endpoint\":\"wflzlfbxzpuzy\",\"provisioningState\":\"Deleting\"},\"id\":\"pnq\",\"name\":\"ahmgkbrp\",\"type\":\"y\"},{\"location\":\"ibnuqqkpik\",\"properties\":{\"endpoint\":\"vtq\",\"provisioningState\":\"Canceled\"},\"id\":\"buynhijggm\",\"name\":\"bfs\",\"type\":\"arbu\"},{\"location\":\"cvpnazzmhjrunmpx\",\"properties\":{\"endpoint\":\"hrbnlankxmyskpbh\",\"provisioningState\":\"Canceled\"},\"id\":\"tkcxywnytnrsy\",\"name\":\"lqidyby\",\"type\":\"czfc\"},{\"location\":\"aaxdbabphlwrq\",\"properties\":{\"endpoint\":\"sthsu\",\"provisioningState\":\"Canceled\"},\"id\":\"mnyyazt\",\"name\":\"bt\",\"type\":\"wrqpue\"}],\"nextLink\":\"kzywbiex\"}")
                .toObject(ReplicaListResult.class);
        Assertions.assertEquals("odebfqkkrbmpu", model.value().get(0).location());
        Assertions.assertEquals("kzywbiex", model.nextLink());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ReplicaListResult model =
            new ReplicaListResult()
                .withValue(
                    Arrays
                        .asList(
                            new ReplicaInner().withLocation("odebfqkkrbmpu"),
                            new ReplicaInner().withLocation("ibnuqqkpik"),
                            new ReplicaInner().withLocation("cvpnazzmhjrunmpx"),
                            new ReplicaInner().withLocation("aaxdbabphlwrq")))
                .withNextLink("kzywbiex");
        model = BinaryData.fromObject(model).toObject(ReplicaListResult.class);
        Assertions.assertEquals("odebfqkkrbmpu", model.value().get(0).location());
        Assertions.assertEquals("kzywbiex", model.nextLink());
    }
}