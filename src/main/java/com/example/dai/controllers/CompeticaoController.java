package com.example.dai.controllers;

/*
* Função para receber uma nova competições onde o ABC vai participar
* */

import com.example.dai.data.classes.Competicao;
import com.example.dai.data.enums.Escalao;
import com.example.dai.data.enums.Genero;
import com.example.dai.model.CompeticaoAddModel;
import com.example.dai.services.CompeticaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/competition")
public class CompeticaoController {

    private final CompeticaoService competicaoService;

    @Autowired
    public CompeticaoController(CompeticaoService competitionService){this.competicaoService = competitionService;}

    @PostMapping
    public String newCompetition(@RequestBody CompeticaoAddModel novaCompetition){
        return competicaoService.adicionarCompeticao(novaCompetition);
    }

    @GetMapping
    public List<Competicao> listarCompeticoes(){
        return competicaoService.listarCompeticoes();
    }

    @GetMapping(path="{idCompeticao}")
    public String listarCompeticao(@PathVariable("idCompeticao") Long idCompeticao){
        return competicaoService.listarCompeticao(idCompeticao);
    }

    @DeleteMapping(path="{idCompeticao}")
    public String removerCompeticao(@PathVariable("idCompeticao") Long idCompeticao){
        return competicaoService.removerCompeticao(idCompeticao);
    }

    //Adidionar mudar informações competição
    @PutMapping(path="{idCompeticao}")
    public String editarCompeticao(
            @PathVariable Long idCompeticao,
            @RequestParam(required = false) String urlFederacao,
            @RequestParam(required = false) String Nome,
            @RequestParam(required = false) String epoca,
            @RequestParam(required = false) Escalao escalao,
            @RequestParam(required = false) Genero genero,
            @RequestParam(required = false) int numJornadas
    ){
        return competicaoService.editarCompeticao(idCompeticao, urlFederacao, Nome, epoca, escalao, genero, numJornadas);
    }
}
