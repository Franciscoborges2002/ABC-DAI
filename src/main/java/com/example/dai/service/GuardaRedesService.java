package com.example.dai.service;

import com.example.dai.data.GuardaRedes;
import com.example.dai.data.Jogador;
import com.example.dai.model.JogadorAddModel;
import com.example.dai.repository.GuardaRedesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuardaRedesService {
    private final GuardaRedesRepository guardaRedesRepository;

    @Autowired
    public GuardaRedesService(GuardaRedesRepository guardaRedesRepository) {
        this.guardaRedesRepository = guardaRedesRepository;
    }

    public void criarGuardaRedes(JogadorAddModel guardaRedesCriar){
        GuardaRedes guardaRedes = new GuardaRedes(guardaRedesCriar.getNomeUtilizador(), guardaRedesCriar.getNomeCompleto(), guardaRedesCriar.getPassword(), guardaRedesCriar.getDataNascimento(), guardaRedesCriar.getEmail(), guardaRedesCriar.getNumeroTelemovel(), "guarda-redes");
        guardaRedesRepository.save(guardaRedes);
    }
}
