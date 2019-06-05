package com.gs.buscadi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.gs.buscadi.modelos.Usuario;

public class Cadastro extends AppCompatActivity {
    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtTelefone;
    private EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtNome = (EditText) findViewById(R.id.cd_nome);
        edtEmail = (EditText) findViewById(R.id.cd_email);
        edtTelefone = (EditText) findViewById(R.id.cd_telefone);
        edtSenha = (EditText) findViewById(R.id.cd_senhac);


    }


    private boolean validarcad() {
        boolean res = false;
        String nome = edtNome.getText().toString();
        String email = edtEmail.getText().toString();
        String telefone = edtTelefone.getText().toString();
        String senha = edtSenha.getText().toString();
        if (res = campovazio(nome)) {
            edtNome.requestFocus();


        } else if (res = campovazio(email)) {
            edtEmail.requestFocus();
        } else if (res = emailvalido(telefone)) {
            edtEmail.requestFocus();

        } else if (res = campovazio(telefone)) {
            edtTelefone.requestFocus();
        } else if (res = campovazio(senha)) {
            edtSenha.requestFocus();
        }
        if (res) {
            AlertDialog.Builder dig = new AlertDialog.Builder(this);
            dig.setTitle("Aviso");
            dig.setMessage("Há campos inválidos ou em branco!");
            dig.setNeutralButton("ok", null );
            dig.show();
            return false;

        }

        return true;
    }
    public void bt_cancelar(View view) {

        Intent intent3 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent3);






    }


    private boolean campovazio(String valor) {
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;
    }

    private boolean emailvalido(String email) {
        boolean resultado = (!campovazio(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        return resultado;
    }

    public void bt_cadastrar(View view) {
        if(validarcad()){
            Usuario usuario = new Usuario();
            usuario.setEmail(edtEmail.getText().toString());
            usuario.setNome(edtNome.getText().toString());
            usuario.setTelefone(edtTelefone.getText().toString());
            usuario.setSenha(edtSenha.getText().toString());
            String newUser = "INSERT INTO CLIENTE VALUES ('"+usuario.getNome()+"','','','')";
            DatabaseHelper dh = new DatabaseHelper();
            dh.inserirNovoUsuario(usuario);
            Intent intent3 = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent3);




    } }}





