package com.example.dai.data;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idJogo;

    private int jornada;

    private Long idCompeticao;

    @Column(name = "dataJogo")
    private LocalDate dataJogo;

    @Column(name = "horasJogo")
    private String horasJogo;

    @Column(name = "golosABC")
    private int golosABC;

    @Column(name = "golosEquipaVisitante")
    private int golosEquipaVisitante;

    @Column(name = "pavilhao")
    private Long pavilhao;

    private Long idEquipaAbd;

    private String equipaVisitante;

    @OneToMany(
            mappedBy = "atleta",
            cascade = CascadeType.ALL
    )
    private Set<JogoAtleta> atletasNoJogo;

    @OneToMany(
            mappedBy = "jogada",
            cascade = CascadeType.ALL
    )
    private Set<JogoJogada> jogadasNoJogo;

    public Jogo(int jornada, Long idCompeticao, Long pavilhao) {
        this.jornada = jornada;
        this.idCompeticao = idCompeticao;
        this.pavilhao = pavilhao;
    }
/*
    public Jogo(int jornada, Long idCompeticao, LocalDate dataJogo, String horasJogo, Long pavilhao, Long abc, String equipaVisitante, Set<JogoAtleta> atletasNoJogo, Set<JogoJogada> jogadasNoJogo) {
        this.jornada = jornada;
        this.idCompeticao = idCompeticao;
        this.dataJogo = dataJogo;
        this.horasJogo = horasJogo;
        this.pavilhao = pavilhao;
        this.idEquipaAbd = abc;
        this.equipaVisitante = equipaVisitante;
        this.atletasNoJogo = atletasNoJogo;
        this.jogadasNoJogo = jogadasNoJogo;
    }*/

    public Jogo() {
    }

    public Jogo(int jornada, Long idCompeticao, LocalDate dataJogo, String horasJogo, Long idPavilhao, Long idEquipa, String equipaVisitante, Set<Long> atletasNoJogo, Set<Long> jogadasNoJogo) {
    }


    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public Long getPavilhao() {
        return pavilhao;
    }

    public void setPavilhao(Long pavilhao) {
        this.pavilhao = pavilhao;
    }
/*
    public Competicao getCompeticao() {
        return competicao;
    }

    public void setCompeticao(Competicao competicao) {
        this.competicao = competicao;
    }*/

    public LocalDate getDataJogo() {
        return dataJogo;
    }

    public void setDataJogo(LocalDate dataJogo) {
        this.dataJogo = dataJogo;
    }

    public String getHorasJogo() {
        return horasJogo;
    }

    public void setHorasJogo(String horasJogo) {
        this.horasJogo = horasJogo;
    }

    public int getGolosABC() {
        return golosABC;
    }

    public void setGolosABC(int golosABC) {
        this.golosABC = golosABC;
    }

    public int getGolosEquipaVisitante() {
        return golosEquipaVisitante;
    }

    public void setGolosEquipaVisitante(int golosEquipaVisitante) {
        this.golosEquipaVisitante = golosEquipaVisitante;
    }



    public String getEquipaVisitante() {
        return equipaVisitante;
    }

    public void setEquipaVisitante(String equipaVisitante) {
        this.equipaVisitante = equipaVisitante;
    }
}
