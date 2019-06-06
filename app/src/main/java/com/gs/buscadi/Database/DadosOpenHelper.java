package com.gs.buscadi.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DadosOpenHelper extends SQLiteOpenHelper {
    public DadosOpenHelper( Context context) {
        super(context, "DADOS", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( ScriptDLL.getCreateTablecliente());
        db.execSQL("CREATE TABLE Usuario(\n" +
                "   CODIGO   INT PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "   NOME     VARCHAR (40)  NOT NULL ,\n" +
                "   EMAIL    VARCHAR (40)  NOT NULL ,\n" +
                "   TELEFONE VARCHAR (13)  NOT NULL ,\n" +
                "   IMAGEM   BLOB          NOT NULL  \n" +
                "   );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }







    }


