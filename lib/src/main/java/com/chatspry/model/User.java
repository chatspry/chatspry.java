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

}
