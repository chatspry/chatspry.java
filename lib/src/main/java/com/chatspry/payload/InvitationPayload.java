package com.chatspry.payload;

import com.chatspry.model.Invitation;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

/**
 * Created by berwyn on 18/10/14.
 */
public class InvitationPayload {

    @SerializedName("convo_id")
    public UUID       convoId;
    @SerializedName("guest_id")
    public UUID       guestID;
    public Invitation invitation;

}
