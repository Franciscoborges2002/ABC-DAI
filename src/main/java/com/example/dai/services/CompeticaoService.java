package com.example.dai.services;

import com.example.dai.data.classes.Competicao;
import com.example.dai.data.enums.Escalao;
import com.example.dai.data.enums.Genero;
import com.example.dai.model.CompeticaoAddModel;
import com.example.dai.repositories.CompeticaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CompeticaoService {
    private final CompeticaoRepository competicaoRepository;

    @Autowired
    public CompeticaoService(CompeticaoRepository competicaoRepository){
        this.competicaoRepository = competicaoRepository;
    }

    //Não está a aparecer
    public List<Competicao> listarCompeticoes(){
        return competicaoRepository.findAll();
    }

    public String listarCompeticao(Long idCompeticao){
        Optional<Competicao> competicao= competicaoRepository.findById(idCompeticao);

        if(competicao.isEmpty()){
            throw new IllegalStateException("Competição não existe");
        }

        return competicao.getClass().toString();
    }

    public String adicionarCompeticao(CompeticaoAddModel novaCompeticao){
        String nomeCompeticao = novaCompeticao.getNomeCompeticao();
        Escalao escalao = novaCompeticao.getEscalao();
        Genero genero = novaCompeticao.getGenero();
        int numeroJornadas = novaCompeticao.getNumeroJornadas();
        String epoca = novaCompeticao.getEpoca();

        if(nomeCompeticao.equals("") || escalao.equals("") || genero.equals("") || numeroJornadas <= 0 || epoca.equals("")){
            throw new IllegalArgumentException("Falta algum dado");
        }

        //Verificar se já tem o nome da competicao e a jornada
        Optional<Competicao> existeNomeCompeticao = competicaoRepository.encontrarCompeticaoPeloNome(nomeCompeticao);

        //Se já existe o nome
        if(existeNomeCompeticao.isPresent()){//Existe o nome da competicao na BD
            Class<? extends Optional> competicaoExistente = existeNomeCompeticao.getClass();

            //verificar se a epoca é igual à existente na bd
        }

        Competicao competicaoAdicionar = new Competicao(nomeCompeticao, epoca, escalao, genero, numeroJornadas);

        competicaoRepository.save(competicaoAdicionar);

        return "competicao registrada com sucesso";
    }

    //Só os diretores é que tem permissão para acessar
    public String removerCompeticao(Long idCompeticao){
        Optional<Competicao> existeCompeticao = competicaoRepository.findById(idCompeticao);

        if(existeCompeticao.isEmpty()){
            throw new IllegalStateException("Competição com o id " + idCompeticao + " não existe!");
        }

        competicaoRepository.deleteById(idCompeticao);
        return "Competição removida com sucesso!";
    }

    public String editarCompeticao(Long idCompeticao, String urlFederacao, String nomeCompeticao, String epoca, Escalao escalao, Genero genero, int numJornadas){
        Optional<Competicao> existeCompeticao = Optional.of(competicaoRepository.getById(idCompeticao));

        if(existeCompeticao.isEmpty()){//Se a competição não existir
            throw new IllegalStateException("Competção não existe");
        }

        //Ver o que está a dar erro
        Competicao competicao = competicaoRepository.getById(idCompeticao);

        if(urlFederacao != null &&
                urlFederacao.length() > 0 &&
                !Objects.equals(competicao.getUrlFederacao(), urlFederacao)){
            competicao.set
        }

        return "Competição alterada com sucesso!";
    }
}
