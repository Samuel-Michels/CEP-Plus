package com.michelstech.bestapps.cepplus_encontrecepgrtis.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.michelstech.bestapps.cepplus_encontrecepgrtis.R;
import com.michelstech.bestapps.cepplus_encontrecepgrtis.adapter.Adapter;
import com.michelstech.bestapps.cepplus_encontrecepgrtis.helper.EnderecosSalvosDAO;
import com.michelstech.bestapps.cepplus_encontrecepgrtis.model.PostsCep;
import com.michelstech.bestapps.cepplus_encontrecepgrtis.helper.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class FavoritoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<PostsCep> listarCepFavoritos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view,int position) {
                                Toast.makeText(getApplicationContext(),"click",Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(),"Long click",Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent,View view,int position,long id) {

                            }
                        }
                )
        );


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
