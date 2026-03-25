package dev.felpus.CadastroDePiratas.Missoes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MissoesModel>> listarMissao(){
        List<MissoesModel> missoes = missaoService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }


    //POST -- Mandar uma requisição para criar as missões
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesModel missao){
        MissoesModel novaMissao = missaoService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("A missão: " + novaMissao.getNomeMissao() + ". Foi criada com sucesso!");
    }

    //Listar por id
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id){
        MissoesModel missao = missaoService.listarPorId(id);
        if(missao != null){
            return ResponseEntity.ok(missao);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão de ID: " + id + ". Não foi encontrada!");
        }
    }

    //PUT -- Mandar uma requisição para alterar as missões
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesModel atualizarMissao){
        if(missaoService.listarPorId(id) != null){
            MissoesModel alterarMissao = missaoService.atualizarMissao(id, atualizarMissao);
            return ResponseEntity.ok(alterarMissao);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão de ID: \" + id + \". Não foi encontrada!");
        }
    }

    //DELETE -- Mandar uma requisição para deletar as missões
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarMissao(@PathVariable Long id){
        if(missaoService.listarPorId(id) != null){
            missaoService.deletarMissao(id);
            return ResponseEntity.ok("A missão de ID " + id + " foi deletada com sucesso!");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão de ID: " + id + " não foi encontrada");
        }
    }
}
