package com.example.dai.model;

public class PavilhaoAddModel {
    private String nomePavilhao;
    private String localizacao;
    private int numeroDeTreinosPorHora;

    public PavilhaoAddModel(String nomePavilhao, String localizacao, int numeroDeTreinosPorHora) {
        this.nomePavilhao = nomePavilhao;
        this.localizacao = localizacao;
        this.numeroDeTreinosPorHora = numeroDeTreinosPorHora;
    }

    public String getNomePavilhao() {
        return nomePavilhao;
    }

    public void setNomePavilhao(String nomePavilhao) {
        this.nomePavilhao = nomePavilhao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getNumeroDeTreinosPorHora() {
        return numeroDeTreinosPorHora;
    }

    public void setNumeroDeTreinosPorHora(int numeroDeTreinosPorHora) {
        this.numeroDeTreinosPorHora = numeroDeTreinosPorHora;
    }
}
