// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.policyinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.policyinsights.models.CheckManagementGroupRestrictionsRequest;
import com.azure.resourcemanager.policyinsights.models.CheckRestrictionsResourceDetails;
import com.azure.resourcemanager.policyinsights.models.PendingField;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class CheckManagementGroupRestrictionsRequestTests {
    @Test
    public void testDeserialize() {
        CheckManagementGroupRestrictionsRequest model =
            BinaryData
                .fromString(
                    "{\"resourceDetails\":{\"apiVersion\":\"ezkojvdcp\",\"scope\":\"oqouicybxarzgszu\"},\"pendingFields\":[{\"field\":\"ciqopidoa\",\"values\":[\"odhkha\",\"xkhnzbonlwnto\",\"gokdwbwhks\",\"zcmrvexztvb\"]}]}")
                .toObject(CheckManagementGroupRestrictionsRequest.class);
        Assertions.assertEquals("ezkojvdcp", model.resourceDetails().apiVersion());
        Assertions.assertEquals("oqouicybxarzgszu", model.resourceDetails().scope());
        Assertions.assertEquals("ciqopidoa", model.pendingFields().get(0).field());
        Assertions.assertEquals("odhkha", model.pendingFields().get(0).values().get(0));
    }

    @Test
    public void testSerialize() {
        CheckManagementGroupRestrictionsRequest model =
            new CheckManagementGroupRestrictionsRequest()
                .withResourceDetails(
                    new CheckRestrictionsResourceDetails().withApiVersion("ezkojvdcp").withScope("oqouicybxarzgszu"))
                .withPendingFields(
                    Arrays
                        .asList(
                            new PendingField()
                                .withField("ciqopidoa")
                                .withValues(Arrays.asList("odhkha", "xkhnzbonlwnto", "gokdwbwhks", "zcmrvexztvb"))));
        model = BinaryData.fromObject(model).toObject(CheckManagementGroupRestrictionsRequest.class);
        Assertions.assertEquals("ezkojvdcp", model.resourceDetails().apiVersion());
        Assertions.assertEquals("oqouicybxarzgszu", model.resourceDetails().scope());
        Assertions.assertEquals("ciqopidoa", model.pendingFields().get(0).field());
        Assertions.assertEquals("odhkha", model.pendingFields().get(0).values().get(0));
    }
}
