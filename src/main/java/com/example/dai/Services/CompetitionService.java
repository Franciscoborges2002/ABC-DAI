package com.example.dai.Services;

import com.example.dai.Data.Competition;

public class CompetitionService {

    public static String addCompetition(Competition newCompetition){
        String url = newCompetition.getURL();

        if(!url.contains("www.")){
            return "URL não válido\nFornceça um URL válido.";
        }else {
            return "URL guardado com sucesso";
        }
    }
}
