package dev.felpus.CadastroDePiratas.Missoes;

import dev.felpus.CadastroDePiratas.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/missoes")
public class MissoesService {
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Criar
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }
    //Listar
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }
    //listar por id
    public MissoesModel listarPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    }
    //Deletar
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }
    //alterar

    public MissoesModel atualizarMissao(Long id, MissoesModel missaoAtualizada){
        if(missoesRepository.existsById(id)){
            missaoAtualizada.setId(id);
        }
        return null;
    }
}
