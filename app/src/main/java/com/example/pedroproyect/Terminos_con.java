package com.example.pedroproyect;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Terminos_con extends AppCompatActivity {

    ImageButton question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminos_con);

        question = findViewById(R.id.imageButton77);
        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Terminos_con.this, pregunta.class));
                finish();
            }
        });
    }
}