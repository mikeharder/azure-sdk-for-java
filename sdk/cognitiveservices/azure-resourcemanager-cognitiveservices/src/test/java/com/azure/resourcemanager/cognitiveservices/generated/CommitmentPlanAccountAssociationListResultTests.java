// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.cognitiveservices.models.CommitmentPlanAccountAssociationListResult;
import org.junit.jupiter.api.Assertions;

public final class CommitmentPlanAccountAssociationListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        CommitmentPlanAccountAssociationListResult model = BinaryData.fromString(
            "{\"nextLink\":\"qqfkuv\",\"value\":[{\"etag\":\"mligov\",\"tags\":{\"mloazuru\":\"xk\",\"te\":\"cbgoor\",\"vvjgslor\":\"ybfhjxa\",\"yw\":\"il\"},\"properties\":{\"accountId\":\"gkxnyedabg\"},\"id\":\"vudtjuewbcihx\",\"name\":\"uwhcjyxccybv\",\"type\":\"ayakkudzpx\"},{\"etag\":\"plmag\",\"tags\":{\"jkmnwq\":\"yohpfkyrkdbdgiog\",\"m\":\"nobaiyhddviacegf\",\"vbalxlllc\":\"tfpmvmemfnczdw\",\"ukuv\":\"podbzevwrdnh\"},\"properties\":{\"accountId\":\"swsmys\"},\"id\":\"uluqypfc\",\"name\":\"lerchpq\",\"type\":\"mfpjbabw\"}]}")
            .toObject(CommitmentPlanAccountAssociationListResult.class);
        Assertions.assertEquals("qqfkuv", model.nextLink());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        CommitmentPlanAccountAssociationListResult model
            = new CommitmentPlanAccountAssociationListResult().withNextLink("qqfkuv");
        model = BinaryData.fromObject(model).toObject(CommitmentPlanAccountAssociationListResult.class);
        Assertions.assertEquals("qqfkuv", model.nextLink());
    }
}
