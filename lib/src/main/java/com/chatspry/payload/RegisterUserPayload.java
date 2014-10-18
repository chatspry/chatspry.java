package com.chatspry.payload;

import com.chatspry.model.Device;
import com.chatspry.model.User;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

/**
 * An entity payload used when registering users and guests
 *
 * @author berwyn <berwyn@chatspry.com>
 * @version 1.0
 * @since 2014-10-17
 */
public class RegisterUserPayload {

    /**
     * The client secret
     */
    @SerializedName("client_secret")
    public String clientSecret;

    /**
     * The client ID
     */
    @SerializedName("client_id")
    public UUID clientID;

    /**
     * The User to register
     */
    public User user;

    /**
     * The type of device to register. Currently only {@link com.chatspry.model.Device#DEVICE_TYPE_ANDROID} and
     * {@link com.chatspry.model.Device#DEVICE_TYPE_APPLE} are supported.
     */
    @SerializedName("device_type")
    public String deviceType;

    /**
     * The {@link com.chatspry.model.Device} that should be registered to this user. This is
     * primarily to allow GCM and APNS devices to receive push notifications.
     */
    public Device device;

    /**
     * The scopes requested, whitespace separated
     *
     * Example: "read_activity read_user"
     */
    public String scope;

}
