package com.example.dai.data;

import javax.persistence.*;

@Entity
@Table(name = "EquipaAtleta")
public class EquipaAtleta{

    @EmbeddedId
    private EquipaAtletaId id;

    private long idEquipa;

    private long idAtleta;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idEquipa")
    private Equipa Equipa;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idAtleta")
    private Atleta atleta;

    public EquipaAtleta() {
    }

    public EquipaAtleta(Long idEquipa, Long idAtleta) {
        this.idEquipa = idEquipa;
        this.idAtleta = idAtleta;
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

    public long getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(long idAtleta) {
        this.idAtleta = idAtleta;
    }

    public com.example.dai.data.Equipa getEquipa() {
        return Equipa;
    }

    public void setEquipa(com.example.dai.data.Equipa equipa) {
        Equipa = equipa;
    }
}
