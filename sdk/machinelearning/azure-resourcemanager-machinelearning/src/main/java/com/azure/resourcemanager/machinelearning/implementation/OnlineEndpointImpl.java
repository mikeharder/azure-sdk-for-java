// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.machinelearning.fluent.models.OnlineEndpointInner;
import com.azure.resourcemanager.machinelearning.models.EndpointAuthKeys;
import com.azure.resourcemanager.machinelearning.models.EndpointAuthToken;
import com.azure.resourcemanager.machinelearning.models.ManagedServiceIdentity;
import com.azure.resourcemanager.machinelearning.models.OnlineEndpoint;
import com.azure.resourcemanager.machinelearning.models.OnlineEndpointProperties;
import com.azure.resourcemanager.machinelearning.models.PartialManagedServiceIdentity;
import com.azure.resourcemanager.machinelearning.models.PartialMinimalTrackedResourceWithIdentity;
import com.azure.resourcemanager.machinelearning.models.RegenerateEndpointKeysRequest;
import com.azure.resourcemanager.machinelearning.models.Sku;
import java.util.Collections;
import java.util.Map;

public final class OnlineEndpointImpl implements OnlineEndpoint, OnlineEndpoint.Definition, OnlineEndpoint.Update {
    private OnlineEndpointInner innerObject;

    private final com.azure.resourcemanager.machinelearning.MachineLearningManager serviceManager;

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public String location() {
        return this.innerModel().location();
    }

    public Map<String, String> tags() {
        Map<String, String> inner = this.innerModel().tags();
        if (inner != null) {
            return Collections.unmodifiableMap(inner);
        } else {
            return Collections.emptyMap();
        }
    }

    public OnlineEndpointProperties properties() {
        return this.innerModel().properties();
    }

    public String kind() {
        return this.innerModel().kind();
    }

    public ManagedServiceIdentity identity() {
        return this.innerModel().identity();
    }

    public Sku sku() {
        return this.innerModel().sku();
    }

    public SystemData systemData() {
        return this.innerModel().systemData();
    }

    public Region region() {
        return Region.fromName(this.regionName());
    }

    public String regionName() {
        return this.location();
    }

    public String resourceGroupName() {
        return resourceGroupName;
    }

    public OnlineEndpointInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.machinelearning.MachineLearningManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String workspaceName;

    private String endpointName;

    private PartialMinimalTrackedResourceWithIdentity updateBody;

    public OnlineEndpointImpl withExistingWorkspace(String resourceGroupName, String workspaceName) {
        this.resourceGroupName = resourceGroupName;
        this.workspaceName = workspaceName;
        return this;
    }

    public OnlineEndpoint create() {
        this.innerObject = serviceManager.serviceClient()
            .getOnlineEndpoints()
            .createOrUpdate(resourceGroupName, workspaceName, endpointName, this.innerModel(), Context.NONE);
        return this;
    }

    public OnlineEndpoint create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getOnlineEndpoints()
            .createOrUpdate(resourceGroupName, workspaceName, endpointName, this.innerModel(), context);
        return this;
    }

    OnlineEndpointImpl(String name, com.azure.resourcemanager.machinelearning.MachineLearningManager serviceManager) {
        this.innerObject = new OnlineEndpointInner();
        this.serviceManager = serviceManager;
        this.endpointName = name;
    }

    public OnlineEndpointImpl update() {
        this.updateBody = new PartialMinimalTrackedResourceWithIdentity();
        return this;
    }

    public OnlineEndpoint apply() {
        this.innerObject = serviceManager.serviceClient()
            .getOnlineEndpoints()
            .update(resourceGroupName, workspaceName, endpointName, updateBody, Context.NONE);
        return this;
    }

    public OnlineEndpoint apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getOnlineEndpoints()
            .update(resourceGroupName, workspaceName, endpointName, updateBody, context);
        return this;
    }

    OnlineEndpointImpl(OnlineEndpointInner innerObject,
        com.azure.resourcemanager.machinelearning.MachineLearningManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.workspaceName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "workspaces");
        this.endpointName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "onlineEndpoints");
    }

    public OnlineEndpoint refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getOnlineEndpoints()
            .getWithResponse(resourceGroupName, workspaceName, endpointName, Context.NONE)
            .getValue();
        return this;
    }

    public OnlineEndpoint refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getOnlineEndpoints()
            .getWithResponse(resourceGroupName, workspaceName, endpointName, context)
            .getValue();
        return this;
    }

    public Response<EndpointAuthKeys> listKeysWithResponse(Context context) {
        return serviceManager.onlineEndpoints()
            .listKeysWithResponse(resourceGroupName, workspaceName, endpointName, context);
    }

    public EndpointAuthKeys listKeys() {
        return serviceManager.onlineEndpoints().listKeys(resourceGroupName, workspaceName, endpointName);
    }

    public void regenerateKeys(RegenerateEndpointKeysRequest body) {
        serviceManager.onlineEndpoints().regenerateKeys(resourceGroupName, workspaceName, endpointName, body);
    }

    public void regenerateKeys(RegenerateEndpointKeysRequest body, Context context) {
        serviceManager.onlineEndpoints().regenerateKeys(resourceGroupName, workspaceName, endpointName, body, context);
    }

    public Response<EndpointAuthToken> getTokenWithResponse(Context context) {
        return serviceManager.onlineEndpoints()
            .getTokenWithResponse(resourceGroupName, workspaceName, endpointName, context);
    }

    public EndpointAuthToken getToken() {
        return serviceManager.onlineEndpoints().getToken(resourceGroupName, workspaceName, endpointName);
    }

    public OnlineEndpointImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public OnlineEndpointImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public OnlineEndpointImpl withProperties(OnlineEndpointProperties properties) {
        this.innerModel().withProperties(properties);
        return this;
    }

    public OnlineEndpointImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateBody.withTags(tags);
            return this;
        }
    }

    public OnlineEndpointImpl withKind(String kind) {
        this.innerModel().withKind(kind);
        return this;
    }

    public OnlineEndpointImpl withIdentity(ManagedServiceIdentity identity) {
        this.innerModel().withIdentity(identity);
        return this;
    }

    public OnlineEndpointImpl withSku(Sku sku) {
        this.innerModel().withSku(sku);
        return this;
    }

    public OnlineEndpointImpl withIdentity(PartialManagedServiceIdentity identity) {
        this.updateBody.withIdentity(identity);
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel().id() == null;
    }
}
