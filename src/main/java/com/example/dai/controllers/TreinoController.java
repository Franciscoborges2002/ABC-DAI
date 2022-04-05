package com.example.dai.controllers;

import com.example.dai.data.classes.Equipa;
import com.example.dai.data.classes.Treino;
import com.example.dai.data.enums.Escalao;
import com.example.dai.data.enums.Genero;
import com.example.dai.model.TreinoAddModel;
import com.example.dai.services.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//Função para aidionar um novo treino à BD
@RestController
@RequestMapping("/api/v1/treino")
public class TreinoController {

    private final TreinoService treinoService;

    @Autowired
    public TreinoController(TreinoService trainService){this.treinoService = trainService;}

    @PostMapping
    public String addTrain(@RequestBody TreinoAddModel treino){
        return treinoService.adicionarTreino(treino);
    }

    @GetMapping
    public List<Treino> listTrains(){
        return treinoService.listarTreinos();
    }

    @PutMapping(path = "{idTreino}")
    public void editTrain(
            @PathVariable Long idTreino,
            @RequestParam(required = false) String nomeTreino,
            @RequestParam(required = false) Equipa equipa,
            @RequestParam(required = false) LocalDate horario,
            @RequestParam(required = false) String localizacao
    ){
        treinoService.mudarInformacaoTreino(idTreino, nomeTreino, equipa, horario, localizacao);
    }

    @DeleteMapping(path = "{idTreino}")
    public void deleteTreino(@RequestBody long idTreino){
         treinoService.eliminarTreino(idTreino);
    }


}
