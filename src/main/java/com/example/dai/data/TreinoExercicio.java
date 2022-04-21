package com.example.dai.data;

import javax.persistence.*;

@Entity
@Table(name="TreinoExercicio")
public class TreinoExercicio{

    @EmbeddedId
    private TreinoExercicioId id;

    private long idTreino;
    private long idExercicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idTreino")
    private Treino treino;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idExercicio")
    private Exercicio exercicio;

    public TreinoExercicio(){

    }

    public TreinoExercicio(long idTreino, long idExercicio){
        this.idTreino= idTreino;
        this.idExercicio=idExercicio;
    }

    public TreinoExercicioId getId() {
        return id;
    }

    public void setId(TreinoExercicioId id) {
        this.id = id;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }


}
