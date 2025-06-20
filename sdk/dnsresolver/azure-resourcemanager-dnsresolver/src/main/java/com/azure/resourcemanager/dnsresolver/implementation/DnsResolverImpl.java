// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.dnsresolver.implementation;

import com.azure.core.management.Region;
import com.azure.core.management.SubResource;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.dnsresolver.fluent.models.DnsResolverInner;
import com.azure.resourcemanager.dnsresolver.models.DnsResolver;
import com.azure.resourcemanager.dnsresolver.models.DnsResolverPatch;
import com.azure.resourcemanager.dnsresolver.models.DnsResolverState;
import com.azure.resourcemanager.dnsresolver.models.ProvisioningState;
import java.util.Collections;
import java.util.Map;

public final class DnsResolverImpl implements DnsResolver, DnsResolver.Definition, DnsResolver.Update {
    private DnsResolverInner innerObject;

    private final com.azure.resourcemanager.dnsresolver.DnsResolverManager serviceManager;

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

    public String etag() {
        return this.innerModel().etag();
    }

    public SystemData systemData() {
        return this.innerModel().systemData();
    }

    public SubResource virtualNetwork() {
        return this.innerModel().virtualNetwork();
    }

    public DnsResolverState dnsResolverState() {
        return this.innerModel().dnsResolverState();
    }

    public ProvisioningState provisioningState() {
        return this.innerModel().provisioningState();
    }

    public String resourceGuid() {
        return this.innerModel().resourceGuid();
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

    public DnsResolverInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.dnsresolver.DnsResolverManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String dnsResolverName;

    private String createIfMatch;

    private String createIfNoneMatch;

    private String updateIfMatch;

    private DnsResolverPatch updateParameters;

    public DnsResolverImpl withExistingResourceGroup(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    public DnsResolver create() {
        this.innerObject = serviceManager.serviceClient()
            .getDnsResolvers()
            .createOrUpdate(resourceGroupName, dnsResolverName, this.innerModel(), createIfMatch, createIfNoneMatch,
                Context.NONE);
        return this;
    }

    public DnsResolver create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getDnsResolvers()
            .createOrUpdate(resourceGroupName, dnsResolverName, this.innerModel(), createIfMatch, createIfNoneMatch,
                context);
        return this;
    }

    DnsResolverImpl(String name, com.azure.resourcemanager.dnsresolver.DnsResolverManager serviceManager) {
        this.innerObject = new DnsResolverInner();
        this.serviceManager = serviceManager;
        this.dnsResolverName = name;
        this.createIfMatch = null;
        this.createIfNoneMatch = null;
    }

    public DnsResolverImpl update() {
        this.updateIfMatch = null;
        this.updateParameters = new DnsResolverPatch();
        return this;
    }

    public DnsResolver apply() {
        this.innerObject = serviceManager.serviceClient()
            .getDnsResolvers()
            .update(resourceGroupName, dnsResolverName, updateParameters, updateIfMatch, Context.NONE);
        return this;
    }

    public DnsResolver apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getDnsResolvers()
            .update(resourceGroupName, dnsResolverName, updateParameters, updateIfMatch, context);
        return this;
    }

    DnsResolverImpl(DnsResolverInner innerObject,
        com.azure.resourcemanager.dnsresolver.DnsResolverManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.dnsResolverName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "dnsResolvers");
    }

    public DnsResolver refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getDnsResolvers()
            .getByResourceGroupWithResponse(resourceGroupName, dnsResolverName, Context.NONE)
            .getValue();
        return this;
    }

    public DnsResolver refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getDnsResolvers()
            .getByResourceGroupWithResponse(resourceGroupName, dnsResolverName, context)
            .getValue();
        return this;
    }

    public DnsResolverImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public DnsResolverImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public DnsResolverImpl withVirtualNetwork(SubResource virtualNetwork) {
        this.innerModel().withVirtualNetwork(virtualNetwork);
        return this;
    }

    public DnsResolverImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateParameters.withTags(tags);
            return this;
        }
    }

    public DnsResolverImpl withIfMatch(String ifMatch) {
        if (isInCreateMode()) {
            this.createIfMatch = ifMatch;
            return this;
        } else {
            this.updateIfMatch = ifMatch;
            return this;
        }
    }

    public DnsResolverImpl withIfNoneMatch(String ifNoneMatch) {
        this.createIfNoneMatch = ifNoneMatch;
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel() == null || this.innerModel().id() == null;
    }
}
