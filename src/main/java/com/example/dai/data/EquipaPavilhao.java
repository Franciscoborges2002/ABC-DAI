package com.example.dai.data;

import javax.persistence.*;

@Entity
@Table(name="EquipaPavilhao")
public class EquipaPavilhao {

    @EmbeddedId
    private EquipaPavilhaoId id;

    /*//@Column(insertable = false, updatable = false)/*
    private long idEquipa;

    private long idPavilhao;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idEquipa")
    @JoinColumn(name = "idEquipa", insertable = false, updatable = false)
    private Equipa equipa;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPavilhao")
    @JoinColumn(name = "idPavilhao", insertable = false, updatable = false)
    private Pavilhao pavilhao;

    public EquipaPavilhao() {
    }

    public EquipaPavilhao(EquipaPavilhaoId id) {
        this.id = id;
    }

    public EquipaPavilhaoId getId() {
        return id;
    }

    public void setId(EquipaPavilhaoId id) {
        this.id = id;
    }

    public Pavilhao getPavilhao() {
        return pavilhao;
    }

    public void setPavilhao(Pavilhao pavilhao) {
        this.pavilhao = pavilhao;
    }

    public Equipa getEquipa() {
        return equipa;
    }

    public void setEquipa(Equipa equipa) {
        this.equipa = equipa;
    }

}
