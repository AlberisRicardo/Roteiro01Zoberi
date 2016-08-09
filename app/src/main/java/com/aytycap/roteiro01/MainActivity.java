package com.aytycap.roteiro01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ;
    private TextView saudacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saudacao=(TextView) findViewById(R.id.saudacao);
        Intent intent= getIntent();
        Bundle bundle= intent.getExtras();

        String nomeUsuario = bundle.getString("usuario");
        saudacao.setText("Bem vindo, " + nomeUsuario
         + "!");

    }
}
