package com.example.dai.service;

import com.example.dai.data.Exercicio;
import com.example.dai.data.CategoriaTreino;
import com.example.dai.model.ExercicioAddModel;
import com.example.dai.model.ExercicioDto;
import com.example.dai.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//import static com.example.dai.services.UtilizadorService.exerciseRepositorie;


@Service
public class ExercicioService {
    private final ExercicioRepository exercicioRepository;

    @Autowired
    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    public List<Exercicio> listarExercicios(){
        return exercicioRepository.findAll();
    }

    public Exercicio listarExercicio(Long idExercicio){
        Optional<Exercicio> exercicio = exercicioRepository.findById(idExercicio);

        if(exercicio.isEmpty()){
            throw new IllegalStateException("Exercicio não existe!");
        }

        return exercicioRepository.encontrarExercicioPeloId(idExercicio);
    }

    public ExercicioDto adicionarExercicio(ExercicioAddModel novoExercicio) {
        String nomeExercicio = novoExercicio.getNomeExercicio();
        String linkImagem = novoExercicio.getLink();
        CategoriaTreino categoria = novoExercicio.getCategoriaExercicio();
        String descricao = novoExercicio.getDescricao();
        String objetivo = novoExercicio.getObjetivo();
        String materialNecessario = novoExercicio.getMaterialNecessario();
        double duracao = novoExercicio.getDuracao();
        int repeticoes = novoExercicio.getRepeticoes();

        if (nomeExercicio.equals("") || linkImagem.startsWith("https://") || linkImagem.startsWith("www") || categoria.equals(null)) {
            throw new IllegalArgumentException("Falta algum dado");
        }

        Optional<Exercicio> existeNomeExercicio = exercicioRepository.encontrarExercicioPeloNome(nomeExercicio);

        if (existeNomeExercicio.isPresent()) {//Existe o nome do Exercicio na BD
            Exercicio exercicio = exercicioRepository.encontrarExercicioPeloNome2(nomeExercicio);
            if (exercicio.getCategoriaExercicio().equals(categoria)) { //verificar se a epoca é igual à existente na bd
                if (exercicio.getLink().equals(linkImagem)) {
                    if (exercicio.getNomeExercicio().equals(nomeExercicio)) {
                        throw new IllegalStateException("Este exercico já está registrado na BD");
                    }
                }
            }
        }

        Exercicio exercicioAdicionar = new Exercicio(nomeExercicio, categoria, descricao, linkImagem, objetivo, materialNecessario, duracao, repeticoes);
        exercicioRepository.save(exercicioAdicionar);
        return new ExercicioDto("Exercicio adicionado com sucesso!");
    }

    @Transactional
    public void editarExercicio(Long idExercicio, String nome, String descricao, String objetivo, String materialNecessario, String link, CategoriaTreino categoria, int repeticoes, double duracao){
        Optional<Exercicio> existeExercicio = exercicioRepository.findById(idExercicio);

        if(existeExercicio.isEmpty()){
            throw new IllegalStateException("Exercicio com o id " + idExercicio + " não existe");
        }

        Exercicio exercicio = exercicioRepository.getById(idExercicio);

        if(nome != null &&
                nome.length() > 0 &&
                !Objects.equals(exercicio.getNomeExercicio(), nome)){
            exercicio.setNomeExercicio(nome);
        }

        if(descricao != null &&
                descricao.length() > 0 &&
                !Objects.equals(exercicio.getDescricao(), descricao)){
            exercicio.setDescricao(descricao);
        }

        if(objetivo != null &&
                objetivo.length() > 0 &&
                !Objects.equals(exercicio.getObjetivo(), objetivo)){
            exercicio.setObjetivo(objetivo);
        }

        if(materialNecessario != null &&
                materialNecessario.length() > 0 &&
                !Objects.equals(exercicio.getMaterialNecessario(), materialNecessario)){
            exercicio.setMaterialNecessario(materialNecessario);
        }

        if(link != null &&
                link.length() > 0 &&
                !Objects.equals(exercicio.getLink(), link)){
            exercicio.setLink(link);
        }

        if(categoria != null &&
                !Objects.equals(exercicio.getCategoriaExercicio(), categoria)){
            exercicio.setCategoriaExercicio(categoria);
        }

        if(repeticoes > 0 &&
                !Objects.equals(exercicio.getRepeticoes(), repeticoes)){
            exercicio.setRepeticoes(repeticoes);
        }

        if(duracao > 0 &&
                !Objects.equals(exercicio.getDuracao(), duracao)){
            exercicio.setDuracao(duracao);
        }

    }


    //Só os treinadores é que tem permissão para acessar
    public void removerExercicio(Long idExercicio){
        Optional<Exercicio> existeExercicio = exercicioRepository.findById(idExercicio);

        if(existeExercicio.isEmpty()){
            throw new IllegalStateException("Exercicio com o id " + idExercicio + " não existe!");
        }

        exercicioRepository.deleteById(idExercicio);
    }
}
