package com.example.dai.Controllers;

import com.example.dai.Data.Class.Equipa;
import com.example.dai.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

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

}
