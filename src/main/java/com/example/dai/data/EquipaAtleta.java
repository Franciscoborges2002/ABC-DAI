package com.example.dai.data;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "EquipaAtleta")
public class EquipaAtleta{


    @EmbeddedId
    private EquipaAtletaId id;

    @JsonBackReference
    @ManyToOne//(fetch = FetchType.LAZY)
    @MapsId("idEquipa")
    @JoinColumn(name = "id_equipa", insertable = false, updatable = false)
    private Equipa equipa;

    //@JsonBackReference
    @ManyToOne//(fetch = FetchType.LAZY)
    @MapsId("idAtleta")
    @JoinColumn(name = "id_atleta", insertable = false, updatable = false)
    private Atleta atleta;

    public EquipaAtleta() {
    }



    public EquipaAtleta(EquipaAtletaId id) {
        this.id = id;
    }

    public EquipaAtletaId getId() {
        return id;
    }

    public void setId(EquipaAtletaId id) {
        this.id = id;
    }


    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    public Equipa getEquipa() {
        return equipa;
    }

    public void setEquipa(Equipa equipa) {
        this.equipa = equipa;
    }
}
