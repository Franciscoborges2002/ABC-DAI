package com.example.dai.Services;


import org.springframework.stereotype.Service;
import com.example.dai.data.Class.Equipa;

import static com.example.dai.Services.UtilizadorService.teamRepositorie;

@Service
public class EquipaService {

    public static String addTeam(Equipa newTeam){
         teamRepositorie.addTeam(newTeam);
         return newTeam.toString();
        }

    public String listTeams(){return teamRepositorie.getTeams().toString();}

    public String changeInfoTeam(Equipa equipa2change) {
        if (teamRepositorie.getTeams().containsKey(equipa2change.getNome())) {
            return "Equipa editada com sucesso";
        } else {
            return "Equipa não existe";
        }
    }

        public String deleteTeam(Equipa equipaDelete){
            if(teamRepositorie.getTeams().containsKey(equipaDelete.getNome())){
                return "Equipa eliminada com sucesso";
            }
            return "Treino não existe";
        }

    }


