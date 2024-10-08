// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * ProcessInfo resource specific properties.
 */
@Fluent
public final class ProcessInfoProperties implements JsonSerializable<ProcessInfoProperties> {
    /*
     * ARM Identifier for deployment.
     */
    private Integer identifier;

    /*
     * Deployment name.
     */
    private String deploymentName;

    /*
     * HRef URI.
     */
    private String href;

    /*
     * Minidump URI.
     */
    private String minidump;

    /*
     * Is profile running?
     */
    private Boolean isProfileRunning;

    /*
     * Is the IIS Profile running?
     */
    private Boolean isIisProfileRunning;

    /*
     * IIS Profile timeout (seconds).
     */
    private Double iisProfileTimeoutInSeconds;

    /*
     * Parent process.
     */
    private String parent;

    /*
     * Child process list.
     */
    private List<String> children;

    /*
     * Thread list.
     */
    private List<ProcessThreadInfoInner> threads;

    /*
     * List of open files.
     */
    private List<String> openFileHandles;

    /*
     * List of modules.
     */
    private List<ProcessModuleInfoInner> modules;

    /*
     * File name of this process.
     */
    private String fileName;

    /*
     * Command line.
     */
    private String commandLine;

    /*
     * User name.
     */
    private String username;

    /*
     * Handle count.
     */
    private Integer handleCount;

    /*
     * Module count.
     */
    private Integer moduleCount;

    /*
     * Thread count.
     */
    private Integer threadCount;

    /*
     * Start time.
     */
    private OffsetDateTime startTime;

    /*
     * Total CPU time.
     */
    private String totalCpuTime;

    /*
     * User CPU time.
     */
    private String userCpuTime;

    /*
     * Privileged CPU time.
     */
    private String privilegedCpuTime;

    /*
     * Working set.
     */
    private Long workingSet;

    /*
     * Peak working set.
     */
    private Long peakWorkingSet;

    /*
     * Private memory size.
     */
    private Long privateMemory;

    /*
     * Virtual memory size.
     */
    private Long virtualMemory;

    /*
     * Peak virtual memory usage.
     */
    private Long peakVirtualMemory;

    /*
     * Paged system memory.
     */
    private Long pagedSystemMemory;

    /*
     * Non-paged system memory.
     */
    private Long nonPagedSystemMemory;

    /*
     * Paged memory.
     */
    private Long pagedMemory;

    /*
     * Peak paged memory.
     */
    private Long peakPagedMemory;

    /*
     * Time stamp.
     */
    private OffsetDateTime timestamp;

    /*
     * List of environment variables.
     */
    private Map<String, String> environmentVariables;

    /*
     * Is this the SCM site?
     */
    private Boolean isScmSite;

    /*
     * Is this a Web Job?
     */
    private Boolean isWebjob;

    /*
     * Description of process.
     */
    private String description;

    /**
     * Creates an instance of ProcessInfoProperties class.
     */
    public ProcessInfoProperties() {
    }

    /**
     * Get the identifier property: ARM Identifier for deployment.
     * 
     * @return the identifier value.
     */
    public Integer identifier() {
        return this.identifier;
    }

    /**
     * Get the deploymentName property: Deployment name.
     * 
     * @return the deploymentName value.
     */
    public String deploymentName() {
        return this.deploymentName;
    }

    /**
     * Set the deploymentName property: Deployment name.
     * 
     * @param deploymentName the deploymentName value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withDeploymentName(String deploymentName) {
        this.deploymentName = deploymentName;
        return this;
    }

    /**
     * Get the href property: HRef URI.
     * 
     * @return the href value.
     */
    public String href() {
        return this.href;
    }

    /**
     * Set the href property: HRef URI.
     * 
     * @param href the href value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withHref(String href) {
        this.href = href;
        return this;
    }

    /**
     * Get the minidump property: Minidump URI.
     * 
     * @return the minidump value.
     */
    public String minidump() {
        return this.minidump;
    }

    /**
     * Set the minidump property: Minidump URI.
     * 
     * @param minidump the minidump value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withMinidump(String minidump) {
        this.minidump = minidump;
        return this;
    }

    /**
     * Get the isProfileRunning property: Is profile running?.
     * 
     * @return the isProfileRunning value.
     */
    public Boolean isProfileRunning() {
        return this.isProfileRunning;
    }

