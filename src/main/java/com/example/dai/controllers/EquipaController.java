package com.example.dai.controllers;

import com.example.dai.data.classes.Equipa;
import com.example.dai.data.enums.Escalao;
import com.example.dai.data.enums.Genero;
import com.example.dai.model.EquipaAddModel;
import com.example.dai.services.EquipaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/equipa")
public class EquipaController {

    private final EquipaService equipaService;

    @Autowired
    public EquipaController(EquipaService teamService) {
        this.equipaService = teamService;
    }

    @PostMapping
    public String addTeam(@RequestBody EquipaAddModel novaEquipa){
        return equipaService.adicionarEquipa(novaEquipa);
    }

    @GetMapping
    public List<Equipa> listTrains(){
        return equipaService.listarEquipas();
    }


    @PutMapping(path = "{idEquipa}")
    public void editTrain(
            @PathVariable Long idEquipa,
            @RequestParam(required = false) String nomeEquipa,
            @RequestParam(required = false) String moradaEquipa,
            @RequestParam(required = false) String emailEquipa,
            @RequestParam(required = false) String websiteEquipa,
            @RequestParam(required = false) String recintoEquipa,
            @RequestParam(required = false) Escalao escalaoEquipa,
            @RequestParam(required = false) Genero generoEquipa
    ){
        equipaService.mudarInformacaoEquipa(idEquipa,nomeEquipa, moradaEquipa,emailEquipa, websiteEquipa,recintoEquipa, escalaoEquipa, generoEquipa);
    }

    @DeleteMapping(path = "{idEquipa}")
    public void deleteEquipa(@PathVariable Long idEquipa){
        equipaService.eliminarEquipa(idEquipa);
    }
}
