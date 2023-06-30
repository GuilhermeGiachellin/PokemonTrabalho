package com.example.pokemontrabalho;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils {


    public PokemonObject getInformacao(String end){
        String url = "";
        String json;
        PokemonObject novoPokemon = null;
        //recebe a string com o nome do pokemon
        json = NetworkUtils.getJSONFromAPI(end);
        url = parseJsonUrl(json);

        //pega o resto do baile
        json = NetworkUtils.getJSONFromAPI(url);
        novoPokemon = parseJsonPokemon(json);

        return novoPokemon;
    }

    public PokemonObject parseJsonPokemon(String json) {
        try {
            PokemonObject pokemon = new PokemonObject();
            JSONObject jsonObj = new JSONObject(json);

            pokemon.setNome(jsonObj.getString("name"));
            Log.i("COME CASADAAAAAAAAAAAAAAA", pokemon.getNome());

            return pokemon;
        }catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    private String parseJsonUrl(String json){
        try {

            int min = 1;
            int max = 20;

            JSONObject jsonObj = new JSONObject(json);
            JSONArray array = jsonObj.getJSONArray("pokemon");

            JSONObject objArray = array.getJSONObject(1 );
            JSONObject obj = objArray.getJSONObject("pokemon");

//            new Random().nextInt(max - min + 1) + min

            return obj.getString("url");

        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }
}
