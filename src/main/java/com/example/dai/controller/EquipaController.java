package com.example.dai.controller;

import com.example.dai.data.Equipa;
import com.example.dai.data.EquipaTreinador;
import com.example.dai.data.Escalao;
import com.example.dai.data.Genero;
import com.example.dai.model.*;
import com.example.dai.service.EquipaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<EquipaDto> adicionarEquipa(@RequestBody @Valid EquipaAddModel novaEquipa){
        EquipaDto resposta =  equipaService.adicionarEquipa(novaEquipa);//retornar a EquipaDto
        return  new ResponseEntity(resposta, HttpStatus.OK);
    }

    @GetMapping
    public List<Equipa> listarEquipa(){
        System.out.println(equipaService.listarEquipas());
        return equipaService.listarEquipas();
    }

    @GetMapping(path="{idEquipa}")
    public Equipa listarEquipa(@PathVariable Long idEquipa){
        return equipaService.listarEquipa(idEquipa);
    }

    @PutMapping(path = "{idEquipa}")
    public ResponseEntity editarEquipa(
            @PathVariable Long idEquipa,
            @RequestBody EquipaEditModel equipaEditModel
            ){
        equipaService.mudarInformacaoEquipa(idEquipa, equipaEditModel);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(path = "{idEquipa}")
    public ResponseEntity eliminarEquipa(@PathVariable Long idEquipa){
        equipaService.eliminarEquipa(idEquipa);
        return  new ResponseEntity(HttpStatus.OK);
    }

    //Adicionar jogador à equipa
    @PostMapping(path="adicionarJogador")
    public ResponseEntity<EquipaDto> adicionarJogadorEquipa(@RequestParam EquipaRequestModel equipa, @RequestParam AtletaAddEquipaModel atletaAdicionar){

        boolean message = equipaService.adicionarAtleta(equipa, atletaAdicionar);
        return new ResponseEntity(new EquipaDto("Atleta adicionado com sucesso!"), HttpStatus.OK);
    }
}
