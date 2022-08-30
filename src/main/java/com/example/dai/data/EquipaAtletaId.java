package com.example.dai.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EquipaAtletaId implements Serializable {

    //@Column(name = "id_equipa")
    private Long idEquipa;

    //@Column(name = "id_atleta")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquipaAtletaId)) return false;
        EquipaAtletaId that = (EquipaAtletaId) o;
        return Objects.equals(getIdEquipa(), that.getIdEquipa()) && Objects.equals(getIdAtleta(), that.getIdAtleta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdEquipa(), getIdAtleta());
    }
}
