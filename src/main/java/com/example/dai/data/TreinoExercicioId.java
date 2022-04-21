package com.example.dai.data;

import javax.persistence.Column;
import java.io.Serializable;

public class TreinoExercicioId implements Serializable {
    @Column(name = "idExercicio")
    private Long idExercicio;

    @Column(name = "idTreino")
    private Long idTreino;

    public TreinoExercicioId() {

    }

    public TreinoExercicioId(Long idExercicio, Long idTreino) {
        this.idExercicio = idExercicio;
        this.idTreino = idTreino;
    }

    public Long getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(Long idExercicio) {
        this.idExercicio = idExercicio;
    }

    public Long getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(Long idTreino) {
        this.idTreino = idTreino;
    }
}
