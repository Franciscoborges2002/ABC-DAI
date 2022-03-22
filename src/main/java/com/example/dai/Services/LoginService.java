package com.example.dai.Services;

import com.example.dai.Data.Class.Utilizador;
import com.example.dai.Data.LoginForm;
import com.example.dai.Repositories.UsersRepositorie;
import org.springframework.stereotype.Service;

import static com.example.dai.Services.SignUpService.usersRepositorie;

@Service
public class LoginService {


    public static String login(LoginForm loginForm){

        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        Utilizador utilizador = new Utilizador();
        utilizador.setNomeUtilizador(username);
        utilizador.setPassword(password);

        if(username.equals("") || password.equals("")){
            return "Sem dados para fazer verificação";
        }

        if(usersRepositorie.getUtilizadores().isEmpty()) {
            return "Nenhum dado encontrado";
        }

        if(usersRepositorie.getUtilizadores().containsKey(username)){
            Utilizador u = usersRepositorie.getUtilizadores().get(username);
            if(u.getPassword().equals(password)){
                return "Login bem sucedido\n";
            }
            return "Username ou password incorreto\n";
        }else{
            return "Username ou password incorreto\n";
        }
    }
}
