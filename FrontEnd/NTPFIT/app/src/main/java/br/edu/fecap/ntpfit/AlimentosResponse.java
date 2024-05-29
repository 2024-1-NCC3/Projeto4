package br.edu.fecap.ntpfit;

import com.google.gson.JsonObject;

import java.util.List;

public class AlimentosResponse {
    private List<JsonObject> ALIMENTOS;
    public List<JsonObject> getALIMENTOS() {
        return ALIMENTOS;
    }

    public void setALIMENTOS(List<JsonObject> ALIMENTOS) {
        this.ALIMENTOS = ALIMENTOS;
    }
}
