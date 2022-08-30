package com.example.dai.service;

import com.example.dai.data.Competicao;
import com.example.dai.data.Escalao;
import com.example.dai.data.Genero;
import com.example.dai.model.CompeticaoAddModel;
import com.example.dai.model.CompeticaoDto;
import com.example.dai.model.CompeticaoEditModel;
import com.example.dai.repository.CompeticaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompeticaoService {
    private final CompeticaoRepository competicaoRepository;

    @Autowired
    public CompeticaoService(CompeticaoRepository competicaoRepository){
        this.competicaoRepository = competicaoRepository;
    }

    public List<Competicao> listarCompeticoes(){
        return competicaoRepository.findAll();
    }

    public Competicao listarCompeticao(Long idCompeticao){
        Optional<Competicao> competicao= competicaoRepository.findById(idCompeticao);

        if(!competicao.isPresent()){
            throw new IllegalStateException("Competição não existe");
        }

        return competicaoRepository.encontrarCompeticaoPeloId(idCompeticao);
    }

    public CompeticaoDto adicionarCompeticao(CompeticaoAddModel novaCompeticao){
        String nomeCompeticao = novaCompeticao.getNomeCompeticao();
        Escalao escalao = novaCompeticao.getEscalao();
        Genero genero = novaCompeticao.getGenero();
        int numeroJornadas = novaCompeticao.getNumeroJornadas();
        String epoca = novaCompeticao.getEpoca();
        String urlFederacao = novaCompeticao.getUrlFederacao();

        if(nomeCompeticao.equals("") || escalao.equals("") || genero.equals("") || numeroJornadas <= 0 || epoca.equals("")){
            throw new IllegalArgumentException("Falta algum dado");
        }

        //Verificar se já tem o nome da competicao e a jornada
        Optional<Competicao> existeNomeCompeticao = competicaoRepository.encontrarCompeticaoPeloNome(nomeCompeticao);

        //Se já existe o nome
        if(existeNomeCompeticao.isPresent()){//Existe o nome da competicao na BD
            Competicao competicao = competicaoRepository.encontrarCompeticaoPeloNome2(nomeCompeticao);

            if(competicao.getEpoca().equals(epoca)){ //verificar se a epoca é igual à existente na bd
                if(competicao.getEscalao().equals(escalao)){
                    if(competicao.getGenero().equals(genero)){
                        throw new IllegalStateException("Essa competição já está registrada na BD");
                    }
                }
            }
        }

        Competicao competicaoAdicionar = new Competicao(nomeCompeticao, epoca, escalao, genero, numeroJornadas, urlFederacao);
        competicaoRepository.save(competicaoAdicionar);

        return new CompeticaoDto("Competicao Criada Com sucesso");
    }

    //Só os diretoressc é que tem permissão para acessar
    public void removerCompeticao(Long idCompeticao){
        Optional<Competicao> existeCompeticao = competicaoRepository.findById(idCompeticao);

        if(!existeCompeticao.isPresent()){
            throw new IllegalStateException("Competição com o id " + idCompeticao + " não existe!");
        }

        competicaoRepository.deleteById(idCompeticao);
    }

    public void editarCompeticao(Long idCompeticao, CompeticaoEditModel competicaoEditModel){
        Optional<Competicao> existeCompeticao = Optional.of(competicaoRepository.getById(idCompeticao));

        if(!existeCompeticao.isPresent()){//Se a competição não existir
            throw new IllegalStateException("Competção não existe");
        }

        //Ver o que está a dar erro
        //Competicao competicao = competicaoRepository.getById(idCompeticao);
        Competicao competicao = existeCompeticao.get();

        if(competicaoEditModel.getUrlFederacao() != null &&
                competicaoEditModel.getUrlFederacao().length() > 0){
            competicao.setUrlFederacao(competicaoEditModel.getUrlFederacao());
        }

        if(competicaoEditModel.getEpoca() != null &&
                competicaoEditModel.getEpoca().length() > 0){
            competicao.setEpoca(competicaoEditModel.getEpoca());
        }

        if(competicaoEditModel.getNomeCompeticao() != null &&
                competicaoEditModel.getNomeCompeticao().length() > 0){
            competicao.setNome(competicaoEditModel.getNomeCompeticao());
        }

        if(competicaoEditModel.getEscalao() != null){
            competicao.setEscalao(competicaoEditModel.getEscalao());
        }

        if(competicaoEditModel.getGenero() != null){
            competicao.setGenero(competicaoEditModel.getGenero());
        }

        if(competicaoEditModel.getNumeroJornadas() > 0) {
            competicao.setNumJornadas(competicaoEditModel.getNumeroJornadas());
        }

        competicaoRepository.competicaoMudarInfo(idCompeticao, competicaoEditModel.getUrlFederacao(), competicaoEditModel.getNomeCompeticao(), competicaoEditModel.getEscalao(), competicaoEditModel.getGenero(), competicaoEditModel.getNumeroJornadas(), competicaoEditModel.getEpoca());

    }
}
