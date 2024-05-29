package br.edu.fecap.ntpfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FastFood extends AppCompatActivity {
        private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_food);

        listView = findViewById(R.id.ListFastFood);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.15.8:8081").addConverterFactory(GsonConverterFactory.create()).build();

        APIaliementos apIaliementos = retrofit.create(APIaliementos.class);

        Call<AlimentosResponse> call = apIaliementos.obterLista();
        call.enqueue(new Callback<AlimentosResponse>() {
            @Override
            public void onResponse(Call<AlimentosResponse> call, Response<AlimentosResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<JsonObject> alimentosJson = response.body().getALIMENTOS();

                    List<String> alimentosStrings = new ArrayList<>();
                    for (JsonObject alimentoJson : alimentosJson) {
                        if (alimentoJson.has("nome") && alimentoJson.has("kcal")) {
                            String nome = alimentoJson.get("nome").getAsString();
                            String kcal = alimentoJson.get("kcal").getAsString();
                            alimentosStrings.add(nome + " " + kcal);
                        } else {
                            Log.e("fast", "Objeto JSON malformado: " + alimentoJson.toString());
                        }
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(FastFood.this,
                            android.R.layout.simple_list_item_1, alimentosStrings);
                    listView.setAdapter(adapter);
                } else {
                    Log.e("fast", "Falha ao obter dados: " + response.errorBody());
                    Toast.makeText(FastFood.this, "Falha ao obter dados", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AlimentosResponse> call, Throwable t) {
                Log.e("fast", "Erro na chamada de API: " + t.getMessage(), t);
                Toast.makeText(FastFood.this, "Erro: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
        public void addAlimentos(View view){
        Intent intent = new Intent(FastFood.this, addFood.class);
        startActivity(intent);
        }
}