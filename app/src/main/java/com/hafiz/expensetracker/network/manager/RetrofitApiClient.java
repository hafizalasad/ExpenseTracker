package com.hafiz.expensetracker.network.manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hafiz.expensetracker.settings.AppSettings;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClient {
    private static Retrofit retrofit = null;

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private RetrofitApiClient() {
         /*
             This is a Private Constructor
             So that nobody can create an object with this constructor, from outside of this class.
             We will achieve Singleton
         */
    }

    public static Retrofit getClient() {
        if (retrofit == null) {
            synchronized (RetrofitApiClient.class) { //thread safe Singleton implementation
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(AppSettings.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .build();
                }
            }
        }

        return retrofit;
    }
}
