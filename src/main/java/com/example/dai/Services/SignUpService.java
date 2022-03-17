package com.example.dai.Services;

import com.example.dai.Data.SignUpForm;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

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

        return "signup form bem sucedida";
    }
}
