// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.purestorageblock.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.purestorageblock.fluent.models.LimitDetailsInner;
import org.junit.jupiter.api.Assertions;

public final class LimitDetailsInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        LimitDetailsInner model = BinaryData.fromString(
            "{\"storagePool\":{\"provisionedBandwidthMbPerSec\":{\"min\":4652283960591475965,\"max\":3226770590349878189},\"provisionedIops\":{\"min\":729151913745579744,\"max\":4015230803094049478},\"physicalAvailabilityZones\":[\"fkgukdkexxppof\",\"xaxcfjpgddtocjjx\",\"vpmouexhdzxib\"]},\"volume\":{\"provisionedSize\":{\"min\":4277846390701650653,\"max\":4614606581389875358}},\"protectionPolicy\":{\"frequency\":{\"min\":4100986999398487835,\"max\":2361719571524653167},\"retention\":{\"min\":7242238818162588034,\"max\":4291031946118420703}},\"performancePolicy\":{\"iopsLimit\":{\"min\":808595757398499551,\"max\":3565100103213873234},\"bandwidthLimit\":{\"min\":2543360050548789201,\"max\":4634265215487541073}}}")
            .toObject(LimitDetailsInner.class);
        Assertions.assertEquals(4652283960591475965L, model.storagePool().provisionedBandwidthMbPerSec().min());
        Assertions.assertEquals(3226770590349878189L, model.storagePool().provisionedBandwidthMbPerSec().max());
        Assertions.assertEquals(729151913745579744L, model.storagePool().provisionedIops().min());
        Assertions.assertEquals(4015230803094049478L, model.storagePool().provisionedIops().max());
        Assertions.assertEquals("fkgukdkexxppof", model.storagePool().physicalAvailabilityZones().get(0));
        Assertions.assertEquals(4277846390701650653L, model.volume().provisionedSize().min());
        Assertions.assertEquals(4614606581389875358L, model.volume().provisionedSize().max());
        Assertions.assertEquals(4100986999398487835L, model.protectionPolicy().frequency().min());
        Assertions.assertEquals(2361719571524653167L, model.protectionPolicy().frequency().max());
        Assertions.assertEquals(7242238818162588034L, model.protectionPolicy().retention().min());
        Assertions.assertEquals(4291031946118420703L, model.protectionPolicy().retention().max());
        Assertions.assertEquals(808595757398499551L, model.performancePolicy().iopsLimit().min());
        Assertions.assertEquals(3565100103213873234L, model.performancePolicy().iopsLimit().max());
        Assertions.assertEquals(2543360050548789201L, model.performancePolicy().bandwidthLimit().min());
        Assertions.assertEquals(4634265215487541073L, model.performancePolicy().bandwidthLimit().max());
    }
}
