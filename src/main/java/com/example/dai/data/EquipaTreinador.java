package com.example.dai.data;
import javax.persistence.*;

@Entity
@Table(name="EquipaTreinador")
public class EquipaTreinador{
    @EmbeddedId
    private EquipaTreinadorId id;

    private long idEquipa;

    private long idTreinador;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idEquipa")
    private Equipa Equipa;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idTreinador")
    private Treinador treinador;

    public EquipaTreinador() {
    }

    public EquipaTreinador(long idEquipa, long idTreinador) {
        this.idEquipa = idEquipa;
        this.idTreinador = idTreinador;
    }

    public EquipaTreinadorId getId() {
        return id;
    }

    public void setId(EquipaTreinadorId id) {
        this.id = id;
    }

    public Treinador getTreinador() {
        return treinador;
    }

    public void setTreinador(Treinador treinador) {
        this.treinador = treinador;
    }
    
}
