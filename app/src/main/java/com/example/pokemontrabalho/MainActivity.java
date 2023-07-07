package com.example.pokemontrabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog load;
    private Spinner valorSpinner;
    private Integer posicaoType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerElementos = findViewById(R.id.spinner_elementos);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.elementos, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinnerElementos.setAdapter(adapter);


    }


    public void pesquisarButton(View v) {
        valorSpinner = (Spinner) findViewById(R.id.spinner_elementos);
        posicaoType = valorSpinner.getSelectedItemPosition() - 1;
        if(posicaoType >= 0) {
            GetJson download = new GetJson();
            //Chama Async Task
            download.execute();
        }
    }

    public void trocarTela(PokemonObject pokemon) {
        //PASSA OBJETO PARA PARA O POKEMON ACTIVITY
        Intent intent = new Intent(this, pokemon.class);
        intent.putExtra("pokemon", pokemon);

        //PUT EXTRA PARA COLOCAR AS INFORMAÇÕES COLETADAS DAS HABILIDADE
        for(int i = 0; i < pokemon.getHabilidades().size(); i++) {
            intent.putExtra("nomeHabilidade" + i, "" + pokemon.getHabilidades().get(i).getNome());
            intent.putExtra("urlHabilidade" + i, "" + pokemon.getHabilidades().get(i).getUrl());
        }
        intent.putExtra("tamanhoArray", pokemon.getHabilidades().size());
        startActivity(intent);
    }


    private class GetJson extends AsyncTask<Void, Void, PokemonObject> {


        @Override
        protected void onPreExecute(){
            load = ProgressDialog.show(MainActivity.this,
                    "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        }

        @Override
        protected PokemonObject doInBackground(Void... params) {
            Utils util = new Utils();
            //PEGA O VALOR DA POSICAO DO SPINNER E CONCATENA NO URL
            return util.getInformacao("https://pokeapi.co/api/v2/type/" + posicaoType );
        }

        @Override
        protected void onPostExecute(PokemonObject pokemon) {
              trocarTela(pokemon);
              load.dismiss();
        }
    }
}