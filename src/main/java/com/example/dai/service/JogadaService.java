package com.example.dai.service;

import com.example.dai.data.Jogada;
import com.example.dai.model.JogadaAddModel;
import com.example.dai.model.JogadaDto;
import com.example.dai.model.JogadaEditModel;
import com.example.dai.repository.JogadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class JogadaService {
    private final JogadaRepository jogadaRepository;

    @Autowired
    public JogadaService(JogadaRepository jogadaRepository) {
        this.jogadaRepository = jogadaRepository;
    }

    public List<Jogada> listarJogadas() {
        return jogadaRepository.findAll();
    }

    public JogadaDto listarJogada(Long idJogada) {
        Optional<Jogada> jogadaExiste = jogadaRepository.findById(idJogada);

        if(jogadaExiste.isPresent()){
            return new JogadaDto(jogadaExiste.get());
        }

        throw new IllegalStateException("Utilizador não existe");
    }

    public JogadaDto jogadaAdicionar(JogadaAddModel jogadaAdicionar) {
        if(jogadaAdicionar.getNomeJogada().equals("") || jogadaAdicionar.getDescricaoJogada().equals("")){
            throw new IllegalStateException("Falta algum dado");
        }

        Optional<Jogada> existeJogada = jogadaRepository.findByNomeJogada(jogadaAdicionar.getNomeJogada());

        if(existeJogada.isPresent()){
            throw new IllegalStateException("Nome da jogada já existe!");
        }

        existeJogada = jogadaRepository.findByDescricaoJogada(jogadaAdicionar.getDescricaoJogada());

        if(existeJogada.isPresent()){
            throw new IllegalStateException("Alguma jogada já tem a mesma descrição!");
        }

        Jogada jogada = new Jogada(jogadaAdicionar.getNomeJogada(), jogadaAdicionar.getDescricaoJogada(), jogadaAdicionar.getTipoJogada());

        jogadaRepository.save(jogada);

        return new JogadaDto(jogada, "Jogada criada com sucesso");
    }

    public void removerJogada(Long idJogada) {
        Optional<Jogada> existeJogada = jogadaRepository.findById(idJogada);

        if(!existeJogada.isPresent()){
            throw new IllegalStateException("Jogada com o id " + idJogada + " não existe!");
        }

        jogadaRepository.deleteById(idJogada);
    }

    @Transactional
    public void mudarInformacaoJogada(Long idJogada, JogadaEditModel jogadaNovasInformacoes){
        Optional<Jogada> existeJogada = Optional.of(jogadaRepository.getById(idJogada));

        if (!existeJogada.isPresent()) {//Se o utilizador não existe
            throw new IllegalStateException("Jogada com o id " + idJogada + " não existe!");
        }

        Jogada jogada = existeJogada.get();

        if(jogada.getNomeJogada() != null){
            jogada.setNomeJogada(jogadaNovasInformacoes.getNomeJogada());
        }

        if(jogada.getDescricaoJogada() != null){
            jogada.setDescricaoJogada(jogadaNovasInformacoes.getDescricaoJogada());
        }

        jogadaRepository.jogadaMudarInformacao(idJogada, jogadaNovasInformacoes.getNomeJogada(), jogadaNovasInformacoes.getDescricaoJogada());
    }
}
