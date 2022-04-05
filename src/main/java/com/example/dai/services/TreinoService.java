package com.example.dai.services;

import com.example.dai.data.classes.Equipa;
import com.example.dai.data.classes.Treino;
import com.example.dai.model.TreinoAddModel;
import com.example.dai.repositories.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TreinoService {
    private final TreinoRepository treinoRepository;

    @Autowired
    public TreinoService(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }

    public String adicionarTreino(TreinoAddModel novoTreino){

        //Verificar se toda a informação foi preenchida
        if(novoTreino.getNomeTreino().equals("") || novoTreino.getEquipaTreinar().equals("") || novoTreino.getHorarioTreino().equals("")|| novoTreino.getPavilhao().equals("")) {
            throw new IllegalArgumentException("Not all information provided");
        }
        //Se o nome do treino for menor do que 3 caracteres
        if(novoTreino.getNomeTreino().length() < 3){
            throw new IllegalArgumentException("Nome do treino tem menos do que 3 caracteres.");
        }

        Optional<Treino> existeNomeTreino= treinoRepository.encontrarTreinoPeloNome(novoTreino.getNomeTreino());


        if(existeNomeTreino.isPresent()){
            throw new IllegalStateException("Treino com o mesmo nome já existe.");
        }
        Treino treinoAdicionar = new Treino(novoTreino.getNomeTreino(), novoTreino.getEquipaTreinar(), novoTreino.getHorarioTreino(), novoTreino.getPavilhao());

        treinoRepository.save(treinoAdicionar);

        return "Treino adicionado com sucesso!";
    }

    public List<Treino> listarTreinos(){return treinoRepository.findAll();}

    @Transactional
    public void mudarInformacaoTreino(Long idTreino, String nomeTreino, Equipa equipa, LocalDate horario, String localizacao) {
        Optional<Treino> existeTreino = Optional.of(treinoRepository.getById(idTreino));
        if(existeTreino.isEmpty()){
            throw new IllegalStateException("O treino com o id "+ idTreino + " não existe!");
        }
        Treino treino = treinoRepository.getById(idTreino);

        if(nomeTreino != null &&
                nomeTreino.length() > 0 &&
                !Objects.equals(treino.getNomeTreino(), nomeTreino)){
            treino.setNomeTreino(nomeTreino);
        }
        if(equipa != null &&
                !Objects.equals(treino.getEquipa(), equipa)){
            treino.setEquipa(equipa);
        }
        if(horario != null &&
                horario.toString().length() > 0 &&
                !Objects.equals(treino.getHorario(), horario)){
            treino.setHorario(horario);
        }
        if(localizacao != null &&
                localizacao.toString().length() > 0 &&
                !Objects.equals(treino.getLocalizacao(), localizacao)){
            treino.setLocalizacao(localizacao);
        }
    }

    public void eliminarTreino(Long idTreino){
        Optional<Treino> existeTreino = treinoRepository.findById(idTreino);
        if(existeTreino.isEmpty()){
            throw new IllegalStateException("Treino com o id " + idTreino + " não existe!");
        }
        treinoRepository.deleteById(idTreino);
    }

}
