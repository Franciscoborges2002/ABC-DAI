package com.example.dai.repository;

import com.example.dai.data.Jogo;
import com.example.dai.model.JogoAddModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

}

