package com.example.dai.services;

import com.example.dai.data.classes.Competicao;
import org.springframework.stereotype.Service;

@Service
public class CompeticaoService {

    public static String adicionarCompeticao(Competicao newCompetition){
        String url = newCompetition.getURL();

        if(!url.contains("www.")){
            return "URL não válido\nFornceça um URL válido.";
        }else {
            return "URL guardado com sucesso";
        }
    }
}
