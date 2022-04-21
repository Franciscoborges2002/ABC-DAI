package com.example.dai.data;

import javax.persistence.*;

@Entity
@Table(name="EquipaPavilhao")
public class EquipaPavilhao {

    @EmbeddedId
    private EquipaPavilhaoId id;

    private long idEquipa;

    private long idPavilhao;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idEquipa")
    private Equipa Equipa;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPavilhao")
    private Pavilhao pavilhao;

    public EquipaPavilhao() {
    }

    public EquipaPavilhao(long idEquipa, long idPavilhao) {
        this.idEquipa = idEquipa;
        this.idPavilhao = idPavilhao;
    }

    public EquipaPavilhaoId getId() {
        return id;
    }

    public void setId(EquipaPavilhaoId id) {
        this.id = id;
    }

    public long getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(long idEquipa) {
        this.idEquipa = idEquipa;
    }

    public long getIdPavilhao() {
        return idPavilhao;
    }

    public void setIdPavilhao(long idPavilhao) {
        this.idPavilhao = idPavilhao;
    }

    public Pavilhao getPavilhao() {
        return pavilhao;
    }

    public void setPavilhao(Pavilhao pavilhao) {
        this.pavilhao = pavilhao;
    }
}
