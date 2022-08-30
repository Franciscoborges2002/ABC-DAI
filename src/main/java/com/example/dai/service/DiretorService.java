package com.example.dai.service;

import com.example.dai.data.Diretor;
import com.example.dai.model.DiretorAddModel;
import com.example.dai.repository.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiretorService {
    private final DiretorRepository diretorRepository;

    @Autowired
    public DiretorService(DiretorRepository diretorRepository) {
        this.diretorRepository = diretorRepository;
    }

    public void criarDiretor(DiretorAddModel diretorCriar){
        Diretor diretor = new Diretor(diretorCriar.getNomeUtilizador(), diretorCriar.getNomeCompleto(), diretorCriar.getPassword(), diretorCriar.getDataNascimento(), diretorCriar.getEmail(), diretorCriar.getNumeroTelemovel(), "diretor");

        diretorRepository.save(diretor);
    }
}
