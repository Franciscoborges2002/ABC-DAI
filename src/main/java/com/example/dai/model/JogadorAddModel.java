package com.example.dai.model;

import java.util.Date;

public class JogadorAddModel {
    private String nomeUtilizador;
    private String cipa;
    private int numeroCamisola;
    private long numeroParticipacaoTreinos;
    private long numeroParticipacaoJogos;
    private long golos;
    private long assistencias;
    private String nomeCompleto;
    private String password;
    private Date dataNascimento;
    private String email;
    private String numeroTelemovel;

    public JogadorAddModel() {
    }

    public JogadorAddModel(String nomeUtilizador, String cipa, int numeroCamisola, long numeroParticipacaoTreinos, long numeroParticipacaoJogos, long golos, long assistencias, String nomeCompleto, String password, Date dataNascimento, String email, String numeroTelemovel) {
        this.nomeUtilizador = nomeUtilizador;
        this.cipa = cipa;
        this.numeroCamisola = numeroCamisola;
        this.numeroParticipacaoTreinos = numeroParticipacaoTreinos;
        this.numeroParticipacaoJogos = numeroParticipacaoJogos;
        this.golos = golos;
        this.assistencias = assistencias;
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

    public String getCipa() {
        return cipa;
    }

    public void setCipa(String cipa) {
        this.cipa = cipa;
    }

    public int getNumeroCamisola() {
        return numeroCamisola;
    }

    public void setNumeroCamisola(int numeroCamisola) {
        this.numeroCamisola = numeroCamisola;
    }

    public long getNumeroParticipacaoTreinos() {
        return numeroParticipacaoTreinos;
    }

    public void setNumeroParticipacaoTreinos(long numeroParticipacaoTreinos) {
        this.numeroParticipacaoTreinos = numeroParticipacaoTreinos;
    }

    public long getNumeroParticipacaoJogos() {
        return numeroParticipacaoJogos;
    }

    public void setNumeroParticipacaoJogos(long numeroParticipacaoJogos) {
        this.numeroParticipacaoJogos = numeroParticipacaoJogos;
    }

    public long getGolos() {
        return golos;
    }

    public void setGolos(long golos) {
        this.golos = golos;
    }

    public long getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(long assistencias) {
        this.assistencias = assistencias;
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
