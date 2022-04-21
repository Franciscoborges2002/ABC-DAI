package com.example.dai.service;

import com.example.dai.data.Treinador;
import com.example.dai.model.TreinadorAddModel;
import com.example.dai.repository.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreinadorService {
    private final TreinadorRepository treinadorRepository;

    @Autowired
    public TreinadorService(TreinadorRepository treinadorRepository) {
        this.treinadorRepository = treinadorRepository;
    }

    public void criarTreinador(TreinadorAddModel treinadorCriar){
        Treinador treinador = new Treinador(treinadorCriar.getNomeUtilizador(), treinadorCriar.getNomeCompleto(), treinadorCriar.getPassword(), treinadorCriar.getDataNascimento(), treinadorCriar.getEmail(), treinadorCriar.getNumeroTelemovel());

        treinadorRepository.save(treinador);
    }
}
