package dev.felpus.CadastroDePiratas.Missoes;

import dev.felpus.CadastroDePiratas.Ninjas.NinjaMapper;
import dev.felpus.CadastroDePiratas.Ninjas.NinjaModel;
import jakarta.validation.constraints.Null;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/missoes")
public class MissoesService {
    private final MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Criar
    public MissoesDTO criarMissao(MissoesDTO missoesDTO){
        MissoesModel missao = missoesMapper.map(missoesDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }
    //Listar
    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }
    //listar por id
    public MissoesDTO listarPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);
    }
    //Deletar
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }

    //alterar
    public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if(missaoExistente.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missoesDTO);
            return missoesMapper.map(missaoAtualizada);
        }
        return null;
    }
}
