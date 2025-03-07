// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storage.generated;

import com.azure.resourcemanager.storage.models.AccountImmutabilityPolicyProperties;
import com.azure.resourcemanager.storage.models.AccountImmutabilityPolicyState;
import com.azure.resourcemanager.storage.models.AllowedCopyScope;
import com.azure.resourcemanager.storage.models.Bypass;
import com.azure.resourcemanager.storage.models.DefaultAction;
import com.azure.resourcemanager.storage.models.DnsEndpointType;
import com.azure.resourcemanager.storage.models.Encryption;
import com.azure.resourcemanager.storage.models.EncryptionIdentity;
import com.azure.resourcemanager.storage.models.EncryptionService;
import com.azure.resourcemanager.storage.models.EncryptionServices;
import com.azure.resourcemanager.storage.models.ExpirationAction;
import com.azure.resourcemanager.storage.models.ExtendedLocation;
import com.azure.resourcemanager.storage.models.ExtendedLocationTypes;
import com.azure.resourcemanager.storage.models.Identity;
import com.azure.resourcemanager.storage.models.IdentityType;
import com.azure.resourcemanager.storage.models.ImmutableStorageAccount;
import com.azure.resourcemanager.storage.models.KeyPolicy;
import com.azure.resourcemanager.storage.models.KeySource;
import com.azure.resourcemanager.storage.models.KeyType;
import com.azure.resourcemanager.storage.models.KeyVaultProperties;
import com.azure.resourcemanager.storage.models.Kind;
import com.azure.resourcemanager.storage.models.MinimumTlsVersion;
import com.azure.resourcemanager.storage.models.NetworkRuleSet;
import com.azure.resourcemanager.storage.models.PublicNetworkAccess;
import com.azure.resourcemanager.storage.models.RoutingChoice;
import com.azure.resourcemanager.storage.models.RoutingPreference;
import com.azure.resourcemanager.storage.models.SasPolicy;
import com.azure.resourcemanager.storage.models.Sku;
import com.azure.resourcemanager.storage.models.SkuName;
import com.azure.resourcemanager.storage.models.StorageAccountCreateParameters;
import com.azure.resourcemanager.storage.models.UserAssignedIdentity;
import com.azure.resourcemanager.storage.models.VirtualNetworkRule;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Samples for StorageAccounts Create.
 */
