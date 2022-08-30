package com.example.dai.data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Exercicio{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExercicio;

    @Column(name="nomeExercicio", length = 250, nullable = false, unique = true)
    private String nomeExercicio;

    @Enumerated(EnumType.STRING)
    @Column(name="categoriaExercicio")
    private CategoriaTreino categoriaExercicio;

    @Column(name="descricaoExercicio")
    private String descricao;

    @Column(name="linkImagemExercicio")
    private String link;

    @Column(name="objetivoExercicio")
    private String objetivo;

    @Column(name="materiaNecessarioExercicio")
    private String materialNecessario;

    @Column(name="duracaoExercicio")
    private double duracao;

    @Column(name="repeticoesExercicio")
    private int repeticoes;

    @OneToMany(
            mappedBy = "treino",
            cascade = CascadeType.ALL
    )
    private Set<TreinoExercicio> treino;

    public Exercicio() {

    }

    public Exercicio(String nomeExercicio, CategoriaTreino categoriaExercicio, String descricao, String link, String objetivo, String materialNecessario, double duracao, int repeticoes) {
        this.nomeExercicio = nomeExercicio;
        this.categoriaExercicio = categoriaExercicio;
        this.descricao = descricao;
        this.link = link;
        this.objetivo = objetivo;
        this.materialNecessario = materialNecessario;
        this.duracao = duracao;
        this.repeticoes = repeticoes;
    }

    public String getMaterialNecessario() {
        return materialNecessario;
    }

    public void setMaterialNecessario(String materialNecessario) {
        this.materialNecessario = materialNecessario;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public CategoriaTreino getCategoriaTreino() {
        return categoriaExercicio;
    }

    public void setCategoriaTreino(CategoriaTreino categoriaTreino) {
        this.categoriaExercicio = categoriaTreino;
    }

    public CategoriaTreino getCategoriaExercicio() {
        return categoriaExercicio;
    }

    public void setCategoriaExercicio(CategoriaTreino categoriaExercicio) {
        this.categoriaExercicio = categoriaExercicio;
    }

    @Override
    public String toString() {
        return "Exercicio{" +
                "idExercicio=" + idExercicio +
                ", nomeExercicio='" + nomeExercicio + '\'' +
                ", categoriaExercicio=" + categoriaExercicio +
                '}';
    }
}
