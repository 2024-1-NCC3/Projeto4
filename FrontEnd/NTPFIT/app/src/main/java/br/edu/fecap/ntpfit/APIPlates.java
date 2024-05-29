package br.edu.fecap.ntpfit;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIPlates {
    @GET("/pratos1500cafe")
    Call<JsonObject> obterPratosCafe1500();

    @GET("/pratos1500almoco")
    Call<JsonObject> obterPratosAlmoco1500();

    @GET("/pratos1500jantar")
    Call<JsonObject> obterPratosJantar1500();

    @GET("/pratos1700cafe")
    Call<JsonObject>obterPratosCafe1700();

    @GET("/pratos1700almoco")
    Call<JsonObject>obterPratosAlmoco1700();

    @GET("/pratos1700jantar")
    Call<JsonObject>obterPratosJantar1700();

    @GET("/pratos1900cafe")
    Call<JsonObject>obterPratosCafe1900();

    @GET("/pratos1900almoco")
    Call<JsonObject>obterPratosAlmoco1900();

    @GET("/pratos1900jantar")
    Call<JsonObject>obterPratosJantar1900();

    @GET("/pratos2100cafe")
    Call<JsonObject>obterPratosCafe2100();

    @GET("/pratos2100almoco")
    Call<JsonObject>obterPratosAlmoco2100();

    @GET("/pratos2100jantar")
    Call<JsonObject>obterPratosJantar2100();

    @GET("/pratos2300cafe")
    Call<JsonObject>obterPratosCafe2300();

    @GET("/pratos2300almoco")
    Call<JsonObject>obterPratosAlmoco2300();

    @GET("/pratos2300jantar")
    Call<JsonObject>obterPratosJantar2300();

    @GET("/pratos2500cafe")
    Call<JsonObject>obterPratosCafe2500();

    @GET("/pratos2500almoco")
    Call<JsonObject>obterPratosAlmoco2500();

    @GET("/pratos2500jantar")
    Call<JsonObject>obterPratosJantar2500();



}
