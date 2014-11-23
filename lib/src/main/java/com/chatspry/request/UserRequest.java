package com.chatspry.request;

import com.chatspry.model.Device;
import com.chatspry.model.User;
import com.google.gson.annotations.SerializedName;

/**
 * Created by berwyn on 21/11/2014.
 */
public class UserRequest {

    @SerializedName("client_secret")
    public String clientSecret;
    @SerializedName("client_id")
    public String clientID;
    public User user;
    @SerializedName("device_type")
    public String deviceType;
    public Device device;
    public String scope;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRequest)) return false;

        UserRequest that = (UserRequest) o;

        if (clientID != null ? !clientID.equals(that.clientID) : that.clientID != null) return false;
        if (clientSecret != null ? !clientSecret.equals(that.clientSecret) : that.clientSecret != null) return false;
        if (device != null ? !device.equals(that.device) : that.device != null) return false;
        if (deviceType != null ? !deviceType.equals(that.deviceType) : that.deviceType != null) return false;
        if (scope != null ? !scope.equals(that.scope) : that.scope != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientSecret != null ? clientSecret.hashCode() : 0;
        result = 31 * result + (clientID != null ? clientID.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (deviceType != null ? deviceType.hashCode() : 0);
        result = 31 * result + (device != null ? device.hashCode() : 0);
        result = 31 * result + (scope != null ? scope.hashCode() : 0);
        return result;
    }
}
