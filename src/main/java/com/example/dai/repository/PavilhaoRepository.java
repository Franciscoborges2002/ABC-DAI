package com.example.dai.repository;

import com.example.dai.data.Pavilhao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PavilhaoRepository extends JpaRepository<Pavilhao, Long> {
    @Query("SELECT p FROM Pavilhao p  WHERE p.nomePavilhao = ?1")
    Optional<Pavilhao> encontrarPavilhaoPeloNome(String nomeCompeticao);

    @Query("SELECT p FROM Pavilhao p WHERE p.localizacao = ?1")
    Optional<Pavilhao> encontrarPavilhaoPelaLocalizacao(String localizacao);

    //Não sei se é assim
    @Query("SELECT p FROM Pavilhao p WHERE p.numeroDeTreinosPorHora = ?1")
    Pavilhao[] pavilhoesPorNumeroTreinos(int numeroTreinos);

    @Query("SELECT p FROM Pavilhao p WHERE p.nomePavilhao = ?1")
    Pavilhao encontrarPavilhaoPeloNome2(String nomePavilhao);

    @Query("SELECT p FROM Pavilhao p WHERE p.idPavilhao = ?1")
    Pavilhao encontrarPavilhaoPeloId(Long idPavilhao);

}
