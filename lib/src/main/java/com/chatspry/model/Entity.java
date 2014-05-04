package com.chatspry.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Describes the base context of all entities
 */
@Data
public class Entity {

    @SerializedName("id")
    private String id;
    private String type;

}
