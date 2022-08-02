package com.michelstech.bestapps.cepplus_encontrecepgrtis.helper;

import com.michelstech.bestapps.cepplus_encontrecepgrtis.model.PostsCep;

import java.util.List;

public interface IEnderecosSalvosDAO {

    public boolean salvar(PostsCep postsCep);

    public boolean deletar(PostsCep postsCep);

    public List<PostsCep> listar();

}
