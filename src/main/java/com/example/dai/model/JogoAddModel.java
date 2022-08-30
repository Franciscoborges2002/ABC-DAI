package com.example.dai.model;

import com.example.dai.data.Competicao;
import com.example.dai.data.Equipa;
import com.example.dai.data.JogoAtleta;
import com.example.dai.data.JogoJogada;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

public class JogoAddModel {
    private int jornada;
    private Long idCompeticao;
    private LocalDate dataJogo;
    private String horasJogo;
    private Long idPavilhao;
    private Long idEquipa;
    private String equipaVisitante;
    private Set<Long> atletasNoJogo;
    private Set<Long> jogadasNoJogo;

    public JogoAddModel(int jornada, Long idCompeticao, LocalDate dataJogo, String horasJogo, Long pavilhao, Long idEquipa, String equipaVisitante, Set<Long> atletasNoJogo, Set<Long> jogadasNoJogo) {
        this.jornada = jornada;
        this.idCompeticao = idCompeticao;
        this.dataJogo = dataJogo;
        this.horasJogo = horasJogo;
        this.idPavilhao = pavilhao;
        this.idEquipa = idEquipa;
        this.equipaVisitante = equipaVisitante;
        this.atletasNoJogo = atletasNoJogo;
        this.jogadasNoJogo = jogadasNoJogo;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public Long getIdCompeticao() {
        return idCompeticao;
    }

    public void setIdCompeticao(Long idCompeticao) {
        this.idCompeticao = idCompeticao;
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

    public Long getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(Long idEquipa) {
        this.idEquipa = idEquipa;
    }

    public String getEquipaVisitante() {
        return equipaVisitante;
    }

    public void setEquipaVisitante(String equipaVisitante) {
        this.equipaVisitante = equipaVisitante;
    }

    public Set<Long> getAtletasNoJogo() {
        return atletasNoJogo;
    }

    public void setAtletasNoJogo(Set<Long> atletasNoJogo) {
        this.atletasNoJogo = atletasNoJogo;
    }

    public Set<Long> getJogadasNoJogo() {
        return jogadasNoJogo;
    }

    public void setJogadasNoJogo(Set<Long> jogadasNoJogo) {
        this.jogadasNoJogo = jogadasNoJogo;
    }

    public Long getIdPavilhao() {
        return idPavilhao;
    }

    public void setIdPavilhao(Long idPavilhao) {
        this.idPavilhao = idPavilhao;
    }
}
