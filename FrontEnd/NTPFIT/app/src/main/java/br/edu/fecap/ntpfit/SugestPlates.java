package br.edu.fecap.ntpfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SugestPlates extends AppCompatActivity {
    private RadioButton caloria1500, caloria1700, caloria1900, caloria2100, caloria2300, caloria2500;
    private Button btnS;

    private TextView resultCafe, resultAlmoco, resultJanta;

    private APIPlates apiPlates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugest_plates);

        caloria1500 = findViewById(R.id.kcal1500);
        caloria1700 = findViewById(R.id.kcal1700);
        caloria1900 = findViewById(R.id.kcal1900);
        caloria2100 = findViewById(R.id.kcal2100);
        caloria2300 = findViewById(R.id.kcal2300);
        caloria2500 = findViewById(R.id.kcal2500);
        resultCafe = findViewById(R.id.ResultPlate);
        resultAlmoco = findViewById(R.id.resultPalate2);
        resultJanta = findViewById(R.id.resultJantaplate);
        btnS = findViewById(R.id.btnSugest);

        String url = "http://192.168.15.8:8081";

        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

        apiPlates = retrofit.create(APIPlates.class);


    }

    public void buttonSugest(View view) {
        if (caloria1500.isChecked()) {
            obterCafe1500();
            obterAlmoco1500();
            obterJantar1500();

        }
        if(caloria1700.isChecked()){
            obterCafe1700();
            obterAlmoco1700();
            obterJanta1700();
        }
        if(caloria1900.isChecked()){
            obterCafe1900();
            obterAlmoco1900();
            obterJantar1900();
        }
        if(caloria2100.isChecked()){
            obterCafe2100();
            obterAlmoco2100();
            obterJantar2100();
        }
        if(caloria2300.isChecked()){
            obterCafe2300();
            obterAlmoco2300();
            obterJantar2300();
        }
        if(caloria2500.isChecked()){
            obterCafe2500();
            obterAlmoco2500();
            obterJantar2500();
        }
    }

    private void obterCafe1500() {
        Call<JsonObject> call = apiPlates.obterPratosCafe1500();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {
                        JsonElement cafeElement = jsonObject.get("CAFE");

                        if (cafeElement != null && !cafeElement.isJsonNull()) {
                            String cafe = cafeElement.getAsJsonObject().get("CAFE").getAsString();

                            resultCafe.setText(cafe);

                        }

                    }
                } else {
                    resultCafe.setText("ERRO DE COMUNICAÇÃO");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("SUGESTION", "ERRO" + t.getMessage());
            }
        });
    }

    private void obterAlmoco1500() {
        Call<JsonObject> call = apiPlates.obterPratosAlmoco1500();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {


                        JsonElement almoElement = jsonObject.get("ALMOCO");

                        if (almoElement != null && !almoElement.isJsonNull()) {
                            String almoco = almoElement.getAsJsonObject().get("ALMOCO").getAsString();
                            resultAlmoco.setText(almoco);

                        } else {
                            resultAlmoco.setText("ALMOCO não encontrado");
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("SUGESTION", "ERRO: " + t.getMessage());
            }
        });
    }
    public void obterJantar1500(){
        Call<JsonObject> call = apiPlates.obterPratosJantar1500();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {


                        JsonElement jantaElement = jsonObject.get("JANTAR");

                        if (jantaElement != null && !jantaElement.isJsonNull()) {
                            String janta = jantaElement.getAsJsonObject().get("JANTAR").getAsString();

                            resultJanta.setText(janta);


                            Intent intent = new Intent(SugestPlates.this, plates.class);
                            intent.putExtra("almoco", resultAlmoco.getText().toString());
                            intent.putExtra("cafe", resultCafe.getText().toString());
                            intent.putExtra("janta", resultJanta.getText().toString());
                            startActivity(intent);
                        } else {
                            resultAlmoco.setText("JANTA não encontrado");
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });

    }
    public void obterCafe1700(){
        Call<JsonObject> call = apiPlates.obterPratosCafe1700();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {
                        JsonElement cafeElement = jsonObject.get("CAFE");

                        if (cafeElement != null && !cafeElement.isJsonNull()) {
                            String cafe = cafeElement.getAsJsonObject().get("CAFE").getAsString();

                            resultCafe.setText(cafe);

                        }

                    }
                } else {
                    resultCafe.setText("ERRO DE COMUNICAÇÃO");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("SUGESTION", "ERRO" + t.getMessage());
            }
        });
    }
    public void obterAlmoco1700(){
        Call<JsonObject> call = apiPlates.obterPratosAlmoco1700();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {
                        Log.d("JSON Recebido", jsonObject.toString());

                        JsonElement almoElement = jsonObject.get("ALMOCO");

                        if (almoElement != null && !almoElement.isJsonNull()) {
                            String almoco = almoElement.getAsJsonObject().get("ALMOCO").getAsString();
                            resultAlmoco.setText(almoco);

                        } else {
                            resultAlmoco.setText("ALMOCO não encontrado");
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("SUGESTION", "ERRO: " + t.getMessage());
            }
        });
    }

    public void obterJanta1700() {
        Call<JsonObject> call = apiPlates.obterPratosJantar1700();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {


                        JsonElement jantaElement = jsonObject.get("JANTA");

                        if (jantaElement != null && !jantaElement.isJsonNull()) {
                            String janta = jantaElement.getAsJsonObject().get("JANTA").getAsString();

                            resultJanta.setText(janta);


                            Intent intent = new Intent(SugestPlates.this, plates.class);
                            intent.putExtra("almoco", resultAlmoco.getText().toString());
                            intent.putExtra("cafe", resultCafe.getText().toString());
                            intent.putExtra("janta", resultJanta.getText().toString());
                            startActivity(intent);
                        } else {
                            resultAlmoco.setText("JANTA não encontrado");
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });

    }
    public void obterCafe1900(){
        Call<JsonObject> call = apiPlates.obterPratosCafe1900();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {
                        JsonElement cafeElement = jsonObject.get("CAFE");

                        if (cafeElement != null && !cafeElement.isJsonNull()) {
                            String cafe = cafeElement.getAsJsonObject().get("CAFE").getAsString();

                            resultCafe.setText(cafe);

                        }

                    }
                } else {
                    resultCafe.setText("ERRO DE COMUNICAÇÃO");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("SUGESTION", "ERRO" + t.getMessage());
            }
        });
    }
    public void obterAlmoco1900(){
        Call<JsonObject> call = apiPlates.obterPratosAlmoco1900();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {
                        Log.d("JSON Recebido", jsonObject.toString());

                        JsonElement almoElement = jsonObject.get("ALMOCO");

                        if (almoElement != null && !almoElement.isJsonNull()) {
                            String almoco = almoElement.getAsJsonObject().get("ALMOCO").getAsString();
                            resultAlmoco.setText(almoco);

                        } else {
                            resultAlmoco.setText("ALMOCO não encontrado");
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("SUGESTION", "ERRO: " + t.getMessage());
            }
        });
    }
    public void obterJantar1900(){
        Call<JsonObject> call = apiPlates.obterPratosJantar1900();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {
                        Log.d("JSON Recebido", jsonObject.toString());

                        JsonElement jantaElement = jsonObject.get("JANTA");

                        if (jantaElement != null && !jantaElement.isJsonNull()) {
                            String janta = jantaElement.getAsJsonObject().get("JANTA").getAsString();
                            resultJanta.setText(janta);

                            Intent intent = new Intent(SugestPlates.this, plates.class);
                            intent.putExtra("almoco", resultAlmoco.getText().toString());
                            intent.putExtra("cafe", resultCafe.getText().toString());
                            intent.putExtra("janta", resultJanta.getText().toString());
                            startActivity(intent);
                        } else {
                            resultAlmoco.setText("JANTA não encontrado");
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
    public void obterCafe2100(){
        Call<JsonObject> call = apiPlates.obterPratosCafe2100();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {
                        JsonElement cafeElement = jsonObject.get("CAFE");

                        if (cafeElement != null && !cafeElement.isJsonNull()) {
                            String cafe = cafeElement.getAsJsonObject().get("CAFE").getAsString();

                            resultCafe.setText(cafe);

                        }

                    }
                } else {
                    resultCafe.setText("ERRO DE COMUNICAÇÃO");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("SUGESTION", "ERRO" + t.getMessage());
            }
        });
    }
    public void obterAlmoco2100(){
        Call<JsonObject> call = apiPlates.obterPratosAlmoco2100();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {
                        Log.d("JSON Recebido", jsonObject.toString());

                        JsonElement almoElement = jsonObject.get("ALMOCO");

                        if (almoElement != null && !almoElement.isJsonNull()) {
                            String almoco = almoElement.getAsJsonObject().get("ALMOCO").getAsString();
                            resultAlmoco.setText(almoco);

                        } else {
                            resultAlmoco.setText("ALMOCO não encontrado");
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("SUGESTION", "ERRO: " + t.getMessage());
            }
        });
    }
    public void obterJantar2100(){
        Call<JsonObject> call = apiPlates.obterPratosJantar2100();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {
                        Log.d("JSON Recebido", jsonObject.toString());

                        JsonElement jantaElement = jsonObject.get("JANTA");

                        if (jantaElement != null && !jantaElement.isJsonNull()) {
                            String janta = jantaElement.getAsJsonObject().get("JANTA").getAsString();
                            resultJanta.setText(janta);

                            Intent intent = new Intent(SugestPlates.this, plates.class);
                            intent.putExtra("almoco", resultAlmoco.getText().toString());
                            intent.putExtra("cafe", resultCafe.getText().toString());
                            intent.putExtra("janta", resultJanta.getText().toString());
                            startActivity(intent);
                        } else {
                            resultAlmoco.setText("JANTA não encontrado");
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }


    public void obterCafe2300(){
        Call<JsonObject> call = apiPlates.obterPratosCafe2300();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {
                        JsonElement cafeElement = jsonObject.get("CAFE");

                        if (cafeElement != null && !cafeElement.isJsonNull()) {
                            String cafe = cafeElement.getAsJsonObject().get("CAFE").getAsString();

                            resultCafe.setText(cafe);

                        }

                    }
                } else {
                    resultCafe.setText("ERRO DE COMUNICAÇÃO");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("SUGESTION", "ERRO" + t.getMessage());
            }
        });
    }
    public void obterAlmoco2300(){
        Call<JsonObject> call = apiPlates.obterPratosAlmoco2300();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {
                        Log.d("JSON Recebido", jsonObject.toString());

                        JsonElement almoElement = jsonObject.get("ALMOCO");

                        if (almoElement != null && !almoElement.isJsonNull()) {
                            String almoco = almoElement.getAsJsonObject().get("ALMOCO").getAsString();
                            resultAlmoco.setText(almoco);

                        } else {
                            resultAlmoco.setText("ALMOCO não encontrado");
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("SUGESTION", "ERRO: " + t.getMessage());
            }
        });
    }
    public void obterJantar2300(){
        Call<JsonObject> call = apiPlates.obterPratosJantar2300();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {
                        Log.d("JSON Recebido", jsonObject.toString());

                        JsonElement jantaElement = jsonObject.get("JANTA");

                        if (jantaElement != null && !jantaElement.isJsonNull()) {
                            String janta = jantaElement.getAsJsonObject().get("JANTA").getAsString();
                            resultJanta.setText(janta);

                            Intent intent = new Intent(SugestPlates.this, plates.class);
                            intent.putExtra("almoco", resultAlmoco.getText().toString());
                            intent.putExtra("cafe", resultCafe.getText().toString());
                            intent.putExtra("janta", resultJanta.getText().toString());
                            startActivity(intent);
                        } else {
                            resultAlmoco.setText("JANTA não encontrado");
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
    public void obterCafe2500(){
        Call<JsonObject> call = apiPlates.obterPratosCafe2500();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {
                        JsonElement cafeElement = jsonObject.get("CAFE");

                        if (cafeElement != null && !cafeElement.isJsonNull()) {
                            String cafe = cafeElement.getAsJsonObject().get("CAFE").getAsString();

                            resultCafe.setText(cafe);

                        }

                    }
                } else {
                    resultCafe.setText("ERRO DE COMUNICAÇÃO");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("SUGESTION", "ERRO" + t.getMessage());
            }
        });
    }
    public void obterAlmoco2500(){
        Call<JsonObject> call = apiPlates.obterPratosAlmoco2500();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {
                        Log.d("JSON Recebido", jsonObject.toString());

                        JsonElement almoElement = jsonObject.get("ALMOCO");

                        if (almoElement != null && !almoElement.isJsonNull()) {
                            String almoco = almoElement.getAsJsonObject().get("ALMOCO").getAsString();
                            resultAlmoco.setText(almoco);

                        } else {
                            resultAlmoco.setText("ALMOCO não encontrado");
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("SUGESTION", "ERRO: " + t.getMessage());
            }
        });
    }
    public void obterJantar2500(){
        Call<JsonObject> call = apiPlates.obterPratosJantar2500();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {
                        Log.d("JSON Recebido", jsonObject.toString());

                        JsonElement jantaElement = jsonObject.get("JANTA");

                        if (jantaElement != null && !jantaElement.isJsonNull()) {
                            String janta = jantaElement.getAsJsonObject().get("JANTA").getAsString();
                            resultJanta.setText(janta);

                            Intent intent = new Intent(SugestPlates.this, plates.class);
                            intent.putExtra("almoco", resultAlmoco.getText().toString());
                            intent.putExtra("cafe", resultCafe.getText().toString());
                            intent.putExtra("janta", resultJanta.getText().toString());
                            startActivity(intent);
                        } else {
                            resultAlmoco.setText("JANTA não encontrado");
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
}

