// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.resourcemanager.resources.implementation;

import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonProviders;
import com.azure.json.JsonReader;
import com.azure.resourcemanager.resources.fluent.PolicyDefinitionsClient;
import com.azure.resourcemanager.resources.fluent.models.PolicyDefinitionInner;
import com.azure.resourcemanager.resources.fluentcore.model.implementation.CreatableUpdatableImpl;
import com.azure.resourcemanager.resources.models.ParameterDefinitionsValue;
import com.azure.resourcemanager.resources.models.ParameterType;
import com.azure.resourcemanager.resources.models.PolicyDefinition;
import com.azure.resourcemanager.resources.models.PolicyType;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Implementation for {@link PolicyDefinition}.
 */
final class PolicyDefinitionImpl
    extends CreatableUpdatableImpl<PolicyDefinition, PolicyDefinitionInner, PolicyDefinitionImpl>
    implements PolicyDefinition, PolicyDefinition.Definition, PolicyDefinition.Update {
    private final PolicyDefinitionsClient innerCollection;
    private final ClientLogger logger = new ClientLogger(getClass());

    PolicyDefinitionImpl(String name, PolicyDefinitionInner innerModel, PolicyDefinitionsClient innerCollection) {
        super(name, innerModel);
        this.innerCollection = innerCollection;
    }

    @Override
    public PolicyType policyType() {
        return innerModel().policyType();
    }

    @Override
    public String displayName() {
        return innerModel().displayName();
    }

    @Override
    public String description() {
        return innerModel().description();
    }

    @Override
    public Object policyRule() {
        return innerModel().policyRule();
    }

    @Override
    public Map<String, ParameterDefinitionsValue> parameters() {
        return innerModel().parameters() == null
            ? Collections.emptyMap()
            : Collections.unmodifiableMap(innerModel().parameters());
    }

    @Override
    public String mode() {
        return innerModel().mode();
    }

    @Override
    public Object metadata() {
        return innerModel().metadata();
    }

    @Override
    public String id() {
        return innerModel().id();
    }

    @Override
    protected Mono<PolicyDefinitionInner> getInnerAsync() {
        return innerCollection.getAsync(name());
    }

    @Override
    public PolicyDefinitionImpl withDescription(String description) {
        innerModel().withDescription(description);
        return this;
    }

    @Override
    public PolicyDefinitionImpl withDisplayName(String displayName) {
        innerModel().withDisplayName(displayName);
        return this;
    }

    @Override
    public PolicyDefinitionImpl withPolicyRule(Object policyRule) {
        innerModel().withPolicyRule(policyRule);
        return this;
    }

    @Override
    public PolicyDefinitionImpl withPolicyRuleJson(String policyRuleJson) {
        try (JsonReader jsonReader = JsonProviders.createReader(policyRuleJson)) {
            Object policyRule = jsonReader.readUntyped();
            innerModel().withPolicyRule(policyRule);
        } catch (IOException e) {
            throw logger.logExceptionAsError(new RuntimeException(e));
        }
        return this;
    }

    @Override
    public PolicyDefinitionImpl withPolicyType(PolicyType policyType) {
        innerModel().withPolicyType(policyType);
        return this;
    }

    @Override
    public Mono<PolicyDefinition> createResourceAsync() {
        return innerCollection.createOrUpdateAsync(name(), innerModel()).map(innerToFluentMap(this));
    }

    @Override
    public boolean isInCreateMode() {
        return id() == null;
    }

    @Override
    public PolicyDefinitionImpl withParameter(String name, ParameterDefinitionsValue definition) {
        if (innerModel().parameters() == null) {
            innerModel().withParameters(new TreeMap<>());
        }
        innerModel().parameters().put(name, definition);
        return this;
    }

    @Override
    public PolicyDefinitionImpl withParameter(String name, ParameterType parameterType, Object defaultValue) {
        if (innerModel().parameters() == null) {
            innerModel().withParameters(new TreeMap<>());
        }
        innerModel().parameters()
            .put(name, new ParameterDefinitionsValue().withType(parameterType).withDefaultValue(defaultValue));
        return this;
    }

    @Override
    public PolicyDefinitionImpl withMode(String mode) {
        innerModel().withMode(mode);
        return this;
    }

    @Override
    public PolicyDefinitionImpl withMetadata(Object metadata) {
        innerModel().withMetadata(metadata);
        return this;
    }
}
