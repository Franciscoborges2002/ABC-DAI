package com.example.dai.controller;

import com.example.dai.data.Escalao;
import com.example.dai.data.Utilizador;
import com.example.dai.service.AtletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/atleta")
public class AtletaController {

    private AtletaService atletaService;

    @Autowired
    public AtletaController(AtletaService atletaService) {
        this.atletaService = atletaService;
    }

    @GetMapping
    public List<Utilizador> listarAtletas(){
        return atletaService.listarAtletas();
    }
/*
    @GetMapping(path = "{escalao}")
    public List<Utilizador> listarAtletas(@PathVariable()Escalao escalao){
        return atletaService.listarAtletas();
    }*/
}
