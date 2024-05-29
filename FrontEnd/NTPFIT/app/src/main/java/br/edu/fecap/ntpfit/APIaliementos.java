package br.edu.fecap.ntpfit;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIaliementos {
    @GET("/alimentos")
    Call<AlimentosResponse> obterLista();
}
