// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.security.fluent.models.SettingInner;
import com.azure.resourcemanager.security.models.SettingName;

/**
 * An instance of this class provides access to all the operations defined in SettingsClient.
 */
public interface SettingsClient {
    /**
     * Settings about different configurations in Microsoft Defender for Cloud.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return subscription settings list as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<SettingInner> list();

    /**
     * Settings about different configurations in Microsoft Defender for Cloud.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return subscription settings list as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<SettingInner> list(Context context);

    /**
     * Settings of different configurations in Microsoft Defender for Cloud.
     * 
     * @param settingName The name of the setting.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the kind of the security setting along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<SettingInner> getWithResponse(SettingName settingName, Context context);

    /**
     * Settings of different configurations in Microsoft Defender for Cloud.
     * 
     * @param settingName The name of the setting.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the kind of the security setting.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SettingInner get(SettingName settingName);

    /**
     * updating settings about different configurations in Microsoft Defender for Cloud.
     * 
     * @param settingName The name of the setting.
     * @param setting Setting object.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the kind of the security setting along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<SettingInner> updateWithResponse(SettingName settingName, SettingInner setting, Context context);

    /**
     * updating settings about different configurations in Microsoft Defender for Cloud.
     * 
     * @param settingName The name of the setting.
     * @param setting Setting object.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the kind of the security setting.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SettingInner update(SettingName settingName, SettingInner setting);
}
