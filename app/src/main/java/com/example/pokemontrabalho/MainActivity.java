package com.example.pokemontrabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog load;

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
        GetJson download = new GetJson();
        //Chama Async Task
        download.execute();
    }

    public void trocarTela(PokemonObject pokemon) {
        //PASSA OBJETO PARA PARA O POKEMON ACTIVITY
        Intent intent = new Intent(this, pokemon.class);
        intent.putExtra("nome", pokemon.getNome());
        intent.putExtra("ataque", pokemon.getAtaque());
        intent.putExtra("vida", pokemon.getVida());
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
            Random random = new Random();
            int number;
            number = random.nextInt(20);
            //PEGA UM VALOR RANDOM DE 0 A 19
            return util.getInformacao("https://pokeapi.co/api/v2/type/" + number );
        }

        @Override
        protected void onPostExecute(PokemonObject pokemon){
              trocarTela(pokemon);

//            nome.setText(pessoa.getNome().substring(0,1).toUpperCase()+pessoa.getNome().substring(1));
//            sobrenome.setText(pessoa.getSobrenome().substring(0,1).toUpperCase()+pessoa.getSobrenome().substring(1));
//            email.setText(pessoa.getEmail());
//            endereco.setText(pessoa.getEndereco());
//            cidade.setText(pessoa.getCidade().substring(0,1).toUpperCase()+pessoa.getCidade().substring(1));
//            estado.setText(pessoa.getEstado());
//            username.setText(pessoa.getUsername());
//            senha.setText(pessoa.getSenha());
//            nascimento.setText(pessoa.getNascimento());
//            telefone.setText(pessoa.getTelefone());
//            foto.setImageBitmap(pessoa.getFoto());
//            load.dismiss();
        }
    }
}