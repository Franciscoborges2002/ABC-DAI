package com.example.dai.data;

import javax.persistence.*;

@Entity
@Table(name="JogoAtleta")
public class JogoAtleta {

    @EmbeddedId
    private JogoAtletaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idJogo")
    @JoinColumn(name = "idJogo", insertable = false, updatable = false)
    private Jogo jogo;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idAtleta")
    @JoinColumn(name = "idAtleta", insertable = false, updatable = false)
    private Atleta atleta;

    public JogoAtleta() {
    }

    public JogoAtleta(Jogo jogo, Atleta atleta) {
        this.jogo = jogo;
        this.atleta = atleta;
    }

    public JogoAtletaId getId() {
        return id;
    }

    public void setId(JogoAtletaId id) {
        this.id = id;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }
}
