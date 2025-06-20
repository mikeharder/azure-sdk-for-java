// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.spark.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The SparkBatchJobOptions model.
 */
@Fluent
public final class SparkBatchJobOptions implements JsonSerializable<SparkBatchJobOptions> {
    /*
     * Dictionary of <string>
     */
    @Generated
    private Map<String, String> tags;

    /*
     * The artifactId property.
     */
    @Generated
    private String artifactId;

    /*
     * The name property.
     */
    @Generated
    private String name;

    /*
     * The file property.
     */
    @Generated
    private String file;

    /*
     * The className property.
     */
    @Generated
    private String className;

    /*
     * The args property.
     */
    @Generated
    private List<String> arguments;

    /*
     * The jars property.
     */
    @Generated
    private List<String> jars;

    /*
     * The pyFiles property.
     */
    @Generated
    private List<String> pythonFiles;

    /*
     * The files property.
     */
    @Generated
    private List<String> files;

    /*
     * The archives property.
     */
    @Generated
    private List<String> archives;

    /*
     * Dictionary of <string>
     */
    @Generated
    private Map<String, String> configuration;

    /*
     * The driverMemory property.
     */
    @Generated
    private String driverMemory;

    /*
     * The driverCores property.
     */
    @Generated
    private Integer driverCores;

    /*
     * The executorMemory property.
     */
    @Generated
    private String executorMemory;

    /*
     * The executorCores property.
     */
    @Generated
    private Integer executorCores;

    /*
     * The numExecutors property.
     */
    @Generated
    private Integer executorCount;

    /**
     * Creates an instance of SparkBatchJobOptions class.
     */
    @Generated
    public SparkBatchJobOptions() {
    }

    /**
     * Get the tags property: Dictionary of &lt;string&gt;.
     * 
     * @return the tags value.
     */
    @Generated
    public Map<String, String> getTags() {
        return this.tags;
    }

    /**
     * Set the tags property: Dictionary of &lt;string&gt;.
     * 
     * @param tags the tags value to set.
     * @return the SparkBatchJobOptions object itself.
     */
    @Generated
    public SparkBatchJobOptions setTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get the artifactId property: The artifactId property.
     * 
     * @return the artifactId value.
     */
    @Generated
    public String getArtifactId() {
        return this.artifactId;
    }

    /**
     * Set the artifactId property: The artifactId property.
     * 
     * @param artifactId the artifactId value to set.
     * @return the SparkBatchJobOptions object itself.
     */
    @Generated
    public SparkBatchJobOptions setArtifactId(String artifactId) {
        this.artifactId = artifactId;
        return this;
    }

    /**
     * Get the name property: The name property.
     * 
     * @return the name value.
     */
    @Generated
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: The name property.
     * 
     * @param name the name value to set.
     * @return the SparkBatchJobOptions object itself.
     */
    @Generated
    public SparkBatchJobOptions setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the file property: The file property.
     * 
     * @return the file value.
     */
    @Generated
    public String getFile() {
        return this.file;
    }

    /**
     * Set the file property: The file property.
     * 
     * @param file the file value to set.
     * @return the SparkBatchJobOptions object itself.
     */
    @Generated
    public SparkBatchJobOptions setFile(String file) {
        this.file = file;
        return this;
    }

    /**
     * Get the className property: The className property.
     * 
     * @return the className value.
     */
    @Generated
    public String getClassName() {
        return this.className;
    }

    /**
     * Set the className property: The className property.
     * 
     * @param className the className value to set.
     * @return the SparkBatchJobOptions object itself.
     */
    @Generated
    public SparkBatchJobOptions setClassName(String className) {
        this.className = className;
        return this;
    }

    /**
     * Get the arguments property: The args property.
     * 
     * @return the arguments value.
     */
    @Generated
    public List<String> getArguments() {
        return this.arguments;
    }

    /**
     * Set the arguments property: The args property.
     * 
     * @param arguments the arguments value to set.
     * @return the SparkBatchJobOptions object itself.
     */
    @Generated
    public SparkBatchJobOptions setArguments(List<String> arguments) {
        this.arguments = arguments;
        return this;
    }

    /**
     * Get the jars property: The jars property.
     * 
     * @return the jars value.
     */
    @Generated
    public List<String> getJars() {
        return this.jars;
    }

