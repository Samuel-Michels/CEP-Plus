package com.michelstech.bestapps.cepplus_encontrecepgrtis.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.michelstech.bestapps.cepplus_encontrecepgrtis.R;
import com.michelstech.bestapps.cepplus_encontrecepgrtis.adapter.Adapter;
import com.michelstech.bestapps.cepplus_encontrecepgrtis.helper.EnderecosSalvosDAO;
import com.michelstech.bestapps.cepplus_encontrecepgrtis.model.PostsCep;

import java.util.ArrayList;
import java.util.List;

public class FavoritoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<PostsCep> listarCepFavoritos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);




    }

    public void carregarListaFavorito(){
        EnderecosSalvosDAO enderecosSalvosDAO = new EnderecosSalvosDAO(getApplicationContext());
        listarCepFavoritos = enderecosSalvosDAO.listar();

        //Configurar Recycler View
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        Adapter adapter = new Adapter(listarCepFavoritos);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //recyclerView.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        carregarListaFavorito();
    }
}
