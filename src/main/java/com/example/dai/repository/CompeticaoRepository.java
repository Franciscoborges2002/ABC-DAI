package com.example.dai.repository;

import com.example.dai.data.Competicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * This interface is responsible for data acess
 * */
@Repository
public interface CompeticaoRepository extends JpaRepository<Competicao, Long> {

    @Query("SELECT c FROM Competicao c WHERE c.nome = ?1")
    Optional<Competicao> encontrarCompeticaoPeloNome(String nomeCompeticao);

    @Query("SELECT c FROM Competicao c WHERE c.urlFederacao = ?1")
    Optional<Competicao> encontrarCompeticaoPeloUrl(String nomeCompeticao);

    @Query("SELECT c FROM Competicao c WHERE c.nome = ?1")
    Competicao encontrarCompeticaoPeloNome2(String nomeCompeticao);

    @Query("SELECT c FROM Competicao c WHERE c.nome = ?1")
    Competicao encontrarCompeticaoPeloId(Long idCompeticao);
}
