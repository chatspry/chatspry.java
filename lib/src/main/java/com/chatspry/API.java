package com.chatspry;

import com.chatspry.model.AccessToken;
import com.chatspry.payload.*;
import com.chatspry.response.ConvoResponse;
import com.chatspry.response.InvitationResponse;
import com.chatspry.response.RegistrationResponse;
import com.chatspry.response.UserResponse;
import com.google.gson.Gson;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.client.Response;
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

    //region >> Activity

    @POST("/v1/activity")
    public Observable<Response> createActivity(@Header("Authorization") String authToken,
                                               @Body ActivityPayload payload);

    //endregion

    //region >> Invitation

    @POST("/v1/invitation")
    public Observable<InvitationResponse> createInvitation(@Header("Authorization") String authToken,
                                                           @Body InvitationPayload payload);

    @DELETE("/v1/invitation")
    public Observable<Response> revokeInvitation(@Header("Authorization") String authToken,
                                                 @Body InvitationPayload payload);

    //endregion

    //region >> Members

    @POST("/v1/member")
    public Observable<InvitationResponse> createMembership(@Header("Authorization") String authToken,
                                                           @Body MembershipPayload payload);

    @DELETE("/v1/member")
    public Observable<Response> deleteMembership(@Header("Authorization") String authToken,
                                                 @Body MembershipPayload payload);

    //endregion

    public static class Builder {

        private String host;
        private Gson   gson;
        private Client client;
        private String userAgent;

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

        public Builder setUserAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        public API build() {
            if(host == null) host = "http://api.chatspry.org";
            if(gson == null) gson = new Gson();
            if(client == null) client = new OkClient();
            if(userAgent == null) userAgent = "chatspry.java/1.0.0";

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(host)
                    .setConverter(new GsonConverter(gson))
                    .setClient(client)
                    .build();

            return restAdapter.create(API.class);
        }
    }
}
