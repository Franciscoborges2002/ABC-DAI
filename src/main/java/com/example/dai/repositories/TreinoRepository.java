package com.example.dai.repositories;

import com.example.dai.data.classes.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long> {
    @Query("SELECT t FROM Treino t WHERE t.nomeTreino = ?1")
    Optional<Treino> encontrarTreinoPeloNome(String nomeTreino);
}
