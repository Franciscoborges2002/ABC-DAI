package com.example.dai.model;


public class PavilhaoEditModel {
    private String nomePavilhao;
    private String localizacao;
    private Long numeroDeTreinosPorHora;

    public PavilhaoEditModel(String nomePavilhao, String localizacao, Long numeroDeTreinosPorHora) {
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

    public Long getNumeroDeTreinosPorHora() {
        return numeroDeTreinosPorHora;
    }

    public void setNumeroDeTreinosPorHora(Long numeroDeTreinosPorHora) {
        this.numeroDeTreinosPorHora = numeroDeTreinosPorHora;
    }
}
