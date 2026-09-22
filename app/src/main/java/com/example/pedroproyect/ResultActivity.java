package com.example.pedroproyect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class ResultActivity extends AppCompatActivity {

    MaterialCardView inicio;
    TextView Rcorrectas, Rincorrectas, resultadoinf, result;
    ImageView resultadoimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        inicio = findViewById(R.id.volver);
        Rcorrectas = findViewById(R.id.rescorrectas);
        Rincorrectas = findViewById(R.id.resincorrectas);
        resultadoinf = findViewById(R.id.informacion);
        result = findViewById(R.id.resultadoo);
        resultadoimg = findViewById(R.id.resultadoimg);

        int correcto = getIntent().getIntExtra("correct", 0);
        int incorrecto = getIntent().getIntExtra("mal", 0);
        int puntos = correcto * 5;

        Rcorrectas.setText(String.valueOf(correcto));
        Rincorrectas.setText(String.valueOf(incorrecto));
        result.setText(String.valueOf(puntos));

        if (correcto >= 0 && correcto <= 2) {
            resultadoinf.setText("Tienes que hacer el cuestionario nuevamente");
            resultadoimg.setImageResource(R.drawable.triste);
        } else if (correcto >= 3 && correcto <= 5) {
            resultadoinf.setText("Tienes que intentarlo nuevamente");
            resultadoimg.setImageResource(R.drawable.neutro);
        } else if (correcto >= 6 && correcto <= 8) {
            resultadoinf.setText("Eres bueno, felicidades");
            resultadoimg.setImageResource(R.drawable.feliz);
        } else {
            resultadoinf.setText("Felicidades!!");
            resultadoimg.setImageResource(R.drawable.feliz);
        }

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}