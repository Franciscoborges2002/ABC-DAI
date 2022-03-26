package com.example.dai.Services;

import com.example.dai.Data.RawStatistics;

public class GameSyncService {

    public static String gameSync(RawStatistics rawStatistics){
        int passes = rawStatistics.getPasses();
        int ataques = rawStatistics.getAtaques();
        int contraAtaques = rawStatistics.getContraAtaques();


        return "Número de passes " + passes + ", número de ataques " + ataques + ", númer contra ataques " + contraAtaques;
    }
}
