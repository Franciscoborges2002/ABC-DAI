package com.example.dai.data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Utilizador")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilizador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idUtilizador;

    @Column(name="nomeUtilizador", length = 20)
    private String nomeUtilizador;

    @Column(name="nomeCompleto")
    private String nomeCompleto;

    @Column(name="password", nullable = false)
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name="dataNascimento")
    private Date dataNascimento;

    @Column(name="email")
    private String email;

    @Column(name="telemovel")
    private String numeroTelemovel;

    @OneToMany(
            mappedBy="Role",
            cascade = CascadeType.ALL
    )
    private Set<UtilizadorRole> role;

    public Utilizador() {
    }

    public Utilizador(Long idUtilizador, String nomeUtilizador) {
        this.idUtilizador = idUtilizador;
        this.nomeUtilizador = nomeUtilizador;
    }

    public Utilizador(String nomeUtilizador) {
        this.nomeUtilizador = nomeUtilizador;
    }

    public Utilizador(String nomeUtilizador, String password) {
        this.nomeUtilizador = nomeUtilizador;
        this.password = password;
    }

    public Utilizador(String nomeUtilizador, String nomeCompleto, String password, Date dataNascimento, String email, String numeroTelemovel) {
        this.nomeUtilizador = nomeUtilizador;
        this.nomeCompleto = nomeCompleto;
        this.password = password;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.numeroTelemovel = numeroTelemovel;
    }

    public Utilizador(String nomeUtilizador, String password, String email) {
        this.nomeUtilizador = nomeUtilizador;
        this.password = password;
        this.email = email;
    }

    public Utilizador(Long idUtilizador, String nomeUtilizador, String password, String email) {
        this.idUtilizador = idUtilizador;
        this.nomeUtilizador = nomeUtilizador;
        this.password = password;
        this.email = email;
    }

    public Utilizador(Long idUtilizador, String nomeUtilizador, String nomeCompleto, String password, Date dataNascimento, String email, String numeroTelemovel) {
        this.idUtilizador = idUtilizador;
        this.nomeUtilizador = nomeUtilizador;
        this.nomeCompleto = nomeCompleto;
        this.password = password;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.numeroTelemovel = numeroTelemovel;
    }

    public Long getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Long idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public String getNomeUtilizador() {
        return nomeUtilizador;
    }

    public void setNomeUtilizador(String nomeUtilizador) {
        this.nomeUtilizador = nomeUtilizador;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelemovel() {
        return numeroTelemovel;
    }

    public void setNumeroTelemovel(String numeroTelemovel) {
        this.numeroTelemovel = numeroTelemovel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizador that = (Utilizador) o;
        return Objects.equals(nomeUtilizador, that.nomeUtilizador) && Objects.equals(nomeCompleto, that.nomeCompleto) && Objects.equals(password, that.password) && Objects.equals(dataNascimento, that.dataNascimento) && Objects.equals(email, that.email) && Objects.equals(numeroTelemovel, that.numeroTelemovel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeUtilizador, nomeCompleto, password, dataNascimento, email, numeroTelemovel);
    }

    @Override
    public String toString() {
        return "Utilizador{" +
                "nomeUtilizador='" + nomeUtilizador + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", password='" + password + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", email='" + email + '\'' +
                ", numeroTelemovel='" + numeroTelemovel + '\'' +
                '}';
    }
}