package com.chatspry.test;

import com.chatspry.API;
import com.chatspry.model.AccessToken;
import com.chatspry.model.Device;
import com.chatspry.model.User;
import com.chatspry.request.UserRequest;
import com.chatspry.response.UserResponse;
import com.google.gson.Gson;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by berwyn on 22/11/2014.
 */
@RunWith(JUnit4.class)
public class ApiTest {

    private Gson gson;
    private API.Builder builder;
    private MockWebServer server;

    @Before
    public void setup() {
        server = new MockWebServer();
        gson = new Gson();
        builder = new API.Builder()
                .setGson(gson);
    }

    @After
    public void teardown() throws IOException {
        server.shutdown();
    }

    @Test
    public void testCreateGuestUser() throws IOException, InterruptedException {
        UserRequest request = new UserRequest();
        request.clientSecret = "abc123";
        request.clientID = "abc123";
        request.scope = "read_user read_activity";

        User guest = new User();
        guest.guest = true;
        request.user = guest;

        UserResponse serverResponse = new UserResponse();
        serverResponse.user = new User();
        serverResponse.access = new AccessToken();
        serverResponse.device = new Device();

        server.enqueue(new MockResponse().setBody(gson.toJson(serverResponse)));
        server.play();

        API api = builder
                .setHost(server.getUrl("").toString())
                .build();

        api
            .createUser(null, UUID.randomUUID(), request)
            .doOnError(error -> System.out.println("Error during createUser"))
            .subscribe(response -> {
                assertThat(response.user, allOf(
                        notNullValue(),
                        hasProperty("id")
                ));
            });

        RecordedRequest sentRequest = server.takeRequest();

        UserRequest payload = gson.fromJson(new String(sentRequest.getBody(), "UTF-8"), UserRequest.class);
        assertThat(request, allOf(
                notNullValue(),
                equalTo(payload)
        ));
    }

}
