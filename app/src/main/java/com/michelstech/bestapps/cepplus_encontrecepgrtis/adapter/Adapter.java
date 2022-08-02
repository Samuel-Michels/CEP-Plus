package com.michelstech.bestapps.cepplus_encontrecepgrtis.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.michelstech.bestapps.cepplus_encontrecepgrtis.R;
import com.michelstech.bestapps.cepplus_encontrecepgrtis.model.PostsCep;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<PostsCep> listarCepFavoritos;

    public Adapter(List<PostsCep> lista) {
        this.listarCepFavoritos = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_cep_favorito, parent, false);


        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {

        PostsCep postsCep = listarCepFavoritos.get(position);
        holder.cep.setText(postsCep.getCep());
        holder.localidade.setText(postsCep.getLocalidade());
        holder.uf.setText(postsCep.getUf());

    }

    @Override
    public int getItemCount() {
        return this.listarCepFavoritos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView cep,
                localidade,
                uf;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cep = itemView.findViewById(R.id.textCep);
            localidade = itemView.findViewById(R.id.textLocalidade);
            uf = itemView.findViewById(R.id.textUf);

        }
    }
}
