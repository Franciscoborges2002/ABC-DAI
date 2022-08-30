package com.example.dai.model;

import com.example.dai.data.Equipa;
import com.example.dai.data.Pavilhao;

import java.time.LocalDate;
import java.util.Set;

public class TreinoAddModel {
    private String nomeTreino;
    private Equipa equipaTreinar;
    private LocalDate horarioTreino;
    private Pavilhao pavilhao;
    private Set<Long> Exercicios;

    public TreinoAddModel() {
    }

    public TreinoAddModel(String nomeTreino, Equipa equipaTreinar, LocalDate horarioTreino, Pavilhao pavilhao) {
        this.nomeTreino = nomeTreino;
        this.equipaTreinar = equipaTreinar;
        this.horarioTreino = horarioTreino;
        this.pavilhao = pavilhao;
    }

    public String getNomeTreino() {
        return nomeTreino;
    }

    public void setNomeTreino(String nomeTreino) {
        this.nomeTreino = nomeTreino;
    }

    public Equipa getEquipaTreinar() {
        return equipaTreinar;
    }

    public void setEquipaTreinar(Equipa equipaTreinar) {
        this.equipaTreinar = equipaTreinar;
    }

    public LocalDate getHorarioTreino() {
        return horarioTreino;
    }

    public void setHorarioTreino(LocalDate horarioTreino) {
        this.horarioTreino = horarioTreino;
    }

    public Pavilhao getPavilhao() {
        return pavilhao;
    }

    public void setPavilhao(Pavilhao pavilhao) {
        this.pavilhao = pavilhao;
    }
}
