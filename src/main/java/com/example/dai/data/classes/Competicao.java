package com.example.dai.data.classes;

import com.example.dai.data.enums.Escalao;
import com.example.dai.data.enums.Genero;

import javax.persistence.*;

//Função para registar uma nova competição
@Entity
@Table
public class Competicao {
    @Id
    @SequenceGenerator(
            name = "competicao_sequence",
            sequenceName = "competicao_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "competicao_sequence"
    )
    private Long idCompeticao;
    private String urlFederacao;
    private String Nome;
    private String epoca;
    private Escalao escalao;
    private Genero genero;
    private int numJornadas;

    public Competicao() {
    }

    public Competicao(String nome, String epoca, Escalao escalao, Genero genero, int numJornadas) {
        Nome = nome;
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
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
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
