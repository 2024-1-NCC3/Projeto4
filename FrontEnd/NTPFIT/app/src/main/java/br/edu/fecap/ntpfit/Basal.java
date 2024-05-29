package br.edu.fecap.ntpfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Basal extends AppCompatActivity {

    private RadioButton Masc, Fem;
    private EditText inputA;
    private Button btn;
    private TextView result;

    private String idade, peso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basal);


        result = findViewById(R.id.resultBasal);
        Masc = findViewById(R.id.radioMasc);
        Fem = findViewById(R.id.radioFem);
        btn = findViewById(R.id.btnCalc);
        inputA = findViewById(R.id.alturaInput);


        Intent intent = getIntent();
        idade = intent.getStringExtra("idade");
        peso = intent.getStringExtra("peso");


        if (idade != null && peso != null) {
            btn.setOnClickListener(view -> {
                String alturaStr = inputA.getText().toString();
                if (!alturaStr.isEmpty()) {

                    double altura = Double.parseDouble(alturaStr);


                    int idadeInt = Integer.parseInt(idade);
                    double pesoDouble = Double.parseDouble(peso);

                    double tmb;


                    if (Masc.isChecked()) {
                        tmb = 88.36 + (13.4 * pesoDouble) + (4.8 * altura) - (5.7 * idadeInt);
                    } else {
                        tmb = 447.6 + (9.2 * pesoDouble) + (3.1 * altura) - (4.3 * idadeInt);
                    }


                    result.setText(String.format("SUA TMB É \n KCAL:  %.0f", tmb ));
                } else {

                    result.setText("POR FAVOR INSIRA A ALTURA");
                }
            });
        }

    }
    public void info(View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(android.R.drawable.ic_menu_info_details);

        dialog.setTitle("O que é a TAXA METABOLICA BASAL: ");
        dialog.setMessage("É A QUANTIDADE DE CALORIAS QUE SEU CORPO PRECISA PARA MANTER O ORGANISMO FUNCIONADO.\n " +
                "ENTÃO PARA EMAGRECER DE UMA FORMA SAUDAVEL VOCÊ PRECISA INGERIR MENOS CALORIAS QUE SEU CORPO PRECISA. \n " +
                "ENTÃO VOCE ENTRARÁ EM DEFICIT CALÓRICO, QUE É O PROCESSO QUE PARA REPOR AS ENERGIAS O ORGANISMO " +
                "COMEÇA A QUEIMAR GORDURA PARA MANTER O ORGANISMO VIVO.");

        dialog.setCancelable(true);

        dialog.show();
    }
}
