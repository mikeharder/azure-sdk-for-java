// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datamigration.fluent.models.ProjectFileInner;
import com.azure.resourcemanager.datamigration.models.FileList;
import com.azure.resourcemanager.datamigration.models.ProjectFileProperties;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class FileListTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        FileList model = BinaryData.fromString(
            "{\"value\":[{\"etag\":\"lwuenvrkp\",\"properties\":{\"extension\":\"aibrebqaaysjkixq\",\"filePath\":\"qttezlwfffiakpjp\",\"lastModified\":\"2021-08-03T03:37:12Z\",\"mediaType\":\"edltmmjihyeozp\",\"size\":2963358602242054360},\"systemData\":{\"createdBy\":\"qncygupkvi\",\"createdByType\":\"Key\",\"createdAt\":\"2021-11-26T01:54:54Z\",\"lastModifiedBy\":\"xqupevzhf\",\"lastModifiedByType\":\"ManagedIdentity\",\"lastModifiedAt\":\"2021-11-14T07:44:57Z\"},\"id\":\"hojujbypelmcuv\",\"name\":\"ixbjx\",\"type\":\"fw\"}],\"nextLink\":\"lrcoolsttpki\"}")
            .toObject(FileList.class);
        Assertions.assertEquals("lwuenvrkp", model.value().get(0).etag());
        Assertions.assertEquals("aibrebqaaysjkixq", model.value().get(0).properties().extension());
        Assertions.assertEquals("qttezlwfffiakpjp", model.value().get(0).properties().filePath());
        Assertions.assertEquals("edltmmjihyeozp", model.value().get(0).properties().mediaType());
        Assertions.assertEquals("lrcoolsttpki", model.nextLink());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        FileList model = new FileList().withValue(Arrays.asList(new ProjectFileInner().withEtag("lwuenvrkp")
            .withProperties(new ProjectFileProperties().withExtension("aibrebqaaysjkixq")
                .withFilePath("qttezlwfffiakpjp")
                .withMediaType("edltmmjihyeozp"))))
            .withNextLink("lrcoolsttpki");
        model = BinaryData.fromObject(model).toObject(FileList.class);
        Assertions.assertEquals("lwuenvrkp", model.value().get(0).etag());
        Assertions.assertEquals("aibrebqaaysjkixq", model.value().get(0).properties().extension());
        Assertions.assertEquals("qttezlwfffiakpjp", model.value().get(0).properties().filePath());
        Assertions.assertEquals("edltmmjihyeozp", model.value().get(0).properties().mediaType());
        Assertions.assertEquals("lrcoolsttpki", model.nextLink());
    }
}
