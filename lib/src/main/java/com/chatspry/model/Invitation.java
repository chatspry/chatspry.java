package com.chatspry.model;

import java.util.UUID;

/**
 * Created by berwyn on 17/10/14.
 */
public class Invitation {

    public UUID          id;
    public String        detail;
    public TypedResource convo;
    public TypedResource inviter;
    public TypedResource guest;

}