public final class StorageAccountsCreateSamples {
    /*
     * x-ms-original-file:
     * specification/storage/resource-manager/Microsoft.Storage/stable/2024-01-01/examples/NfsV3AccountCreate.json
     */
    /**
     * Sample code: NfsV3AccountCreate.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void nfsV3AccountCreate(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.storageAccounts()
            .manager()
            .serviceClient()
            .getStorageAccounts()
            .create("res9101", "sto4445", new StorageAccountCreateParameters()
                .withSku(new Sku().withName(SkuName.PREMIUM_LRS))
                .withKind(Kind.BLOCK_BLOB_STORAGE)
                .withLocation("eastus")
                .withNetworkRuleSet(new NetworkRuleSet().withBypass(Bypass.AZURE_SERVICES)
                    .withVirtualNetworkRules(Arrays.asList(new VirtualNetworkRule().withVirtualNetworkResourceId(
                        "/subscriptions/{subscription-id}/resourceGroups/res9101/providers/Microsoft.Network/virtualNetworks/net123/subnets/subnet12")))
                    .withIpRules(Arrays.asList())
                    .withDefaultAction(DefaultAction.ALLOW))
                .withEnableHttpsTrafficOnly(false)
                .withEnableExtendedGroups(true)
                .withIsHnsEnabled(true)
                .withEnableNfsV3(true), com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: specification/storage/resource-manager/Microsoft.Storage/stable/2024-01-01/examples/
     * StorageAccountCreatePremiumBlockBlobStorage.json
     */
    /**
     * Sample code: StorageAccountCreatePremiumBlockBlobStorage.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void
        storageAccountCreatePremiumBlockBlobStorage(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.storageAccounts()
            .manager()
            .serviceClient()
            .getStorageAccounts()
            .create("res9101", "sto4445",
                new StorageAccountCreateParameters().withSku(new Sku().withName(SkuName.PREMIUM_LRS))
                    .withKind(Kind.BLOCK_BLOB_STORAGE)
                    .withLocation("eastus")
                    .withTags(mapOf("key1", "fakeTokenPlaceholder", "key2", "fakeTokenPlaceholder"))
                    .withEncryption(new Encryption()
                        .withServices(new EncryptionServices()
                            .withBlob(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT))
                            .withFile(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT)))
                        .withKeySource(KeySource.MICROSOFT_STORAGE)
                        .withRequireInfrastructureEncryption(false))
                    .withMinimumTlsVersion(MinimumTlsVersion.TLS1_2)
                    .withAllowSharedKeyAccess(true),
                com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: specification/storage/resource-manager/Microsoft.Storage/stable/2024-01-01/examples/
     * StorageAccountCreateWithImmutabilityPolicy.json
     */
    /**
     * Sample code: StorageAccountCreateWithImmutabilityPolicy.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void
        storageAccountCreateWithImmutabilityPolicy(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.storageAccounts()
            .manager()
            .serviceClient()
            .getStorageAccounts()
            .create("res9101", "sto4445",
                new StorageAccountCreateParameters().withSku(new Sku().withName(SkuName.STANDARD_GRS))
                    .withKind(Kind.STORAGE)
                    .withLocation("eastus")
                    .withExtendedLocation(
                        new ExtendedLocation().withName("losangeles001").withType(ExtendedLocationTypes.EDGE_ZONE))
                    .withImmutableStorageWithVersioning(new ImmutableStorageAccount().withEnabled(true)
                        .withImmutabilityPolicy(
                            new AccountImmutabilityPolicyProperties().withImmutabilityPeriodSinceCreationInDays(15)
                                .withState(AccountImmutabilityPolicyState.UNLOCKED)
                                .withAllowProtectedAppendWrites(true))),
                com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: specification/storage/resource-manager/Microsoft.Storage/stable/2024-01-01/examples/
     * StorageAccountCreateAllowedCopyScopeToPrivateLink.json
     */
    /**
     * Sample code: StorageAccountCreateAllowedCopyScopeToPrivateLink.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void
        storageAccountCreateAllowedCopyScopeToPrivateLink(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.storageAccounts()
            .manager()
            .serviceClient()
            .getStorageAccounts()
            .create("res9101", "sto4445", new StorageAccountCreateParameters()
                .withSku(new Sku().withName(SkuName.STANDARD_GRS))
                .withKind(Kind.STORAGE)
                .withLocation("eastus")
                .withTags(mapOf("key1", "fakeTokenPlaceholder", "key2", "fakeTokenPlaceholder"))
                .withAllowedCopyScope(AllowedCopyScope.PRIVATE_LINK)
                .withSasPolicy(
                    new SasPolicy().withSasExpirationPeriod("1.15:59:59").withExpirationAction(ExpirationAction.LOG))
                .withKeyPolicy(new KeyPolicy().withKeyExpirationPeriodInDays(20))
                .withEncryption(new Encryption()
                    .withServices(new EncryptionServices()
                        .withBlob(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT))
                        .withFile(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT)))
                    .withKeySource(KeySource.MICROSOFT_STORAGE)
                    .withRequireInfrastructureEncryption(false))
                .withIsHnsEnabled(true)
                .withRoutingPreference(new RoutingPreference().withRoutingChoice(RoutingChoice.MICROSOFT_ROUTING)
                    .withPublishMicrosoftEndpoints(true)
                    .withPublishInternetEndpoints(true))
                .withAllowBlobPublicAccess(false)
                .withMinimumTlsVersion(MinimumTlsVersion.TLS1_2)
                .withAllowSharedKeyAccess(true), com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file:
     * specification/storage/resource-manager/Microsoft.Storage/stable/2024-01-01/examples/StorageAccountCreate.json
     */
    /**
     * Sample code: StorageAccountCreate.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void storageAccountCreate(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.storageAccounts()
            .manager()
            .serviceClient()
            .getStorageAccounts()
            .create("res9101", "sto4445", new StorageAccountCreateParameters()
                .withSku(new Sku().withName(SkuName.STANDARD_GRS))
                .withKind(Kind.STORAGE)
                .withLocation("eastus")
                .withExtendedLocation(
                    new ExtendedLocation().withName("losangeles001").withType(ExtendedLocationTypes.EDGE_ZONE))
                .withTags(mapOf("key1", "fakeTokenPlaceholder", "key2", "fakeTokenPlaceholder"))
                .withSasPolicy(
                    new SasPolicy().withSasExpirationPeriod("1.15:59:59").withExpirationAction(ExpirationAction.LOG))
                .withKeyPolicy(new KeyPolicy().withKeyExpirationPeriodInDays(20))
                .withEncryption(new Encryption()
                    .withServices(new EncryptionServices()
                        .withBlob(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT))
                        .withFile(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT)))
                    .withKeySource(KeySource.MICROSOFT_STORAGE)
                    .withRequireInfrastructureEncryption(false))
                .withIsSftpEnabled(true)
                .withIsHnsEnabled(true)
                .withRoutingPreference(new RoutingPreference().withRoutingChoice(RoutingChoice.MICROSOFT_ROUTING)
                    .withPublishMicrosoftEndpoints(true)
                    .withPublishInternetEndpoints(true))
                .withAllowBlobPublicAccess(false)
                .withMinimumTlsVersion(MinimumTlsVersion.TLS1_2)
                .withAllowSharedKeyAccess(true)
                .withDefaultToOAuthAuthentication(false), com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: specification/storage/resource-manager/Microsoft.Storage/stable/2024-01-01/examples/
     * StorageAccountCreateEnablePublicNetworkAccess.json
     */
    /**
     * Sample code: StorageAccountCreateEnablePublicNetworkAccess.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void
        storageAccountCreateEnablePublicNetworkAccess(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.storageAccounts()
            .manager()
            .serviceClient()
            .getStorageAccounts()
            .create("res9101", "sto4445", new StorageAccountCreateParameters()
                .withSku(new Sku().withName(SkuName.STANDARD_GRS))
                .withKind(Kind.STORAGE)
                .withLocation("eastus")
                .withExtendedLocation(
                    new ExtendedLocation().withName("losangeles001").withType(ExtendedLocationTypes.EDGE_ZONE))
                .withTags(mapOf("key1", "fakeTokenPlaceholder", "key2", "fakeTokenPlaceholder"))
                .withPublicNetworkAccess(PublicNetworkAccess.ENABLED)
                .withSasPolicy(
                    new SasPolicy().withSasExpirationPeriod("1.15:59:59").withExpirationAction(ExpirationAction.LOG))
                .withKeyPolicy(new KeyPolicy().withKeyExpirationPeriodInDays(20))
                .withEncryption(new Encryption()
                    .withServices(new EncryptionServices()
                        .withBlob(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT))
                        .withFile(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT)))
                    .withKeySource(KeySource.MICROSOFT_STORAGE)
                    .withRequireInfrastructureEncryption(false))
                .withIsHnsEnabled(true)
                .withRoutingPreference(new RoutingPreference().withRoutingChoice(RoutingChoice.MICROSOFT_ROUTING)
                    .withPublishMicrosoftEndpoints(true)
                    .withPublishInternetEndpoints(true))
                .withAllowBlobPublicAccess(false)
                .withMinimumTlsVersion(MinimumTlsVersion.TLS1_2)
                .withAllowSharedKeyAccess(true), com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: specification/storage/resource-manager/Microsoft.Storage/stable/2024-01-01/examples/
     * StorageAccountCreateAllowedCopyScopeToAAD.json
     */
    /**
     * Sample code: StorageAccountCreateAllowedCopyScopeToAAD.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void storageAccountCreateAllowedCopyScopeToAAD(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.storageAccounts()
            .manager()
            .serviceClient()
            .getStorageAccounts()
            .create("res9101", "sto4445", new StorageAccountCreateParameters()
                .withSku(new Sku().withName(SkuName.STANDARD_GRS))
                .withKind(Kind.STORAGE)
                .withLocation("eastus")
                .withTags(mapOf("key1", "fakeTokenPlaceholder", "key2", "fakeTokenPlaceholder"))
                .withAllowedCopyScope(AllowedCopyScope.AAD)
                .withSasPolicy(
                    new SasPolicy().withSasExpirationPeriod("1.15:59:59").withExpirationAction(ExpirationAction.LOG))
                .withKeyPolicy(new KeyPolicy().withKeyExpirationPeriodInDays(20))
                .withEncryption(new Encryption()
                    .withServices(new EncryptionServices()
                        .withBlob(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT))
                        .withFile(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT)))
                    .withKeySource(KeySource.MICROSOFT_STORAGE)
                    .withRequireInfrastructureEncryption(false))
                .withIsHnsEnabled(true)
                .withRoutingPreference(new RoutingPreference().withRoutingChoice(RoutingChoice.MICROSOFT_ROUTING)
                    .withPublishMicrosoftEndpoints(true)
                    .withPublishInternetEndpoints(true))
                .withAllowBlobPublicAccess(false)
                .withMinimumTlsVersion(MinimumTlsVersion.TLS1_2)
                .withAllowSharedKeyAccess(true), com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: specification/storage/resource-manager/Microsoft.Storage/stable/2024-01-01/examples/
     * StorageAccountCreateUserAssignedIdentityWithFederatedIdentityClientId.json
     */
    /**
     * Sample code: StorageAccountCreateUserAssignedIdentityWithFederatedIdentityClientId.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void storageAccountCreateUserAssignedIdentityWithFederatedIdentityClientId(
        com.azure.resourcemanager.AzureResourceManager azure) {
        azure.storageAccounts()
            .manager()
            .serviceClient()
            .getStorageAccounts()
            .create("res131918", "sto131918", new StorageAccountCreateParameters()
                .withSku(new Sku().withName(SkuName.STANDARD_LRS))
                .withKind(Kind.STORAGE)
                .withLocation("eastus")
                .withIdentity(new Identity().withType(IdentityType.USER_ASSIGNED)
                    .withUserAssignedIdentities(mapOf(
                        "/subscriptions/{subscription-id}/resourceGroups/res9101/providers/Microsoft.ManagedIdentity/userAssignedIdentities/{managed-identity-name}",
                        new UserAssignedIdentity())))
                .withEncryption(new Encryption()
                    .withServices(new EncryptionServices()
                        .withBlob(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT))
                        .withFile(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT)))
                    .withKeySource(KeySource.MICROSOFT_KEYVAULT)
                    .withKeyVaultProperties(new KeyVaultProperties().withKeyName("fakeTokenPlaceholder")
                        .withKeyVersion("fakeTokenPlaceholder")
                        .withKeyVaultUri("fakeTokenPlaceholder"))
                    .withEncryptionIdentity(new EncryptionIdentity().withEncryptionUserAssignedIdentity(
                        "/subscriptions/{subscription-id}/resourceGroups/res9101/providers/Microsoft.ManagedIdentity/userAssignedIdentities/{managed-identity-name}")
                        .withEncryptionFederatedIdentityClientId("f83c6b1b-4d34-47e4-bb34-9d83df58b540"))),
                com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: specification/storage/resource-manager/Microsoft.Storage/stable/2024-01-01/examples/
     * StorageAccountCreateDisallowPublicNetworkAccess.json
     */
    /**
     * Sample code: StorageAccountCreateDisallowPublicNetworkAccess.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void
        storageAccountCreateDisallowPublicNetworkAccess(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.storageAccounts()
            .manager()
            .serviceClient()
            .getStorageAccounts()
            .create("res9101", "sto4445", new StorageAccountCreateParameters()
                .withSku(new Sku().withName(SkuName.STANDARD_GRS))
                .withKind(Kind.STORAGE)
                .withLocation("eastus")
                .withExtendedLocation(
                    new ExtendedLocation().withName("losangeles001").withType(ExtendedLocationTypes.EDGE_ZONE))
                .withTags(mapOf("key1", "fakeTokenPlaceholder", "key2", "fakeTokenPlaceholder"))
                .withPublicNetworkAccess(PublicNetworkAccess.DISABLED)
                .withSasPolicy(
                    new SasPolicy().withSasExpirationPeriod("1.15:59:59").withExpirationAction(ExpirationAction.LOG))
                .withKeyPolicy(new KeyPolicy().withKeyExpirationPeriodInDays(20))
                .withEncryption(new Encryption()
                    .withServices(new EncryptionServices()
                        .withBlob(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT))
                        .withFile(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT)))
                    .withKeySource(KeySource.MICROSOFT_STORAGE)
                    .withRequireInfrastructureEncryption(false))
                .withIsHnsEnabled(true)
                .withRoutingPreference(new RoutingPreference().withRoutingChoice(RoutingChoice.MICROSOFT_ROUTING)
                    .withPublishMicrosoftEndpoints(true)
                    .withPublishInternetEndpoints(true))
                .withAllowBlobPublicAccess(false)
                .withMinimumTlsVersion(MinimumTlsVersion.TLS1_2)
                .withAllowSharedKeyAccess(true), com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: specification/storage/resource-manager/Microsoft.Storage/stable/2024-01-01/examples/
     * StorageAccountCreateDnsEndpointTypeToStandard.json
     */
    /**
     * Sample code: StorageAccountCreateDnsEndpointTypeToStandard.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void
        storageAccountCreateDnsEndpointTypeToStandard(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.storageAccounts()
            .manager()
            .serviceClient()
            .getStorageAccounts()
            .create("res9101", "sto4445", new StorageAccountCreateParameters()
                .withSku(new Sku().withName(SkuName.STANDARD_GRS))
                .withKind(Kind.STORAGE)
                .withLocation("eastus")
                .withExtendedLocation(
                    new ExtendedLocation().withName("losangeles001").withType(ExtendedLocationTypes.EDGE_ZONE))
                .withTags(mapOf("key1", "fakeTokenPlaceholder", "key2", "fakeTokenPlaceholder"))
                .withSasPolicy(
                    new SasPolicy().withSasExpirationPeriod("1.15:59:59").withExpirationAction(ExpirationAction.LOG))
                .withKeyPolicy(new KeyPolicy().withKeyExpirationPeriodInDays(20))
                .withEncryption(new Encryption()
                    .withServices(new EncryptionServices()
                        .withBlob(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT))
                        .withFile(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT)))
                    .withKeySource(KeySource.MICROSOFT_STORAGE)
                    .withRequireInfrastructureEncryption(false))
                .withIsSftpEnabled(true)
                .withIsHnsEnabled(true)
                .withRoutingPreference(new RoutingPreference().withRoutingChoice(RoutingChoice.MICROSOFT_ROUTING)
                    .withPublishMicrosoftEndpoints(true)
                    .withPublishInternetEndpoints(true))
                .withAllowBlobPublicAccess(false)
                .withMinimumTlsVersion(MinimumTlsVersion.TLS1_2)
                .withAllowSharedKeyAccess(true)
                .withDefaultToOAuthAuthentication(false)
                .withDnsEndpointType(DnsEndpointType.STANDARD), com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: specification/storage/resource-manager/Microsoft.Storage/stable/2024-01-01/examples/
     * StorageAccountCreateDnsEndpointTypeToAzureDnsZone.json
     */
    /**
     * Sample code: StorageAccountCreateDnsEndpointTypeToAzureDnsZone.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void
        storageAccountCreateDnsEndpointTypeToAzureDnsZone(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.storageAccounts()
            .manager()
            .serviceClient()
            .getStorageAccounts()
            .create("res9101", "sto4445", new StorageAccountCreateParameters()
                .withSku(new Sku().withName(SkuName.STANDARD_GRS))
                .withKind(Kind.STORAGE)
                .withLocation("eastus")
                .withExtendedLocation(
                    new ExtendedLocation().withName("losangeles001").withType(ExtendedLocationTypes.EDGE_ZONE))
                .withTags(mapOf("key1", "fakeTokenPlaceholder", "key2", "fakeTokenPlaceholder"))
                .withSasPolicy(
                    new SasPolicy().withSasExpirationPeriod("1.15:59:59").withExpirationAction(ExpirationAction.LOG))
                .withKeyPolicy(new KeyPolicy().withKeyExpirationPeriodInDays(20))
                .withEncryption(new Encryption()
                    .withServices(new EncryptionServices()
                        .withBlob(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT))
                        .withFile(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT)))
                    .withKeySource(KeySource.MICROSOFT_STORAGE)
                    .withRequireInfrastructureEncryption(false))
                .withIsSftpEnabled(true)
                .withIsHnsEnabled(true)
                .withRoutingPreference(new RoutingPreference().withRoutingChoice(RoutingChoice.MICROSOFT_ROUTING)
                    .withPublishMicrosoftEndpoints(true)
                    .withPublishInternetEndpoints(true))
                .withAllowBlobPublicAccess(false)
                .withMinimumTlsVersion(MinimumTlsVersion.TLS1_2)
                .withAllowSharedKeyAccess(true)
                .withDefaultToOAuthAuthentication(false)
                .withDnsEndpointType(DnsEndpointType.AZURE_DNS_ZONE), com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: specification/storage/resource-manager/Microsoft.Storage/stable/2024-01-01/examples/
     * StorageAccountCreateUserAssignedEncryptionIdentityWithCMK.json
     */
    /**
     * Sample code: StorageAccountCreateUserAssignedEncryptionIdentityWithCMK.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void storageAccountCreateUserAssignedEncryptionIdentityWithCMK(
        com.azure.resourcemanager.AzureResourceManager azure) {
        azure.storageAccounts()
            .manager()
            .serviceClient()
            .getStorageAccounts()
            .create("res9101", "sto4445", new StorageAccountCreateParameters()
                .withSku(new Sku().withName(SkuName.STANDARD_LRS))
                .withKind(Kind.STORAGE)
                .withLocation("eastus")
                .withIdentity(new Identity().withType(IdentityType.USER_ASSIGNED)
                    .withUserAssignedIdentities(mapOf(
                        "/subscriptions/{subscription-id}/resourceGroups/res9101/providers/Microsoft.ManagedIdentity/userAssignedIdentities/{managed-identity-name}",
                        new UserAssignedIdentity())))
                .withEncryption(new Encryption()
                    .withServices(new EncryptionServices()
                        .withBlob(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT))
                        .withFile(new EncryptionService().withEnabled(true).withKeyType(KeyType.ACCOUNT)))
                    .withKeySource(KeySource.MICROSOFT_KEYVAULT)
                    .withKeyVaultProperties(new KeyVaultProperties().withKeyName("fakeTokenPlaceholder")
                        .withKeyVersion("fakeTokenPlaceholder")
                        .withKeyVaultUri("fakeTokenPlaceholder"))
                    .withEncryptionIdentity(new EncryptionIdentity().withEncryptionUserAssignedIdentity(
                        "/subscriptions/{subscription-id}/resourceGroups/res9101/providers/Microsoft.ManagedIdentity/userAssignedIdentities/{managed-identity-name}"))),
                com.azure.core.util.Context.NONE);
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
