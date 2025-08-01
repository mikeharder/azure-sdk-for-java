// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.hardwaresecuritymodules.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * SKU of the dedicated HSM.
 */
public final class SkuName extends ExpandableStringEnum<SkuName> {
    /**
     * The dedicated HSM is a Safenet Luna Network HSM A790 device.
     */
    public static final SkuName SAFE_NET_LUNA_NETWORK_HSM_A790 = fromString("SafeNet Luna Network HSM A790");

    /**
     * The dedicated HSM is a payShield 10K, model PS10-D, 10Gb Ethernet Hardware Platform device with 1 local master
     * key which supports up to 60 calls per second.
     */
    public static final SkuName PAY_SHIELD10K_LMK1_CPS60 = fromString("payShield10K_LMK1_CPS60");

    /**
     * The dedicated HSM is a payShield 10K, model PS10-D, 10Gb Ethernet Hardware Platform device with 1 local master
     * key which supports up to 250 calls per second.
     */
    public static final SkuName PAY_SHIELD10K_LMK1_CPS250 = fromString("payShield10K_LMK1_CPS250");

    /**
     * The dedicated HSM is a payShield 10K, model PS10-D, 10Gb Ethernet Hardware Platform device with 1 local master
     * key which supports up to 2500 calls per second.
     */
    public static final SkuName PAY_SHIELD10K_LMK1_CPS2500 = fromString("payShield10K_LMK1_CPS2500");

    /**
     * The dedicated HSM is a payShield 10K, model PS10-D, 10Gb Ethernet Hardware Platform device with 2 local master
     * keys which supports up to 60 calls per second.
     */
    public static final SkuName PAY_SHIELD10K_LMK2_CPS60 = fromString("payShield10K_LMK2_CPS60");

    /**
     * The dedicated HSM is a payShield 10K, model PS10-D, 10Gb Ethernet Hardware Platform device with 2 local master
     * keys which supports up to 250 calls per second.
     */
    public static final SkuName PAY_SHIELD10K_LMK2_CPS250 = fromString("payShield10K_LMK2_CPS250");

    /**
     * The dedicated HSM is a payShield 10K, model PS10-D, 10Gb Ethernet Hardware Platform device with 2 local master
     * keys which supports up to 2500 calls per second.
     */
    public static final SkuName PAY_SHIELD10K_LMK2_CPS2500 = fromString("payShield10K_LMK2_CPS2500");

    /**
     * Creates a new instance of SkuName value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public SkuName() {
    }

    /**
     * Creates or finds a SkuName from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding SkuName.
     */
    public static SkuName fromString(String name) {
        return fromString(name, SkuName.class);
    }

    /**
     * Gets known SkuName values.
     * 
     * @return known SkuName values.
     */
    public static Collection<SkuName> values() {
        return values(SkuName.class);
    }
}
