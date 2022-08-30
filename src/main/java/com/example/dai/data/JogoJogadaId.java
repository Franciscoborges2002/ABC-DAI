package com.example.dai.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class JogoJogadaId implements Serializable {

    @Column(name = "idJogo")
    private Long idJogo;

    @Column(name = "idJogada")
    private Long idJogada;

    public JogoJogadaId() {
    }

    public JogoJogadaId(Long idJogo, Long idJogada) {
        this.idJogo = idJogo;
        this.idJogada = idJogada;
    }

    public Long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Long idJogo) {
        this.idJogo = idJogo;
    }

    public Long getIdJogada() {
        return idJogada;
    }

    public void setIdJogada(Long idJogada) {
        this.idJogada = idJogada;
    }
}
