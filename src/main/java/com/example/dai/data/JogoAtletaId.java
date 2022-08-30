package com.example.dai.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class JogoAtletaId implements Serializable {
    @Column(name = "idJogo")
    private Long idJogo;

    @Column(name = "idAtleta")
    private Long idAtleta;

    public JogoAtletaId() {
    }

    public JogoAtletaId(Long idJogo, Long idAtleta) {
        this.idJogo = idJogo;
        this.idAtleta = idAtleta;
    }

    public Long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Long idJogo) {
        this.idJogo = idJogo;
    }

    public Long getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(Long idAtleta) {
        this.idAtleta = idAtleta;
    }
}
