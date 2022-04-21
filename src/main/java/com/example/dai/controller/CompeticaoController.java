package com.example.dai.controller;

/*
* Função para receber uma nova competições onde o ABC vai participar
* */

import com.example.dai.data.Competicao;
import com.example.dai.data.Escalao;
import com.example.dai.data.Genero;
import com.example.dai.model.CompeticaoAddModel;
import com.example.dai.model.CompeticaoDto;
import com.example.dai.model.UtilizadorDto;
import com.example.dai.service.CompeticaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/competicao")
public class CompeticaoController {

    private final CompeticaoService competicaoService;

    @Autowired
    public CompeticaoController(CompeticaoService competitionService){this.competicaoService = competitionService;}

    @PostMapping
    public ResponseEntity<CompeticaoDto> adicionarCompeticao(@RequestBody CompeticaoAddModel novaCompetition){
            CompeticaoDto competicao =  competicaoService.adicionarCompeticao(novaCompetition);
            return new ResponseEntity(competicao, HttpStatus.CREATED);

    }

    @GetMapping
    public List<Competicao> listarCompeticoes(){
        return competicaoService.listarCompeticoes();
    }

    @GetMapping(path="{idCompeticao}")
    public ResponseEntity<CompeticaoDto> listarCompeticao(@PathVariable("idCompeticao") Long idCompeticao){
        Competicao response = competicaoService.listarCompeticao(idCompeticao);

        return new ResponseEntity(new CompeticaoDto("Competição criado com sucesso!", response), HttpStatus.OK);
    }

    @DeleteMapping(path="{idCompeticao}")
    public ResponseEntity removerCompeticao(@PathVariable("idCompeticao") Long idCompeticao){
        competicaoService.removerCompeticao(idCompeticao);
        return  new ResponseEntity(HttpStatus.OK);
    }

    //Adidionar mudar informações competição
    @PutMapping(path="{idCompeticao}")
    public ResponseEntity editarCompeticao(
            @PathVariable Long idCompeticao,
            @RequestParam(required = false) String urlFederacao,
            @RequestParam(required = false) String Nome,
            @RequestParam(required = false) String epoca,
            @RequestParam(required = false) Escalao escalao,
            @RequestParam(required = false) Genero genero,
            @RequestParam(required = false) int numJornadas
    ){
         competicaoService.editarCompeticao(idCompeticao, urlFederacao, Nome, epoca, escalao, genero, numJornadas);
        return  new ResponseEntity(HttpStatus.OK);

    }
}
