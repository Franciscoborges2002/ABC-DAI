package com.example.dai.controller;

import com.example.dai.data.Treinador;
import com.example.dai.service.TreinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/treinador")
public class TreinadorController {

    private TreinadorService treinadorService;

    @Autowired
    public TreinadorController(TreinadorService treinadorService) {
        this.treinadorService = treinadorService;
    }

    @GetMapping
    public List<Treinador> listarTreinadores(){
        return treinadorService.listarTreinadores();
    }
}
