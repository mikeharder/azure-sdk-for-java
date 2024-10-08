// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hdinsight.containers.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.hdinsight.containers.fluent.models.ClusterLibraryInner;
import com.azure.resourcemanager.hdinsight.containers.models.ClusterLibraryList;
import com.azure.resourcemanager.hdinsight.containers.models.ClusterLibraryProperties;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class ClusterLibraryListTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ClusterLibraryList model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"type\":\"ClusterLibraryProperties\",\"remarks\":\"crxgibb\",\"timestamp\":\"2020-12-25T20:16:58Z\",\"status\":\"UNINSTALL_FAILED\",\"message\":\"fozauorsuk\"},\"id\":\"wbqpl\",\"name\":\"lvnuuepzlrph\",\"type\":\"zsoldwey\"},{\"properties\":{\"type\":\"ClusterLibraryProperties\",\"remarks\":\"dunvmnnrwrbiorkt\",\"timestamp\":\"2021-08-10T02:45:15Z\",\"status\":\"INSTALLED\",\"message\":\"hgdnhxmsivfo\"},\"id\":\"loxggdufiqn\",\"name\":\"ieuzaofjchvcyyy\",\"type\":\"fgdo\"},{\"properties\":{\"type\":\"ClusterLibraryProperties\",\"remarks\":\"ubiipuipwoqonma\",\"timestamp\":\"2021-10-21T10:35:29Z\",\"status\":\"UNINSTALL_FAILED\",\"message\":\"zshq\"},\"id\":\"impevf\",\"name\":\"mblrrilbywd\",\"type\":\"smiccwrwfscj\"},{\"properties\":{\"type\":\"ClusterLibraryProperties\",\"remarks\":\"ynszquji\",\"timestamp\":\"2021-01-17T07:53:09Z\",\"status\":\"INSTALLED\",\"message\":\"tiby\"},\"id\":\"bblgyavut\",\"name\":\"thjoxoism\",\"type\":\"ksbpimlqoljx\"}],\"nextLink\":\"gxxlxsffgcvizq\"}")
            .toObject(ClusterLibraryList.class);
        Assertions.assertEquals("crxgibb", model.value().get(0).properties().remarks());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ClusterLibraryList model = new ClusterLibraryList().withValue(Arrays.asList(
            new ClusterLibraryInner().withProperties(new ClusterLibraryProperties().withRemarks("crxgibb")),
            new ClusterLibraryInner().withProperties(new ClusterLibraryProperties().withRemarks("dunvmnnrwrbiorkt")),
            new ClusterLibraryInner().withProperties(new ClusterLibraryProperties().withRemarks("ubiipuipwoqonma")),
            new ClusterLibraryInner().withProperties(new ClusterLibraryProperties().withRemarks("ynszquji"))));
        model = BinaryData.fromObject(model).toObject(ClusterLibraryList.class);
        Assertions.assertEquals("crxgibb", model.value().get(0).properties().remarks());
    }
}
