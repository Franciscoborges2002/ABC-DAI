package com.example.dai.service;

import com.example.dai.data.Utilizador;
import com.example.dai.repository.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AtletaService {
    private final UtilizadorRepository utilizadorRepository;
    private final TreinadorService treinadorService;
    private final JogadorService jogadorService;

    @Autowired
    public AtletaService(UtilizadorRepository utilizadorRepository, TreinadorService treinadorService, JogadorService jogadorService) {
        this.utilizadorRepository = utilizadorRepository;
        this.treinadorService = treinadorService;
        this.jogadorService = jogadorService;
    }

    public List<Utilizador> listarAtletas(){
        List<Utilizador> listaAtletas = new ArrayList<>();

        List<Utilizador> listarUtilizadores  = utilizadorRepository.findAll();
        System.out.println(listarUtilizadores);

        for (Utilizador utilizador: listarUtilizadores) {
            System.out.println(utilizador.getTipoUtilizador());
            if(utilizador.getTipoUtilizador().equals("jogador") || utilizador.getTipoUtilizador().equals("guarda-redes")){
                System.out.println(utilizador.getIdUtilizador());
                listaAtletas.add(utilizador);
            }
        }

        return listaAtletas;
    }
}
