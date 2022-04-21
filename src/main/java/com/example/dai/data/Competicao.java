package com.example.dai.data;

import org.hibernate.mapping.Map;

import javax.persistence.*;

//Função para registar uma nova competição
@Entity
@Table()
public class Competicao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCompeticao;

    @Column(name="urlFederacao")
    private String urlFederacao;

    @Column(name="nome")
    private String nome;

    @Column(name="epoca")
    private String epoca;

    @Enumerated(EnumType.STRING)
    private Escalao escalao;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(name="numJornadas")
    private int numJornadas;
/*
    @OneToMany(mappedBy = "competicao")
    private Map<Long, Jogo> jogos;
*/
    public Competicao() {
    }

    public Competicao( String nome, String epoca, Escalao escalao, Genero genero, int numJornadas, String urlFederacao){
        this.urlFederacao = urlFederacao;
        this.nome = nome;
        this.epoca = epoca;
        this.escalao = escalao;
        this.genero = genero;
        this.numJornadas = numJornadas;
    }

    public Long getIdCompeticao() {
        return idCompeticao;
    }

    public void setIdCompeticao(Long idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    public String getUrlFederacao() {
        return urlFederacao;
    }

    public void setUrlFederacao(String urlFederacao) {
        this.urlFederacao = urlFederacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        nome = nome;
    }

    public String getEpoca() {
        return epoca;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    public Escalao getEscalao() {
        return escalao;
    }

    public void setEscalao(Escalao escalao) {
        this.escalao = escalao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getNumJornadas() {
        return numJornadas;
    }

    public void setNumJornadas(int numJornadas) {
        this.numJornadas = numJornadas;
    }
}
