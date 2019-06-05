package com.gs.buscadi.Database;

public class ScriptDLL {

    public static String getCreateTablecliente(){
        StringBuilder sql = new StringBuilder();
      sql.append("CREATE TABLE IF NOT EXISTS CLIENTE( ");
      sql.append("CODIGO   INTERGER PRIMARY KEY AUTOINCREMENT NOT NULL,");
      sql.append("NOME     VARCHAR (40)  NOT NULL DEFAULT (''),");
      sql.append("EMAIL    VARCHAR (200) NOT NULL DEFAULT (''),");
      sql.append("TELEFONE VARCHAR (20)  NOT NULL DEFAULT ('') ) ");
        sql.append("TELEFONE VARCHAR (20)  NOT NULL DEFAULT ('') ) ");

      return  sql.toString();

    }
}
