package com.example.dai.repository;

import com.example.dai.data.EquipaTreinador;
import com.example.dai.data.EquipaTreinadorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipaTreinadorRepository extends JpaRepository<EquipaTreinador, EquipaTreinadorId> {

    @Modifying
    @Query("DELETE FROM EquipaTreinador t WHERE t.equipa.idEquipa = ?1")
    void eliminarTreinadorEquipa(Long idEquipa);
}
