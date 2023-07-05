package com.example.pokemontrabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class pokemon extends AppCompatActivity {

    private TextView nome;
    private TextView vida;
    private TextView ataque;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        LinearLayout containerHabilidades = findViewById(R.id.containerHabilidades);

        Bundle bundle = getIntent().getExtras();
        coletarIds();
        popularCampos(bundle);

        //Buttons criados dinamicamente baseado na quantia de habilidades
        for (int i = 1; i <= 8; i++) {
            Button button = new Button(this);
            button.setText("Button " + String.valueOf(i));
            button.setId(i);
            button.setTag("habilidadeButton" + String.valueOf(i));

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    habilidadeButton(v);
                }

             });
            containerHabilidades.addView(button);
        }
    }

    public void coletarIds() {
        nome = (TextView)findViewById(R.id.textNome);
        vida = (TextView)findViewById(R.id.textVida);
        ataque = (TextView)findViewById(R.id.textAtaque);
    }

    public void popularCampos(Bundle bundle) {
        nome.setText(bundle.getString("nome"));
        vida.setText("Vida: " + bundle.getInt("vida"));
        ataque.setText("Ataque: " + bundle.getInt("ataque"));
    }

    public void habilidadeButton(View v) {
        startActivity(new Intent(this, habilidade.class));
    }
}