    /**
     * Set the jars property: The jars property.
     * 
     * @param jars the jars value to set.
     * @return the SparkBatchJobOptions object itself.
     */
    @Generated
    public SparkBatchJobOptions setJars(List<String> jars) {
        this.jars = jars;
        return this;
    }

    /**
     * Get the pythonFiles property: The pyFiles property.
     * 
     * @return the pythonFiles value.
     */
    @Generated
    public List<String> getPythonFiles() {
        return this.pythonFiles;
    }

    /**
     * Set the pythonFiles property: The pyFiles property.
     * 
     * @param pythonFiles the pythonFiles value to set.
     * @return the SparkBatchJobOptions object itself.
     */
    @Generated
    public SparkBatchJobOptions setPythonFiles(List<String> pythonFiles) {
        this.pythonFiles = pythonFiles;
        return this;
    }

    /**
     * Get the files property: The files property.
     * 
     * @return the files value.
     */
    @Generated
    public List<String> getFiles() {
        return this.files;
    }

    /**
     * Set the files property: The files property.
     * 
     * @param files the files value to set.
     * @return the SparkBatchJobOptions object itself.
     */
    @Generated
    public SparkBatchJobOptions setFiles(List<String> files) {
        this.files = files;
        return this;
    }

    /**
     * Get the archives property: The archives property.
     * 
     * @return the archives value.
     */
    @Generated
    public List<String> getArchives() {
        return this.archives;
    }

    /**
     * Set the archives property: The archives property.
     * 
     * @param archives the archives value to set.
     * @return the SparkBatchJobOptions object itself.
     */
    @Generated
    public SparkBatchJobOptions setArchives(List<String> archives) {
        this.archives = archives;
        return this;
    }

    /**
     * Get the configuration property: Dictionary of &lt;string&gt;.
     * 
     * @return the configuration value.
     */
    @Generated
    public Map<String, String> getConfiguration() {
        return this.configuration;
    }

    /**
     * Set the configuration property: Dictionary of &lt;string&gt;.
     * 
     * @param configuration the configuration value to set.
     * @return the SparkBatchJobOptions object itself.
     */
    @Generated
    public SparkBatchJobOptions setConfiguration(Map<String, String> configuration) {
        this.configuration = configuration;
        return this;
    }

    /**
     * Get the driverMemory property: The driverMemory property.
     * 
     * @return the driverMemory value.
     */
    @Generated
    public String getDriverMemory() {
        return this.driverMemory;
    }

    /**
     * Set the driverMemory property: The driverMemory property.
     * 
     * @param driverMemory the driverMemory value to set.
     * @return the SparkBatchJobOptions object itself.
     */
    @Generated
    public SparkBatchJobOptions setDriverMemory(String driverMemory) {
        this.driverMemory = driverMemory;
        return this;
    }

    /**
     * Get the driverCores property: The driverCores property.
     * 
     * @return the driverCores value.
     */
    @Generated
    public Integer getDriverCores() {
        return this.driverCores;
    }

    /**
     * Set the driverCores property: The driverCores property.
     * 
     * @param driverCores the driverCores value to set.
     * @return the SparkBatchJobOptions object itself.
     */
    @Generated
    public SparkBatchJobOptions setDriverCores(Integer driverCores) {
        this.driverCores = driverCores;
        return this;
    }

    /**
     * Get the executorMemory property: The executorMemory property.
     * 
     * @return the executorMemory value.
     */
    @Generated
    public String getExecutorMemory() {
        return this.executorMemory;
    }

    /**
     * Set the executorMemory property: The executorMemory property.
     * 
     * @param executorMemory the executorMemory value to set.
     * @return the SparkBatchJobOptions object itself.
     */
    @Generated
    public SparkBatchJobOptions setExecutorMemory(String executorMemory) {
        this.executorMemory = executorMemory;
        return this;
    }

    /**
     * Get the executorCores property: The executorCores property.
     * 
     * @return the executorCores value.
     */
    @Generated
    public Integer getExecutorCores() {
        return this.executorCores;
    }

    /**
     * Set the executorCores property: The executorCores property.
     * 
     * @param executorCores the executorCores value to set.
     * @return the SparkBatchJobOptions object itself.
     */
    @Generated
    public SparkBatchJobOptions setExecutorCores(Integer executorCores) {
        this.executorCores = executorCores;
        return this;
    }

