package dev.felpus.CadastroDePiratas.Missoes;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missaoService;

    public MissoesController(MissoesService missaoService) {
        this.missaoService = missaoService;
    }

    //GET -- Mandar uma requisição para mostrar as missões
    @GetMapping("/listar")
    public List<MissoesModel> listarMissao(){
        return missaoService.listarMissoes();
    }


    //POST -- Mandar uma requisição para criar as missões
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missaoService.criarMissao(missao);
    }

    //Listar por id
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissaoPorId(@PathVariable Long id){
        return missaoService.listarPorId(id);
    }

    //PUT -- Mandar uma requisição para alterar as missões
    @PutMapping("/alterar/{id}")
    public MissoesModel alterarMissao(@PathVariable Long id, @RequestBody MissoesModel atualizarMissao){
        return missaoService.atualizarMissao(id, atualizarMissao);
    }

    //DELETE -- Mandar uma requisição para deletar as missões
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missaoService.deletarMissao(id);
    }
}
