package com.gs.buscadi.modelos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.gs.buscadi.Database.DadosOpenHelper;

import java.util.ArrayList;

public class Usuario {
    public int getCodigo() {
        return codigo;
    }

    private int codigo;
    private String nome;
    private String telefone;
    private String email;
    private String senha;


    public Usuario(Context context){
        this.context = context;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private byte[] imagem;
    private Context context;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public boolean salvar() {
        DadosOpenHelper dadosOpenHelper = null;
        SQLiteDatabase sqLiteDatabase = null;
        String sql = "";

        try {
            dadosOpenHelper = new DadosOpenHelper(context);
            sqLiteDatabase = dadosOpenHelper.getWritableDatabase();
            if (codigo == -1) {
                sql = "INSERT INTO usuario (nome,email,senha,telefone,imagem) VALUES (?,?,?,?,?)";
            } else {

            }
            sqLiteDatabase.beginTransaction();
            SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);
            sqLiteStatement.clearBindings();
            sqLiteStatement.bindString(1,nome);
            sqLiteStatement.bindString(2,email);
            sqLiteStatement.bindString(3,senha);
            sqLiteStatement.bindString(4,telefone);
            sqLiteStatement.bindBlob(5, imagem);
            if (codigo != -1){
                sqLiteStatement.bindString(6,String.valueOf(codigo));
                sqLiteStatement.executeInsert();
                sqLiteDatabase.setTransactionSuccessful();
                sqLiteDatabase.endTransaction();
            }


            sqLiteDatabase.setTransactionSuccessful();
            sqLiteDatabase.endTransaction();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            sqLiteDatabase.endTransaction();
            return false;
        } finally {

            if (sqLiteDatabase != null) ;
            sqLiteDatabase.close();
            if (dadosOpenHelper != null) ;
            dadosOpenHelper.close();

        }
    }






    public ArrayList<Usuario> getUsuarios() {
        DadosOpenHelper dadosOpenHelper = null;
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try{
            dadosOpenHelper = new DadosOpenHelper(context);
            sqLiteDatabase = dadosOpenHelper.getReadableDatabase();
            cursor = sqLiteDatabase.query("usuario",null,null,null,null,null,null);
            while (cursor.moveToNext());
            Usuario usuario = new Usuario(context);
            usuario.codigo = cursor.getInt(cursor.getColumnIndex("codigo"));
            usuario.nome = cursor.getString(cursor.getColumnIndex("nome"));
            usuario.senha = cursor.getString(cursor.getColumnIndex("senha"));
            usuario.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            usuario.setImagem(cursor.getBlob(cursor.getColumnIndex("imagem")));
            usuarios.add(usuario);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((cursor != null) && (!cursor.isClosed()));
            cursor.close();
            if (sqLiteDatabase != null);
            sqLiteDatabase.close();
            if (dadosOpenHelper != null);
            dadosOpenHelper.close();

        }
        return usuarios;
    }


}
