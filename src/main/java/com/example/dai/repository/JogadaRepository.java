package com.example.dai.repository;

import com.example.dai.data.Jogada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JogadaRepository extends JpaRepository<Jogada, Long> {

    Optional<Jogada> findByNomeJogada(String nomeJogada);

    Optional<Jogada> findByDescricaoJogada(String descricaoJogada);

    @Modifying
    @Query("update Jogada j set j.nomeJogada = ?2, j.descricaoJogada = ?3 where j.id = ?1")
    void jogadaMudarInformacao(Long idJogada, String nomeJogada, String descricaoJogada);
}
