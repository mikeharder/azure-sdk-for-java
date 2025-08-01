// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.implementation.directconnectivity;

import com.azure.cosmos.BridgeInternal;
import com.azure.cosmos.CosmosException;
import com.azure.cosmos.implementation.GoneException;
import com.azure.cosmos.implementation.HttpConstants;
import com.azure.cosmos.implementation.IRetryPolicy;
import com.azure.cosmos.implementation.ImplementationBridgeHelpers;
import com.azure.cosmos.implementation.InvalidPartitionException;
import com.azure.cosmos.implementation.LeaseNotFoundException;
import com.azure.cosmos.implementation.PartitionIsMigratingException;
import com.azure.cosmos.implementation.PartitionKeyRangeGoneException;
import com.azure.cosmos.implementation.PartitionKeyRangeIsSplittingException;
import com.azure.cosmos.implementation.Quadruple;
import com.azure.cosmos.implementation.RetryContext;
import com.azure.cosmos.implementation.RetryWithException;
import com.azure.cosmos.implementation.RxDocumentServiceRequest;
import com.azure.cosmos.implementation.ShouldRetryResult;
import com.azure.cosmos.implementation.Utils;
import com.azure.cosmos.implementation.apachecommons.lang.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import static com.azure.cosmos.implementation.guava25.base.Preconditions.checkNotNull;

public class GoneAndRetryWithRetryPolicy implements IRetryPolicy {

    private final static Logger logger = LoggerFactory.getLogger(GoneAndRetryWithRetryPolicy.class);
    private final GoneRetryPolicy goneRetryPolicy;
    private final RetryWithRetryPolicy retryWithRetryPolicy;
    private final Instant start;
    private volatile Instant end;

    private volatile RetryWithException lastRetryWithException;
    private RetryContext retryContext;
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    private static final ImplementationBridgeHelpers.CosmosExceptionHelper.CosmosExceptionAccessor cosmosExceptionsAccessor
        = ImplementationBridgeHelpers.CosmosExceptionHelper.getCosmosExceptionAccessor();

    public GoneAndRetryWithRetryPolicy(RxDocumentServiceRequest request, Integer waitTimeInSeconds) {
        this.retryContext = BridgeInternal.getRetryContext(request.requestContext.cosmosDiagnostics);
        this.goneRetryPolicy = new GoneRetryPolicy(
            request,
            waitTimeInSeconds,
            this.retryContext
        );
        this.retryWithRetryPolicy = new RetryWithRetryPolicy(waitTimeInSeconds, this.retryContext);
        this.start = Instant.now();
    }

    @Override
    public Mono<ShouldRetryResult> shouldRetry(Exception exception) {

        return this.retryWithRetryPolicy.shouldRetry(exception)
                                        .flatMap((retryWithResult) -> {
            if (!retryWithResult.nonRelatedException) {
                return Mono.just(retryWithResult);
            }

            // only pass request to gone retry policy if retryWithRetryPolicy can not handle the exception.
            return this.goneRetryPolicy.shouldRetry(exception)
                .flatMap((goneRetryResult) -> {
                    if (!goneRetryResult.shouldRetry) {
                        logger.debug("Operation will NOT be retried. Exception:",
                            exception);
                        this.end = Instant.now();
                    }

                    return Mono.just(goneRetryResult);
                });
        });
    }

    @Override
    public RetryContext getRetryContext() {
        return this.retryContext;
    }

    private Duration getElapsedTime() {
        Instant endSnapshot = this.end != null ? this.end : Instant.now();

        return Duration.between(this.start, endSnapshot);
    }

    class GoneRetryPolicy implements IRetryPolicy {
        private final static int DEFAULT_WAIT_TIME_IN_SECONDS = 30;
        private final static int MAXIMUM_BACKOFF_TIME_IN_SECONDS = 15;
        private final static int INITIAL_BACKOFF_TIME = 1;
        private final static int BACK_OFF_MULTIPLIER = 2;

        private final RxDocumentServiceRequest request;
        private final AtomicInteger attemptCount = new AtomicInteger(1);
        private final AtomicInteger currentBackoffSeconds = new AtomicInteger(GoneRetryPolicy.INITIAL_BACKOFF_TIME);
        private final int waitTimeInSeconds;
        private RetryContext retryContext;

        public GoneRetryPolicy(
            RxDocumentServiceRequest request,
            Integer waitTimeInSeconds,
            RetryContext retryContext) {

            checkNotNull(request, "request must not be null.");
            this.request = request;
            this.waitTimeInSeconds = waitTimeInSeconds != null ? waitTimeInSeconds : DEFAULT_WAIT_TIME_IN_SECONDS;
            this.retryContext = retryContext;
        }

