package com.example.dai.controller;

import com.example.dai.data.Pavilhao;
import com.example.dai.model.PavilhaoAddModel;
import com.example.dai.model.PavilhaoDto;
import com.example.dai.model.PavilhaoEditModel;
import com.example.dai.model.UtilizadorDto;
import com.example.dai.service.PavilhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pavilhao")
public class PavilhaoController {

    private final PavilhaoService pavilhaoService;

    @Autowired
    public PavilhaoController(PavilhaoService pavilhaoService) {
        this.pavilhaoService = pavilhaoService;
    }

    @PostMapping
    public ResponseEntity<PavilhaoDto> adicionarPavilhao(@RequestBody PavilhaoAddModel novoPavilhao){
        PavilhaoDto response = pavilhaoService.adicionarPavilhao(novoPavilhao);
        return  new ResponseEntity(response,HttpStatus.OK);
    }

    @GetMapping
    public List<Pavilhao> listarPavilhoes(){
        return pavilhaoService.listarPavilhoes();
    }

    @GetMapping(path="{idPavilhao}")
    public ResponseEntity<PavilhaoDto> listarPavilhao(@PathVariable("idPavilhao") Long idPavilhao){
        Pavilhao response = pavilhaoService.listarPavilhao(idPavilhao);

        return new ResponseEntity(new PavilhaoDto(response), HttpStatus.OK);
    }

    @DeleteMapping(path="{idPavilhao}")
    public ResponseEntity removerPavilhao (@PathVariable("idPavilhao") Long idPavilhao){
        pavilhaoService.removerPavilhao(idPavilhao);
        return new ResponseEntity(HttpStatus.OK);
    }


    @PutMapping(path="{idPavilhao}")
    public ResponseEntity editarPavilhao(
            @PathVariable Long idPavilhao,
            PavilhaoEditModel pavilhao
    ){
        pavilhao.setNomePavilhao("123");
        pavilhao.setLocalizacao("asd");
        pavilhao.setNumeroDeTreinosPorHora(3L);
        pavilhaoService.editarPavilhao(idPavilhao, pavilhao);
        return new ResponseEntity(HttpStatus.OK);
    }
}