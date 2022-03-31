package com.example.dai.controllers;

/*
* Função para receber uma nova competições onde o ABC vai participar
* */

import com.example.dai.data.classes.Competicao;
import com.example.dai.services.CompeticaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/competition")
public class CompeticaoController {

    private final CompeticaoService competicaoService;

    @Autowired
    public CompeticaoController(CompeticaoService competitionService){this.competicaoService = competitionService;}

    @PostMapping
    public String newCompetition(@RequestBody Competicao novaCompetition){
        return competicaoService.adicionarCompeticao(novaCompetition);
    }

    @GetMapping
    public String getCompetitions(){
        return "Competições:\n1. Campeonato nacional;\n2. Campeonate regional;\n3. Campeonato destrital;";
    }
}
