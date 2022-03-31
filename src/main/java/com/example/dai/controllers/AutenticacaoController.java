package com.example.dai.controllers;

import com.example.dai.services.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/login")
public class AutenticacaoController {

    private final AutenticacaoService autenticacaoService;

    @Autowired
    public AutenticacaoController(AutenticacaoService loginService) {
        this.autenticacaoService = loginService;
    }

   /* @PostMapping
   public String login(@RequestBody LoginAddModel loginRequest) {//DTO -> Data Transfer Object//
        return autenticacaoService.autenticar(loginRequest);
    }*/
}