        private boolean isNonRetryableException(Exception exception) {
            if (exception instanceof GoneException ||
                exception instanceof PartitionIsMigratingException ||
                exception instanceof PartitionKeyRangeIsSplittingException ||
                exception instanceof LeaseNotFoundException) {

                return false;
            }

            return true;
        }

        private CosmosException logAndWrapExceptionWithLastRetryWithException(Exception exception) {
            String exceptionType;
            if (exception instanceof GoneException) {
                exceptionType = "GoneException";
            } else if (exception instanceof PartitionKeyRangeGoneException) {
                exceptionType = "PartitionKeyRangeGoneException";
            } else if (exception instanceof  InvalidPartitionException) {
                exceptionType = "InvalidPartitionException";
            } else if (exception instanceof  PartitionKeyRangeIsSplittingException) {
                exceptionType = "PartitionKeyRangeIsSplittingException";
            } else if (exception instanceof CosmosException) {
                logger.warn("Received CosmosException after backoff/retry. Will fail the request.",
                    exception);

                return (CosmosException)exception;
            } else {
                throw new IllegalStateException("Invalid exception type", exception);
            }

            RetryWithException lastRetryWithExceptionSnapshot =
                GoneAndRetryWithRetryPolicy.this.lastRetryWithException;
            if (lastRetryWithExceptionSnapshot != null) {
                logger.warn(
                    "Received {} after backoff/retry including at least one RetryWithException. "
                        + "Will fail the request with RetryWithException. {}: {}. RetryWithException: {}",
                    exceptionType,
                    exceptionType,
                    exception,
                    lastRetryWithExceptionSnapshot);

                return lastRetryWithExceptionSnapshot;
            }

            logger.warn(
                "Received {} after backoff/retry. Will fail the request. {}",
                exceptionType,
                exception);
            int subStatusCode = getExceptionSubStatusCodeForGoneRetryPolicy(exception);
            return BridgeInternal.createServiceUnavailableException(exception, subStatusCode);
        }

        private int getExceptionSubStatusCodeForGoneRetryPolicy(Exception exception) {
            int exceptionSubStatusCode = HttpConstants.SubStatusCodes.UNKNOWN;

            if (exception instanceof CosmosException) {
                if (exception instanceof PartitionKeyRangeIsSplittingException) {
                    exceptionSubStatusCode = HttpConstants.SubStatusCodes.COMPLETING_SPLIT_EXCEEDED_RETRY_LIMIT;
                } else if (exception instanceof PartitionIsMigratingException) {
                    exceptionSubStatusCode = HttpConstants.SubStatusCodes.COMPLETING_PARTITION_MIGRATION_EXCEEDED_RETRY_LIMIT;
                } else if (exception instanceof InvalidPartitionException) {
                    exceptionSubStatusCode = HttpConstants.SubStatusCodes.NAME_CACHE_IS_STALE_EXCEEDED_RETRY_LIMIT;
                } else if (exception instanceof PartitionKeyRangeGoneException) {
                    exceptionSubStatusCode = HttpConstants.SubStatusCodes.PARTITION_KEY_RANGE_GONE_EXCEEDED_RETRY_LIMIT;
                } else {
                    exceptionSubStatusCode = ((CosmosException) exception).getSubStatusCode();
                }
            }
            return exceptionSubStatusCode;
        }

