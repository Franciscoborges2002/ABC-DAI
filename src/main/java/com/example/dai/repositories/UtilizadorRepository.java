package com.example.dai.repositories;

import com.example.dai.data.classes.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
* This interface is responsible for data acess
* */
@Repository
public interface UtilizadorRepository
        extends JpaRepository<Utilizador, Long> {

}
