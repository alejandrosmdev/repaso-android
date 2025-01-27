package com.example.loginandroid_29_09_2023.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCliente {
    private static Retrofit retrofit = null;
    // Crear una instancia personalizada de Gson que sea leniente
    //static Gson gson = new GsonBuilder().setLenient().create();
    public static Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

