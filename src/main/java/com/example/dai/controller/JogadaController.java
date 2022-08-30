package com.example.dai.controller;

import com.example.dai.data.Jogada;
import com.example.dai.model.JogadaAddModel;
import com.example.dai.model.JogadaDto;
import com.example.dai.model.JogadaEditModel;
import com.example.dai.service.JogadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/jogadas")
public class JogadaController {

    private final JogadaService jogadaService;

    @Autowired
    public JogadaController(JogadaService jogadaService) {
        this.jogadaService = jogadaService;
    }

    @GetMapping
    public List<Jogada> listarJogadas(){
        return jogadaService.listarJogadas();
    }

    @GetMapping(path = "{idUtilizador}")
    public ResponseEntity<JogadaDto> listarJogada(@PathVariable("idUtilizador") Long idJogada){
        JogadaDto jogadaDto = jogadaService.listarJogada(idJogada);
        return new ResponseEntity(new JogadaDto(jogadaDto.getJogada()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<JogadaDto> criarJogada(@RequestBody JogadaAddModel jogadaAdicionar){
        JogadaDto mensagem = jogadaService.jogadaAdicionar(jogadaAdicionar);
        return new ResponseEntity(mensagem, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{idJogada}")
    public ResponseEntity eliminarJogada(@PathVariable("idJogada") Long idJogada){
        jogadaService.removerJogada(idJogada);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "{idJogada}")
    public ResponseEntity editarJogada(
            @PathVariable("idJogada") Long idJogada,
            @RequestBody JogadaEditModel jogadaInfo
    ){
        jogadaService.mudarInformacaoJogada(idJogada, jogadaInfo);
        return new ResponseEntity(HttpStatus.OK);
    }
}
