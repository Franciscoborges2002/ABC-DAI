package com.example.dai.data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Atleta extends Utilizador{

    @Column(name="cipa", nullable = false, unique = true)
    private String cipa;

    @Column(name="numeroCamisola", nullable = false)
    private int numeroCamisola;

    @Transient
    private long numeroParticipacaoJogos;

    @Column(name="numeroParticipacaoTreinos")
    private long numeroParticipacaoTreinos;

    @Column(name="golos")
    private long golos;

    @Column(name="assistencias")
    private long assistencias;

    //Mudar Equipa
    @OneToMany(
            mappedBy = "Equipa",
            cascade = CascadeType.ALL
    )
    private Set<EquipaAtleta> equipa;

    public Atleta() {
    }

    public Atleta(String password, String email) {
        super(password, email);
    }

    public Atleta(String nomeUtilizador, String password, String email) {
        super( nomeUtilizador, password, email);
    }

    public Set<EquipaAtleta> getEquipa() {
        return equipa;
    }

    public void setEquipa(Set<EquipaAtleta> equipa) {
        this.equipa = equipa;
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
