package com.example.dai.model;

import com.example.dai.data.Jogada;

public class JogadaDto {
    private Jogada jogada;
    private String mensagem;

    public JogadaDto() {
    }

    public JogadaDto(Jogada jogada, String mensagem) {
        this.jogada = jogada;
        this.mensagem = mensagem;
    }

    public JogadaDto(Jogada jogada) {
        this.jogada = jogada;
    }

    public JogadaDto(String mensagem) {
        this.mensagem = mensagem;
    }

    public Jogada getJogada() {
        return jogada;
    }

    public void setJogada(Jogada jogada) {
        this.jogada = jogada;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
