package com.chatspry.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.UUID;

/**
 * Created by berwyn on 17/10/14.
 */
public class Convo {

    public UUID   id;
    public String name;
    @SerializedName("created_at")
    public Date   createdAt;
    @SerializedName("updated_at")
    public Date   updatedAt;
    public User   user;

}
