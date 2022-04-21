package com.example.dai.controller;

import com.example.dai.data.Equipa;
import com.example.dai.data.Treino;
import com.example.dai.model.CompeticaoDto;
import com.example.dai.model.TreinoAddModel;
import com.example.dai.model.TreinoDto;
import com.example.dai.model.UtilizadorDto;
import com.example.dai.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//Função para aidionar um novo treino à BD
@RestController
@RequestMapping("/api/v1/treino")
public class TreinoController {

    private final TreinoService treinoService;

    @Autowired
    public TreinoController(TreinoService trainService){this.treinoService = trainService;}

    @GetMapping
    public List<Treino> listarTreino(){
        return treinoService.listarTreinos();
    }

    @PostMapping
    public ResponseEntity<TreinoDto> adicionarTreino(@RequestBody TreinoAddModel treino){
         TreinoDto mensagem = treinoService.adicionarTreino(treino);
        return  new ResponseEntity(mensagem,HttpStatus.OK);
    }

    @PutMapping(path = "{idTreino}")
    public ResponseEntity mudarInformacaoTreino(
            @PathVariable Long idTreino,
            @RequestParam(required = false) String nomeTreino,
            @RequestParam(required = false) Equipa equipa,
            @RequestParam(required = false) LocalDate horario,
            @RequestParam(required = false) String localizacao
    ){
         treinoService.mudarInformacaoTreino(idTreino, nomeTreino, equipa, horario, localizacao);
         return  new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(path = "{idTreino}")
    public ResponseEntity eliminarTreino(@RequestBody long idTreino){
        treinoService.eliminarTreino(idTreino);
        return  new ResponseEntity(HttpStatus.OK);
    }


}
