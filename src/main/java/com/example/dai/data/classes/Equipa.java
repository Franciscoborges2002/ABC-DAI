package com.example.dai.data.classes;

import com.example.dai.data.enums.Escalao;
import com.example.dai.data.enums.Genero;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Objects;

@Entity
@Table
public class Equipa {
    @Id
    @SequenceGenerator(
            name = "equipa_sequence",
            sequenceName = "equipa_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "equipa_sequence"
    )
    private Long idEquipa;
    private String nome;
    private String morada;
    private String email;
    private String website;
    private String recinto;
    private Escalao escalao;
    private Genero genero;
    //private HashMap<String, Atleta> atletasNaEquipa;//String: nomeUtilizador
    //private HashMap<String, Treinador> treinadoresNaEquipa;//String: nomeUtilizador

    public Equipa() {
    }

    public Equipa(String nome, String morada, String recinto, Escalao escalao, Genero genero) {
        this.nome = nome;
        this.morada = morada;
        this.recinto = recinto;
        this.escalao = escalao;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getRecinto() {
        return recinto;
    }

    public void setRecinto(String recinto) {
        this.recinto = recinto;
    }

    public Escalao getEscalao() {
        return escalao;
    }

    public void setEscalao(Escalao escalao) {
        this.escalao = escalao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipa equipa = (Equipa) o;
        return Objects.equals(nome, equipa.nome) && Objects.equals(morada, equipa.morada) && Objects.equals(email, equipa.email) && Objects.equals(website, equipa.website) && Objects.equals(recinto, equipa.recinto) && escalao == equipa.escalao && genero == equipa.genero;
    }

    @Override
    public String toString() {
        return "Equipa{" +
                "nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", recinto='" + recinto + '\'' +
                ", escalao=" + escalao +
                ", genero=" + genero +
                '}';
    }
}
