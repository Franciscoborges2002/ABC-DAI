package com.example.dai.services;

import com.example.dai.data.enums.Escalao;
import com.example.dai.data.enums.Genero;
import com.example.dai.model.EquipaAddModel;
import com.example.dai.repositories.EquipaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dai.data.classes.Equipa;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EquipaService {
    private final EquipaRepository equipaRepository;

    @Autowired
    public EquipaService(EquipaRepository equipaRepository) {
        this.equipaRepository = equipaRepository;
    }

    public String adicionarEquipa(EquipaAddModel novaEquipa){

        //Verificar se toda a informação foi preenchida
        if(novaEquipa.getNomeEquipa().equals("") || novaEquipa.getEscalao().equals("") || novaEquipa.getGenero().equals("")){
            throw new IllegalArgumentException("Not all information provided");
        }

        //Se o nome da equipa for menor do que 3 caracteres
        if(novaEquipa.getNomeEquipa().length() < 3){
            throw new IllegalArgumentException("Nome da equipa tem menos do que 3 caracteres.");
        }

        Optional<Equipa> existeNomeEquipa = equipaRepository.encontrarEquipaPeloNome(novaEquipa.getNomeEquipa());

        if(existeNomeEquipa.isPresent()){
            throw new IllegalStateException("Equipa com o mesmo nome já existe.");
        }

        Equipa equipaAdicionar = new Equipa(novaEquipa.getNomeEquipa(), novaEquipa.getEscalao(), novaEquipa.getGenero());

        equipaRepository.save(equipaAdicionar);

        return "Equipa adicionada com sucesso!";
    }

    public List<Equipa> listarEquipas(){return equipaRepository.findAll();}

    @Transactional
    public void mudarInformacaoEquipa(Long idEquipa, String nomeEquipa, String morada, String email, String website, String recinto, Escalao escalao, Genero genero) {
        Optional<Equipa> existeEquipa = Optional.of(equipaRepository.getById(idEquipa));

        if(existeEquipa.isEmpty()){
            throw new IllegalStateException("Utilizador com o id "+ idEquipa + " não existe!");
        }

        Equipa equipa = equipaRepository.getById(idEquipa);

        if(nomeEquipa != null &&
                nomeEquipa.length() > 0 &&
                !Objects.equals(equipa.getNome(), nomeEquipa)){
            equipa.setNome(nomeEquipa);
        }

        if(morada != null &&
                morada.length() > 0 &&
                !Objects.equals(equipa.getMorada(), morada)){
            equipa.setMorada(morada);
        }

        if(email != null &&
                email.length() > 0 &&
                !Objects.equals(equipa.getEmail(), email)){
            equipa.setEmail(email);
        }

        if(email != null &&
                email.length() > 0 &&
                !Objects.equals(equipa.getEmail(), email)){
            equipa.setEmail(email);
        }

        if(website != null &&
                website.length() > 0 &&
                !Objects.equals(equipa.getWebsite(), website)){
            equipa.setWebsite(website);
        }

        if(recinto != null &&
                recinto.length() > 0 &&
                !Objects.equals(equipa.getRecinto(), recinto)){
            equipa.setRecinto(recinto);
        }

        if(escalao != null &&
                !Objects.equals(equipa.getEscalao(), escalao)){
            equipa.setEscalao(escalao);
        }

        if(genero != null &&
                !Objects.equals(equipa.getEscalao(), genero)){
            equipa.setGenero(genero);
        }
    }

        public void eliminarEquipa(Long idEquipa){
            Optional<Equipa> existeEquipa = equipaRepository.findById(idEquipa);

            if(existeEquipa.isEmpty()){
                throw new IllegalStateException("Equipa com o id " + idEquipa + " não existe!");
            }

            equipaRepository.deleteById(idEquipa);
        }

    }


