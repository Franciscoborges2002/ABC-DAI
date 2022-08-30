package com.example.dai.data;

import javax.persistence.*;

@Entity
@Table(name="JogoJogadas")
public class JogoJogada {

    @EmbeddedId
    private JogoJogadaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idJogo")
    @JoinColumn(name = "idJogo", insertable = false, updatable = false)
    private Jogo jogo;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idJogada")
    @JoinColumn(name = "idJogada", insertable = false, updatable = false)
    private Jogada jogada;

    public JogoJogada(Jogo jogo, Jogada jogada) {
        this.jogo = jogo;
        this.jogada = jogada;
    }

    public JogoJogada() {
    }

    public JogoJogadaId getId() {
        return id;
    }

    public void setId(JogoJogadaId id) {
        this.id = id;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Jogada getJogada() {
        return jogada;
    }

    public void setJogada(Jogada jogada) {
        this.jogada = jogada;
    }
}
