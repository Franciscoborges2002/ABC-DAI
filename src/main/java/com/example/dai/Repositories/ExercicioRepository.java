package com.example.dai.Repositories;

import com.example.dai.Data.Class.Exercicio;

import java.util.HashMap;

public class ExercicioRepository {
    HashMap<Integer, Exercicio> exercises = new HashMap();

    public HashMap<Integer, Exercicio> getExercises(){return exercises;}

    public void setExercises(HashMap<Integer, Exercicio> exercises){ this.exercises = exercises;}

    public String addExercise(Exercicio exercicio){
        if(exercises.containsValue(exercicio)){
            return "Exercicio já adicionado";
        }else{
            exercises.put(exercicio.getIdExercicio(), exercicio);
            return "Exercicio adicionado";
        }
    }

    public String removeExercise(Exercicio exercicio){
        if(exercises.containsValue(exercicio)){
            exercises.remove(exercicio.getIdExercicio(), exercicio);
            return "O Exercicio foi removido com sucesso";
        }else{
            return "O Exercicio não foi encontrado";
        }
    }

}
