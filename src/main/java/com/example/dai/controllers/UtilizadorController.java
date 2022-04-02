package com.example.dai.controllers;

import com.example.dai.data.classes.Utilizador;
import com.example.dai.model.UserAddModel;
import com.example.dai.services.UtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public String criarUtilizador(@RequestBody UserAddModel signUpForm){return utilizadorService.criarUtilizador(signUpForm); }

    @DeleteMapping(path = "{idUtilizador}")
    public String eliminarUtilizador(@PathVariable("idUtilizador") Long idUtilizador) {return utilizadorService.removerUtilizador(idUtilizador); }

    @PutMapping(path = "{idUtilizador}")
    public String editarUtilizador(
            @PathVariable Long idUtilizador,
            @RequestParam(required = false) String nomeCompleto,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String numeroTelemovel,
            @RequestParam(required = false) LocalDate dataNascimento
                           ) {return utilizadorService.mudarInformacaoUtilizador(idUtilizador, nomeCompleto, email, password, numeroTelemovel, dataNascimento);}


}
