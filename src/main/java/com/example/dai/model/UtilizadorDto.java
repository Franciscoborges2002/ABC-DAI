package com.example.dai.model;

//DTO = Data Transfer Object

import com.example.dai.data.Utilizador;

public class UtilizadorDto {
    private Utilizador utilizador;
    private String mensagem;
    private String tipoUtilizador;

    public UtilizadorDto(String mensagem) {
        this.mensagem = mensagem;
    }

    public UtilizadorDto(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public UtilizadorDto(String mensagem, String tipoUtilizador) {
        this.mensagem = mensagem;
        this.tipoUtilizador = tipoUtilizador;
    }

    public UtilizadorDto(Utilizador utilizador, String tipoUtilizador) {
        this.utilizador = utilizador;
        this.tipoUtilizador = tipoUtilizador;
    }

    public UtilizadorDto(Utilizador utilizador, String mensagem, String tipoUtilizador) {
        this.utilizador = utilizador;
        this.mensagem = mensagem;
        this.tipoUtilizador = tipoUtilizador;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTipoUtilizador() {
        return tipoUtilizador;
    }

    public void setTipoUtilizador(String tipoUtilizador) {
        this.tipoUtilizador = tipoUtilizador;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
}
