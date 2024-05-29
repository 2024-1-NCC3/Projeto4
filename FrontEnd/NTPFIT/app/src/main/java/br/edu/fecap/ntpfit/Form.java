package br.edu.fecap.ntpfit;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Form extends AppCompatActivity {
    TextView nameView;
    private ImageView pratos, foods;

    String nome, idade, email, telefone, peso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forms);

        nameView = findViewById(R.id.NameView);


        String nomeR = getIntent().getStringExtra("nome");

        nome = getIntent().getStringExtra("nome");
        idade = getIntent().getStringExtra("idade");
        peso = getIntent().getStringExtra("peso");
        email = getIntent().getStringExtra("email");
        telefone = getIntent().getStringExtra("telefone");

        nameView.setText(nomeR);
        pratos = findViewById(R.id.plate);
        foods = findViewById(R.id.SearchFood);

    }

    public void plates (View view){
        Intent intent = new Intent(Form.this, SugestPlates.class);
        startActivity(intent);
    }

    public void SearchFood(View view){
        Intent intent = new Intent(Form.this, FastFood.class);
        startActivity(intent);
    }
    public void Basal(View view){

        Intent intent = new Intent(Form.this, Basal.class);
        intent.putExtra("idade", idade);
        intent.putExtra("peso", peso);
        startActivity(intent);

        Log.d("CadastroActivity", "Dados enviados:  " + ", Idade: " + idade + ", Peso: " + peso);



    }
    public void User(View view ){
        Intent intent = new Intent(Form.this, ProfileShow.class);
        intent.putExtra("nome", nome);
        intent.putExtra("idade", idade);
        intent.putExtra("email", email);
        intent.putExtra("telefone", telefone);
        intent.putExtra("peso", peso);
        startActivity(intent);

        Log.d("profileshow", "Dados enviados:  " + ", Idade: " + idade + ", Peso: " + peso + "Nome" + nome + "telefone" + telefone + "email " + email);
    }
}