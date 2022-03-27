package com.example.dai.data.Class;

import com.example.dai.data.Enums.Categoria;

public class Exercicio{
    private int idExercicio;
    private String nomeExercicio;
    private Categoria categoriaExercicio;

    public Exercicio() {
    }

    public Exercicio(int idExercicio, String nomeExercicio, Categoria categoriaExercicio) {
        this.idExercicio = idExercicio;
        this.nomeExercicio = nomeExercicio;
        this.categoriaExercicio = categoriaExercicio;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public Categoria getCategoriaTreino() {
        return categoriaExercicio;
    }

    public void setCategoriaTreino(Categoria categoriaTreino) {
        this.categoriaExercicio = categoriaTreino;
    }

    public int getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(int idExercicio) {
        this.idExercicio = idExercicio;
    }

    public Categoria getCategoriaExercicio() {
        return categoriaExercicio;
    }

    public void setCategoriaExercicio(Categoria categoriaExercicio) {
        this.categoriaExercicio = categoriaExercicio;
    }

    @Override
    public String toString() {
        return "Exercicio{" +
                "idExercicio=" + idExercicio +
                ", nomeExercicio='" + nomeExercicio + '\'' +
                ", categoriaExercicio=" + categoriaExercicio +
                '}';
    }
}
