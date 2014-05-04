package com.chatspry.model;

import lombok.Data;

/**
 * Defines an error returned from the API
 */
@Data
public class Error {

    private String message;
    private String type;
    private Entity entity;

}
