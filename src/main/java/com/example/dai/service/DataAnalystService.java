package com.example.dai.service;

import com.example.dai.data.DataAnalyst;

import com.example.dai.model.DataAnalystAddModel;
import com.example.dai.repository.DataAnalystRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataAnalystService {
    private final DataAnalystRepository dataAnalystRepository;

    @Autowired
    public DataAnalystService(DataAnalystRepository dataAnalystRepository) {
        this.dataAnalystRepository = dataAnalystRepository;
    }

    public void criarDataAnalyst(DataAnalystAddModel dataAnalystAdd){
        DataAnalyst dataAnalyst = new DataAnalyst(dataAnalystAdd.getNomeUtilizador(), dataAnalystAdd.getNomeCompleto(), dataAnalystAdd.getPassword(), dataAnalystAdd.getDataNascimento(), dataAnalystAdd.getEmail(), dataAnalystAdd.getNumeroTelemovel(), "data-analyst");

        dataAnalystRepository.save(dataAnalyst);
    }
}
