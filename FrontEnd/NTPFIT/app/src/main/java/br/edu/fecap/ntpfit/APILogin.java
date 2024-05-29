package br.edu.fecap.ntpfit;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APILogin {
    @POST("/login")
    Call<JsonObject> loginReq(@Body LoginRequest loginRequest);

}
