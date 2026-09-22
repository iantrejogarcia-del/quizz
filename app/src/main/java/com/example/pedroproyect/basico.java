package com.example.pedroproyect;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class basico extends AppCompatActivity {

    TextView preguntatexto, respa1, respb2, respc3, respd4;
    List<preguntaselement> preguntaselements;
    int currenpreguntas = 0;
    int correcto = 0, erroneo = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basico);

        ImageButton backButton = findViewById(R.id.imageButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(basico.this, MainActivity.class));
                finish();
            }
        });
        preguntatexto = findViewById(R.id.textohist);
        respa1 = findViewById(R.id.respuesta1);
        respb2 = findViewById(R.id.respuesta2);
        respc3 = findViewById(R.id.respuesta3);
        respd4 = findViewById(R.id.respuesta4);

        loadAllQuestions();
        Collections.shuffle(preguntaselements);
        setQuestionScreen(currenpreguntas);

        View.OnClickListener answerClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView selectedAnswer = (TextView) v;
                checkAnswer(selectedAnswer);
                if (currenpreguntas < preguntaselements.size() - 1) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currenpreguntas++;
                            setQuestionScreen(currenpreguntas);
                            resetAnswers();
                        }
                    }, 500);
                } else {
                    Intent intent = new Intent(basico.this, ResultActivity.class);
                    intent.putExtra("correct", correcto);
                    intent.putExtra("mal", erroneo);
                    startActivity(intent);
                    finish();
                }
            }
        };

        respa1.setOnClickListener(answerClickListener);
        respb2.setOnClickListener(answerClickListener);
        respc3.setOnClickListener(answerClickListener);
        respd4.setOnClickListener(answerClickListener);
    }

    private void setQuestionScreen(int currenpreguntas) {
        preguntatexto.setText(preguntaselements.get(currenpreguntas).getPreguntas());
        respa1.setText(preguntaselements.get(currenpreguntas).getRespuesta1());
        respb2.setText(preguntaselements.get(currenpreguntas).getRespuesta2());
        respc3.setText(preguntaselements.get(currenpreguntas).getRespuesta3());
        respd4.setText(preguntaselements.get(currenpreguntas).getRespuesta4());
    }

    private void loadAllQuestions() {
        preguntaselements = new ArrayList<>();
        String jsonquiz = loadJsonFromAsset("historiapreguntas.json");
        try {
            JSONObject jsonObject = new JSONObject(jsonquiz);
            JSONArray preg = jsonObject.getJSONArray("Historiapreguntas");
            for (int i = 0; i < preg.length(); i++) {
                JSONObject pregu = preg.getJSONObject(i);

                String preguntastring = pregu.getString("preguntas");
                String respuesta1String = pregu.getString("respuesta1");
                String respuesta2String = pregu.getString("respuesta2");
                String respuesta3String = pregu.getString("respuesta3");
                String respuesta4String = pregu.getString("respuesta4");
                String correctoString = pregu.getString("correcto");

                preguntaselements.add(new preguntaselement(preguntastring, respuesta1String, respuesta2String, respuesta3String, respuesta4String, correctoString));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String loadJsonFromAsset(String s) {
        String json = "";
        try {
            InputStream inputStream = getAssets().open(s);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    private void checkAnswer(TextView selectedAnswer) {
        String answer = selectedAnswer.getText().toString();
        String correctAnswer = preguntaselements.get(currenpreguntas).getCorrect();

        if (answer.equals(correctAnswer)) {
            correcto++;
            selectedAnswer.setBackgroundResource(R.color.green);
            selectedAnswer.setTextColor(getResources().getColor(R.color.white));
        } else {
            erroneo++;
            selectedAnswer.setBackgroundResource(R.color.red);
            selectedAnswer.setTextColor(getResources().getColor(R.color.white));
        }
    }

    private void resetAnswers() {
        respa1.setBackgroundResource(android.R.color.white);
        respa1.setTextColor(getResources().getColor(android.R.color.black));
        respb2.setBackgroundResource(android.R.color.white);
        respb2.setTextColor(getResources().getColor(android.R.color.black));
        respc3.setBackgroundResource(android.R.color.white);
        respc3.setTextColor(getResources().getColor(android.R.color.black));
        respd4.setBackgroundResource(android.R.color.white);
        respd4.setTextColor(getResources().getColor(android.R.color.black));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(basico.this);
        materialAlertDialogBuilder.setTitle(R.string.app_name);
        materialAlertDialogBuilder.setMessage("Estas seguro de salir de el cuestionario?");
        materialAlertDialogBuilder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });
        materialAlertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                startActivity(new Intent(basico.this, MainActivity.class));
                finish();
            }
        });
        materialAlertDialogBuilder.show();
    }
}