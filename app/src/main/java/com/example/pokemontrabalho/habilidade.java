package com.example.pokemontrabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class habilidade extends AppCompatActivity {

    private TextView nome;
    private TextView descricao;
    private TextView efeito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habilidade);



        coletarIds();
        popularCampos();
    }

    public void coletarIds() {
        nome = (TextView)findViewById(R.id.textNome);
        descricao = (TextView)findViewById(R.id.textDescricao);
        efeito = (TextView)findViewById(R.id.textEfeito);
    }

    public void popularCampos() {
        Bundle bundle = getIntent().getExtras();
        nome.setText(bundle.getString("nome"));
        descricao.setText(bundle.getString("descricao"));
        efeito.setText(bundle.getString("efeito"));
    }
}