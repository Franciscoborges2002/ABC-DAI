package com.example.dai.data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Pavilhao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPavilhao;

    @Column(name="nomePavilhao")
    private String nomePavilhao;

    @Column(name="localizacao")
    private String localizacao;

    @Column(name="numeroDeTreinosPorHora")
    private Integer numeroDeTreinosPorHora;

    //Mudar Equipa
    @OneToMany(
            mappedBy = "Equipa",
            cascade = CascadeType.ALL
    )
    private Set<EquipaPavilhao> equipa;

    public Pavilhao() {
    }

    public Pavilhao(String nomePavilhao, String localizacao, int numeroDeTreinosPorHora) {
        this.nomePavilhao = nomePavilhao;
        this.localizacao = localizacao;
        this.numeroDeTreinosPorHora = numeroDeTreinosPorHora;
    }

    public Long getIdPavilhao() {
        return idPavilhao;
    }

    public void setIdPavilhao(Long idPavilhao) {
        this.idPavilhao = idPavilhao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getNumeroDeTreinosPorHora() {
        return numeroDeTreinosPorHora;
    }

    public void setNumeroDeTreinosPorHora(int numeroDeTreinosPorHora) {
        this.numeroDeTreinosPorHora = numeroDeTreinosPorHora;
    }

    public String getNomePavilhao() {
        return nomePavilhao;
    }

    public void setNomePavilhao(String nomePavilhao) {
        this.nomePavilhao = nomePavilhao;
    }
}