    /**
     * Set the isProfileRunning property: Is profile running?.
     * 
     * @param isProfileRunning the isProfileRunning value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withIsProfileRunning(Boolean isProfileRunning) {
        this.isProfileRunning = isProfileRunning;
        return this;
    }

    /**
     * Get the isIisProfileRunning property: Is the IIS Profile running?.
     * 
     * @return the isIisProfileRunning value.
     */
    public Boolean isIisProfileRunning() {
        return this.isIisProfileRunning;
    }

    /**
     * Set the isIisProfileRunning property: Is the IIS Profile running?.
     * 
     * @param isIisProfileRunning the isIisProfileRunning value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withIsIisProfileRunning(Boolean isIisProfileRunning) {
        this.isIisProfileRunning = isIisProfileRunning;
        return this;
    }

    /**
     * Get the iisProfileTimeoutInSeconds property: IIS Profile timeout (seconds).
     * 
     * @return the iisProfileTimeoutInSeconds value.
     */
    public Double iisProfileTimeoutInSeconds() {
        return this.iisProfileTimeoutInSeconds;
    }

    /**
     * Set the iisProfileTimeoutInSeconds property: IIS Profile timeout (seconds).
     * 
     * @param iisProfileTimeoutInSeconds the iisProfileTimeoutInSeconds value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withIisProfileTimeoutInSeconds(Double iisProfileTimeoutInSeconds) {
        this.iisProfileTimeoutInSeconds = iisProfileTimeoutInSeconds;
        return this;
    }

    /**
     * Get the parent property: Parent process.
     * 
     * @return the parent value.
     */
    public String parent() {
        return this.parent;
    }

    /**
     * Set the parent property: Parent process.
     * 
     * @param parent the parent value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withParent(String parent) {
        this.parent = parent;
        return this;
    }

    /**
     * Get the children property: Child process list.
     * 
     * @return the children value.
     */
    public List<String> children() {
        return this.children;
    }

    /**
     * Set the children property: Child process list.
     * 
     * @param children the children value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withChildren(List<String> children) {
        this.children = children;
        return this;
    }

    /**
     * Get the threads property: Thread list.
     * 
     * @return the threads value.
     */
    public List<ProcessThreadInfoInner> threads() {
        return this.threads;
    }

    /**
     * Set the threads property: Thread list.
     * 
     * @param threads the threads value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withThreads(List<ProcessThreadInfoInner> threads) {
        this.threads = threads;
        return this;
    }

    /**
     * Get the openFileHandles property: List of open files.
     * 
     * @return the openFileHandles value.
     */
    public List<String> openFileHandles() {
        return this.openFileHandles;
    }

    /**
     * Set the openFileHandles property: List of open files.
     * 
     * @param openFileHandles the openFileHandles value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withOpenFileHandles(List<String> openFileHandles) {
        this.openFileHandles = openFileHandles;
        return this;
    }

    /**
     * Get the modules property: List of modules.
     * 
     * @return the modules value.
     */
    public List<ProcessModuleInfoInner> modules() {
        return this.modules;
    }

    /**
     * Set the modules property: List of modules.
     * 
     * @param modules the modules value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withModules(List<ProcessModuleInfoInner> modules) {
        this.modules = modules;
        return this;
    }

    /**
     * Get the fileName property: File name of this process.
     * 
     * @return the fileName value.
     */
    public String fileName() {
        return this.fileName;
    }

    /**
     * Set the fileName property: File name of this process.
     * 
     * @param fileName the fileName value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    /**
     * Get the commandLine property: Command line.
     * 
     * @return the commandLine value.
     */
    public String commandLine() {
        return this.commandLine;
    }

    /**
     * Set the commandLine property: Command line.
     * 
     * @param commandLine the commandLine value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withCommandLine(String commandLine) {
        this.commandLine = commandLine;
        return this;
    }

    /**
     * Get the username property: User name.
     * 
     * @return the username value.
     */
    public String username() {
        return this.username;
    }

    /**
     * Set the username property: User name.
     * 
     * @param username the username value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * Get the handleCount property: Handle count.
     * 
     * @return the handleCount value.
     */
    public Integer handleCount() {
        return this.handleCount;
    }

