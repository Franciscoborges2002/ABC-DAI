package com.example.dai.Controllers;

import com.example.dai.Data.LoginRequest;
import com.example.dai.Services.AutenticacaoService;
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
    public String login(@RequestBody LoginRequest loginRequest) {//DTO -> Data Transfer Object//
        return autenticacaoService.autenticar(loginRequest);
    }
}
