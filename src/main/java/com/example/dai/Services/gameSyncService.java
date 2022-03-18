package com.example.dai.Services;

import com.example.dai.Data.RawStatistics;

public class gameSyncService {
    public static String gameSync(RawStatistics rawStatistics){
        int passes = rawStatistics.getPasses();

        return "Número de passes " + passes;
    }
}
