package com.example.dai.repository;

import com.example.dai.data.Equipa;
import com.example.dai.data.Escalao;
import com.example.dai.data.Genero;
import org.springframework.data.jpa.repository.JpaRepository;;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipaRepository extends JpaRepository<Equipa, Long> {
    Optional<Equipa> findByNome(String nomeEquipa);

    @Modifying
    @Query("UPDATE Equipa e SET e.nome = ?2, e.escalao = ?3, e.genero = ?4 WHERE e.idEquipa = ?1 ")
    void mudarInformacaoEquipa(Long idEquipa, String nomeEquipa, Escalao escalao, Genero genero);
}
