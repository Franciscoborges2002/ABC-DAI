package com.example.dai.Repositories;

import com.example.dai.Data.Class.Equipa;

import java.util.HashMap;

public class TeamRepositorie {
    //Nome, Objeto
    HashMap<String, Equipa> teams = new HashMap();

    public TeamRepositorie(HashMap<String, Equipa> teams) {
        this.teams = teams;
    }


    public HashMap<String, Equipa> getTeams(){
        return teams;
    }

    public void setTeams(HashMap<String, Equipa> newTeam){
        this.teams = newTeam;
    }

    public String addTeam(Equipa newTeam){
        if(teams.containsValue(newTeam)){
            return "Equipa já adicionado";
        }else{
            teams.put(newTeam.getNome(),newTeam);
            return "Equipa adicionado com sucesso";
        }
    }

    public String removeTeam(Equipa team2Remove){
        if(teams.containsValue(team2Remove)){
            teams.remove(team2Remove.getNome(), team2Remove);
            return "A equipa foi removida com sucesso";
        }else{
            return "A equipa não foi encontrada";
        }
    }
}
