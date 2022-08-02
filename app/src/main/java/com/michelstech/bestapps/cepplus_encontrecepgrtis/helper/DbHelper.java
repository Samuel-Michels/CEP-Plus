package com.michelstech.bestapps.cepplus_encontrecepgrtis.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static int VERSION= 1;
    public static String NOME_DB = "DB_ENDERECOS";
    public static String TABELA_TAREFAS = "enderecossalvos";

    public DbHelper(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " +
                TABELA_TAREFAS +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "cep VARCHAR(10)," +
                "logradouro VARCHAR(255)," +
                "complemento VARCHAR(255)," +
                "bairro VARCHAR(255)," +
                "localidade VARCHAR(255)," +
                "uf VARCHAR(2)," +
                "codibge VARCHAR(255)," +
                "codgia VARCHAR(255)," +
                "ddd VARCHAR(255)," +
                "codsiafi VARCHAR(255)); ";
        try{
            db.execSQL(sql);
            Log.i("INFO DB", "Tabela Criada");
        }   catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
