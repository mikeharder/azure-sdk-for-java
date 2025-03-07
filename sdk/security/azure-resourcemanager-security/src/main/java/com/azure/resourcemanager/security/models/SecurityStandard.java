// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.util.Context;
import com.azure.resourcemanager.security.fluent.models.SecurityStandardInner;
import java.util.List;

/**
 * An immutable client-side representation of SecurityStandard.
 */
public interface SecurityStandard {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     * 
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     * 
     * @return the type value.
     */
    String type();

    /**
     * Gets the displayName property: Display name of the standard, equivalent to the standardId.
     * 
     * @return the displayName value.
     */
    String displayName();

    /**
     * Gets the standardType property: Standard type (Custom or Default or Compliance only currently).
     * 
     * @return the standardType value.
     */
    StandardType standardType();

    /**
     * Gets the description property: Description of the standard.
     * 
     * @return the description value.
     */
    String description();

    /**
     * Gets the assessments property: List of assessment keys to apply to standard scope.
     * 
     * @return the assessments value.
     */
    List<PartialAssessmentProperties> assessments();

    /**
     * Gets the cloudProviders property: List of all standard supported clouds.
     * 
     * @return the cloudProviders value.
     */
    List<StandardSupportedCloud> cloudProviders();

    /**
     * Gets the policySetDefinitionId property: The policy set definition id associated with the standard.
     * 
     * @return the policySetDefinitionId value.
     */
    String policySetDefinitionId();

    /**
     * Gets the metadata property: The security standard metadata.
     * 
     * @return the metadata value.
     */
    StandardMetadata metadata();

    /**
     * Gets the inner com.azure.resourcemanager.security.fluent.models.SecurityStandardInner object.
     * 
     * @return the inner object.
     */
    SecurityStandardInner innerModel();

    /**
     * The entirety of the SecurityStandard definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithScope, DefinitionStages.WithCreate {
    }

    /**
     * The SecurityStandard definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of the SecurityStandard definition.
         */
        interface Blank extends WithScope {
        }

        /**
         * The stage of the SecurityStandard definition allowing to specify parent resource.
         */
        interface WithScope {
            /**
             * Specifies scope.
             * 
             * @param scope The scope of the security standard. Valid scopes are: management group (format:
             * 'providers/Microsoft.Management/managementGroups/{managementGroup}'), subscription (format:
             * 'subscriptions/{subscriptionId}'), or security connector (format:
             * 'subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Security/securityConnectors/{securityConnectorName})'.
             * @return the next definition stage.
             */
            WithCreate withExistingScope(String scope);
        }

        /**
         * The stage of the SecurityStandard definition which contains all the minimum required properties for the
         * resource to be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate extends DefinitionStages.WithDisplayName, DefinitionStages.WithDescription,
            DefinitionStages.WithAssessments, DefinitionStages.WithCloudProviders,
            DefinitionStages.WithPolicySetDefinitionId, DefinitionStages.WithMetadata {
            /**
             * Executes the create request.
             * 
             * @return the created resource.
             */
            SecurityStandard create();

            /**
             * Executes the create request.
             * 
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            SecurityStandard create(Context context);
        }

        /**
         * The stage of the SecurityStandard definition allowing to specify displayName.
         */
        interface WithDisplayName {
            /**
             * Specifies the displayName property: Display name of the standard, equivalent to the standardId.
             * 
             * @param displayName Display name of the standard, equivalent to the standardId.
             * @return the next definition stage.
             */
            WithCreate withDisplayName(String displayName);
        }

        /**
         * The stage of the SecurityStandard definition allowing to specify description.
         */
        interface WithDescription {
            /**
             * Specifies the description property: Description of the standard.
             * 
             * @param description Description of the standard.
             * @return the next definition stage.
             */
            WithCreate withDescription(String description);
        }

        /**
         * The stage of the SecurityStandard definition allowing to specify assessments.
         */
        interface WithAssessments {
            /**
             * Specifies the assessments property: List of assessment keys to apply to standard scope..
             * 
             * @param assessments List of assessment keys to apply to standard scope.
             * @return the next definition stage.
             */
            WithCreate withAssessments(List<PartialAssessmentProperties> assessments);
        }

