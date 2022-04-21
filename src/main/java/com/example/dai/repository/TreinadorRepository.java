package com.example.dai.repository;

import com.example.dai.data.Treinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * This interface is responsible for data acess
 * */
@Repository
public interface TreinadorRepository extends JpaRepository<Treinador, Long> {

    @Query("SELECT t FROM Treinador t WHERE t.nomeUtilizador = ?1")
    Optional<Treinador> encontrarTreinadorPeloNome(String nomeTreinador);

    @Query("SELECT t FROM Treinador t WHERE t.nomeUtilizador = ?1")
    Treinador encontrarTreinadorPeloNome2(String nomeTreinador);

    @Query("SELECT t FROM Treinador t WHERE t.idUtilizador = ?1")
    Treinador encontrarTreinadorPeloId(Long idTreinador);
}
