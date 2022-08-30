package com.example.dai.service;

import com.example.dai.data.Pavilhao;
import com.example.dai.model.PavilhaoAddModel;
import com.example.dai.model.PavilhaoDto;
import com.example.dai.model.PavilhaoEditModel;
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

        if(!pavilhao.isPresent()){
            throw new IllegalStateException("Pavilhão não existe");
        }

        return pavilhaoRepository.encontrarPavilhaoPeloId(idPavilhao);
    }

    public PavilhaoDto adicionarPavilhao(PavilhaoAddModel novoPavilhao){
         String nomePavilhao = novoPavilhao.getNomePavilhao();
         String localizacao = novoPavilhao.getLocalizacao();
            Long numeroDeTreinosPorHora = novoPavilhao.getNumeroDeTreinosPorHora();

        if(nomePavilhao.equals("") || localizacao.equals("") || numeroDeTreinosPorHora <=0 ){
            throw new IllegalArgumentException("Dados em falta ou inválidos");
        }

        Optional<Pavilhao> existeNomePavilhao = pavilhaoRepository.encontrarPavilhaoPeloNome(nomePavilhao);

        if(existeNomePavilhao.isPresent()){//Existe o nome do pavilhao na BD

            Pavilhao pavilhao = pavilhaoRepository.encontrarPavilhaoPeloNome2(nomePavilhao);

            if(pavilhao.getLocalizacao().equals(localizacao)){ //verificar se a epoca é igual à existente na bd
                throw new IllegalStateException("Esse pavilhão já está registado na BD");

            }
        }

        Pavilhao pavilhaoAdicionar = new Pavilhao(nomePavilhao, localizacao, numeroDeTreinosPorHora);
        pavilhaoRepository.save(pavilhaoAdicionar);
        return new PavilhaoDto("Pavilhão criado com sucesso!");
    }


    public void removerPavilhao(Long idPavilhao){
        Optional<Pavilhao> existePavilhao = pavilhaoRepository.findById(idPavilhao);
        if(!existePavilhao.isPresent()){
            throw new IllegalStateException("Pavilhao com o id " + idPavilhao + " não existe!");
        }
        pavilhaoRepository.deleteById(idPavilhao);
    }

    @Transactional
    public void editarPavilhao(Long idPavilhao, PavilhaoEditModel pavilhao){
        Optional<Pavilhao> existePavilhao = Optional.of(pavilhaoRepository.getById(idPavilhao));

        if(!existePavilhao.isPresent()){//Se o pavilhao não existir
            throw new IllegalStateException("Pavilhão não existe");
        }

        Pavilhao pavilhaoObjeto = existePavilhao.get();

        if(pavilhao.getNomePavilhao() != null){
            pavilhaoObjeto.setNomePavilhao(pavilhao.getNomePavilhao());
        }

        if(pavilhao.getLocalizacao() != null){
            pavilhaoObjeto.setLocalizacao(pavilhao.getLocalizacao());
        }

        if(pavilhao.getNumeroDeTreinosPorHora() >0){
            pavilhaoObjeto.setNumeroDeTreinosPorHora(Long.valueOf(pavilhao.getNumeroDeTreinosPorHora()));
        }

        pavilhaoRepository.pavilhaoMudarInfo(idPavilhao, pavilhao.getNomePavilhao(), pavilhao.getLocalizacao(), Long.valueOf(pavilhao.getNumeroDeTreinosPorHora()));
    }
}
