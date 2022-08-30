package com.example.dai.service;

import com.example.dai.data.*;
import com.example.dai.model.*;
import com.example.dai.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class EquipaService {
    private final EquipaRepository equipaRepository;
    private final EquipaAtletaRepository equipaAtletaRepository;
    private final EquipaPavilhaoRepository equipaPavilhaoRepository;
    private final EquipaTreinadorRepository equipaTreinadorRepository;
    private final JogadorRepository jogadorRepository;
    private final GuardaRedesService guardaRedesService;
    private final UtilizadorRepository utilizadorRepository;

    @Autowired
    public EquipaService(EquipaRepository equipaRepository, EquipaAtletaRepository equipaAtletaRepository, EquipaPavilhaoRepository equipaPavilhaoRepository, EquipaTreinadorRepository equipaTreinadorRepository, JogadorRepository jogadorRepository, GuardaRedesService guardaRedesService, UtilizadorRepository utilizadorRepository) {
        this.equipaRepository = equipaRepository;
        this.equipaAtletaRepository = equipaAtletaRepository;
        this.equipaPavilhaoRepository = equipaPavilhaoRepository;
        this.equipaTreinadorRepository = equipaTreinadorRepository;
        this.jogadorRepository = jogadorRepository;
        this.guardaRedesService = guardaRedesService;
        this.utilizadorRepository = utilizadorRepository;
    }

    public EquipaDto adicionarEquipa(EquipaAddModel novaEquipa){
        Equipa equipaAdicionar = new Equipa(novaEquipa.getNomeEquipa(), novaEquipa.getEscalao(), novaEquipa.getGenero());

        equipaAdicionar = equipaRepository.save(equipaAdicionar);

        if(!novaEquipa.getAtletas().isEmpty()){
            for(Long idAtleta : novaEquipa.getAtletas()){
                EquipaAtleta equipaAtleta = new EquipaAtleta(new EquipaAtletaId(equipaAdicionar.getIdEquipa(), idAtleta));
                Equipa equipa = equipaRepository.getById(equipaAdicionar.getIdEquipa());
                equipaAtleta.setEquipa(equipaRepository.getById(equipaAdicionar.getIdEquipa()));
                equipaAtleta.setAtleta(new Atleta(idAtleta, "a"));
                equipaAtletaRepository.save(equipaAtleta);
            }
        }

        if(!novaEquipa.getPavilhoes().isEmpty()){
            for(Long idPavilhao : novaEquipa.getPavilhoes()){
                EquipaPavilhao equipaPavilhao = new EquipaPavilhao(new EquipaPavilhaoId(equipaAdicionar.getIdEquipa(), idPavilhao));
                equipaPavilhao.setEquipa(equipaRepository.getById(equipaAdicionar.getIdEquipa()));
                equipaPavilhao.setPavilhao(new Pavilhao(idPavilhao));
                equipaPavilhaoRepository.save(equipaPavilhao);
            }
        }

        if(!novaEquipa.getTreinadores().isEmpty()){
            for(Long idTreinador : novaEquipa.getTreinadores()){
                EquipaTreinador equipaTreinador = new EquipaTreinador(new EquipaTreinadorId(equipaAdicionar.getIdEquipa(), idTreinador));
                equipaTreinador.setEquipa(equipaRepository.getById(equipaAdicionar.getIdEquipa()));
                equipaTreinador.setTreinador(new Treinador(idTreinador, "a"));
                equipaTreinadorRepository.save(equipaTreinador);
            }
        }

        return new EquipaDto("Equipa adicionada com sucesso!");
    }

    public List<Equipa> listarEquipas(){
        List<Equipa> equipas = equipaRepository.findAll();
        /*List<Equipa> equipas2 = new ArrayList<>();
        int i = 0;

        for(Equipa equipa: equipas) {
            Equipa equipaAdicionar = null;
            if (i != equipas.size()) {
                equipaAdicionar = new Equipa();
                equipaAdicionar.setIdEquipa(equipa.getIdEquipa());
                equipaAdicionar.setAtletasNaEquipa(equipa.getAtletasNaEquipa());
                System.out.println(equipa.getAtletasNaEquipa());
                equipaAdicionar.setEscalao(equipa.getEscalao());
                equipaAdicionar.setTreinadoresNaEquipa(equipa.getTreinadoresNaEquipa());
                equipaAdicionar.setNome(equipa.getNome());
                equipaAdicionar.setGenero(equipa.getGenero());
            }
            i++;
            equipas2.add(equipaAdicionar);
        }*/

        return equipas;
    }

    /*private Atleta getEquipaAtleta(Long idEquipa){
        return equipaAtletaRepository.findByIdEquipa(idEquipa);
    }*/

    public Equipa listarEquipa(Long idCompeticao){
        Optional<Equipa> equipa = equipaRepository.findById(idCompeticao);

        if (!equipa.isPresent()) {
            throw new IllegalStateException("Competição não existe");
        }

        return equipa.get();
    }

    @Transactional
    public void mudarInformacaoEquipa(Long idEquipa, EquipaEditModel equipaNovasInfos) {
        Optional<Equipa> existeEquipa = equipaRepository.findById(idEquipa);

        if(!existeEquipa.isPresent()){
            throw new IllegalStateException("Equipa com o id "+ idEquipa + " não existe!");
        }



        Equipa equipa = existeEquipa.get();

        if(equipaNovasInfos.getNomeEquipa() != null){
            equipa.setNome(equipaNovasInfos.getNomeEquipa());
        }

        if(equipaNovasInfos.getEscalao() != null){
            equipa.setEscalao(equipaNovasInfos.getEscalao());
        }

        if(equipaNovasInfos.getGenero() != null){
            equipa.setGenero(equipaNovasInfos.getGenero());
        }

        //Retirar os que tinha anteriormente
        equipaTreinadorRepository.eliminarTreinadorEquipa(idEquipa);
        equipaAtletaRepository.eliminarAtletaEquipa(idEquipa);
        equipaPavilhaoRepository.eliminarPavilhaoEquipa(idEquipa);

        //Adicionar os novos
        if(!equipaNovasInfos.getAtletas().isEmpty()){
            for(Long idAtleta : equipaNovasInfos.getAtletas()){
                EquipaAtleta equipaAtleta = new EquipaAtleta(new EquipaAtletaId(equipa.getIdEquipa(), idAtleta));
                equipaAtleta.setEquipa(equipaRepository.getById(equipa.getIdEquipa()));
                equipaAtleta.setAtleta(new Atleta(idAtleta, "a"));
                equipaAtletaRepository.save(equipaAtleta);
            }
        }

        if(!equipaNovasInfos.getPavilhoes().isEmpty()){
            for(Long idPavilhao : equipaNovasInfos.getPavilhoes()){
                EquipaPavilhao equipaPavilhao = new EquipaPavilhao(new EquipaPavilhaoId(equipa.getIdEquipa(), idPavilhao));
                equipaPavilhao.setEquipa(equipaRepository.getById(equipa.getIdEquipa()));
                equipaPavilhao.setPavilhao(new Pavilhao(idPavilhao));
                equipaPavilhaoRepository.save(equipaPavilhao);
            }
        }

        if(!equipaNovasInfos.getTreinadores().isEmpty()){
            for(Long idTreinador : equipaNovasInfos.getTreinadores()){
                EquipaTreinador equipaTreinador = new EquipaTreinador(new EquipaTreinadorId(equipa.getIdEquipa(), idTreinador));
                equipaTreinador.setEquipa(equipaRepository.getById(equipa.getIdEquipa()));
                equipaTreinador.setTreinador(new Treinador(idTreinador, "a"));
                equipaTreinadorRepository.save(equipaTreinador);
            }
        }

        equipaRepository.save(equipa);

    }

    @Transactional
    public void eliminarEquipa(Long idEquipa){
        Optional<Equipa> existeEquipa = equipaRepository.findById(idEquipa);

        if(!existeEquipa.isPresent()){
            throw new IllegalStateException("Equipa com o id " + idEquipa + " não existe!");
        }

        equipaTreinadorRepository.eliminarTreinadorEquipa(idEquipa);
        equipaAtletaRepository.eliminarAtletaEquipa(idEquipa);
        equipaPavilhaoRepository.eliminarPavilhaoEquipa(idEquipa);

        equipaRepository.deleteById(idEquipa);
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

            if(!existeEquipa.isPresent()){//Se a equipa não existir na BD
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


