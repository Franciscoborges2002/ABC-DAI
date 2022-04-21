package com.example.dai.data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRole;

    @Column(nullable = false, length= 45)
    private String nome;

    @OneToMany(
            mappedBy = "Utilizador",
            cascade = CascadeType.ALL
    )
    private Set<UtilizadorRole> utilizador;

    public Role() {
    }

    public Role(Long idRole, String nome) {
        this.idRole = idRole;
        this.nome = nome;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
