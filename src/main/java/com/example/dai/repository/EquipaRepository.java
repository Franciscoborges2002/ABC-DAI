package com.example.dai.repository;

import com.example.dai.data.Equipa;
import org.springframework.data.jpa.repository.JpaRepository;;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipaRepository extends JpaRepository<Equipa, Long> {
    Optional<Equipa> findByNome(String nomeEquipa);
}
