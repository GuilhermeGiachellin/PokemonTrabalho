package com.example.pokemontrabalho;

public class PokemonObject {
    private String nome;
    private String descricao;
    private String tipo;
    private Integer ataque;
    private Integer vida;

    private HabilidadeObject habilidade;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public HabilidadeObject getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(HabilidadeObject habilidade) {
        this.habilidade = habilidade;
    }
}
