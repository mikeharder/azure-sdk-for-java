// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.implementation;

import com.azure.cosmos.CosmosException;

/**
 * While this class is public, but it is not part of our published public APIs.
 * This is meant to be internally used only by our sdk.
 */
public class Exceptions {

    public static boolean isStatusCode(CosmosException e, int status) {
        return status == e.getStatusCode();
    }

    public static boolean isSubStatusCode(CosmosException e, int subStatus) {
        return subStatus == e.getSubStatusCode();
    }

    public static boolean isGone(CosmosException e) {
        return isStatusCode(e, HttpConstants.StatusCodes.GONE);
    }

    public static boolean isConflict(CosmosException e) {
        return isStatusCode(e, HttpConstants.StatusCodes.CONFLICT);
    }

    public static boolean isNotFound(CosmosException e) {
        return isStatusCode(e, HttpConstants.StatusCodes.NOTFOUND);
    }

    public static boolean isPartitionSplitOrMerge(CosmosException e) {
        return isStatusCode(e, HttpConstants.StatusCodes.GONE)
                && isSubStatusCode(e, HttpConstants.SubStatusCodes.PARTITION_KEY_RANGE_GONE);
    }

    public static boolean isNameCacheStale(CosmosException e) {
        return isStatusCode(e, HttpConstants.StatusCodes.GONE)
                && isSubStatusCode(e, HttpConstants.SubStatusCodes.NAME_CACHE_IS_STALE);
    }

    public static boolean isThroughputControlRequestRateTooLargeException(CosmosException e) {
        return isStatusCode(e, HttpConstants.StatusCodes.TOO_MANY_REQUESTS)
            && isSubStatusCode(e, HttpConstants.SubStatusCodes.THROUGHPUT_CONTROL_REQUEST_RATE_TOO_LARGE);
    }

    public static boolean isPartitionCompletingSplittingException(CosmosException cosmosException) {
        return Exceptions.isStatusCode(cosmosException, HttpConstants.StatusCodes.GONE) &&
            Exceptions.isSubStatusCode(cosmosException, HttpConstants.SubStatusCodes.COMPLETING_SPLIT_OR_MERGE);
    }

    public static boolean isPartitionKeyMismatchException(CosmosException cosmosException) {
        return Exceptions.isStatusCode(cosmosException, HttpConstants.StatusCodes.NOTFOUND) &&
            Exceptions.isSubStatusCode(cosmosException, HttpConstants.SubStatusCodes.PARTITION_KEY_MISMATCH);
    }

    public static String getInternalServerErrorMessage(String prefix) {
        return prefix + " - " + RMResources.InternalServerError;
    }

    public static boolean isStaledResourceException(int statusCode, int subStatusCode) {
        return (statusCode == HttpConstants.StatusCodes.BADREQUEST
                    && subStatusCode == HttpConstants.SubStatusCodes.INCORRECT_CONTAINER_RID_SUB_STATUS)
            || (statusCode == HttpConstants.StatusCodes.GONE
                    && subStatusCode == HttpConstants.SubStatusCodes.NAME_CACHE_IS_STALE);
    }
}
