package br.edu.fecap.ntpfit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIUsers {
    @POST("/criarUsuario")
    Call<Void> insertUsers(@Body User user);
}
