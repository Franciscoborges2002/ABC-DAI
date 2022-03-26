package com.example.dai.Repositories;

import com.example.dai.Data.Class.Atleta;
import com.example.dai.Data.Class.Diretor;
import com.example.dai.Data.Class.Treinador;
import com.example.dai.Data.Class.Utilizador;

import java.util.HashMap;

public class UtilizadorRepository {
    //nomeUtlizador, objeto
    HashMap<String, Utilizador> utilizadores = new HashMap<>();

    public HashMap<String, Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void setUtilizadores(HashMap<String, Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    public HashMap<String, Treinador> getTreinadores(){
        HashMap<String, Treinador> treinadores = new HashMap<>();

        for(Utilizador u: utilizadores.values()){
                if(u instanceof Treinador){
                    treinadores.put(u.getNomeUtilizador(), (Treinador) u);
                }
        }
        return treinadores;
    }
    public HashMap<String, Atleta> getAtletas(){
        HashMap<String, Atleta> atletas = new HashMap<>();

        for(Utilizador u: utilizadores.values()){
            if(u instanceof Atleta){
                atletas.put(u.getNomeUtilizador(), (Atleta) u);
            }
        }
        return atletas;
    }

    public HashMap<String, Diretor> getDiretores(){
        HashMap<String, Diretor> diretores = new HashMap<>();

        for(Utilizador u: utilizadores.values()){
            if(u instanceof Diretor){
                diretores.put(u.getNomeUtilizador(), (Diretor) u);
            }
        }
        return diretores;
    }

    public String adicionarUtilizador(Utilizador utilizador){    // adionar um novo utilizador com a verificação se o username está a ser utilizado
        if(utilizadores.keySet().contains(utilizador.getNomeUtilizador())){
            return "Nome de utilizador já utilizado";
        }else{
            utilizadores.put(utilizador.getNomeUtilizador(), utilizador);
            return "Utilizador adicionado";
        }
    }

    public void removerUtilizador(String username){
        utilizadores.remove(username);

    }




}
