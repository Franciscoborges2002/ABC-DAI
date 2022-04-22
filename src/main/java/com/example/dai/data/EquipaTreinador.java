package com.example.dai.data;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="EquipaTreinador")
public class EquipaTreinador {

    @EmbeddedId
    private EquipaTreinadorId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idEquipa")
    @JoinColumn(name = "idEquipa", insertable = false, updatable = false)
    private Equipa equipa;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idTreinador")
    @JoinColumn(name = "idTreinador", insertable = false, updatable = false)
    private Treinador treinador;

    public EquipaTreinador() {
    }

    public EquipaTreinador(EquipaTreinadorId id) {
        this.id = id;
    }

    public Equipa getEquipa() {
        return equipa;
    }

    public void setEquipa(Equipa equipa) {
        this.equipa = equipa;
    }

    public EquipaTreinadorId getId() {
        return id;
    }

    public void setId(EquipaTreinadorId id) {
        this.id = id;
    }

    public Treinador getTreinador() {
        return treinador;
    }

    public void setTreinador(Treinador treinador) {
        this.treinador = treinador;
    }

}
