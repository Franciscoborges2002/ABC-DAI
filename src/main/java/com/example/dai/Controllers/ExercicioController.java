package com.example.dai.Controllers;

import com.example.dai.Data.Class.Exercicio;
import com.example.dai.Services.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Funcao para adicinar um exercicio à BD
@RestController
@RequestMapping("api/v1/exercise")
public class ExercicioController {

    private final ExercicioService exercicioService;

    @Autowired
    public ExercicioController(ExercicioService exerciseService){this.exercicioService= exerciseService;}

    @PostMapping
    public String createExercise(@RequestBody Exercicio exercicio){return exercicioService.addExercise(exercicio);}

    @GetMapping
    public String listExercise(){return exercicioService.listExercise();}

    @PutMapping
    public String editExercise(@RequestBody Exercicio exercicioNewInfo){return exercicioService.changeInfoExercise(exercicioNewInfo);}

    @DeleteMapping
    public String deleteExercise(@RequestBody  Exercicio exercicioDelete){return exercicioService.deleteExercise(exercicioDelete);}




}
