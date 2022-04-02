package com.example.dai.data.classes;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Atleta extends Utilizador{
    @SequenceGenerator(
            name = "atleta_sequence",
            sequenceName = "atleta_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "atleta_sequence"
    )
    private long idAtleta;
    private String cipa;
    private int numeroCamisola;
    private long numeroParticipacaoJogos;
    private long numeroParticipacaoTreinos;
    private long golos;
    private long assistencias;
    //private long


    public Atleta() {
    }

    public Atleta(String password, String email) {
        super(password, email);
    }

    public Atleta(String nomeUtilizador, String password, String cipa) {
        super(nomeUtilizador, password);
        this.cipa = cipa;
    }

    public long getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(long idAtleta) {
        this.idAtleta = idAtleta;
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

    public long getNumeroParticipacaoTreinos() {
        return numeroParticipacaoTreinos;
    }

    public void setNumeroParticipacaoTreinos(long numeroParticipacaoTreinos) {
        this.numeroParticipacaoTreinos = numeroParticipacaoTreinos;
    }

    public long getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(long assistencias) {
        this.assistencias = assistencias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Atleta atleta = (Atleta) o;
        return numeroCamisola == atleta.numeroCamisola && numeroParticipacaoJogos == atleta.numeroParticipacaoJogos && numeroParticipacaoTreinos == atleta.numeroParticipacaoTreinos && golos == atleta.golos && assistencias == atleta.assistencias &&  Objects.equals(cipa, atleta.cipa);
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "cipa='" + cipa + '\'' +
                ", numeroCamisola=" + numeroCamisola +
                ", numeroParticipacaoJogos=" + numeroParticipacaoJogos +
                ", numeroParticipacaoTreinos=" + numeroParticipacaoTreinos +
                ", assistencias=" + assistencias +
                '}';
    }
}
