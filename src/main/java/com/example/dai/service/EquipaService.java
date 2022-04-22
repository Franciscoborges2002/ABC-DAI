package com.example.dai.service;

import com.example.dai.data.*;
import com.example.dai.model.AtletaAddEquipaModel;
import com.example.dai.model.EquipaAddModel;
import com.example.dai.model.EquipaDto;
import com.example.dai.model.EquipaRequestModel;
import com.example.dai.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EquipaService {
    private final EquipaRepository equipaRepository;
    private final EquipaAtletaRepository equipaAtletaRepository;
    private final EquipaPavilhaoRepository equipaPavilhaoRepository;
    private final EquipaTreinadorRepository equipaTreinadorRepository;
    private final UtilizadorRepository utilizadorRepository;

    @Autowired
    public EquipaService(EquipaRepository equipaRepository, EquipaAtletaRepository equipaAtletaRepository, EquipaPavilhaoRepository equipaPavilhaoRepository, EquipaTreinadorRepository equipaTreinadorRepository, UtilizadorRepository utilizadorRepository) {
        this.equipaRepository = equipaRepository;
        this.equipaAtletaRepository = equipaAtletaRepository;
        this.equipaPavilhaoRepository = equipaPavilhaoRepository;
        this.equipaTreinadorRepository = equipaTreinadorRepository;
        this.utilizadorRepository = utilizadorRepository;
    }

    public EquipaDto adicionarEquipa(EquipaAddModel novaEquipa){
        Equipa equipaAdicionar = new Equipa(novaEquipa.getNomeEquipa(), novaEquipa.getMorada(), novaEquipa.getEmail(), novaEquipa.getWebsite(), novaEquipa.getEscalao(), novaEquipa.getGenero());

        equipaAdicionar = equipaRepository.save(equipaAdicionar);

        if(!novaEquipa.getAtletas().isEmpty()){
            for(Long idAtleta : novaEquipa.getAtletas()){
                EquipaAtleta equipaAtleta = new EquipaAtleta(equipaAdicionar.getIdEquipa(), idAtleta);
                equipaAtletaRepository.save(equipaAtleta);
            }
        }

        if(!novaEquipa.getPavilhoes().isEmpty()){
            for(Long idPavilhao : novaEquipa.getPavilhoes()){
                EquipaPavilhao equipaPavilhao = new EquipaPavilhao(equipaAdicionar.getIdEquipa(), idPavilhao);
                equipaPavilhaoRepository.save(equipaPavilhao);
            }
        }

        if(!novaEquipa.getTreinadores().isEmpty()){
            for(Long idTreinador : novaEquipa.getTreinadores()){
                EquipaTreinador equipaTreinador = new EquipaTreinador(new EquipaTreinadorId(equipaAdicionar.getIdEquipa(), idTreinador));
                equipaTreinador.setEquipa(equipaRepository.getById(equipaAdicionar.getIdEquipa()));
                equipaTreinador.setTreinador(new Treinador(2L,"c"));
                equipaTreinadorRepository.save(equipaTreinador);
            }
        }

        return new EquipaDto("Equipa adicionada com sucesso!");
    }

    public List<EquipaTreinador> listarEquipas(){return equipaTreinadorRepository.findAll();}


    public void mudarInformacaoEquipa(Long idEquipa, String nomeEquipa, String morada, String email, String website, String recinto, Escalao escalao, Genero genero) {
        Optional<Equipa> existeEquipa = equipaRepository.findById(idEquipa);

        if(existeEquipa.isEmpty()){
            throw new IllegalStateException("Utilizador com o id "+ idEquipa + " não existe!");
        }

        Equipa equipa = existeEquipa.get();

        if(nomeEquipa != null){
            equipa.setNome(nomeEquipa);
        }

        if(morada != null){
            equipa.setMorada(morada);
        }

        if(email != null){
            equipa.setEmail(email);
        }

        if(email != null){
            equipa.setEmail(email);
        }

        if(website != null){
            equipa.setWebsite(website);
        }

        if(escalao != null){
            equipa.setEscalao(escalao);
        }

        if(genero != null){
            equipa.setGenero(genero);
        }

        equipaRepository.save(equipa);

    }

        public void eliminarEquipa(Long idEquipa){
            Optional<Equipa> existeEquipa = equipaRepository.findById(idEquipa);

            if(existeEquipa.isEmpty()){
                throw new IllegalStateException("Equipa com o id " + idEquipa + " não existe!");
            }

            equipaRepository.deleteById(idEquipa);
        }

        public Equipa listarEquipa(Long idCompeticao){
            Optional<Equipa> equipa = equipaRepository.findById(idCompeticao);

            if (equipa.isEmpty()) {
                throw new IllegalStateException("Competição não existe");
            }

            return equipa.get();
        }



        public boolean adicionarAtleta(EquipaRequestModel equipa, AtletaAddEquipaModel atleta){
            /*Map<Long, Atleta> atletas= equipa.getAtletasNaEquipa();

            if(!existeAtletaNaEquipa(equipa, atleta)){
                atletas.put(atleta.getIdUtilizador(), atleta);
                equipaRepository.save(equipa);//Dar save no repo
                return true;
            }else{
                throw new IllegalStateException("Jogador já adicionado à equipa");
            }*/

            Optional<Equipa> existeEquipa = equipaRepository.findById(equipa.getIdEquipa());

            if(existeEquipa.isEmpty()){//Se a equipa não existir na BD
                throw new IllegalStateException("Equipa não existe");
            }

            Equipa equipaObjeto = equipaRepository.getById(equipa.getIdEquipa());

            /*Map<Long, Atleta> atletas= equipaObjeto.getAtletasNaEquipa();

            if(!existeAtletaNaEquipa(equipaObjeto, (Atleta) utilizadorRepository.getById(atleta.getIdUtilizador()))){
                atletas.put(atleta.getIdUtilizador(), (Atleta) utilizadorRepository.getById(atleta.getIdUtilizador()));
                equipaRepository.save(equipaObjeto);//Dar save no repo
                return true;
            }else{
                throw new IllegalStateException("Jogador já adicionado à equipa");
            }*/

            return true;
        }
/*
        public boolean existeAtletaNaEquipa(Equipa equipa, Atleta atleta){
            Map<Long, Atleta> atletas= equipa.getAtletasNaEquipa();
            if(atletas.containsKey(atleta.getIdUtilizador())){
                return true;
            }
            return false;
        }*/

    }


