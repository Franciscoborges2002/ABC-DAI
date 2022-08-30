package com.example.dai.controller;

import com.example.dai.data.Jogo;
import com.example.dai.data.JogoAtleta;
import com.example.dai.model.JogoAddModel;
import com.example.dai.model.JogoEditModel;
import com.example.dai.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/jogo")
public class JogoController {

    private final JogoService jogoService;

    @Autowired
    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @GetMapping
    public List<Jogo> listarJogos(){
        return jogoService.listarJogos();
    }

    @PostMapping
    public void adicionarJogo(JogoAddModel jogoAdicionar){
        jogoService.adicionarJogo(jogoAdicionar);
    }

    @DeleteMapping(path="{idJogo}")
    public void eliminarJogo(@PathVariable Long idJogo){
        jogoService.eliminarJogo(idJogo);
    }

    @PutMapping(path="{idJogo}")
    public void mudarInformacoesJogo(@PathVariable Long idJogo,
                                     @RequestBody JogoEditModel jogoNovasInfo){
        jogoService.mudarInformacoesJogo(idJogo, jogoNovasInfo);
    }

}
