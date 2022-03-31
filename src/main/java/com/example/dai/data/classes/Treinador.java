package com.example.dai.data.classes;

import javax.persistence.*;

@Entity
@Table
public class Treinador extends Utilizador {
    @SequenceGenerator(
            name = "treinador_sequence",
            sequenceName = "treinador_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "treinador_sequence"
    )
    private Long idTreinador;
}
