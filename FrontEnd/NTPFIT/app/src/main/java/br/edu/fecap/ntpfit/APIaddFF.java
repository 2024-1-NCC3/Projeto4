package br.edu.fecap.ntpfit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIaddFF {
    @POST("/addAlimentos")
    Call<Void>insertFood(@Body Alimentos alimentos);
}