    /**
     * Set the handleCount property: Handle count.
     * 
     * @param handleCount the handleCount value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withHandleCount(Integer handleCount) {
        this.handleCount = handleCount;
        return this;
    }

    /**
     * Get the moduleCount property: Module count.
     * 
     * @return the moduleCount value.
     */
    public Integer moduleCount() {
        return this.moduleCount;
    }

    /**
     * Set the moduleCount property: Module count.
     * 
     * @param moduleCount the moduleCount value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withModuleCount(Integer moduleCount) {
        this.moduleCount = moduleCount;
        return this;
    }

    /**
     * Get the threadCount property: Thread count.
     * 
     * @return the threadCount value.
     */
    public Integer threadCount() {
        return this.threadCount;
    }

    /**
     * Set the threadCount property: Thread count.
     * 
     * @param threadCount the threadCount value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withThreadCount(Integer threadCount) {
        this.threadCount = threadCount;
        return this;
    }

    /**
     * Get the startTime property: Start time.
     * 
     * @return the startTime value.
     */
    public OffsetDateTime startTime() {
        return this.startTime;
    }

    /**
     * Set the startTime property: Start time.
     * 
     * @param startTime the startTime value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Get the totalCpuTime property: Total CPU time.
     * 
     * @return the totalCpuTime value.
     */
    public String totalCpuTime() {
        return this.totalCpuTime;
    }

    /**
     * Set the totalCpuTime property: Total CPU time.
     * 
     * @param totalCpuTime the totalCpuTime value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withTotalCpuTime(String totalCpuTime) {
        this.totalCpuTime = totalCpuTime;
        return this;
    }

    /**
     * Get the userCpuTime property: User CPU time.
     * 
     * @return the userCpuTime value.
     */
    public String userCpuTime() {
        return this.userCpuTime;
    }

    /**
     * Set the userCpuTime property: User CPU time.
     * 
     * @param userCpuTime the userCpuTime value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withUserCpuTime(String userCpuTime) {
        this.userCpuTime = userCpuTime;
        return this;
    }

    /**
     * Get the privilegedCpuTime property: Privileged CPU time.
     * 
     * @return the privilegedCpuTime value.
     */
    public String privilegedCpuTime() {
        return this.privilegedCpuTime;
    }

    /**
     * Set the privilegedCpuTime property: Privileged CPU time.
     * 
     * @param privilegedCpuTime the privilegedCpuTime value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withPrivilegedCpuTime(String privilegedCpuTime) {
        this.privilegedCpuTime = privilegedCpuTime;
        return this;
    }

    /**
     * Get the workingSet property: Working set.
     * 
     * @return the workingSet value.
     */
    public Long workingSet() {
        return this.workingSet;
    }

    /**
     * Set the workingSet property: Working set.
     * 
     * @param workingSet the workingSet value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withWorkingSet(Long workingSet) {
        this.workingSet = workingSet;
        return this;
    }

    /**
     * Get the peakWorkingSet property: Peak working set.
     * 
     * @return the peakWorkingSet value.
     */
    public Long peakWorkingSet() {
        return this.peakWorkingSet;
    }

    /**
     * Set the peakWorkingSet property: Peak working set.
     * 
     * @param peakWorkingSet the peakWorkingSet value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withPeakWorkingSet(Long peakWorkingSet) {
        this.peakWorkingSet = peakWorkingSet;
        return this;
    }

    /**
     * Get the privateMemory property: Private memory size.
     * 
     * @return the privateMemory value.
     */
    public Long privateMemory() {
        return this.privateMemory;
    }

    /**
     * Set the privateMemory property: Private memory size.
     * 
     * @param privateMemory the privateMemory value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withPrivateMemory(Long privateMemory) {
        this.privateMemory = privateMemory;
        return this;
    }

    /**
     * Get the virtualMemory property: Virtual memory size.
     * 
     * @return the virtualMemory value.
     */
    public Long virtualMemory() {
        return this.virtualMemory;
    }

    /**
     * Set the virtualMemory property: Virtual memory size.
     * 
     * @param virtualMemory the virtualMemory value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withVirtualMemory(Long virtualMemory) {
        this.virtualMemory = virtualMemory;
        return this;
    }

    /**
     * Get the peakVirtualMemory property: Peak virtual memory usage.
     * 
     * @return the peakVirtualMemory value.
     */
    public Long peakVirtualMemory() {
        return this.peakVirtualMemory;
    }

