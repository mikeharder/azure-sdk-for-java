// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.security.keyvault.keys;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceModifiedException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.BinaryData;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.polling.LongRunningOperationStatus;
import com.azure.core.util.polling.PollResponse;
import com.azure.core.util.polling.PollerFlux;
import com.azure.core.util.polling.PollingContext;
import com.azure.security.keyvault.keys.cryptography.CryptographyAsyncClient;
import com.azure.security.keyvault.keys.cryptography.CryptographyClientBuilder;
import com.azure.security.keyvault.keys.implementation.KeyClientImpl;
import com.azure.security.keyvault.keys.implementation.KeyVaultKeysUtils;
import com.azure.security.keyvault.keys.implementation.models.BackupKeyResult;
import com.azure.security.keyvault.keys.implementation.models.DeletedKeyBundle;
import com.azure.security.keyvault.keys.implementation.models.DeletedKeyItem;
import com.azure.security.keyvault.keys.implementation.models.GetRandomBytesRequest;
import com.azure.security.keyvault.keys.implementation.models.KeyBundle;
import com.azure.security.keyvault.keys.implementation.models.KeyCreateParameters;
import com.azure.security.keyvault.keys.implementation.models.KeyImportParameters;
import com.azure.security.keyvault.keys.implementation.models.KeyItem;
import com.azure.security.keyvault.keys.implementation.models.KeyReleaseParameters;
import com.azure.security.keyvault.keys.implementation.models.KeyRestoreParameters;
import com.azure.security.keyvault.keys.implementation.models.KeyUpdateParameters;
import com.azure.security.keyvault.keys.implementation.models.KeyVaultKeysModelsUtils;
import com.azure.security.keyvault.keys.implementation.models.RandomBytes;
import com.azure.security.keyvault.keys.models.CreateEcKeyOptions;
import com.azure.security.keyvault.keys.models.CreateKeyOptions;
import com.azure.security.keyvault.keys.models.CreateOctKeyOptions;
import com.azure.security.keyvault.keys.models.CreateRsaKeyOptions;
import com.azure.security.keyvault.keys.models.DeletedKey;
import com.azure.security.keyvault.keys.models.ImportKeyOptions;
import com.azure.security.keyvault.keys.models.JsonWebKey;
import com.azure.security.keyvault.keys.models.KeyCurveName;
import com.azure.security.keyvault.keys.models.KeyExportEncryptionAlgorithm;
import com.azure.security.keyvault.keys.models.KeyOperation;
import com.azure.security.keyvault.keys.models.KeyProperties;
import com.azure.security.keyvault.keys.models.KeyRotationPolicy;
import com.azure.security.keyvault.keys.models.KeyType;
import com.azure.security.keyvault.keys.models.KeyVaultKey;
import com.azure.security.keyvault.keys.models.ReleaseKeyOptions;
import com.azure.security.keyvault.keys.models.ReleaseKeyResult;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.HttpURLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static com.azure.core.util.FluxUtil.monoError;
import static com.azure.core.util.FluxUtil.withContext;
import static com.azure.security.keyvault.keys.implementation.KeyVaultKeysUtils.EMPTY_OPTIONS;
import static com.azure.security.keyvault.keys.implementation.models.KeyVaultKeysModelsUtils.createDeletedKey;
import static com.azure.security.keyvault.keys.implementation.models.KeyVaultKeysModelsUtils.createKeyAttributes;
import static com.azure.security.keyvault.keys.implementation.models.KeyVaultKeysModelsUtils.createKeyVaultKey;
import static com.azure.security.keyvault.keys.implementation.models.KeyVaultKeysModelsUtils.mapJsonWebKey;
import static com.azure.security.keyvault.keys.implementation.models.KeyVaultKeysModelsUtils.mapKeyReleasePolicy;
import static com.azure.security.keyvault.keys.implementation.models.KeyVaultKeysModelsUtils.mapKeyRotationPolicy;
import static com.azure.security.keyvault.keys.implementation.models.KeyVaultKeysModelsUtils.mapKeyRotationPolicyImpl;

/**
 * The {@link KeyAsyncClient} provides asynchronous methods to manage {@link KeyVaultKey keys} in the Azure Key Vault.
 * The client supports creating, retrieving, updating, deleting, purging, backing up, restoring, listing, releasing
 * and rotating the {@link KeyVaultKey keys}. The client also supports listing {@link DeletedKey deleted keys} for a
 * soft-delete enabled key vault.
 *
 * <h2>Getting Started</h2>
 *
 * <p>In order to interact with the Azure Key Vault service, you will need to create an instance of the
 * {@link KeyAsyncClient} class, a vault url and a credential object.</p>
 *
 * <p>The examples shown in this document use a credential object named DefaultAzureCredential for authentication,
 * which is appropriate for most scenarios, including local development and production environments. Additionally,
 * we recommend using a
 * <a href="https://learn.microsoft.com/azure/active-directory/managed-identities-azure-resources/">
 * managed identity</a> for authentication in production environments.
 * You can find more information on different ways of authenticating and their corresponding credential types in the
 * <a href="https://learn.microsoft.com/java/api/overview/azure/identity-readme?view=azure-java-stable">
 * Azure Identity documentation"</a>.</p>
 *
 * <p><strong>Sample: Construct Asynchronous Key Client</strong></p>
 *
 * <p>The following code sample demonstrates the creation of a {@link KeyAsyncClient}, using the
 * {@link KeyClientBuilder} to configure it.</p>
 *
 * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.instantiation -->
 * <pre>
 * KeyAsyncClient keyAsyncClient = new KeyClientBuilder&#40;&#41;
 *     .vaultUrl&#40;&quot;&lt;your-key-vault-url&gt;&quot;&#41;
 *     .credential&#40;new DefaultAzureCredentialBuilder&#40;&#41;.build&#40;&#41;&#41;
 *     .buildAsyncClient&#40;&#41;;
 * </pre>
 * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.instantiation -->
 *
 * <br>
 *
 * <hr>
 *
 * <h2>Create a Cryptographic Key</h2>
 * The {@link KeyAsyncClient} can be used to create a key in the key vault.
 *
 * <p><strong>Code Sample:</strong></p>
 * <p>The following code sample demonstrates how to asynchronously create a cryptographic key in the key vault,
 * using the {@link KeyAsyncClient#createKey(String, KeyType)} API.</p>
 *
 * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.createKey#String-KeyType -->
 * <pre>
 * keyAsyncClient.createKey&#40;&quot;keyName&quot;, KeyType.EC&#41;
 *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
 *     .subscribe&#40;key -&gt;
 *         System.out.printf&#40;&quot;Created key with name: %s and id: %s %n&quot;, key.getName&#40;&#41;,
 *             key.getId&#40;&#41;&#41;&#41;;
 * </pre>
 * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.createKey#String-KeyType -->
 *
 * <p><strong>Note:</strong> For the synchronous sample, refer to {@link KeyClient}.</p>
 *
 * <br>
 *
 * <hr>
 *
 * <h2>Get a Cryptographic Key</h2>
 * The {@link KeyAsyncClient} can be used to retrieve a key from the key vault.
 *
 * <p><strong>Code Sample:</strong></p>
 * <p>The following code sample demonstrates how to asynchronously retrieve a key from the key vault, using
 * the {@link KeyAsyncClient#getKey(String)} API.</p>
 *
 * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.getKey#String -->
 * <pre>
 * keyAsyncClient.getKey&#40;&quot;keyName&quot;&#41;
 *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
 *     .subscribe&#40;key -&gt;
 *         System.out.printf&#40;&quot;Created key with name: %s and: id %s%n&quot;, key.getName&#40;&#41;,
 *             key.getId&#40;&#41;&#41;&#41;;
 * </pre>
 * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.getKey#String -->
 *
 * <p><strong>Note:</strong> For the synchronous sample, refer to {@link KeyClient}.</p>
 *
 * <br>
 *
 * <hr>
 *
 * <h2>Delete a Cryptographic Key</h2>
 * The {@link KeyAsyncClient} can be used to delete a key from the key vault.
 *
 * <p><strong>Code Sample:</strong></p>
 * <p>The following code sample demonstrates how to asynchronously delete a key from the
 * key vault, using the {@link KeyAsyncClient#beginDeleteKey(String)} API.</p>
 *
 * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.deleteKey#String -->
 * <pre>
 * keyAsyncClient.beginDeleteKey&#40;&quot;keyName&quot;&#41;
 *     .subscribe&#40;pollResponse -&gt; &#123;
 *         System.out.printf&#40;&quot;Deletion status: %s%n&quot;, pollResponse.getStatus&#40;&#41;&#41;;
 *         System.out.printf&#40;&quot;Key name: %s%n&quot;, pollResponse.getValue&#40;&#41;.getName&#40;&#41;&#41;;
 *         System.out.printf&#40;&quot;Key delete date: %s%n&quot;, pollResponse.getValue&#40;&#41;.getDeletedOn&#40;&#41;&#41;;
 *     &#125;&#41;;
 * </pre>
 * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.deleteKey#String -->
 *
 * <p><strong>Note:</strong> For the synchronous sample, refer to {@link KeyClient}.</p>
 *
 * @see com.azure.security.keyvault.keys
 * @see KeyClientBuilder
 */
@ServiceClient(
    builder = KeyClientBuilder.class,
    isAsync = true,
    serviceInterfaces = KeyClientImpl.KeyClientService.class)
public final class KeyAsyncClient {
    private static final ClientLogger LOGGER = new ClientLogger(KeyAsyncClient.class);

    private final KeyClientImpl implClient;
    private final String vaultUrl;
    private final KeyServiceVersion serviceVersion;

    /**
     * Creates a {@link KeyAsyncClient} that uses a {@link KeyClientImpl} to service requests.
     *
     * @param implClient the impl client.
     * @param vaultUrl the vault url.
     * @param keyServiceVersion the service version.
     */
    KeyAsyncClient(KeyClientImpl implClient, String vaultUrl, KeyServiceVersion keyServiceVersion) {
        this.implClient = implClient;
        this.vaultUrl = vaultUrl;
        this.serviceVersion = keyServiceVersion;
    }

    /**
     * Get the vault endpoint url to which service requests are sent to.
     *
     * @return The vault endpoint url
     */
    public String getVaultUrl() {
        return vaultUrl;
    }

    /**
     * Gets the {@link HttpPipeline} powering this client.
     *
     * @return The {@link HttpPipeline pipeline}.
     */
    HttpPipeline getHttpPipeline() {
        return implClient.getHttpPipeline();
    }

    /**
     * Creates a {@link CryptographyAsyncClient} for the latest version of a given key.
     *
     * <p>To ensure correct behavior when performing operations such as {@code Decrypt}, {@code Unwrap} and
     * {@code Verify}, it is recommended to use a {@link CryptographyAsyncClient} created for the specific key
     * version that was used for the corresponding inverse operation: {@code Encrypt}, {@code Wrap}, or
     * {@code Sign}, respectively.</p>
     *
     * <p>You can provide a key version either via {@link KeyAsyncClient#getCryptographyAsyncClient(String, String)} or
     * by ensuring it is included in the {@code keyIdentifier} passed to
     * {@link CryptographyClientBuilder#keyIdentifier(String)} before building a client.</p>
     *
     * @param keyName The name of the key.
     *
     * @return An instance of {@link CryptographyAsyncClient} associated with the latest version of a key with the
     * provided name.
     *
     * @throws IllegalArgumentException If {@code keyName} is {@code null} or empty.
     */
    public CryptographyAsyncClient getCryptographyAsyncClient(String keyName) {
        return getCryptographyAsyncClient(keyName, null);
    }

    /**
     * Creates a {@link CryptographyAsyncClient} for a given key version.
     *
     * @param keyName The name of the key.
     * @param keyVersion The key version.
     *
     * @return An instance of {@link CryptographyAsyncClient} associated with a key with the provided name and version.
     * If {@code keyVersion} is {@code null} or empty, the client will use the latest version of the key.
     *
     * @throws IllegalArgumentException If {@code keyName} is {@code null} or empty.
     */
    public CryptographyAsyncClient getCryptographyAsyncClient(String keyName, String keyVersion) {
        return KeyVaultKeysUtils
            .getCryptographyClientBuilder(keyName, keyVersion, vaultUrl, getHttpPipeline(), serviceVersion)
            .buildAsyncClient();
    }

