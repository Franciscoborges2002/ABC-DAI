package com.example.dai.service;

import com.example.dai.data.Pavilhao;
import com.example.dai.model.PavilhaoAddModel;
import com.example.dai.model.PavilhaoDto;
import com.example.dai.repository.PavilhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PavilhaoService {

    private final PavilhaoRepository pavilhaoRepository;

    @Autowired
    public PavilhaoService(PavilhaoRepository pavilhaoRepository) {
        this.pavilhaoRepository = pavilhaoRepository;
    }


    public List<Pavilhao> listarPavilhoes(){
        return pavilhaoRepository.findAll();
    }

    public Pavilhao listarPavilhao(Long idPavilhao){
        Optional<Pavilhao> pavilhao= pavilhaoRepository.findById(idPavilhao);

        if(pavilhao.isEmpty()){
            throw new IllegalStateException("Pavilhão não existe");
        }

        return pavilhaoRepository.encontrarPavilhaoPeloId(idPavilhao);
    }

    public PavilhaoDto adicionarPavilhao(PavilhaoAddModel novoPavilhao){
         String nomePavilhao = novoPavilhao.getNomePavilhao();
         String localizacao = novoPavilhao.getLocalizacao();
         int numeroDeTreinosPorHora = novoPavilhao.getNumeroDeTreinosPorHora();

        if(nomePavilhao.equals("") || localizacao.equals("") || numeroDeTreinosPorHora <=0 ){
            throw new IllegalArgumentException("Dados em falta ou inválidos");
        }

        //Verificar se já tem o nome do pavilhao e a localizacao
        Optional<Pavilhao> existeNomePavilhao = pavilhaoRepository.encontrarPavilhaoPeloNome(nomePavilhao);

        //Se já existe o nome
        if(existeNomePavilhao.isPresent()){//Existe o nome do pavilhao na BD

            Pavilhao pavilhao = pavilhaoRepository.encontrarPavilhaoPeloNome2(nomePavilhao);

            if(pavilhao.getLocalizacao().equals(localizacao)){ //verificar se a epoca é igual à existente na bd
                if(pavilhao.getNumeroDeTreinosPorHora() == numeroDeTreinosPorHora){
                        throw new IllegalStateException("Esse pavilhão já está registado na BD");

                }
            }
        }

        Pavilhao pavilhaoAdicionar = new Pavilhao(nomePavilhao, localizacao, numeroDeTreinosPorHora);
        pavilhaoRepository.save(pavilhaoAdicionar);
        return new PavilhaoDto("Pavilhão criado com sucesso!");
    }


    //Só os diretores é que tem permissão para acessar
    public void removerPavilhao(Long idPavilhao){
        Optional<Pavilhao> existePavilhao = pavilhaoRepository.findById(idPavilhao);
        if(existePavilhao.isEmpty()){
            throw new IllegalStateException("Pavilhao com o id " + idPavilhao + " não existe!");
        }
        pavilhaoRepository.deleteById(idPavilhao);
    }


    @Transactional
    public void editarPavilhao(Long idPavilhao,String nomePavilhao, String localizacao, int numeroDeTreinosPorHora){
        Optional<Pavilhao> existePavilhao = Optional.of(pavilhaoRepository.getById(idPavilhao));

        if(existePavilhao.isEmpty()){//Se a competição não existir
            throw new IllegalStateException("Pavilhão não existe");
        }
        //Competicao competicao = competicaoRepository.getById(idCompeticao);
        Pavilhao pavilhao = pavilhaoRepository.getById(idPavilhao);

        if(nomePavilhao != null &&
                nomePavilhao.length() > 0 &&
                !Objects.equals(pavilhao.getNomePavilhao(), nomePavilhao)){
            pavilhao.setNomePavilhao(nomePavilhao);
        }

        if(localizacao != null &&
                localizacao.length() > 0 &&
                !Objects.equals(pavilhao.getLocalizacao(), localizacao)){
            pavilhao.setLocalizacao(localizacao);
        }

        if(numeroDeTreinosPorHora <=0 &&
                !Objects.equals(pavilhao.getNumeroDeTreinosPorHora(), numeroDeTreinosPorHora)){
            pavilhao.setNumeroDeTreinosPorHora(numeroDeTreinosPorHora);
        }
    }


}
