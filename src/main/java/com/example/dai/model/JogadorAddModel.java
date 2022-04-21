package com.example.dai.model;

import java.util.Date;

public class JogadorAddModel {
    private String nomeUtilizador;
    private String nomeCompleto;
    private String password;
    private Date dataNascimento;
    private String email;
    private String numeroTelemovel;

    public JogadorAddModel() {
    }

    public JogadorAddModel(String nomeUtilizador, String nomeCompleto, String password, Date dataNascimento, String email, String numeroTelemovel) {
        this.nomeUtilizador = nomeUtilizador;
        this.nomeCompleto = nomeCompleto;
        this.password = password;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.numeroTelemovel = numeroTelemovel;
    }

    public String getNomeUtilizador() {
        return nomeUtilizador;
    }

    public void setNomeUtilizador(String nomeUtilizador) {
        this.nomeUtilizador = nomeUtilizador;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelemovel() {
        return numeroTelemovel;
    }

    public void setNumeroTelemovel(String numeroTelemovel) {
        this.numeroTelemovel = numeroTelemovel;
    }
}
