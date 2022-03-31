package com.example.dai.config;

import com.example.dai.data.classes.Utilizador;
import com.example.dai.repositories.UtilizadorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UtilizadorConfig {

    @Bean
    CommandLineRunner commandLineRunner(UtilizadorRepository repository){
        return args -> {
          Utilizador a =new Utilizador(
                  1L,
                "teste",
                  "teste",
                  "teste@gmail.com"

          );

            repository.saveAll(
                  List.of(a)
          );
        };
    }
}
