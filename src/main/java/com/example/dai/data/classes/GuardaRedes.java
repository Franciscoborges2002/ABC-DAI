package com.example.dai.data.classes;

import javax.persistence.*;

@Entity
@Table
public class GuardaRedes extends Atleta{
        @SequenceGenerator(
                name = "guardaredes_sequence",
                sequenceName = "guardaredes_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "guardaredes_sequence"
        )
        private long idGuardaRedes;
        private long golosSofridos;
        private long numeroDefesas;

}
