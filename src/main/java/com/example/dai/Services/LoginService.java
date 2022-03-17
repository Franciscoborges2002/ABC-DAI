package com.example.dai.Services;

import com.example.dai.Data.LoginForm;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public static String login(LoginForm loginForm){
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        if(username.equals("") || password.equals("")){
            return "Sem dados para fazer verificação";
        }

        if(username.equals("admin") && password.equals("admin")){
            return "Login bem sucedido";
        }else{
            return "Login mal sucedido";
        }
    }
}
