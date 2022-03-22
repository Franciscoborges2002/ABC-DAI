package com.example.dai.Data;

//Função para registar uma nova competição, url. o resto vamos buscar ao website da federação;
public class Competition {
    private String Nome;

    public String getURL() {
        return Nome;
    }

    public void setURL(String URL) {
        this.Nome = URL;
    }
}
