package br.edu.fecap.ntpfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileShow extends AppCompatActivity {

    TextView nomeR, idadeR, emailR, telefoneR, pesoR;

    private String nome, idade, email, telefone, peso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_show);

        nomeR = findViewById(R.id.textViewNome);
        idadeR = findViewById(R.id.textViewIdade);
        emailR = findViewById(R.id.textViewEmail);
        telefoneR = findViewById(R.id.textViewTelefone);
        pesoR = findViewById(R.id.textViewPeso);


        nome = getIntent().getStringExtra("nome");
        idade = getIntent().getStringExtra("idade");
        peso = getIntent().getStringExtra("peso");
        telefone = getIntent().getStringExtra("telefone");
        email = getIntent().getStringExtra("email");

        nomeR.setText(nome);
        idadeR.setText(idade);
        emailR.setText(email);
        telefoneR.setText(telefone);
        pesoR.setText(peso);



    }
    public void Edit(View view){
        Intent intent = new Intent(ProfileShow.this, Form.class);
        intent.putExtra("nome", nome);
        intent.putExtra("idade", idade);
        intent.putExtra("email", email);
        intent.putExtra("telefone", telefone);
        intent.putExtra("peso", peso);
        startActivity(intent);
    }

}