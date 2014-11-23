package com.chatspry.model;

import com.google.gson.annotations.SerializedName;
import org.joda.time.DateTime;

/**
 * Created by berwyn on 17/10/14.
 */
public class AccessToken {

    public static final String GRANT_TYPE_PASSWORD = "password";
    public static final String GRANT_TYPE_BEARER = "bearer";

    public String type;
    public String token;
    @SerializedName("refresh_token")
    public String refreshToken;
    @SerializedName("expires_at")
    public DateTime expiresAt;
    public TypedResource client;
    @SerializedName("resource_owner")
    public TypedResource resourceOwner;
    public String[] scopes;

    @Override
    public String toString() {
        return "Bearer " + token;
    }
}
