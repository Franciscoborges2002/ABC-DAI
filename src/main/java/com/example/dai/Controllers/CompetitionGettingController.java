package com.example.dai.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Função para mostrar todas as competições registradas no repositório
@RestController
@RequestMapping("/api/v1/competition/all")
public class CompetitionGettingController {

    @GetMapping
    public String getCompetitions(){
        return "Competições:\n1. Campeonato nacional;\n2. Campeonate regional;\n3. Campeonato destrital;";
    }
}
