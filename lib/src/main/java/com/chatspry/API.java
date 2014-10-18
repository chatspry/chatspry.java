package com.chatspry;

import com.chatspry.model.AccessToken;
import com.chatspry.payload.LoginPayload;
import com.google.gson.Gson;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;
import retrofit.http.Body;
import retrofit.http.POST;
import rx.Observable;

/**
 * Defines the API contract for clients
 */
public interface API {

    @POST("/v1/oauth/access")
    public Observable<AccessToken> login(@Body LoginPayload payload);

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
