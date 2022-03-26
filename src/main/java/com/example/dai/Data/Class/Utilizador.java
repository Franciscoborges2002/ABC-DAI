package com.example.dai.Data.Class;

import java.time.LocalDate;
import java.util.Objects;

public class Utilizador {
    private String nomeUtilizador;
    private String nomeCompleto;
    private String password;
    private LocalDate dataNascimento;
    private String email;
    private String numeroTelemovel;

    public Utilizador() {
    }

    public Utilizador(String nomeUtilizador, String password) {
        this.nomeUtilizador = nomeUtilizador;
        this.password = password;
    }



    public Utilizador(String nomeUtilizador, String password, String email) {
        this.nomeUtilizador = nomeUtilizador;
        this.password = password;
        this.email = email;
    }

    public Utilizador(String nomeUtilizador, String nomeCompleto, String password, LocalDate dataNascimento, String email, String numeroTelemovel) {
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizador that = (Utilizador) o;
        return Objects.equals(nomeUtilizador, that.nomeUtilizador) && Objects.equals(nomeCompleto, that.nomeCompleto) && Objects.equals(password, that.password) && Objects.equals(dataNascimento, that.dataNascimento) && Objects.equals(email, that.email) && Objects.equals(numeroTelemovel, that.numeroTelemovel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeUtilizador, nomeCompleto, password, dataNascimento, email, numeroTelemovel);
    }

    @Override
    public String toString() {
        return "Utilizador{" +
                "nomeUtilizador='" + nomeUtilizador + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", password='" + password + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", email='" + email + '\'' +
                ", numeroTelemovel='" + numeroTelemovel + '\'' +
                '}';
    }
}