package com.example.dai.service;

import com.example.dai.data.Jogo;
import com.example.dai.model.JogoAddModel;
import com.example.dai.model.JogoEditModel;
import com.example.dai.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class JogoService {

    private final JogoRepository jogoRepository;

    @Autowired
    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public void adicionarJogo(JogoAddModel jogoAdicionar){

        if(jogoAdicionar.getDataJogo().equals("") || jogoAdicionar.getJornada() <0){
            throw new IllegalStateException("Falta alguma informação ");
        }
        //int jornada, Long idCompeticao, LocalDate dataJogo, String horasJogo, String pavilhao, Long abc, String equipaVisitante, Set<JogoAtleta> atletasNoJogo, Set<JogoJogada> jogadasNoJogo
        //Jogo jogoAdd = new Jogo(jogoAdicionar.getJornada(), jogoAdicionar.getIdCompeticao(), jogoAdicionar.getDataJogo(), jogoAdicionar.getHorasJogo(), jogoAdicionar.getIdPavilhao(), jogoAdicionar.getIdEquipa(), jogoAdicionar.getEquipaVisitante(), jogoAdicionar.getAtletasNoJogo(), jogoAdicionar.getJogadasNoJogo());

        Jogo jogoAdd = new Jogo(jogoAdicionar.getJornada(), jogoAdicionar.getIdCompeticao(), jogoAdicionar.getIdPavilhao());
        jogoRepository.save(jogoAdd);
    }

    public List<Jogo> listarJogos() {
        return jogoRepository.findAll();
    }

    public void eliminarJogo(Long idJogo){
        Optional<Jogo> existeJogo = jogoRepository.findById(idJogo);

        if(!existeJogo.isPresent()){
            throw new IllegalStateException("Jogo com o id " + idJogo + " não existe!");
        }

        jogoRepository.deleteById(idJogo);
    }

    public void mudarInformacoesJogo(Long idJogo, JogoEditModel novasInformacoesJogo){
        Optional<Jogo> existeJogo = jogoRepository.findById(idJogo);

        if(!existeJogo.isPresent()){
            throw new IllegalStateException("Jogo com o id " + idJogo + " não existe!");
        }

    }
}

