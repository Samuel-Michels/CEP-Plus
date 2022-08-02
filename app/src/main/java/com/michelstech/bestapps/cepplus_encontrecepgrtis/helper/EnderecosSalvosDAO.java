package com.michelstech.bestapps.cepplus_encontrecepgrtis.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.michelstech.bestapps.cepplus_encontrecepgrtis.model.PostsCep;

import java.util.ArrayList;
import java.util.List;

public class EnderecosSalvosDAO implements IEnderecosSalvosDAO{
    public static SQLiteDatabase escrever;
    public  SQLiteDatabase ler;

    public EnderecosSalvosDAO(Context context) {
        DbHelper db = new DbHelper(context);
        escrever = db.getWritableDatabase();
        ler = db.getReadableDatabase();
    }


    @Override
    public boolean salvar(PostsCep postsCep) {
        ContentValues cv = new ContentValues();
        cv.put("cep",postsCep.getCep());
        cv.put("logradouro",postsCep.getLogradouro());
        cv.put("complemento",postsCep.getComplemento());
        cv.put("bairro",postsCep.getBairro());
        cv.put("localidade",postsCep.getLocalidade());
        cv.put("uf",postsCep.getUf());
        cv.put("codibge",postsCep.getIbge());
        cv.put("codgia",postsCep.getGia());
        cv.put("ddd",postsCep.getDdd());
        cv.put("codsiafi",postsCep.getSiafi());

        try{
            escrever.insert(DbHelper.TABELA_TAREFAS, null, cv);
            Log.i("INFO", "SALVO C/ SUCESSO");
        }  catch (Exception e){
            Log.e("INFO", "ERRO AO SALVAR TAREFA" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deletar(PostsCep postsCep) {
        try{
            String[] args = {postsCep.getId().toString()};
            escrever.delete(DbHelper.TABELA_TAREFAS,"id=?",args);
        }  catch (Exception e){
            Log.e("INFO", "ERRO AO SALVAR TAREFA" + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public List<PostsCep> listar() {

        List<PostsCep> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS +" ;";
        Cursor c = ler.rawQuery(sql,null);

        while (c.moveToNext()){
            PostsCep postsCep = new PostsCep();

            Long id = c.getLong(c.getColumnIndex("id"));
            String cep = c.getString(c.getColumnIndex("cep"));
            String localidade = c.getString(c.getColumnIndex("localidade"));
            String uf = c.getString(c.getColumnIndex("uf"));


            postsCep.setId(id);
            postsCep.setCep(cep);
            postsCep.setLocalidade(localidade);
            postsCep.setUf(uf);
            tarefas.add(postsCep);

        }

        return tarefas;
    }
}
