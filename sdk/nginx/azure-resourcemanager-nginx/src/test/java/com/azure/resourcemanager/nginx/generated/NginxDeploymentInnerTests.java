// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.nginx.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.nginx.fluent.models.NginxDeploymentInner;
import com.azure.resourcemanager.nginx.models.AutoUpgradeProfile;
import com.azure.resourcemanager.nginx.models.IdentityProperties;
import com.azure.resourcemanager.nginx.models.IdentityType;
import com.azure.resourcemanager.nginx.models.NginxDeploymentProperties;
import com.azure.resourcemanager.nginx.models.NginxDeploymentScalingProperties;
import com.azure.resourcemanager.nginx.models.NginxDeploymentUserProfile;
import com.azure.resourcemanager.nginx.models.NginxFrontendIpConfiguration;
import com.azure.resourcemanager.nginx.models.NginxLogging;
import com.azure.resourcemanager.nginx.models.NginxNetworkInterfaceConfiguration;
import com.azure.resourcemanager.nginx.models.NginxNetworkProfile;
import com.azure.resourcemanager.nginx.models.NginxPrivateIpAddress;
import com.azure.resourcemanager.nginx.models.NginxPrivateIpAllocationMethod;
import com.azure.resourcemanager.nginx.models.NginxPublicIpAddress;
import com.azure.resourcemanager.nginx.models.NginxStorageAccount;
import com.azure.resourcemanager.nginx.models.ResourceSku;
import com.azure.resourcemanager.nginx.models.ScaleProfile;
import com.azure.resourcemanager.nginx.models.ScaleProfileCapacity;
import com.azure.resourcemanager.nginx.models.UserIdentityProperties;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class NginxDeploymentInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        NginxDeploymentInner model = BinaryData.fromString(
            "{\"identity\":{\"principalId\":\"tnwu\",\"tenantId\":\"gazxuf\",\"type\":\"UserAssigned\",\"userAssignedIdentities\":{\"kfthwxmntei\":{\"principalId\":\"fihrfi\",\"clientId\":\"vzwdzuhtymwis\"}}},\"properties\":{\"provisioningState\":\"Deleting\",\"nginxVersion\":\"km\",\"managedResourceGroup\":\"c\",\"networkProfile\":{\"frontEndIPConfiguration\":{\"publicIPAddresses\":[{\"id\":\"fufsrpymzi\"},{\"id\":\"sezcxtb\"},{\"id\":\"gfycc\"}],\"privateIPAddresses\":[{\"privateIPAddress\":\"mdwzjeiachboo\",\"privateIPAllocationMethod\":\"Static\",\"subnetId\":\"ro\"},{\"privateIPAddress\":\"qpteeh\",\"privateIPAllocationMethod\":\"Dynamic\",\"subnetId\":\"pyqr\"}]},\"networkInterfaceConfiguration\":{\"subnetId\":\"inpvswjdkirsoodq\"}},\"ipAddress\":\"crmnohjtckwhds\",\"enableDiagnosticsSupport\":true,\"logging\":{\"storageAccount\":{\"accountName\":\"pjxsqwpgrjbznor\",\"containerName\":\"xv\"}},\"scalingProperties\":{\"capacity\":1906799262,\"autoScaleSettings\":{\"profiles\":[{\"name\":\"abnmocpcyshu\",\"capacity\":{\"min\":818060655,\"max\":2023442123}},{\"name\":\"fblj\",\"capacity\":{\"min\":844718571,\"max\":527758336}}]}},\"autoUpgradeProfile\":{\"upgradeChannel\":\"toqcjmklja\"},\"userProfile\":{\"preferredEmail\":\"idtqajzyu\"}},\"sku\":{\"name\":\"kudjkrlkhb\"},\"location\":\"fepgzgq\",\"tags\":{\"c\":\"locx\"},\"id\":\"aierhhb\",\"name\":\"sglumma\",\"type\":\"tjaodxobnb\"}")
            .toObject(NginxDeploymentInner.class);
        Assertions.assertEquals("fepgzgq", model.location());
        Assertions.assertEquals("locx", model.tags().get("c"));
        Assertions.assertEquals(IdentityType.USER_ASSIGNED, model.identity().type());
        Assertions.assertEquals("c", model.properties().managedResourceGroup());
        Assertions.assertEquals("fufsrpymzi",
            model.properties().networkProfile().frontEndIpConfiguration().publicIpAddresses().get(0).id());
        Assertions.assertEquals("mdwzjeiachboo",
            model.properties()
                .networkProfile()
                .frontEndIpConfiguration()
                .privateIpAddresses()
                .get(0)
                .privateIpAddress());
        Assertions.assertEquals(NginxPrivateIpAllocationMethod.STATIC,
            model.properties()
                .networkProfile()
                .frontEndIpConfiguration()
                .privateIpAddresses()
                .get(0)
                .privateIpAllocationMethod());
        Assertions.assertEquals("ro",
            model.properties().networkProfile().frontEndIpConfiguration().privateIpAddresses().get(0).subnetId());
        Assertions.assertEquals("inpvswjdkirsoodq",
            model.properties().networkProfile().networkInterfaceConfiguration().subnetId());
        Assertions.assertEquals(true, model.properties().enableDiagnosticsSupport());
        Assertions.assertEquals("pjxsqwpgrjbznor", model.properties().logging().storageAccount().accountName());
        Assertions.assertEquals("xv", model.properties().logging().storageAccount().containerName());
        Assertions.assertEquals(1906799262, model.properties().scalingProperties().capacity());
        Assertions.assertEquals("abnmocpcyshu", model.properties().scalingProperties().profiles().get(0).name());
        Assertions.assertEquals(818060655, model.properties().scalingProperties().profiles().get(0).capacity().min());
        Assertions.assertEquals(2023442123, model.properties().scalingProperties().profiles().get(0).capacity().max());
        Assertions.assertEquals("toqcjmklja", model.properties().autoUpgradeProfile().upgradeChannel());
        Assertions.assertEquals("idtqajzyu", model.properties().userProfile().preferredEmail());
        Assertions.assertEquals("kudjkrlkhb", model.sku().name());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        NginxDeploymentInner model
            = new NginxDeploymentInner().withLocation("fepgzgq")
                .withTags(mapOf("c", "locx"))
                .withIdentity(new IdentityProperties().withType(IdentityType.USER_ASSIGNED)
                    .withUserAssignedIdentities(mapOf("kfthwxmntei", new UserIdentityProperties())))
                .withProperties(
                    new NginxDeploymentProperties().withManagedResourceGroup("c")
                        .withNetworkProfile(
                            new NginxNetworkProfile()
                                .withFrontEndIpConfiguration(
                                    new NginxFrontendIpConfiguration()
                                        .withPublicIpAddresses(
                                            Arrays.asList(new NginxPublicIpAddress().withId("fufsrpymzi"),
                                                new NginxPublicIpAddress().withId("sezcxtb"),
                                                new NginxPublicIpAddress().withId("gfycc")))
                                        .withPrivateIpAddresses(
                                            Arrays.asList(
                                                new NginxPrivateIpAddress().withPrivateIpAddress("mdwzjeiachboo")
                                                    .withPrivateIpAllocationMethod(
                                                        NginxPrivateIpAllocationMethod.STATIC)
                                                    .withSubnetId("ro"),
                                                new NginxPrivateIpAddress().withPrivateIpAddress("qpteeh")
                                                    .withPrivateIpAllocationMethod(
                                                        NginxPrivateIpAllocationMethod.DYNAMIC)
                                                    .withSubnetId("pyqr"))))
                                .withNetworkInterfaceConfiguration(
                                    new NginxNetworkInterfaceConfiguration().withSubnetId("inpvswjdkirsoodq")))
                        .withEnableDiagnosticsSupport(true)
                        .withLogging(new NginxLogging().withStorageAccount(
                            new NginxStorageAccount().withAccountName("pjxsqwpgrjbznor").withContainerName("xv")))
                        .withScalingProperties(new NginxDeploymentScalingProperties().withCapacity(1906799262)
                            .withProfiles(Arrays.asList(
                                new ScaleProfile().withName("abnmocpcyshu")
                                    .withCapacity(new ScaleProfileCapacity().withMin(818060655).withMax(2023442123)),
                                new ScaleProfile().withName("fblj")
                                    .withCapacity(new ScaleProfileCapacity().withMin(844718571).withMax(527758336)))))
                        .withAutoUpgradeProfile(new AutoUpgradeProfile().withUpgradeChannel("toqcjmklja"))
                        .withUserProfile(new NginxDeploymentUserProfile().withPreferredEmail("idtqajzyu")))
                .withSku(new ResourceSku().withName("kudjkrlkhb"));
        model = BinaryData.fromObject(model).toObject(NginxDeploymentInner.class);
        Assertions.assertEquals("fepgzgq", model.location());
        Assertions.assertEquals("locx", model.tags().get("c"));
        Assertions.assertEquals(IdentityType.USER_ASSIGNED, model.identity().type());
        Assertions.assertEquals("c", model.properties().managedResourceGroup());
        Assertions.assertEquals("fufsrpymzi",
            model.properties().networkProfile().frontEndIpConfiguration().publicIpAddresses().get(0).id());
        Assertions.assertEquals("mdwzjeiachboo",
            model.properties()
                .networkProfile()
                .frontEndIpConfiguration()
                .privateIpAddresses()
                .get(0)
                .privateIpAddress());
        Assertions.assertEquals(NginxPrivateIpAllocationMethod.STATIC,
            model.properties()
                .networkProfile()
                .frontEndIpConfiguration()
                .privateIpAddresses()
                .get(0)
                .privateIpAllocationMethod());
        Assertions.assertEquals("ro",
            model.properties().networkProfile().frontEndIpConfiguration().privateIpAddresses().get(0).subnetId());
        Assertions.assertEquals("inpvswjdkirsoodq",
            model.properties().networkProfile().networkInterfaceConfiguration().subnetId());
        Assertions.assertEquals(true, model.properties().enableDiagnosticsSupport());
        Assertions.assertEquals("pjxsqwpgrjbznor", model.properties().logging().storageAccount().accountName());
        Assertions.assertEquals("xv", model.properties().logging().storageAccount().containerName());
        Assertions.assertEquals(1906799262, model.properties().scalingProperties().capacity());
        Assertions.assertEquals("abnmocpcyshu", model.properties().scalingProperties().profiles().get(0).name());
        Assertions.assertEquals(818060655, model.properties().scalingProperties().profiles().get(0).capacity().min());
        Assertions.assertEquals(2023442123, model.properties().scalingProperties().profiles().get(0).capacity().max());
        Assertions.assertEquals("toqcjmklja", model.properties().autoUpgradeProfile().upgradeChannel());
        Assertions.assertEquals("idtqajzyu", model.properties().userProfile().preferredEmail());
        Assertions.assertEquals("kudjkrlkhb", model.sku().name());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
