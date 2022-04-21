package com.example.dai.service;

import com.example.dai.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class JogadorService {
    private final JogadorRepository jogadorRepository;

    @Autowired
    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

}

