package com.example.pokemontrabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class pokemon extends AppCompatActivity {

    private ProgressDialog load;
    private TextView nome;
    private TextView vida;
    private TextView ataque;
    private LinearLayout containerHabilidades;
    private ArrayList<String> nomeHabilidades = new ArrayList<>();
    private ArrayList<String> urlHabilidades = new ArrayList<>();
    private int tamanhoArray = 0;
    private int posicaoBotao = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        containerHabilidades = findViewById(R.id.containerHabilidades);
        //OBJETO POKEMON É PEGO COM O GETPARCEBLEEXTRA
        PokemonObject pokemon = getIntent().getParcelableExtra("pokemon");
        coletarIds();
        coletarHabilidades();
        popularCampos(pokemon);
    }

    public void coletarHabilidades() {
        Bundle bundle = getIntent().getExtras();
        tamanhoArray = bundle.getInt("tamanhoArray");

        for(int i = 0; i < tamanhoArray; i++) {
            nomeHabilidades.add(bundle.getString("nomeHabilidade" + i));
            urlHabilidades.add(bundle.getString("urlHablidade" + i));
        }
    }


    public void coletarIds() {
        nome = (TextView)findViewById(R.id.textNome);
        vida = (TextView)findViewById(R.id.textVida);
        ataque = (TextView)findViewById(R.id.textAtaque);
    }

    public void popularCampos(PokemonObject pokemon) {
        nome.setText(pokemon.getNome());
        vida.setText("Vida: " + pokemon.getVida());
        ataque.setText("Ataque: " + pokemon.getAtaque());
        criarBotoes(pokemon);
    }

    public void criarBotoes(PokemonObject pokemon) {
        //Buttons criados dinamicamente baseado na quantia de habilidades

        for (int i = 0; i < tamanhoArray; i++) {
            Button button = new Button(this);
            button.setText(nomeHabilidades.get(i));
            button.setId(i);
            button.setTag(urlHabilidades.get(i));

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    habilidadeButton(v);
                }

            });
            containerHabilidades.addView(button);
        }
    }

    public void habilidadeButton(View v) {
        //PEGA A ID DO BOTAO CLICADO
        posicaoBotao = v.getId();
        //CHAMA A TASK ASYNC
        //PEGA O VALOR DA POSICAO DO SPINNER E CONCATENA NO URL
        Log.i("URL DO KCT", urlHabilidades.get(posicaoBotao));
        pokemon.GetJson download = new pokemon.GetJson();
        download.execute();


    }

    public void trocarTela(HabilidadeObject habilidade) {
        //MANADA HABILIDADE NOVA CRIADA PARA A ACTIVITY HABILIDADE
        Intent intent = new Intent(this, pokemon.class);
        intent.putExtra("nome", habilidade.getNome());
        intent.putExtra("descricao", habilidade.getDescricao());
        intent.putExtra("efeito", habilidade.getEfeito());

//        startActivity(intent);
    }

    private class GetJson extends AsyncTask<Void, Void, HabilidadeObject> {


        @Override
        protected void onPreExecute(){
            load = ProgressDialog.show(pokemon.this,
                    "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        }

        @Override
        protected HabilidadeObject doInBackground(Void... params) {
            Utils util = new Utils();

            return util.getInformacaoHabilidade(urlHabilidades.get(posicaoBotao));
        }

        @Override
        protected void onPostExecute(HabilidadeObject habilidade) {
           trocarTela(habilidade);
           load.dismiss();

        }
    }
}