package com.example.pedroproyect;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class pregunta extends AppCompatActivity {

    ImageButton question, instagramButton, facebookButton;
    Button boton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);

        question = findViewById(R.id.imageButton7);
        instagramButton = findViewById(R.id.instagram_button);
        facebookButton = findViewById(R.id.facebook_button);

        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pregunta.this, MainActivity.class));
                finish();
            }
        });
        boton=findViewById(R.id.buttont);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pregunta.this, Terminos_con.class));
                finish();
            }
        });

        instagramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir Instagram
                openInstagram();
            }
        });

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFacebook();
            }
        });
    }

    private void openInstagram() {
        String instagramUrl = "https://www.instagram.com/materias_oficial_2024?igshid=MXdrcmQ3N2JxYWsxeQ==";
        Intent intent = new Intent(Intent.ACTION_VIEW, android.net.Uri.parse(instagramUrl));
        startActivity(intent);
    }

    private void openFacebook() {
        String facebookUrl = "https://www.facebook.com/profile.php?id=61560386948135&mibextid=ZbWKwL";
        Intent intent = new Intent(Intent.ACTION_VIEW, android.net.Uri.parse(facebookUrl));
        startActivity(intent);
    }
}