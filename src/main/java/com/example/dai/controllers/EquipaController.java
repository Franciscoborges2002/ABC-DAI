package com.example.dai.controllers;

import com.example.dai.data.classes.Equipa;
import com.example.dai.services.EquipaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teams")
public class EquipaController {

    private final EquipaService teamService;

    @Autowired
    public EquipaController(EquipaService teamService) {
        this.teamService = teamService;
    }
/*
    @PostMapping
    public String addTeam(@RequestBody Equipa newTeam){
        return teamService.addTeam(newTeam);
    }

    @GetMapping
    public String listTrains(){
        return teamService.listTeams();
    }

    @PutMapping
    public String editTrain(@RequestBody Equipa equipaNewInfo){
        return teamService.changeInfoTeam(equipaNewInfo);
    }

    @DeleteMapping
    public String deleteTrain(@RequestBody Equipa equipaDelete){
        return teamService.deleteTeam(equipaDelete);
    }
*/
}
