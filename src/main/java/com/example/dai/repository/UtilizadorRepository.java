package com.example.dai.repository;

import com.example.dai.data.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

/*
* This interface is responsible for data acess
* */
@Repository
public interface UtilizadorRepository
        extends JpaRepository<Utilizador, Long> {
    Optional<Utilizador> findByNomeUtilizador(String nomeUtilizador);

    Optional<Utilizador> findByEmail(String email);

    @Modifying
    @Query("update Utilizador u set u.nomeCompleto = ?2, u.dataNascimento = ?2, u.email = ?3, u.numeroTelemovel = ?4, u.password = ?5 where u.idUtilizador = ?1")
    void utilizadorMudarInfo(Long id, String nomeCompleto, Date dataNascimento,String email ,String numeroTelemovel, String password);
}
