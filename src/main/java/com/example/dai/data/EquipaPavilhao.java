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
    @JoinColumn(name = "idEquipa", insertable = false, updatable = false)
    private Equipa Equipa;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPavilhao")
    @JoinColumn(name = "idTreinador", insertable = false, updatable = false)
    private Pavilhao pavilhao;

    public EquipaPavilhao() {
    }

    public EquipaPavilhao(com.example.dai.data.Equipa equipa, Pavilhao pavilhao) {
        Equipa = equipa;
        this.pavilhao = pavilhao;
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

    public com.example.dai.data.Equipa getEquipa() {
        return Equipa;
    }

    public void setEquipa(com.example.dai.data.Equipa equipa) {
        Equipa = equipa;
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
}
