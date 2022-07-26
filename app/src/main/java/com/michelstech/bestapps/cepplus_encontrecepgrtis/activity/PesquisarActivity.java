package com.michelstech.bestapps.cepplus_encontrecepgrtis.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.michelstech.bestapps.cepplus_encontrecepgrtis.R;
import com.michelstech.bestapps.cepplus_encontrecepgrtis.api.EndpointCep;
import com.michelstech.bestapps.cepplus_encontrecepgrtis.model.PostsCep;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PesquisarActivity extends AppCompatActivity {
    EditText editNumeroCep;
    Button buttonPesquisar;
    TextView textCepResultado,
            textLogradouroResultado,
            textComplementoResultado,
            textBairroResultado,
            textLocalidadeResultado,
            textUfResultado,
            textIbgeResultado,
            textDddResultado,
            textGiaResultado,
            textSiafiResultado;

    private Retrofit retrofit;

    String urlCep = "https://viacep.com.br/ws/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar);

        //indexando conteudo da activity
        editNumeroCep = findViewById(R.id.editNumeroCep);
        buttonPesquisar = findViewById(R.id.buttonPesquisar);


        textCepResultado = findViewById(R.id.textCepResultado);
        textLogradouroResultado = findViewById(R.id.textLogradouroResultado);
        textComplementoResultado = findViewById(R.id.textComplementoResultado);
        textBairroResultado = findViewById(R.id.textBairroResultado);
        textLocalidadeResultado = findViewById(R.id.textLocalidadeResultado);
        textUfResultado = findViewById(R.id.textUfResultado);
        textIbgeResultado = findViewById(R.id.textIbgeResultado);
        textDddResultado = findViewById(R.id.textDddResultado);
        textGiaResultado = findViewById(R.id.textGiaResultado);
        textSiafiResultado = findViewById(R.id.textSiafiResultado);

        buttonPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringNumeroCep = editNumeroCep.getText().toString();

                if (validaEditCampoCep(stringNumeroCep)){
                    recuperarCepRetrofit(stringNumeroCep);
                } else {
                    Toast.makeText(getApplicationContext(),"Gentileza, Inserir um cep válido de 8 digítos!",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    public Boolean validaEditCampoCep(String dado){

        Integer numeroCaracteres = dado.length();

        if (numeroCaracteres == 8){
            return true;
        }

        return false;
    }

    public void recuperarCepRetrofit(String dado){
        retrofit = new Retrofit.Builder()
                .baseUrl(urlCep)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EndpointCep endpointCep = retrofit.create(EndpointCep.class);

        Call<PostsCep> call = endpointCep.recuperarCEP(dado);

        call.enqueue(new Callback<PostsCep>() {
            @Override
            public void onResponse(Call<PostsCep> call,Response<PostsCep> response) {
                PostsCep getgsonRespostaRestrofitbody = response.body();

                textCepResultado.setText(getgsonRespostaRestrofitbody.getCep());
                textLogradouroResultado.setText(getgsonRespostaRestrofitbody.getLogradouro());
                textComplementoResultado.setText(getgsonRespostaRestrofitbody.getComplemento());
                textBairroResultado.setText(getgsonRespostaRestrofitbody.getBairro());
                textLocalidadeResultado.setText(getgsonRespostaRestrofitbody.getLocalidade());
                textUfResultado.setText(getgsonRespostaRestrofitbody.getUf());
                textIbgeResultado.setText(getgsonRespostaRestrofitbody.getIbge());
                textDddResultado.setText(getgsonRespostaRestrofitbody.getDdd());
                textGiaResultado.setText(getgsonRespostaRestrofitbody.getGia());
                textSiafiResultado.setText(getgsonRespostaRestrofitbody.getSiafi());
            }

            @Override
            public void onFailure(Call<PostsCep> call,Throwable t) {

            }
        });


    }

}