package com.example.dai.controller;

import com.example.dai.data.Exercicio;
import com.example.dai.data.CategoriaTreino;
import com.example.dai.model.ExercicioAddModel;
import com.example.dai.model.ExercicioDto;
import com.example.dai.service.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/exercicio")
public class ExercicioController {

    private final ExercicioService exercicioService;

    @Autowired
    public ExercicioController(ExercicioService exerciseService){this.exercicioService= exerciseService;}

    @PostMapping
    public ResponseEntity<ExercicioDto> criarExercicio(@RequestBody ExercicioAddModel exercicio){
        ExercicioDto resposta = exercicioService.adicionarExercicio(exercicio);
        return  new ResponseEntity(resposta,HttpStatus.OK);

    }


    //Mudar para retornar DTO
    @GetMapping(path="{idExercicio}")
    public ResponseEntity<ExercicioDto> listarExercicio(@PathVariable Long idExercicio){
        Exercicio exercicio = exercicioService.listarExercicio(idExercicio);

        return new ResponseEntity(new ExercicioDto(exercicio), HttpStatus.OK);
    }

    @GetMapping
    public List<Exercicio> listExercise(){return exercicioService.listarExercicios();}

    @PutMapping(path="{idExercicio}")
    public ResponseEntity editarExercicio(@PathVariable Long idExercicio,
                                                     @RequestParam(required = false) String nome,
                                                     @RequestParam(required = false) String descricao,
                                                     @RequestParam(required = false) String objetivo,
                                                        @RequestParam(required = false) String materialNecessario,
                                                        @RequestParam(required = false) String link,
                                                     @RequestParam(required = false) CategoriaTreino categoria,
                                                     @RequestParam(required = false) int repeticoes,
                                                     @RequestParam(required = false) double duracao){
         exercicioService.editarExercicio(idExercicio, nome, descricao, objetivo, materialNecessario, link, categoria, repeticoes, duracao);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(path="{idExercicio}")
    public ResponseEntity<ExercicioDto> removerExercicio(@PathVariable Long idExercicio){
         exercicioService.removerExercicio(idExercicio);
        return  new ResponseEntity(HttpStatus.OK);
    }





}
