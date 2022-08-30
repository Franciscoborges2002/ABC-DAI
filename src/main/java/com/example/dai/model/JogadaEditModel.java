package com.example.dai.model;

import com.example.dai.data.TipoJogada;

public class JogadaEditModel {
    private String nomeJogada;
    private String descricaoJogada;
    private TipoJogada tipoJogada;

    public JogadaEditModel() {
    }

    public JogadaEditModel(String nomeJogada, String descricaoJogada, TipoJogada tipoJogada) {
        this.nomeJogada = nomeJogada;
        this.descricaoJogada = descricaoJogada;
        this.tipoJogada = tipoJogada;
    }

    public String getNomeJogada() {
        return nomeJogada;
    }

    public void setNomeJogada(String nomeJogada) {
        this.nomeJogada = nomeJogada;
    }

    public String getDescricaoJogada() {
        return descricaoJogada;
    }

    public void setDescricaoJogada(String descricaoJogada) {
        this.descricaoJogada = descricaoJogada;
    }

    public TipoJogada getTipoJogada() {
        return tipoJogada;
    }

    public void setTipoJogada(TipoJogada tipoJogada) {
        this.tipoJogada = tipoJogada;
    }
}
