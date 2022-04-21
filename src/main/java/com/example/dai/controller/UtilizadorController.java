package com.example.dai.controller;

import com.example.dai.data.Utilizador;
import com.example.dai.model.UtilizadorAddModel;
import com.example.dai.model.UtilizadorDto;
import com.example.dai.service.UtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value="/api/v1/user")
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

    @PostMapping
    public ResponseEntity<UtilizadorDto> criarUtilizador(@RequestBody UtilizadorAddModel signUpForm){
        UtilizadorDto mensagem = utilizadorService.criarUtilizador(signUpForm);
        return new ResponseEntity(mensagem, HttpStatus.OK);
    }

    @DeleteMapping(path = "{idUtilizador}")
    public ResponseEntity eliminarUtilizador(@PathVariable("idUtilizador") Long idUtilizador) {
        utilizadorService.removerUtilizador(idUtilizador);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "{idUtilizador}")
    public ResponseEntity editarUtilizador(
            @PathVariable Long idUtilizador,
            @RequestParam(required = false) String nomeCompleto,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String numeroTelemovel,
            @RequestParam(required = false) Date dataNascimento
                           ) {
        utilizadorService.mudarInformacaoUtilizador(idUtilizador, nomeCompleto, email, password, numeroTelemovel, dataNascimento);
        return  new ResponseEntity(HttpStatus.OK);

    }


}
