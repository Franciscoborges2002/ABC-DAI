package com.example.dai.data;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class DataAnalyst extends Utilizador{

    public DataAnalyst() {
    }

    public DataAnalyst(String nomeUtilizador, String nomeCompleto, String password, Date dataNascimento, String email, String numeroTelemovel, String tipoUtilizador) {
        super(nomeUtilizador, nomeCompleto, password, dataNascimento, email, numeroTelemovel, tipoUtilizador);
    }
}
