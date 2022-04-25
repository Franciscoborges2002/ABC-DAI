package com.example.dai.data;

import javax.persistence.*;
import java.util.Date;

@Entity
public class GuardaRedes extends Atleta{
        private long idGuardaRedes;

        @Column(name = "golosSofridos")
        private long golosSofridos;

        @Column(name = "numeroDefesas")
        private long numeroDefesas;

        public GuardaRedes() {
        }

        public GuardaRedes(String nomeUtilizador, String password, String email) {
                super(nomeUtilizador, password, email);
        }

        public GuardaRedes(String nomeUtilizador, String nomeCompleto, String password, Date dataNascimento, String email, String numeroTelemovel) {
                super(nomeUtilizador, nomeCompleto, password, dataNascimento, email, numeroTelemovel);
        }
}
