package com.example.dai.Data.Class;

import com.example.dai.Data.Enums.Categoria;

import java.time.LocalDate;

public class Treino {
    private Categoria categoria;
    private Equipa equipa;
    private LocalDate horario;
    private String localizacao;

    public Treino() {
    }

    public Treino(Categoria categoria, Equipa equipa, LocalDate horario, String localizacao) {
        this.categoria = categoria;
        this.equipa = equipa;
        this.horario = horario;
        this.localizacao = localizacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Equipa getEquipa() {
        return equipa;
    }

    public void setEquipa(Equipa equipa) {
        this.equipa = equipa;
    }

    public LocalDate getHorario() {
        return horario;
    }

    public void setHorario(LocalDate horario) {
        this.horario = horario;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "Treino{" +
                "categoria=" + categoria +
                ", equipa=" + equipa +
                ", horario=" + horario +
                ", localizacao='" + localizacao + '\'' +
                '}';
    }
}
