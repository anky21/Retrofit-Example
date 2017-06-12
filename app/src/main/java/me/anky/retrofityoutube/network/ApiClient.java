package me.anky.retrofityoutube.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Anky An on 12/06/2017.
 * anky25@gmail.com
 */

public class ApiClient {
    public static final String BASE_URL = "http://www.shaoniiuc.com/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
