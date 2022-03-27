package com.example.dai.data.Class;

import java.time.LocalDate;
import java.util.HashMap;

public class Treino {
    private String nomeTreino;
    private Equipa equipa;
    private LocalDate horario;
    private String localizacao;
    private HashMap<Integer, Exercicio> exercicios;

    public Treino() {
    }

    public Treino(Equipa equipa, LocalDate horario, String localizacao, HashMap<Integer, Exercicio> exercicios) {
        this.equipa = equipa;
        this.horario = horario;
        this.localizacao = localizacao;
        this.exercicios = exercicios;
    }

    public String getNomeTreino() {
        return nomeTreino;
    }

    public void setNomeTreino(String nomeTreino) {
        this.nomeTreino = nomeTreino;
    }

    public Equipa getEquipa() {
        return equipa;
    }

    public void setEquipa(Equipa equipa) {
        this.equipa = equipa;
    }

    public LocalDate getHorario() {
        return horario;
    }

    public void setHorario(LocalDate horario) {
        this.horario = horario;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public HashMap<Integer, Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(HashMap<Integer, Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    @Override
    public String toString() {
        return "Treino{" +
                "nomeTreino='" + nomeTreino + '\'' +
                ", equipa=" + equipa +
                ", horario=" + horario +
                ", localizacao='" + localizacao + '\'' +
                ", exercicios=" + exercicios +
                '}';
    }
}
