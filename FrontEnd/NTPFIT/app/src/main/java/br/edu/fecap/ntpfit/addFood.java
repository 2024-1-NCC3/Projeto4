package br.edu.fecap.ntpfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class addFood extends AppCompatActivity {

        EditText nome, kcal;

        public String url = "http://192.168.15.9:8081";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        nome = findViewById(R.id.textNomeAlimento);
        kcal = findViewById(R.id.textKcalAlimentos);
    }

    public void add(View view){
        String nome = this.nome.getText().toString();
        String kcal = this.kcal.getText().toString();

        if(nome.isEmpty() || kcal.isEmpty()){
            Toast.makeText(addFood.this, "PREENCHA TODOS OS CAMPOS", Toast.LENGTH_LONG).show();
        }else{
            Alimentos alimentos = new Alimentos(nome, kcal);

            Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

            APIaddFF apiAdd = retrofit.create(APIaddFF.class);

            Call<Void> call = apiAdd.insertFood(alimentos);
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(addFood.this, "ALIMENTO ADICIONADO COM SUCESSO!", Toast.LENGTH_LONG).show();
                        Log.d("ADDFOOD", "ALIMENTO CADASTRADO");
                    }else{
                        Toast.makeText(addFood.this, "FALHA AO CADASTRAR ALIMENTO!", Toast.LENGTH_LONG).show();
                        String erromsg = "FALHA AO CADASTRAR ALIMENTO " + response.code();
                        Log.e("ADDFOOD",erromsg);
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Log.e("CADASTRO", "Erro: " + t.getMessage());
                    Toast.makeText(addFood.this, "Erro ao cadastrar usuário", Toast.LENGTH_LONG).show();
                }
            });


        }
    }
}