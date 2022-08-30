package com.example.dai.repository;

import com.example.dai.data.EquipaPavilhao;
import com.example.dai.data.EquipaPavilhaoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipaPavilhaoRepository extends JpaRepository<EquipaPavilhao, EquipaPavilhaoId> {

    @Modifying
    @Query("DELETE FROM EquipaPavilhao p WHERE p.equipa.idEquipa = ?1")
    void eliminarPavilhaoEquipa(Long idEquipa);
}
