package com.chatspry.model;

import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.UUID;

/**
 * Defines the User entity
 */
public class User {

    public UUID     id;
    public String   name;
    public String   handle;
    @SerializedName("created_at")
    public Calendar createdAt;
    @SerializedName("updated_at")
    public Calendar updatedAt;
    public boolean  guest;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (guest != user.guest) return false;
        if (createdAt != null ? !createdAt.equals(user.createdAt) : user.createdAt != null) return false;
        if (handle != null ? !handle.equals(user.handle) : user.handle != null) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (updatedAt != null ? !updatedAt.equals(user.updatedAt) : user.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (handle != null ? handle.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (guest ? 1 : 0);
        return result;
    }
}