    /**
     * Set the peakVirtualMemory property: Peak virtual memory usage.
     * 
     * @param peakVirtualMemory the peakVirtualMemory value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withPeakVirtualMemory(Long peakVirtualMemory) {
        this.peakVirtualMemory = peakVirtualMemory;
        return this;
    }

    /**
     * Get the pagedSystemMemory property: Paged system memory.
     * 
     * @return the pagedSystemMemory value.
     */
    public Long pagedSystemMemory() {
        return this.pagedSystemMemory;
    }

    /**
     * Set the pagedSystemMemory property: Paged system memory.
     * 
     * @param pagedSystemMemory the pagedSystemMemory value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withPagedSystemMemory(Long pagedSystemMemory) {
        this.pagedSystemMemory = pagedSystemMemory;
        return this;
    }

    /**
     * Get the nonPagedSystemMemory property: Non-paged system memory.
     * 
     * @return the nonPagedSystemMemory value.
     */
    public Long nonPagedSystemMemory() {
        return this.nonPagedSystemMemory;
    }

    /**
     * Set the nonPagedSystemMemory property: Non-paged system memory.
     * 
     * @param nonPagedSystemMemory the nonPagedSystemMemory value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withNonPagedSystemMemory(Long nonPagedSystemMemory) {
        this.nonPagedSystemMemory = nonPagedSystemMemory;
        return this;
    }

    /**
     * Get the pagedMemory property: Paged memory.
     * 
     * @return the pagedMemory value.
     */
    public Long pagedMemory() {
        return this.pagedMemory;
    }

    /**
     * Set the pagedMemory property: Paged memory.
     * 
     * @param pagedMemory the pagedMemory value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withPagedMemory(Long pagedMemory) {
        this.pagedMemory = pagedMemory;
        return this;
    }

    /**
     * Get the peakPagedMemory property: Peak paged memory.
     * 
     * @return the peakPagedMemory value.
     */
    public Long peakPagedMemory() {
        return this.peakPagedMemory;
    }

    /**
     * Set the peakPagedMemory property: Peak paged memory.
     * 
     * @param peakPagedMemory the peakPagedMemory value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withPeakPagedMemory(Long peakPagedMemory) {
        this.peakPagedMemory = peakPagedMemory;
        return this;
    }

    /**
     * Get the timestamp property: Time stamp.
     * 
     * @return the timestamp value.
     */
    public OffsetDateTime timestamp() {
        return this.timestamp;
    }

    /**
     * Set the timestamp property: Time stamp.
     * 
     * @param timestamp the timestamp value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Get the environmentVariables property: List of environment variables.
     * 
     * @return the environmentVariables value.
     */
    public Map<String, String> environmentVariables() {
        return this.environmentVariables;
    }

    /**
     * Set the environmentVariables property: List of environment variables.
     * 
     * @param environmentVariables the environmentVariables value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withEnvironmentVariables(Map<String, String> environmentVariables) {
        this.environmentVariables = environmentVariables;
        return this;
    }

    /**
     * Get the isScmSite property: Is this the SCM site?.
     * 
     * @return the isScmSite value.
     */
    public Boolean isScmSite() {
        return this.isScmSite;
    }

    /**
     * Set the isScmSite property: Is this the SCM site?.
     * 
     * @param isScmSite the isScmSite value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withIsScmSite(Boolean isScmSite) {
        this.isScmSite = isScmSite;
        return this;
    }

    /**
     * Get the isWebjob property: Is this a Web Job?.
     * 
     * @return the isWebjob value.
     */
    public Boolean isWebjob() {
        return this.isWebjob;
    }

