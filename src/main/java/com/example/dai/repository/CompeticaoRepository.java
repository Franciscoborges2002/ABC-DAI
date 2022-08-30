package com.example.dai.repository;

import com.example.dai.data.Competicao;
import com.example.dai.data.Escalao;
import com.example.dai.data.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying
    @Query("update Competicao c set c.urlFederacao = ?2, c.nome = ?3, c.escalao = ?4, c.genero = ?5, c.numJornadas = ?6, c.epoca = ?7 where c.idCompeticao = ?1")
    void competicaoMudarInfo(Long Id, String urlFederacao, String nomeCompeticao, Escalao escalao, Genero genero, int numJornadas, String Epoca);
}
