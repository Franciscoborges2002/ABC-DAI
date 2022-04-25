package com.example.dai.data;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Jogador extends Atleta{
    public Jogador() {

    }

    public Jogador(String nomeUtilizador, String nomeCompleto, String password, Date dataNascimento, String email, String numeroTelemovel) {
        super(nomeUtilizador, nomeCompleto, password, dataNascimento, email, numeroTelemovel);
    }
}
