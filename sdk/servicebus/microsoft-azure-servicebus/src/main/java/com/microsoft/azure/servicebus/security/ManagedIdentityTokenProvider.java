// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.microsoft.azure.servicebus.security;

import java.io.IOException;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microsoft.azure.credentials.MSICredentials;
import com.microsoft.azure.servicebus.primitives.MessagingFactory;

/**
 * This is a token provider that obtains token using Managed Identity(MI). This token provider automatically detects MI settings.
 * @since 1.2.0
 *
 */
public class ManagedIdentityTokenProvider extends TokenProvider {
    private static final Logger TRACE_LOGGER = LoggerFactory.getLogger(ManagedIdentityTokenProvider.class);
    private static final MSICredentials CREDENTIALS = new MSICredentials();

    @Override
    public CompletableFuture<SecurityToken> getSecurityTokenAsync(String audience) {
        CompletableFuture<SecurityToken> tokenGeneratingFuture = new CompletableFuture<>();
        MessagingFactory.INTERNAL_THREAD_POOL.execute(() -> {
            try {
                String rawToken = CREDENTIALS.getToken(SecurityConstants.SERVICEBUS_AAD_AUDIENCE_RESOURCE_URL);
                Date expiry = SecurityToken.getExpirationDateTimeUtcFromToken(rawToken);
                tokenGeneratingFuture.complete(new SecurityToken(SecurityTokenType.JWT, audience, rawToken, Instant.now(), expiry.toInstant()));
            } catch (IOException e) {
                TRACE_LOGGER.info("ManagedIdentity token generation failed.", e);
                tokenGeneratingFuture.completeExceptionally(e);
            } catch (ParseException e) {
                TRACE_LOGGER.info("Could not parse the expiry time from the Managed Identity token string.", e);
                tokenGeneratingFuture.completeExceptionally(e);
            }
        });
        
        return tokenGeneratingFuture;
    }
}
