package com.example.dai.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EquipaTreinadorId implements Serializable {
        @Column(name = "idEquipa")
        private Long idEquipa;

        @Column(name = "idTreinador")
        private Long idTreinador;

        public EquipaTreinadorId() {
        }

        public EquipaTreinadorId(Long idEquipa, Long idTreinador) {
            this.idEquipa = idEquipa;
            this.idTreinador = idTreinador;
        }

        public Long getIdEquipa() {
            return idEquipa;
        }

        public void setIdEquipa(Long idEquipa) {
            this.idEquipa = idEquipa;
        }

        public Long getIdTreinador() {
            return idTreinador;
        }

        public void setIdTreinador(Long idTreinador) {
            this.idTreinador = idTreinador;
        }
}
