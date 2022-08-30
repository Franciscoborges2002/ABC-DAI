package com.example.dai.model;

import java.util.Date;

public class UtilizadorEditModel {
    private String password;
    private String email;
    private String nomeCompleto;
    private Date dataNascimento;
    private String numeroTelemovel;
    private String tipoUser;

    public UtilizadorEditModel(String password, String email, String nomeCompleto, Date dataNascimento, String numeroTelemovel, String tipoUser) {
        this.password = password;
        this.email = email;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.numeroTelemovel = numeroTelemovel;
        this.tipoUser = tipoUser;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
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
}
