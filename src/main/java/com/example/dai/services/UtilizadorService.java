package com.example.dai.services;

import com.example.dai.data.classes.Utilizador;
import com.example.dai.model.UserAddModel;
import com.example.dai.repositories.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UtilizadorService {
    private final UtilizadorRepository utilizadorRepository;

    @Autowired
    public UtilizadorService(UtilizadorRepository utilizadorRepository) {
        this.utilizadorRepository = utilizadorRepository;
    }

    public List<Utilizador> listarUtilizadores(){
        return utilizadorRepository.findAll();
    }

    //Acabar função
    @Transactional
    public String mudarInformacaoUtilizador(Long idUtilizador, String nomeCompleto, String email, String password, String numeroTelemovel, LocalDate dataNascimento){
        Optional<Utilizador> existeUtilizador = Optional.of(utilizadorRepository.getById(idUtilizador));

        if(existeUtilizador.isEmpty()){//Se o utilizador não existe
            throw new IllegalStateException("Utilizador com o id "+ idUtilizador + " não existe!");
        }

        Utilizador utilizador = utilizadorRepository.getById(idUtilizador);

        if(nomeCompleto != null &&
                nomeCompleto.length() > 0 &&
                !Objects.equals(utilizador.getNomeCompleto(), nomeCompleto)){
            utilizador.setNomeCompleto(nomeCompleto);
        }

        if(email != null &&
                email.length() > 0 &&
                !Objects.equals(utilizador.getEmail(), email)){
            Optional<Utilizador> existeEmail = utilizadorRepository.encontrarNomeUtilizadorPeloEmail(email);
            if(existeEmail.isPresent()){
                throw new IllegalStateException("Email taken!");
            }
            utilizador.setEmail(email);
        }

        if(password != null &&
                password.length() >0 &&
                !Objects.equals(utilizador.getPassword(), password)){
            utilizador.setPassword(password);
        }

        if(numeroTelemovel != null &&
                numeroTelemovel.length() > 0 &&
                !Objects.equals(utilizador.getNumeroTelemovel(), numeroTelemovel)){
            utilizador.setNumeroTelemovel(numeroTelemovel);
        }

        if(dataNascimento != null &&
                dataNascimento.isAfter(LocalDate.now())){
            utilizador.setDataNascimento(dataNascimento);
        }

        return "Utilizador alterada com sucesso";
    }

    //Só os diretores é que tem permissão para acessar
    public String removerUtilizador(Long idUtilizador){
        Optional<Utilizador> existeUtilizador = utilizadorRepository.findById(idUtilizador);

        if(existeUtilizador.isEmpty()){
            throw new IllegalStateException("Utilizador com o id " + idUtilizador + " não existe!");
        }
        utilizadorRepository.deleteById(idUtilizador);
        return "Utilizador removido com sucesso";
    }

    public String criarUtilizador(UserAddModel signUpForm){
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

        //Criar utilizador objeto
        Utilizador utilizador = new Utilizador(username, username, email);

        //Procurar se já existe o nomeUtilizador
        Optional<Utilizador> existenomeUtilizador = utilizadorRepository.encontrarUtilizadorPeloNomeUtilizador(utilizador.getNomeUtilizador());

        if(existenomeUtilizador.isPresent()){
            throw new IllegalStateException("username taken!");
        }

        //Procurar se já existe o email
        Optional<Utilizador> existeEmail = utilizadorRepository.encontrarNomeUtilizadorPeloEmail(utilizador.getEmail());

        if(existeEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }

        utilizadorRepository.save(utilizador);

        return "Utilizador registado com sucesos";
    }

}