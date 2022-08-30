package com.example.dai.model;


import com.example.dai.data.TipoJogada;
import org.springframework.stereotype.Service;

@Service
public class JogadaAddModel {
    private String nomeJogada;
    private String descricaoJogada;
    private TipoJogada tipoJogada;

    public JogadaAddModel() {
    }

    public JogadaAddModel(String nomeJogada, String descricaoJogada, TipoJogada tipoJogada) {
        this.nomeJogada = nomeJogada;
        this.descricaoJogada = descricaoJogada;
        this.tipoJogada = tipoJogada;
    }

    public TipoJogada getTipoJogada() {
        return tipoJogada;
    }

    public void setTipoJogada(TipoJogada tipoJogada) {
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
}
