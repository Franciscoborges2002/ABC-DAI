package com.example.dai.data;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Diretor extends Utilizador{

    public Diretor() {

    }

    public Diretor(String nomeUtilizador, String nomeCompleto, String password, Date dataNascimento, String email, String numeroTelemovel) {
        super(nomeUtilizador, nomeCompleto, password, dataNascimento, email, numeroTelemovel);
    }
}
