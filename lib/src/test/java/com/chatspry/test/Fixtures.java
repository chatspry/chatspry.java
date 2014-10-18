package com.chatspry.test;

import com.chatspry.model.AccessToken;

import java.util.Date;
import java.util.UUID;

/**
 * Created by berwyn on 17/10/14.
 */
public class Fixtures {

    public static final UUID        CLIENT_ID     = UUID.randomUUID();
    public static final String      CLIENT_SECRET = "GqOhe2Ug5LgBhvFta1SyXg";
    public static final AccessToken ACCESS_TOKEN;

    static {
        ACCESS_TOKEN = new AccessToken() {{
            type = "bearer";
            token = "4327dc71be895cacf6b80795a626dd8bdf3873c0b51238fda44c895834eb1666";
            refreshToken = "6QBwgKEUef1I8zmBzow-zQ";
            expiresAt = new Date(1403368287);
            client = new TypedResource() {{
                type = "application";
                id = UUID.fromString("4bf5cda6-91fb-47d9-938b-325b27dc4862");
            }};
            owner = new TypedResource() {{
                type = "owner";
                id = UUID.fromString("38459979-e5f9-4c50-8bf6-8721bae33b4e");
            }};
            scopes = new String[]{"read_user", "read_activity"};
        }};
    }
}
