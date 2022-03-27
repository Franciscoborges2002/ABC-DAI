package com.example.dai.repositories;

import com.example.dai.data.Class.Equipa;

import java.util.HashMap;

public class EquipaRepository {
    //Nome, Objeto//

    HashMap<String, Equipa> teams = new HashMap<>();


    public EquipaRepository() {

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