    /**
     * Creates a new {@link KeyVaultKey key} and stores it in the key vault. The create key operation can be used to
     * create any {@link KeyType keyType} in Azure Key Vault. If a {@link KeyVaultKey key} with the provided name
     * already exists, Azure Key Vault creates a new version of the {@link KeyVaultKey key}. It requires the
     * {@code keys/create} permission.
     *
     * <p>The {@link KeyType keyType} indicates the type of {@link KeyVaultKey key} to create. Possible values include:
     * {@link KeyType#EC EC}, {@link KeyType#EC_HSM EC-HSM}, {@link KeyType#RSA RSA}, {@link KeyType#RSA_HSM RSA-HSM},
     * {@link KeyType#OCT OCT}, and {@link KeyType#OCT_HSM OCT-HSM}.</p>
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Creates a new {@link KeyVaultKey EC key}. Subscribes to the call asynchronously and prints out the newly
     * {@link KeyVaultKey created key} details when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.createKey#String-KeyType -->
     * <pre>
     * keyAsyncClient.createKey&#40;&quot;keyName&quot;, KeyType.EC&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;key -&gt;
     *         System.out.printf&#40;&quot;Created key with name: %s and id: %s %n&quot;, key.getName&#40;&#41;,
     *             key.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.createKey#String-KeyType -->
     *
     * @param name The name of the {@link KeyVaultKey key} being created.
     * @param keyType The type of {@link KeyVaultKey key} to create. For valid values, see {@link KeyType KeyType}.
     *
     * @return A {@link Mono} containing the {@link KeyVaultKey created key}.
     *
     * @throws HttpResponseException If {@code name} is an empty string.
     * @throws NullPointerException If {@code name} or {@code keyType} are {@code null}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<KeyVaultKey> createKey(String name, KeyType keyType) {
        return createKeyWithResponse(new CreateKeyOptions(name, keyType)).flatMap(FluxUtil::toMono);
    }

    /**
     * Creates a new {@link KeyVaultKey key} and stores it in the key vault. The create key operation can be used to
     * create any {@link KeyType keyType} in Azure Key Vault. If a {@link KeyVaultKey key} with the provided name
     * already exists, Azure Key Vault creates a new version of the {@link KeyVaultKey key}. It requires the
     * {@code keys/create} permission.
     *
     * <p>The {@link KeyType keyType} indicates the type of {@link KeyVaultKey key} to create. Possible values include:
     * {@link KeyType#EC EC}, {@link KeyType#EC_HSM EC-HSM}, {@link KeyType#RSA RSA}, {@link KeyType#RSA_HSM RSA-HSM},
     * {@link KeyType#OCT OCT}, and {@link KeyType#OCT_HSM OCT-HSM}.</p>
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Creates a new {@link KeyVaultKey EC key}. Subscribes to the call asynchronously and prints out the newly
     * {@link KeyVaultKey created key} details when a response has been received.</p>
     *
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.createKeyWithResponse#CreateKeyOptions -->
     * <pre>
     * CreateKeyOptions createKeyOptions = new CreateKeyOptions&#40;&quot;keyName&quot;, KeyType.RSA&#41;
     *     .setNotBefore&#40;OffsetDateTime.now&#40;&#41;.plusDays&#40;1&#41;&#41;
     *     .setExpiresOn&#40;OffsetDateTime.now&#40;&#41;.plusYears&#40;1&#41;&#41;;
     *
     * keyAsyncClient.createKeyWithResponse&#40;createKeyOptions&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;createKeyResponse -&gt;
     *         System.out.printf&#40;&quot;Created key with name: %s and: id %s%n&quot;, createKeyResponse.getValue&#40;&#41;.getName&#40;&#41;,
     *             createKeyResponse.getValue&#40;&#41;.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.createKeyWithResponse#CreateKeyOptions -->
     *
     * @param createKeyOptions The {@link CreateKeyOptions options object} containing information about the
     * {@link KeyVaultKey key} being created.
     *
     * @return A {@link Mono} containing a {@link Response} whose {@link Response#getValue() value} contains the
     * {@link KeyVaultKey created key}.
     *
     * @throws HttpResponseException If {@link CreateKeyOptions#getName()} is an empty string.
     * @throws NullPointerException If {@code createKeyOptions} is null.
     * @throws ResourceModifiedException If {@code createKeyOptions} is malformed.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<KeyVaultKey>> createKeyWithResponse(CreateKeyOptions createKeyOptions) {
        try {
            if (createKeyOptions == null) {
                return monoError(LOGGER, new NullPointerException("'createKeyOptions' cannot be null."));
            }

            KeyCreateParameters keyCreateParameters
                = new KeyCreateParameters(createKeyOptions.getKeyType()).setKeyOps(createKeyOptions.getKeyOperations())
                    .setKeyAttributes(createKeyAttributes(createKeyOptions))
                    .setTags(createKeyOptions.getTags())
                    .setReleasePolicy(mapKeyReleasePolicy(createKeyOptions.getReleasePolicy()));

            return implClient
                .createKeyWithResponseAsync(createKeyOptions.getName(), BinaryData.fromObject(keyCreateParameters),
                    EMPTY_OPTIONS)
                .onErrorMap(HttpResponseException.class, KeyAsyncClient::mapCreateKeyException)
                .map(response -> new SimpleResponse<>(response,
                    createKeyVaultKey(response.getValue().toObject(KeyBundle.class))));
        } catch (RuntimeException e) {
            return monoError(LOGGER, e);
        }
    }

    static HttpResponseException mapCreateKeyException(HttpResponseException e) {
        return (e.getResponse().getStatusCode() == 400)
            ? new ResourceModifiedException(e.getMessage(), e.getResponse(), e.getValue())
            : e;
    }

    /**
     * Creates a new {@link KeyVaultKey key} and stores it in the key vault. The create key operation can be used to
     * create any {@link KeyType keyType} in Azure Key Vault. If a {@link KeyVaultKey key} with the provided name
     * already exists, Azure Key Vault creates a new version of the {@link KeyVaultKey key}. It requires the
     * {@code keys/create} permission.
     *
     * <p>The {@link CreateKeyOptions} parameter is required. The {@link CreateKeyOptions#getExpiresOn() expires} and
     * {@link CreateKeyOptions#getNotBefore() notBefore} values are optional. The
     * {@link CreateKeyOptions#isEnabled() enabled} field is set to {@code true} by Azure Key Vault, if not specified.
     * </p>
     *
     * <p>The {@link CreateKeyOptions#getKeyType() keyType} indicates the type of {@link KeyVaultKey key} to create.
     * Possible values include: {@link KeyType#EC EC}, {@link KeyType#EC_HSM EC-HSM}, {@link KeyType#RSA RSA},
     * {@link KeyType#RSA_HSM RSA-HSM}, {@link KeyType#OCT OCT}, and {@link KeyType#OCT_HSM OCT-HSM}.</p>
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Creates a new {@link KeyVaultKey RSA key} which activates in one day and expires in one year. Subscribes to
     * the call asynchronously and prints out the newly {@link KeyVaultKey created key} details when a response has been
     * received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.createKey#CreateKeyOptions -->
     * <pre>
     * CreateKeyOptions createKeyOptions = new CreateKeyOptions&#40;&quot;keyName&quot;, KeyType.RSA&#41;
     *     .setNotBefore&#40;OffsetDateTime.now&#40;&#41;.plusDays&#40;1&#41;&#41;
     *     .setExpiresOn&#40;OffsetDateTime.now&#40;&#41;.plusYears&#40;1&#41;&#41;;
     *
     * keyAsyncClient.createKey&#40;createKeyOptions&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;key -&gt;
     *         System.out.printf&#40;&quot;Created key with name: %s and id: %s %n&quot;, key.getName&#40;&#41;,
     *             key.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.createKey#CreateKeyOptions -->
     *
     * @param createKeyOptions The {@link CreateKeyOptions options object} containing information about the
     * {@link KeyVaultKey key} being created.
     *
     * @return A {@link Mono} containing the {@link KeyVaultKey created key}.
     *
     * @throws HttpResponseException If {@link CreateKeyOptions#getName()} is an empty string.
     * @throws NullPointerException If {@code createKeyOptions} is {@code null}.
     * @throws ResourceModifiedException If {@code createKeyOptions} is malformed.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<KeyVaultKey> createKey(CreateKeyOptions createKeyOptions) {
        return createKeyWithResponse(createKeyOptions).flatMap(FluxUtil::toMono);
    }

    /**
     * /**
     * Creates a new {@link KeyVaultKey RSA key} and stores it in the key vault. The create RSA key operation can be
     * used to create any RSA key type in Azure Key Vault. If a {@link KeyVaultKey key} with the provided name already
     * exists, Azure Key Vault creates a new version of the {@link KeyVaultKey key}. It requires the
     * {@code keys/create} permission.
     *
     * <p>The {@link CreateRsaKeyOptions} parameter is required. The {@link CreateRsaKeyOptions#getKeySize() keySize}
     * can be optionally specified. The {@link CreateRsaKeyOptions#getExpiresOn() expires} and
     * {@link CreateRsaKeyOptions#getNotBefore() notBefore} values are optional. The
     * {@link CreateRsaKeyOptions#isEnabled() enabled} field is set to {@code true} by Azure Key Vault, if not
     * specified.</p>
     *
     * <p>The {@link CreateRsaKeyOptions#getKeyType() keyType} indicates the type of {@link KeyVaultKey key} to create.
     * Possible values include: {@link KeyType#RSA RSA} and {@link KeyType#RSA_HSM RSA-HSM}.</p>
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Creates a new {@link KeyVaultKey RSA key} with size 2048 which activates in one day and expires in one year.
     * Subscribes to the call asynchronously and prints out the newly {@link KeyVaultKey created key} details when a
     * response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.createRsaKey#CreateRsaKeyOptions -->
     * <pre>
     * CreateRsaKeyOptions createRsaKeyOptions = new CreateRsaKeyOptions&#40;&quot;keyName&quot;&#41;
     *     .setKeySize&#40;2048&#41;
     *     .setNotBefore&#40;OffsetDateTime.now&#40;&#41;.plusDays&#40;1&#41;&#41;
     *     .setExpiresOn&#40;OffsetDateTime.now&#40;&#41;.plusYears&#40;1&#41;&#41;;
     *
     * keyAsyncClient.createRsaKey&#40;createRsaKeyOptions&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;rsaKey -&gt;
     *         System.out.printf&#40;&quot;Created key with name: %s and id: %s %n&quot;, rsaKey.getName&#40;&#41;,
     *             rsaKey.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.createRsaKey#CreateRsaKeyOptions -->
     *
     * @param createRsaKeyOptions The {@link CreateRsaKeyOptions options object} containing information about the
     * {@link KeyVaultKey RSA key} being created.
     *
     * @return A {@link Mono} containing the {@link KeyVaultKey created key}.
     *
     * @throws HttpResponseException If {@link CreateRsaKeyOptions#getName()} is an empty string.
     * @throws NullPointerException If {@code createRsaKeyOptions} is {@code null}.
     * @throws ResourceModifiedException If {@code createRsaKeyOptions} is malformed.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<KeyVaultKey> createRsaKey(CreateRsaKeyOptions createRsaKeyOptions) {
        return createRsaKeyWithResponse(createRsaKeyOptions).flatMap(FluxUtil::toMono);
    }

    /**
     * Creates a new {@link KeyVaultKey RSA key} and stores it in the key vault. The create RSA key operation can be
     * used to create any RSA key type in Azure Key Vault. If a {@link KeyVaultKey key} with the provided name already
     * exists, Azure Key Vault creates a new version of the {@link KeyVaultKey key}. It requires the
     * {@code keys/create} permission.
     *
     * <p>The {@link CreateRsaKeyOptions} parameter is required. The {@link CreateRsaKeyOptions#getKeySize() keySize}
     * can be optionally specified. The {@link CreateRsaKeyOptions#getExpiresOn() expires} and
     * {@link CreateRsaKeyOptions#getNotBefore() notBefore} values are optional. The
     * {@link CreateRsaKeyOptions#isEnabled() enabled} field is set to {@code true} by Azure Key Vault, if not
     * specified.</p>
     *
     * <p>The {@link CreateRsaKeyOptions#getKeyType() keyType} indicates the type of {@link KeyVaultKey key} to create.
     * Possible values include: {@link KeyType#RSA RSA} and {@link KeyType#RSA_HSM RSA-HSM}.</p>
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Creates a new {@link KeyVaultKey RSA key} with size 2048 which activates in one day and expires in one year.
     * Subscribes to the call asynchronously and prints out the newly {@link KeyVaultKey created key} details when a
     * response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.createRsaKeyWithResponse#CreateRsaKeyOptions -->
     * <pre>
     * CreateRsaKeyOptions createRsaKeyOptions = new CreateRsaKeyOptions&#40;&quot;keyName&quot;&#41;
     *     .setKeySize&#40;2048&#41;
     *     .setNotBefore&#40;OffsetDateTime.now&#40;&#41;.plusDays&#40;1&#41;&#41;
     *     .setExpiresOn&#40;OffsetDateTime.now&#40;&#41;.plusYears&#40;1&#41;&#41;;
     *
     * keyAsyncClient.createRsaKeyWithResponse&#40;createRsaKeyOptions&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;createRsaKeyResponse -&gt;
     *         System.out.printf&#40;&quot;Created key with name: %s and: id %s%n&quot;, createRsaKeyResponse.getValue&#40;&#41;.getName&#40;&#41;,
     *             createRsaKeyResponse.getValue&#40;&#41;.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.createRsaKeyWithResponse#CreateRsaKeyOptions -->
     *
     * @param createRsaKeyOptions The {@link CreateRsaKeyOptions options object} containing information about the
     * {@link KeyVaultKey RSA key} being created.
     *
     * @return A {@link Mono} containing a {@link Response} whose {@link Response#getValue() value} contains the
     * {@link KeyVaultKey created key}.
     *
     * @throws HttpResponseException If {@link CreateRsaKeyOptions#getName()} is an empty string.
     * @throws NullPointerException If {@code createRsaKeyOptions} is {@code null}.
     * @throws ResourceModifiedException If {@code createRsaKeyOptions} is malformed.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<KeyVaultKey>> createRsaKeyWithResponse(CreateRsaKeyOptions createRsaKeyOptions) {
        try {
            if (createRsaKeyOptions == null) {
                return monoError(LOGGER, new NullPointerException("'createRsaKeyOptions' cannot be null."));
            }

            KeyCreateParameters keyCreateParameters
                = new KeyCreateParameters(createRsaKeyOptions.getKeyType()).setKeySize(createRsaKeyOptions.getKeySize())
                    .setPublicExponent(createRsaKeyOptions.getPublicExponent())
                    .setKeyOps(createRsaKeyOptions.getKeyOperations())
                    .setKeyAttributes(createKeyAttributes(createRsaKeyOptions))
                    .setTags(createRsaKeyOptions.getTags())
                    .setReleasePolicy(mapKeyReleasePolicy(createRsaKeyOptions.getReleasePolicy()));

            return implClient
                .createKeyWithResponseAsync(createRsaKeyOptions.getName(), BinaryData.fromObject(keyCreateParameters),
                    EMPTY_OPTIONS)
                .onErrorMap(HttpResponseException.class, KeyAsyncClient::mapCreateKeyException)
                .map(response -> new SimpleResponse<>(response,
                    createKeyVaultKey(response.getValue().toObject(KeyBundle.class))));
        } catch (RuntimeException e) {
            return monoError(LOGGER, e);
        }
    }

    /**
     * Creates a new {@link KeyVaultKey EC key} and stores it in the key vault. The create EC key operation can be
     * used to create any EC {@link KeyType key type} in Azure Key Vault. If a {@link KeyVaultKey key} with the
     * provided name already exists, Azure Key Vault creates a new version of the {@link KeyVaultKey key}. It requires
     * the {@code keys/create} permission.
     *
     * <p>The {@link CreateEcKeyOptions} parameter is required. The {@link CreateEcKeyOptions#getCurveName() key curve}
     * can be optionally specified. If not specified, the default value {@link KeyCurveName#P_256 P-256} is used by
     * Azure Key Vault. The {@link CreateEcKeyOptions#getExpiresOn() expires} and
     * {@link CreateEcKeyOptions#getNotBefore() notBefore} values are optional. The
     * {@link CreateEcKeyOptions#isEnabled() enabled} field is set to {@code true} by Azure Key Vault, if not specified.
     * </p>
     *
     * <p>The {@link CreateEcKeyOptions#getKeyType() keyType} indicates the type of {@link KeyVaultKey} key to create.
     * Possible values include: {@link KeyType#EC EC} and {@link KeyType#EC_HSM EC-HSM}.</p>
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Creates a new {@link KeyVaultKey EC key} with a {@link KeyCurveName#P_384 P-384} web key curve. The key
     * activates in one day and expires in one year. Subscribes to the call asynchronously and prints out the newly
     * {@link KeyVaultKey created key} details when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.createEcKey#CreateEcKeyOptions -->
     * <pre>
     * CreateEcKeyOptions createEcKeyOptions = new CreateEcKeyOptions&#40;&quot;keyName&quot;&#41;
     *     .setCurveName&#40;KeyCurveName.P_384&#41;
     *     .setNotBefore&#40;OffsetDateTime.now&#40;&#41;.plusDays&#40;1&#41;&#41;
     *     .setExpiresOn&#40;OffsetDateTime.now&#40;&#41;.plusYears&#40;1&#41;&#41;;
     *
     * keyAsyncClient.createEcKey&#40;createEcKeyOptions&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;ecKey -&gt;
     *         System.out.printf&#40;&quot;Created key with name: %s and id: %s %n&quot;, ecKey.getName&#40;&#41;,
     *             ecKey.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.createEcKey#CreateEcKeyOptions -->
     *
     * @param createEcKeyOptions The {@link CreateEcKeyOptions options object} containing information about the
     * {@link KeyVaultKey EC key} being created.
     *
     * @return A {@link Mono} containing the {@link KeyVaultKey created key}.
     *
     * @throws HttpResponseException If {@link CreateEcKeyOptions#getName()} is an empty string.
     * @throws NullPointerException If {@code ecKeyCreateOptions} is {@code null}.
     * @throws ResourceModifiedException If {@code ecKeyCreateOptions} is malformed.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<KeyVaultKey> createEcKey(CreateEcKeyOptions createEcKeyOptions) {
        return createEcKeyWithResponse(createEcKeyOptions).flatMap(FluxUtil::toMono);
    }

    /**
     * Creates a new {@link KeyVaultKey EC key} and stores it in the key vault. The create EC key operation can be
     * used to create any EC {@link KeyType key type} in Azure Key Vault. If a {@link KeyVaultKey key} with the
     * provided name already exists, Azure Key Vault creates a new version of the {@link KeyVaultKey key}. It requires
     * the {@code keys/create} permission.
     *
     * <p>The {@link CreateEcKeyOptions} parameter is required. The {@link CreateEcKeyOptions#getCurveName() key curve}
     * can be optionally specified. If not specified, the default value {@link KeyCurveName#P_256 P-256} is used by
     * Azure Key Vault. The {@link CreateEcKeyOptions#getExpiresOn() expires} and
     * {@link CreateEcKeyOptions#getNotBefore() notBefore} values are optional. The
     * {@link CreateEcKeyOptions#isEnabled() enabled} field is set to {@code true} by Azure Key Vault, if not
     * specified.
     * </p>
     *
     * <p>The {@link CreateEcKeyOptions#getKeyType() keyType} indicates the type of {@link KeyVaultKey} key to create.
     * Possible values include: {@link KeyType#EC EC} and {@link KeyType#EC_HSM EC-HSM}.</p>
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Creates a new {@link KeyVaultKey EC key} with a {@link KeyCurveName#P_384 P-384} web key curve. The key
     * activates in one day and expires in one year. Subscribes to the call asynchronously and prints out the newly
     * {@link KeyVaultKey created key} details when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.createEcKeyWithResponse#CreateEcKeyOptions -->
     * <pre>
     * CreateEcKeyOptions createEcKeyOptions = new CreateEcKeyOptions&#40;&quot;keyName&quot;&#41;
     *     .setCurveName&#40;KeyCurveName.P_384&#41;
     *     .setNotBefore&#40;OffsetDateTime.now&#40;&#41;.plusDays&#40;1&#41;&#41;
     *     .setExpiresOn&#40;OffsetDateTime.now&#40;&#41;.plusYears&#40;1&#41;&#41;;
     *
     * keyAsyncClient.createEcKeyWithResponse&#40;createEcKeyOptions&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;createEcKeyResponse -&gt;
     *         System.out.printf&#40;&quot;Created key with name: %s and: id %s%n&quot;, createEcKeyResponse.getValue&#40;&#41;.getName&#40;&#41;,
     *             createEcKeyResponse.getValue&#40;&#41;.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.createEcKeyWithResponse#CreateEcKeyOptions -->
     *
     * @param createEcKeyOptions The {@link CreateEcKeyOptions options object} containing information about the
     * {@link KeyVaultKey EC key} being created.
     *
     * @return A {@link Mono} containing a {@link Response} whose {@link Response#getValue() value} contains the
     * {@link KeyVaultKey created key}.
     *
     * @throws HttpResponseException If {@link CreateEcKeyOptions#getName()} is an empty string.
     * @throws NullPointerException If {@code ecKeyCreateOptions} is {@code null}.
     * @throws ResourceModifiedException If {@code ecKeyCreateOptions} is malformed.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<KeyVaultKey>> createEcKeyWithResponse(CreateEcKeyOptions createEcKeyOptions) {
        try {
            if (createEcKeyOptions == null) {
                return monoError(LOGGER, new NullPointerException("'createEcKeyOptions' cannot be null."));
            }

            KeyCreateParameters keyCreateParameters = new KeyCreateParameters(createEcKeyOptions.getKeyType())
                .setKeyOps(createEcKeyOptions.getKeyOperations())
                .setKeyAttributes(createKeyAttributes(createEcKeyOptions))
                .setTags(createEcKeyOptions.getTags())
                .setCurve(createEcKeyOptions.getCurveName())
                .setReleasePolicy(mapKeyReleasePolicy(createEcKeyOptions.getReleasePolicy()));

            return implClient
                .createKeyWithResponseAsync(createEcKeyOptions.getName(), BinaryData.fromObject(keyCreateParameters),
                    EMPTY_OPTIONS)
                .onErrorMap(HttpResponseException.class, KeyAsyncClient::mapCreateKeyException)
                .map(response -> new SimpleResponse<>(response,
                    createKeyVaultKey(response.getValue().toObject(KeyBundle.class))));
        } catch (RuntimeException e) {
            return monoError(LOGGER, e);
        }
    }

    /**
     * Creates and stores a new {@link KeyVaultKey symmetric key} in the key vault. If a {@link KeyVaultKey key} with
     * the provided name already exists, Azure Key Vault creates a new version of the key. This operation requires
     * the {@code keys/create} permission.
     *
     * <p>The {@link CreateOctKeyOptions} parameter is required. The {@link CreateOctKeyOptions#getExpiresOn() expires}
     * and {@link CreateOctKeyOptions#getNotBefore() notBefore} values are optional. The
     * {@link CreateOctKeyOptions#isEnabled() enabled} field is set to {@code true} by Azure Key Vault, if not
     * specified.</p>
     *
     * <p>The {@link CreateOctKeyOptions#getKeyType() keyType} indicates the type of {@link KeyVaultKey} key to create.
     * Possible values include: {@link KeyType#OCT OCT} and {@link KeyType#OCT_HSM OCT-HSM}.</p>
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Creates a new {@link KeyVaultKey symmetric key}. The {@link KeyVaultKey key} activates in one day and expires
     * in one year. Subscribes to the call asynchronously and prints out the details of the newly
     * {@link KeyVaultKey created key} when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.createOctKey#CreateOctKeyOptions -->
     * <pre>
     * CreateOctKeyOptions createOctKeyOptions = new CreateOctKeyOptions&#40;&quot;keyName&quot;&#41;
     *     .setNotBefore&#40;OffsetDateTime.now&#40;&#41;.plusDays&#40;1&#41;&#41;
     *     .setExpiresOn&#40;OffsetDateTime.now&#40;&#41;.plusYears&#40;1&#41;&#41;;
     *
     * keyAsyncClient.createOctKey&#40;createOctKeyOptions&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;octKey -&gt;
     *         System.out.printf&#40;&quot;Created key with name: %s and id: %s %n&quot;, octKey.getName&#40;&#41;,
     *             octKey.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.createOctKey#CreateOctKeyOptions -->
     *
     * @param createOctKeyOptions The {@link CreateOctKeyOptions options object} containing information about the
     * {@link KeyVaultKey symmetric key} being created.
     *
     * @return A {@link Mono} containing the {@link KeyVaultKey created key}.
     *
     * @throws HttpResponseException If {@link CreateOctKeyOptions#getName()} is an empty string.
     * @throws NullPointerException If {@code ecKeyCreateOptions} is {@code null}.
     * @throws ResourceModifiedException If {@code ecKeyCreateOptions} is malformed.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<KeyVaultKey> createOctKey(CreateOctKeyOptions createOctKeyOptions) {
        return createOctKeyWithResponse(createOctKeyOptions).flatMap(FluxUtil::toMono);
    }

    /**
     * Creates and stores a new {@link KeyVaultKey symmetric key} in the key vault. If a {@link KeyVaultKey key} with
     * the provided name already exists, Azure Key Vault creates a new version of the key. This operation requires
     * the {@code keys/create} permission.
     *
     * <p>The {@link CreateOctKeyOptions} parameter is required. The {@link CreateOctKeyOptions#getExpiresOn() expires}
     * and {@link CreateOctKeyOptions#getNotBefore() notBefore} values are optional. The
     * {@link CreateOctKeyOptions#isEnabled() enabled} field is set to {@code true} by Azure Key Vault, if not
     * specified.</p>
     *
     * <p>The {@link CreateOctKeyOptions#getKeyType() keyType} indicates the type of {@link KeyVaultKey} key to create.
     * Possible values include: {@link KeyType#OCT OCT} and {@link KeyType#OCT_HSM OCT-HSM}.</p>
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Creates a new {@link KeyVaultKey symmetric key}. The {@link KeyVaultKey key} activates in one day and expires
     * in one year. Subscribes to the call asynchronously and prints out the details of the newly
     * {@link KeyVaultKey created key} when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.createOctKeyWithResponse#CreateOctKeyOptions -->
     * <pre>
     * CreateOctKeyOptions createOctKeyOptions = new CreateOctKeyOptions&#40;&quot;keyName&quot;&#41;
     *     .setNotBefore&#40;OffsetDateTime.now&#40;&#41;.plusDays&#40;1&#41;&#41;
     *     .setExpiresOn&#40;OffsetDateTime.now&#40;&#41;.plusYears&#40;1&#41;&#41;;
     *
     * keyAsyncClient.createOctKeyWithResponse&#40;createOctKeyOptions&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;createOctKeyResponse -&gt;
     *         System.out.printf&#40;&quot;Created key with name: %s and: id %s%n&quot;, createOctKeyResponse.getValue&#40;&#41;.getName&#40;&#41;,
     *             createOctKeyResponse.getValue&#40;&#41;.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.createOctKeyWithResponse#CreateOctKeyOptions -->
     *
     * @param createOctKeyOptions The {@link CreateOctKeyOptions options object} containing information about the
     * {@link KeyVaultKey symmetric key} being created.
     *
     * @return A {@link Mono} containing a {@link Response} whose {@link Response#getValue() value} contains the
     * {@link KeyVaultKey created key}.
     *
     * @throws HttpResponseException If {@link CreateOctKeyOptions#getName()} is an empty string.
     * @throws NullPointerException If {@code createOctKeyOptions} is {@code null}.
     * @throws ResourceModifiedException If {@code createOctKeyOptions} is malformed.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<KeyVaultKey>> createOctKeyWithResponse(CreateOctKeyOptions createOctKeyOptions) {
        try {
            if (createOctKeyOptions == null) {
                return monoError(LOGGER, new NullPointerException("'createOctKeyOptions' cannot be null."));
            }

            KeyCreateParameters keyCreateParameters
                = new KeyCreateParameters(createOctKeyOptions.getKeyType()).setKeySize(createOctKeyOptions.getKeySize())
                    .setKeyOps(createOctKeyOptions.getKeyOperations())
                    .setKeyAttributes(createKeyAttributes(createOctKeyOptions))
                    .setTags(createOctKeyOptions.getTags())
                    .setReleasePolicy(mapKeyReleasePolicy(createOctKeyOptions.getReleasePolicy()));

            return implClient
                .createKeyWithResponseAsync(createOctKeyOptions.getName(), BinaryData.fromObject(keyCreateParameters),
                    EMPTY_OPTIONS)
                .onErrorMap(HttpResponseException.class, KeyAsyncClient::mapCreateKeyException)
                .map(response -> new SimpleResponse<>(response,
                    createKeyVaultKey(response.getValue().toObject(KeyBundle.class))));
        } catch (RuntimeException e) {
            return monoError(LOGGER, e);
        }
    }

    /**
     * Imports an externally created {@link JsonWebKey key} and stores it in the key vault. The import key operation
     * may be used to import any {@link KeyType key type} into Azure Key Vault. If a {@link KeyVaultKey key} with
     * the provided name already exists, Azure Key Vault creates a new version of the {@link KeyVaultKey key}. This
     * operation requires the {@code keys/import} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Imports a new {@link KeyVaultKey key} into key vault. Subscribes to the call asynchronously and prints out the
     * newly {@link KeyVaultKey imported key} details when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.importKey#String-JsonWebKey -->
     * <pre>
     * keyAsyncClient.importKey&#40;&quot;keyName&quot;, jsonWebKeyToImport&#41;
     *     .subscribe&#40;keyVaultKey -&gt;
     *         System.out.printf&#40;&quot;Imported key with name: %s and id: %s%n&quot;, keyVaultKey.getName&#40;&#41;,
     *             keyVaultKey.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.importKey#String-JsonWebKey -->
     *
     * @param name The name for the imported key.
     * @param keyMaterial The Json web key being imported.
     *
     * @return A {@link Mono} containing a {@link Response} whose {@link Response#getValue() value} contains the
     * {@link KeyVaultKey imported key}.
     *
     * @throws HttpResponseException If {@code name} is an empty string.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<KeyVaultKey> importKey(String name, JsonWebKey keyMaterial) {
        return importKeyWithResponse(new ImportKeyOptions(name, keyMaterial)).flatMap(FluxUtil::toMono);
    }

    /**
     * Imports an externally created {@link JsonWebKey key} and stores it in the key vault. The import key operation
     * may be used to import any {@link KeyType key type} into Azure Key Vault. If a {@link KeyVaultKey key} with
     * the provided name already exists, Azure Key Vault creates a new version of the {@link KeyVaultKey key}. This
     * operation requires the {@code keys/import} permission.
     *
     * <p>{@link ImportKeyOptions} is required and its fields {@link ImportKeyOptions#getName() name} and
     * {@link ImportKeyOptions#getKey() key material} cannot be {@code null}. The
     * {@link ImportKeyOptions#getExpiresOn() expires} and {@link ImportKeyOptions#getNotBefore() notBefore} values
     * in {@code keyImportOptions} are optional. If not specified, no values are set for the fields. The
     * {@link ImportKeyOptions#isEnabled() enabled} field is set to {@code true} and the
     * {@link ImportKeyOptions#isHardwareProtected() hsm} field is set to {@code false} by Azure Key Vault, if they are
     * not specified.</p>
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Imports a new {@link KeyVaultKey key} into key vault. Subscribes to the call asynchronously and prints out the
     * newly {@link KeyVaultKey imported key} details when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.importKey#ImportKeyOptions -->
     * <pre>
     * ImportKeyOptions options = new ImportKeyOptions&#40;&quot;keyName&quot;, jsonWebKeyToImport&#41;
     *     .setHardwareProtected&#40;false&#41;;
     *
     * keyAsyncClient.importKey&#40;options&#41;.subscribe&#40;keyVaultKey -&gt;
     *     System.out.printf&#40;&quot;Imported key with name: %s and id: %s%n&quot;, keyVaultKey.getName&#40;&#41;, keyVaultKey.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.importKey#ImportKeyOptions -->
     *
     * @param importKeyOptions The {@link ImportKeyOptions options object} containing information about the
     * {@link JsonWebKey} being imported.
     *
     * @return A {@link Mono} containing the {@link KeyVaultKey imported key}.
     *
     * @throws HttpResponseException If {@link ImportKeyOptions#getName()} is an empty string.
     * @throws NullPointerException If {@code importKeyOptions} is {@code null}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<KeyVaultKey> importKey(ImportKeyOptions importKeyOptions) {
        return importKeyWithResponse(importKeyOptions).flatMap(FluxUtil::toMono);
    }

    /**
     * Imports an externally created {@link JsonWebKey key} and stores it in the key vault. The import key operation
     * may be used to import any {@link KeyType key type} into Azure Key Vault. If a {@link KeyVaultKey key} with
     * the provided name already exists, Azure Key Vault creates a new version of the {@link KeyVaultKey key}. This
     * operation requires the {@code keys/import} permission.
     *
     * <p>{@link ImportKeyOptions} is required and its fields {@link ImportKeyOptions#getName() name} and
     * {@link ImportKeyOptions#getKey() key material} cannot be {@code null}. The
     * {@link ImportKeyOptions#getExpiresOn() expires} and {@link ImportKeyOptions#getNotBefore() notBefore} values
     * in {@code keyImportOptions} are optional. If not specified, no values are set for the fields. The
     * {@link ImportKeyOptions#isEnabled() enabled} field is set to {@code true} and the
     * {@link ImportKeyOptions#isHardwareProtected() hsm} field is set to {@code false} by Azure Key Vault, if they are
     * not specified.</p>
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Imports a new {@link KeyVaultKey key} into key vault. Subscribes to the call asynchronously and prints out the
     * newly {@link KeyVaultKey imported key} details when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.importKeyWithResponse#ImportKeyOptions -->
     * <pre>
     * ImportKeyOptions importKeyOptions = new ImportKeyOptions&#40;&quot;keyName&quot;, jsonWebKeyToImport&#41;
     *     .setHardwareProtected&#40;false&#41;;
     *
     * keyAsyncClient.importKeyWithResponse&#40;importKeyOptions&#41;.subscribe&#40;response -&gt;
     *     System.out.printf&#40;&quot;Imported key with name: %s and id: %s%n&quot;, response.getValue&#40;&#41;.getName&#40;&#41;,
     *         response.getValue&#40;&#41;.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.importKeyWithResponse#ImportKeyOptions -->
     *
     * @param importKeyOptions The {@link ImportKeyOptions options object} containing information about the
     * {@link JsonWebKey} being imported.
     *
     * @return A {@link Mono} containing a {@link Response} whose {@link Response#getValue() value} contains the
     * {@link KeyVaultKey imported key}.
     *
     * @throws HttpResponseException If {@link ImportKeyOptions#getName()} is an empty string.
     * @throws NullPointerException If {@code importKeyOptions} is {@code null}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<KeyVaultKey>> importKeyWithResponse(ImportKeyOptions importKeyOptions) {
        try {
            if (importKeyOptions == null) {
                return monoError(LOGGER, new RuntimeException("'importKeyOptions' cannot be null."));
            }

            KeyImportParameters keyImportParameters = new KeyImportParameters(mapJsonWebKey(importKeyOptions.getKey()))
                .setHsm(importKeyOptions.isHardwareProtected())
                .setKeyAttributes(createKeyAttributes(importKeyOptions))
                .setTags(importKeyOptions.getTags())
                .setReleasePolicy(mapKeyReleasePolicy(importKeyOptions.getReleasePolicy()));

            return implClient
                .importKeyWithResponseAsync(importKeyOptions.getName(), BinaryData.fromObject(keyImportParameters),
                    EMPTY_OPTIONS)
                .map(response -> new SimpleResponse<>(response,
                    createKeyVaultKey(response.getValue().toObject(KeyBundle.class))));
        } catch (RuntimeException e) {
            return monoError(LOGGER, e);
        }
    }

    /**
     * Gets the public part of the specified {@link KeyVaultKey key} and key version. The get key operation is
     * applicable to all {@link KeyType key types} and it requires the {@code keys/get} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Gets a specific version of the {@link KeyVaultKey key} in the key vault. Subscribes to the call asynchronously
     * and prints out the {@link KeyVaultKey retrieved key} details when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.getKey#String-String -->
     * <pre>
     * String keyVersion = &quot;&lt;key-version&gt;&quot;;
     *
     * keyAsyncClient.getKey&#40;&quot;keyName&quot;, keyVersion&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;key -&gt;
     *         System.out.printf&#40;&quot;Created key with name: %s and: id %s%n&quot;, key.getName&#40;&#41;,
     *             key.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.getKey#String-String -->
     *
     * @param name The name of the {@link KeyVaultKey key}, cannot be {@code null}.
     * @param version The version of the key to retrieve. If this is an empty String or null, this call is
     * equivalent to calling {@link KeyAsyncClient#getKey(String)}, with the latest version being retrieved.
     *
     * @return A {@link Mono} containing the requested {@link KeyVaultKey key}.
     * The content of the key is {@code null} if both {@code name} and {@code version} are {@code null} or empty.
     *
     * @throws HttpResponseException If a valid {@code name} and a non null/empty {@code version} is specified.
     * @throws ResourceNotFoundException When a {@link KeyVaultKey key} with the provided {@code name} doesn't exist in
     * the key vault or an empty/{@code null} {@code name} and a non-null/empty {@code version} is provided.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<KeyVaultKey> getKey(String name, String version) {
        return getKeyWithResponse(name, version).flatMap(FluxUtil::toMono);
    }

    /**
     * Gets the public part of the specified {@link KeyVaultKey key} and key version. The get key operation is
     * applicable to all {@link KeyType key types} and it requires the {@code keys/get} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Gets a specific version of the {@link KeyVaultKey key} in the key vault. Subscribes to the call asynchronously
     * and prints out the {@link KeyVaultKey retrieved key} details when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.getKeyWithResponse#String-String -->
     * <pre>
     * String keyVersion = &quot;&lt;key-version&gt;&quot;;
     *
     * keyAsyncClient.getKeyWithResponse&#40;&quot;keyName&quot;, keyVersion&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;getKeyResponse -&gt;
     *         System.out.printf&#40;&quot;Created key with name: %s and: id %s%n&quot;,
     *             getKeyResponse.getValue&#40;&#41;.getName&#40;&#41;, getKeyResponse.getValue&#40;&#41;.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.getKeyWithResponse#String-String -->
     *
     * @param name The name of the {@link KeyVaultKey key}, cannot be {@code null}.
     * @param version The version of the key to retrieve. If this is an empty String or null, this call is
     * equivalent to calling {@link KeyAsyncClient#getKey(String)}, with the latest version being retrieved.
     *
     * @return A {@link Mono} containing a {@link Response} whose {@link Response#getValue() value} contains the
     * requested {@link KeyVaultKey key}. The content of the key is {@code null} if both {@code name} and
     * {@code version} are {@code null} or empty.
     *
     * @throws HttpResponseException If a valid {@code name} and a non-null/empty {@code version} is specified.
     * @throws ResourceNotFoundException When a {@link KeyVaultKey key} with the provided {@code name} doesn't exist in
     * the key vault or an empty/{@code null} {@code name} and a non-null/empty {@code version} is provided.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<KeyVaultKey>> getKeyWithResponse(String name, String version) {
        try {
            return implClient.getKeyWithResponseAsync(name, version, EMPTY_OPTIONS)
                .onErrorMap(HttpResponseException.class, KeyAsyncClient::mapGetKeyException)
                .map(response -> new SimpleResponse<>(response,
                    createKeyVaultKey(response.getValue().toObject(KeyBundle.class))));
        } catch (RuntimeException e) {
            return monoError(LOGGER, e);
        }
    }

    /**
     * Maps a {@link HttpResponseException} to an {@link HttpResponseException} for get key operations.
     *
     * @param e The {@link HttpResponseException} to map.
     * @return The {@link HttpResponseException} that maps from the {@link HttpResponseException}.
     */
    static HttpResponseException mapGetKeyException(HttpResponseException e) {
        return e.getResponse().getStatusCode() == 403
            ? new ResourceModifiedException(e.getMessage(), e.getResponse(), e.getValue())
            : e;
    }

