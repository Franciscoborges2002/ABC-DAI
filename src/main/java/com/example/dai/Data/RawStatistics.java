package com.example.dai.Data;

import java.util.HashMap;

public class RawStatistics {
    private int passes;
    private int ataques;
    private int contraAtaques;
    private int defesas;
    HashMap<Integer, String[]> Golos= new HashMap<Integer, String[]>();


    //private HashMap<Integer, > Golos;  // id do golo , {Nome,tempo em segundos do golo ,Distancia, lugar e por onde passo}
    //HashMap<Integer, String>;
    /*
     * HashMap:
     *   Key: ID do golo (0, etccc)
     *   Value: Array com informações
     *           Tempo do golo
     *           Quem marcou
     *           Por onde marcou(Mapa por onde percorreu)
     *           Se foi na ponta, 6m , 7m ou 9m
     *           Se houve um passe ou não
     *           Em que lugar da baliza
     *           De quem foi a assistencia
     * */

    public int getPasses() {
        return passes;

    }

    public int getAtaques() {
        return ataques;
    }

    public int getContraAtaques() {
        return contraAtaques;
    }
}
