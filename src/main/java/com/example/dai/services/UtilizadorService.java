package com.example.dai.services;

import com.example.dai.data.classes.Utilizador;
import com.example.dai.model.UserAddModel;
import com.example.dai.repositories.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilizadorService {
    private final UtilizadorRepository utilizadorRepository;

    @Autowired
    public UtilizadorService(UtilizadorRepository utilizadorRepository) {
        this.utilizadorRepository = utilizadorRepository;
    }

    public List<Utilizador> list(){
        return utilizadorRepository.findAll();
    }

    //Acabar função
    public  String changeInfoUser (Utilizador utilizador){
        if (utilizadorRepository.findById(utilizador.getIdUtilizador()).isEmpty()){//Se existir
           // utilizadorRepository.findOne(utilizador).;
            return "Utilizador editado com sucesso";

        }else{
            return "Utilizador não existe !";//Retornar
        }
    }
/*
    public static String removeUser(Utilizador utilizador){
        if (utilizadorRepository.getUtilizadores().keySet().contains(utilizador.getNomeUtilizador())){
            utilizadorRepository.getUtilizadores().remove(utilizador.getNomeUtilizador(), utilizador);
            return "Utilizador removido com sucesso";

        }else{
            return "Utilizador não existe";//Retornar
        }
    }

    public static String createUser(UserAddModel signUpForm){
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
        utilizadorRepository.adicionarUtilizador(utilizador);
        return "signup form bem sucedida";
    }*/

}