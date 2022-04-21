package com.example.dai.service;

import com.example.dai.data.*;
import com.example.dai.model.*;
import com.example.dai.repository.UtilizadorRepository;
import com.example.dai.repository.TreinadorRepository;
import com.example.dai.repository.JogadorRepository;
import com.example.dai.repository.GuardaRedesRepository;
import com.example.dai.repository.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UtilizadorService {
    private final UtilizadorRepository utilizadorRepository;
    private final TreinadorRepository treinadorRepository;
    private final JogadorRepository jogadorRepository;
    private final GuardaRedesRepository guardaRedesRepository;
    private final DiretorRepository diretorRepository;
    private final DiretorService diretorService;
    private final TreinadorService treinadorService;

    @Autowired
    public UtilizadorService(UtilizadorRepository utilizadorRepository, TreinadorRepository treinadorRepository, JogadorRepository jogadorRepository, GuardaRedesRepository guardaRedesRepository, DiretorRepository diretorRepository, DiretorService diretorService, TreinadorService treinadorService) {
        this.utilizadorRepository = utilizadorRepository;
        this.treinadorRepository = treinadorRepository;
        this.jogadorRepository = jogadorRepository;
        this.guardaRedesRepository = guardaRedesRepository;
        this.diretorRepository = diretorRepository;
        this.diretorService = diretorService;
        this.treinadorService = treinadorService;
    }

    public List<Utilizador> listarUtilizadores(){
        return utilizadorRepository.findAll();
    }

    //Acabar função
    @Transactional
    public void mudarInformacaoUtilizador(Long idUtilizador, String nomeCompleto, String email, String password, String numeroTelemovel, Date dataNascimento){
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
            Optional<Utilizador> existeEmail = utilizadorRepository.findByEmail(email);
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

        //
        //Verificar se funciona
        //
        if(dataNascimento != null &&
                //dataNascimento.isAfter(LocalDate.now())
                dataNascimento.after(localDate2Date(LocalDate.now()))){
            utilizador.setDataNascimento(dataNascimento);
        }

    }

    public Date localDate2Date(LocalDate localDate){
        ZoneId defaultZoneId = ZoneId.systemDefault();

        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        return date;
    }

    //Só os diretores é que tem permissão para acessar
    public void removerUtilizador(Long idUtilizador){
        Optional<Utilizador> existeUtilizador = utilizadorRepository.findById(idUtilizador);

        if(existeUtilizador.isEmpty()){
            throw new IllegalStateException("Utilizador com o id " + idUtilizador + " não existe!");
        }
        utilizadorRepository.deleteById(idUtilizador);
    }

    public UtilizadorDto criarUtilizador(UtilizadorAddModel utilizadorAdicionar){
        String username = utilizadorAdicionar.getUsername();
        String password = utilizadorAdicionar.getPassword();
        String email = utilizadorAdicionar.getEmail();
        String tipoUtilizador = utilizadorAdicionar.getTipoUser();

        //Algumas validações

        if(username.equals("") || password.equals("") || email.equals("")){
            throw new IllegalStateException("Falta algum dado");
        }

        if(username.length() < 5){
            throw new IllegalStateException("O nome de utilizador precisa de ter mais de 5 letras!");
        }

        //Criar utilizador objeto
        Utilizador utilizador = new Utilizador(username, username, email);

        //Procurar se já existe o nomeUtilizador
        Optional<Utilizador> existenomeUtilizador = utilizadorRepository.findByNomeUtilizador(utilizador.getNomeUtilizador());

        if(existenomeUtilizador.isPresent()){
            throw new IllegalStateException("username taken!");
        }

        //Procurar se já existe o email
        Optional<Utilizador> existeEmail = utilizadorRepository.findByEmail(utilizador.getEmail());

        if(existeEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }

        switch(tipoUtilizador){
            case "treinador":
                treinadorService.criarTreinador(new TreinadorAddModel(utilizadorAdicionar.getUsername(), utilizadorAdicionar.getNomeCompleto(), utilizadorAdicionar.getPassword(), utilizadorAdicionar.getDataNascimento(), utilizadorAdicionar.getEmail(), utilizadorAdicionar.getNumeroTelemovel()));
                break;
            case "jogador":
                /*Jogador jogador = new JogadorAddModel(username, password, email);
                jogadorRepository.save(jogador);*/
                break;
            case "guarda-redes":
                GuardaRedes guardaRedes = new GuardaRedes(username,password, email);
                guardaRedesRepository.save(guardaRedes);
                break;
            case "diretor":
                diretorService.criarDiretor(new DiretorAddModel(utilizadorAdicionar.getUsername(), utilizadorAdicionar.getNomeCompleto(), utilizadorAdicionar.getPassword(), utilizadorAdicionar.getDataNascimento(), utilizadorAdicionar.getEmail(), utilizadorAdicionar.getNumeroTelemovel()));
                break;
            default:
                utilizadorRepository.save(utilizador);
        }

        return new UtilizadorDto("Utilizador criado com sucesso!");
    }

}