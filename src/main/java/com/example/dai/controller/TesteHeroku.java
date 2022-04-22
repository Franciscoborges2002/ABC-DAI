package com.example.dai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="")
public class TesteHeroku {

    @GetMapping
    public String testeHeroku(){
        return "Hello World";
    }
}
