package com.chatspry.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by berwyn on 21/11/2014.
 */
public class OAuthRequest {

    @SerializedName("grant_type")
    public String grantType;
    public String identifier;
    public String passphrase;
    public String scope;
    @SerializedName("client_id")
    public String clientID;
    @SerializedName("client_secret")
    public String clientSecret;

}
