package com.example.dai.data;

import javax.persistence.*;

@Entity
@Table(name = "UtilizadorRole")
public class UtilizadorRole {

    @EmbeddedId
    private UtilizadorRoleId id;

    private long idUtilizador;

    private long idRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUtilizador")
    private Utilizador Utilizador;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idRole")
    private Role Role;

    public UtilizadorRole() {
    }

    public UtilizadorRole(Long idUtilizador, Long idRole) {
        this.idUtilizador = idUtilizador;
        this.idRole = idRole;
    }

    public UtilizadorRoleId getId() {
        return id;
    }

    public void setId(UtilizadorRoleId id) {
        this.id = id;
    }

    public long getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(long idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }
}
