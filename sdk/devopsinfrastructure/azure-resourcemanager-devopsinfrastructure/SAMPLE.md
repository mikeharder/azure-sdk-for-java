# Code snippets and samples


## ImageVersions

- [ListByImage](#imageversions_listbyimage)

## Operations

- [List](#operations_list)

## Pools

- [CheckNameAvailability](#pools_checknameavailability)
- [CreateOrUpdate](#pools_createorupdate)
- [Delete](#pools_delete)
- [GetByResourceGroup](#pools_getbyresourcegroup)
- [List](#pools_list)
- [ListByResourceGroup](#pools_listbyresourcegroup)
- [Update](#pools_update)

## ResourceDetails

- [ListByPool](#resourcedetails_listbypool)

## Sku

- [ListByLocation](#sku_listbylocation)

## SubscriptionUsages

- [Usages](#subscriptionusages_usages)
### ImageVersions_ListByImage

```java
/**
 * Samples for ImageVersions ListByImage.
 */
public final class ImageVersionsListByImageSamples {
    /*
     * x-ms-original-file: 2025-01-21/ImageVersions_ListByImage.json
     */
    /**
     * Sample code: ImageVersions_ListByImage.
     * 
     * @param manager Entry point to DevOpsInfrastructureManager.
     */
    public static void
        imageVersionsListByImage(com.azure.resourcemanager.devopsinfrastructure.DevOpsInfrastructureManager manager) {
        manager.imageVersions().listByImage("my-resource-group", "windows-2022", com.azure.core.util.Context.NONE);
    }
}
```

### Operations_List

```java
/**
 * Samples for Operations List.
 */
public final class OperationsListSamples {
    /*
     * x-ms-original-file: 2025-01-21/ListOperations.json
     */
    /**
     * Sample code: Operations_List.
     * 
     * @param manager Entry point to DevOpsInfrastructureManager.
     */
    public static void
        operationsList(com.azure.resourcemanager.devopsinfrastructure.DevOpsInfrastructureManager manager) {
        manager.operations().list(com.azure.core.util.Context.NONE);
    }
}
```

### Pools_CheckNameAvailability

```java
import com.azure.resourcemanager.devopsinfrastructure.models.CheckNameAvailability;
import com.azure.resourcemanager.devopsinfrastructure.models.DevOpsInfrastructureResourceType;

/**
 * Samples for Pools CheckNameAvailability.
 */
public final class PoolsCheckNameAvailabilitySamples {
    /*
     * x-ms-original-file: 2025-01-21/Pools_CheckNameAvailability.json
     */
    /**
     * Sample code: Pools_CheckNameAvailability.
     * 
     * @param manager Entry point to DevOpsInfrastructureManager.
     */
    public static void
        poolsCheckNameAvailability(com.azure.resourcemanager.devopsinfrastructure.DevOpsInfrastructureManager manager) {
        manager.pools()
            .checkNameAvailabilityWithResponse(
                new CheckNameAvailability().withName("mydevopspool")
                    .withType(DevOpsInfrastructureResourceType.MICROSOFT_DEV_OPS_INFRASTRUCTURE_POOLS),
                com.azure.core.util.Context.NONE);
    }
}
```

### Pools_CreateOrUpdate

```java
import com.azure.resourcemanager.devopsinfrastructure.models.AzureDevOpsOrganizationProfile;
import com.azure.resourcemanager.devopsinfrastructure.models.CertificateStoreNameOption;
import com.azure.resourcemanager.devopsinfrastructure.models.DevOpsAzureSku;
import com.azure.resourcemanager.devopsinfrastructure.models.EphemeralType;
import com.azure.resourcemanager.devopsinfrastructure.models.Organization;
import com.azure.resourcemanager.devopsinfrastructure.models.OsProfile;
import com.azure.resourcemanager.devopsinfrastructure.models.PoolImage;
import com.azure.resourcemanager.devopsinfrastructure.models.PoolProperties;
import com.azure.resourcemanager.devopsinfrastructure.models.ProvisioningState;
import com.azure.resourcemanager.devopsinfrastructure.models.SecretsManagementSettings;
import com.azure.resourcemanager.devopsinfrastructure.models.StatelessAgentProfile;
import com.azure.resourcemanager.devopsinfrastructure.models.VmssFabricProfile;
import java.util.Arrays;

/**
 * Samples for Pools CreateOrUpdate.
 */
public final class PoolsCreateOrUpdateSamples {
    /*
     * x-ms-original-file: 2025-01-21/CreateOrUpdatePool.json
     */
    /**
     * Sample code: Pools_CreateOrUpdate.
     * 
     * @param manager Entry point to DevOpsInfrastructureManager.
     */
    public static void
        poolsCreateOrUpdate(com.azure.resourcemanager.devopsinfrastructure.DevOpsInfrastructureManager manager) {
        manager.pools()
            .define("pool")
            .withRegion("eastus")
            .withExistingResourceGroup("rg")
            .withProperties(new PoolProperties().withProvisioningState(ProvisioningState.SUCCEEDED)
                .withMaximumConcurrency(10)
                .withOrganizationProfile(new AzureDevOpsOrganizationProfile().withOrganizations(
                    Arrays.asList(new Organization().withUrl("https://mseng.visualstudio.com").withOpenAccess(true))))
                .withAgentProfile(new StatelessAgentProfile())
                .withFabricProfile(
                    new VmssFabricProfile().withSku(new DevOpsAzureSku().withName("Standard_D4ads_v5"))
                        .withImages(Arrays.asList(new PoolImage()
                            .withResourceId("/MicrosoftWindowsServer/WindowsServer/2019-Datacenter/latest")
                            .withEphemeralType(EphemeralType.AUTOMATIC)))
                        .withOsProfile(
                            new OsProfile().withSecretsManagementSettings(new SecretsManagementSettings()
                                .withCertificateStoreName(CertificateStoreNameOption.ROOT)
                                .withObservedCertificates(Arrays.asList("https://abc.vault.azure.net/secrets/one"))
                                .withKeyExportable(false))))
                .withDevCenterProjectResourceId(
                    "/subscriptions/222e81d0-cf38-4dab-baa5-289bf16baaa4/resourceGroups/rg-1es-devcenter/providers/Microsoft.DevCenter/projects/1ES"))
            .create();
    }
}
```

### Pools_Delete

```java
/**
 * Samples for Pools Delete.
 */
public final class PoolsDeleteSamples {
    /*
     * x-ms-original-file: 2025-01-21/DeletePool.json
     */
    /**
     * Sample code: Pools_Delete.
     * 
     * @param manager Entry point to DevOpsInfrastructureManager.
     */
    public static void poolsDelete(com.azure.resourcemanager.devopsinfrastructure.DevOpsInfrastructureManager manager) {
        manager.pools().delete("rg", "pool", com.azure.core.util.Context.NONE);
    }
}
```

### Pools_GetByResourceGroup

```java
/**
 * Samples for Pools GetByResourceGroup.
 */
public final class PoolsGetByResourceGroupSamples {
    /*
     * x-ms-original-file: 2025-01-21/GetPool.json
     */
    /**
     * Sample code: Pools_Get.
     * 
     * @param manager Entry point to DevOpsInfrastructureManager.
     */
    public static void poolsGet(com.azure.resourcemanager.devopsinfrastructure.DevOpsInfrastructureManager manager) {
        manager.pools().getByResourceGroupWithResponse("rg", "pool", com.azure.core.util.Context.NONE);
    }
}
```

### Pools_List

```java
/**
 * Samples for Pools List.
 */
public final class PoolsListSamples {
    /*
     * x-ms-original-file: 2025-01-21/ListPoolsBySubscription.json
     */
    /**
     * Sample code: Pools_ListBySubscription.
     * 
     * @param manager Entry point to DevOpsInfrastructureManager.
     */
    public static void
        poolsListBySubscription(com.azure.resourcemanager.devopsinfrastructure.DevOpsInfrastructureManager manager) {
        manager.pools().list(com.azure.core.util.Context.NONE);
    }
}
```

### Pools_ListByResourceGroup

```java
/**
 * Samples for Pools ListByResourceGroup.
 */
public final class PoolsListByResourceGroupSamples {
    /*
     * x-ms-original-file: 2025-01-21/ListPoolsBySubscriptionAndResourceGroup.json
     */
    /**
     * Sample code: Pools_ListByResourceGroup.
     * 
     * @param manager Entry point to DevOpsInfrastructureManager.
     */
    public static void
        poolsListByResourceGroup(com.azure.resourcemanager.devopsinfrastructure.DevOpsInfrastructureManager manager) {
        manager.pools().listByResourceGroup("rg", com.azure.core.util.Context.NONE);
    }
}
```

### Pools_Update

```java
import com.azure.resourcemanager.devopsinfrastructure.models.Pool;

/**
 * Samples for Pools Update.
 */
public final class PoolsUpdateSamples {
    /*
     * x-ms-original-file: 2025-01-21/UpdatePool.json
     */
    /**
     * Sample code: Pools_Update.
     * 
     * @param manager Entry point to DevOpsInfrastructureManager.
     */
    public static void poolsUpdate(com.azure.resourcemanager.devopsinfrastructure.DevOpsInfrastructureManager manager) {
        Pool resource
            = manager.pools().getByResourceGroupWithResponse("rg", "pool", com.azure.core.util.Context.NONE).getValue();
        resource.update().apply();
    }
}
```

### ResourceDetails_ListByPool

```java
/**
 * Samples for ResourceDetails ListByPool.
 */
public final class ResourceDetailsListByPoolSamples {
    /*
     * x-ms-original-file: 2025-01-21/ResourceDetails_ListByPool.json
     */
    /**
     * Sample code: ResourceDetails_ListByPool.
     * 
     * @param manager Entry point to DevOpsInfrastructureManager.
     */
    public static void
        resourceDetailsListByPool(com.azure.resourcemanager.devopsinfrastructure.DevOpsInfrastructureManager manager) {
        manager.resourceDetails().listByPool("my-resource-group", "my-dev-ops-pool", com.azure.core.util.Context.NONE);
    }
}
```

### Sku_ListByLocation

```java
/**
 * Samples for Sku ListByLocation.
 */
public final class SkuListByLocationSamples {
    /*
     * x-ms-original-file: 2025-01-21/Sku_ListByLocation.json
     */
    /**
     * Sample code: Sku_ListByLocation.
     * 
     * @param manager Entry point to DevOpsInfrastructureManager.
     */
    public static void
        skuListByLocation(com.azure.resourcemanager.devopsinfrastructure.DevOpsInfrastructureManager manager) {
        manager.skus().listByLocation("eastus", com.azure.core.util.Context.NONE);
    }
}
```

### SubscriptionUsages_Usages

```java
/**
 * Samples for SubscriptionUsages Usages.
 */
public final class SubscriptionUsagesUsagesSamples {
    /*
     * x-ms-original-file: 2025-01-21/SubscriptionUsages_Usages.json
     */
    /**
     * Sample code: SubscriptionUsages_Usages.
     * 
     * @param manager Entry point to DevOpsInfrastructureManager.
     */
    public static void
        subscriptionUsagesUsages(com.azure.resourcemanager.devopsinfrastructure.DevOpsInfrastructureManager manager) {
        manager.subscriptionUsages().usages("eastus", com.azure.core.util.Context.NONE);
    }
}
```

