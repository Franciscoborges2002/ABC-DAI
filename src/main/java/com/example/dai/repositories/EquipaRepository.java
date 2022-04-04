package com.example.dai.repositories;

import com.example.dai.data.classes.Equipa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * This interface is responsible for data acess
 * */
@Repository
public interface EquipaRepository extends JpaRepository<Equipa, Long> {
    @Query("SELECT e FROM Equipa e WHERE e.nome = ?1")
    Optional<Equipa> encontrarEquipaPeloNome(String nomeEquipa);

}
