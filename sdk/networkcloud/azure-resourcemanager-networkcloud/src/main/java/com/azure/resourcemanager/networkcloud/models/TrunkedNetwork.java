// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.models;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.networkcloud.fluent.models.TrunkedNetworkInner;
import java.util.List;
import java.util.Map;

/**
 * An immutable client-side representation of TrunkedNetwork.
 */
public interface TrunkedNetwork {
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
     * Gets the location property: The geo-location where the resource lives.
     * 
     * @return the location value.
     */
    String location();

    /**
     * Gets the tags property: Resource tags.
     * 
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * Gets the etag property: Resource ETag.
     * 
     * @return the etag value.
     */
    String etag();

    /**
     * Gets the extendedLocation property: The extended location of the cluster associated with the resource.
     * 
     * @return the extendedLocation value.
     */
    ExtendedLocation extendedLocation();

    /**
     * Gets the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     * 
     * @return the systemData value.
     */
    SystemData systemData();

    /**
     * Gets the associatedResourceIds property: The list of resource IDs for the other Microsoft.NetworkCloud resources
     * that have attached this network.
     * 
     * @return the associatedResourceIds value.
     */
    List<String> associatedResourceIds();

    /**
     * Gets the clusterId property: The resource ID of the Network Cloud cluster this trunked network is associated
     * with.
     * 
     * @return the clusterId value.
     */
    String clusterId();

    /**
     * Gets the detailedStatus property: The more detailed status of the trunked network.
     * 
     * @return the detailedStatus value.
     */
    TrunkedNetworkDetailedStatus detailedStatus();

    /**
     * Gets the detailedStatusMessage property: The descriptive message about the current detailed status.
     * 
     * @return the detailedStatusMessage value.
     */
    String detailedStatusMessage();

    /**
     * Gets the hybridAksClustersAssociatedIds property: Field Deprecated. These fields will be empty/omitted. The list
     * of Hybrid AKS cluster resource IDs that are associated with this trunked network.
     * 
     * @return the hybridAksClustersAssociatedIds value.
     */
    List<String> hybridAksClustersAssociatedIds();

    /**
     * Gets the hybridAksPluginType property: Field Deprecated. The field was previously optional, now it will have no
     * defined behavior and will be ignored. The network plugin type for Hybrid AKS.
     * 
     * @return the hybridAksPluginType value.
     */
    HybridAksPluginType hybridAksPluginType();

    /**
     * Gets the interfaceName property: The default interface name for this trunked network in the virtual machine. This
     * name can be overridden by the name supplied in the network attachment configuration of that virtual machine.
     * 
     * @return the interfaceName value.
     */
    String interfaceName();

    /**
     * Gets the isolationDomainIds property: The list of resource IDs representing the Network Fabric isolation domains.
     * It can be any combination of l2IsolationDomain and l3IsolationDomain resources.
     * 
     * @return the isolationDomainIds value.
     */
    List<String> isolationDomainIds();

    /**
     * Gets the provisioningState property: The provisioning state of the trunked network.
     * 
     * @return the provisioningState value.
     */
    TrunkedNetworkProvisioningState provisioningState();

    /**
     * Gets the virtualMachinesAssociatedIds property: Field Deprecated. These fields will be empty/omitted. The list of
     * virtual machine resource IDs, excluding any Hybrid AKS virtual machines, that are currently using this trunked
     * network.
     * 
     * @return the virtualMachinesAssociatedIds value.
     */
    List<String> virtualMachinesAssociatedIds();

    /**
     * Gets the vlans property: The list of vlans that are selected from the isolation domains for trunking.
     * 
     * @return the vlans value.
     */
    List<Long> vlans();

    /**
     * Gets the region of the resource.
     * 
     * @return the region of the resource.
     */
    Region region();

    /**
     * Gets the name of the resource region.
     * 
     * @return the name of the resource region.
     */
    String regionName();

    /**
     * Gets the name of the resource group.
     * 
     * @return the name of the resource group.
     */
    String resourceGroupName();

