package com.example.dai.Controllers;

import com.example.dai.Data.Class.Treino;
import com.example.dai.Services.TrainService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Função para aidionar um novo treino à BD
@RestController
@RequestMapping("/api/v1/trains/add")
public class AddTrainController {

    @PostMapping
    public String addTrain(@RequestBody Treino treino){
        return TrainService.addTrain(treino);
    }
}
