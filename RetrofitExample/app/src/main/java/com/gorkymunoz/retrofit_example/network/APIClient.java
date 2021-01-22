package com.gorkymunoz.retrofit_example.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gorky Muñoz on 21/1/2021.
 * API Client for initialize Retrofit instance
 * gorkymunoz@hotmail.com
 */
public class APIClient {

    private static final String BASE_URL = "https://rickandmortyapi.com/api/";
    private static APIClient instance = null;
    private Retrofit retrofit;

    public APIClient() {
        buildRetrofitClient();
    }

    public static synchronized APIClient getInstance() {
        if (instance == null) {
            instance = new APIClient();
        }
        return instance;
    }

    private void buildRetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getClient() {
        return retrofit;
    }

    public <T> T createService(Class<T> serviceClass) {
        return getInstance().getClient().create(serviceClass);
    }

}
