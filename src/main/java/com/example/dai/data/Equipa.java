package com.example.dai.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Equipa")
public class Equipa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipa;

    @Column(name="nome", nullable = false, unique = true)
    private String nome;

    @Enumerated(EnumType.STRING)
    private Escalao escalao;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @OneToMany(
            mappedBy = "pavilhao"
            //cascade = CascadeType.ALL,
    )
    private Set<EquipaPavilhao> pavilhao;

    @JsonIgnoreProperties("equipa")
    @OneToMany(
            mappedBy = "equipa",
            cascade = CascadeType.ALL
    )
    private List<EquipaAtleta> atletasNaEquipa;

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

    public Equipa(String nome, Escalao escalao, Genero genero) {
        this.nome = nome;
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

    public Set<EquipaPavilhao> getPavilhao() {
        return pavilhao;
    }

    public void setPavilhao(Set<EquipaPavilhao> pavilhao) {
        this.pavilhao = pavilhao;
    }

    public List<EquipaAtleta> getAtletasNaEquipa() {
        return atletasNaEquipa;
    }

    public void setAtletasNaEquipa(List<EquipaAtleta> atletasNaEquipa) {
        this.atletasNaEquipa = atletasNaEquipa;
    }

    public Set<EquipaTreinador> getTreinadoresNaEquipa() {
        return treinadoresNaEquipa;
    }

    public void setTreinadoresNaEquipa(Set<EquipaTreinador> treinadoresNaEquipa) {
        this.treinadoresNaEquipa = treinadoresNaEquipa;
    }
}
