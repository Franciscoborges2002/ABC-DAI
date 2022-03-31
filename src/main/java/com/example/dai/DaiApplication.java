package com.example.dai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication()
public class DaiApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SpringApplication.run(DaiApplication.class, args);
    }
}
