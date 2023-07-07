package com.example.pokemontrabalho;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class PokemonObject implements Parcelable {
    private String nome;
    private String tipo;
    private Integer ataque;
    private Integer vida;
    private ArrayList<HabilidadeObject> habilidades;

    public PokemonObject() {
        habilidades = new ArrayList<HabilidadeObject>();
    }

    protected PokemonObject(Parcel in) {
        nome = in.readString();
        tipo = in.readString();
        if (in.readByte() == 0) {
            ataque = null;
        } else {
            ataque = in.readInt();
        }
        if (in.readByte() == 0) {
            vida = null;
        } else {
            vida = in.readInt();
        }
    }

    public static final Creator<PokemonObject> CREATOR = new Creator<PokemonObject>() {
        @Override
        public PokemonObject createFromParcel(Parcel in) {
            return new PokemonObject(in);
        }

        @Override
        public PokemonObject[] newArray(int size) {
            return new PokemonObject[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeString(tipo);
        if (ataque == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(ataque);
        }
        if (vida == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(vida);
        }
    }
}
