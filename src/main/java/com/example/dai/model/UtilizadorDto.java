package com.example.dai.model;

//DTO = Data Transfer Object

public class UtilizadorDto {
    private String mensagem;
    private String tipoUtilizador;

    public UtilizadorDto(String mensagem) {
        this.mensagem = mensagem;
    }

    public UtilizadorDto(String mensagem, String tipoUtilizador) {
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
}
