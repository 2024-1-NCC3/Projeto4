package br.edu.fecap.ntpfit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class login extends AppCompatActivity {
    private EditText InputE;
    private EditText InputP;

    public static String URL = "http://192.168.15.8:8081";
    private br.edu.fecap.ntpfit.LoginRequest LoginRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InputE = findViewById(R.id.InputEmail);
        InputP = findViewById(R.id.InputSenha);




    }
    public void loginbtnc (View view) {
        String email = InputE.getText().toString();
        String senha = InputP.getText().toString();

        if(email.isEmpty() || senha.isEmpty()){
            Toast.makeText(login.this, "PREENCHA TODOS OS CAMPOS!!", Toast.LENGTH_LONG).show();
        }else{
            LoginRequest loginRequest = new LoginRequest(email, senha);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                    .build();;

            APILogin apiLogin = retrofit.create(APILogin.class);

            Call<JsonObject> call = apiLogin.loginReq(loginRequest);
            call.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if (response.isSuccessful() && response.body() !=null){
                        JsonObject jsonObject = response.body();
                        Log.d("JSON", "Resposta JSON: " + jsonObject.toString());


                        String message = jsonObject.get("message").getAsString();
                        JsonObject userInfoObject = jsonObject.getAsJsonObject("userInfo");
                        String nome = userInfoObject.get("nome").getAsString();
                        String idade = userInfoObject.get("idade").getAsString();
                        String telefone = userInfoObject.get("telefone").getAsString();
                        String peso = userInfoObject.get("peso").getAsString();


                        Toast.makeText(getApplicationContext(), "Login bem-sucedido", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(login.this, Form.class);
                        intent.putExtra("nome", nome);
                        intent.putExtra("idade", idade);
                        intent.putExtra("email", email);
                        intent.putExtra("telefone", telefone);
                        intent.putExtra("peso", peso);
                        startActivity(intent);

                    }else{
                        Toast.makeText(getApplicationContext(), "Credenciais inválidas", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {
                    Log.e("LOGIN", "ERRO: " + t.getMessage());
                }
            });

        }
    }
    public void btnCadastro(View view){
        Intent intent = new Intent(login.this, cadastro.class);
        startActivity(intent);
    }
}