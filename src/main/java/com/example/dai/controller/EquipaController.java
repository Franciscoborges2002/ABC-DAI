package com.example.dai.controller;

import com.example.dai.data.Equipa;
import com.example.dai.data.EquipaTreinador;
import com.example.dai.data.Escalao;
import com.example.dai.data.Genero;
import com.example.dai.model.AtletaAddEquipaModel;
import com.example.dai.model.EquipaAddModel;
import com.example.dai.model.EquipaDto;
import com.example.dai.model.EquipaRequestModel;
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
    public List<EquipaTreinador> listarTreinos(){
        List<EquipaTreinador> test = equipaService.listarEquipas();
        return test;
    }

    @PutMapping(path = "{idEquipa}")
    public ResponseEntity editarTreino(
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
