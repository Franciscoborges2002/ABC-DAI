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
}