    /**
     * Gets the inner com.azure.resourcemanager.networkcloud.fluent.models.TrunkedNetworkInner object.
     * 
     * @return the inner object.
     */
    TrunkedNetworkInner innerModel();

    /**
     * The entirety of the TrunkedNetwork definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithLocation,
        DefinitionStages.WithResourceGroup, DefinitionStages.WithExtendedLocation,
        DefinitionStages.WithIsolationDomainIds, DefinitionStages.WithVlans, DefinitionStages.WithCreate {
    }

    /**
     * The TrunkedNetwork definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of the TrunkedNetwork definition.
         */
        interface Blank extends WithLocation {
        }

        /**
         * The stage of the TrunkedNetwork definition allowing to specify location.
         */
        interface WithLocation {
            /**
             * Specifies the region for the resource.
             * 
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(Region location);

            /**
             * Specifies the region for the resource.
             * 
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(String location);
        }

        /**
         * The stage of the TrunkedNetwork definition allowing to specify parent resource.
         */
        interface WithResourceGroup {
            /**
             * Specifies resourceGroupName.
             * 
             * @param resourceGroupName The name of the resource group. The name is case insensitive.
             * @return the next definition stage.
             */
            WithExtendedLocation withExistingResourceGroup(String resourceGroupName);
        }

        /**
         * The stage of the TrunkedNetwork definition allowing to specify extendedLocation.
         */
        interface WithExtendedLocation {
            /**
             * Specifies the extendedLocation property: The extended location of the cluster associated with the
             * resource..
             * 
             * @param extendedLocation The extended location of the cluster associated with the resource.
             * @return the next definition stage.
             */
            WithIsolationDomainIds withExtendedLocation(ExtendedLocation extendedLocation);
        }

        /**
         * The stage of the TrunkedNetwork definition allowing to specify isolationDomainIds.
         */
        interface WithIsolationDomainIds {
            /**
             * Specifies the isolationDomainIds property: The list of resource IDs representing the Network Fabric
             * isolation domains. It can be any combination of l2IsolationDomain and l3IsolationDomain resources..
             * 
             * @param isolationDomainIds The list of resource IDs representing the Network Fabric isolation domains. It
             * can be any combination of l2IsolationDomain and l3IsolationDomain resources.
             * @return the next definition stage.
             */
            WithVlans withIsolationDomainIds(List<String> isolationDomainIds);
        }

        /**
         * The stage of the TrunkedNetwork definition allowing to specify vlans.
         */
        interface WithVlans {
            /**
             * Specifies the vlans property: The list of vlans that are selected from the isolation domains for
             * trunking..
             * 
             * @param vlans The list of vlans that are selected from the isolation domains for trunking.
             * @return the next definition stage.
             */
            WithCreate withVlans(List<Long> vlans);
        }

        /**
         * The stage of the TrunkedNetwork definition which contains all the minimum required properties for the
         * resource to be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate extends DefinitionStages.WithTags, DefinitionStages.WithHybridAksPluginType,
            DefinitionStages.WithInterfaceName, DefinitionStages.WithIfMatch, DefinitionStages.WithIfNoneMatch {
            /**
             * Executes the create request.
             * 
             * @return the created resource.
             */
            TrunkedNetwork create();

            /**
             * Executes the create request.
             * 
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            TrunkedNetwork create(Context context);
        }

        /**
         * The stage of the TrunkedNetwork definition allowing to specify tags.
         */
        interface WithTags {
            /**
             * Specifies the tags property: Resource tags..
             * 
             * @param tags Resource tags.
             * @return the next definition stage.
             */
            WithCreate withTags(Map<String, String> tags);
        }

        /**
         * The stage of the TrunkedNetwork definition allowing to specify hybridAksPluginType.
         */
        interface WithHybridAksPluginType {
            /**
             * Specifies the hybridAksPluginType property: Field Deprecated. The field was previously optional, now it
             * will have no defined behavior and will be ignored. The network plugin type for Hybrid AKS..
             * 
             * @param hybridAksPluginType Field Deprecated. The field was previously optional, now it will have no
             * defined behavior and will be ignored. The network plugin type for Hybrid AKS.
             * @return the next definition stage.
             */
            WithCreate withHybridAksPluginType(HybridAksPluginType hybridAksPluginType);
        }

