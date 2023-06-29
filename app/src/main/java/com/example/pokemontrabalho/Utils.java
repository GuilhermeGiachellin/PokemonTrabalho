package com.example.pokemontrabalho;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {


    public PokemonObject getInformacao(String end){
        String json;
        PokemonObject novoPokemon = null;
        //recebe a string com o nome do pokemon
        json = NetworkUtils.getJSONFromAPI(end);
        Log.i("Resultado", json);
        novoPokemon = parseJsonNome(json,novoPokemon);
        
        //pega o resto do baile
        json = NetworkUtils.getJSONFromAPI("pokemon/" + novoPokemon.getNome());
        novoPokemon = parseJsonNome(json, novoPokemon);

        return novoPokemon;
    }

    private PokemonObject parseJsonNome(String json, PokemonObject novoPokemon){
        try {
            PokemonObject pokemon = new PokemonObject();

            JSONObject jsonObj = new JSONObject(json);
            JSONArray array = jsonObj.getJSONArray("results");

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date data;

            JSONObject objArray = array.getJSONObject(0);
//
            JSONObject obj = objArray.getJSONObject("user");
//            //Atribui os objetos que estão nas camadas mais altas
              pokemon.setNome(obj.getString("name"));
//            pessoa.setUsername(obj.getString("username"));
//            pessoa.setSenha(obj.getString("password"));
//            pessoa.setTelefone(obj.getString("phone"));
//            data = new Date(obj.getLong("dob")*1000);
//            pessoa.setNascimento(sdf.format(data));
//
//            //Nome da pessoa é um objeto, instancia um novo JSONObject
//            JSONObject nome = obj.getJSONObject("name");
//            pessoa.setNome(nome.getString("first"));
//            pessoa.setSobrenome(nome.getString("last"));
//
//            //Endereco tambem é um Objeto
//            JSONObject endereco = obj.getJSONObject("location");
//            pessoa.setEndereco(endereco.getString("street"));
//            pessoa.setEstado(endereco.getString("state"));
//            pessoa.setCidade(endereco.getString("city"));
//
//            //Pega coordenadas dentro de location
//            JSONObject coordenadas = obj.getJSONObject("coordinates");
//            pessoa.setLatitude(coordenadas.getLong("latitude"));
//            pessoa.setLongitude(coordenadas.getLong("longitude"));
//
//            //Imagem eh um objeto
//            JSONObject foto = obj.getJSONObject("picture");
//            pessoa.setFoto(baixarImagem(foto.getString("large")));

            return pokemon;
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }
}
