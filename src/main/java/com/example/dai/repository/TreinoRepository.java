package com.example.dai.repository;

import com.example.dai.data.Equipa;
import com.example.dai.data.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long> {
    @Query("SELECT t FROM Treino t WHERE t.nomeTreino = ?1")
    Optional<Treino> encontrarTreinoPeloNome(String nomeTreino);

    @Query("SELECT e FROM Equipa e WHERE e.nome = ?1")
    Equipa encontrarEquipaPeloNome2(String nomeEquipa);

    @Query("SELECT e FROM Equipa e WHERE e.idEquipa = ?1")
    Equipa encontrarEquipaPeloId(Long idEquipa);
}
