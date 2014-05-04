package com.chatspry;

import com.chatspry.api.V1;

/**
 * Defines the API client
 */
public class Client {

    private V1 api;

    public Client() {
        api = new V1.Builder().build();
    }
}
