package com.chatspry.model;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

/**
 * Created by berwyn on 18/10/14.
 */
public class Device {

    public static final String DEVICE_TYPE_APPLE = "apple";
    public static final String DEVICE_TYPE_ANDROID = "android";

    public UUID    id;
    public String  name;
    public boolean notify;
    @SerializedName("device_token")
    public String  deviceToken;

}
