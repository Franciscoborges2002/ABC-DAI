package com.example.dai.controller;

import com.example.dai.model.LoginRequestModel;
import com.example.dai.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

   @PostMapping
   public String autenticar(@RequestBody LoginRequestModel loginRequest) {//DTO -> Data Transfer Object//
        return autenticacaoService.autenticar(loginRequest);
    }
}
