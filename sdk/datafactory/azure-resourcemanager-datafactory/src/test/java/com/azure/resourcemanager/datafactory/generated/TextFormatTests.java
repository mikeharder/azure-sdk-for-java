// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.TextFormat;

public final class TextFormatTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        TextFormat model = BinaryData.fromString(
            "{\"type\":\"TextFormat\",\"columnDelimiter\":\"datamgsdaluyckhefrbh\",\"rowDelimiter\":\"datauerbgpxebjl\",\"escapeChar\":\"datacaytujraxdtpryj\",\"quoteChar\":\"datatnsewou\",\"nullValue\":\"datayms\",\"encodingName\":\"datayljurkeposehqqyl\",\"treatEmptyAsNull\":\"datactwjwdsdlzm\",\"skipLineCount\":\"dataerxxxoteehkhowgo\",\"firstRowAsHeader\":\"datavhxowpcbapnpxra\",\"serializer\":\"datawbmpspfeylqloc\",\"deserializer\":\"dataujexayglxrk\",\"\":{\"jfiuofpi\":\"datamzpaslav\",\"kyhydvikmf\":\"dataidzlvssqywjopa\"}}")
            .toObject(TextFormat.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        TextFormat model = new TextFormat().withSerializer("datawbmpspfeylqloc")
            .withDeserializer("dataujexayglxrk")
            .withColumnDelimiter("datamgsdaluyckhefrbh")
            .withRowDelimiter("datauerbgpxebjl")
            .withEscapeChar("datacaytujraxdtpryj")
            .withQuoteChar("datatnsewou")
            .withNullValue("datayms")
            .withEncodingName("datayljurkeposehqqyl")
            .withTreatEmptyAsNull("datactwjwdsdlzm")
            .withSkipLineCount("dataerxxxoteehkhowgo")
            .withFirstRowAsHeader("datavhxowpcbapnpxra");
        model = BinaryData.fromObject(model).toObject(TextFormat.class);
    }
}
