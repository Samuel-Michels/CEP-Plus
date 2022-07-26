package com.michelstech.bestapps.cepplus_encontrecepgrtis.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.clans.fab.FloatingActionButton;
import com.michelstech.bestapps.cepplus_encontrecepgrtis.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirTelaPesquisa(View view){startActivity(new Intent(getApplicationContext(), PesquisarActivity.class));}
    public void abrirTelaFavorito(View view){startActivity(new Intent(getApplicationContext(), PesquisarActivity.class));}
    public void abrirTelaSaibaMais(View view){startActivity(new Intent(getApplicationContext(), PesquisarActivity.class));}

}