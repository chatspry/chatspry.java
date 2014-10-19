package com.chatspry.payload;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

/**
 * Created by berwyn on 18/10/14.
 */
public class MembershipPayload {

    @SerializedName("convo_id")
    public UUID convoID;
    @SerializedName("user_id")
    public UUID userID;

}
