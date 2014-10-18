package com.chatspry.payload;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

/**
 * An entity payload for logging in users
 *
 * @author berwyn <berwyn@chatspry.com>
 * @version 1.0
 * @since 2014-10-17
 */
public class LoginPayload {

    public static final String GRANT_TYPE_PASSWORD = "password";

    /**
     * The type of grant to use. For programmatic logic, this should be
     * {@link #GRANT_TYPE_PASSWORD}.
     */
    @SerializedName("grant_type")
    public String grantType;

    /**
     * The user's handle
     */
    public String identifier;

    /**
     * The user's plaintext password
     */
    public String passphrase;

    /**
     * A list of space-separated scopes requested.
     * Example: "read_activity read_user"
     */
    public String scope;

    /**
     * The client's UUID
     */
    @SerializedName("client_id")
    public UUID clientID;

    /**
     * The client's secret
     */
    @SerializedName("client_secret")
    public String clientSecret;

}
