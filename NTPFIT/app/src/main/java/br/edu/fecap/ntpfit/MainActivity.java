package br.edu.fecap.ntpfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMenu = findViewById(R.id.btnContinuar);

    }
    public void Continuar (View view){
        Intent intent = new Intent(MainActivity.this, login.class);
        startActivity(intent);
    }
}