package com.example.dai.Services;

import com.example.dai.Data.Class.Utilizador;
import com.example.dai.Data.SignUpForm;
import com.example.dai.Repositories.UsersRepositorie;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    static UsersRepositorie usersRepositorie = new UsersRepositorie();

    public static String signUp(SignUpForm signUpForm){
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