        @Override
        public Mono<ShouldRetryResult> shouldRetry(Exception exception) {
            CosmosException exceptionToThrow;
            Duration backoffTime = Duration.ofSeconds(0);
            Duration timeout;
            boolean forceRefreshAddressCache;
            if (isNonRetryableException(exception)) {
                logger.debug("Operation will NOT be retried. Current attempt {}, Exception: ", this.attemptCount,
                    exception);
                return Mono.just(ShouldRetryResult.noRetryOnNonRelatedException());
            } else if (exception instanceof GoneException &&
                !request.isReadOnly() &&
                BridgeInternal.hasSendingRequestStarted((CosmosException)exception) &&
                !((GoneException)exception).isBasedOn410ResponseFromService() &&
                !this.request.getNonIdempotentWriteRetriesEnabled()) {

                logger.warn(
                    "Operation will NOT be retried. Write operations which failed due to transient transport errors " +
                        "can not be retried safely when sending the request " +
                        "to the service because they aren't idempotent. Current attempt {}, Exception: ",
                    this.attemptCount,
                    exception);

                // wrapping this is as a 408 doesn't affect retry semantics in ClientRetryPolicy layer for writes
                // this will also allow PPAF to mark such a partitionKeyRange as unavailable for that region
                exceptionToThrow = cosmosExceptionsAccessor.createCosmosException(HttpConstants.StatusCodes.REQUEST_TIMEOUT, exception);

                GoneException goneException = Utils.as(exception, GoneException.class);
                BridgeInternal.setSubStatusCode(exceptionToThrow, goneException.getSubStatusCode());

                return Mono.just(ShouldRetryResult.noRetry(exceptionToThrow,
                    Quadruple.with(true, true, Duration.ofMillis(0), this.attemptCount.get())));
            } else if (exception instanceof LeaseNotFoundException) {

                exceptionToThrow = cosmosExceptionsAccessor.createCosmosException(HttpConstants.StatusCodes.SERVICE_UNAVAILABLE, exception);
                LeaseNotFoundException leaseNotFoundException = Utils.as(exception, LeaseNotFoundException.class);

                BridgeInternal.setSubStatusCode(exceptionToThrow, leaseNotFoundException.getSubStatusCode());

                logger.warn("Operation will NOT be retried in the local region. LeaseNotFoundException, Current attempt {}, Exception: ",
                    this.attemptCount,
                    exception);

                return Mono.just(ShouldRetryResult.noRetry(exceptionToThrow,
                    Quadruple.with(true, false, Duration.ofMillis(0), this.attemptCount.get())));
            }

            long remainingSeconds = this.waitTimeInSeconds -
                GoneAndRetryWithRetryPolicy.this.getElapsedTime().toMillis() / 1_000L;
            int currentRetryAttemptCount = this.attemptCount.get();
            if (this.attemptCount.getAndIncrement() > 1) {
                if (remainingSeconds <= 0) {
                    exceptionToThrow = logAndWrapExceptionWithLastRetryWithException(exception);
                    return Mono.just(ShouldRetryResult.error(exceptionToThrow));
                }

                backoffTime = Duration.ofSeconds(Math.min(Math.min(this.currentBackoffSeconds.get(), remainingSeconds),
                    GoneRetryPolicy.MAXIMUM_BACKOFF_TIME_IN_SECONDS));
                this.currentBackoffSeconds.accumulateAndGet(GoneRetryPolicy.BACK_OFF_MULTIPLIER, (left, right) -> left * right);
                logger.debug("BackoffTime: {} seconds.", backoffTime.getSeconds());
            }

            // Calculate the remaining time based after accounting for the backoff that we
            // will perform
            long timeoutInMillSec = remainingSeconds*1000 - backoffTime.toMillis();
            timeout = timeoutInMillSec > 0 ? Duration.ofMillis(timeoutInMillSec)
                : Duration.ofSeconds(GoneRetryPolicy.MAXIMUM_BACKOFF_TIME_IN_SECONDS);
            logger.debug("Timeout. {} - BackoffTime {} - currentBackoffSeconds {} - CurrentRetryAttemptCount {}",
                timeout.toMillis(),
                backoffTime,
                this.currentBackoffSeconds,
                currentRetryAttemptCount);

            Pair<Mono<ShouldRetryResult>, Boolean> exceptionHandlingResult = handleException(exception);
            Mono<ShouldRetryResult> result = exceptionHandlingResult.getLeft();
            if (result != null) {
                return result;
            }

            forceRefreshAddressCache = exceptionHandlingResult.getRight();

            return Mono.just(ShouldRetryResult.retryAfter(backoffTime,
                Quadruple.with(forceRefreshAddressCache, true, timeout, currentRetryAttemptCount)));
        }

        @Override
        public RetryContext getRetryContext() {
            return this.retryContext;
        }

        private Pair<Mono<ShouldRetryResult>, Boolean> handleException(Exception exception) {
            if (exception instanceof GoneException) {
                return handleGoneException((GoneException)exception);
            } else if (exception instanceof PartitionIsMigratingException) {
                return handlePartitionIsMigratingException((PartitionIsMigratingException)exception);
            } else if (exception instanceof PartitionKeyRangeIsSplittingException) {
                return handlePartitionKeyIsSplittingException((PartitionKeyRangeIsSplittingException) exception);
            }

            throw new IllegalStateException("Invalid exception type", exception);
        }

        private Pair<Mono<ShouldRetryResult>, Boolean> handleGoneException(GoneException exception) {
            logger.debug("Received gone exception, will retry, {}", exception.toString());
            return Pair.of(null, true); // indicate we are in retry.
        }

