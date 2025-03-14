// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.implementation.query;

import com.azure.cosmos.implementation.RequestTimeline;
import com.azure.cosmos.implementation.query.hybridsearch.HybridSearchQueryInfo;
import com.azure.cosmos.implementation.routing.Range;
import com.azure.cosmos.implementation.JsonSerializable;
import com.azure.cosmos.implementation.Constants;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

/**
 * Used internally to encapsulates execution information for a query in the Azure Cosmos DB database service.
 */
public final class PartitionedQueryExecutionInfo extends JsonSerializable {
    @SuppressWarnings("unchecked")
    private static final Class<Range<String>> QUERY_RANGES_CLASS = (Class<Range<String>>) Range
            .getEmptyRange((String) null).getClass();

    private QueryInfo queryInfo;
    private List<Range<String>> queryRanges;
    private RequestTimeline queryPlanRequestTimeline;
    private HybridSearchQueryInfo hybridSearchQueryInfo;

    PartitionedQueryExecutionInfo(QueryInfo queryInfo, List<Range<String>> queryRanges) {
        this.queryInfo = queryInfo;
        this.queryRanges = queryRanges;

        this.set(
            PartitionedQueryExecutionInfoInternal.PARTITIONED_QUERY_EXECUTION_INFO_VERSION_PROPERTY,
            Constants.PartitionedQueryExecutionInfo.VERSION_1
        );
    }

    public PartitionedQueryExecutionInfo(ObjectNode content, RequestTimeline queryPlanRequestTimeline) {
        super(content);
        this.queryPlanRequestTimeline = queryPlanRequestTimeline;
    }

    public PartitionedQueryExecutionInfo(String jsonString) {
        super(jsonString);
    }

    public int getVersion() {
        return super.getInt(PartitionedQueryExecutionInfoInternal.PARTITIONED_QUERY_EXECUTION_INFO_VERSION_PROPERTY);
    }

    public QueryInfo getQueryInfo() {
        return this.queryInfo != null ? this.queryInfo
                : (this.queryInfo = super.getObject(
                        PartitionedQueryExecutionInfoInternal.QUERY_INFO_PROPERTY, QueryInfo.class));
    }

    public List<Range<String>> getQueryRanges() {
        return this.queryRanges != null ? this.queryRanges
                : (this.queryRanges = super.getList(
                        PartitionedQueryExecutionInfoInternal.QUERY_RANGES_PROPERTY, QUERY_RANGES_CLASS));
    }

    public RequestTimeline getQueryPlanRequestTimeline() {
        return queryPlanRequestTimeline;
    }

    public boolean hasHybridSearchQueryInfo() {
        getHybridSearchQueryInfo();
        return hybridSearchQueryInfo != null;
    }

    public HybridSearchQueryInfo getHybridSearchQueryInfo() {
        if (hybridSearchQueryInfo == null) {
            hybridSearchQueryInfo = super.getObject(
                PartitionedQueryExecutionInfoInternal.HYBRID_SEARCH_QUERY_INFO_PROPERTY, HybridSearchQueryInfo.class);
        }

        return this.hybridSearchQueryInfo;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
