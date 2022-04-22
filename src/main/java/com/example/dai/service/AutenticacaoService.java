package com.example.dai.service;

import com.example.dai.data.Utilizador;
import com.example.dai.model.LoginRequestModel;
import com.example.dai.repository.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService {
    private UtilizadorRepository utilizadorRepository;

    @Autowired
    public AutenticacaoService(UtilizadorRepository utilizadorRepository) {
        this.utilizadorRepository = utilizadorRepository;
    }

    public String autenticar(LoginRequestModel loginForm){
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        if(username.equals("") || password.equals("")){
            return "Sem dados para fazer verificação";
        }

        if(utilizadorRepository.findAll().isEmpty()) {
            return "Nenhum dado encontrado";
        }

        Optional<Utilizador> utilizadorExiste= utilizadorRepository.findByNomeUtilizador(username);

        if(utilizadorExiste.isPresent()){
            Utilizador utilziadorVerificar = utilizadorExiste.get();
            if(utilziadorVerificar.getPassword() == password){
                return "Login efetuado com sucesso";
            }else{
                return "Username ou password não estão corretos";
            }
        }else{
            return "Utilizador não existe!";
        }


    }
}
