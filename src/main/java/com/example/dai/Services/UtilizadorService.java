package com.example.dai.Services;

import com.example.dai.data.Class.Utilizador;
import com.example.dai.data.SignUpForm;
import com.example.dai.repositories.ExercicioRepository;
import com.example.dai.repositories.EquipaRepository;
import com.example.dai.repositories.TreinoRepository;
import com.example.dai.repositories.UtilizadorRepository;
import org.springframework.stereotype.Service;

@Service
public class UtilizadorService {
    static UtilizadorRepository usersRepositorie = new UtilizadorRepository();
    static TreinoRepository trainingRepositorie = new TreinoRepository();
    static ExercicioRepository exerciseRepositorie = new ExercicioRepository();
    static EquipaRepository teamRepositorie = new EquipaRepository();

    public String list(){
        return usersRepositorie.getUtilizadores().toString();
    }

    //Joca --> criar um metodo para consguir alterar/gerir os perfis dos utilizadores;

    public static String changeInfoUser (Utilizador utilizador){
        if (usersRepositorie.getUtilizadores().keySet().contains(utilizador.getNomeUtilizador())){
            usersRepositorie.getUtilizadores().replace(utilizador.getNomeUtilizador(), utilizador);
            return "Utilizador editado com sucesso";

        }else{
            return "Utilizador não existe l!";//Retornar
        }
    }

    public static String removeUser(Utilizador utilizador){
        if (usersRepositorie.getUtilizadores().keySet().contains(utilizador.getNomeUtilizador())){
            usersRepositorie.getUtilizadores().remove(utilizador.getNomeUtilizador(), utilizador);
            return "Utilizador removido com sucesso";

        }else{
            return "Utilizador não existe";//Retornar
        }
    }

    public static String createUser(SignUpForm signUpForm){
        String username = signUpForm.getUsername();
        String password = signUpForm.getPassword();
        String email = signUpForm.getEmail();

        //Algumas validações
        if(username.equals("") || password.equals("") || email.equals("")){
            return "Not all information provided";
        }

        if(username.length() < 5){
            return "o nome de utilizador precisa de ter mais de 5 letras";
        }

        if(!email.contains("@")){
            return "Email não foi providenciado";
        }

        Utilizador utilizador = new Utilizador(username, username, email);

        //Adicionar ao repositório
        usersRepositorie.adicionarUtilizador(utilizador);
        return "signup form bem sucedida";
    }

}