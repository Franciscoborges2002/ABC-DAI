package com.example.dai.model;

import com.example.dai.data.Escalao;
import com.example.dai.data.Genero;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Set;

public class EquipaEditModel {
    private String nomeEquipa;

    @Enumerated(EnumType.STRING)
    private Escalao escalao;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    private Set<Long> pavilhoes;
    private Set<Long> atletas;
    private Set<Long> treinadores;

    public EquipaEditModel(String nomeEquipa, Escalao escalao, Genero genero, Set<Long> pavilhoes, Set<Long> atletas, Set<Long> treinadores) {
        this.nomeEquipa = nomeEquipa;
        this.escalao = escalao;
        this.genero = genero;
        this.pavilhoes = pavilhoes;
        this.atletas = atletas;
        this.treinadores = treinadores;
    }

    public String getNomeEquipa() {
        return nomeEquipa;
    }

    public void setNomeEquipa(String nomeEquipa) {
        this.nomeEquipa = nomeEquipa;
    }

    public Escalao getEscalao() {
        return escalao;
    }

    public void setEscalao(Escalao escalao) {
        this.escalao = escalao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Set<Long> getPavilhoes() {
        return pavilhoes;
    }

    public void setPavilhoes(Set<Long> pavilhoes) {
        this.pavilhoes = pavilhoes;
    }

    public Set<Long> getAtletas() {
        return atletas;
    }

    public void setAtletas(Set<Long> atletas) {
        this.atletas = atletas;
    }

    public Set<Long> getTreinadores() {
        return treinadores;
    }

    public void setTreinadores(Set<Long> treinadores) {
        this.treinadores = treinadores;
    }
}
