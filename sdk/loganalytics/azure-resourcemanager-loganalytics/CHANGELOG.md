# Release History

## 1.2.0-beta.1 (Unreleased)

### Features Added

### Breaking Changes

### Bugs Fixed

### Other Changes

## 1.1.0 (2024-12-13)

- Azure Resource Manager LogAnalytics client library for Java. This package contains Microsoft Azure SDK for LogAnalytics Management SDK. Operational Insights Client. Package tag package-2022-10. For documentation on how to use this package, please see [Azure Management Libraries for Java](https://aka.ms/azsdk/java/mgmt).

### Breaking Changes

#### Serialization/Deserialization change

- `Jackson` is removed from dependency and no longer supported.

##### Migration Guide

If you are using `Jackson`/`ObjectMapper` for manual serialization/deserialization, configure your `ObjectMapper` for backward compatibility:
```java
objectMapper.registerModule(com.azure.core.serializer.json.jackson.JacksonJsonProvider.getJsonSerializableDatabindModule());
```

#### `models.Cluster$Definition` was modified

* `withIdentity(models.Identity)` was removed

#### `models.Cluster$Update` was modified

* `withIdentity(models.Identity)` was removed

#### `models.ClusterPatch` was modified

* `models.Identity identity()` -> `models.ManagedServiceIdentity identity()`
* `withIdentity(models.Identity)` was removed

#### `models.Cluster` was modified

* `models.Identity identity()` -> `models.ManagedServiceIdentity identity()`

### Features Added

* `models.ManagedServiceIdentity` was added

* `models.ManagedServiceIdentityType` was added

* `models.UserAssignedIdentity` was added

#### `models.Cluster$Definition` was modified

* `withIdentity(models.ManagedServiceIdentity)` was added

#### `models.Cluster$Update` was modified

* `withIdentity(models.ManagedServiceIdentity)` was added

#### `models.AzureEntityResource` was modified

* `id()` was added
* `type()` was added
* `name()` was added

#### `models.QueryPacksResource` was modified

* `id()` was added
* `name()` was added
* `type()` was added

#### `models.ClusterPatch` was modified

* `withIdentity(models.ManagedServiceIdentity)` was added

#### `models.WorkspacePatch` was modified

* `id()` was added
* `type()` was added
* `name()` was added
* `etag()` was added

## 1.0.0 (2023-10-26)

- Azure Resource Manager LogAnalytics client library for Java. This package contains Microsoft Azure SDK for LogAnalytics Management SDK. Operational Insights Client. Package tag package-2022-10. For documentation on how to use this package, please see [Azure Management Libraries for Java](https://aka.ms/azsdk/java/mgmt).

### Breaking Changes

#### `models.Table$Update` was modified

* `withResultStatistics(models.ResultStatistics)` was removed

#### `models.QueryPacks` was modified

* `deleteWithResponse(java.lang.String,java.lang.String,com.azure.core.util.Context)` was removed

#### `models.Table$Definition` was modified

* `withResultStatistics(models.ResultStatistics)` was removed

#### `models.Workspaces` was modified

* `delete(java.lang.String,java.lang.String,java.lang.Boolean)` was removed

#### `models.Schema` was modified

* `searchResults()` was removed
* `restoredLogs()` was removed

### Features Added

#### `models.SearchResults` was modified

* `azureAsyncOperationId()` was added

#### `models.Workspace$Update` was modified

* `withIdentity(models.Identity)` was added

#### `models.Workspace$Definition` was modified

* `withIdentity(models.Identity)` was added

#### `models.WorkspacePatch` was modified

* `identity()` was added
* `withIdentity(models.Identity)` was added

#### `models.RestoredLogs` was modified

* `azureAsyncOperationId()` was added

#### `models.ResultStatistics` was modified

* `scannedGb()` was added

#### `models.Workspace` was modified

* `identity()` was added

#### `models.Table` was modified

* `totalRetentionInDaysAsDefault()` was added
* `retentionInDaysAsDefault()` was added
* `cancelSearch()` was added
* `cancelSearchWithResponse(com.azure.core.util.Context)` was added

#### `models.QueryPacks` was modified

* `createOrUpdateWithoutNameWithResponse(java.lang.String,fluent.models.LogAnalyticsQueryPackInner,com.azure.core.util.Context)` was added
* `deleteByResourceGroupWithResponse(java.lang.String,java.lang.String,com.azure.core.util.Context)` was added
* `createOrUpdateWithoutName(java.lang.String,fluent.models.LogAnalyticsQueryPackInner)` was added

#### `models.Tables` was modified

* `cancelSearch(java.lang.String,java.lang.String,java.lang.String)` was added
* `cancelSearchWithResponse(java.lang.String,java.lang.String,java.lang.String,com.azure.core.util.Context)` was added

## 1.0.0-beta.3 (2022-07-07)

- Azure Resource Manager LogAnalytics client library for Java. This package contains Microsoft Azure SDK for LogAnalytics Management SDK. Operational Insights Client. Package tag package-2022-02. For documentation on how to use this package, please see [Azure Management Libraries for Java](https://aka.ms/azsdk/java/mgmt).

### Breaking Changes

* `models.ErrorAdditionalInfo` was removed

#### `models.Cluster$Definition` was modified

* `withNextLink(java.lang.String)` was removed

#### `models.DataExport` was modified

* `typePropertiesDestinationType()` was removed

#### `models.Workspace$Update` was modified

* `withFeatures(java.util.Map)` was removed
* `withProvisioningState(models.WorkspaceEntityStatus)` was removed

#### `models.Workspace$Definition` was modified

* `withProvisioningState(models.WorkspaceEntityStatus)` was removed
* `withFeatures(java.util.Map)` was removed

#### `models.WorkspacePatch` was modified

* `withFeatures(java.util.Map)` was removed
* `withProvisioningState(models.WorkspaceEntityStatus)` was removed
* `java.util.Map features()` -> `models.WorkspaceFeatures features()`

#### `models.Workspace` was modified

* `java.util.Map features()` -> `models.WorkspaceFeatures features()`

#### `models.WorkspaceSku` was modified

* `maxCapacityReservationLevel()` was removed
* `withCapacityReservationLevel(java.lang.Integer)` was removed
* `java.lang.Integer capacityReservationLevel()` -> `models.CapacityReservationLevel capacityReservationLevel()`

#### `models.Tables` was modified

* `update(java.lang.String,java.lang.String,java.lang.String,fluent.models.TableInner)` was removed
* `updateWithResponse(java.lang.String,java.lang.String,java.lang.String,fluent.models.TableInner,com.azure.core.util.Context)` was removed

#### `models.Cluster` was modified

* `nextLink()` was removed

#### `models.IdentityType` was modified

* `models.IdentityType[] values()` -> `java.util.Collection values()`
* `toString()` was removed
* `valueOf(java.lang.String)` was removed

#### `models.ClusterSku` was modified

* `withCapacity(java.lang.Long)` was removed
* `java.lang.Long capacity()` -> `models.Capacity capacity()`

### Features Added

* `models.LogAnalyticsQueryPack$Update` was added

* `models.AzureResourceProperties` was added

* `models.BillingType` was added

* `models.SystemDataAutoGenerated` was added

* `models.SourceEnum` was added

* `models.Table$Update` was added

* `models.ColumnTypeEnum` was added

* `models.Table$UpdateStages` was added

* `models.LogAnalyticsQueryPackQuerySearchPropertiesRelated` was added

* `models.CreatedByType` was added

* `models.UserIdentityProperties` was added

* `models.LogAnalyticsQueryPack$Definition` was added

* `models.QueryPacksResource` was added

* `models.LogAnalyticsQueryPack$DefinitionStages` was added

* `models.Column` was added

* `models.Capacity` was added

* `models.SearchResults` was added

* `models.WorkspaceFeatures` was added

* `models.LogAnalyticsQueryPackQuery$DefinitionStages` was added

* `models.CapacityReservationProperties` was added

* `models.LogAnalyticsQueryPackQuery` was added

* `models.LogAnalyticsQueryPackQuery$UpdateStages` was added

* `models.RestoredLogs` was added

* `models.LogAnalyticsQueryPackQuery$Update` was added

* `models.LogAnalyticsQueryPackQueryPropertiesRelated` was added

* `models.Table$DefinitionStages` was added

* `models.ResultStatistics` was added

* `models.Queries` was added

* `models.LogAnalyticsQueryPackQueryListResult` was added

* `models.LogAnalyticsQueryPack` was added

* `models.ColumnDataTypeHintEnum` was added

* `models.LogAnalyticsQueryPackListResult` was added

* `models.CapacityReservationLevel` was added

* `models.LogAnalyticsQueryPackQuerySearchProperties` was added

* `models.TablePlanEnum` was added

* `models.AssociatedWorkspace` was added

* `models.QueryPacks` was added

* `models.TagsResource` was added

* `models.Table$Definition` was added

* `models.TableTypeEnum` was added

* `models.TableSubTypeEnum` was added

* `models.ProvisioningStateEnum` was added

* `models.LogAnalyticsQueryPackQuery$Definition` was added

* `models.Schema` was added

* `models.LogAnalyticsQueryPack$UpdateStages` was added

#### `models.StorageInsight` was modified

* `resourceGroupName()` was added

#### `models.Cluster$Definition` was modified

* `withAssociatedWorkspaces(java.util.List)` was added
* `withIsDoubleEncryptionEnabled(java.lang.Boolean)` was added
* `withCapacityReservationProperties(models.CapacityReservationProperties)` was added
* `withIsAvailabilityZonesEnabled(java.lang.Boolean)` was added
* `withBillingType(models.BillingType)` was added

#### `models.Cluster$Update` was modified

* `withIdentity(models.Identity)` was added
* `withBillingType(models.BillingType)` was added

#### `LogAnalyticsManager` was modified

* `authenticate(com.azure.core.http.HttpPipeline,com.azure.core.management.profile.AzureProfile)` was added
* `queryPacks()` was added
* `queries()` was added

#### `models.LinkedStorageAccountsResource` was modified

* `resourceGroupName()` was added

#### `models.DataSource` was modified

* `resourceGroupName()` was added

#### `models.DataExport` was modified

* `typePropertiesType()` was added
* `resourceGroupName()` was added

#### `models.Workspace$Update` was modified

* `withDefaultDataCollectionRuleResourceId(java.lang.String)` was added
* `withFeatures(models.WorkspaceFeatures)` was added

#### `models.Identity` was modified

* `userAssignedIdentities()` was added
* `withUserAssignedIdentities(java.util.Map)` was added

#### `models.ClusterPatch` was modified

* `identity()` was added
* `billingType()` was added
* `withBillingType(models.BillingType)` was added
* `withIdentity(models.Identity)` was added

#### `LogAnalyticsManager$Configurable` was modified

* `withScope(java.lang.String)` was added
* `withRetryOptions(com.azure.core.http.policy.RetryOptions)` was added

#### `models.Workspace$Definition` was modified

* `withFeatures(models.WorkspaceFeatures)` was added
* `withDefaultDataCollectionRuleResourceId(java.lang.String)` was added

#### `models.WorkspacePatch` was modified

* `defaultDataCollectionRuleResourceId()` was added
* `withDefaultDataCollectionRuleResourceId(java.lang.String)` was added
* `withFeatures(models.WorkspaceFeatures)` was added

#### `models.SavedSearch` was modified

* `resourceGroupName()` was added

#### `models.LinkedService` was modified

* `resourceGroupName()` was added

#### `models.Workspace` was modified

* `systemData()` was added
* `defaultDataCollectionRuleResourceId()` was added
* `resourceGroupName()` was added

#### `models.KeyVaultProperties` was modified

* `withKeyRsaSize(java.lang.Integer)` was added
* `keyRsaSize()` was added

#### `models.WorkspaceSku` was modified

* `withCapacityReservationLevel(models.CapacityReservationLevel)` was added

#### `models.Table` was modified

* `archiveRetentionInDays()` was added
* `plan()` was added
* `migrate()` was added
* `schema()` was added
* `migrateWithResponse(com.azure.core.util.Context)` was added
* `provisioningState()` was added
* `systemData()` was added
* `lastPlanModifiedDate()` was added
* `resourceGroupName()` was added
* `refresh()` was added
* `resultStatistics()` was added
* `refresh(com.azure.core.util.Context)` was added
* `totalRetentionInDays()` was added
* `restoredLogs()` was added
* `update()` was added
* `searchResults()` was added

#### `models.Tables` was modified

* `delete(java.lang.String,java.lang.String,java.lang.String,com.azure.core.util.Context)` was added
* `getById(java.lang.String)` was added
* `deleteById(java.lang.String)` was added
* `getByIdWithResponse(java.lang.String,com.azure.core.util.Context)` was added
* `migrateWithResponse(java.lang.String,java.lang.String,java.lang.String,com.azure.core.util.Context)` was added
* `deleteByIdWithResponse(java.lang.String,com.azure.core.util.Context)` was added
* `define(java.lang.String)` was added
* `migrate(java.lang.String,java.lang.String,java.lang.String)` was added
* `delete(java.lang.String,java.lang.String,java.lang.String)` was added

#### `models.Cluster` was modified

* `capacityReservationProperties()` was added
* `billingType()` was added
* `resourceGroupName()` was added
* `lastModifiedDate()` was added
* `isDoubleEncryptionEnabled()` was added
* `associatedWorkspaces()` was added
* `createdDate()` was added
* `isAvailabilityZonesEnabled()` was added

#### `models.ClusterSku` was modified

* `withCapacity(models.Capacity)` was added

## 1.0.0-beta.2 (2021-03-30)

- Azure Resource Manager LogAnalytics client library for Java. This package contains Microsoft Azure SDK for LogAnalytics Management SDK. Operational Insights Client. Package tag package-2020-08. For documentation on how to use this package, please see [Azure Management Libraries for Java](https://aka.ms/azsdk/java/mgmt).

### New Feature

#### `models.Workspace$Update` was modified

* `withForceCmkForQuery(java.lang.Boolean)` was added
* `withFeatures(java.util.Map)` was added

#### `models.Workspace$Definition` was modified

* `withFeatures(java.util.Map)` was added
* `withForceCmkForQuery(java.lang.Boolean)` was added

#### `models.WorkspacePatch` was modified

* `withFeatures(java.util.Map)` was added
* `createdDate()` was added
* `withForceCmkForQuery(java.lang.Boolean)` was added
* `features()` was added
* `modifiedDate()` was added
* `forceCmkForQuery()` was added

#### `models.Workspace` was modified

* `createdDate()` was added
* `features()` was added
* `modifiedDate()` was added
* `forceCmkForQuery()` was added

## 1.0.0-beta.1 (2020-12-18)

- Azure Resource Manager LogAnalytics client library for Java. This package contains Microsoft Azure SDK for LogAnalytics Management SDK. Operational Insights Client. Package tag package-2020-08. For documentation on how to use this package, please see [Azure Management Libraries for Java](https://aka.ms/azsdk/java/mgmt).
