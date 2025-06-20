// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.metricsadvisor.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * The MongoDBDataFeedPatch model.
 */
@Fluent
public final class MongoDBDataFeedPatch extends DataFeedDetailPatch {
    /*
     * data source type
     */
    @Generated
    private DataSourceType dataSourceType = DataSourceType.MONGO_DB;

    /*
     * The dataSourceParameter property.
     */
    @Generated
    private MongoDBParameterPatch dataSourceParameter;

    /**
     * Creates an instance of MongoDBDataFeedPatch class.
     */
    @Generated
    public MongoDBDataFeedPatch() {
    }

    /**
     * Get the dataSourceType property: data source type.
     * 
     * @return the dataSourceType value.
     */
    @Generated
    @Override
    public DataSourceType getDataSourceType() {
        return this.dataSourceType;
    }

    /**
     * Get the dataSourceParameter property: The dataSourceParameter property.
     * 
     * @return the dataSourceParameter value.
     */
    @Generated
    public MongoDBParameterPatch getDataSourceParameter() {
        return this.dataSourceParameter;
    }

    /**
     * Set the dataSourceParameter property: The dataSourceParameter property.
     * 
     * @param dataSourceParameter the dataSourceParameter value to set.
     * @return the MongoDBDataFeedPatch object itself.
     */
    @Generated
    public MongoDBDataFeedPatch setDataSourceParameter(MongoDBParameterPatch dataSourceParameter) {
        this.dataSourceParameter = dataSourceParameter;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setDataFeedName(String dataFeedName) {
        super.setDataFeedName(dataFeedName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setDataFeedDescription(String dataFeedDescription) {
        super.setDataFeedDescription(dataFeedDescription);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setTimestampColumn(String timestampColumn) {
        super.setTimestampColumn(timestampColumn);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setDataStartFrom(OffsetDateTime dataStartFrom) {
        super.setDataStartFrom(dataStartFrom);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setStartOffsetInSeconds(Long startOffsetInSeconds) {
        super.setStartOffsetInSeconds(startOffsetInSeconds);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setMaxConcurrency(Integer maxConcurrency) {
        super.setMaxConcurrency(maxConcurrency);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setMinRetryIntervalInSeconds(Long minRetryIntervalInSeconds) {
        super.setMinRetryIntervalInSeconds(minRetryIntervalInSeconds);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setStopRetryAfterInSeconds(Long stopRetryAfterInSeconds) {
        super.setStopRetryAfterInSeconds(stopRetryAfterInSeconds);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setNeedRollup(NeedRollupEnum needRollup) {
        super.setNeedRollup(needRollup);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setRollUpMethod(RollUpMethod rollUpMethod) {
        super.setRollUpMethod(rollUpMethod);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setRollUpColumns(List<String> rollUpColumns) {
        super.setRollUpColumns(rollUpColumns);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setAllUpIdentification(String allUpIdentification) {
        super.setAllUpIdentification(allUpIdentification);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setFillMissingPointType(FillMissingPointType fillMissingPointType) {
        super.setFillMissingPointType(fillMissingPointType);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setFillMissingPointValue(Double fillMissingPointValue) {
        super.setFillMissingPointValue(fillMissingPointValue);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setViewMode(ViewMode viewMode) {
        super.setViewMode(viewMode);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setAdmins(List<String> admins) {
        super.setAdmins(admins);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setViewers(List<String> viewers) {
        super.setViewers(viewers);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setStatus(EntityStatus status) {
        super.setStatus(status);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setActionLinkTemplate(String actionLinkTemplate) {
        super.setActionLinkTemplate(actionLinkTemplate);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setAuthenticationType(AuthenticationTypeEnum authenticationType) {
        super.setAuthenticationType(authenticationType);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MongoDBDataFeedPatch setCredentialId(String credentialId) {
        super.setCredentialId(credentialId);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("dataFeedName", getDataFeedName());
        jsonWriter.writeStringField("dataFeedDescription", getDataFeedDescription());
        jsonWriter.writeStringField("timestampColumn", getTimestampColumn());
        jsonWriter.writeStringField("dataStartFrom",
            getDataStartFrom() == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(getDataStartFrom()));
        jsonWriter.writeNumberField("startOffsetInSeconds", getStartOffsetInSeconds());
        jsonWriter.writeNumberField("maxConcurrency", getMaxConcurrency());
        jsonWriter.writeNumberField("minRetryIntervalInSeconds", getMinRetryIntervalInSeconds());
        jsonWriter.writeNumberField("stopRetryAfterInSeconds", getStopRetryAfterInSeconds());
        jsonWriter.writeStringField("needRollup", getNeedRollup() == null ? null : getNeedRollup().toString());
        jsonWriter.writeStringField("rollUpMethod", getRollUpMethod() == null ? null : getRollUpMethod().toString());
        jsonWriter.writeArrayField("rollUpColumns", getRollUpColumns(),
            (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("allUpIdentification", getAllUpIdentification());
        jsonWriter.writeStringField("fillMissingPointType",
            getFillMissingPointType() == null ? null : getFillMissingPointType().toString());
        jsonWriter.writeNumberField("fillMissingPointValue", getFillMissingPointValue());
        jsonWriter.writeStringField("viewMode", getViewMode() == null ? null : getViewMode().toString());
        jsonWriter.writeArrayField("admins", getAdmins(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeArrayField("viewers", getViewers(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("status", getStatus() == null ? null : getStatus().toString());
        jsonWriter.writeStringField("actionLinkTemplate", getActionLinkTemplate());
        jsonWriter.writeStringField("authenticationType",
            getAuthenticationType() == null ? null : getAuthenticationType().toString());
        jsonWriter.writeStringField("credentialId", getCredentialId());
        jsonWriter.writeStringField("dataSourceType",
            this.dataSourceType == null ? null : this.dataSourceType.toString());
        jsonWriter.writeJsonField("dataSourceParameter", this.dataSourceParameter);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MongoDBDataFeedPatch from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MongoDBDataFeedPatch if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the MongoDBDataFeedPatch.
     */
    @Generated
    public static MongoDBDataFeedPatch fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MongoDBDataFeedPatch deserializedMongoDBDataFeedPatch = new MongoDBDataFeedPatch();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("dataFeedName".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch.setDataFeedName(reader.getString());
                } else if ("dataFeedDescription".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch.setDataFeedDescription(reader.getString());
                } else if ("timestampColumn".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch.setTimestampColumn(reader.getString());
                } else if ("dataStartFrom".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch.setDataStartFrom(reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString())));
                } else if ("startOffsetInSeconds".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch.setStartOffsetInSeconds(reader.getNullable(JsonReader::getLong));
                } else if ("maxConcurrency".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch.setMaxConcurrency(reader.getNullable(JsonReader::getInt));
                } else if ("minRetryIntervalInSeconds".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch
                        .setMinRetryIntervalInSeconds(reader.getNullable(JsonReader::getLong));
                } else if ("stopRetryAfterInSeconds".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch
                        .setStopRetryAfterInSeconds(reader.getNullable(JsonReader::getLong));
                } else if ("needRollup".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch.setNeedRollup(NeedRollupEnum.fromString(reader.getString()));
                } else if ("rollUpMethod".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch.setRollUpMethod(RollUpMethod.fromString(reader.getString()));
                } else if ("rollUpColumns".equals(fieldName)) {
                    List<String> rollUpColumns = reader.readArray(reader1 -> reader1.getString());
                    deserializedMongoDBDataFeedPatch.setRollUpColumns(rollUpColumns);
                } else if ("allUpIdentification".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch.setAllUpIdentification(reader.getString());
                } else if ("fillMissingPointType".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch
                        .setFillMissingPointType(FillMissingPointType.fromString(reader.getString()));
                } else if ("fillMissingPointValue".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch
                        .setFillMissingPointValue(reader.getNullable(JsonReader::getDouble));
                } else if ("viewMode".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch.setViewMode(ViewMode.fromString(reader.getString()));
                } else if ("admins".equals(fieldName)) {
                    List<String> admins = reader.readArray(reader1 -> reader1.getString());
                    deserializedMongoDBDataFeedPatch.setAdmins(admins);
                } else if ("viewers".equals(fieldName)) {
                    List<String> viewers = reader.readArray(reader1 -> reader1.getString());
                    deserializedMongoDBDataFeedPatch.setViewers(viewers);
                } else if ("status".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch.setStatus(EntityStatus.fromString(reader.getString()));
                } else if ("actionLinkTemplate".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch.setActionLinkTemplate(reader.getString());
                } else if ("authenticationType".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch
                        .setAuthenticationType(AuthenticationTypeEnum.fromString(reader.getString()));
                } else if ("credentialId".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch.setCredentialId(reader.getString());
                } else if ("dataSourceType".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch.dataSourceType = DataSourceType.fromString(reader.getString());
                } else if ("dataSourceParameter".equals(fieldName)) {
                    deserializedMongoDBDataFeedPatch.dataSourceParameter = MongoDBParameterPatch.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedMongoDBDataFeedPatch;
        });
    }
}
