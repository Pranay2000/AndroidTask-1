package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    EditText username;
    EditText password;
    Button login, register;
    String s1,s2;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        textToSpeech = new TextToSpeech(MainActivity.this, this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s1 = username.getText().toString();
                s2 = password.getText().toString();
                validateCredentials();
            }
        });
    }

    void validateCredentials() {
        if(s1.contentEquals("pranay1507") && s2.contentEquals("12345")) {
            Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
            textToSpeech.speak("Login Successful",TextToSpeech.QUEUE_ADD,null);
        } else {
            Toast.makeText(MainActivity.this,"Login failed", Toast.LENGTH_LONG).show();
            textToSpeech.speak("Login failed",TextToSpeech.QUEUE_ADD,null);
        }
    }

    @Override
    public void onInit(int i) {
        textToSpeech.setLanguage(Locale.ENGLISH);
        textToSpeech.setSpeechRate(0.8f);
    }
}