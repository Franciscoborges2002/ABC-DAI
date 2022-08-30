package com.example.dai.model;

import com.example.dai.data.Escalao;
import com.example.dai.data.Genero;

public class CompeticaoEditModel {
    private String urlFederacao;
    private String nomeCompeticao;
    private Escalao escalao;
    private Genero genero;
    private int numeroJornadas;
    private String epoca;

    public CompeticaoEditModel(String urlFederacao, String nomeCompeticao, Escalao escalao, Genero genero, int numeroJornadas, String epoca) {
        this.urlFederacao = urlFederacao;
        this.nomeCompeticao = nomeCompeticao;
        this.escalao = escalao;
        this.genero = genero;
        this.numeroJornadas = numeroJornadas;
        this.epoca = epoca;
    }

    public void setUrlFederacao(String urlFederacao) {
        this.urlFederacao = urlFederacao;
    }

    public void setNomeCompeticao(String nomeCompeticao) {
        this.nomeCompeticao = nomeCompeticao;
    }

    public void setEscalao(Escalao escalao) {
        this.escalao = escalao;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setNumeroJornadas(int numeroJornadas) {
        this.numeroJornadas = numeroJornadas;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    public String getUrlFederacao() {
        return urlFederacao;
    }

    public String getNomeCompeticao() {
        return nomeCompeticao;
    }

    public Escalao getEscalao() {
        return escalao;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getNumeroJornadas() {
        return numeroJornadas;
    }

    public String getEpoca() {
        return epoca;
    }
}
