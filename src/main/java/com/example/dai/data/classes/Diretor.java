package com.example.dai.data.classes;

import javax.persistence.*;

@Entity
@Table
public class Diretor extends Utilizador{
    @SequenceGenerator(
            name = "diretor_sequence",
            sequenceName = "diretor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "diretor_sequence"
    )
    private Long idDiretor;
}
