package com.example.dai.data.Class;

import java.time.LocalDate;
import java.util.Objects;

public class Jogo {
    private int numeroJogo;
    private Competicao competicao;
    private String epoca;
    private LocalDate dataJogo;
    private String horasJogo;
    private int golosABC;
    private int golosEquipaVisitante;
    private String estadio;
    private Equipa ABC;
    private Equipa equipaVisitante;

    public Jogo() {
    }

    public Jogo(int numeroJogo, Competicao competicao, String epoca, LocalDate dataJogo, String horasJogo, int golosABC, int golosEquipaVisitante, String estadio, Equipa ABC, Equipa equipaVisitante) {
        this.numeroJogo = numeroJogo;
        this.competicao = competicao;
        this.epoca = epoca;
        this.dataJogo = dataJogo;
        this.horasJogo = horasJogo;
        this.golosABC = golosABC;
        this.golosEquipaVisitante = golosEquipaVisitante;
        this.estadio = estadio;
        this.ABC = ABC;
        this.equipaVisitante = equipaVisitante;
    }

    public int getNumeroJogo() {
        return numeroJogo;
    }

    public void setNumeroJogo(int numeroJogo) {
        this.numeroJogo = numeroJogo;
    }

    public Competicao getCompeticao() {
        return competicao;
    }

    public void setCompeticao(Competicao competicao) {
        this.competicao = competicao;
    }

    public String getEpoca() {
        return epoca;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

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

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Equipa getABC() {
        return ABC;
    }

    public void setABC(Equipa ABC) {
        this.ABC = ABC;
    }

    public Equipa getEquipaVisitante() {
        return equipaVisitante;
    }

    public void setEquipaVisitante(Equipa equipaVisitante) {
        this.equipaVisitante = equipaVisitante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogo jogo = (Jogo) o;
        return numeroJogo == jogo.numeroJogo && golosABC == jogo.golosABC && golosEquipaVisitante == jogo.golosEquipaVisitante && Objects.equals(competicao, jogo.competicao) && Objects.equals(epoca, jogo.epoca) && Objects.equals(dataJogo, jogo.dataJogo) && Objects.equals(horasJogo, jogo.horasJogo) && Objects.equals(estadio, jogo.estadio) && Objects.equals(ABC, jogo.ABC) && Objects.equals(equipaVisitante, jogo.equipaVisitante);
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "numeroJogo=" + numeroJogo +
                ", competicao=" + competicao +
                ", epoca='" + epoca + '\'' +
                ", dataJogo=" + dataJogo +
                ", horasJogo='" + horasJogo + '\'' +
                ", golosABC=" + golosABC +
                ", golosEquipaVisitante=" + golosEquipaVisitante +
                ", estadio='" + estadio + '\'' +
                ", ABC=" + ABC +
                ", equipaVisitante=" + equipaVisitante +
                '}';
    }
}
