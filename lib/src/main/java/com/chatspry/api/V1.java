package com.chatspry.api;

import com.chatspry.model.RoomResponse;
import com.chatspry.model.UserResponse;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.*;

/**
 * Defines the API contract for V1 clients
 */
public interface V1 {

    @GET("/v1/show_profile")
    public void showProfile(Callback<UserResponse> callback);

    @PATCH("/v1/update_profile")
    public void updateProfile(Callback<UserResponse> callback);

    @GET("/v1/find_room")
    public void findRoom(Callback<RoomResponse> callback);

    @PUT("/v1/enter_room")
    public void enterRoom(Callback<RoomResponse> callback);

    @DELETE("/v1/leave_room")
    public void leaveRoom(Callback<RoomResponse> callback);

    @PATCH("/v1/update_room")
    public void updateRoom(Callback<RoomResponse> callback);

    @POST("/v1/build_room")
    public void buildRoom(Callback<RoomResponse> callback);

    public static class Builder {

        private String host;

        public Builder setHost(String host) {
            this.host = host;
            return this;
        }

        public V1 build() {
            if (host == null) host = "http://api.chatspry.org";

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(this.host)
                    .build();

            return restAdapter.create(V1.class);
        }
    }
}
