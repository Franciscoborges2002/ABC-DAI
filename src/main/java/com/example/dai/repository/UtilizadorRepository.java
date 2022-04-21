package com.example.dai.repository;

import com.example.dai.data.Utilizador;
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
    Optional<Utilizador> findByNomeUtilizador(String nomeUtilizador);

    Optional<Utilizador> findByEmail(String email);
}
