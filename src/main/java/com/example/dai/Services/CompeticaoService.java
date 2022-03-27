package com.example.dai.Services;

import com.example.dai.data.Class.Competicao;
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
