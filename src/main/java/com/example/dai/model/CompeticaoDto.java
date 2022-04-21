package com.example.dai.model;

import com.example.dai.data.Competicao;

public class CompeticaoDto {
    private String mensagem;
    private String nomeCompeticao;
    private Competicao competicao;

    public CompeticaoDto(String mensagem) {
        this.mensagem = mensagem;
    }

    public CompeticaoDto(String mensagem, String nomeCompeticao) {
        this.mensagem = mensagem;
        this.nomeCompeticao = nomeCompeticao;
    }

    public CompeticaoDto(String mensagem, Competicao competicao) {
        this.mensagem = mensagem;
        this.competicao = competicao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeCompeticao() {
        return nomeCompeticao;
    }

    public void setNomeCompeticao(String nomeCompeticao) {
        this.nomeCompeticao = nomeCompeticao;
    }

    public Competicao getCompeticao() {
        return competicao;
    }

    public void setCompeticao(Competicao competicao) {
        this.competicao = competicao;
    }
}
