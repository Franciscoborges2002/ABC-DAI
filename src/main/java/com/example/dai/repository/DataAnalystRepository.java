package com.example.dai.repository;

import com.example.dai.data.DataAnalyst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataAnalystRepository extends JpaRepository<DataAnalyst, Long> {
}
