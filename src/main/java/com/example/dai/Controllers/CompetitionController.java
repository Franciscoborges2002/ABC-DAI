package com.example.dai.Controllers;

/*
* Função para receber uma nova competições onde o ABC vai participar
* */

import com.example.dai.Data.Competition;
import com.example.dai.Services.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/competition")
public class CompetitionController {

    private final CompetitionService competitionService;

    @Autowired
    public CompetitionController(CompetitionService competitionService){this.competitionService = competitionService;}

    @PostMapping
    public String newCompetition(@RequestBody Competition newCompetition){
        return CompetitionService.addCompetition(newCompetition);
    }

    @GetMapping
    public String getCompetitions(){
        return "Competições:\n1. Campeonato nacional;\n2. Campeonate regional;\n3. Campeonato destrital;";
    }
}
