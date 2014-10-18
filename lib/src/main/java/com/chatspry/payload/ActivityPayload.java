package com.chatspry.payload;

import com.chatspry.model.Activity;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

/**
 * Created by berwyn on 17/10/14.
 */
public class ActivityPayload {

    @SerializedName("convo_id")
    public UUID     convoID;
    public Activity activity;

    public ActivityPayload(UUID convoID, Activity activity) {
        this.convoID = convoID;
        this.activity = activity;
    }
}
