package com.example.pokemontrabalho;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class HabilidadeObject implements Parcelable {
    private String nome;
    private String url;

    private String descricao;

    private String efeito;


    protected HabilidadeObject(Parcel in) {
        nome = in.readString();
        url = in.readString();
        descricao = in.readString();
        efeito = in.readString();
    }

    public static final Creator<HabilidadeObject> CREATOR = new Creator<HabilidadeObject>() {
        @Override
        public HabilidadeObject createFromParcel(Parcel in) {
            return new HabilidadeObject(in);
        }

        @Override
        public HabilidadeObject[] newArray(int size) {
            return new HabilidadeObject[size];
        }
    };

    public HabilidadeObject() {

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEfeito() {
        return efeito;
    }

    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeString(url);
        parcel.writeString(descricao);
        parcel.writeString(efeito);
    }
}
