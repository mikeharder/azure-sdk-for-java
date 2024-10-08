// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.analytics.purview.datamap.generated;

import com.azure.analytics.purview.datamap.models.AtlasAttributeDef;
import com.azure.analytics.purview.datamap.models.AtlasClassificationDef;
import com.azure.analytics.purview.datamap.models.AtlasEntityDef;
import com.azure.analytics.purview.datamap.models.AtlasEnumDef;
import com.azure.analytics.purview.datamap.models.AtlasRelationshipDef;
import com.azure.analytics.purview.datamap.models.AtlasStructDef;
import com.azure.analytics.purview.datamap.models.AtlasTypesDef;
import com.azure.analytics.purview.datamap.models.CardinalityValue;
import com.azure.analytics.purview.datamap.models.TermTemplateDef;
import com.azure.analytics.purview.datamap.models.TypeCategory;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public final class TypeListTermTemplateDefsTests extends DataMapClientTestBase {
    @Test
    @Disabled
    public void testTypeListTermTemplateDefsTests() {
        // method invocation
        AtlasTypesDef response = typeDefinitionClient.get(null, TypeCategory.TERM_TEMPLATE);

        // response assertion
        Assertions.assertNotNull(response);
        // verify property "classificationDefs"
        List<AtlasClassificationDef> responseClassificationDefs = response.getClassificationDefs();
        Assertions.assertEquals(0, responseClassificationDefs.size());
        // verify property "entityDefs"
        List<AtlasEntityDef> responseEntityDefs = response.getEntityDefs();
        Assertions.assertEquals(0, responseEntityDefs.size());
        // verify property "enumDefs"
        List<AtlasEnumDef> responseEnumDefs = response.getEnumDefs();
        Assertions.assertEquals(0, responseEnumDefs.size());
        // verify property "relationshipDefs"
        List<AtlasRelationshipDef> responseRelationshipDefs = response.getRelationshipDefs();
        Assertions.assertEquals(0, responseRelationshipDefs.size());
        // verify property "structDefs"
        List<AtlasStructDef> responseStructDefs = response.getStructDefs();
        Assertions.assertEquals(0, responseStructDefs.size());
        // verify property "termTemplateDefs"
        List<TermTemplateDef> responseTermTemplateDefs = response.getTermTemplateDefs();
        TermTemplateDef responseTermTemplateDefsFirstItem = responseTermTemplateDefs.iterator().next();
        Assertions.assertNotNull(responseTermTemplateDefsFirstItem);
        Assertions.assertEquals(TypeCategory.TERM_TEMPLATE, responseTermTemplateDefsFirstItem.getCategory());
        Assertions.assertEquals(1606300465443L, responseTermTemplateDefsFirstItem.getCreateTime());
        Assertions.assertEquals("ExampleCreator", responseTermTemplateDefsFirstItem.getCreatedBy());
        Assertions.assertEquals("This is the description", responseTermTemplateDefsFirstItem.getDescription());
        Assertions.assertEquals("d776af9c-985c-4168-abb2-477523dbfc70", responseTermTemplateDefsFirstItem.getGuid());
        Assertions.assertEquals("MS KPI", responseTermTemplateDefsFirstItem.getName());
        Assertions.assertEquals("1.0", responseTermTemplateDefsFirstItem.getTypeVersion());
        Assertions.assertEquals(1606300465443L, responseTermTemplateDefsFirstItem.getUpdateTime());
        Assertions.assertEquals("ExampleUpdator", responseTermTemplateDefsFirstItem.getUpdatedBy());
        Assertions.assertEquals(1L, responseTermTemplateDefsFirstItem.getVersion());
        Assertions.assertEquals("1", responseTermTemplateDefsFirstItem.getLastModifiedTS());
        List<AtlasAttributeDef> responseTermTemplateDefsFirstItemAttributeDefs
            = responseTermTemplateDefsFirstItem.getAttributeDefs();
        AtlasAttributeDef responseTermTemplateDefsFirstItemAttributeDefsFirstItem
            = responseTermTemplateDefsFirstItemAttributeDefs.iterator().next();
        Assertions.assertNotNull(responseTermTemplateDefsFirstItemAttributeDefsFirstItem);
        Assertions.assertEquals(CardinalityValue.SINGLE,
            responseTermTemplateDefsFirstItemAttributeDefsFirstItem.getCardinality());
        Assertions.assertEquals(false,
            responseTermTemplateDefsFirstItemAttributeDefsFirstItem.isIncludeInNotification());
        Assertions.assertEquals(false, responseTermTemplateDefsFirstItemAttributeDefsFirstItem.isIndexable());
        Assertions.assertEquals(true, responseTermTemplateDefsFirstItemAttributeDefsFirstItem.isOptional());
        Assertions.assertEquals(false, responseTermTemplateDefsFirstItemAttributeDefsFirstItem.isUnique());
        Assertions.assertEquals("date", responseTermTemplateDefsFirstItemAttributeDefsFirstItem.getName());
        Assertions.assertNotNull(responseTermTemplateDefsFirstItemAttributeDefsFirstItem.getOptions());
        Assertions.assertEquals("date", responseTermTemplateDefsFirstItemAttributeDefsFirstItem.getTypeName());
        Assertions.assertEquals(1, responseTermTemplateDefsFirstItemAttributeDefsFirstItem.getValuesMaxCount());
        Assertions.assertEquals(0, responseTermTemplateDefsFirstItemAttributeDefsFirstItem.getValuesMinCount());
    }
}
