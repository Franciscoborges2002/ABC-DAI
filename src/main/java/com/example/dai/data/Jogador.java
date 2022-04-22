package com.example.dai.data;

import javax.persistence.*;

@Entity
public class Jogador extends Atleta{
    public Jogador() {

    }

    public Jogador(String nomeUtilizador, String password, String email) {
        super(nomeUtilizador, password, email);
    }


}
