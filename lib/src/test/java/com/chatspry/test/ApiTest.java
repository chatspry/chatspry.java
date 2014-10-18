package com.chatspry.test;

import com.chatspry.API;
import com.chatspry.model.AccessToken;
import com.chatspry.payload.LoginPayload;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import retrofit.client.Client;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import rx.Observable;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by berwyn on 17/10/14.
 */
@RunWith(JUnit4.class)
public class ApiTest {

    API client;
    Gson   gson     = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
    Client mockHttp = new Client() {
        @Override
        public Response execute(Request request) throws IOException {
            URI uri = URI.create(request.getUrl());

            String responseJson = "{}";
            if(uri.getPath().contains("/oauth/access")) {
                responseJson = gson.toJson(Fixtures.ACCESS_TOKEN, AccessToken.class);
            }

            return new Response(
                    request.getUrl(),
                    200,
                    "nothing",
                    Collections.EMPTY_LIST,
                    new TypedByteArray("application/json", responseJson.getBytes()));
        }
    };

    @Before
    public void setup() {
        client = new API.Builder().setClient(mockHttp).build();
    }

    @Test
    public void testClientLogin() {
        assertThat(client, notNullValue());

        LoginPayload payload = new LoginPayload() {{
            clientID = Fixtures.CLIENT_ID;
            clientSecret = Fixtures.CLIENT_SECRET;
            scope = "read_user read_activity";
            identifier = "foo";
            passphrase = "barbaz";
            grantType = AccessToken.GRANT_TYPE_PASSWORD;
        }};

        Observable<AccessToken> stream = client.login(payload);
        AccessToken token = stream.toBlocking().single();

        assertThat(token, notNullValue());
        assertThat(token, equalTo(Fixtures.ACCESS_TOKEN));
        assertThat(token.token, equalTo(Fixtures.ACCESS_TOKEN.token));
    }

}
