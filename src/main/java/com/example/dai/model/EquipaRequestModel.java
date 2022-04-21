package com.example.dai.model;

public class EquipaRequestModel {
    private Long idEquipa;
    private String nomeEquipa;

    public EquipaRequestModel(Long idEquipa, String nomeEquipa) {
        this.idEquipa = idEquipa;
        this.nomeEquipa = nomeEquipa;
    }

    public Long getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(Long idEquipa) {
        this.idEquipa = idEquipa;
    }

    public String getNomeEquipa() {
        return nomeEquipa;
    }

    public void setNomeEquipa(String nomeEquipa) {
        this.nomeEquipa = nomeEquipa;
    }
}
