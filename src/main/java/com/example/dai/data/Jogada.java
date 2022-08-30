package com.example.dai.data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table()
public class Jogada {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="nomeJogada")
    private String nomeJogada;

    @Column(name="descricaoJogada")
    private String descricaoJogada;

    @Enumerated
    private TipoJogada tipoJogada;

    @OneToMany(
            mappedBy = "jogo",
            cascade = CascadeType.ALL
    )
    private Set<JogoJogada> jogo;

    public Jogada() {
    }

    public Jogada(Long id, String nomeJogada, String descricaoJogada) {
        this.id = id;
        this.nomeJogada = nomeJogada;
        this.descricaoJogada = descricaoJogada;
    }

    public Jogada(String nomeJogada, String descricaoJogada, TipoJogada tipoJogada) {
        this.nomeJogada = nomeJogada;
        this.descricaoJogada = descricaoJogada;
        this.tipoJogada = tipoJogada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeJogada() {
        return nomeJogada;
    }

    public void setNomeJogada(String nomeJogada) {
        this.nomeJogada = nomeJogada;
    }

    public String getDescricaoJogada() {
        return descricaoJogada;
    }

    public void setDescricaoJogada(String descricaoJogada) {
        this.descricaoJogada = descricaoJogada;
    }

    public TipoJogada getTipoJogada() {
        return tipoJogada;
    }

    public void setTipoJogada(TipoJogada tipoJogada) {
        this.tipoJogada = tipoJogada;
    }
}
