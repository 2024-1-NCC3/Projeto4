package br.edu.fecap.ntpfit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static String BASE_URL = "https://scgtg9-3000.csb.app/login/";
    private static Retrofit retrofit;
    private static Gson gson;

    public static  Retrofit getRetrofitInstance(){
        if(retrofit==null){

            gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();

        }
        return retrofit;
    }


}
