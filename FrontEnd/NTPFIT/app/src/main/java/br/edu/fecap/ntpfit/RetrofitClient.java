package br.edu.fecap.ntpfit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    String url = "http://localhost:8081";
    private static Retrofit retrofit = null;
    public static Retrofit getClient(String url){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
