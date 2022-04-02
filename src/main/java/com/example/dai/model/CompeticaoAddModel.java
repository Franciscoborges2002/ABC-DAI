package com.example.dai.model;

import com.example.dai.data.enums.Escalao;
import com.example.dai.data.enums.Genero;

public class CompeticaoAddModel {
    private String nomeCompeticao;
    private Escalao escalao;
    private Genero genero;
    private int numeroJornadas;
    private String epoca;

    public CompeticaoAddModel(String nomeCompeticao, Escalao escalao, Genero genero, int numeroJornadas, String epoca) {
        this.nomeCompeticao = nomeCompeticao;
        this.escalao = escalao;
        this.genero = genero;
        this.numeroJornadas = numeroJornadas;
        this.epoca = epoca;
    }

    public String getNomeCompeticao() {
        return nomeCompeticao;
    }

    public void setNomeCompeticao(String nomeCompeticao) {
        this.nomeCompeticao = nomeCompeticao;
    }

    public Escalao getEscalao() {
        return escalao;
    }

    public void setEscalao(Escalao escalao) {
        this.escalao = escalao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getNumeroJornadas() {
        return numeroJornadas;
    }

    public void setNumeroJornadas(int numeroJornadas) {
        this.numeroJornadas = numeroJornadas;
    }

    public String getEpoca() {
        return epoca;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }
}
