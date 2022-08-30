package com.example.dai.repository;

import com.example.dai.data.GuardaRedes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuardaRedesRepository extends JpaRepository<GuardaRedes, Long> {
}
