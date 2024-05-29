package br.edu.fecap.ntpfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class plates extends AppCompatActivity {
    private TextView textViewPrato, textViewAlmoco, textViewJanta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plates);

        textViewPrato = findViewById(R.id.resultPrato);
        textViewAlmoco = findViewById(R.id.resultAlmo);
        textViewJanta = findViewById(R.id.resultJanta);

        String cafe = getIntent().getStringExtra("cafe");
        String almoco = getIntent().getStringExtra("almoco");
        String janta = getIntent().getStringExtra("janta");

        textViewPrato.setText(cafe);
        textViewAlmoco.setText(almoco);
        textViewJanta.setText(janta);
    }

}