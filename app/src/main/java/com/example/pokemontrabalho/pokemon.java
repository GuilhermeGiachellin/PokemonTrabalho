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

public class pokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        LinearLayout containerHabilidades = findViewById(R.id.containerHabilidades);

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

    public void habilidadeButton(View v) {
        startActivity(new Intent(this, habilidade.class));

    }
}