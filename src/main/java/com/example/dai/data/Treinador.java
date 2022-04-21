package com.example.dai.data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Treinador extends Utilizador {

    @OneToMany(
            mappedBy = "Equipa",
            cascade = CascadeType.ALL
    )
    private Set<EquipaTreinador> equipa;

    public Treinador() {
    }

    public Treinador(String nomeUtilizador, String nomeCompleto, String password, Date dataNascimento, String email, String numeroTelemovel, Set<EquipaTreinador> equipa) {
        super(nomeUtilizador, nomeCompleto, password, dataNascimento, email, numeroTelemovel);
        this.equipa = equipa;
    }

    public Treinador(String nomeUtilizador, String nomeCompleto, String password, Date dataNascimento, String email, String numeroTelemovel) {
        super(nomeUtilizador, nomeCompleto, password, dataNascimento, email, numeroTelemovel);
    }
}
