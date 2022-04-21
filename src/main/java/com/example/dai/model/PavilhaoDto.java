package com.example.dai.model;

import com.example.dai.data.Pavilhao;

public class PavilhaoDto {
    private String mensagem;
    private Pavilhao pavilhao;

    public PavilhaoDto(String mensagem) {
        this.mensagem = mensagem;
    }

    public PavilhaoDto(Pavilhao pavilhao) {
        this.pavilhao = pavilhao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Pavilhao getPavilhao() {
        return pavilhao;
    }

    public void setPavilhao(Pavilhao pavilhao) {
        this.pavilhao = pavilhao;
    }
}
