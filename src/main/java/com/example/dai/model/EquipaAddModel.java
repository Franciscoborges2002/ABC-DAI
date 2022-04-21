package com.example.dai.model;

import com.example.dai.data.Escalao;
import com.example.dai.data.Genero;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

public class EquipaAddModel {
    @NotEmpty(message = "Um nome deve ser passado.")
    @Size(min = 3, message = "O nome tem de conter pelo menos 3 caracteres.")
    private String nomeEquipa;

    //@NotEmpty(message = "Um escalão deve ser passado.")
    @Enumerated(EnumType.STRING)
    private Escalao escalao;

    //@NotEmpty(message = "Um genero deve ser passado.")
    @Enumerated(EnumType.STRING)
    private Genero genero;

    private String morada;//tirar
    private String email;//tirar
    private String website;//tirar
    private Set<Long> pavilhoes;
    private Set<Long> atletas;
    private Set<Long> treinadores;


    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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
}
