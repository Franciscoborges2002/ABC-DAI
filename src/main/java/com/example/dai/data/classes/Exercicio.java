package com.example.dai.data.classes;

import com.example.dai.data.enums.Categoria;

import javax.persistence.*;

@Entity
@Table
public class Exercicio{
    @Id
    @SequenceGenerator(
            name = "exercicio_sequence",
            sequenceName = "exercicio_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exercicio_sequence"
    )
    private Long idExercicio;
    private String nomeExercicio;
    private Categoria categoriaExercicio;

    public Exercicio() {

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
