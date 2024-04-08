package br.edu.fecap.ntpfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class login extends AppCompatActivity {
    private EditText InputE;
    private EditText InputP;
    private String email , senha;
    private Button btnL;
    private API apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InputE = findViewById(R.id.InputEmail);
        InputP = findViewById(R.id.InputSenha);
        btnL = findViewById(R.id.btnLogin);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://scgtg9-3000.csb.app/login/").addConverterFactory(GsonConverterFactory.create()).build();
        apiService = retrofit.create(API.class);

        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = InputE.getText().toString();
                senha = InputP.getText().toString();


                String autoToken = createAutoToken(email, senha);
                CheckLogin(autoToken);

            }
        });
    }

    private void CheckLogin(String autoToken) {
        Retrofit retrofit = RetrofitClient.getRetrofitInstance();
        final API api = retrofit.create(API.class);

        Call<String> call = api.loginCheck(autoToken);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    if(response.body().isEmpty());
                    Toast.makeText(getApplicationContext(), "PREENCHA TODOS OS CAMPOS", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getApplicationContext(), "LOGIN BEM SUCEDIDO", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("TAG", t.toString());
                t.printStackTrace();
            }
        });
    }

    private String createAutoToken(String email, String senha) {
        byte[] data = new byte[0];
        try{
            data = (email + ":" + senha).getBytes("UTF-8");

        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return "BASIC " + Base64.encodeToString(data, Base64.NO_WRAP);
    }
}