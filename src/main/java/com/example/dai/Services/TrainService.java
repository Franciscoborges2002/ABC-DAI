package com.example.dai.Services;

import com.example.dai.Data.Class.Treino;
import org.springframework.stereotype.Service;

import static com.example.dai.Services.SignUpService.trainingRepositorie;

@Service
public class TrainService {

    public static String addTrain(Treino treino){
        //trainingRepositorie.addTrain(treino);
        return treino.toString();
    }

    public static String listTrains(){
        return trainingRepositorie.getTrains().toString();
    }
}
