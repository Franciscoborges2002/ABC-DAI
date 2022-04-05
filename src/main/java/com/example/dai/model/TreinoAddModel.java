package com.example.dai.model;

import com.example.dai.data.classes.Equipa;
import com.example.dai.data.classes.Treino;

import java.time.LocalDate;

public class TreinoAddModel {
    private String nomeTreino;
    private Equipa equipaTreinar;
    private LocalDate horarioTreino;
    private String pavilhao;//Alterar isto

    public TreinoAddModel(String nomeTreino, Equipa equipaTreinar, LocalDate horarioTreino, String pavilhao) {
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

    public String getPavilhao() {
        return pavilhao;
    }

    public void setPavilhao(String pavilhao) {
        this.pavilhao = pavilhao;
    }
}
