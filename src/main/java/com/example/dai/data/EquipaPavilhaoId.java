package com.example.dai.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EquipaPavilhaoId implements Serializable {
    @Column(name = "idEquipa")
    private Long idEquipa;

    @Column(name = "idPavilhao")
    private Long idPavilhao;

    public EquipaPavilhaoId() {
    }

    public EquipaPavilhaoId(Long idEquipa, Long idPavilhao) {
        this.idEquipa = idEquipa;
        this.idPavilhao = idPavilhao;
    }

    public Long getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(Long idEquipa) {
        this.idEquipa = idEquipa;
    }

    public Long getIdPavilhao() {
        return idPavilhao;
    }

    public void setIdPavilhao(Long idPavilhao) {
        this.idPavilhao = idPavilhao;
    }
}
