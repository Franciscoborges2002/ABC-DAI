package com.example.dai.repository;

import com.example.dai.data.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * This interface is responsible for data acess
 * */
@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {

    @Query("SELECT e FROM Exercicio e WHERE e.nomeExercicio = ?1")
    Optional<Exercicio> encontrarExercicioPeloNome(String nomeExercicio);

    @Query("SELECT e FROM Exercicio e WHERE e.nomeExercicio = ?1")
    Exercicio encontrarExercicioPeloNome2(String nomeExercicio);

    @Query("SELECT e FROM Exercicio e WHERE e.idExercicio = ?1")
    Exercicio encontrarExercicioPeloId(Long idExercicio);
}
