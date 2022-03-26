package com.example.dai.Services;

import com.example.dai.Data.Class.Treino;
import org.springframework.stereotype.Service;

import static com.example.dai.Services.UtilizadorService.trainingRepositorie;

@Service
public class TreinoService {

    public static String addTrain(Treino treino){

        trainingRepositorie.addTrain(treino);
        return treino.toString();
    }

    public String listTrains(){
        return trainingRepositorie.getTrains().toString();
    }

    //Acabar a função
    public String changeInfoTrain(Treino train2Change) {
        if (trainingRepositorie.getTrains().containsKey(train2Change.getHorario())) {
            return "Treino editado com sucesso";
        } else {
            return "Treino não existe";
        }
    }

    //Acabar a função
    public String deleteTrain(Treino trainDelete){
        if(trainingRepositorie.getTrains().containsKey(trainDelete.getHorario())){
            return "Treino eliminado com sucesso";
        }
            return "Treino não existe";
    }
}
