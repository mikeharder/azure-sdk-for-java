// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.providerhub.fluent.models.CheckinManifestInfoInner;
import org.junit.jupiter.api.Assertions;

public final class CheckinManifestInfoInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        CheckinManifestInfoInner model = BinaryData
            .fromString(
                "{\"isCheckedIn\":true,\"statusMessage\":\"ytdxwit\",\"pullRequest\":\"rjaw\",\"commitId\":\"wgxhn\"}")
            .toObject(CheckinManifestInfoInner.class);
        Assertions.assertTrue(model.isCheckedIn());
        Assertions.assertEquals("ytdxwit", model.statusMessage());
        Assertions.assertEquals("rjaw", model.pullRequest());
        Assertions.assertEquals("wgxhn", model.commitId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        CheckinManifestInfoInner model = new CheckinManifestInfoInner().withIsCheckedIn(true)
            .withStatusMessage("ytdxwit")
            .withPullRequest("rjaw")
            .withCommitId("wgxhn");
        model = BinaryData.fromObject(model).toObject(CheckinManifestInfoInner.class);
        Assertions.assertTrue(model.isCheckedIn());
        Assertions.assertEquals("ytdxwit", model.statusMessage());
        Assertions.assertEquals("rjaw", model.pullRequest());
        Assertions.assertEquals("wgxhn", model.commitId());
    }
}
