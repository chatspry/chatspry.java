package com.chatspry.model;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * Created by berwyn on 17/10/14.
 */
@EqualsAndHashCode
public class AccessToken {

    public static final String GRANT_TYPE_PASSWORD = "password";
    public static final String GRANT_TYPE_BEARER   = "bearer";

    public String        type;
    public String        token;
    @SerializedName("refresh_token")
    public String        refreshToken;
    @SerializedName("expires_at")
    public Date          expiresAt;
    public TypedResource client;
    @SerializedName("resource_owner")
    public TypedResource owner;
    public String[]      scopes;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof AccessToken)) return false;

        AccessToken that = (AccessToken) o;

        if(client != null ? !client.equals(that.client) : that.client != null) return false;
        if(expiresAt != null ? !expiresAt.equals(that.expiresAt) : that.expiresAt != null) return false;
        if(owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
        if(refreshToken != null ? !refreshToken.equals(that.refreshToken) : that.refreshToken != null) return false;
        if(!Arrays.equals(scopes, that.scopes)) return false;
        if(token != null ? !token.equals(that.token) : that.token != null) return false;
        if(type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (refreshToken != null ? refreshToken.hashCode() : 0);
        result = 31 * result + (expiresAt != null ? expiresAt.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (scopes != null ? Arrays.hashCode(scopes) : 0);
        return result;
    }

    public class TypedResource {

        public UUID   id;
        public String type;

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(!(o instanceof TypedResource)) return false;

            TypedResource that = (TypedResource) o;

            if(id != null ? !id.equals(that.id) : that.id != null) return false;
            if(type != null ? !type.equals(that.type) : that.type != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (type != null ? type.hashCode() : 0);
            return result;
        }
    }

}
