package com.chatspry;

import com.chatspry.model.AccessToken;
import com.chatspry.model.Convo;
import com.chatspry.payload.ConvoPayload;
import com.chatspry.payload.LoginPayload;
import com.chatspry.payload.RegisterUserPayload;
import com.chatspry.response.ConvoResponse;
import com.chatspry.response.RegistrationResponse;
import com.chatspry.response.UserResponse;
import com.google.gson.Gson;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;
import retrofit.http.*;
import rx.Observable;

import java.util.UUID;

/**
 * Defines the API contract for clients
 */
public interface API {

    //region >> OAuth

    @POST("/v1/oauth/access")
    public Observable<AccessToken> login(@Body LoginPayload payload);

    //endregion

    //region >> User

    @GET("/v1/user/{id}")
    public Observable<UserResponse> getUser(@Path("id") UUID id);

    @PUT("/v1/user/{id}")
    public Observable<RegistrationResponse> registerUser(@Path("id") UUID id, @Body RegisterUserPayload payload);

    //endregion

    //region >> Convo

    @PUT("/v1/convo/{id}")
    public Observable<ConvoResponse> createConvo(@Header("Authorization") String authToken,
                                                 @Path("id") UUID id,
                                                 @Body ConvoPayload payload);

    @GET("/v1/convo/{id}")
    public Observable<ConvoResponse> getConvo(@Header("Authorization") String authToken,
                                              @Path("id") UUID id);

    @PATCH("/v1/convo/{id}")
    public Observable<ConvoResponse> updateConvo(@Header("Authorization") String authToken,
                                                 @Path("id") UUID id,
                                                 @Body ConvoPayload payload);

    //endregion

    public static class Builder {


        private String host;
        private Gson   gson;
        private Client client;


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

        public API build() {
            if(host == null) host = "http://api.chatspry.org";
            if(gson == null) gson = new Gson();
            if(client == null) client = new OkClient();

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(host)
                    .setConverter(new GsonConverter(gson))
                    .setClient(client)
                    .build();

            return restAdapter.create(API.class);
        }
    }
}
