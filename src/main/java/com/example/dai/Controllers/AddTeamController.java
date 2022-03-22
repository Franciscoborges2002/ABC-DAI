package com.example.dai.Controllers;

import com.example.dai.Data.Class.Equipa;
import com.example.dai.Services.TeamService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teams/add")
public class AddTeamController {

    @PostMapping
    public String addTeam(@RequestBody Equipa newTeam){
        return TeamService.addTeam(newTeam);
    }
}
