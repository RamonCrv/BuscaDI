package com.gs.buscadi;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gs.buscadi.Database.DadosOpenHelper;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase conexao;

    private DadosOpenHelper dadosOpenHelper;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                TextView tLogin = (TextView) findViewById(R.id.tLogin);
                TextView tSenha = (TextView) findViewById(R.id.tSenha);
                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();
                if (login.equals("pedro")&&senha.equals("123")){
                    alert("login realizado com sucesso");
                    Intent intent1 = new Intent(getApplicationContext(),User_menu.class);
                    startActivity(intent1);
                    {



                    }
                }else{
                    alert("Login ou Senha Incorretos");
                }


            }
        });


}                private void alert(String s){
            Toast.makeText(this,s,Toast.LENGTH_LONG).show();


    }public void Gocadastro(View view){
        Intent intent2 = new Intent(getApplicationContext(),Cadastro.class);
        startActivity(intent2);}

    private void criarConexao(){
        try{
dadosOpenHelper = new DadosOpenHelper(this);
conexao = dadosOpenHelper.getWritableDatabase();

        }catch (SQLException ex) {

        }

    }
    }













