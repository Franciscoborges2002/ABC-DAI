package com.example.dai.data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTreino;

    @Column(name="nomeTreino")
    private String nomeTreino;

    @OneToOne
    @JoinColumn(name = "equipa_id_equipa")
    private Equipa equipa;

    @Column(name="horario")
    private LocalDate horario;
/*
    @Column(name="pavilhao")
    private Pavilhao pavilhao;*/

    @OneToMany(
            mappedBy = "exercicio",
            cascade = CascadeType.ALL
    )
    private Set<TreinoExercicio> exerciciosNoTreino;

    public Treino() {
    }
/*
    public Treino(String nomeTreino, Equipa equipa, LocalDate horario, Pavilhao pavilhao, Set<TreinoExercicio> exerciciosNoTreino) {
        this.nomeTreino = nomeTreino;
        this.equipa = equipa;
        this.horario = horario;
        this.pavilhao = pavilhao;
        this.exerciciosNoTreino = exerciciosNoTreino;
    }

    public Treino(String nomeTreino, Equipa equipa, LocalDate horario, Pavilhao pavilhao) {
        this.nomeTreino = nomeTreino;
        this.equipa = equipa;
        this.horario = horario;
        this.pavilhao = pavilhao;
    }*/

    public Treino(String nomeTreino, Equipa equipa, LocalDate horario, Set<TreinoExercicio> exerciciosNoTreino) {
        this.nomeTreino = nomeTreino;
        this.equipa = equipa;
        this.horario = horario;
        this.exerciciosNoTreino = exerciciosNoTreino;
    }

    public Treino(String nomeTreino, Equipa equipa, LocalDate horario) {
        this.nomeTreino = nomeTreino;
        this.equipa = equipa;
        this.horario = horario;
    }

    /*
    public Pavilhao getPavilhao() {
        return pavilhao;
    }

    public void setPavilhao(Pavilhao pavilhao) {
        this.pavilhao = pavilhao;
    }*/

    public Set<TreinoExercicio> getExerciciosNoTreino() {
        return exerciciosNoTreino;
    }

    public void setExerciciosNoTreino(Set<TreinoExercicio> exerciciosNoTreino) {
        this.exerciciosNoTreino = exerciciosNoTreino;
    }

    public Long getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(Long idTreino) {
        this.idTreino = idTreino;
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
}
