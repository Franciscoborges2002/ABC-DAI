package com.example.dai.repositories;

import com.example.dai.data.classes.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
* This interface is responsible for data acess
* */
@Repository
public interface UtilizadorRepository
        extends JpaRepository<Utilizador, Long> {

    @Query("SELECT u FROM Utilizador u WHERE u.nomeUtilizador = ?1")
    Optional<Utilizador> encontrarUtilizadorPeloNomeUtilizador(String nomeUtilizador);

    @Query("SELECT u FROM Utilizador u WHERE u.email = ?1")
    Optional<Utilizador> encontrarNomeUtilizadorPeloEmail(String email);
}
