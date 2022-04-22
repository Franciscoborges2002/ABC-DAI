package com.example.dai.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Equipa")
public class Equipa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipa;

    @Column(name="nome", nullable = false, unique = true)
    private String nome;

    @Column(name="morada")
    private String morada;

    @Column(name="email")
    private String email;

    @Column(name="website")
    private String website;

    @Enumerated(EnumType.STRING)
    private Escalao escalao;

    @Enumerated(EnumType.STRING)
    private Genero genero;
/*
    @OneToMany(
            mappedBy = "pavilhao",
            cascade = CascadeType.ALL
    )
    private Set<EquipaPavilhao> pavilhao;

    @OneToMany(
            mappedBy = "atleta",
            cascade = CascadeType.ALL
    )
    private Set<EquipaAtleta> atletasNaEquipa;*/

    @OneToMany(
            mappedBy = "treinador",
            cascade = CascadeType.ALL
    )
    private Set<EquipaTreinador> treinadoresNaEquipa;

    public Equipa() {
    }

    public Equipa(String nome) {
        this.nome = nome;
    }

    public Equipa(String nome, String morada, String email, String website, Escalao escalao, Genero genero) {
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.website = website;
        this.escalao = escalao;
        this.genero = genero;
    }

    public Long getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(Long idEquipa) {
        this.idEquipa = idEquipa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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
/*
    public Set<EquipaPavilhao> getPavilhao() {
        return pavilhao;
    }

    public void setPavilhao(Set<EquipaPavilhao> pavilhao) {
        this.pavilhao = pavilhao;
    }

    public Set<EquipaAtleta> getAtletasNaEquipa() {
        return atletasNaEquipa;
    }

    public void setAtletasNaEquipa(Set<EquipaAtleta> atletasNaEquipa) {
        this.atletasNaEquipa = atletasNaEquipa;
    }*/

    public Set<EquipaTreinador> getTreinadoresNaEquipa() {
        return treinadoresNaEquipa;
    }

    public void setTreinadoresNaEquipa(Set<EquipaTreinador> treinadoresNaEquipa) {
        this.treinadoresNaEquipa = treinadoresNaEquipa;
    }
}
