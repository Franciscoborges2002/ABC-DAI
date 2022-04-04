package com.example.dai.model;

import com.example.dai.data.enums.Escalao;
import com.example.dai.data.enums.Genero;

public class EquipaAddModel {
    private String nomeEquipa;
    private Escalao escalao;
    private Genero genero;

    public EquipaAddModel(String nomeEquipa, Escalao escalao, Genero genero) {
        this.nomeEquipa = nomeEquipa;
        this.escalao = escalao;
        this.genero = genero;
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
