package com.example.dai.data.classes;

import javax.persistence.*;

@Entity
@Table
public class Jogador extends Atleta{
    @SequenceGenerator(
            name = "jogador_sequence",
            sequenceName = "jogador_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "jogador_sequence"
    )
    private long idJogador;//Mudar depois

    public long getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(long idJogador) {
        this.idJogador = idJogador;
    }
}
