package com.example.dai.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UtilizadorRoleId implements Serializable {

    @Column(name = "idUtilizador")
    private Long idUtilizador;

    @Column(name = "idRole")
    private Long idRole;

    public UtilizadorRoleId() {
    }

    public UtilizadorRoleId(Long idUtilizador, Long idRole) {
        this.idUtilizador = idUtilizador;
        this.idRole = idRole;
    }

    public Long getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Long idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }
}
