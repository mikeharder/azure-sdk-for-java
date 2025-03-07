// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.postgresqlflexibleserver.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.postgresqlflexibleserver.fluent.models.LtrPreBackupResponseInner;
import org.junit.jupiter.api.Assertions;

public final class LtrPreBackupResponseInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        LtrPreBackupResponseInner model = BinaryData.fromString("{\"properties\":{\"numberOfContainers\":1950925712}}")
            .toObject(LtrPreBackupResponseInner.class);
        Assertions.assertEquals(1950925712, model.numberOfContainers());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        LtrPreBackupResponseInner model = new LtrPreBackupResponseInner().withNumberOfContainers(1950925712);
        model = BinaryData.fromObject(model).toObject(LtrPreBackupResponseInner.class);
        Assertions.assertEquals(1950925712, model.numberOfContainers());
    }
}
