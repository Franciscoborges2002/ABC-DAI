package com.example.dai.data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Treinador")
public class Treinador extends Utilizador {

    @OneToMany(
            mappedBy = "equipa",
            cascade = CascadeType.ALL
    )
    private Set<EquipaTreinador> Equipa;

    public Treinador() {
    }

    public Treinador(String nomeUtilizador, String nomeCompleto, String password, Date dataNascimento, String email, String numeroTelemovel, Set<EquipaTreinador> equipa) {
        super(nomeUtilizador, nomeCompleto, password, dataNascimento, email, numeroTelemovel);
        this.Equipa = equipa;
    }

    public Treinador(String nomeUtilizador) {
        super(nomeUtilizador);
    }

    public Treinador(Long idUtilizador, String nomeUtilizador) {
        super(idUtilizador, nomeUtilizador);
    }

    public Treinador(String nomeUtilizador, String nomeCompleto, String password, Date dataNascimento, String email, String numeroTelemovel) {
        super(nomeUtilizador, nomeCompleto, password, dataNascimento, email, numeroTelemovel);
    }
}
