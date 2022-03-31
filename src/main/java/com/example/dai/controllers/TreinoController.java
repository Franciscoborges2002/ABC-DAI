package com.example.dai.controllers;

import com.example.dai.data.classes.Treino;
import com.example.dai.services.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Função para aidionar um novo treino à BD
@RestController
@RequestMapping("/api/v1/train")
public class TreinoController {

    private final TreinoService trainService;

    @Autowired
    public TreinoController(TreinoService trainService){this.trainService = trainService;}
/*
    @PostMapping
    public String createTrain(@RequestBody Treino treino){
        return TreinoService.addTrain(treino);
    }

    @GetMapping
    public String listTrains(){
        return trainService.listTrains();
    }

    @PutMapping
    public String editTrain(@RequestBody Treino trainNewInfo){
        return trainService.changeInfoTrain(trainNewInfo);
    }
    @DeleteMapping
    public String deleteTrain(@RequestBody Treino trainDelete){
        return trainService.deleteTrain(trainDelete);
    }
*/

}
