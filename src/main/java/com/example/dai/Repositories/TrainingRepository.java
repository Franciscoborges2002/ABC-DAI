package com.example.dai.Repositories;

import com.example.dai.Data.Class.Treino;

import java.time.LocalDate;
import java.util.HashMap;

public class TrainingRepository {
    HashMap<LocalDate, Treino> trains = new HashMap();

    public HashMap<LocalDate, Treino> getTrains(){return trains;}

    public void setTrains(HashMap<LocalDate, Treino> trains){ this.trains = trains;}

    public String addTrain(Treino treino){
        if(trains.containsValue(treino)){
            return "Treino já adicionado";
        }else{
            trains.put(treino.getHorario(), treino);
            return "Treino adicionado";
        }
    }

    public String removeTrain(Treino treino){
        if(trains.containsValue(treino)){
            trains.remove(treino.getHorario(), treino);
            return "O treino foi removido com sucesso";
        }else{
            return "O treino não foi encontrado";
        }
    }
}
