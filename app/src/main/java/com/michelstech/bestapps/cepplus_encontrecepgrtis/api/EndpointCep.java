package com.michelstech.bestapps.cepplus_encontrecepgrtis.api;

import com.michelstech.bestapps.cepplus_encontrecepgrtis.model.PostsCep;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EndpointCep {
    @GET("{cep}/json/")
    Call<PostsCep> recuperarCEP(@Path("cep") String cep);
}
