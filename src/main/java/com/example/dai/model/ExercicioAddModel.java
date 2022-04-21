package com.example.dai.model;

import com.example.dai.data.CategoriaTreino;

public class ExercicioAddModel {
    private String nomeExercicio;
    private CategoriaTreino categoriaExercicio;
    private String descricao;
    private String link;
    private String objetivo;
    private String materialNecessario;
    private double duracao;
    private int repeticoes;

    public ExercicioAddModel(String nomeExercicio, CategoriaTreino categoriaExercicio, String descricao, String link, String objetivo, String materialNecessario, double duracao, int repeticoes) {
        this.nomeExercicio = nomeExercicio;
        this.categoriaExercicio = categoriaExercicio;
        this.descricao = descricao;
        this.link = link;
        this.objetivo = objetivo;
        this.materialNecessario = materialNecessario;
        this.duracao = duracao;
        this.repeticoes = repeticoes;
    }

    public ExercicioAddModel(String nomeExercicio, String descricao, String objetivo, double duracao, int repeticoes) {
        this.nomeExercicio = nomeExercicio;
        this.descricao = descricao;
        this.objetivo = objetivo;
        this.duracao = duracao;
        this.repeticoes = repeticoes;
    }

    public ExercicioAddModel(String nomeExercicio, CategoriaTreino categoriaExercicio, String descricao, String objetivo, String materialNecessario, double duracao, int repeticoes) {
        this.nomeExercicio = nomeExercicio;
        this.categoriaExercicio = categoriaExercicio;
        this.descricao = descricao;
        this.objetivo = objetivo;
        this.materialNecessario = materialNecessario;
        this.duracao = duracao;
        this.repeticoes = repeticoes;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public CategoriaTreino getCategoriaExercicio() {
        return categoriaExercicio;
    }

    public void setCategoriaExercicio(CategoriaTreino categoriaExercicio) {
        this.categoriaExercicio = categoriaExercicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getMaterialNecessario() {
        return materialNecessario;
    }

    public void setMaterialNecessario(String materialNecessario) {
        this.materialNecessario = materialNecessario;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }
}