        /**
         * The stage of the TrunkedNetwork definition allowing to specify interfaceName.
         */
        interface WithInterfaceName {
            /**
             * Specifies the interfaceName property: The default interface name for this trunked network in the virtual
             * machine. This name can be overridden by the name supplied in the network attachment configuration of that
             * virtual machine..
             * 
             * @param interfaceName The default interface name for this trunked network in the virtual machine. This
             * name can be overridden by the name supplied in the network attachment configuration of that virtual
             * machine.
             * @return the next definition stage.
             */
            WithCreate withInterfaceName(String interfaceName);
        }

        /**
         * The stage of the TrunkedNetwork definition allowing to specify ifMatch.
         */
        interface WithIfMatch {
            /**
             * Specifies the ifMatch property: The ETag of the transformation. Omit this value to always overwrite the
             * current resource. Specify the last-seen ETag value to prevent accidentally overwriting concurrent
             * changes..
             * 
             * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource.
             * Specify the last-seen ETag value to prevent accidentally overwriting concurrent changes.
             * @return the next definition stage.
             */
            WithCreate withIfMatch(String ifMatch);
        }

        /**
         * The stage of the TrunkedNetwork definition allowing to specify ifNoneMatch.
         */
        interface WithIfNoneMatch {
            /**
             * Specifies the ifNoneMatch property: Set to '*' to allow a new record set to be created, but to prevent
             * updating an existing resource. Other values will result in error from server as they are not supported..
             * 
             * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an
             * existing resource. Other values will result in error from server as they are not supported.
             * @return the next definition stage.
             */
            WithCreate withIfNoneMatch(String ifNoneMatch);
        }
    }

    /**
     * Begins update for the TrunkedNetwork resource.
     * 
     * @return the stage of resource update.
     */
    TrunkedNetwork.Update update();

    /**
     * The template for TrunkedNetwork update.
     */
    interface Update extends UpdateStages.WithTags, UpdateStages.WithIfMatch, UpdateStages.WithIfNoneMatch {
        /**
         * Executes the update request.
         * 
         * @return the updated resource.
         */
        TrunkedNetwork apply();

        /**
         * Executes the update request.
         * 
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        TrunkedNetwork apply(Context context);
    }

    /**
     * The TrunkedNetwork update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the TrunkedNetwork update allowing to specify tags.
         */
        interface WithTags {
            /**
             * Specifies the tags property: The Azure resource tags that will replace the existing ones..
             * 
             * @param tags The Azure resource tags that will replace the existing ones.
             * @return the next definition stage.
             */
            Update withTags(Map<String, String> tags);
        }

        /**
         * The stage of the TrunkedNetwork update allowing to specify ifMatch.
         */
        interface WithIfMatch {
            /**
             * Specifies the ifMatch property: The ETag of the transformation. Omit this value to always overwrite the
             * current resource. Specify the last-seen ETag value to prevent accidentally overwriting concurrent
             * changes..
             * 
             * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource.
             * Specify the last-seen ETag value to prevent accidentally overwriting concurrent changes.
             * @return the next definition stage.
             */
            Update withIfMatch(String ifMatch);
        }

        /**
         * The stage of the TrunkedNetwork update allowing to specify ifNoneMatch.
         */
        interface WithIfNoneMatch {
            /**
             * Specifies the ifNoneMatch property: Set to '*' to allow a new record set to be created, but to prevent
             * updating an existing resource. Other values will result in error from server as they are not supported..
             * 
             * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an
             * existing resource. Other values will result in error from server as they are not supported.
             * @return the next definition stage.
             */
            Update withIfNoneMatch(String ifNoneMatch);
        }
    }

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @return the refreshed resource.
     */
    TrunkedNetwork refresh();

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    TrunkedNetwork refresh(Context context);
}
