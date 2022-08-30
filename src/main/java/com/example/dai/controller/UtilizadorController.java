package com.example.dai.controller;

import com.example.dai.data.Utilizador;
import com.example.dai.model.UtilizadorAddModel;
import com.example.dai.model.UtilizadorDto;
import com.example.dai.model.UtilizadorEditModel;
import com.example.dai.service.UtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/api/v1/utilizador")
public class UtilizadorController {

    private final UtilizadorService utilizadorService;

    @Autowired
    public UtilizadorController(UtilizadorService listUsersService) {
        this.utilizadorService = listUsersService;
    }

    @GetMapping
    public List<Utilizador> listarUtilizadores(){
        return utilizadorService.listarUtilizadores();
    }

    @GetMapping(path = "{idUtilizador}")
    public ResponseEntity<UtilizadorDto> listarUtilizador(@PathVariable("idUtilizador") Long idUtilizador){
        UtilizadorDto utilizadorDto = utilizadorService.listarUtilizador(idUtilizador);
        return new ResponseEntity(new UtilizadorDto(utilizadorDto.getUtilizador()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UtilizadorDto> criarUtilizador(@RequestBody UtilizadorAddModel signUpForm){
        UtilizadorDto mensagem = utilizadorService.criarUtilizador(signUpForm);
        return new ResponseEntity(mensagem, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{idUtilizador}")
    public ResponseEntity eliminarUtilizador(@PathVariable("idUtilizador") Long idUtilizador) {
        utilizadorService.removerUtilizador(idUtilizador);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "{idUtilizador}")
    public ResponseEntity<UtilizadorDto> editarUtilizador(
            @PathVariable Long idUtilizador,
            @RequestBody UtilizadorEditModel utilizadorInfo
    ) {
        //utilizadorService.mudarInformacaoUtilizador(idUtilizador, nomeCompleto, email, password, numeroTelemovel, dataNascimento);
        utilizadorService.mudarInformacaoUtilizador(idUtilizador, utilizadorInfo);
        System.out.println(utilizadorInfo.getNomeCompleto());
        return new ResponseEntity(HttpStatus.OK);

    }
}