    /**
     * Get the executorCount property: The numExecutors property.
     * 
     * @return the executorCount value.
     */
    @Generated
    public Integer getExecutorCount() {
        return this.executorCount;
    }

    /**
     * Set the executorCount property: The numExecutors property.
     * 
     * @param executorCount the executorCount value to set.
     * @return the SparkBatchJobOptions object itself.
     */
    @Generated
    public SparkBatchJobOptions setExecutorCount(Integer executorCount) {
        this.executorCount = executorCount;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("file", this.file);
        jsonWriter.writeMapField("tags", this.tags, (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("artifactId", this.artifactId);
        jsonWriter.writeStringField("className", this.className);
        jsonWriter.writeArrayField("args", this.arguments, (writer, element) -> writer.writeString(element));
        jsonWriter.writeArrayField("jars", this.jars, (writer, element) -> writer.writeString(element));
        jsonWriter.writeArrayField("pyFiles", this.pythonFiles, (writer, element) -> writer.writeString(element));
        jsonWriter.writeArrayField("files", this.files, (writer, element) -> writer.writeString(element));
        jsonWriter.writeArrayField("archives", this.archives, (writer, element) -> writer.writeString(element));
        jsonWriter.writeMapField("conf", this.configuration, (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("driverMemory", this.driverMemory);
        jsonWriter.writeNumberField("driverCores", this.driverCores);
        jsonWriter.writeStringField("executorMemory", this.executorMemory);
        jsonWriter.writeNumberField("executorCores", this.executorCores);
        jsonWriter.writeNumberField("numExecutors", this.executorCount);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SparkBatchJobOptions from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SparkBatchJobOptions if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SparkBatchJobOptions.
     */
    @Generated
    public static SparkBatchJobOptions fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SparkBatchJobOptions deserializedSparkBatchJobOptions = new SparkBatchJobOptions();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedSparkBatchJobOptions.name = reader.getString();
                } else if ("file".equals(fieldName)) {
                    deserializedSparkBatchJobOptions.file = reader.getString();
                } else if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedSparkBatchJobOptions.tags = tags;
                } else if ("artifactId".equals(fieldName)) {
                    deserializedSparkBatchJobOptions.artifactId = reader.getString();
                } else if ("className".equals(fieldName)) {
                    deserializedSparkBatchJobOptions.className = reader.getString();
                } else if ("args".equals(fieldName)) {
                    List<String> arguments = reader.readArray(reader1 -> reader1.getString());
                    deserializedSparkBatchJobOptions.arguments = arguments;
                } else if ("jars".equals(fieldName)) {
                    List<String> jars = reader.readArray(reader1 -> reader1.getString());
                    deserializedSparkBatchJobOptions.jars = jars;
                } else if ("pyFiles".equals(fieldName)) {
                    List<String> pythonFiles = reader.readArray(reader1 -> reader1.getString());
                    deserializedSparkBatchJobOptions.pythonFiles = pythonFiles;
                } else if ("files".equals(fieldName)) {
                    List<String> files = reader.readArray(reader1 -> reader1.getString());
                    deserializedSparkBatchJobOptions.files = files;
                } else if ("archives".equals(fieldName)) {
                    List<String> archives = reader.readArray(reader1 -> reader1.getString());
                    deserializedSparkBatchJobOptions.archives = archives;
                } else if ("conf".equals(fieldName)) {
                    Map<String, String> configuration = reader.readMap(reader1 -> reader1.getString());
                    deserializedSparkBatchJobOptions.configuration = configuration;
                } else if ("driverMemory".equals(fieldName)) {
                    deserializedSparkBatchJobOptions.driverMemory = reader.getString();
                } else if ("driverCores".equals(fieldName)) {
                    deserializedSparkBatchJobOptions.driverCores = reader.getNullable(JsonReader::getInt);
                } else if ("executorMemory".equals(fieldName)) {
                    deserializedSparkBatchJobOptions.executorMemory = reader.getString();
                } else if ("executorCores".equals(fieldName)) {
                    deserializedSparkBatchJobOptions.executorCores = reader.getNullable(JsonReader::getInt);
                } else if ("numExecutors".equals(fieldName)) {
                    deserializedSparkBatchJobOptions.executorCount = reader.getNullable(JsonReader::getInt);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSparkBatchJobOptions;
        });
    }
}