    /**
     * Gets the public part of the specified {@link KeyVaultKey key} and key version. The get key operation is
     * applicable to all {@link KeyType key types} and it requires the {@code keys/get} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Gets a specific version of the {@link KeyVaultKey key} in the key vault. Subscribes to the call asynchronously
     * and prints out the {@link KeyVaultKey retrieved key} details when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.getKey#String -->
     * <pre>
     * keyAsyncClient.getKey&#40;&quot;keyName&quot;&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;key -&gt;
     *         System.out.printf&#40;&quot;Created key with name: %s and: id %s%n&quot;, key.getName&#40;&#41;,
     *             key.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.getKey#String -->
     *
     * @param name The name of the {@link KeyVaultKey key}, cannot be {@code null}.
     *
     * @return A {@link Mono} containing the requested {@link KeyVaultKey key}. The content of the key is {@code null}
     * if {@code name} is {@code null} or empty.
     *
     * @throws HttpResponseException If a valid {@code name} and a non-null/empty {@code version} is specified.
     * @throws ResourceNotFoundException When a {@link KeyVaultKey key} with the provided {@code name} doesn't exist in
     * the key vault or an empty/{@code null} {@code name} and a non-null/empty {@code version} is provided.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<KeyVaultKey> getKey(String name) {
        return getKeyWithResponse(name, null).flatMap(FluxUtil::toMono);
    }

    /**
     * Updates the {@link KeyProperties attributes} and {@link KeyOperation key operations} associated with the
     * specified {@link KeyVaultKey key}, but not the cryptographic key material of the specified
     * {@link KeyVaultKey key} in the key vault. The update operation changes specified
     * {@link KeyProperties attributes} of an existing stored {@link KeyVaultKey key} and
     * {@link KeyProperties attributes} that are not specified in the request are left unchanged. The cryptographic
     * key material of a {@link KeyVaultKey key} itself cannot be changed. This operation requires the
     * {@code keys/set} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Gets latest version of the {@link KeyVaultKey key}, changes its notBefore time and then updates it in the
     * Azure Key Vault. Subscribes to the call asynchronously and prints out the {@link KeyVaultKey returned key}
     * details when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.updateKeyPropertiesWithResponse#KeyProperties-KeyOperation -->
     * <pre>
     * keyAsyncClient.getKey&#40;&quot;keyName&quot;&#41;
     *     .subscribe&#40;getKeyResponse -&gt; &#123;
     *         &#47;&#47;Update the not before time of the key.
     *         getKeyResponse.getProperties&#40;&#41;.setNotBefore&#40;OffsetDateTime.now&#40;&#41;.plusDays&#40;50&#41;&#41;;
     *         keyAsyncClient.updateKeyPropertiesWithResponse&#40;getKeyResponse.getProperties&#40;&#41;, KeyOperation.ENCRYPT,
     *                 KeyOperation.DECRYPT&#41;
     *             .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *             .subscribe&#40;updateKeyResponse -&gt;
     *                 System.out.printf&#40;&quot;Updated key's &#92;&quot;not before time&#92;&quot;: %s%n&quot;,
     *                     updateKeyResponse.getValue&#40;&#41;.getProperties&#40;&#41;.getNotBefore&#40;&#41;.toString&#40;&#41;&#41;&#41;;
     *     &#125;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.updateKeyPropertiesWithResponse#KeyProperties-KeyOperation -->
     *
     * @param keyProperties The {@link KeyProperties key properties} object with updated properties.
     * @param keyOperations The updated {@link KeyOperation key operations} to associate with the key.
     *
     * @return A {@link Mono} containing a {@link Response} whose {@link Response#getValue() value} contains the
     * {@link KeyVaultKey updated key}.
     *
     * @throws HttpResponseException If {@link KeyProperties#getName() name} or
     * {@link KeyProperties#getVersion() version} is an empty string.
     * @throws NullPointerException If {@code keyProperties} is null.
     * @throws ResourceNotFoundException When a key with {@link KeyProperties#getName() name} and
     * {@link KeyProperties#getVersion() version} doesn't exist in the key vault.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<KeyVaultKey>> updateKeyPropertiesWithResponse(KeyProperties keyProperties,
        KeyOperation... keyOperations) {

        try {
            if (keyProperties == null) {
                return monoError(LOGGER, new NullPointerException("'keyProperties' cannot be null."));
            }

            KeyUpdateParameters keyUpdateParameters
                = new KeyUpdateParameters().setKeyOps(keyOperations == null ? null : Arrays.asList(keyOperations))
                    .setKeyAttributes(createKeyAttributes(keyProperties))
                    .setTags(keyProperties.getTags())
                    .setReleasePolicy(mapKeyReleasePolicy(keyProperties.getReleasePolicy()));

            return implClient
                .updateKeyWithResponseAsync(keyProperties.getName(), keyProperties.getVersion(),
                    BinaryData.fromObject(keyUpdateParameters), EMPTY_OPTIONS)
                .map(response -> new SimpleResponse<>(response,
                    createKeyVaultKey(response.getValue().toObject(KeyBundle.class))));
        } catch (RuntimeException e) {
            return monoError(LOGGER, e);
        }
    }

    /**
     * Updates the {@link KeyProperties attributes} and {@link KeyOperation key operations} associated with the
     * specified {@link KeyVaultKey key}, but not the cryptographic key material of the specified
     * {@link KeyVaultKey key} in the key vault. The update operation changes specified
     * {@link KeyProperties attributes} of an existing stored {@link KeyVaultKey key} and
     * {@link KeyProperties attributes} that are not specified in the request are left unchanged. The cryptographic
     * key material of a {@link KeyVaultKey key} itself cannot be changed. This operation requires the
     * {@code keys/set} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Gets latest version of the {@link KeyVaultKey key}, changes its notBefore time and then updates it in the
     * Azure Key Vault. Subscribes to the call asynchronously and prints out the {@link KeyVaultKey returned key}
     * details when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.updateKeyProperties#KeyProperties-KeyOperation -->
     * <pre>
     * keyAsyncClient.getKey&#40;&quot;keyName&quot;&#41;
     *     .subscribe&#40;key -&gt; &#123;
     *         &#47;&#47;Update the not before time of the key.
     *         key.getProperties&#40;&#41;.setNotBefore&#40;OffsetDateTime.now&#40;&#41;.plusDays&#40;50&#41;&#41;;
     *         keyAsyncClient.updateKeyProperties&#40;key.getProperties&#40;&#41;, KeyOperation.ENCRYPT,
     *                 KeyOperation.DECRYPT&#41;
     *             .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *             .subscribe&#40;updatedKey -&gt;
     *                 System.out.printf&#40;&quot;Updated key's &#92;&quot;not before time&#92;&quot;: %s%n&quot;,
     *                     updatedKey.getProperties&#40;&#41;.getNotBefore&#40;&#41;.toString&#40;&#41;&#41;&#41;;
     *     &#125;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.updateKeyProperties#KeyProperties-KeyOperation -->
     *
     * @param keyProperties The {@link KeyProperties key properties} object with updated properties.
     * @param keyOperations The updated {@link KeyOperation key operations} to associate with the key.
     *
     * @return A {@link Mono} containing the {@link KeyVaultKey updated key}.
     *
     * @throws HttpResponseException If {@link KeyProperties#getName() name} or
     * {@link KeyProperties#getVersion() version} is an empty string.
     * @throws NullPointerException If {@code key} is {@code null}.
     * @throws ResourceNotFoundException When a key with {@link KeyProperties#getName() name} and
     * {@link KeyProperties#getVersion() version} doesn't exist in the key vault.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<KeyVaultKey> updateKeyProperties(KeyProperties keyProperties, KeyOperation... keyOperations) {
        return updateKeyPropertiesWithResponse(keyProperties, keyOperations).flatMap(FluxUtil::toMono);
    }

    /**
     * Deletes a {@link KeyVaultKey key} of any type from the key vault. If soft-delete is enabled on the key vault then
     * the {@link KeyVaultKey key} is placed in the deleted state and requires to be purged for permanent deletion
     * else the {@link KeyVaultKey key} is permanently deleted. The delete operation applies to any
     * {@link KeyVaultKey key} stored in Azure Key Vault but it cannot be applied to an individual version
     * of a {@link KeyVaultKey key}. This operation removes the cryptographic material associated with the
     * {@link KeyVaultKey key}, which means the {@link KeyVaultKey key} is not usable for {@code Sign/Verify},
     * {@code Wrap/Unwrap} or {@code Encrypt/Decrypt} operations. This operation requires the {@code keys/delete}
     * permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Deletes the {@link KeyVaultKey key} in the Azure Key Vault. Subscribes to the call asynchronously and prints
     * out the {@link KeyVaultKey deleted key} details when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.deleteKey#String -->
     * <pre>
     * keyAsyncClient.beginDeleteKey&#40;&quot;keyName&quot;&#41;
     *     .subscribe&#40;pollResponse -&gt; &#123;
     *         System.out.printf&#40;&quot;Deletion status: %s%n&quot;, pollResponse.getStatus&#40;&#41;&#41;;
     *         System.out.printf&#40;&quot;Key name: %s%n&quot;, pollResponse.getValue&#40;&#41;.getName&#40;&#41;&#41;;
     *         System.out.printf&#40;&quot;Key delete date: %s%n&quot;, pollResponse.getValue&#40;&#41;.getDeletedOn&#40;&#41;&#41;;
     *     &#125;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.deleteKey#String -->
     *
     * @param name The name of the {@link KeyVaultKey key} to be deleted.
     *
     * @return A {@link PollerFlux} to poll on the {@link DeletedKey deleted key} status.
     *
     * @throws HttpResponseException When a key with {@code name} is an empty string.
     * @throws ResourceNotFoundException When a key with {@code name} doesn't exist in the key vault.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    public PollerFlux<DeletedKey, Void> beginDeleteKey(String name) {
        return new PollerFlux<>(Duration.ofSeconds(1), deleteActivationOperation(name), deletePollOperation(name),
            (context, firstResponse) -> Mono.empty(), context -> Mono.empty());
    }

    private Function<PollingContext<DeletedKey>, Mono<DeletedKey>> deleteActivationOperation(String name) {
        return pollingContext -> implClient.deleteKeyWithResponseAsync(name, EMPTY_OPTIONS)
            .map(response -> createDeletedKey(response.getValue().toObject(DeletedKeyBundle.class)));
    }

    private Function<PollingContext<DeletedKey>, Mono<PollResponse<DeletedKey>>> deletePollOperation(String name) {
        return pollingContext -> implClient.getDeletedKeyWithResponseAsync(name, EMPTY_OPTIONS)
            .map(response -> new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                createDeletedKey(response.getValue().toObject(DeletedKeyBundle.class))))
            .onErrorResume(HttpResponseException.class, e -> {
                if (e.getResponse().getStatusCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                    return Mono.just(new PollResponse<>(LongRunningOperationStatus.IN_PROGRESS,
                        pollingContext.getLatestResponse().getValue()));
                } else {
                    // This means either vault has soft-delete disabled or permission is not granted for the get deleted key
                    // operation. In both cases deletion operation was successful when activation operation succeeded before
                    // reaching here.
                    return Mono.just(new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                        pollingContext.getLatestResponse().getValue()));
                }
            })
            // This means either vault has soft-delete disabled or permission is not granted for the get deleted key
            // operation. In both cases deletion operation was successful when activation operation succeeded before
            // reaching here.
            .onErrorReturn(new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                pollingContext.getLatestResponse().getValue()));
    }

    /**
     * Gets the public part of a {@link KeyVaultKey deleted key}. The get deleted Key operation is applicable for
     * soft-delete enabled vaults. This operation requires the {@code keys/get} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p> Gets the {@link KeyVaultKey deleted key} from the key vault enabled for soft-delete. Subscribes to the call
     * asynchronously and prints out the {@link KeyVaultKey deleted key} details when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.getDeletedKey#String -->
     * <pre>
     * keyAsyncClient.getDeletedKey&#40;&quot;keyName&quot;&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;deletedKey -&gt;
     *         System.out.printf&#40;&quot;Deleted key's recovery id:%s%n&quot;, deletedKey.getRecoveryId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.getDeletedKey#String -->
     *
     * @param name The name of the deleted {@link KeyVaultKey key}.
     *
     * @return A {@link Mono} containing the {@link DeletedKey deleted key}.
     *
     * @throws HttpResponseException When a key with {@code name} is an empty string.
     * @throws ResourceNotFoundException When a key with {@code name} doesn't exist in the key vault.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<DeletedKey> getDeletedKey(String name) {
        return getDeletedKeyWithResponse(name).flatMap(FluxUtil::toMono);
    }

    /**
     * Gets the public part of a {@link KeyVaultKey deleted key}. The get deleted Key operation is applicable for
     * soft-delete enabled vaults. This operation requires the {@code keys/get} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p> Gets the {@link KeyVaultKey deleted key} from the key vault enabled for soft-delete. Subscribes to the call
     * asynchronously and prints out the {@link KeyVaultKey deleted key} details when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.getDeletedKeyWithResponse#String -->
     * <pre>
     * keyAsyncClient.getDeletedKeyWithResponse&#40;&quot;keyName&quot;&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;getDeletedKeyResponse -&gt;
     *         System.out.printf&#40;&quot;Deleted key's recovery id: %s%n&quot;, getDeletedKeyResponse.getValue&#40;&#41;.getRecoveryId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.getDeletedKeyWithResponse#String -->
     *
     * @param name The name of the deleted {@link KeyVaultKey key}.
     *
     * @return A {@link Mono} containing a {@link Response} whose {@link Response#getValue() value} contains the
     * {@link DeletedKey deleted key}.
     *
     * @throws HttpResponseException When a key with {@code name} is an empty string.
     * @throws ResourceNotFoundException When a key with {@code name} doesn't exist in the key vault.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<DeletedKey>> getDeletedKeyWithResponse(String name) {
        try {
            return implClient.getDeletedKeyWithResponseAsync(name, EMPTY_OPTIONS)
                .map(response -> new SimpleResponse<>(response,
                    createDeletedKey(response.getValue().toObject(DeletedKeyBundle.class))));
        } catch (RuntimeException e) {
            return monoError(LOGGER, e);
        }
    }

    /**
     * Permanently deletes the specified {@link KeyVaultKey key} without the possibility of recovery. The purge
     * deleted key operation is applicable for soft-delete enabled vaults. This operation requires the
     * {@code keys/purge} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Purges the {@link KeyVaultKey deleted key} from the key vault enabled for soft-delete. Subscribes to the call
     * asynchronously and prints out the status code from the server response when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.purgeDeletedKey#String -->
     * <pre>
     * keyAsyncClient.purgeDeletedKey&#40;&quot;deletedKeyName&quot;&#41;
     *     .subscribe&#40;ignored -&gt;
     *         System.out.println&#40;&quot;Successfully purged deleted key&quot;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.purgeDeletedKey#String -->
     *
     * @param name The name of the {@link KeyVaultKey deleted key}.
     *
     * @return An empty {@link Mono}.
     *
     * @throws HttpResponseException When a key with {@code name} is an empty string.
     * @throws ResourceNotFoundException When a key with {@code name} doesn't exist in the key vault.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> purgeDeletedKey(String name) {
        return purgeDeletedKeyWithResponse(name).flatMap(FluxUtil::toMono);
    }

    /**
     * Permanently deletes the specified {@link KeyVaultKey key} without the possibility of recovery. The purge
     * deleted key operation is applicable for soft-delete enabled vaults. This operation requires the
     * {@code keys/purge} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Purges the {@link KeyVaultKey deleted key} from the key vault enabled for soft-delete. Subscribes to the call
     * asynchronously and prints out the status code from the server response when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.purgeDeletedKeyWithResponse#String -->
     * <pre>
     * keyAsyncClient.purgeDeletedKeyWithResponse&#40;&quot;deletedKeyName&quot;&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;purgeDeletedKeyResponse -&gt;
     *         System.out.printf&#40;&quot;Purge response status code: %d%n&quot;, purgeDeletedKeyResponse.getStatusCode&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.purgeDeletedKeyWithResponse#String -->
     *
     * @param name The name of the {@link KeyVaultKey deleted key}.
     *
     * @return A {@link Mono} containing a Response containing status code and HTTP headers.
     *
     * @throws HttpResponseException When a key with {@code name} is an empty string.
     * @throws ResourceNotFoundException When a key with {@code name} doesn't exist in the key vault.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> purgeDeletedKeyWithResponse(String name) {
        try {
            return implClient.purgeDeletedKeyWithResponseAsync(name, EMPTY_OPTIONS);
        } catch (RuntimeException e) {
            return monoError(LOGGER, e);
        }
    }

    /**
     * Recovers the {@link KeyVaultKey deleted key} in the key vault to its latest version and can only be performed
     * on a soft-delete enabled vault. An attempt to recover an {@link KeyVaultKey non-deleted key} will return an
     * error. Consider this the inverse of the delete operation on soft-delete enabled vaults. This operation
     * requires the {@code keys/recover} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Recovers the {@link KeyVaultKey deleted key} from the key vault enabled for soft-delete. Subscribes to the
     * call asynchronously and prints out the recovered key details when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.recoverDeletedKey#String -->
     * <pre>
     * keyAsyncClient.beginRecoverDeletedKey&#40;&quot;deletedKeyName&quot;&#41;
     *     .subscribe&#40;pollResponse -&gt; &#123;
     *         System.out.printf&#40;&quot;Recovery status: %s%n&quot;, pollResponse.getStatus&#40;&#41;&#41;;
     *         System.out.printf&#40;&quot;Key name: %s%n&quot;, pollResponse.getValue&#40;&#41;.getName&#40;&#41;&#41;;
     *         System.out.printf&#40;&quot;Key type: %s%n&quot;, pollResponse.getValue&#40;&#41;.getKeyType&#40;&#41;&#41;;
     *     &#125;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.recoverDeletedKey#String -->
     *
     * @param name The name of the {@link KeyVaultKey deleted key} to be recovered.
     *
     * @return A {@link PollerFlux} to poll on the {@link KeyVaultKey recovered key} status.
     *
     * @throws HttpResponseException When a key with {@code name} is an empty string.
     * @throws ResourceNotFoundException When a key with {@code name} doesn't exist in the key vault.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    public PollerFlux<KeyVaultKey, Void> beginRecoverDeletedKey(String name) {
        return new PollerFlux<>(Duration.ofSeconds(1), recoverActivationOperation(name), recoverPollOperation(name),
            (context, firstResponse) -> Mono.empty(), context -> Mono.empty());
    }

    private Function<PollingContext<KeyVaultKey>, Mono<KeyVaultKey>> recoverActivationOperation(String name) {
        return pollingContext -> implClient.recoverDeletedKeyWithResponseAsync(name, EMPTY_OPTIONS)
            .map(response -> KeyVaultKeysModelsUtils.createKeyVaultKey(response.getValue().toObject(KeyBundle.class)));
    }

    private Function<PollingContext<KeyVaultKey>, Mono<PollResponse<KeyVaultKey>>>
        recoverPollOperation(String keyName) {

        return pollingContext -> implClient.getKeyWithResponseAsync(keyName, null, EMPTY_OPTIONS)
            .map(response -> new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                createKeyVaultKey(response.getValue().toObject(KeyBundle.class))))
            .onErrorResume(HttpResponseException.class, e -> {
                if (e.getResponse().getStatusCode() == 404) {
                    return Mono.just(new PollResponse<>(LongRunningOperationStatus.IN_PROGRESS,
                        pollingContext.getLatestResponse().getValue()));
                } else {
                    // This means permission is not granted for the get key operation. In both cases recovery operation
                    // was successful when activation operation succeeded before reaching here.
                    return Mono.just(new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                        pollingContext.getLatestResponse().getValue()));
                }
            })
            // This means permission is not granted for the get deleted key operation. In both cases deletion
            // operation was successful when activation operation succeeded before reaching here.
            .onErrorReturn(new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                pollingContext.getLatestResponse().getValue()));
    }

    /**
     * Requests a backup of the specified {@link KeyVaultKey key} be downloaded to the client. The key backup
     * operation exports a {@link KeyVaultKey key} from Azure Key Vault in a protected form. Note that this operation
     * does not return key material in a form that can be used outside the Azure Key Vault system, the returned key
     * material is either protected to a Azure Key Vault HSM or to Azure Key Vault itself. The intent of this
     * operation is to allow a client to generate a {@link KeyVaultKey key} in one Azure Key Vault instance, backup the
     * {@link KeyVaultKey key}, and then restore it into another Azure Key Vault instance. The backup operation may
     * be used to export, in protected form, any {@link KeyType key type} from Azure Key Vault. Individual versions
     * of a {@link KeyVaultKey key} cannot be backed up. {@code Backup/Restore} can be performed within geographical
     * boundaries only; meaning that a backup from one geographical area cannot be restored to another geographical
     * area. For example, a backup from the US geographical area cannot be restored in an EU geographical area. This
     * operation requires the {@code key/backup} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Backs up the {@link KeyVaultKey key} from the key vault. Subscribes to the call asynchronously and prints out
     * the length of the key's backup byte array returned in the response.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.backupKey#String -->
     * <pre>
     * keyAsyncClient.backupKey&#40;&quot;keyName&quot;&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;bytes -&gt;
     *         System.out.printf&#40;&quot;Key backup byte array length: %s%n&quot;, bytes.length&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.backupKey#String -->
     *
     * @param name The name of the {@link KeyVaultKey key}.
     *
     * @return A {@link Mono} containing the backed up key blob.
     *
     * @throws HttpResponseException When a key with {@code name} is an empty string.
     * @throws ResourceNotFoundException When a key with {@code name} doesn't exist in the key vault.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<byte[]> backupKey(String name) {
        return backupKeyWithResponse(name).flatMap(FluxUtil::toMono);
    }

    /**
     * Requests a backup of the specified {@link KeyVaultKey key} be downloaded to the client. The key backup
     * operation exports a {@link KeyVaultKey key} from Azure Key Vault in a protected form. Note that this operation
     * does not return key material in a form that can be used outside the Azure Key Vault system, the returned key
     * material is either protected to a Azure Key Vault HSM or to Azure Key Vault itself. The intent of this
     * operation is to allow a client to generate a {@link KeyVaultKey key} in one Azure Key Vault instance, backup the
     * {@link KeyVaultKey key}, and then restore it into another Azure Key Vault instance. The backup operation may
     * be used to export, in protected form, any {@link KeyType key type} from Azure Key Vault. Individual versions
     * of a {@link KeyVaultKey key} cannot be backed up. {@code Backup/Restore} can be performed within geographical
     * boundaries only; meaning that a backup from one geographical area cannot be restored to another geographical
     * area. For example, a backup from the US geographical area cannot be restored in an EU geographical area. This
     * operation requires the {@code key/backup} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Backs up the {@link KeyVaultKey key} from the key vault. Subscribes to the call asynchronously and prints out
     * the length of the key's backup byte array returned in the response.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.backupKeyWithResponse#String -->
     * <pre>
     * keyAsyncClient.backupKeyWithResponse&#40;&quot;keyName&quot;&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;backupKeyResponse -&gt;
     *         System.out.printf&#40;&quot;Key backup byte array length: %s%n&quot;, backupKeyResponse.getValue&#40;&#41;.length&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.backupKeyWithResponse#String -->
     *
     * @param name The name of the {@link KeyVaultKey key}.
     *
     * @return A {@link Mono} containing a {@link Response} whose {@link Response#getValue() value} contains the backed up
     * key blob.
     *
     * @throws ResourceNotFoundException When a key with {@code name} doesn't exist in the key vault.
     * @throws HttpResponseException When a key with {@code name} is an empty string.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<byte[]>> backupKeyWithResponse(String name) {
        try {
            return implClient.backupKeyWithResponseAsync(name, EMPTY_OPTIONS)
                .map(response -> new SimpleResponse<>(response,
                    response.getValue().toObject(BackupKeyResult.class).getValue()));
        } catch (RuntimeException e) {
            return monoError(LOGGER, e);
        }
    }

    /**
     * Restores a backed up {@link KeyVaultKey key} to a vault. Imports a previously backed up {@link KeyVaultKey key}
     * into Azure Key Vault, restoring the {@link KeyVaultKey key}, its key identifier, attributes and access control
     * policies. The restore operation may be used to import a previously backed up {@link KeyVaultKey key}. Individual
     * versions of a {@link KeyVaultKey key} cannot be restored. The {@link KeyVaultKey key} is restored in its entirety
     * with the same key name as it had when it was backed up. If the key name is not available in the target key vault,
     * the restore operation will be rejected. While the key name is retained during restore, the final key identifier
     * will change if the {@link KeyVaultKey key} is restored to a different vault. Restore will restore all versions
     * and preserve version identifiers. The restore operation is subject to security constraints: The target key
     * vault must be owned by the same Microsoft Azure Subscription as the source key vault. The user must have
     * the {@code restore} permission in the target key vault. This operation requires the {@code keys/restore}
     * permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Restores the {@link KeyVaultKey key} in the key vault from its backup. Subscribes to the call asynchronously
     * and prints out the restored key details when a response has been received.</p>
     * //Pass the Key Backup Byte array to the restore operation.
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.restoreKeyBackup#byte -->
     * <pre>
     * keyAsyncClient.restoreKeyBackup&#40;keyBackupByteArray&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;restoreKeyResponse -&gt;
     *         System.out.printf&#40;&quot;Restored key with name: %s and: id %s%n&quot;, restoreKeyResponse.getName&#40;&#41;,
     *             restoreKeyResponse.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.restoreKeyBackup#byte -->
     *
     * @param backup The backup blob associated with the {@link KeyVaultKey key}.
     *
     * @return A {@link Mono} containing the {@link KeyVaultKey restored key}.
     *
     * @throws ResourceModifiedException When {@code backup} blob is malformed.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<KeyVaultKey> restoreKeyBackup(byte[] backup) {
        return restoreKeyBackupWithResponse(backup).flatMap(FluxUtil::toMono);
    }

    /**
     * Restores a backed up {@link KeyVaultKey key} to a vault. Imports a previously backed up {@link KeyVaultKey key}
     * into Azure Key Vault, restoring the {@link KeyVaultKey key}, its key identifier, attributes and access control
     * policies. The restore operation may be used to import a previously backed up {@link KeyVaultKey key}. Individual
     * versions of a {@link KeyVaultKey key} cannot be restored. The {@link KeyVaultKey key} is restored in its entirety
     * with the same key name as it had when it was backed up. If the key name is not available in the target key vault,
     * the restore operation will be rejected. While the key name is retained during restore, the final key identifier
     * will change if the {@link KeyVaultKey key} is restored to a different vault. Restore will restore all versions
     * and preserve version identifiers. The restore operation is subject to security constraints: The target key
     * vault must be owned by the same Microsoft Azure Subscription as the source key vault. The user must have
     * the {@code restore} permission in the target key vault. This operation requires the {@code keys/restore}
     * permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Restores the {@link KeyVaultKey key} in the key vault from its backup. Subscribes to the call asynchronously
     * and prints out the restored key details when a response has been received.</p>
     * //Pass the Key Backup Byte array to the restore operation.
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.restoreKeyBackupWithResponse#byte -->
     * <pre>
     * keyAsyncClient.restoreKeyBackupWithResponse&#40;keyBackupByteArray&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;restoreKeyBackupResponse -&gt;
     *         System.out.printf&#40;&quot;Restored key with name: %s and: id %s%n&quot;,
     *             restoreKeyBackupResponse.getValue&#40;&#41;.getName&#40;&#41;, restoreKeyBackupResponse.getValue&#40;&#41;.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.restoreKeyBackupWithResponse#byte -->
     *
     * @param backup The backup blob associated with the {@link KeyVaultKey key}.
     *
     * @return A {@link Mono} containing a {@link Response} whose {@link Response#getValue() value} contains the
     * {@link KeyVaultKey restored key}.
     *
     * @throws ResourceModifiedException When {@code backup} blob is malformed.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<KeyVaultKey>> restoreKeyBackupWithResponse(byte[] backup) {
        try {
            KeyRestoreParameters keyRestoreParameters = new KeyRestoreParameters(backup);

            return implClient.restoreKeyWithResponseAsync(BinaryData.fromObject(keyRestoreParameters), EMPTY_OPTIONS)
                .onErrorMap(HttpResponseException.class, KeyAsyncClient::mapRestoreKeyException)
                .map(response -> new SimpleResponse<>(response,
                    createKeyVaultKey(response.getValue().toObject(KeyBundle.class))));
        } catch (RuntimeException e) {
            return monoError(LOGGER, e);
        }
    }

    static HttpResponseException mapRestoreKeyException(HttpResponseException e) {
        return (e.getResponse().getStatusCode() == 400)
            ? new ResourceModifiedException(e.getMessage(), e.getResponse(), e.getValue())
            : e;
    }

    /**
     * List {@link KeyVaultKey keys} in the key vault. Retrieves a list of the {@link KeyVaultKey keys} in the key
     * vault as {@link JsonWebKey} structures that contain the public part of a stored {@link KeyVaultKey key}. The list
     * operation is applicable to all {@link KeyType key types} and the individual {@link KeyVaultKey key} response
     * in the list is represented by {@link KeyProperties} as only the key identifier, attributes and tags are
     * provided in the response. The key material and individual key versions are not listed in the response. This
     * operation requires the {@code keys/list} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>It is possible to get {@link KeyVaultKey full keys} with key material from this information. Convert the
     * {@link Flux} containing {@link KeyProperties key properties} to {@link Flux} containing
     * {@link KeyVaultKey key} using {@link KeyAsyncClient#getKey(String, String)} within
     * {@link Flux#flatMap(Function)}.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.listPropertiesOfKeys -->
     * <pre>
     * keyAsyncClient.listPropertiesOfKeys&#40;&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .flatMap&#40;keyProperties -&gt; keyAsyncClient.getKey&#40;keyProperties.getName&#40;&#41;, keyProperties.getVersion&#40;&#41;&#41;&#41;
     *     .subscribe&#40;key -&gt; System.out.printf&#40;&quot;Retrieved key with name: %s and type: %s%n&quot;,
     *         key.getName&#40;&#41;,
     *         key.getKeyType&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.listPropertiesOfKeys -->
     *
     * @return A {@link PagedFlux} containing {@link KeyProperties key} of all the keys in the vault.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<KeyProperties> listPropertiesOfKeys() {
        PagedFlux<BinaryData> pagedFlux = implClient.getKeysAsync(EMPTY_OPTIONS);

        return PagedFlux.create(() -> (continuationTokenParam, pageSizeParam) -> {
            Flux<PagedResponse<BinaryData>> pagedResponseFlux = (continuationTokenParam == null)
                ? pagedFlux.byPage().take(1)
                : pagedFlux.byPage(continuationTokenParam).take(1);

            return pagedResponseFlux.map(pagedResponse -> mapPagedResponse(pagedResponse,
                binaryData -> KeyVaultKeysModelsUtils.createKeyProperties(binaryData.toObject(KeyItem.class))));
        });
    }

    private static <T, R> PagedResponse<R> mapPagedResponse(PagedResponse<T> page, Function<T, R> itemMapper) {
        List<R> mappedValues = new ArrayList<>(page.getValue().size());

        for (T item : page.getValue()) {
            mappedValues.add(itemMapper.apply(item));
        }

        return new PagedResponseBase<>(page.getRequest(), page.getStatusCode(), page.getHeaders(), mappedValues,
            page.getContinuationToken(), null);
    }

    /**
     * Lists {@link DeletedKey deleted keys} of the key vault. The {@link DeletedKey deleted keys} are retrieved as
     * {@link JsonWebKey} structures that contain the public part of a {@link DeletedKey deleted key}. The get deleted
     * keys operation is applicable for vaults enabled for soft-delete. This operation requires the {@code keys/list}
     * permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Lists the {@link DeletedKey deleted keys} in the key vault. Subscribes to the call asynchronously and prints
     * out the recovery id of each {@link DeletedKey deleted key} when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.listDeletedKeys -->
     * <pre>
     * keyAsyncClient.listDeletedKeys&#40;&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;deletedKey -&gt;
     *         System.out.printf&#40;&quot;Deleted key's recovery id:%s%n&quot;, deletedKey.getRecoveryId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.listDeletedKeys -->
     *
     * @return A {@link PagedFlux} containing all of the {@link DeletedKey deleted keys} in the vault.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<DeletedKey> listDeletedKeys() {
        PagedFlux<BinaryData> pagedFlux = implClient.getDeletedKeysAsync(EMPTY_OPTIONS);

        return PagedFlux.create(() -> (continuationTokenParam, pageSizeParam) -> {
            Flux<PagedResponse<BinaryData>> pagedResponseFlux = (continuationTokenParam == null)
                ? pagedFlux.byPage().take(1)
                : pagedFlux.byPage(continuationTokenParam).take(1);

            return pagedResponseFlux.map(pagedResponse -> mapPagedResponse(pagedResponse,
                binaryData -> createDeletedKey(binaryData.toObject(DeletedKeyItem.class))));
        });
    }

    /**
     * List all versions of the specified {@link KeyVaultKey keys}. The individual key response in the flux is
     * represented by {@link KeyProperties} as only the key identifier, attributes and tags are provided in the
     * response. The key material values are not provided in the response. This operation requires the
     * {@code keys/list} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>It is possible to get the keys with key material of all the versions from this information. Convert the
     * {@link Flux} containing {@link KeyProperties key properties} to {@link Flux} containing
     * {@link KeyVaultKey key } using {@link KeyAsyncClient#getKey(String, String)} within
     * {@link Flux#flatMap(Function)}.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.listKeyVersions -->
     * <pre>
     * keyAsyncClient.listPropertiesOfKeyVersions&#40;&quot;keyName&quot;&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .flatMap&#40;keyProperties -&gt; keyAsyncClient.getKey&#40;keyProperties.getName&#40;&#41;, keyProperties.getVersion&#40;&#41;&#41;&#41;
     *     .subscribe&#40;key -&gt;
     *         System.out.printf&#40;&quot;Retrieved key version: %s with name: %s and type: %s%n&quot;,
     *             key.getProperties&#40;&#41;.getVersion&#40;&#41;, key.getName&#40;&#41;, key.getKeyType&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.listKeyVersions -->
     *
     * @param name The name of the {@link KeyVaultKey key}.
     *
     * @return A {@link PagedFlux} containing {@link KeyProperties} of all the versions of the specified
     * {@link KeyVaultKey keys} in the vault. {@link Flux} is empty if key with {@code name} does not exist in the key
     * vault.
     *
     * @throws ResourceNotFoundException When a given key {@code name} is {@code null} or an empty string.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<KeyProperties> listPropertiesOfKeyVersions(String name) {
        PagedFlux<BinaryData> pagedFlux = implClient.getKeyVersionsAsync(name, EMPTY_OPTIONS);

        return PagedFlux.create(() -> (continuationTokenParam, pageSizeParam) -> {
            Flux<PagedResponse<BinaryData>> pagedResponseFlux = (continuationTokenParam == null)
                ? pagedFlux.byPage().take(1)
                : pagedFlux.byPage(continuationTokenParam).take(1);

            return pagedResponseFlux.map(pagedResponse -> mapPagedResponse(pagedResponse,
                binaryData -> KeyVaultKeysModelsUtils.createKeyProperties(binaryData.toObject(KeyItem.class))));
        });
    }

    /**
     * Get the requested number of bytes containing random values from a managed HSM.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Gets a number of bytes containing random values from a Managed HSM. Prints out the retrieved bytes in
     * base64Url format.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.getRandomBytes#int -->
     * <pre>
     * int amount = 16;
     * keyAsyncClient.getRandomBytes&#40;amount&#41;
     *     .subscribe&#40;randomBytes -&gt;
     *         System.out.printf&#40;&quot;Retrieved %d random bytes: %s%n&quot;, amount, Arrays.toString&#40;randomBytes&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.getRandomBytes#int -->
     *
     * @param count The requested number of random bytes.
     *
     * @return A {@link Mono} containing the requested number of bytes containing random values from a managed HSM.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<byte[]> getRandomBytes(int count) {
        return getRandomBytesWithResponse(count).flatMap(FluxUtil::toMono);
    }

    /**
     * Get the requested number of bytes containing random values from a managed HSM.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Gets a number of bytes containing random values from a Managed HSM. Prints out the
     * {@link Response HTTP Response} details and the retrieved bytes in base64Url format.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.getRandomBytesWithResponse#int -->
     * <pre>
     * int amountOfBytes = 16;
     * keyAsyncClient.getRandomBytesWithResponse&#40;amountOfBytes&#41;.subscribe&#40;response -&gt;
     *     System.out.printf&#40;&quot;Response received successfully with status code: %d. Retrieved %d random bytes: %s%n&quot;,
     *         response.getStatusCode&#40;&#41;, amountOfBytes, Arrays.toString&#40;response.getValue&#40;&#41;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.getRandomBytesWithResponse#int -->
     *
     * @param count The requested number of random bytes.
     *
     * @return A {@link Mono} containing the {@link Response HTTP response} for this operation and the requested number
     * of bytes containing random values from a managed HSM.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<byte[]>> getRandomBytesWithResponse(int count) {
        try {
            GetRandomBytesRequest getRandomBytesRequest = new GetRandomBytesRequest(count);

            return withContext(context -> implClient
                .getRandomBytesWithResponseAsync(BinaryData.fromObject(getRandomBytesRequest), EMPTY_OPTIONS)
                .map(response -> new SimpleResponse<>(response,
                    response.getValue().toObject(RandomBytes.class).getValue())));
        } catch (RuntimeException e) {
            return monoError(LOGGER, e);
        }
    }

    /**
     * Releases the latest version of a {@link KeyVaultKey key}.
     *
     * <p>The {@link KeyVaultKey key} must be exportable. This operation requires the {@code keys/release} permission.
     * </p>
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Releases a {@link KeyVaultKey key}. Subscribes to the call asynchronously and prints out the signed object
     * that contains the {@link KeyVaultKey released key} when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyClient.releaseKey#String-String -->
     * <pre>
     * String targetAttestationToken = &quot;someAttestationToken&quot;;
     * ReleaseKeyResult releaseKeyResult = keyClient.releaseKey&#40;&quot;keyName&quot;, targetAttestationToken&#41;;
     *
     * System.out.printf&#40;&quot;Signed object containing released key: %s%n&quot;, releaseKeyResult&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyClient.releaseKey#String-String -->
     *
     * @param name The name of the {@link KeyVaultKey key} to release.
     * @param targetAttestationToken The attestation assertion for the target of the {@link KeyVaultKey key} release.
     *
     * @return A {@link Mono} containing the {@link ReleaseKeyResult} containing the released key.
     *
     * @throws IllegalArgumentException If {@code name} or {@code targetAttestationToken} are {@code null} or empty.
     * @throws ResourceNotFoundException If the {@link KeyVaultKey key} for the provided {@code name} does not exist.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<ReleaseKeyResult> releaseKey(String name, String targetAttestationToken) {
        return releaseKeyWithResponse(name, null, targetAttestationToken, new ReleaseKeyOptions())
            .flatMap(FluxUtil::toMono);
    }

    /**
     * Releases a key.
     *
     * <p>The key must be exportable. This operation requires the 'keys/release' permission.</p>
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Releases a {@link KeyVaultKey key}. Subscribes to the call asynchronously and prints out the signed object
     * that contains the {@link KeyVaultKey released key} when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.releaseKey#String-String-String -->
     * <pre>
     * String myKeyVersion = &quot;&lt;key-version&gt;&quot;;
     * String myTargetAttestationToken = &quot;someAttestationToken&quot;;
     *
     * keyAsyncClient.releaseKey&#40;&quot;keyName&quot;, myKeyVersion, myTargetAttestationToken&#41;
     *     .subscribe&#40;releaseKeyResult -&gt;
     *         System.out.printf&#40;&quot;Signed object containing released key: %s%n&quot;, releaseKeyResult.getValue&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.releaseKey#String-String-String -->
     *
     * @param name The name of the {@link KeyVaultKey key} to release.
     * @param version The version of the key to retrieve. If this is empty or {@code null}, this call is equivalent to
     * calling {@link KeyAsyncClient#releaseKey(String, String)}, with the latest key version being released.
     * @param targetAttestationToken The attestation assertion for the target of the key release.
     *
     * @return A {@link Mono} containing the {@link ReleaseKeyResult} containing the released key.
     *
     * @throws IllegalArgumentException If {@code name} or {@code targetAttestationToken} are {@code null} or empty.
     * @throws ResourceNotFoundException If the {@link KeyVaultKey key} for the provided {@code name} does not exist.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<ReleaseKeyResult> releaseKey(String name, String version, String targetAttestationToken) {
        return releaseKeyWithResponse(name, version, targetAttestationToken, new ReleaseKeyOptions())
            .flatMap(FluxUtil::toMono);
    }

    /**
     * Releases a key.
     *
     * <p>The key must be exportable. This operation requires the 'keys/release' permission.</p>
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Releases a {@link KeyVaultKey key}. Subscribes to the call asynchronously and prints out the
     * {@link Response HTTP Response} details and the signed object that contains the {@link KeyVaultKey released key}
     * when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.releaseKeyWithResponse#String-String-String-ReleaseKeyOptions -->
     * <pre>
     * String releaseKeyVersion = &quot;&lt;key-version&gt;&quot;;
     * String someTargetAttestationToken = &quot;someAttestationToken&quot;;
     * ReleaseKeyOptions releaseKeyOptions = new ReleaseKeyOptions&#40;&#41;
     *     .setAlgorithm&#40;KeyExportEncryptionAlgorithm.RSA_AES_KEY_WRAP_256&#41;
     *     .setNonce&#40;&quot;someNonce&quot;&#41;;
     *
     * keyAsyncClient.releaseKeyWithResponse&#40;&quot;keyName&quot;, releaseKeyVersion, someTargetAttestationToken,
     *         releaseKeyOptions&#41;
     *     .subscribe&#40;releaseKeyResponse -&gt;
     *         System.out.printf&#40;&quot;Response received successfully with status code: %d. Signed object containing&quot;
     *                 + &quot;released key: %s%n&quot;, releaseKeyResponse.getStatusCode&#40;&#41;,
     *             releaseKeyResponse.getValue&#40;&#41;.getValue&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.releaseKeyWithResponse#String-String-String-ReleaseKeyOptions -->
     *
     * @param name The name of the key to release.
     * @param version The version of the key to retrieve. If this is empty or {@code null}, this call is equivalent to
     * calling {@link KeyAsyncClient#releaseKey(String, String)}, with the latest key version being released.
     * @param targetAttestationToken The attestation assertion for the target of the key release.
     * @param releaseKeyOptions Additional {@link ReleaseKeyOptions options} for releasing a {@link KeyVaultKey key}.
     *
     * @return A {@link Mono} containing the {@link Response HTTP response} for this operation and the
     * {@link ReleaseKeyResult} containing the released key.
     *
     * @throws IllegalArgumentException If {@code name} or {@code targetAttestationToken} are {@code null} or empty.
     * @throws ResourceNotFoundException If the {@link KeyVaultKey key} for the provided {@code name} does not exist.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<ReleaseKeyResult>> releaseKeyWithResponse(String name, String version,
        String targetAttestationToken, ReleaseKeyOptions releaseKeyOptions) {

        try {
            if (CoreUtils.isNullOrEmpty(name) || CoreUtils.isNullOrEmpty(targetAttestationToken)) {
                return monoError(LOGGER,
                    new IllegalArgumentException("'name' or 'targetAttestationToken' cannot be null or empty."));
            }

            String nonce = releaseKeyOptions == null ? null : releaseKeyOptions.getNonce();
            KeyExportEncryptionAlgorithm algorithm
                = releaseKeyOptions == null ? null : releaseKeyOptions.getAlgorithm();

            KeyReleaseParameters keyReleaseParameters
                = new KeyReleaseParameters(targetAttestationToken).setNonce(nonce).setEnc(algorithm);

            return implClient
                .releaseWithResponseAsync(name, version, BinaryData.fromObject(keyReleaseParameters), EMPTY_OPTIONS)
                .map(binaryData -> new SimpleResponse<>(binaryData,
                    binaryData.getValue().toObject(ReleaseKeyResult.class)));
        } catch (RuntimeException e) {
            return monoError(LOGGER, e);
        }
    }

    /**
     * Rotates a {@link KeyVaultKey key}. The rotate key operation will do so based on
     * {@link KeyRotationPolicy key's rotation policy}. This operation requires the {@code keys/rotate} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Rotates a {@link KeyVaultKey key}. Prints out {@link KeyVaultKey rotated key} details.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.rotateKey#String -->
     * <pre>
     * keyAsyncClient.rotateKey&#40;&quot;keyName&quot;&#41;
     *     .subscribe&#40;key -&gt;
     *         System.out.printf&#40;&quot;Rotated key with name: %s and version:%s%n&quot;, key.getName&#40;&#41;,
     *             key.getProperties&#40;&#41;.getVersion&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.rotateKey#String -->
     *
     * @param name The name of {@link KeyVaultKey key} to be rotated. The system will generate a new version in the
     * specified {@link KeyVaultKey key}.
     *
     * @return The new version of the rotated {@link KeyVaultKey key}.
     *
     * @throws IllegalArgumentException If {@code name} is {@code null} or empty.
     * @throws ResourceNotFoundException If the {@link KeyVaultKey key} for the provided {@code name} does not exist.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<KeyVaultKey> rotateKey(String name) {
        return rotateKeyWithResponse(name).flatMap(FluxUtil::toMono);
    }

    /**
     * Rotates a {@link KeyVaultKey key}. The rotate key operation will do so based on
     * {@link KeyRotationPolicy key's rotation policy}. This operation requires the {@code keys/rotate} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Rotates a {@link KeyVaultKey key}. Subscribes to the call asynchronously and prints out the
     * {@link Response HTTP Response} and {@link KeyVaultKey rotated key} details when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.rotateKeyWithResponse#String -->
     * <pre>
     * keyAsyncClient.rotateKeyWithResponse&#40;&quot;keyName&quot;&#41;
     *     .subscribe&#40;rotateKeyResponse -&gt;
     *         System.out.printf&#40;&quot;Response received successfully with status code: %d. Rotated key with name: %s and&quot;
     *                 + &quot;version: %s%n&quot;, rotateKeyResponse.getStatusCode&#40;&#41;, rotateKeyResponse.getValue&#40;&#41;.getName&#40;&#41;,
     *             rotateKeyResponse.getValue&#40;&#41;.getProperties&#40;&#41;.getVersion&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.rotateKeyWithResponse#String -->
     *
     * @param name The name of {@link KeyVaultKey key} to be rotated. The system will generate a new version in the
     * specified {@link KeyVaultKey key}.
     *
     * @return A {@link Mono} containing the {@link Response HTTP response} for this operation and the new version of
     * the rotated {@link KeyVaultKey key}.
     *
     * @throws IllegalArgumentException If {@code name} is {@code null} or empty.
     * @throws ResourceNotFoundException If the {@link KeyVaultKey key} for the provided {@code name} does not exist.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<KeyVaultKey>> rotateKeyWithResponse(String name) {
        try {
            return implClient.rotateKeyWithResponseAsync(name, EMPTY_OPTIONS)
                .map(response -> new SimpleResponse<>(response,
                    createKeyVaultKey(response.getValue().toObject(KeyBundle.class))));
        } catch (RuntimeException e) {
            return monoError(LOGGER, e);
        }
    }

    /**
     * Gets the {@link KeyRotationPolicy} for the {@link KeyVaultKey key} with the provided name. This operation
     * requires the {@code keys/get} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Retrieves the {@link KeyRotationPolicy rotation policy} of a given {@link KeyVaultKey key}. Subscribes to the
     * call asynchronously and prints out the {@link KeyRotationPolicy rotation policy key} details when a response
     * has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.getKeyRotationPolicy#String -->
     * <pre>
     * keyAsyncClient.getKeyRotationPolicy&#40;&quot;keyName&quot;&#41;
     *     .subscribe&#40;keyRotationPolicy -&gt;
     *         System.out.printf&#40;&quot;Retrieved key rotation policy with id: %s%n&quot;, keyRotationPolicy.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.getKeyRotationPolicy#String -->
     *
     * @param keyName The name of the {@link KeyVaultKey key}.
     *
     * @return A {@link Mono} containing the {@link KeyRotationPolicy} for the key.
     *
     * @throws IllegalArgumentException If {@code name} is {@code null} or empty.
     * @throws ResourceNotFoundException If the {@link KeyVaultKey key} for the provided {@code name} does not exist.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<KeyRotationPolicy> getKeyRotationPolicy(String keyName) {
        return getKeyRotationPolicyWithResponse(keyName).flatMap(FluxUtil::toMono);
    }

    /**
     * Gets the {@link KeyRotationPolicy} for the {@link KeyVaultKey key} with the provided name. This operation
     * requires the {@code keys/get} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Retrieves the {@link KeyRotationPolicy rotation policy} of a given {@link KeyVaultKey key}. Subscribes to the
     * call asynchronously and prints out the {@link Response HTTP Response} and
     * {@link KeyRotationPolicy rotation policy key} details when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.getKeyRotationPolicyWithResponse#String -->
     * <pre>
     * keyAsyncClient.getKeyRotationPolicyWithResponse&#40;&quot;keyName&quot;&#41;
     *     .subscribe&#40;getKeyRotationPolicyResponse -&gt;
     *         System.out.printf&#40;&quot;Response received successfully with status code: %d. Retrieved key rotation policy&quot;
     *             + &quot;with id: %s%n&quot;, getKeyRotationPolicyResponse.getStatusCode&#40;&#41;,
     *             getKeyRotationPolicyResponse.getValue&#40;&#41;.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.getKeyRotationPolicyWithResponse#String -->
     *
     * @param keyName The name of the {@link KeyVaultKey key}.
     *
     * @return A {@link Mono} containing the {@link Response HTTP response} for this operation and the
     * {@link KeyRotationPolicy} for the key.
     *
     * @throws IllegalArgumentException If {@code name} is {@code null} or empty.
     * @throws ResourceNotFoundException If the {@link KeyVaultKey key} for the provided {@code name} does not exist.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<KeyRotationPolicy>> getKeyRotationPolicyWithResponse(String keyName) {
        try {
            return implClient.getKeyRotationPolicyWithResponseAsync(keyName, EMPTY_OPTIONS)
                .map(response -> new SimpleResponse<>(response, mapKeyRotationPolicyImpl(response.getValue()
                    .toObject(com.azure.security.keyvault.keys.implementation.models.KeyRotationPolicy.class))));
        } catch (RuntimeException e) {
            return monoError(LOGGER, e);
        }
    }

    /**
     * Updates the {@link KeyRotationPolicy} of the key with the provided name. This operation requires the
     * {@code keys/update} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Updates the {@link KeyRotationPolicy rotation policy} of a given {@link KeyVaultKey key}. Subscribes to the
     * call asynchronously and prints out the {@link KeyRotationPolicy rotation policy key} details when a response
     * has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.updateKeyRotationPolicy#String-KeyRotationPolicy -->
     * <pre>
     * List&lt;KeyRotationLifetimeAction&gt; lifetimeActions = new ArrayList&lt;&gt;&#40;&#41;;
     * KeyRotationLifetimeAction rotateLifetimeAction = new KeyRotationLifetimeAction&#40;KeyRotationPolicyAction.ROTATE&#41;
     *     .setTimeAfterCreate&#40;&quot;P90D&quot;&#41;;
     * KeyRotationLifetimeAction notifyLifetimeAction = new KeyRotationLifetimeAction&#40;KeyRotationPolicyAction.NOTIFY&#41;
     *     .setTimeBeforeExpiry&#40;&quot;P45D&quot;&#41;;
     *
     * lifetimeActions.add&#40;rotateLifetimeAction&#41;;
     * lifetimeActions.add&#40;notifyLifetimeAction&#41;;
     *
     * KeyRotationPolicy keyRotationPolicy = new KeyRotationPolicy&#40;&#41;
     *     .setLifetimeActions&#40;lifetimeActions&#41;
     *     .setExpiresIn&#40;&quot;P6M&quot;&#41;;
     *
     * keyAsyncClient.updateKeyRotationPolicy&#40;&quot;keyName&quot;, keyRotationPolicy&#41;
     *     .subscribe&#40;updatedPolicy -&gt;
     *         System.out.printf&#40;&quot;Updated key rotation policy with id: %s%n&quot;, updatedPolicy.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.updateKeyRotationPolicy#String-KeyRotationPolicy -->
     *
     * @param keyName The name of the {@link KeyVaultKey key}.
     * @param keyRotationPolicy The {@link KeyRotationPolicy} for the key.
     *
     * @return A {@link Mono} containing the {@link KeyRotationPolicy} for the key.
     *
     * @throws IllegalArgumentException If {@code name} is {@code null} or empty.
     * @throws ResourceNotFoundException If the {@link KeyVaultKey key} for the provided {@code name} does not exist.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<KeyRotationPolicy> updateKeyRotationPolicy(String keyName, KeyRotationPolicy keyRotationPolicy) {
        return updateKeyRotationPolicyWithResponse(keyName, keyRotationPolicy).flatMap(FluxUtil::toMono);
    }

    /**
     * Updates the {@link KeyRotationPolicy} of the key with the provided name. This operation requires the
     * {@code keys/update} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Updates the {@link KeyRotationPolicy rotation policy} of a given {@link KeyVaultKey key}. Subscribes to the
     * call asynchronously and prints out the {@link Response HTTP Response} and
     * {@link KeyRotationPolicy rotation policy key} details when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.updateKeyRotationPolicyWithResponse#String-KeyRotationPolicy -->
     * <pre>
     * List&lt;KeyRotationLifetimeAction&gt; myLifetimeActions = new ArrayList&lt;&gt;&#40;&#41;;
     * KeyRotationLifetimeAction myRotateLifetimeAction = new KeyRotationLifetimeAction&#40;KeyRotationPolicyAction.ROTATE&#41;
     *     .setTimeAfterCreate&#40;&quot;P90D&quot;&#41;;
     * KeyRotationLifetimeAction myNotifyLifetimeAction = new KeyRotationLifetimeAction&#40;KeyRotationPolicyAction.NOTIFY&#41;
     *     .setTimeBeforeExpiry&#40;&quot;P45D&quot;&#41;;
     *
     * myLifetimeActions.add&#40;myRotateLifetimeAction&#41;;
     * myLifetimeActions.add&#40;myNotifyLifetimeAction&#41;;
     *
     * KeyRotationPolicy myKeyRotationPolicy = new KeyRotationPolicy&#40;&#41;
     *     .setLifetimeActions&#40;myLifetimeActions&#41;
     *     .setExpiresIn&#40;&quot;P6M&quot;&#41;;
     *
     * keyAsyncClient.updateKeyRotationPolicyWithResponse&#40;&quot;keyName&quot;, myKeyRotationPolicy&#41;
     *     .subscribe&#40;myUpdatedPolicyResponse -&gt;
     *         System.out.printf&#40;&quot;Response received successfully with status code: %d. Updated key rotation policy&quot;
     *             + &quot;with id: %s%n&quot;, myUpdatedPolicyResponse.getStatusCode&#40;&#41;,
     *             myUpdatedPolicyResponse.getValue&#40;&#41;.getId&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.updateKeyRotationPolicyWithResponse#String-KeyRotationPolicy -->
     *
     * @param keyName The name of the {@link KeyVaultKey key}.
     * @param keyRotationPolicy The {@link KeyRotationPolicy} for the key.
     *
     * @return A {@link Mono} containing the {@link Response HTTP response} for this operation and the
     * {@link KeyRotationPolicy} for the key.
     *
     * @throws IllegalArgumentException If {@code name} is {@code null} or empty.
     * @throws ResourceNotFoundException If the {@link KeyVaultKey key} for the provided {@code name} does not exist.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<KeyRotationPolicy>> updateKeyRotationPolicyWithResponse(String keyName,
        KeyRotationPolicy keyRotationPolicy) {
        try {

            return implClient
                .updateKeyRotationPolicyWithResponseAsync(keyName,
                    BinaryData.fromObject(mapKeyRotationPolicy(keyRotationPolicy)), EMPTY_OPTIONS)
                .map(response -> new SimpleResponse<>(response, mapKeyRotationPolicyImpl(response.getValue()
                    .toObject(com.azure.security.keyvault.keys.implementation.models.KeyRotationPolicy.class))));
        } catch (RuntimeException e) {
            return monoError(LOGGER, e);
        }
    }

    /**
     * Gets the public part of the latest version of the specified {@link KeyVaultKey key}, including its attestation
     * information. The get key operation is applicable to all {@link KeyType key types} and it requires the
     * {@code keys/get} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Gets the latest version of the {@link KeyVaultKey key} in the key vault, including its attestation
     * information. Subscribes to the call asynchronously and prints out the {@link KeyVaultKey retrieved key} details
     * when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.getKeyAttestation#String -->
     * <pre>
     * keyAsyncClient.getKeyAttestation&#40;&quot;keyName&quot;&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;key -&gt; &#123;
     *         System.out.printf&#40;&quot;Created key with name: %s and: id %s%n&quot;, key.getName&#40;&#41;, key.getId&#40;&#41;&#41;;
     *
     *         KeyAttestation keyAttestationInfo = key.getProperties&#40;&#41;.getKeyAttestation&#40;&#41;;
     *
     *         System.out.printf&#40;&quot;Attestation information details: %n&quot;
     *                 + &quot;Certificate PEM file: %s%n&quot;
     *                 + &quot;Private key attestation: %s%n&quot;
     *                 + &quot;Public key attestation: %s%n&quot;
     *                 + &quot;Version: %s&quot;,
     *             Base64Url.encode&#40;keyAttestationInfo.getCertificatePemFile&#40;&#41;&#41;,
     *             Base64Url.encode&#40;keyAttestationInfo.getPrivateKeyAttestation&#40;&#41;&#41;,
     *             Base64Url.encode&#40;keyAttestationInfo.getPublicKeyAttestation&#40;&#41;&#41;,
     *             keyAttestationInfo.getVersion&#40;&#41;&#41;;
     *     &#125;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.getKeyAttestation#String -->
     *
     * @param name The name of the {@link KeyVaultKey key}, cannot be {@code null}.
     *
     * @return A {@link Mono} containing the requested {@link KeyVaultKey key}. The content of the key is {@code null}
     * if {@code name} is {@code null} or empty.
     *
     * @throws HttpResponseException If a valid {@code name} and a non-null/empty {@code version} is specified.
     * @throws ResourceNotFoundException When a {@link KeyVaultKey key} with the provided {@code name} doesn't exist in
     * the key vault or an empty/{@code null} {@code name} and a non-null/empty {@code version} is provided.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<KeyVaultKey> getKeyAttestation(String name) {
        return getKeyAttestationWithResponse(name, null).flatMap(FluxUtil::toMono);
    }

    /**
     * Gets the public part of the specified {@link KeyVaultKey key} and key version, including its attestation
     * information. The get key operation is applicable to all {@link KeyType key types} and it requires the
     * {@code keys/get} permission.
     *
     * <p><strong>Code Samples</strong></p>
     * <p>Gets the latest version of the {@link KeyVaultKey key} in the key vault, including its attestation
     * information. Subscribes to the call asynchronously and prints out the {@link KeyVaultKey retrieved key} details
     * when a response has been received.</p>
     * <!-- src_embed com.azure.security.keyvault.keys.KeyAsyncClient.getKeyAttestationWithResponse#String-String -->
     * <pre>
     * String keyVersion = &quot;&lt;key-version&gt;&quot;;
     *
     * keyAsyncClient.getKeyAttestationWithResponse&#40;&quot;keyName&quot;, keyVersion&#41;
     *     .contextWrite&#40;Context.of&#40;&quot;key1&quot;, &quot;value1&quot;, &quot;key2&quot;, &quot;value2&quot;&#41;&#41;
     *     .subscribe&#40;getKeyResponse -&gt; &#123;
     *         KeyVaultKey keyVaultKey = getKeyResponse.getValue&#40;&#41;;
     *
     *         System.out.printf&#40;&quot;Created key with name: %s and: id %s%n&quot;, getKeyResponse.getValue&#40;&#41;.getName&#40;&#41;,
     *             getKeyResponse.getValue&#40;&#41;.getId&#40;&#41;&#41;;
     *
     *         KeyAttestation keyAttestationInfo = keyVaultKey.getProperties&#40;&#41;.getKeyAttestation&#40;&#41;;
     *
     *         System.out.printf&#40;&quot;Attestation information details: %n&quot;
     *                 + &quot;Certificate PEM file: %s%n&quot;
     *                 + &quot;Private key attestation: %s%n&quot;
     *                 + &quot;Public key attestation: %s%n&quot;
     *                 + &quot;Version: %s&quot;,
     *             Base64Url.encode&#40;keyAttestationInfo.getCertificatePemFile&#40;&#41;&#41;,
     *             Base64Url.encode&#40;keyAttestationInfo.getPrivateKeyAttestation&#40;&#41;&#41;,
     *             Base64Url.encode&#40;keyAttestationInfo.getPublicKeyAttestation&#40;&#41;&#41;,
     *             keyAttestationInfo.getVersion&#40;&#41;&#41;;
     *     &#125;&#41;;
     * </pre>
     * <!-- end com.azure.security.keyvault.keys.KeyAsyncClient.getKeyAttestationWithResponse#String-String -->
     *
     * @param name The name of the {@link KeyVaultKey key}, cannot be {@code null}.
     * @param version The version of the key to retrieve. If this is an empty String or null, this call is
     * equivalent to calling {@link KeyAsyncClient#getKey(String)}, with the latest version being retrieved.
     *
     * @return A {@link Mono} containing a {@link Response} whose {@link Response#getValue() value} contains the
     * requested {@link KeyVaultKey key}. The content of the key is {@code null} if both {@code name} and
     * {@code version} are {@code null} or empty.
     *
     * @throws HttpResponseException If a valid {@code name} and a non-null/empty {@code version} is specified.
     * @throws ResourceNotFoundException When a {@link KeyVaultKey key} with the provided {@code name} doesn't exist in
     * the key vault or an empty/{@code null} {@code name} and a non-null/empty {@code version} is provided.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<KeyVaultKey>> getKeyAttestationWithResponse(String name, String version) {
        try {
            return implClient.getKeyAttestationWithResponseAsync(name, version, EMPTY_OPTIONS)
                .onErrorMap(HttpResponseException.class, KeyAsyncClient::mapGetKeyException)
                .map(response -> new SimpleResponse<>(response,
                    createKeyVaultKey(response.getValue().toObject(KeyBundle.class))));
        } catch (RuntimeException e) {
            return monoError(LOGGER, e);
        }
    }
}
