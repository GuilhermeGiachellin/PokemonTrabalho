package com.example.pokemontrabalho;

import java.util.ArrayList;

public class PokemonObject {
    private String nome;
    private String tipo;
    private Integer ataque;
    private Integer vida;
    private ArrayList<HabilidadeObject> habilidades;

    public PokemonObject() {
        habilidades = new ArrayList<HabilidadeObject>();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }


    public ArrayList<HabilidadeObject> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<HabilidadeObject> habilidades) {
        this.habilidades.clear();
        this.habilidades.addAll(habilidades);
    }
}
