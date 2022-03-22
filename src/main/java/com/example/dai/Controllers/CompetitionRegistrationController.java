package com.example.dai.Controllers;

/*
* Função para receber uma nova competições onde o ABC vai participar
* */

import com.example.dai.Data.Competition;
import com.example.dai.Services.CompetitionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/competition/new")
public class CompetitionRegistrationController {

    @PostMapping
    public String newCompetition(@RequestBody Competition newCompetition){
        return CompetitionService.addCompetition(newCompetition);
    }
}
