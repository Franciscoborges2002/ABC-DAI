package com.example.dai.data.classes;

import javax.persistence.*;

//Função para registar uma nova competição, url. o resto vamos buscar ao website da federação;
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
    private String Nome;

    public String getURL() {
        return Nome;
    }

    public void setURL(String URL) {
        this.Nome = URL;
    }
}
