// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datamigration.models.MigrateSqlServerSqlDbTaskOutputDatabaseLevelValidationResult;

public final class MigrateSqlServerSqlDbTaskOutputDatabaseLevelValidationResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        MigrateSqlServerSqlDbTaskOutputDatabaseLevelValidationResult model = BinaryData.fromString(
            "{\"resultType\":\"MigrationDatabaseLevelValidationOutput\",\"id\":\"mmuabwi\",\"migrationId\":\"iygbpvn\",\"sourceDatabaseName\":\"wmtxkyctwwgz\",\"targetDatabaseName\":\"jlmec\",\"startedOn\":\"2021-05-06T22:37:38Z\",\"endedOn\":\"2021-06-09T04:03:52Z\",\"dataIntegrityValidationResult\":{\"failedObjects\":{\"tmoqqtlffhzb\":\"neezaifg\"},\"validationErrors\":{\"text\":\"jjjavfqnvhnq\",\"severity\":\"Error\"}},\"schemaValidationResult\":{\"schemaDifferences\":{\"objectName\":\"iyet\",\"objectType\":\"Table\",\"updateAction\":\"ChangedOnTarget\"},\"validationErrors\":{\"text\":\"bztjhqtfbovnynkb\",\"severity\":\"Error\"},\"sourceDatabaseObjectCount\":{\"p\":6087710670618433080,\"kzyaup\":6008885383686808215,\"cxnafbwqrooh\":8485007217871910477},\"targetDatabaseObjectCount\":{\"aonurjtumg\":694260076287453599,\"pv\":7748280938760549360,\"slclblyjxltbsju\":7238386177470152085}},\"queryAnalysisValidationResult\":{\"queryResults\":{\"queryText\":\"f\",\"statementsInBatch\":5282271236189869633,\"sourceResult\":{\"executionCount\":9050305746042718833,\"cpuTimeMs\":74.84599,\"elapsedTimeMs\":51.06553,\"waitStats\":{\"d\":{\"waitType\":\"ccyd\",\"waitTimeMs\":84.068016,\"waitCount\":3571783690197600648},\"qm\":{\"waitType\":\"ky\",\"waitTimeMs\":78.215355,\"waitCount\":7053269008494904369},\"oaguhic\":{\"waitType\":\"zgwldoychillcec\",\"waitTimeMs\":64.80049,\"waitCount\":8319031555808763080}},\"hasErrors\":false,\"sqlErrors\":[\"stacsjvhrweftkwq\",\"jp\",\"vssehaepw\",\"mcxtczhu\"]},\"targetResult\":{\"executionCount\":1708986968372039784,\"cpuTimeMs\":77.6167,\"elapsedTimeMs\":25.10578,\"waitStats\":{\"v\":{\"waitType\":\"spyd\",\"waitTimeMs\":53.97322,\"waitCount\":1014590508316855749},\"gbhgau\":{\"waitType\":\"ulrtywikdmh\",\"waitTimeMs\":42.28267,\"waitCount\":8589946500530915839},\"zoeo\":{\"waitType\":\"dixmxufrsryjq\",\"waitTimeMs\":74.03639,\"waitCount\":7027488377284563642},\"asfaymxbulpze\":{\"waitType\":\"vjhvefgwbm\",\"waitTimeMs\":4.0716887,\"waitCount\":2962662676791309250}},\"hasErrors\":false,\"sqlErrors\":[\"kyojwyvfk\",\"btsuahxs\",\"xjcmmzrrsc\"]}},\"validationErrors\":{\"text\":\"wsdrnpxqwodif\",\"severity\":\"Warning\"}},\"status\":\"Completed\"}")
            .toObject(MigrateSqlServerSqlDbTaskOutputDatabaseLevelValidationResult.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        MigrateSqlServerSqlDbTaskOutputDatabaseLevelValidationResult model
            = new MigrateSqlServerSqlDbTaskOutputDatabaseLevelValidationResult();
        model
            = BinaryData.fromObject(model).toObject(MigrateSqlServerSqlDbTaskOutputDatabaseLevelValidationResult.class);
    }
}
