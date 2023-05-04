package com.example.pokemontrabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerElementos = findViewById(R.id.spinner_elementos);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.elementos, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinnerElementos.setAdapter(adapter);

    }
}