    /**
     * Set the isWebjob property: Is this a Web Job?.
     * 
     * @param isWebjob the isWebjob value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withIsWebjob(Boolean isWebjob) {
        this.isWebjob = isWebjob;
        return this;
    }

    /**
     * Get the description property: Description of process.
     * 
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: Description of process.
     * 
     * @param description the description value to set.
     * @return the ProcessInfoProperties object itself.
     */
    public ProcessInfoProperties withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (threads() != null) {
            threads().forEach(e -> e.validate());
        }
        if (modules() != null) {
            modules().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("deployment_name", this.deploymentName);
        jsonWriter.writeStringField("href", this.href);
        jsonWriter.writeStringField("minidump", this.minidump);
        jsonWriter.writeBooleanField("is_profile_running", this.isProfileRunning);
        jsonWriter.writeBooleanField("is_iis_profile_running", this.isIisProfileRunning);
        jsonWriter.writeNumberField("iis_profile_timeout_in_seconds", this.iisProfileTimeoutInSeconds);
        jsonWriter.writeStringField("parent", this.parent);
        jsonWriter.writeArrayField("children", this.children, (writer, element) -> writer.writeString(element));
        jsonWriter.writeArrayField("threads", this.threads, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("open_file_handles", this.openFileHandles,
            (writer, element) -> writer.writeString(element));
        jsonWriter.writeArrayField("modules", this.modules, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("file_name", this.fileName);
        jsonWriter.writeStringField("command_line", this.commandLine);
        jsonWriter.writeStringField("user_name", this.username);
        jsonWriter.writeNumberField("handle_count", this.handleCount);
        jsonWriter.writeNumberField("module_count", this.moduleCount);
        jsonWriter.writeNumberField("thread_count", this.threadCount);
        jsonWriter.writeStringField("start_time",
            this.startTime == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.startTime));
        jsonWriter.writeStringField("total_cpu_time", this.totalCpuTime);
        jsonWriter.writeStringField("user_cpu_time", this.userCpuTime);
        jsonWriter.writeStringField("privileged_cpu_time", this.privilegedCpuTime);
        jsonWriter.writeNumberField("working_set", this.workingSet);
        jsonWriter.writeNumberField("peak_working_set", this.peakWorkingSet);
        jsonWriter.writeNumberField("private_memory", this.privateMemory);
        jsonWriter.writeNumberField("virtual_memory", this.virtualMemory);
        jsonWriter.writeNumberField("peak_virtual_memory", this.peakVirtualMemory);
        jsonWriter.writeNumberField("paged_system_memory", this.pagedSystemMemory);
        jsonWriter.writeNumberField("non_paged_system_memory", this.nonPagedSystemMemory);
        jsonWriter.writeNumberField("paged_memory", this.pagedMemory);
        jsonWriter.writeNumberField("peak_paged_memory", this.peakPagedMemory);
        jsonWriter.writeStringField("time_stamp",
            this.timestamp == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.timestamp));
        jsonWriter.writeMapField("environment_variables", this.environmentVariables,
            (writer, element) -> writer.writeString(element));
        jsonWriter.writeBooleanField("is_scm_site", this.isScmSite);
        jsonWriter.writeBooleanField("is_webjob", this.isWebjob);
        jsonWriter.writeStringField("description", this.description);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ProcessInfoProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ProcessInfoProperties if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ProcessInfoProperties.
     */
    public static ProcessInfoProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ProcessInfoProperties deserializedProcessInfoProperties = new ProcessInfoProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("identifier".equals(fieldName)) {
                    deserializedProcessInfoProperties.identifier = reader.getNullable(JsonReader::getInt);
                } else if ("deployment_name".equals(fieldName)) {
                    deserializedProcessInfoProperties.deploymentName = reader.getString();
                } else if ("href".equals(fieldName)) {
                    deserializedProcessInfoProperties.href = reader.getString();
                } else if ("minidump".equals(fieldName)) {
                    deserializedProcessInfoProperties.minidump = reader.getString();
                } else if ("is_profile_running".equals(fieldName)) {
                    deserializedProcessInfoProperties.isProfileRunning = reader.getNullable(JsonReader::getBoolean);
                } else if ("is_iis_profile_running".equals(fieldName)) {
                    deserializedProcessInfoProperties.isIisProfileRunning = reader.getNullable(JsonReader::getBoolean);
                } else if ("iis_profile_timeout_in_seconds".equals(fieldName)) {
                    deserializedProcessInfoProperties.iisProfileTimeoutInSeconds
                        = reader.getNullable(JsonReader::getDouble);
                } else if ("parent".equals(fieldName)) {
                    deserializedProcessInfoProperties.parent = reader.getString();
                } else if ("children".equals(fieldName)) {
                    List<String> children = reader.readArray(reader1 -> reader1.getString());
                    deserializedProcessInfoProperties.children = children;
                } else if ("threads".equals(fieldName)) {
                    List<ProcessThreadInfoInner> threads
                        = reader.readArray(reader1 -> ProcessThreadInfoInner.fromJson(reader1));
                    deserializedProcessInfoProperties.threads = threads;
                } else if ("open_file_handles".equals(fieldName)) {
                    List<String> openFileHandles = reader.readArray(reader1 -> reader1.getString());
                    deserializedProcessInfoProperties.openFileHandles = openFileHandles;
                } else if ("modules".equals(fieldName)) {
                    List<ProcessModuleInfoInner> modules
                        = reader.readArray(reader1 -> ProcessModuleInfoInner.fromJson(reader1));
                    deserializedProcessInfoProperties.modules = modules;
                } else if ("file_name".equals(fieldName)) {
                    deserializedProcessInfoProperties.fileName = reader.getString();
                } else if ("command_line".equals(fieldName)) {
                    deserializedProcessInfoProperties.commandLine = reader.getString();
                } else if ("user_name".equals(fieldName)) {
                    deserializedProcessInfoProperties.username = reader.getString();
                } else if ("handle_count".equals(fieldName)) {
                    deserializedProcessInfoProperties.handleCount = reader.getNullable(JsonReader::getInt);
                } else if ("module_count".equals(fieldName)) {
                    deserializedProcessInfoProperties.moduleCount = reader.getNullable(JsonReader::getInt);
                } else if ("thread_count".equals(fieldName)) {
                    deserializedProcessInfoProperties.threadCount = reader.getNullable(JsonReader::getInt);
                } else if ("start_time".equals(fieldName)) {
                    deserializedProcessInfoProperties.startTime = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("total_cpu_time".equals(fieldName)) {
                    deserializedProcessInfoProperties.totalCpuTime = reader.getString();
                } else if ("user_cpu_time".equals(fieldName)) {
                    deserializedProcessInfoProperties.userCpuTime = reader.getString();
                } else if ("privileged_cpu_time".equals(fieldName)) {
                    deserializedProcessInfoProperties.privilegedCpuTime = reader.getString();
                } else if ("working_set".equals(fieldName)) {
                    deserializedProcessInfoProperties.workingSet = reader.getNullable(JsonReader::getLong);
                } else if ("peak_working_set".equals(fieldName)) {
                    deserializedProcessInfoProperties.peakWorkingSet = reader.getNullable(JsonReader::getLong);
                } else if ("private_memory".equals(fieldName)) {
                    deserializedProcessInfoProperties.privateMemory = reader.getNullable(JsonReader::getLong);
                } else if ("virtual_memory".equals(fieldName)) {
                    deserializedProcessInfoProperties.virtualMemory = reader.getNullable(JsonReader::getLong);
                } else if ("peak_virtual_memory".equals(fieldName)) {
                    deserializedProcessInfoProperties.peakVirtualMemory = reader.getNullable(JsonReader::getLong);
                } else if ("paged_system_memory".equals(fieldName)) {
                    deserializedProcessInfoProperties.pagedSystemMemory = reader.getNullable(JsonReader::getLong);
                } else if ("non_paged_system_memory".equals(fieldName)) {
                    deserializedProcessInfoProperties.nonPagedSystemMemory = reader.getNullable(JsonReader::getLong);
                } else if ("paged_memory".equals(fieldName)) {
                    deserializedProcessInfoProperties.pagedMemory = reader.getNullable(JsonReader::getLong);
                } else if ("peak_paged_memory".equals(fieldName)) {
                    deserializedProcessInfoProperties.peakPagedMemory = reader.getNullable(JsonReader::getLong);
                } else if ("time_stamp".equals(fieldName)) {
                    deserializedProcessInfoProperties.timestamp = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("environment_variables".equals(fieldName)) {
                    Map<String, String> environmentVariables = reader.readMap(reader1 -> reader1.getString());
                    deserializedProcessInfoProperties.environmentVariables = environmentVariables;
                } else if ("is_scm_site".equals(fieldName)) {
                    deserializedProcessInfoProperties.isScmSite = reader.getNullable(JsonReader::getBoolean);
                } else if ("is_webjob".equals(fieldName)) {
                    deserializedProcessInfoProperties.isWebjob = reader.getNullable(JsonReader::getBoolean);
                } else if ("description".equals(fieldName)) {
                    deserializedProcessInfoProperties.description = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedProcessInfoProperties;
        });
    }
}
