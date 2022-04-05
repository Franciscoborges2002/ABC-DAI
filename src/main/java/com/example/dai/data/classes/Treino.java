package com.example.dai.data.classes;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;


@Entity
@Table
public class Treino {
    @Id
    @SequenceGenerator(
            name = "treino_sequence",
            sequenceName = "treino_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "treino_sequence"
    )
    private Long idTreino;
    private String nomeTreino;
    @OneToOne
    @JoinColumn(name = "equipa_id_equipa")
    private Equipa equipa;
    private LocalDate horario;
    private String localizacao;
    //private HashMap<Integer, Exercicio> exercicios;

    public Treino() {
    }

    public Treino(String nomeTreino, Equipa equipa, LocalDate horario, String localizacao) {
        this.nomeTreino =nomeTreino;
        this.equipa = equipa;
        this.horario = horario;
        this.localizacao = localizacao;
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

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "Treino{" +
                "nomeTreino='" + nomeTreino + '\'' +
                ", equipa=" + equipa +
                ", horario=" + horario +
                ", localizacao='" + localizacao + '\'' +
                '}';
    }
}
