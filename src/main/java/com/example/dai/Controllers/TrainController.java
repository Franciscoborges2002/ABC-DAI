package com.example.dai.Controllers;

import com.example.dai.Data.Class.Treino;
import com.example.dai.Services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Função para aidionar um novo treino à BD
@RestController
@RequestMapping("/api/v1/train")
public class TrainController {

    private final TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService){this.trainService = trainService;}

    @PostMapping
    public String createTrain(@RequestBody Treino treino){
        return TrainService.addTrain(treino);
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


}
