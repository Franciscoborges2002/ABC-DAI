package com.example.dai.service;

import com.example.dai.data.*;
import com.example.dai.model.*;
import com.example.dai.repository.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class UtilizadorService {
    private final UtilizadorRepository utilizadorRepository;
    private final DiretorService diretorService;
    private final TreinadorService treinadorService;
    private final JogadorService jogadorService;
    private final GuardaRedesService guardaRedesService;
    private final DataAnalystService dataAnalystService;

    @Autowired
    public UtilizadorService(UtilizadorRepository utilizadorRepository, DiretorService diretorService, TreinadorService treinadorService, JogadorService jogadorService, GuardaRedesService guardaRedesService, DataAnalystService dataAnalystService) {
        this.utilizadorRepository = utilizadorRepository;
        this.diretorService = diretorService;
        this.treinadorService = treinadorService;
        this.jogadorService = jogadorService;
        this.guardaRedesService = guardaRedesService;
        this.dataAnalystService = dataAnalystService;
    }

    public List<Utilizador> listarUtilizadores(){
        return utilizadorRepository.findAll();
    }

    public UtilizadorDto listarUtilizador(Long idUtilizador){
        Optional<Utilizador> utilizadorExiste = utilizadorRepository.findById(idUtilizador);

        if(utilizadorExiste.isPresent()){
            return new UtilizadorDto(utilizadorExiste.get());
        }



        throw new IllegalStateException("Utilizador não existe");
    }

    public void mudarInformacaoUtilizador(Long idUtilizador, UtilizadorEditModel utilizadorNovasInfos) {
        Optional<Utilizador> existeUtilizador = Optional.of(utilizadorRepository.getById(idUtilizador));

        if (!existeUtilizador.isPresent()) {//Se o utilizador não existe
            throw new IllegalStateException("Utilizador com o id " + idUtilizador + " não existe!");
        }

        Utilizador utilizador = utilizadorRepository.getById(idUtilizador);

        if (utilizadorNovasInfos.getNomeCompleto() != null &&
                utilizadorNovasInfos.getNomeCompleto().length() > 0) {
            utilizador.setNomeCompleto(utilizadorNovasInfos.getNomeCompleto());
        }

        if (utilizadorNovasInfos.getEmail() != null &&
                utilizadorNovasInfos.getEmail().length() > 0) {
            Optional<Utilizador> existeEmail = utilizadorRepository.findByEmail(utilizadorNovasInfos.getEmail());
            if (existeEmail.isPresent()) {
                throw new IllegalStateException("Email taken!");
            }
            utilizador.setEmail(utilizadorNovasInfos.getEmail());
        }

        if (utilizadorNovasInfos.getPassword() != null &&
                utilizadorNovasInfos.getPassword().length() > 0) {
            utilizador.setPassword(utilizadorNovasInfos.getPassword());
        }

        if (utilizadorNovasInfos.getNumeroTelemovel() != null &&
                utilizadorNovasInfos.getNumeroTelemovel().length() > 0) {
            utilizador.setNumeroTelemovel(utilizadorNovasInfos.getNumeroTelemovel());
        }

        //
        //Verificar se funciona
        //
        if (utilizadorNovasInfos.getDataNascimento() != null &&
                //dataNascimento.isAfter(LocalDate.now())
                utilizadorNovasInfos.getDataNascimento().after(localDate2Date(LocalDate.now()))) {
            utilizador.setDataNascimento(utilizadorNovasInfos.getDataNascimento());
            System.out.println();
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String data = simpleDateFormat.format(utilizadorNovasInfos.getDataNascimento());

       /* System.out.println("ashufiosHDFUYSHDGOUS" + data);
        Date data1 = null;
        try {
            data1 = new SimpleDateFormat("yyyy-MM-dd").parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
*/
        System.out.println("oioioioiioioioioioioio" + utilizadorNovasInfos.getDataNascimento());
        //System.out.println("asdwasdawsd" + data1);

        //utilizadorRepository.utilizadorMudarInfo(idUtilizador, utilizadorNovasInfos.getNomeCompleto(), data, utilizadorNovasInfos.getEmail(), utilizadorNovasInfos.getNumeroTelemovel(), utilizadorNovasInfos.getPassword());

    }



    public Date localDate2Date(LocalDate localDate){
        ZoneId defaultZoneId = ZoneId.systemDefault();

        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        return date;
    }

    //Só os diretores é vão ter permissão para acessar
    public void removerUtilizador(Long idUtilizador){
        Optional<Utilizador> existeUtilizador = utilizadorRepository.findById(idUtilizador);

        if(!existeUtilizador.isPresent()){
            throw new IllegalStateException("Utilizador com o id " + idUtilizador + " não existe!");
        }
        utilizadorRepository.deleteById(idUtilizador);
    }

    public UtilizadorDto criarUtilizador(UtilizadorAddModel utilizadorAdicionar){
        String username = utilizadorAdicionar.getNomeUtilizador();
        String password = utilizadorAdicionar.getPassword();
        String email = utilizadorAdicionar.getEmail();
        String tipoUtilizador = utilizadorAdicionar.getTipoUser();

        System.out.println("olaolaolaolaola" + utilizadorAdicionar.getDataNascimento());

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
            throw new IllegalStateException("Nome já utilizado!");
        }

        //Procurar se já existe o email.
        Optional<Utilizador> existeEmail = utilizadorRepository.findByEmail(utilizador.getEmail());

        if(existeEmail.isPresent()){
            throw new IllegalStateException("Email já utilizado!");
        }

        switch(tipoUtilizador){
            case "treinador":
                treinadorService.criarTreinador(new TreinadorAddModel(utilizadorAdicionar.getNomeUtilizador(), utilizadorAdicionar.getNomeCompleto(), utilizadorAdicionar.getPassword(), utilizadorAdicionar.getDataNascimento(), utilizadorAdicionar.getEmail(), utilizadorAdicionar.getNumeroTelemovel()));
                break;
            case "jogador":
                jogadorService.criarJogador(new JogadorAddModel(utilizadorAdicionar.getNomeUtilizador(), utilizadorAdicionar.getNomeCompleto(), utilizadorAdicionar.getPassword(), utilizadorAdicionar.getDataNascimento(), utilizadorAdicionar.getEmail(), utilizadorAdicionar.getNumeroTelemovel()));
                break;
            case "guarda-redes":
                guardaRedesService.criarGuardaRedes(new JogadorAddModel(utilizadorAdicionar.getNomeUtilizador(), utilizadorAdicionar.getNomeCompleto(), utilizadorAdicionar.getPassword(), utilizadorAdicionar.getDataNascimento(), utilizadorAdicionar.getEmail(), utilizadorAdicionar.getNumeroTelemovel()));
                break;
            case "diretor":
                diretorService.criarDiretor(new DiretorAddModel(utilizadorAdicionar.getNomeUtilizador(), utilizadorAdicionar.getNomeCompleto(), utilizadorAdicionar.getPassword(), utilizadorAdicionar.getDataNascimento(), utilizadorAdicionar.getEmail(), utilizadorAdicionar.getNumeroTelemovel()));
                break;
            case "data-analyst":
                dataAnalystService.criarDataAnalyst(new DataAnalystAddModel(utilizadorAdicionar.getNomeUtilizador(), utilizadorAdicionar.getNomeCompleto(), utilizadorAdicionar.getPassword(), utilizadorAdicionar.getDataNascimento(), utilizadorAdicionar.getEmail(), utilizadorAdicionar.getNumeroTelemovel()));
                break;
            default:
                utilizadorRepository.save(utilizador);
        }

        return new UtilizadorDto("Utilizador criado com sucesso!", utilizadorAdicionar.getTipoUser());
    }
}