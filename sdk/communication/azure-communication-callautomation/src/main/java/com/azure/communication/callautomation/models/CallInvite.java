// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.callautomation.models;

import java.util.HashMap;

import com.azure.communication.common.CommunicationIdentifier;
import com.azure.communication.common.CommunicationUserIdentifier;
import com.azure.communication.common.MicrosoftTeamsUserIdentifier;
import com.azure.communication.common.PhoneNumberIdentifier;
import com.azure.communication.common.TeamsExtensionUserIdentifier;
import com.azure.core.annotation.Fluent;

/**
 *  Call invite details.
 */
@Fluent
public final class CallInvite {
    private final CommunicationIdentifier targetParticipant;
    private PhoneNumberIdentifier sourceCallerIdNumber;
    private String sourceDisplayName;
    private final CustomCallingContext customCallingContext;

    /**
     *  Create a CallInvite object with PhoneNumberIdentifier
     *  When the source of the call is a Teams App source, callerIdNumber is not supported and should be null.
     * @param targetIdentity Target's PhoneNumberIdentifier
     * @param callerIdNumber Caller's phone number identifier
     */
    public CallInvite(PhoneNumberIdentifier targetIdentity, PhoneNumberIdentifier callerIdNumber) {
        this.targetParticipant = targetIdentity;
        this.sourceCallerIdNumber = callerIdNumber;
        this.customCallingContext = new CustomCallingContext(new HashMap<>(), null);
    }

    /**
     * Create a CallInvite object with CommunicationUserIdentifier
     * @param targetIdentity Target's CommunicationUserIdentifier
     */
    public CallInvite(CommunicationUserIdentifier targetIdentity) {
        this.targetParticipant = targetIdentity;
        this.sourceCallerIdNumber = null;
        this.customCallingContext = new CustomCallingContext(null, new HashMap<>());
    }

    /**
     * Create a CallInvite object with MicrosoftTeamsUserIdentifier
     * @param targetIdentity Target's MicrosoftTeamsUserIdentifier
     */
    public CallInvite(MicrosoftTeamsUserIdentifier targetIdentity) {
        this.targetParticipant = targetIdentity;
        this.sourceCallerIdNumber = null;
        this.customCallingContext = new CustomCallingContext(null, new HashMap<>());
    }

    /**
     * Create a CallInvite object with TeamsExtensionUserIdentifier
     * @param targetIdentity Target's TeamsExtensionUserIdentifier
     */
    public CallInvite(TeamsExtensionUserIdentifier targetIdentity) {
        this.targetParticipant = targetIdentity;
        this.sourceCallerIdNumber = null;
        this.customCallingContext = new CustomCallingContext(null, new HashMap<>());
    }

    /**
     * Get target's CommunicationIdentifier
     * @return target's CommunicationIdentifier
     */
    public CommunicationIdentifier getTargetParticipant() {
        return targetParticipant;
    }

    /**
     * get caller's display name
     * @return display name for caller
     */
    public String getSourceDisplayName() {
        return sourceDisplayName;
    }

    /**
     * set display name for caller
     * @param sourceDisplayName display name for caller
     * @return the CallInvite object itself
     */
    public CallInvite setSourceDisplayName(String sourceDisplayName) {
        this.sourceDisplayName = sourceDisplayName;
        return this;
    }

    /**
     *  get custom calling context
     * @return custom calling context
     */
    public CustomCallingContext getCustomCallingContext() {
        return customCallingContext;
    }

    /**
     * get PhoneNumberIdentifier for PSTN caller
     * @return PhoneNumberIdentifier for PSTN caller
     */
    public PhoneNumberIdentifier getSourceCallerIdNumber() {
        return sourceCallerIdNumber;
    }

    /**
     * set PhoneNumberIdentifier for PSTN caller
     * @param sourceCallerIdNumber PhoneNumberIdentifier for PSTN caller
     * @return the CallInvite object itself
     */
    public CallInvite setSourceCallerIdNumber(PhoneNumberIdentifier sourceCallerIdNumber) {
        this.sourceCallerIdNumber = sourceCallerIdNumber;
        return this;
    }
}