        /**
         * The stage of the SecurityStandard definition allowing to specify cloudProviders.
         */
        interface WithCloudProviders {
            /**
             * Specifies the cloudProviders property: List of all standard supported clouds..
             * 
             * @param cloudProviders List of all standard supported clouds.
             * @return the next definition stage.
             */
            WithCreate withCloudProviders(List<StandardSupportedCloud> cloudProviders);
        }

        /**
         * The stage of the SecurityStandard definition allowing to specify policySetDefinitionId.
         */
        interface WithPolicySetDefinitionId {
            /**
             * Specifies the policySetDefinitionId property: The policy set definition id associated with the standard..
             * 
             * @param policySetDefinitionId The policy set definition id associated with the standard.
             * @return the next definition stage.
             */
            WithCreate withPolicySetDefinitionId(String policySetDefinitionId);
        }

        /**
         * The stage of the SecurityStandard definition allowing to specify metadata.
         */
        interface WithMetadata {
            /**
             * Specifies the metadata property: The security standard metadata..
             * 
             * @param metadata The security standard metadata.
             * @return the next definition stage.
             */
            WithCreate withMetadata(StandardMetadata metadata);
        }
    }

    /**
     * Begins update for the SecurityStandard resource.
     * 
     * @return the stage of resource update.
     */
    SecurityStandard.Update update();

    /**
     * The template for SecurityStandard update.
     */
    interface Update extends UpdateStages.WithDisplayName, UpdateStages.WithDescription, UpdateStages.WithAssessments,
        UpdateStages.WithCloudProviders, UpdateStages.WithPolicySetDefinitionId, UpdateStages.WithMetadata {
        /**
         * Executes the update request.
         * 
         * @return the updated resource.
         */
        SecurityStandard apply();

        /**
         * Executes the update request.
         * 
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        SecurityStandard apply(Context context);
    }

    /**
     * The SecurityStandard update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the SecurityStandard update allowing to specify displayName.
         */
        interface WithDisplayName {
            /**
             * Specifies the displayName property: Display name of the standard, equivalent to the standardId.
             * 
             * @param displayName Display name of the standard, equivalent to the standardId.
             * @return the next definition stage.
             */
            Update withDisplayName(String displayName);
        }

        /**
         * The stage of the SecurityStandard update allowing to specify description.
         */
        interface WithDescription {
            /**
             * Specifies the description property: Description of the standard.
             * 
             * @param description Description of the standard.
             * @return the next definition stage.
             */
            Update withDescription(String description);
        }

        /**
         * The stage of the SecurityStandard update allowing to specify assessments.
         */
        interface WithAssessments {
            /**
             * Specifies the assessments property: List of assessment keys to apply to standard scope..
             * 
             * @param assessments List of assessment keys to apply to standard scope.
             * @return the next definition stage.
             */
            Update withAssessments(List<PartialAssessmentProperties> assessments);
        }

        /**
         * The stage of the SecurityStandard update allowing to specify cloudProviders.
         */
        interface WithCloudProviders {
            /**
             * Specifies the cloudProviders property: List of all standard supported clouds..
             * 
             * @param cloudProviders List of all standard supported clouds.
             * @return the next definition stage.
             */
            Update withCloudProviders(List<StandardSupportedCloud> cloudProviders);
        }

        /**
         * The stage of the SecurityStandard update allowing to specify policySetDefinitionId.
         */
        interface WithPolicySetDefinitionId {
            /**
             * Specifies the policySetDefinitionId property: The policy set definition id associated with the standard..
             * 
             * @param policySetDefinitionId The policy set definition id associated with the standard.
             * @return the next definition stage.
             */
            Update withPolicySetDefinitionId(String policySetDefinitionId);
        }

        /**
         * The stage of the SecurityStandard update allowing to specify metadata.
         */
        interface WithMetadata {
            /**
             * Specifies the metadata property: The security standard metadata..
             * 
             * @param metadata The security standard metadata.
             * @return the next definition stage.
             */
            Update withMetadata(StandardMetadata metadata);
        }
    }

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @return the refreshed resource.
     */
    SecurityStandard refresh();

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    SecurityStandard refresh(Context context);
}
