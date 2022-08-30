package com.example.dai.service;

import com.example.dai.data.Utilizador;
import com.example.dai.model.LoginRequestModel;
import com.example.dai.model.UtilizadorDto;
import com.example.dai.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService {
    private final UtilizadorRepository utilizadorRepository;
    private final DiretorRepository diretorRepository;
    private final TreinadorRepository treinadorRepository;
    private final JogadorRepository jogadorRepository;
    private final GuardaRedesRepository guardaRedesRepository;
    private final DataAnalystRepository dataAnalystRepository;

    @Autowired
    public AutenticacaoService(UtilizadorRepository utilizadorRepository, DiretorRepository diretorRepository, TreinadorRepository treinadorRepository, JogadorRepository jogadorRepository, GuardaRedesRepository guardaRedesRepository, DataAnalystRepository dataAnalystRepository) {
        this.utilizadorRepository = utilizadorRepository;
        this.diretorRepository = diretorRepository;
        this.treinadorRepository = treinadorRepository;
        this.jogadorRepository = jogadorRepository;
        this.guardaRedesRepository = guardaRedesRepository;
        this.dataAnalystRepository = dataAnalystRepository;
    }

    public UtilizadorDto autenticar(LoginRequestModel loginForm){
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        if(username.equals("") || password.equals("")){
            return new UtilizadorDto("Sem dados para fazer verificação", null);
        }

        if(utilizadorRepository.findAll().isEmpty()) {
            return new UtilizadorDto("Nenhum dado encontrado", null);
        }

        Optional<Utilizador> utilizadorExiste= utilizadorRepository.findByNomeUtilizador(username);

        if(utilizadorExiste.isPresent()){
            Utilizador utilizadorVerificar = utilizadorExiste.get();
            if(utilizadorVerificar.getPassword().equals(loginForm.getPassword())){
                if(diretorRepository.findById(utilizadorVerificar.getIdUtilizador()).isPresent()) {
                    //String nomeUtilizador, String nomeCompleto, String password, Date dataNascimento, String email, String numeroTelemovel
                    return new UtilizadorDto(new Utilizador(utilizadorVerificar.getNomeUtilizador(), utilizadorVerificar.getNomeCompleto(), utilizadorVerificar.getPassword(), utilizadorVerificar.getDataNascimento(), utilizadorVerificar.getEmail(), utilizadorVerificar.getNumeroTelemovel()) ,"Login efetuado com sucesso", "diretor");
                }
                if(treinadorRepository.findById(utilizadorVerificar.getIdUtilizador()).isPresent()){
                    return new UtilizadorDto(new Utilizador(utilizadorVerificar.getNomeUtilizador(), utilizadorVerificar.getNomeCompleto(), utilizadorVerificar.getPassword(), utilizadorVerificar.getDataNascimento(), utilizadorVerificar.getEmail(), utilizadorVerificar.getNumeroTelemovel()) ,"Login efetuado com sucesso", "treinador");
                }
                if(jogadorRepository.findById(utilizadorVerificar.getIdUtilizador()).isPresent()){
                    return new UtilizadorDto(new Utilizador(utilizadorVerificar.getNomeUtilizador(), utilizadorVerificar.getNomeCompleto(), utilizadorVerificar.getPassword(), utilizadorVerificar.getDataNascimento(), utilizadorVerificar.getEmail(), utilizadorVerificar.getNumeroTelemovel()) ,"Login efetuado com sucesso", "jogador");
                }
                if(guardaRedesRepository.findById(utilizadorVerificar.getIdUtilizador()).isPresent()){
                    return new UtilizadorDto(new Utilizador(utilizadorVerificar.getNomeUtilizador(), utilizadorVerificar.getNomeCompleto(), utilizadorVerificar.getPassword(), utilizadorVerificar.getDataNascimento(), utilizadorVerificar.getEmail(), utilizadorVerificar.getNumeroTelemovel()) ,"Login efetuado com sucesso", "guarda-redes");
                }
                if(dataAnalystRepository.findById(utilizadorVerificar.getIdUtilizador()).isPresent()){
                    return new UtilizadorDto(new Utilizador(utilizadorVerificar.getNomeUtilizador(), utilizadorVerificar.getNomeCompleto(), utilizadorVerificar.getPassword(), utilizadorVerificar.getDataNascimento(), utilizadorVerificar.getEmail(), utilizadorVerificar.getNumeroTelemovel()) ,"Login efetuado com sucesso", "data-analyst");
                }
            }else{
                return new UtilizadorDto( "Username ou password não estão corretos", null);
            }
        }else{
            return new UtilizadorDto("Utilizador não existe!1", null);
        }
        return new UtilizadorDto("Utilizador não existe!2", null);
    }
}
