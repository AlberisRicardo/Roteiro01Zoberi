package com.aytycap.roteiro01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CadastroActivity extends AppCompatActivity {

    private TextView nome;
    private TextView sobrenome;
    private TextView usuario;
    private TextView senha;
    private TextView confiSenha;
    private Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = (TextView) findViewById(R.id.nome);
        sobrenome = (TextView) findViewById(R.id.sobrenome);
        usuario = (TextView) findViewById(R.id.usuario);
        senha = (TextView) findViewById(R.id.senha);
        confiSenha = (TextView) findViewById(R.id.confiSenha);
        entrar = (Button) findViewById(R.id.btm);

        entrar.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          cadastrar();
                                      }
                                  }
        );
    }

    public void cadastrar() {
        String nnome = nome.getText().toString();
        String ssobrenome = sobrenome.getText().toString();
        String uusuario = usuario.getText().toString();
        String ssenha = senha.getText().toString();
        String cconfiSenha = confiSenha.getText().toString();

        View focus = null;
        if (TextUtils.isEmpty(nnome)) {
            nome.setError("Campo Vazio");
            focus = nome;
            focus.requestFocus();
        } else if (TextUtils.isEmpty(ssobrenome)) {
            sobrenome.setError("Campo Vazio");
            focus = sobrenome;
            focus.requestFocus();
        } else if (TextUtils.isEmpty(uusuario)) {
            usuario.setError("Campo Vazio");
            focus = usuario;
            focus.requestFocus();
        } else if (TextUtils.isEmpty(ssenha)) {
            senha.setError("Campo Vazio");
            focus = senha;
            focus.requestFocus();
        } else if (TextUtils.isEmpty(cconfiSenha)) {
            confiSenha.setError("Campo Vazio");
            focus = confiSenha;
            focus.requestFocus();
        } else {
            if (ssenha.equals(cconfiSenha)) {
                Intent intent = new Intent(this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("usuario", uusuario);
                intent.putExtras(bundle);

                startActivity(intent);

            }
            else{
                senha.setError("Senhas não compatíveis");
                confiSenha.setError("Senhas não compatíveis");
                focus= senha;
                focus.requestFocus();
                focus= confiSenha;

                focus.requestFocus();
                finish();
            }
        }



    }
}
