package com.example.dai.model;

import java.util.Date;

public class UtilizadorAddModel {
    private String username;
    private String password;
    private String email;
    private String tipoUser;
    private String nomeCompleto;
    private Date dataNascimento;
    private String numeroTelemovel;

    public UtilizadorAddModel(String username, String password, String email, String tipoUser, String nomeCompleto, Date dataNascimento, String numeroTelemovel) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.tipoUser = tipoUser;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.numeroTelemovel = numeroTelemovel;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumeroTelemovel() {
        return numeroTelemovel;
    }

    public void setNumeroTelemovel(String numeroTelemovel) {
        this.numeroTelemovel = numeroTelemovel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }
}
