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

    Optional<Exercicio> findByNomeExercicio(String nomeExercicio);

    Exercicio findByIdExercicio(Long idExercicio);
}
