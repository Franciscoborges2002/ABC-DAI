package com.example.dai.Controllers;

import com.example.dai.Data.Class.Exercicio;
import com.example.dai.Services.ExerciseService;
import com.example.dai.Services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Funcao para adicinar um exercicio à BD
@RestController
@RequestMapping("api/v1/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService){this.exerciseService= exerciseService;}

    @PostMapping
    public String createExercise(@RequestBody Exercicio exercicio){return exerciseService.addExercise(exercicio);}

    @GetMapping
    public String listExercise(){return exerciseService.listExercise();}

    @PutMapping
    public String editExercise(@RequestBody Exercicio exercicioNewInfo){return exerciseService.changeInfoExercise(exercicioNewInfo);}

    @DeleteMapping
    public String deleteExercise(@RequestBody  Exercicio exercicioDelete){return exerciseService.deleteExercise(exercicioDelete);}




}
