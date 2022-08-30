package com.example.dai.service;

import com.example.dai.data.Jogador;
import com.example.dai.model.JogadorAddModel;
import com.example.dai.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogadorService {
    private final JogadorRepository jogadorRepository;

    @Autowired
    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public void criarJogador(JogadorAddModel jogadorCriar){
        Jogador jogador = new Jogador(jogadorCriar.getNomeUtilizador(), jogadorCriar.getNomeCompleto(), jogadorCriar.getPassword(), jogadorCriar.getDataNascimento(), jogadorCriar.getEmail(), jogadorCriar.getNumeroTelemovel(), "jogador");

        jogadorRepository.save(jogador);
    }


}

