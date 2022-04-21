package com.example.dai.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EquipaAtletaId implements Serializable {
    @Column(name = "idEquipa")
    private Long idEquipa;

    @Column(name = "idAtleta")
    private Long idAtleta;

    public EquipaAtletaId() {
    }

    public EquipaAtletaId(Long idEquipa, Long idAtleta) {
        this.idEquipa = idEquipa;
        this.idAtleta = idAtleta;
    }

    public Long getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(Long idEquipa) {
        this.idEquipa = idEquipa;
    }

    public Long getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(Long idAtleta) {
        this.idAtleta = idAtleta;
    }
}
