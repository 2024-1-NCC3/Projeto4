package br.edu.fecap.ntpfit;

import static br.edu.fecap.ntpfit.login.URL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;

import android.nfc.TagLostException;
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

public class cadastro extends AppCompatActivity {

    private EditText nome, Email, idade, telefone, peso, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = findViewById(R.id.InputName);
        Email = findViewById(R.id.inputEmail);
        telefone = findViewById(R.id.InputTel);
        idade = findViewById(R.id.InputIdade);
        peso = findViewById(R.id.InputPeso);
        senha = findViewById(R.id.InputPassword);
    }

    public void bntCadastroo(View view) {
        String email = this.Email.getText().toString();
        String senha = this.senha.getText().toString();
        String nome = this.nome.getText().toString();
        String telefone = this.telefone.getText().toString();
        String idade = this.idade.getText().toString();
        String peso = this.peso.getText().toString();

        if (email.isEmpty() || senha.isEmpty() || nome.isEmpty() || telefone.isEmpty() || idade.isEmpty() || peso.isEmpty()) {
            Toast.makeText(cadastro.this, "PREENCHA TODOS OS CAMPOS!", Toast.LENGTH_LONG).show();
        } else if (!email.contains("@")) {
            Toast.makeText(cadastro.this, "EMAIL INVALIDO", Toast.LENGTH_LONG).show();
        } else if (senha.length() < 8 || !senha.matches(".*\\d.*")) {
            Toast.makeText(cadastro.this, "SENHA PRECISA DE 8 CARACTERES OU MAIS E PELO MENOS 1 NUMERO", Toast.LENGTH_LONG).show();
        } else if (telefone.length() != 11) {
            Toast.makeText(cadastro.this, "TELEFONE INVALIDO, POR FAVOR INSIRA UM NUMERO DE CELULAR COM O CODIGO DE SEU ESTADO OU CIDADE", Toast.LENGTH_LONG).show();
        } else if (idade.length() > 2) {
            Toast.makeText(cadastro.this, "IDADE", Toast.LENGTH_LONG).show();
        }   else {
            User user = new User(nome, idade, telefone, peso, email, senha);

            Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();

            APIUsers apiUsers = retrofit.create(APIUsers.class);

            Call<Void> call = apiUsers.insertUsers(user);


            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(cadastro.this, "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                        Log.d("CADASTRO", "CONECTOU AO SERVIDOR");
                        Intent intent = new Intent(cadastro.this, Form.class);

                        intent.putExtra("nome", nome);
                        intent.putExtra("idade", idade);
                        intent.putExtra("email", email);
                        intent.putExtra("telefone", telefone);
                        intent.putExtra("peso", peso);

                        startActivity(intent);
                    } else {
                        Toast.makeText(cadastro.this, "Falha ao cadastrar usuário Algum campo ja existente em nosso sistema!", Toast.LENGTH_LONG).show();
                        String errorMessage = "Falha ao cadastrar usuário. Código de erro: " + response.code();
                        Log.e("CADASTRO", errorMessage);
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Log.e("CADASTRO", "Erro: " + t.getMessage());
                    Toast.makeText(cadastro.this, "Erro ao cadastrar usuário", Toast.LENGTH_LONG).show();
                }
            });







        }
    }
}
