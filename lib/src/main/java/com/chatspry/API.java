package com.chatspry;

import com.chatspry.model.AccessToken;
import com.chatspry.model.User;
import com.chatspry.request.OAuthRequest;
import com.chatspry.request.UserRequest;
import com.chatspry.response.UserResponse;
import com.google.gson.Gson;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;
import retrofit.http.*;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Defines the API contract for clients
 */
public interface API {

    //region >> OAuth

    /**
     * Login as a user via OAuth payload
     *
     * @param payload The OAuth payload to login with
     * @return An {@link rx.Observable} that emits the {@link com.chatspry.model.AccessToken}
     */
    @POST("/v1/oauth/access")
    public Observable<AccessToken> login(@Body OAuthRequest payload);

    //endregion

    //region >> User

    /**
     * Fetches a user from the API
     *
     * @param token The {@link com.chatspry.model.AccessToken} provided from OAuth login
     * @param id          The user ID to lookup
     * @return An {@link rx.Observable} that emits the {@link com.chatspry.model.User}
     */
    @GET("/v1/user/{id}")
    public Observable<User> getUser(@Header("Authorization") AccessToken token,
                                    @Path("id") UUID id);

    /**
     * Creates a user with the API
     *
     * When creating a guest user, a null {@link com.chatspry.model.AccessToken} should
     * be used, and the {@link com.chatspry.request.UserRequest} should have a user with
     * only {@link com.chatspry.model.User#guest} set to "true"
     *
     * @param token The {@link com.chatspry.model.AccessToken} provided from OAuth login
     * @param id The user ID to create
     * @return An {@link rx.Observable} that emits the {@link com.chatspry.model.User}
     */
    @PUT("/v1/user/{id}")
    public Observable<UserResponse> createUser(@Header("Authorization") AccessToken token,
                                               @Path("id") UUID id,
                                               @Body UserRequest request);


    /**
     * Updates a user on the API
     *
     * @param token The {@link com.chatspry.model.AccessToken} provided from OAuth login
     * @param id The user ID to update
     * @param request A {@link com.chatspry.request.UserRequest} with the updated user
     * @return An {@link rx.Observable} that emits the updated {@link com.chatspry.model.User}
     */
    @PATCH("/v1/user/{id}")
    public Observable<User> updateUser(@Header("Authorization") AccessToken token,
                                       @Path("id") UUID id,
                                       @Body UserRequest request);
    //endregion

    public static class Builder {

        private String host;
        private Gson gson;
        private Client client;
        private RequestInterceptor interceptor;

        public Builder setHost(String host) {
            this.host = host;
            return this;
        }

        public Builder setGson(Gson gson) {
            this.gson = gson;
            return this;
        }

        public Builder setClient(Client client) {
            this.client = client;
            return this;
        }

        public Builder setRequestInterceptor(RequestInterceptor interceptor) {
            this.interceptor = interceptor;
            return this;
        }

        public API build() {
            if (host == null) host = "http://api.chatspry.org";
            if (gson == null) gson = new Gson();
            if (client == null) client = new OkClient();
            if (interceptor == null) interceptor =
                    (request) -> request.addHeader("User-Agent", "chatspry.java/1.0.0");

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(host)
                    .setConverter(new GsonConverter(gson))
                    .setClient(client)
                    .setRequestInterceptor(interceptor)
                    .build();
            return restAdapter.create(API.class);
        }
    }
}
