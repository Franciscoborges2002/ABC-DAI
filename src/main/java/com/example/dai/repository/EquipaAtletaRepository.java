package com.example.dai.repository;

import com.example.dai.data.Atleta;
import com.example.dai.data.EquipaAtleta;
import com.example.dai.data.EquipaAtletaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EquipaAtletaRepository extends JpaRepository<EquipaAtleta, EquipaAtletaId> {

    @Modifying
    @Query("DELETE FROM EquipaAtleta a WHERE a.equipa.idEquipa = ?1")
    void eliminarAtletaEquipa(Long idEquipa);
/*
    @Query("SELECT Atleta FROM EquipaAtleta e where e.equipa.idEquipa = ?1")
    Atleta findByIdEquipa(Long IdEquipa);*/
}
