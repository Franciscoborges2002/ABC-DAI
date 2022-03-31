package com.example.dai.services;

import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

/*
    public String autenticar(LoginAddModel loginForm){

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
            return "Username ou password incorreto 1\n";
        }else{
            return "Username ou password incorreto 2\n";
        }
    }*/
}
