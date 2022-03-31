package com.example.dai.services;

import com.example.dai.model.RawStatistics;

public class GameSyncService {

    public static String gameSync(RawStatistics rawStatistics){
        int passes = rawStatistics.getPasses();
        int ataques = rawStatistics.getAtaques();
        int contraAtaques = rawStatistics.getContraAtaques();


        return "Número de passes " + passes + ", número de ataques " + ataques + ", númer contra ataques " + contraAtaques;
    }
}
