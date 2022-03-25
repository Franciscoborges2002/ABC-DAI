package com.example.dai.Services;

import com.example.dai.Data.Class.Exercicio;
import org.springframework.stereotype.Service;

import static com.example.dai.Services.UsersService.exerciseRepositorie;


@Service
public class ExerciseService {

    public static String addExercise(Exercicio exercicio){
        exerciseRepositorie.addExercise(exercicio);
        return exercicio.toString();
    }

    public String listExercise(){
        return exerciseRepositorie.toString();
    }

    //Acabar a função
    public String changeInfoExercise(Exercicio exercicio) {
        if (exerciseRepositorie.getExercises().containsKey(exercicio.getIdExercicio())) {
            return "exercicio editado com sucesso";
        } else {
            return "exercicio não existe";
        }
    }

    //Acabar a função
    public String deleteExercise(Exercicio exercicio){
        if(exerciseRepositorie.getExercises().containsKey(exercicio.getIdExercicio())){
            exerciseRepositorie.removeExercise(exercicio);
            return "exercicio removido com sucesso";
        }
        return "exercicio não existe";
    }
}
