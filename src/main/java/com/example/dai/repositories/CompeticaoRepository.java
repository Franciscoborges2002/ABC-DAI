package com.example.dai.repositories;

import com.example.dai.data.classes.Competicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * This interface is responsible for data acess
 * */
@Repository
public interface CompeticaoRepository extends JpaRepository<Competicao, Long> {
}