        private Pair<Mono<ShouldRetryResult>, Boolean> handlePartitionIsMigratingException(PartitionIsMigratingException exception) {
            logger.debug("Received PartitionIsMigratingException, will retry, {}", exception.toString());
            this.request.forceCollectionRoutingMapRefresh = true;
            return Pair.of(null, true);
        }

        private Pair<Mono<ShouldRetryResult>, Boolean> handlePartitionKeyIsSplittingException(PartitionKeyRangeIsSplittingException exception) {
            this.request.requestContext.resolvedPartitionKeyRange = null;
            this.request.requestContext.quorumSelectedLSN = -1;
            this.request.requestContext.quorumSelectedStoreResponse = null;
            logger.debug("Received partition key range splitting exception, will retry, {}", exception.toString());
            this.request.forcePartitionKeyRangeRefresh = true;
            return Pair.of(null, false);
        }
    }

    class RetryWithRetryPolicy implements IRetryPolicy {
        private final static int DEFAULT_WAIT_TIME_IN_SECONDS = 30;
        private final static int MAXIMUM_BACKOFF_TIME_IN_MS = 1000;
        private final static int INITIAL_BACKOFF_TIME_MS = 10;
        private final static int BACK_OFF_MULTIPLIER = 2;
        private final static int RANDOM_SALT_IN_MS = 5;

        private final AtomicInteger attemptCount = new AtomicInteger(1);
        private final AtomicInteger currentBackoffMilliseconds = new AtomicInteger(RetryWithRetryPolicy.INITIAL_BACKOFF_TIME_MS);

        private final int waitTimeInSeconds;
        private final RetryContext retryContext;


        public RetryWithRetryPolicy(Integer waitTimeInSeconds, RetryContext retryContext) {
            this.waitTimeInSeconds = waitTimeInSeconds != null ? waitTimeInSeconds : DEFAULT_WAIT_TIME_IN_SECONDS;
            this.retryContext = retryContext;
        }

        @Override
        public Mono<ShouldRetryResult> shouldRetry(Exception exception) {
            Duration backoffTime;
            Duration timeout;

            if (!(exception instanceof RetryWithException)) {
                logger.debug("Operation will NOT be retried. Current attempt {}, Exception: ", this.attemptCount.get(),
                    exception);
                return Mono.just(ShouldRetryResult.noRetryOnNonRelatedException());
            }

            RetryWithException lastRetryWithException = (RetryWithException)exception;
            GoneAndRetryWithRetryPolicy.this.lastRetryWithException = lastRetryWithException;

            long remainingMilliseconds =
                (this.waitTimeInSeconds * 1_000L) -
                    GoneAndRetryWithRetryPolicy.this.getElapsedTime().toMillis();
            int currentRetryAttemptCount = this.attemptCount.getAndIncrement();

            if (remainingMilliseconds <= 0) {
                logger.warn("Received RetryWithException after backoff/retry. Will fail the request.",
                    lastRetryWithException);
                return Mono.just(ShouldRetryResult.error(lastRetryWithException));
            }

            backoffTime = Duration.ofMillis(
                Math.min(
                    Math.min(this.currentBackoffMilliseconds.get() + random.nextInt(RANDOM_SALT_IN_MS), remainingMilliseconds),
                    RetryWithRetryPolicy.MAXIMUM_BACKOFF_TIME_IN_MS));

            this.currentBackoffMilliseconds.set(
                Math.max(
                    RetryWithRetryPolicy.INITIAL_BACKOFF_TIME_MS,
                    Math.min(
                        RetryWithRetryPolicy.MAXIMUM_BACKOFF_TIME_IN_MS,
                        this.currentBackoffMilliseconds.get() * RetryWithRetryPolicy.BACK_OFF_MULTIPLIER))
            );

            logger.debug("BackoffTime: {} ms.", backoffTime.toMillis());

            // Calculate the remaining time based after accounting for the backoff that we
            // will perform
            long timeoutInMillSec = remainingMilliseconds - backoffTime.toMillis();
            timeout = timeoutInMillSec > 0 ? Duration.ofMillis(timeoutInMillSec)
                : Duration.ofMillis(RetryWithRetryPolicy.MAXIMUM_BACKOFF_TIME_IN_MS);

            logger.debug("Received RetryWithException, will retry, ", exception);

            // For RetryWithException, prevent the caller
            // from refreshing any caches.
            return Mono.just(ShouldRetryResult.retryAfter(backoffTime,
                Quadruple.with(false, true, timeout, currentRetryAttemptCount)));
        }

        @Override
        public RetryContext getRetryContext() {
            return this.retryContext;
        }
    }
}
