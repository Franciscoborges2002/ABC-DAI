package com.example.dai.model;

import com.example.dai.data.Exercicio;

public class ExercicioDto {
    private String mensagem;
    private Exercicio exercicio;

    public ExercicioDto(String mensagem) {
        this.mensagem = mensagem;
    }

    public ExercicioDto(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
