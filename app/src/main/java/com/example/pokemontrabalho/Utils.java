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
            HabilidadeObject habilidade = new HabilidadeObject();
            JSONObject jsonObj = new JSONObject(json);

            pokemon.setNome(jsonObj.getString("name"));

            JSONArray array = jsonObj.getJSONArray("stats");
            //PEGA VIDA
            JSONObject objArray = array.getJSONObject(0);
            pokemon.setVida(objArray.getInt("base_stat"));
            //PEGA ATAQUE
            objArray = array.getJSONObject(1);
            pokemon.setAtaque(objArray.getInt("base_stat"));

            Log.i("STATS","NOME " + pokemon.getNome() +  " VIDA " + pokemon.getVida() + "  ATAQUE " + pokemon.getAtaque());



            return pokemon;
        }catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    private String parseJsonUrl(String json){
        try {
            Random random = new Random();
            int number;


            JSONObject jsonObj = new JSONObject(json);
            JSONArray array = jsonObj.getJSONArray("pokemon");
            //PEGA TAMANHO DA ARRAY DOS POKEMONS DENTRO DO JSON
            number = random.nextInt(array.length());

            JSONObject objArray = array.getJSONObject(number);

            JSONObject obj = objArray.getJSONObject("pokemon");

            return obj.getString("url");

        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }
}
